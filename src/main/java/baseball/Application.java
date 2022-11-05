package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public void checkExceptionFromUserInputData(String userNumber) {
        if (!userNumber.equals("1") && !userNumber.equals("2")) {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
