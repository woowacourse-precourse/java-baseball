package baseball.gameComponents;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class MainFunctions {
    public List<Integer> generateRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }

    public int[] examineGuess(List<Integer> guess, List<Integer> answer) {
        //0번째 값 : strike;
        //1번째 값 : ball;
        int[] strikesAndBalls = new int[2];
        boolean[] isPicked = new boolean[10];
        for(int i = 0; i < 3; i++) {
            int guessNumber = guess.get(i);
            int answerNumber = answer.get(i);
            //스트라이크
            if(guessNumber == answerNumber) {
                strikesAndBalls[0]++;
            } else {
                isBall(guessNumber, isPicked, strikesAndBalls);
                isBall(answerNumber, isPicked, strikesAndBalls);
            }
        }
        return strikesAndBalls;
    }

    private void isBall(int input, boolean[] isPicked, int[] strikesAndBalls) {
        if(isPicked[input]) {
            strikesAndBalls[1]++;
        } else {
            isPicked[input] = true;
        }
    }
}
