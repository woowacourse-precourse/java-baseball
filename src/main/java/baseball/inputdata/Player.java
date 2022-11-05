package baseball.inputdata;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private static final String MESSAGE_TO_USER_INPUT = "숫자를 입력해주세요 : ";

    public static List<String> Input() {
        Scanner sc = new Scanner(System.in);
        List<String> intputData = new ArrayList<>();

        System.out.println(MESSAGE_TO_USER_INPUT);
        intputData.add(sc.next());

        return intputData;
    }
}
