package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {

    private final Generator generator;
    private final Validator validator;

    private String randomNumber;
    private boolean isPlaying;

    public static void execute(Generator generator, Validator validator) {
        BaseballGame baseballGame = new BaseballGame(generator, validator);
        baseballGame.start();
    }

    private BaseballGame(Generator generator, Validator validator) {
        this.generator = generator;
        this.validator = validator;
    }

    private void init() {
        this.randomNumber = generator.generateRandomNumber();
        this.isPlaying = true;
    }

    private void start() {
        Printer.start();
        init();

        while (isPlaying) {
            isPlaying = this.play();
        }

        Printer.finish();
    }

    private boolean play() {
        Printer.inputNumber();

        String input = Console.readLine();
        validator.validateInput(input);

        return false;
    }

}
