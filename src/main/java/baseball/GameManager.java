package baseball;

public class GameManager {
    public static void launch() {
        boolean loopFlag = true;

        IOHandler.writeLaunchMessage();
        while (loopFlag) {
            play();
            IOHandler.writeStatusMessage();
            loopFlag = Validator.doStatusValidation(IOHandler.readInput());
        }
    }

    private static void play() {
        boolean threeStrikeFlag = false;
        String userInput;

        Opponent.initAnswer();
        while (!threeStrikeFlag) {
            IOHandler.writeInputMessage();
            userInput = IOHandler.readInput();
            Validator.doNumberValidation(userInput);
            threeStrikeFlag = Opponent.judge(userInput);
        }
        IOHandler.writeCompleteMessage();
    }
}
