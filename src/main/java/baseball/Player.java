package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Player {

    private static final boolean THREE_STRIKE = true;
    private static final int ONE_MORE_GAME = 1;
    private static final int END_GAME = 2;

    public boolean guess(Answer answer) {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        List<Character> numbers = stringToList(input);
        BaseBallNumber baseBallNumber = new BaseBallNumber(numbers);
        if (answer.compare(baseBallNumber) == THREE_STRIKE) {
            return Computer.end();
        }
        return false;
    }

    public int choose() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        int choice = Integer.parseInt(input);
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
