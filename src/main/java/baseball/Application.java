package baseball;

import baseball.starter.BaseballGameStarter;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        BaseballGameStarter baseballGameStarter = new BaseballGameStarter();
        List<List<String>> operatedGame = baseballGameStarter.operate();
        List<String> userInputValue = operatedGame.get(0);
        List<String> computerGeneratedValue = operatedGame.get(1);
        int option = 0;

        while (true) {
            if (baseballGameStarter.operateRefereeJudgement(userInputValue, computerGeneratedValue)) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                option = Integer.parseInt(Console.readLine());
            }
            if (option == 1) {
                operatedGame = baseballGameStarter.operate();
                userInputValue = operatedGame.get(0);
                computerGeneratedValue = operatedGame.get(1);
            } else if (option == 2) {
                break;
            } else if (option != 1 || option != 2) {
                throw new IllegalArgumentException();
            }
        }
    }
}