package baseball;

import java.util.ArrayList;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다!!!");
        System.out.println("엔서는"+answer(args));

    }

    public static ArrayList<Integer> answer(String[] args) {
        int num1;
        int num2;
        int num3;

        while(true) {
            num1 = (int)(Math.random() * 9 + 1);
            num2 = (int)(Math.random() * 9 + 1);
            num3 = (int)(Math.random() * 9 + 1);

            if(num1 != num2 && num1 != num3 && num2 != num3){break;}};

        ArrayList<Integer> answer = new ArrayList<Integer>();
        answer.add(num1);
        answer.add(num2);
        answer.add(num3);

        return answer;
    }
}

