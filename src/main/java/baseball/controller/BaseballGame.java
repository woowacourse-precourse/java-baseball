package baseball.controller;

import baseball.model.RandomNumGenerator;
import baseball.model.UserInputValidation;
import baseball.view.UserInput;
import baseball.view.Output;

import java.util.List;

public class BaseballGame {
    public void GameStart() {
        RandomNumGenerator randomNum = new RandomNumGenerator();
        UserInputValidation validateUserInput = new UserInputValidation();
        Output outputResult = new Output();

        final String ANSWER_OUTPUT = "3스트라이크";
        List<Integer> random_num;
        List<Integer> user_num;
        String result;
        boolean restart = true;

        while (!restart) {
            result = "";
            random_num = randomNum.getRandomNum();
            while (!result.equals(ANSWER_OUTPUT)) {
                user_num = validateUserInput.getUserInput(UserInput.getUserNumber());
                result = outputResult.outputString(random_num, user_num);
                System.out.println(result);
            }
        }
    }
}
