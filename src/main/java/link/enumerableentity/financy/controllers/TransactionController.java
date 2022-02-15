package link.enumerableentity.financy.controllers;

import link.enumerableentity.financy.enums.Type;
import link.enumerableentity.financy.models.Category;
import link.enumerableentity.financy.models.Transaction;
import link.enumerableentity.financy.models.User;
import link.enumerableentity.financy.models.dto.TransactionDto;
import link.enumerableentity.financy.repositories.CategoryRepository;
import link.enumerableentity.financy.repositories.TransactionsRepository;
import link.enumerableentity.financy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping(path = "/transactions")
public class TransactionController {

    private final TransactionsRepository transactionsRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    @Autowired
    public TransactionController(TransactionsRepository transactionsRepository,
                                 UserRepository userRepository,
                                 CategoryRepository categoryRepository) {
        this.transactionsRepository = transactionsRepository;
        this.userRepository = userRepository;
        this.categoryRepository= categoryRepository;
    }

    @PostMapping(path = "/add")
    String addTransaction (@ModelAttribute @Valid TransactionDto transactionDto,
                           HttpServletRequest httpRequest,
                           Principal principal){

        Transaction newTransaction = new Transaction();
        newTransaction.setTitle(transactionDto.getTitle());
        newTransaction.setAmount(transactionDto.getAmount());
        newTransaction.setDate(transactionDto.getDate());
        newTransaction.setType(transactionDto.getType());
        newTransaction.setCategory(transactionDto.getCategory());
        newTransaction.setUser(userRepository.findByEmail(principal.getName()).get());
        transactionsRepository.save(newTransaction);

        return "redirect:" + httpRequest.getHeader("Referer");
    }

    @GetMapping(path = "/all")
    ModelAndView getAll (ModelAndView modelAndView,
                         Principal principal){

        User authUser = userRepository.findByEmail(principal.getName()).get();
        Iterable<Transaction> transactions = transactionsRepository.findAllByUserOrderByDateDesc(authUser);
        Iterable<Category> categoryList = categoryRepository.findAllByUser(authUser);
        modelAndView.addObject("categoryList", categoryList);
        modelAndView.addObject("transactionsList", transactions);
        modelAndView.setViewName("all_transactions");

        return modelAndView;
    }

    @PostMapping(path = "/edit/{id}")
    String editTransaction (@ModelAttribute @Valid TransactionDto transactionDto,
                            @PathVariable Long id,
                            HttpServletRequest httpRequest,
                            Principal principal){

        Transaction transactionToEdit = transactionsRepository.findById(id).orElseThrow(()-> new NoSuchElementException("There is no transaction with this id"));

        if (transactionToEdit.getUser().getEmail().equals(principal.getName()) ) {
            transactionToEdit.setTitle(transactionDto.getTitle());
            transactionToEdit.setType(transactionDto.getType());
            transactionToEdit.setCategory(transactionDto.getCategory());
            transactionToEdit.setAmount(transactionDto.getAmount());
            transactionToEdit.setDate(transactionDto.getDate());
            transactionsRepository.save(transactionToEdit);
        }
        else throw new AccessDeniedException("Access denied for editing this entity");

        return "redirect:" + httpRequest.getHeader("Referer");
    }

    @GetMapping(path = "/delete/{transactionId}")
    String deleteTransaction (@PathVariable Long transactionId,
                              HttpServletRequest httpRequest){

        transactionsRepository.deleteById(transactionId);

        return "redirect:" + httpRequest.getHeader("Referer");
    }

    @GetMapping(path = "/incoming")
    ModelAndView getAllIncoming (ModelAndView modelAndView,
                                 Principal principal){

        User authUser = userRepository.findByEmail(principal.getName()).get();
        Iterable<Transaction> transactions = transactionsRepository.findAllByTypeAndUser(Type.INCOMING,authUser);
        Iterable<Category> categoryList = categoryRepository.findAllByUser(authUser);
        modelAndView.addObject("categoryList", categoryList);
        modelAndView.addObject("transactionsList", transactions);
        modelAndView.setViewName("incoming_tr");

        return modelAndView;
    }

    @GetMapping(path = "/outgoing")
    ModelAndView getAllOutgoing (ModelAndView modelAndView,
                                 Principal principal){

        User authUser = userRepository.findByEmail(principal.getName()).get();
        Iterable<Transaction> transactions = transactionsRepository.findAllByTypeAndUser(Type.OUTGOING,authUser);
        Iterable<Category> categoryList = categoryRepository.findAllByUser(authUser);
        modelAndView.addObject("categoryList", categoryList);
        modelAndView.addObject("transactionsList", transactions);
        modelAndView.setViewName("outgoing_tr");

        return modelAndView;
    }

    @GetMapping(path = "/search")
    ModelAndView searchByTitle (ModelAndView modelAndView, @RequestParam String title, Principal principal){

        User authUser = userRepository.findByEmail(principal.getName()).get();
        List<Transaction> foundedTransactions = transactionsRepository.findAllByTitleContainingIgnoreCaseAndUser(title, authUser);
        Iterable<Category> categoryList = categoryRepository.findAll();
        modelAndView.addObject("categoryList", categoryList);
        modelAndView.addObject("transactionsList", foundedTransactions);
        modelAndView.setViewName("search_results");

        return modelAndView;
    }

}