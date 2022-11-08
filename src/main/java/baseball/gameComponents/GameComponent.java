package baseball.gameComponents;

import baseball.exception.ExceptionCode;
import baseball.exception.GameException;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameComponent {
    private Validator validator;
    public GameComponent(Validator validator) {
        this.validator = validator;
    }
    public List<Integer> generateRandomNumber() {
        boolean[] isPicked = new boolean[10];
        List<Integer> randomNumber = new ArrayList<>();
        int index = 0;
        while(index < 3) {
            int num = Randoms.pickNumberInRange(1, 9);
            if (!isPicked[num]) {
                randomNumber.add(num);
                isPicked[num] = true;
                index++;
            }
        }
        return randomNumber;
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
    public boolean examineResultAndPrint(int[] ballsAndStrikes) {
        validator.validateBallsAndStrike(ballsAndStrikes);
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

    public boolean restartOrEndGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();

        if(input.equals("1")) {
            return true;
        } else if(input.equals("2")) {
            return false;
        } else {
            throw new GameException(ExceptionCode.ONLY_1_OR_2_POSSIBLE);
        }
    }

    public List<Integer> convertStringToList(String input) {
        List<Integer> list = Arrays.asList(input.split("")).stream()
                .mapToInt(str -> Integer.parseInt(str))
                .boxed()
                .collect(Collectors.toList());
        return list;
    }
}
