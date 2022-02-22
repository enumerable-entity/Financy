package link.enumerableentity.financy.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


public class CustomErrorController{

    private ModelAndView renderErrorPage(ModelAndView modelAndView, HttpServletRequest request) {

        HttpStatus status = getStatus(request);

        modelAndView.addObject("errorReason", status.getReasonPhrase());
        modelAndView.addObject("statusCode", status.value());
        modelAndView.setStatus(status);
        modelAndView.setViewName("error");

        return modelAndView;
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        } else {
            try {
                return HttpStatus.valueOf(statusCode);
            } catch (Exception var4) {
                return HttpStatus.INTERNAL_SERVER_ERROR;
            }
        }
    }

}
