package baseball.user;

import baseball.validator.UserInputValueValidator;

import java.util.List;

public class User {

    public List<String> stringConvertToStringList(String inputValue) {
        List<String> inputValueList = List.of(inputValue.split(""));
        UserInputValueValidator.getInstance().validate(inputValueList);
        return inputValueList;
    }
}
