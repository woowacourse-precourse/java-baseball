package baseball;

import baseball.starter.BaseBallGameStarter;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {


    static BaseBallGameStarter baseBallGameStarter = new BaseBallGameStarter();

    public static void main(String[] args) {

        List<List<String>> operatedGame = baseBallGameStarter.operate();
        List<String> userInputValue = operatedGame.get(0);
        List<String> computerGeneratedValue = operatedGame.get(1);
        int option = 0;

        while (true) {
            if (baseBallGameStarter.judgementOperate(userInputValue, computerGeneratedValue)) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                option = Integer.parseInt(Console.readLine());
            }
            if (option == 1) {
                operatedGame = baseBallGameStarter.operate();
                userInputValue = operatedGame.get(0);
                computerGeneratedValue = operatedGame.get(1);
            } else if (option == 2) {
                break;
            }
        }
    }
}
