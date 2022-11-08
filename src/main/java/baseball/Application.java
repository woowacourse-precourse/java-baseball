package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println(Message.GREETING);
        do {
            playBall();
        } while (playOn());
    }

    private static void playBall() {
        List<Integer> computer = Play.getRandomNumber();
        boolean strikeOut = false;
        while (!strikeOut) {
            System.out.print(Message.PROMPT_FOR_NUMBER);
            String input = Console.readLine();
            List<Integer> user = Play.getNumberFrom(input);
            Score.SCORE.of(user, computer);
            Score.SCORE.print();
            strikeOut = Score.SCORE.strikeOut();
        }
        System.out.println(Message.CONGRATULATIONS);
    }

    private static boolean playOn() {
        System.out.println(Message.PROMPT_PLAY_ON);
        String input = Console.readLine();
        if (input == null || !input.matches("^[12]$")) {
            throw new IllegalArgumentException();
        }
        return input.equals("1");
    }
}
