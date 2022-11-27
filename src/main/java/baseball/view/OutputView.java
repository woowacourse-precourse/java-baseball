package baseball.view;

public class OutputView {
    public void printError(String message) {
        System.out.println(message);
    }

    public void printEnd() {
        System.out.println("세개 맞췃습니다 종료");
    }

    public void printCount(String printMessage) {
        System.out.println(printMessage);
    }

    public void printStart() {
        System.out.println("시작한당께");
    }
}
