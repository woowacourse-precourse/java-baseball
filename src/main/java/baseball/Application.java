package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        Scanner sc = new Scanner(System.in);

        boolean reset = true;
        while (reset) {
            // 게임 생성
            Baseball baseball = new Baseball();
            baseball.setNumber();
            //System.out.println(baseball.getNumber());

            boolean tryAgain = false;
            while (!tryAgain) {
                // 유저 입력
                UserInput userInput = new UserInput();
                userInput.input(sc);
                //System.out.println(userInput.getNumber());

                // 결과
                Result result = new Result();
                tryAgain = result.countResult(baseball.getNumber(), userInput.getNumber());
            }

            // 게임 재시작/종료
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            String re = sc.nextLine();

            if (re == "1") {
                reset = true;
            } else if (re == "2") {
                reset = false;
            } else {
                reset = false;
                throw new IllegalArgumentException();
            }
        }
    }
}
