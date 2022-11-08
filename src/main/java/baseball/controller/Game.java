package baseball.controller;

import baseball.model.strikeandball.StrikeAndBall;
import baseball.service.GameService;
import baseball.utills.constants.Constants;
import baseball.view.Input;
import baseball.view.Output;
import baseball.model.numbergenerator.NumberGenerator;
import baseball.model.numbers.Numbers;

public class Game {
    private final NumberGenerator numberGenerator;
    private final Input input;
    private final Output output;
    private final GameService gameService;

    public Game(NumberGenerator numberGenerator, Input input, Output output, GameService gameService) {
        this.numberGenerator = numberGenerator;
        this.input = input;
        this.output = output;
        this.gameService = gameService;
    }

    public void init() {
        output.printInit();
    }

    public void play() {
        Numbers answerNumbers = numberGenerator.generateRandomNumber(3);

        StrikeAndBall result;
        do {
            Numbers inputNumbers = input.getNumber();

            result = gameService.compareAnswerNumberAndInputNumber(answerNumbers, inputNumbers);
            output.printStrikeandBall(result);

        } while (!result.isThreeStrike());

        this.playNewGameOrQuit();
    }

    public void playNewGameOrQuit() {
        int userInput = input.getOneOrTwo();
        if (userInput == Constants.RESTART) {
            this.play();
        }
    }
}