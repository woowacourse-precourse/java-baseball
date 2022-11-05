package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner input = new Scanner(System.in);
        boolean isTrue = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            System.out.print("숫자를 입력해주세요 : ");
            String number = input.next();
            System.out.println(number);
            isTrue = false;
        } while (isTrue);
    }
}
