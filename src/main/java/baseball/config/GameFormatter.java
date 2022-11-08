package baseball.config;

public class GameFormatter {
    public static void gameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void gameInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void gameEndMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void gameOnlyStrikeMessage(int strike) {
        System.out.println(strike + "스트라이크");
    }

    public static void gameHitMessage(int strike){
        gameOnlyStrikeMessage(strike);
        System.out.println(strike + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void gameOnlyBallMessage(int ball){
        System.out.println(ball + "볼");
    }

    public static void gameNothingMessage(){
        System.out.println("낫싱");
    }

    public static void gameBothBallAndStrikeMessage(int ball, int strike){
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }
}
