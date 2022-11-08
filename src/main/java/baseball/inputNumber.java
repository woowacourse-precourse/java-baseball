package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class inputNumber {
    public static List<Integer> makeInputNumber() throws IllegalArgumentException {
        List<Integer> inputNumber = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        Scanner in = new Scanner(System.in);

        int num = in.nextInt();

        String s = Integer.toString(num);

        if(s.length()>3) {
            throw new IllegalArgumentException("잘못 입력하였습니다.");
        }

        for(int i=0; i<3; i++) {
            char character = s.charAt(i);
            String string = String.valueOf(character);
            Integer integer = Integer.valueOf(string);
            inputNumber.add(integer);
        }
        return inputNumber;
    }
}
