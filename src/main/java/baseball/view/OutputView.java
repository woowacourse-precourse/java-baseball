package baseball.view;

public class OutputView {
    public static void endGameMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void initGameMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void endSystemMessage() {
        System.out.println("게임 종료");
    }

    public static void printString(String string){
        System.out.println(string);
    }
}
