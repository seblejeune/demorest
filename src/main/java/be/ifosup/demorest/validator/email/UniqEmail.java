package be.ifosup.demorest.validator.email;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqEmailValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqEmail {
    String message() default "Emailaddress already exists";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
