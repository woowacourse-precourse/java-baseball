package baseball;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static Computer computer = new Computer();
    public static User user = new User();

    public static void start() {
        user.register(computer);
        printMessage(Message.NUMBER_BASEBALL_GAME_START);
        while (true) {
            computer.makeRandomNumber();
            startUnitGame();
            printMessage(Message.NUMBER_BASEBALL_GAME_IS_RESTART);
            String userInput = user.getConsoleInput();
            GameStatus.validStatus(userInput);
            if (!GameStatus.isYes(userInput)) {
                return;
            }
        }
    }


    private static void startUnitGame() {
        while (true) {
            printMessage(Message.INPUT_NUMBER);

            user.makeBaseBallNumber();
            user.printBaseBallNumber();

            List<Hint> hintList = user.compareToComputer();
            Long ballCount = getHintCount(hintList, Hint.BALL);
            Long strikeCount = getHintCount(hintList, Hint.STRIKE);

            List<String> hintStringList = genHintList(ballCount, strikeCount);

            String hinString = String.format("%s\n", String.join(" ", hintStringList));
            print(hinString);

            if (isThreeStrike(strikeCount)) {
                printMessage(Message.END_NUMBER_BASEBALL_GAME);
                return;
            }
        }
    }

    private static long getHintCount(List<Hint> hintList, Hint hint) {
        return hintList.stream().filter(h -> h.equals(hint)).count();
    }

    private static boolean isThreeStrike(Long strikeCount) {
        return strikeCount == BaseBallNumber.BASE_BALL_NUMBER_MAX_SIZE;
    }

    private static List<String> genHintList(Long ballCount, Long strikeCount) {
        if (isNothing(ballCount, strikeCount)) {
            return List.of(Hint.NOTHING.hintString(1L));
        }
        List<String> hintList = new ArrayList<>(List.of(Hint.BALL.hintString(ballCount), Hint.STRIKE.hintString(strikeCount)));
        hintList.remove("");
        return hintList;
    }

    private static boolean isNothing(Long ballCount, Long strikeCount) {
        return ballCount == 0 && strikeCount == 0;
    }

    private static void printMessage(Message message) {
        print(message.getMessage());
    }

    private static void print(String hinString) {
        System.out.print(hinString);
    }
}
