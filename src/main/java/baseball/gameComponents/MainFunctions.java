package baseball.gameComponents;

import baseball.exception.ExceptionCode;
import baseball.exception.GameException;
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

    public boolean printExamineResult(int[] ballsAndStrikes) {
        validateBallsAndStrike(ballsAndStrikes);
        //하나도 맞추지 못한 경우
        if(ballsAndStrikes[0] == 0 && ballsAndStrikes[1] == 0) {
            System.out.println("낫싱");
            return false;
            //모두 맞춘 경우
        } else if(ballsAndStrikes[1] == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
            //그 외
        } else {
            System.out.print(ballsAndStrikes[0] + "볼 ");
            System.out.println(ballsAndStrikes[1] + "스트라이크");
            return false;
        }
    }

    private void validateBallsAndStrike(int[] ballsAndStrikes) {
        int balls = ballsAndStrikes[0];
        int strikes = ballsAndStrikes[1];

        if(ballsAndStrikes.length != 2
            || balls < 0 || balls > 3
            || strikes < 0 || strikes > 3|| balls + strikes > 3) {
            throw new GameException(ExceptionCode.BALLS_AND_STRIKES_NOT_VALID);
        }
    }
}
