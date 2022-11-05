package baseball.Input;

import java.util.Scanner;

public class InputNumber {
    public int getInputNumber(){
        Scanner number = new Scanner(System.in);
        int receivedNumber = number.nextInt();

        return receivedNumber;
    }

    public int getRestartAndEndNumber(){
        Scanner getNumber = new Scanner(System.in);
        int buttonNumber = getNumber.nextInt();

        return buttonNumber;
    }
}
