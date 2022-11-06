package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class inputNumber {
    public static List<Integer> makeInputNumber() {
        List<Integer> inputNumber = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        Scanner in = new Scanner(System.in);

//        try {
//            for(int i=0; i<3; i++) {
//                inputNumber.add(in.nextInt());
//            }
//
//        } catch (IllegalArgumentException e) {
//            throw new IllegalArgumentException();
//        }

        for(int i=0; i<3; i++) {
            inputNumber.add(in.nextInt());
        }

        System.out.println(inputNumber);
        return inputNumber;

    }
}
