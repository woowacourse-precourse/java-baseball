package baseball.model.player;

import baseball.model.computer.Answer;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Player {

    private static final boolean THREE_STRIKE = true;
    private static final int ONE_MORE_GAME = 1;
    private static final int END_GAME = 2;

    public boolean guessAnswer(Answer answer) {
        return answer
                .compare(new BaseBallNumber(stringToList(Console.readLine()))) == THREE_STRIKE;
    }

    public int chooseToContinue() {
        final int choice = Integer.parseInt(Console.readLine());
        validateChoice(choice);
        if (choice == END_GAME) {
            return END_GAME;
        }
        return ONE_MORE_GAME;
    }

    public static void validateChoice(int choice) {
        if (choice != ONE_MORE_GAME && choice != END_GAME) {
            throw new IllegalArgumentException(
                    "Choice should be " + ONE_MORE_GAME + " or " + END_GAME);
        }
    }

    public static List<Character> stringToList(String string) {
        return IntStream.range(0, string.length())
                .mapToObj(string::charAt)
                .collect(Collectors.toList());
    }

}
