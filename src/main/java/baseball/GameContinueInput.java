package baseball;


import camp.nextstep.edu.missionutils.Console;


public class GameContinueInput {

    public static String gameContinue() {
        String continueInput;

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        continueInput = Console.readLine();

        while (!continueInput.equals("1") && !continueInput.equals("2")){
            System.out.println(" 1 또는 2를 입력하세요.");
            continueInput = Console.readLine();
        }

        return continueInput;
    }
}
