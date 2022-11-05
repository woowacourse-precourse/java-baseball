package baseball.system;

import baseball.system.exception.ValidatorNotFoundException;
import baseball.system.validation.Validator;

import java.util.Iterator;
import java.util.List;

public class ValidatorHolder {
    private static ThreadLocal<List<Validator>> validatorHolder = new ThreadLocal<>();

    public static void setValidators(List<Validator> validators) {
        validatorHolder.set(validators);
    }

    public static void validate(Object target, Class<?> to) {
        List<Validator> validators = validatorHolder.get();
        Iterator<Validator> iterator = validators.iterator();
        while (iterator.hasNext()) {
            Validator validator = iterator.next();
            if (validator.supports(target, to)) {
                validator.validate(target);
                return;
            }
        }
        throw new ValidatorNotFoundException();
    }

    public static void clearHolder() {
        validatorHolder.remove();
    }
}
