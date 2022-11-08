package baseball.controller;

import static baseball.utils.Utils.stringToList;

import baseball.model.Answer;
import baseball.model.RandomNumGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.vo.Score;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    public static final int RESTART = 1;

    public BaseballGame() {
        OutputView.printGameStart();
    }

    public void gameStart() {
        Answer answer = new Answer(RandomNumGenerator.generate());
        guessAnswer(answer);
        InputView.inputRestartOrExitNumber();
        String restartExitString = Console.readLine();
        InputValidator.checkIsValidRestartExitString(restartExitString);
        if (Integer.parseInt(restartExitString) == RESTART) {
            gameStart();
        }
    }

    public void guessAnswer(Answer answer) {
        InputView.inputGuessThreeNumbers();
        String inputNumbers = Console.readLine();
        InputValidator.checkIsValidThreeNumbers(inputNumbers);
        Score userScore = answer.compare(stringToList(inputNumbers));
        OutputView.printResult(userScore);
        if (answer.isUserCorrect(userScore)) {
            OutputView.printGameEnd();
        }
        if (!answer.isUserCorrect(userScore)) {
            guessAnswer(answer);
        }
    }
}
