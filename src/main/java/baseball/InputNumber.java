package baseball;

import java.util.Scanner;

public class InputNumber {
    public  int getInputNumber(){
        Scanner number = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        int receivedNumber = number.nextInt();

        return receivedNumber;
    }
}
