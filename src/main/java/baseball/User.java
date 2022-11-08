package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class User {
    static List<Integer> player = new ArrayList<>();
    static Set<Integer> userSet = new HashSet<>(player);

    static int playerNumber = 0;

    public static void enterNum() {

        System.out.println("숫자를 입력해주세요: ");
        playerNumber = Integer.parseInt(Console.readLine());

        int[] digits = Stream.of(String.valueOf(playerNumber).split("")).mapToInt(Integer::parseInt).toArray();
        player = new ArrayList<>();


        for (int order = 0; order < digits.length; order++) {
            player.add(digits[order]);
        }
        userSet = new HashSet<>(player);
    }
}
