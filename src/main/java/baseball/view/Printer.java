package baseball.view;

public class Printer {
    public static void gameStart() {
        String message = "숫자 야구 게임을 시작합니다.";
        System.out.println(message);
    }

    public static void inputNumber() {
        String message = "숫자를 입력해주세요.";
        System.out.println(message);
    }

    public static void isALLCorrect() {
        String message = "3개의 숫자를 모두 맞히셨습니다! 게임종료";
        System.out.println(message);
    }

    public static void askRestart() {
        String message = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        System.out.println(message);
    }
}
