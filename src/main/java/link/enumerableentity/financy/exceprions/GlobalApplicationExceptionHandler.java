package link.enumerableentity.financy.exceprions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.NoSuchElementException;


@ControllerAdvice
public class GlobalApplicationExceptionHandler {

    private static final String DEFAULT_ERROR_VIEW = "error";
    private final ModelAndView mav = new ModelAndView();

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public ModelAndView handleNoSuchElementException(HttpServletRequest request, Exception exception){

        HttpStatus status = HttpStatus.NOT_FOUND;
        mav.setViewName(DEFAULT_ERROR_VIEW);
        mav.addObject("error", status.getReasonPhrase());
        mav.addObject("status", status.value());
        mav.addObject("message", exception.getMessage());
        mav.addObject("path", request.getRequestURI());
        return mav;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ApplicationException.class)
    public ModelAndView handleApplicationException(HttpServletRequest request, Exception exception){

        HttpStatus status = HttpStatus.BAD_REQUEST;
        mav.setViewName(DEFAULT_ERROR_VIEW);
        mav.addObject("error", status.getReasonPhrase());
        mav.addObject("status", status.value());
        mav.addObject("message", exception.getMessage());
        mav.addObject("path", request.getRequestURI());

        return mav;
    }

}
