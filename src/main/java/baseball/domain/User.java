package baseball.domain;

import baseball.util.myList;
import baseball.validator.InputValidator;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class User {
    private static User user = new User();
    User(){

    }
    public static User getInstance(){
        return user;
    }
    public List<Integer> inputUserAnswer() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine().trim();
        List<Integer> userInputs = myList.stringToIntegerList(input);
        if (! InputValidator.validateInPlaying(userInputs))
            throw new IllegalArgumentException("서로 다른 3자리 수를 입력해주세요.");
        return userInputs;
    }
}
