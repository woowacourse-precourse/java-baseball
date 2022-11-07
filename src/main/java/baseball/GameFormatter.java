package baseball;

public class GameFormatter {
    public static void gameStartMessage(){
        System.out.println("게임을 시작합니다.");
    }

    public static void gameInputMessage(){
        System.out.print("숫자를 입력해주세요 :");
    }

    public static void gameEndMessage(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
