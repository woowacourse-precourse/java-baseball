package baseball;

public class Application {
    public static void main(String[] args) {
        getStartMessage();

    }

    public static void getStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다");
    }

    public static void getCorrectMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
