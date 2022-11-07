package baseball;


import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Player {

    public List<Integer> getPlayerRandomNumber() {
        List<Integer> player = new ArrayList<>();
        System.out.println("숫자를 입력해주세요: ");
        String playerInput = Console.readLine();

        checkInputSize(playerInput);
        isNumber(playerInput);
        isDuplicated(playerInput);

        for (int i = 0; i < 3; i++) {
            player.add(Character.getNumericValue(playerInput.charAt(i)));
        }
        return player;
    }

    public static void isNumber(String input) {
        if (!Pattern.matches("^[0-9]*$", input)) {
            throw new IllegalArgumentException("[1,9] 범위 내의 숫자만 사용할 수 있습니다.");
        }
    }

    public static void isDuplicated(String input) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            set.add(input.charAt(i));
        }

        if (input.length() != set.size()) {
            throw new IllegalArgumentException("중복된 숫자는 사용할 수 없습니다.");
        }
    }

    public static void checkInputSize(String input) {
        if (input == null || input.length() != 3) {
            throw new IllegalArgumentException("3자리의 숫자만 입력할 수 있습니다.");
        }
    }
}
