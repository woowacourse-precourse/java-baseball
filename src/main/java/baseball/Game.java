package baseball;

import baseball.domain.Computer;
import baseball.domain.User;

import static baseball.Status.Playing;
import static constant.Constants.GAME_FINISH_MSG;
import static constant.Constants.START_MSG;

public class Game {
    private final Computer computer = new Computer();
    private final User user = new User();
    private final Score score =new Score();
    private Status status;

    //게임 실행부분(재실행 여부 확인 포함)
    public void start() {
        do {
            initGame();
            play();
        } while (user.scanWantReplayingGame());
    }

    //실질적 게임 실행
    private void play() {
        System.out.println(START_MSG);

        while (status == Playing) {
            user.scanUserNums();
            score.setUserNums(user.getNums());
            score.calculateAndShowHint();
            status = score.checkingStatus();
        }
        System.out.println(GAME_FINISH_MSG);
    }

    private void initGame() {
        computer.setRandNums();
        score.setAnswerNums(computer.getNums());
        status = Playing;
    }

}
