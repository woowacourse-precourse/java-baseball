package baseball;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        BaseballGame newGame;
        do {
            newGame = new BaseballGame();
            newGame.start();
        } while (!newGame.isLastGame); // 마지막 게임이 아닐 경우 반복
    }
}
