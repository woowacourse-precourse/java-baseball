package baseball;

public class Application {
    private static boolean userWantsToPlay = true;

    public static void main(String[] args) {
        // TODO: greet user
        while(userWantsToPlay) {
            playBall();
        }
    }

    private static void playBall() {
        // TODO: getRandomNumber
        boolean strikeOut = false;
        while (!strikeOut) {
            // TODO: promptForNumber
            // TODO: getNumberFrom
            // TODO: getScore
            // TODO: printScore
            // TODO: update strikeOut
            strikeOut = true;
        }
        // TODO: congratulate user
        // TODO: update user willingness
        userWantsToPlay = false;
    }
}
