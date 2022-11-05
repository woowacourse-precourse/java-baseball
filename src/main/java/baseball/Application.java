package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean gameEndFlag = false;

        while (!gameEndFlag) {
            List<String> computerList = AnswerGenerator.convertComputerList();
            BaseballGame baseballGame = new BaseballGame(computerList);
            String isRestart = baseballGame.playGame();

            if (isRestart.equals("2")) {
                gameEndFlag = true;
            }
        }
        System.out.println("게임을 종료합니다.");
    }
}
