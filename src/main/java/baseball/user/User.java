package baseball.user;

import baseball.validator.UserInputValidator;

import java.util.List;

public class User {

    public List<String> stringConvertToStringList(String inputValue) {
        List<String> inputValueList = List.of(inputValue.split(""));
        UserInputValidator.getInstance().validate(inputValueList);
        return inputValueList;
    }
}
