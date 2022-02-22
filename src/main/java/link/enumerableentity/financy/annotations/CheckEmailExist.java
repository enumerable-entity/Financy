package link.enumerableentity.financy.annotations;

import link.enumerableentity.financy.validation.EmailExistingValidator;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailExistingValidator.class)
@Documented
public @interface CheckEmailExist {
    String message() default "Email already exist";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
