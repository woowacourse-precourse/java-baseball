package baseball;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        PlayBaseballGame play = new PlayBaseballGame();
        while(play.endGame()){
            play.playGame();
        }
    }
}
