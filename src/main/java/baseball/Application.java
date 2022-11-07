package baseball;

import camp.nextstep.edu.missionutils.Console;
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
            System.out.print(Message.PROMPT_FOR_NUMBER);
            String input = Console.readLine();
            List<Integer> user = Play.getNumberFrom(input);
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
