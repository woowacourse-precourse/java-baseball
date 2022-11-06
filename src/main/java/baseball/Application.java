package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameSet playGame = new GameSet(); //game class를 생성한다
        PrintMessage.startMessage(); // 시작할때 나오는 메세지
        while(playGame.isGameEnd()){
            playGame.playBaseballGame();
        }
    }
}