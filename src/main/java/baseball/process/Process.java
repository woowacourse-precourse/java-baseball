package baseball.process;

import baseball.utils.RandomNumber;
import baseball.utils.UserInput;
import baseball.model.Game;
import baseball.model.Result;

public class Process {
    private int number_of_digit;
    private Game game;
    private RandomNumber randomNumber;
    private UserInput userInput;

    public Process(final int NUMBER_OF_DIGIT) {
        this.number_of_digit = NUMBER_OF_DIGIT;
    }

    public void initialize() {
        this.game = new Game();
        this.randomNumber = new RandomNumber(game, number_of_digit);
        this.userInput = new UserInput(game, number_of_digit);
        randomNumber.createRandomNum();
        getUserInput();
    }

    public void getUserInput() {
        System.out.print("숫자를 입력해 주세요 : ");
        userInput.setUserInput();
        getResult();
    }

    public void getResult() {
        Comparison comparison = new Comparison(game, number_of_digit);
        Result result = new Result(game, comparison);
        System.out.println(result.getResultMsg());
        if (result.is3Strike()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            checkRestart();
            return;
        }
        getUserInput();
    }

    private void checkRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int userInputNumber = userInput.getNewGameStatusInput();

        if (userInputNumber == 2) {
            return;
        }
        if (userInputNumber == 1) {
            initialize();
        }
    }
}
