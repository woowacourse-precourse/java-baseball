package baseball.utils;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInput {

    public static String input(){
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = readLine();

        NumberChecker.checkUserInput(userInput);

        return userInput;
    }

    public static String endInput(){
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = readLine();

        NumberChecker.isOneOrTwo(userInput);

        return userInput;
    }
}
