package baseball;

public class Application {
    public static void main(String[] args) {

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