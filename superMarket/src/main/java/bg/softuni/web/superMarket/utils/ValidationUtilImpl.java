package bg.softuni.web.superMarket.utils;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

@Component
public class ValidationUtilImpl implements ValidationUtil {
    private final Validator validator;

    public ValidationUtilImpl() {
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Override
    public <E> Set<ConstraintViolation<E>> isValid(E entity) {
        return this.validator.validate(entity);
    }

    public <E> boolean isValidEntity(E entity){
        return this.validator.validate(entity).isEmpty();
    }
}
