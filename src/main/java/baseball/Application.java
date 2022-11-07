package baseball;

import java.util.List;

public class Application {
    private static boolean userWantsToPlay = true;

    public static void main(String[] args) {
        System.out.println(Message.GREETING);
        while(userWantsToPlay) {
            playBall();
        }
    }

    private static void playBall() {
        List<Integer> computer = Play.getRandomNumber();
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
