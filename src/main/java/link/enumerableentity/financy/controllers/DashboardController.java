package link.enumerableentity.financy.controllers;

import link.enumerableentity.financy.models.Category;
import link.enumerableentity.financy.models.Transaction;
import link.enumerableentity.financy.models.User;
import link.enumerableentity.financy.models.dto.ChartData;
import link.enumerableentity.financy.models.dto.PredictorData;
import link.enumerableentity.financy.models.dto.StatisticData;
import link.enumerableentity.financy.models.dto.TransactionDto;
import link.enumerableentity.financy.repositories.CategoryRepository;
import link.enumerableentity.financy.repositories.TransactionsRepository;
import link.enumerableentity.financy.repositories.UserRepository;
import link.enumerableentity.financy.services.Predictor;
import link.enumerableentity.financy.services.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;


@Controller
public class DashboardController {

    TransactionsRepository transactionsRepository;

    CategoryRepository categoryRepository;

    StatisticService statisticService;

    UserRepository userRepository;

    Predictor predictor;

    @Autowired
    public DashboardController(TransactionsRepository transactionsRepository, CategoryRepository categoryRepository,UserRepository userRepository, Predictor predictor, StatisticService statisticService) {
        this.transactionsRepository = transactionsRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.predictor = predictor;
        this.statisticService = statisticService;
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(path = "/")
    ModelAndView getMainPage (ModelAndView modelAndView, Principal principal){

        User authUser = userRepository.findByEmail(principal.getName()).get();
        List<Transaction> transactionsList = transactionsRepository.findAllByUser(
                authUser,
                PageRequest.of(0,10, Sort.Direction.DESC, "date"));

        Iterable<Category> categoryList = categoryRepository.findAllByUser(authUser);
        ChartData chartData = statisticService.getChartDataForUser(authUser);
        PredictorData predictorData = predictor.getPredictedDataForUser(authUser);
        StatisticData statisticData = statisticService.getStatisticDataForUser(authUser);

        modelAndView.addObject("transactionsList", transactionsList);
        modelAndView.addObject("categoryList", categoryList);
        modelAndView.addObject("chartData", chartData);
        modelAndView.addObject("predictorData", predictorData);
        modelAndView.addObject("statisticData", statisticData);
        modelAndView.addObject("transactionDto", new TransactionDto());
        modelAndView.setViewName("dashboard");

        return modelAndView;
    }

}


