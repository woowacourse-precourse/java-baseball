package baseball;

public class Application {
    public static void baseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        String restartNumber = "";
        do {
            // TODO: 랜덤 숫자 생성
            restartNumber = startGame();
        } while (!restartNumber.equals("2"));
    }

    public static String startGame() {
        // TODO: 숫자 입력받기
        // TODO: 입력한 수에 대한 힌트
        return "";
    }

    public static void main(String[] args) {
        baseballGame();
    }
}
