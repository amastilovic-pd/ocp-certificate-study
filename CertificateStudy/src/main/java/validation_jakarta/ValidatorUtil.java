package validation_jakarta;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ValidatorUtil {

    Logger log = org.slf4j.LoggerFactory.getLogger(ValidatorUtil.class);

    private final Validator validator;

    public ValidatorUtil(Validator validator) {
        this.validator = validator;
    }


    public <T> void isValidated(T e) {
        log.info("calling isValidated method for {}", e);

        Set<ConstraintViolation<T>> violations = validator.validate(e);
        if(!violations.isEmpty()) {
            log.debug("throwing constraint violation exception for {}", violations);
            throw new ConstraintViolationException(violations);
        }
    }
}
