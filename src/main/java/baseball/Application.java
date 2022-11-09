package baseball;

import static baseball.message.Message.START_MESSAGE;

public class Application {
    public static void main(String[] args) {

        System.out.println(START_MESSAGE);

        while (true) {
            BullsAndCows bullsAndCows = new BullsAndCows(new BullsAndCowsResult());

            while (!bullsAndCows.getBullsAndCowsResult().isFinish()) {
                bullsAndCows.startGame();
            }

            boolean bullsAndCowsContinue = bullsAndCows.isContinue();
            if (!bullsAndCowsContinue) {
                break;
            }
        }
    }
}