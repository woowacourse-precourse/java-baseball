package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        final int numberLength = 3;
        String loopChecker = "1";

        System.out.println("숫자 야구 게임을 시작합니다.");

        Baseball baseball = new Baseball(numberLength);

        while (loopChecker.equals("1")) {
            baseball.play();

            System.out.println(numberLength + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            loopChecker = Console.readLine();
            checkRetryInputException(loopChecker);
        }
    }

    private static void checkRetryInputException(String retry) throws IllegalArgumentException{
        if (!(retry.equals("1") || retry.equals("2"))) {
            throw new IllegalArgumentException();
        }
    }
}
