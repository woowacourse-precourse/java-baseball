package baseball;

public class Application {
    public static void main(String[] args) {

        while (true) {
            BullsAndCows bullsAndCows = new BullsAndCows(new BullsAndCowsResult());

            while (!bullsAndCows.bullsAndCowsResult.finish()) {
                bullsAndCows.start();
            }

            boolean bullsAndCowsContinue = bullsAndCows.isContinue();
            if (!bullsAndCowsContinue) {
                break;
            }
        }
    }
}