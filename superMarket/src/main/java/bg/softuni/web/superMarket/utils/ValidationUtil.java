package bg.softuni.web.superMarket.utils;

import javax.validation.ConstraintViolation;
import java.util.Set;

public interface ValidationUtil {

    <E> Set<ConstraintViolation<E>> isValid(E entity);

    <E> boolean isValidEntity(E entity);
}
