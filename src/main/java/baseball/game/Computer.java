package baseball.game;

import baseball.message.SystemMessage;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    public static final int COMPUTER_NUMBER_SIZE = 3;
    private List<Integer> computerNumber;

    public List<Integer> getComputerNumber() {
        return computerNumber;
    }

    public void setComputerNumber(List<Integer> computerNumber) {
        this.computerNumber = computerNumber;
    }

    public void startGame() {
        setComputerNumber(createComputerNumber());
        System.out.println(SystemMessage.START_NUMBER_BASEBALL_GAME);
    }

    public List<Integer> createComputerNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < COMPUTER_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }

    public String playGame(List<Integer> playerNumber) {
        List<Integer> computerNumber = getComputerNumber();
        int strikeCnt = 0;
        int ballCnt = 0;
        for (int i = 0; i < playerNumber.size(); i++) {
            for (int j = 0; j < computerNumber.size(); j++) {
                if (playerNumber.get(i).equals(computerNumber.get(j))) {
                    strikeCnt = getCount(i == j, strikeCnt);
                    ballCnt = getCount(i != j, ballCnt);
                }
            }
        }
        return getResult(strikeCnt, ballCnt);
    }

    private int getCount(boolean i, int count) {
        if (i) {
            count++;
        }
        return count;
    }

    private String getResult(int strikeCnt, int ballCnt) {
        if (strikeCnt == COMPUTER_NUMBER_SIZE) {
            return SystemMessage.THREE_NUMBERS_RIGHT_GAME_OVER;
        }
        if (strikeCnt > 0 && ballCnt > 0) {
            return strikeCnt + SystemMessage.STRIKE + ballCnt + SystemMessage.BALL;
        }
        if (strikeCnt == 0 && ballCnt > 0) {
            return ballCnt + SystemMessage.BALL;
        }
        if (strikeCnt > 0 && ballCnt == 0) {
            return strikeCnt + SystemMessage.STRIKE;
        }
        return SystemMessage.NOTHING;
    }

}
