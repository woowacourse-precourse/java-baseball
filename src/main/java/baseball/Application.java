package baseball;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        NumberHandler numberHandler = new NumberHandler();
        System.out.print("값을 입력하세요 -->  ");
        numberHandler.setUserNumber();
        ArrayList<Integer> userNumber = numberHandler.getUserNumber();

        for (Integer number : userNumber) {
            System.out.print(number);
        }
        System.out.println();
    }
}
