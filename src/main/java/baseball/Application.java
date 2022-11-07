package baseball;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        try {
            BullsAndCows game = new BullsAndCows();
            while ((doRepeat()) == 1) {
                game.playGame();
            }
        } catch (IllegalArgumentException exception) {
            IO.alert_wrongValue();
        } finally {
            IO.alert_endProgram();
        }
    }

    private static int doRepeat() {
        String repeatInput = getRepeatInput();
        return Integer.parseInt(repeatInput);
    }

    private static String getRepeatInput() {
        String repeatInput = IO.ask_repeat();
        if (!Numbers.checkRepeatInput_regex(repeatInput)) {
            throw new IllegalArgumentException();
        }
        return repeatInput;
    }

}
