package baseball.game;

import baseball.computer.Computer;
import baseball.digit.Digit;
import baseball.digit.Digits;
import baseball.score.Score;
import baseball.score.ScoreStatus;
import utils.InputUtil;

import java.util.List;

import static utils.ConvertUtil.convertDigit;
import static utils.OutputUtil.printGameEnd;
import static utils.OutputUtil.printGameStart;

public class GameManager {

    private Computer computer;
    private Score score;

    public GameManager() {
        this.score = new Score();
    }

    public void init() {
        this.computer = new Computer();
        this.score = new Score();
    }
    public boolean isEndGame(){
        return score.getStrike() == 3;
    }

    public void start(){
        printGameStart();
        boolean inputRetryNumber = true;
        while (inputRetryNumber){
            init();
            play();
            inputRetryNumber = checkRestart();
        }
    }

    public void play(){
        while (true){
            List<Digit> inputDigitNumber = InputUtil.inputTryNumber();
            List<Integer> targetNumber = computer.getTargetNumber();
            Digits digitTragetList = new Digits(convertDigit(targetNumber));
            List<ScoreStatus> scoreResultList = digitTragetList.checkAllDigits(new Digits(inputDigitNumber));
            score.countTotalScore(scoreResultList);
            score.printScore();
            if (isEndGame()){
                printGameEnd();
                return;
            }
            score.clear();
        }
    }

    public boolean checkRestart(){
        return InputUtil.inputRetryNumber();
    }


}
