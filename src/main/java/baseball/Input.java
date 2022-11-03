package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {
    public static List<Integer> playerNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            result.add(Integer.parseInt(String.valueOf(input.charAt(i))));
        }
        return result;
    }
}
