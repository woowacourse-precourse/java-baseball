package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

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
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            list.add(string.charAt(i));
        }
        return list;
    }

}
