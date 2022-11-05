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
        String additionalGame = "";

        do{
            new Game().gameStart();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            additionalGame = readLine();
            new Application().checkExceptionFromUserInputData(additionalGame);
        }while (additionalGame.equals("1"));
    }
}
