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

    public void start() {
        do {
            initGame();
            play();
        } while (user.scanWantReplayingGame());
    }

    private void play() {
        System.out.println(START_MSG);

        while (status == Playing) {
            user.scanUserNums();
            score.setUserNums(user.getNums());
            score.calculateAndShowResult();
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
