package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.stream.Stream;

public class User {

    private static int[] userNumbers;

    public User() {}

    public void inputNumbers() {
        System.out.println("숫자를 입력하세요 : ");
        String userInput = Console.readLine();
        checkException(userInput);
        convertInput(userInput);
    }

    public void checkException(String userInput) {
        Exceptions.checkInputIsNumber(userInput);
        Exceptions.checkInputIsTooLong(userInput);
        Exceptions.checkInputIsTooShort(userInput);
    }

    public void convertInput(String userInput) {
        userNumbers =  Stream.of(userInput.split("")).mapToInt(Integer::parseInt).toArray();
    }

    public static int[] getUserNumbers() {
        return userNumbers;
    }
}
