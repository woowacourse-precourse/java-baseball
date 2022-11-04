package baseball;

class Game {
    public final int RESTART = 1;
    public final int END = 2;

    public void restartGame(int userInputNum) {
        if (userInputNum == RESTART)
            System.out.println("게임시작함수");

        if (userInputNum == END)
            System.out.println("게임종료함수");
    }


    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

}


public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }
}
