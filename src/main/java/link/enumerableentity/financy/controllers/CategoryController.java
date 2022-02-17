package link.enumerableentity.financy.controllers;

import link.enumerableentity.financy.models.Category;
import link.enumerableentity.financy.models.User;
import link.enumerableentity.financy.models.dto.CategoryDto;
import link.enumerableentity.financy.models.dto.TransactionDto;
import link.enumerableentity.financy.repositories.CategoryRepository;
import link.enumerableentity.financy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.NoSuchElementException;

@Controller
@RequestMapping(path = "/categories")
public class CategoryController {

    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @PostMapping(path = "/add")
    String addCategory (@Valid @ModelAttribute("categoryDto") CategoryDto categoryDto,
                                     BindingResult validation,
                                     Principal principal,
                                     HttpServletRequest httpServletRequest){

        if(validation.hasErrors()){
            return "categories";
        }

        Category newCategory = new Category();
        newCategory.setTitle(categoryDto.getTitle().toUpperCase());
        newCategory.setType(categoryDto.getType());
        newCategory.setUser(userRepository.findByEmail(principal.getName()).get());
        categoryRepository.saveAndFlush(newCategory);

        return "redirect:/categories/all";
    }

    @GetMapping(path = "/all")
    private ModelAndView getAllForUser (ModelAndView modelAndView, Principal principal){

        User user = userRepository.findByEmail(principal.getName()).get();
        Iterable<Category> categoriesList = categoryRepository.findAllByUser(user);
        modelAndView.addObject("categoryList", categoriesList);
        modelAndView.addObject("categoryDto", new CategoryDto());
        modelAndView.addObject("transactionDto", new TransactionDto());
        modelAndView.setViewName("categories");
        return modelAndView;
    }

    @PostMapping(path = "/edit/{categoryId}")
    private String editCategory (@Valid @ModelAttribute("categoryDto") CategoryDto categoryDto,
                                 BindingResult validation,
                                 @PathVariable Long categoryId,
                                 HttpServletRequest httpRequest,
                                 Principal principal){
        if(validation.hasErrors()){
            return "categories";
        }

        Category categoryToEdit = categoryRepository.findById(categoryId).orElseThrow(NoSuchElementException::new);
        if (categoryToEdit.getUser().getEmail().equals(principal.getName()) ) {
            categoryToEdit.setTitle(categoryDto.getTitle().toUpperCase());
            categoryToEdit.setType(categoryDto.getType());
            categoryRepository.save(categoryToEdit);
        }
        else throw new AccessDeniedException("Access denied for editing this entity");

        return "redirect:" + httpRequest.getHeader("Referer");
    }

    @GetMapping(path = "/delete/{categoryId}")
    private String deleteCategory (@PathVariable Long categoryId, HttpServletRequest httpRequest, Principal principal){
        Category catToDelete = categoryRepository.findById(categoryId).orElseThrow(NoSuchElementException::new);
        if (catToDelete.getUser().getEmail().equals(principal.getName()) ) {
            categoryRepository.delete(catToDelete);
        }
        else throw new AccessDeniedException("Access denied for deleting this entity");

        return "redirect:" + httpRequest.getHeader("Referer");
    }

}
