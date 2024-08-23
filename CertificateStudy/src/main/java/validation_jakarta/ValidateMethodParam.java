package validation_jakarta;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;

import java.util.Set;

@Validated
public class ValidateMethodParam {
    static Logger log = LoggerFactory.getLogger(ValidateMethodParam.class);
    private final ValidatorUtil validatorUtil;

    public ValidateMethodParam(ValidatorUtil validatorUtil) {
        this.validatorUtil = validatorUtil;

    }

    public static void main(String[] args) {
        System.out.println("main method");
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        // Create an instance of ValidatorUtil
        ValidatorUtil validatorUtil = new ValidatorUtil(validator);

        log.info("calling isValidated method for {}", new EmailValidatorDto("test"));
//        validatorUtil.isValidated(new EmailValidator("email"));
        validateEmail("email");
    }

    static String validateEmail(@Email String email) {
        log.info("calling validateEmail method for {}", email);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        // Create an instance of ValidatorUtil
        ValidatorUtil validatorUtil = new ValidatorUtil(validator);
        validatorUtil.isValidated(email);

        return email;
    }

    public record EmailValidator(@Email @NotNull String email) { }

    public static class EmailValidatorDto {
        @Email
        @NotNull
        private String email;

        public EmailValidatorDto(String email) {
            this.email = email;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public String toString() {
            return "EmailValidatorDto{" +
                    "email='" + email + '\'' +
                    '}';
        }
    }
}
