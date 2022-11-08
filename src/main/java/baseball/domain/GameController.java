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
            requestNewGame();
        }
    }
    void playGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        if (!computer.isReady())
            computer.initRandomNumbers();
        computer.getCounts();
        List<Integer> answer = user.inputUserAnswer();
        while (!isClear(answer)) answer = user.inputUserAnswer();
        computer.clearRandomNumbers();
    }

    boolean isClear(List<Integer> input){

        int strike = myList.countSameLocationValues(input, computer.getBallCounts());
        int ball = myList.countDiffLocationValues(input, computer.getBallCounts());

        if ( ball == 0 && strike == 0 ) System.out.println("낫싱");
        if ( ball != 0 ) System.out.print(ball + "볼 ");
        if ( strike != 0 ) System.out.println(strike + "스트라이크");
        if ( strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    void requestNewGame(){
        if ( user.inputKeepPlaying() == 2 ) keepPlaying = false;
    }
}
