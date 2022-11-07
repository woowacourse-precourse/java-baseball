package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {

    private final Generator generator;
    private final Validator validator;
    private final Checker checker;

    private String randomNumber;
    private boolean isPlaying;

    public static void execute(Generator generator, Validator validator, Checker checker) {
        BaseballGame baseballGame = new BaseballGame(generator, validator, checker);
        baseballGame.start();
    }

    private BaseballGame(Generator generator, Validator validator, Checker checker) {
        this.generator = generator;
        this.validator = validator;
        this.checker = checker;
    }

    private void init() {
        this.randomNumber = generator.generateRandomNumber();
        this.isPlaying = true;
    }

    private void start() {
        Printer.start();
        init();

        while (isPlaying) {
            play();
        }

        Printer.finish();
    }

    private void play() {
        Printer.inputNumber();

        String userInput = Console.readLine();
        validator.validateInput(userInput);

        if (checker.isUserGuessRight(generator.getOverlapChecker(), userInput, this.randomNumber)) {
            this.checkUserDecision();
        }
    }

    private void checkUserDecision() {
        if (validator.userWantRestart(Console.readLine())) {
            init();
            return;
        }

        this.isPlaying = false;
    }

}
