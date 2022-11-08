package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class User {
    static List<Integer> user = new ArrayList<>();
    Set<Integer> userSet = new HashSet<>(user);


    public static void enterNum() {
            int userNumber = 0;
            System.out.println("숫자를 입력해주세요: ");
            userNumber =Integer.parseInt(Console.readLine());

            int[] digits = Stream.of(String.valueOf(userNumber).split("")).mapToInt(Integer::parseInt).toArray();
            user = new ArrayList<>();
        }
}
