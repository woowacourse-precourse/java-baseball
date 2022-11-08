package baseball;

public class BaseballGame {

    private void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private void printNumberInputRequestMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    private void printSuccessMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
