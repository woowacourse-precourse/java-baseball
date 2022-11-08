package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class inputNumber {
    public static List<Integer> makeInputNumber() throws IllegalArgumentException {
        List<Integer> inputNumber = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        System.out.print("숫자를 입력해주세요 : ");

//        int num = in.nextInt();
//        String s = Integer.toString(num);

        String num = Console.readLine();



        if(num.length()>3) {
            throw new IllegalArgumentException("잘못 입력하였습니다.");
        }

        for(int i=0; i<3; i++) {
            char character = num.charAt(i);
            String string = String.valueOf(character);
            Integer integer = Integer.valueOf(string);
            inputNumber.add(integer);
        }

        System.out.print(num+"\n");

        return inputNumber;
    }
}
