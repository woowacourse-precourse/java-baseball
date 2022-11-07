package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CountUtil {
    public List<Integer> createRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber))
                computer.add(randomNumber);
        }
        return (computer);
    }
    public void playGame() {
        RestartUtil restartUtil = new RestartUtil();
        PrintUtil printUtil = new PrintUtil();
        InputUtil inputUtil = new InputUtil();
        List<Integer> randomNumber = this.createRandomNumber();
        printUtil.inputGame(randomNumber);
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        restartUtil.restartGame(inputUtil.restartQuestion());
    }
    public List<Integer> compareNumber(List<Integer> randomNumber) {
        ArrayUtil arrayUtil = new ArrayUtil();
        int ball = 0;
        int strike = 0;
        List<Integer> arrayPlayerNumber = arrayUtil.arrayPlayerNumber();
        for (int i=0;i<3;++i) {
            if (Objects.equals(arrayPlayerNumber.get(i), randomNumber.get(i)))
                strike += 1;
            else
                ball += countBall(arrayPlayerNumber, randomNumber, i);
        }
        return arrayUtil.createCountArray(ball, strike);
    }
    public int countBall(List<Integer> arrayPlayerNumber, List<Integer> randomNumber, int i) {
        int ball = 0;
        for (int j=0;j<3;++j)
            if (i != j && (arrayPlayerNumber.get(i) == randomNumber.get(j)))
                ball += 1;
        return ball;
    }
    public boolean endGame(List<Integer> randomNumber) {
        return this.compareNumber(randomNumber).get(1) == 3;
    }
}