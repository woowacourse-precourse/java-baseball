package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현


    }

    public static List<Integer> createAnswer() {
        List<Integer> answerNumbers = new ArrayList<>();


        while(answerNumbers.size() < 3) {
            int number = Randoms.pickNumberInRange(0, 9);
            if (!answerNumbers.contains(number)) {
                answerNumbers.add(number);
            }
        }
        return answerNumbers;
    }


    public static List<Integer> getInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputString = Console.readLine();
        List<Integer> inputList = Arrays.stream(inputString.split("")).map(Integer::parseInt).collect(Collectors.toList());
        validateInput(inputList);
        return inputList;
    }

    public static boolean validateInput(List<Integer> inputList) {
        List<Integer> allowedInputNumber = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        Set<Integer> inputSet = new HashSet<>(inputList);

        for (Integer eachInputNumber : inputList) {
            if (!allowedInputNumber.contains(eachInputNumber)) {
                throw new IllegalArgumentException("out of range input");
            } else if (inputList.size() != inputSet.size()) {
                throw new IllegalArgumentException("number of unique input integer  is not 3");
            }
        }

        return true;

    }

    public static List<Integer> compareAnswerToInput(List<Integer> answer, List<Integer> input) {
        int strikeCount=0;
        int ballCount = 0;

        for (int integerPosition = 0; integerPosition < answer.size(); integerPosition++) {
            if (answer.get(integerPosition) == input.get(integerPosition)) {
                strikeCount++;
            }

            if (answer.contains(input.get(integerPosition))) {
                ballCount++;
            }
        }

        ballCount = ballCount - strikeCount;
        List<Integer> comparisonResult = Arrays.asList(ballCount, strikeCount);

        return comparisonResult;

    }

    public static String printBallAndStrike(List<Integer> ballAndStrike) {
        String message = "";
        Integer ball = ballAndStrike.get(0);
        Integer strike = ballAndStrike.get(1);
        String ballMessage="";
        String strikeMessage="";
        if (ball > 0) {
            ballMessage = String.valueOf(ball) + "볼";
        }
        if (strike > 0) {
            strikeMessage = String.valueOf(strike) + "스트라이크";
        }

        if (ball > 0 && strike == 0) {
            return ballMessage;
        } else if (ball==0 && strike>0) {
            return strikeMessage;
        } else if (ball > 0 && strike > 0) {
            return ballMessage + " " + strikeMessage;
        } else if (ball == 0 && strike == 0) {
            return "낫싱";
        } else {
            throw new IllegalStateException("ball <0 && strike <0");
        }
    }

}
