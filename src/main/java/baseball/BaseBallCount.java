package baseball;

import java.util.List;

public class BaseBallCount {

    int numberOfBall;
    int numberOfStrik;

    public  void countStrikNumber(List<Integer> computerBaseBallNumber, String userBaseBallNumber) {
        int count = 0;
        for (int i = 0; i < computerBaseBallNumber.size(); i++) {
            if (computerBaseBallNumber.get(i).equals(userBaseBallNumber.charAt(i) - '0') ) {
                count++;
            }
        }
        numberOfStrik= count;
    }

    public static int countBall(int eachComputerBaseBallNumber, String userBaseBallNumber, int Index) {
        for (int i = 0; i < userBaseBallNumber.length(); i++) {
            if (eachComputerBaseBallNumber==userBaseBallNumber.charAt(i) - '0' && i != Index) {
                return 1;
            }
        }
        return 0;
    }

    public void countBallNumber(List<Integer> computerBaseBallNumber, String userBaseBallNumber) {
        int countBall = 0;
        for (int i = 0; i < computerBaseBallNumber.size(); i++) {
            countBall += countBall(computerBaseBallNumber.get(i), userBaseBallNumber, i);
        }
        numberOfBall=countBall;
    }


}
