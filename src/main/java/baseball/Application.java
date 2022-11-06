package baseball;

import java.util.Random;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.println("숫자를 입력해주세요 : ");
        int answerNum = createAnswer();
        System.out.println(answerNum);
        sc.close();
    }

    private static int createAnswer() {
        int min = 1;
        int max = 9;

        StringBuilder answer = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            answer.append((random.nextInt(max)+min));
        }

        return Integer.parseInt(answer.toString());
    }
}
