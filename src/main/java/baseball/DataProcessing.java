package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DataProcessing {
    private List<Integer> randomNumber;
    public void createRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber))
                computer.add(randomNumber);
        }
        this.randomNumber = computer;
    }
    public List<Integer> countBallStrike() {
        int ball = 0;
        int strike = 0;
        List<Integer> playerNumber = arrayPlayerNumber();
        for (int i=0;i<3;++i) {
            if (Objects.equals(playerNumber.get(i), randomNumber.get(i)))
                strike += 1;
            else
                ball += countBall(playerNumber, i);
        }
        List<Integer> ballStrike = new ArrayList<>();
        ballStrike.add(ball);
        ballStrike.add(strike);
        return ballStrike;
    }
    public int countBall(List<Integer> playerNumber, int i) {
        int countBall = 0;
        for (int j=0;j<3;++j){
            if (i != j && playerNumber.get(i) == randomNumber.get(j))
                countBall += 1;
        }
        return countBall;
    }
    public List<Integer> arrayPlayerNumber() {
        List<Integer> playerNumber = new ArrayList<>();
        InputUtil inputUtil = new InputUtil();
        String temp = inputUtil.inputPlayerNumber();
        for (int i=0;i<3;++i) {
            playerNumber.add(temp.charAt(i) - 48);
        }
        return playerNumber;
    }
    public boolean printBallStrike() {
        boolean end = false;
        PrintUtil printUtil = new PrintUtil();
        List<Integer> ballStrike = countBallStrike();
        if (ballStrike.get(1) == 3) {
            end = true;
            printUtil.printThreeStrike();
        }
        else if (ballStrike.get(0) == 0 && ballStrike.get(1) == 0)
            printUtil.printNoting();
        else if (ballStrike.get(0) != 0 && ballStrike.get(1) != 0)
            System.out.println(ballStrike.get(0) + "볼 " + ballStrike.get(1) + "스트라이크");
        else if (ballStrike.get(0) != 0 && ballStrike.get(1) == 0)
            System.out.println(ballStrike.get(0) + "볼");
        else if (ballStrike.get(0) == 0 && ballStrike.get(1) != 0)
            System.out.println(ballStrike.get(1) + "스트라이크");
        return end;
    }
}