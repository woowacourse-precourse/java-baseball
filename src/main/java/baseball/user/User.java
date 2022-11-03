package baseball.user;

import java.util.List;

public class User {

    private final UserInputValidator userInputValidator;

    public User(UserInputValidator userInputValidator) {
        this.userInputValidator = userInputValidator;
    }

    public List<String> stringConvertToStringList(String inputValue) {
        List<String> inputValueList = List.of(inputValue.split(""));
        userInputValidator.validate(inputValueList);
        return inputValueList;
    }
}
