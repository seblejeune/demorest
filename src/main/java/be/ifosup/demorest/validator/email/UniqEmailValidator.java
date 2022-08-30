package be.ifosup.demorest.validator.email;

import be.ifosup.demorest.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UniqEmailValidator implements ConstraintValidator<UniqEmail, String> {
    private final UserRepository userRepository;

    @Autowired
    public UniqEmailValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isValid(String email, ConstraintValidatorContext context) {
        return !userRepository.existsByEmailAddress(email);
    }
}
