package baseball.service;

import baseball.vo.Master;
import baseball.utils.NumberGenerator;

public class GameService {

    int digit;
    Master master;

    public void setGame(int digit, int minNumber, int maxNumber) {
        this.digit = digit;
        master = new Master(NumberGenerator.createRandomNumbers(digit, minNumber, maxNumber));
        master.initCount();
    }

}
