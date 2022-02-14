package com.financy.financyapp.controllers;

import com.financy.financyapp.models.Category;
import com.financy.financyapp.models.User;
import com.financy.financyapp.repositories.CategoryRepository;
import com.financy.financyapp.repositories.UserRepository;
import com.financy.financyapp.services.Predictor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class DashboardController {
    private final TransactionRepository transactionRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final Predictor predictor;

    public DashboardController(TransactionRepository transactionRepository, CategoryRepository categoryRepository, UserRepository userRepository, Predictor predictor) {
        this.transactionRepository = transactionRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.predictor = predictor;
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/")
    private ModelAndView getDashboard (ModelAndView mav, Principal principal){

        User authUser = userRepository.findByEmail(principal.getName()).get();
        List<Transaction> transactionsList = transactionsRepository.getLast10TransactionForUser(authUser);
        Iterable<Category> categoryList = categoryRepository.findAllByUser(authUser);
        ChartData chartData = TransactionService.prepareChartDataForUser(authUser);
        PredictorData predictorData = predictor.getPredictedDataForUser(authUser);
        StatisticData statisticData = TransactionService.getStatisticForUser(authUser);
        mav.addObject("transactionsList", transactions);
        mav.addObject("categoryList", categoryList);
        mav.addObject("chartData", chartData);
        mav.addObject("predictorData", predictorData);
        mav.addObject("statisticData", statisticData);
        mav.setViewName("dashboard");
        
        return mav;
    }
}
