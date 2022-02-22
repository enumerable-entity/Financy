package link.enumerableentity.financy.validation;

import link.enumerableentity.financy.annotations.CheckEmailExist;
import link.enumerableentity.financy.services.UserService;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class EmailExistingValidator implements ConstraintValidator<CheckEmailExist, String> {

    private final UserService userService;


    public EmailExistingValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(CheckEmailExist constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return !userService.checkUserExist(email);
    }
}
