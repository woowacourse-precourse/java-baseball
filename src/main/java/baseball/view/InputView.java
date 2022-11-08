package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String userNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String userNumberOfString = Console.readLine();
        return userNumberOfString;
    }

    public static String checkIsGameRepeatFromUserByGetOneOrTwo() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String oneIfUserRepeatGameOrTwo = Console.readLine();
        return oneIfUserRepeatGameOrTwo;
    }

}
