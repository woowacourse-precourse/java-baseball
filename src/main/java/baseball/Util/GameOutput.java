package baseball.Util;

public class GameOutput {

    public static GameOutput instance;

    public static GameOutput getInstance() {
        if (instance == null) {
            instance = new GameOutput();
        }
        return instance;
    }

    public void printStartLog() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public void printGameEndInfo() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    public void printFinishLog() {
        System.out.println("게임을 종료합니다. 즐거우셨나요?\n아래는 모든 시도 결과입니다!");
    }
    public void printResult(String result) {
        System.out.println(result);
    }
    public static void printInputExceptionLog() {
        System.out.println("입력이 잘못되었습니다. 게임을 종료합니다.");
    }
}
