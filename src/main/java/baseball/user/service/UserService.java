package baseball.user.service;

import baseball.user.entity.User;
import baseball.user.convert.NumberConvert;
import baseball.user.exception.UserExceptionHandler;

import java.util.HashSet;
import java.util.Set;

public class UserService extends User {
    protected Set<Integer> usedNumber;
    private NumberConvert convert;

    public UserService() {
        this.usedNumber = new HashSet<>();
        this.convert = new NumberConvert();
    }


    public void setUserNumber() {
        validCheck(inputUserNumber);
        Integer userNumber = convert.stringNumberToInteger(inputUserNumber);
        userNumbersArr = convert.integerToIntegerArrOfEachElement(userNumber);
    }

    public void validCheck(String number){
        UserExceptionHandler exception = new UserExceptionHandler(number);

        exception.containDuplicateNumber();
        exception.containNumberZero();
    }
}
