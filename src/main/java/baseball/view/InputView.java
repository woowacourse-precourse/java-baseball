package baseball.view;

import baseball.utils.Validator;
import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static List<Integer> readUserNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        Validator.isLengthThree(input);
        Validator.isAllNumber(input);
        return stringToList(input);
    }

    public static int readGameCommand() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        Validator.isOneOrTwo(input);
        return Integer.parseInt(input);
    }

    private static List<Integer> stringToList(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            numbers.add((int) input.charAt(i) - '0');
        }
        return numbers;
    }
}
