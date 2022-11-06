package baseball.gameComponents;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class MainFunctions {
    public List<Integer> generateRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }

    public int[] examineGuess(List<Integer> guess, List<Integer> answer) {
        //0번째 값 : ball;
        //1번째 값 : strike;
        int[] ballsAndStrikes = new int[2];
        boolean[] isPicked = new boolean[10];
        for(int i = 0; i < 3; i++) {
            int guessNumber = guess.get(i);
            int answerNumber = answer.get(i);
            //스트라이크
            if(guessNumber == answerNumber) {
                ballsAndStrikes[1]++;
            } else {
                isBall(guessNumber, isPicked, ballsAndStrikes);
                isBall(answerNumber, isPicked, ballsAndStrikes);
            }
        }
        return ballsAndStrikes;
    }

    private void isBall(int input, boolean[] isPicked, int[] ballsAnsStrikes) {
        if(isPicked[input]) {
            ballsAnsStrikes[0]++;
        } else {
            isPicked[input] = true;
        }
    }
}
