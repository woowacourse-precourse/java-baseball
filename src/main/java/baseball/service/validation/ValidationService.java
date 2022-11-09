package baseball.service.validation;

import java.util.List;

public interface ValidationService {

    void validateRange(List<Integer> list);

    void validateNumberLength(int size, List<Integer> list);

    void validateDuplicate(List<Integer> list, int size);

    void validateIsNumber(String input);
}
