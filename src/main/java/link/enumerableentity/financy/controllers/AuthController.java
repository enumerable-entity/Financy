package link.enumerableentity.financy.controllers;

import link.enumerableentity.financy.models.dto.UserRegistrationRequest;
import link.enumerableentity.financy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping(path = "/auth")
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController (UserService userService){
        this.userService=userService;
    }

    @GetMapping("/login")
    String getLoginPage(){
        return "login";
    }

    @GetMapping(path = "/register")
    ModelAndView getRegtistrationPage(ModelAndView modelAndView, UserRegistrationRequest userData){
        modelAndView.addObject("regRequest", new UserRegistrationRequest());
        modelAndView.setViewName("registration");
        return modelAndView;
    }
    @PostMapping(path = "/register")
    String registerNewUser( @Valid @ModelAttribute("regRequest") UserRegistrationRequest regRequest, BindingResult validation, HttpServletRequest request){
        if(validation.hasErrors()){
            return "registration";
        }
        userService.registerUser(regRequest, request);
        return "redirect:/";
    }
}
