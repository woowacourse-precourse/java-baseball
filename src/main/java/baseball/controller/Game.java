package baseball.controller;

import baseball.domain.Result;
import baseball.domain.ResultType;
import baseball.logic.DigitNumber;
import baseball.logic.Judge;
import baseball.presentation.View;
import camp.nextstep.edu.missionutils.Console;
import java.util.Map;

public class Game {

    private final View view;
    private final Judge judge;
    private final DigitNumber digitNumber;

    public Game(View view, Judge judge, DigitNumber digitNumber) {
        this.view = view;
        this.judge = judge;
        this.digitNumber = digitNumber;
    }

    public void play() throws IllegalArgumentException {
        view.printStart();
        Map<Integer, Integer> computerNumber = digitNumber.generateDigitNumberWithoutDuplication();

        while (true) {
            view.printPlayerTurn();
            String userInput = Console.readLine();
            Map<Integer, Integer> userNumber = digitNumber.convertNumberToMap(userInput);
            Result result = judge.compare(computerNumber, userNumber);

            if (result.isNothing()) {
                view.printNoting();
                continue;
            }

            if (result.isCorrect()) {
                view.printCorrect();
                return;
            }

            int countOfBall = result.get(ResultType.BALL);
            int countOfStrike = result.get(ResultType.STRIKE);
            view.printBallAndStrike(countOfBall, countOfStrike);
        }
    }

}
