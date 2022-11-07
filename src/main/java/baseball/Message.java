package baseball;


public class Message {
    public static void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void getUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void hint(String hint) {
        System.out.println(hint);
    }

    public static void nothing() {
        System.out.println("낫싱");
    }

    public static void endGame() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void replay() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}