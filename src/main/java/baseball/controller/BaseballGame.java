package baseball.controller;

import baseball.model.RandomNumGenerator;
import baseball.model.UserInputValidation;
import baseball.model.RestartGame;
import baseball.view.UserInput;
import baseball.view.Output;

import java.util.List;

public class BaseballGame {
    public void GameStart() {
        RandomNumGenerator randomNum = new RandomNumGenerator();
        UserInputValidation validateUserInput = new UserInputValidation();
        Output outputResult = new Output();
        RestartGame restartGame = new RestartGame();

        final String ANSWER_OUTPUT = "3스트라이크";
        List<Integer> user_num;
        String result;
        boolean restart = true;

        while (restart) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            result = "";
            List<Integer> random_num = randomNum.getRandomNum();
            while (!result.equals(ANSWER_OUTPUT)) {
                user_num = validateUserInput.getUserInput(UserInput.getUserNumber());
                result = outputResult.outputString(random_num, user_num);
                System.out.println(result);
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            restart = restartGame.restartorExit();
        }
    }
}
