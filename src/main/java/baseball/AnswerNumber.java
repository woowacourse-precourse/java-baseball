package baseball;

import java.util.Scanner;

public class AnswerNumber {
    public static void main(String[] args)
    {
        inputPrint();
        getInputNumber();
    }
    public static void inputPrint(){
        System.out.println("숫자를 입력해주세요 : ");
    }
    public static int getInputNumber(){
        Scanner number = new Scanner(System.in);
        int receivedNumber = number.nextInt();

        return receivedNumber;
    }
}
