package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
    private String userInput;
    private boolean flag;

    public String getUserNumber() {
        System.out.print("숫자를 입력해 주세요 : ");
        String userInput = readLine();
        return userInput;
    }
}
