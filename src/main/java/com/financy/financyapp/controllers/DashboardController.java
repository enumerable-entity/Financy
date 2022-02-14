package com.financy.financyapp.controllers;

import com.financy.financyapp.models.Category;
import com.financy.financyapp.models.Transaction;
import com.financy.financyapp.models.User;
import com.financy.financyapp.models.dto.ChartData;
import com.financy.financyapp.models.dto.PredictorData;
import com.financy.financyapp.models.dto.StatisticData;
import com.financy.financyapp.repositories.CategoryRepository;
import com.financy.financyapp.repositories.TransactionsRepository;
import com.financy.financyapp.repositories.UserRepository;
import com.financy.financyapp.services.Predictor;
import com.financy.financyapp.services.StatisticService;
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
        modelAndView.setViewName("dashboard");

        return modelAndView;
    }

}


