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
            playGame();
//            requestNewGame();
        }
    }
    void playGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        if (!computer.isReady())
            computer.initRandomNumbers();
        computer.getCounts();
        List<Integer> answer = user.inputUserAnswer();
//        while (!getScore(answer)) answer = user.inputUserAnswer();
        computer.clearRandomNumbers();
    }
}
