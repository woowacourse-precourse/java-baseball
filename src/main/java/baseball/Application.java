package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    private final static int CONTINUE = 1;
    private final static int EXIT = 2;
    private final static int DIGIT = 3;

    public static void main(String[] args) {
        View view = View.getInstance();
        Judge judge = Judge.getInstance();
        DigitNumber digitNumber = DigitNumber.getInstance(DIGIT);
        int command = CONTINUE;

        while (command == CONTINUE) {
            Game game = new Game(view, judge, digitNumber);

            try {
                game.play();
                command = Integer.parseInt(Console.readLine());
                Validator.isRestartCommand(command);
            } catch (IllegalArgumentException e) {
                command = EXIT;
            }
        }
    }

}
