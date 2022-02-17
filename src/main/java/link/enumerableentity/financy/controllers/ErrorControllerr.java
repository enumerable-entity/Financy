package link.enumerableentity.financy.controllers;

import link.enumerableentity.financy.models.dto.TransactionDto;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping (value ="/error")
public class ErrorControllerr implements ErrorController {

    @GetMapping
    public ModelAndView renderErrorPage (ModelAndView modelAndView){


        modelAndView.addObject("transactionDto", new TransactionDto());
        modelAndView.setViewName("error");


        return modelAndView;
    }


}
