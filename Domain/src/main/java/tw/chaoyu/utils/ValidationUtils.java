package tw.chaoyu.utils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
public class ValidationUtils {
    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    public static void validate(Object object) {
        Set<ConstraintViolation<Object>> violations = getViolations(object);
        if (!violations.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static Set<ConstraintViolation<Object>> getViolations(Object object) {
        Validator validator = factory.getValidator();
        return validator.validate(object);
    }
}
