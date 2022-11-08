package baseball.domain.model;

import baseball.domain.validator.RequestValidator;
import baseball.domain.model.request.UserInputRequest;
import java.util.List;
import java.util.stream.Collectors;

public class UserInput {
    private final List<Integer> numbers;

    public UserInput(UserInputRequest userInputRequest) {
        RequestValidator.inputValidation(userInputRequest);

        this.numbers = userInputRequest.getNumbersRequest()
                .stream()
                .map(Character::getNumericValue)
                .collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
