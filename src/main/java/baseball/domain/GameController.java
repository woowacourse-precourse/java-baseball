package baseball.domain;

import baseball.util.myList;

import java.util.List;

public class GameController {
    private static GameController gameController = new GameController();
    private static Computer computer = null;
    private static User user = null;
    private static boolean keepPlaying;
    public GameController(){
        this.computer = Computer.getInstance();
        this.user = User.getInstance();
        this.keepPlaying = true;
    }
    public void run(){
        // 종료 플래그가 나올 때까지 계속 실행
        while(keepPlaying){
//            playGame();
//            requestNewGame();
        }
    }


}
