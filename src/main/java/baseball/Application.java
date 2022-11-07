package baseball;

import java.util.ArrayList;
import java.util.Objects;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int gameControllerNumber;

        int errNumber = 0;
        int continueNumber = 1;
        int exitNumber = 2;

        do {
            System.out.println("숫자 야구 게임을 시작합니다!!!");
            ArrayList<Integer> generateAnswer = generateAnswer();
            System.out.println("정답은" + generateAnswer);
            gameControllerNumber = gameController(generateAnswer);
        } while (gameControllerNumber != exitNumber && gameControllerNumber != errNumber);
        System.out.println("게임 종료");
        if (gameControllerNumber == errNumber) {
            throw new IllegalArgumentException();
        }
    }

    private static int gameController(ArrayList<Integer> generateAnswer) {
        
        int gameControllerNumber;
        int errNumber = 0;

        ArrayList<Integer> inputUserValue;
        while (true) {
            inputUserValue = inputUserValue();
            if (inputUserValue.get(0) == errNumber) {
                gameControllerNumber = errNumber;
                break;
            }
            String compareAnswerAndValue = compareAnswerAndValue(generateAnswer, inputUserValue);
            System.out.println(compareAnswerAndValue);
            if (compareAnswerAndValue.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                gameControllerNumber = restart();
                break;
            }
        }
        return gameControllerNumber;
    }

    private static ArrayList<Integer> generateAnswer() {
        ArrayList<Integer> answerNumber = new ArrayList<>();
        while (answerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerNumber.contains(randomNumber)) {
                answerNumber.add(randomNumber);
            }
        }
        return answerNumber;
    }

    private static ArrayList<Integer> inputUserValue() {
        ArrayList<Integer> inputNumberArray = new ArrayList<>();
        String inputNumber = Console.readLine();
        int firstBall = 0;
        int secondBall = 1;
        int thirdBall = 2;
        int errNumber = 0;
        if (inputNumber.charAt(firstBall) == inputNumber.charAt(secondBall)
            || inputNumber.charAt(firstBall) == inputNumber.charAt(thirdBall)
            || inputNumber.charAt(secondBall) == inputNumber.charAt(thirdBall)
            || inputNumber.length() != 3
            || !Character.isDigit(inputNumber.charAt(firstBall))
            || !Character.isDigit(inputNumber.charAt(secondBall))
            || !Character.isDigit(inputNumber.charAt(thirdBall))
            || inputNumber.charAt(firstBall) == 0
            || inputNumber.charAt(secondBall) == 0
            || inputNumber.charAt(thirdBall) == 0 ) {
            inputNumberArray.add(errNumber);
            return inputNumberArray;
        }

        inputNumberArray.add(Character.getNumericValue(inputNumber.charAt(firstBall)));
        inputNumberArray.add(Character.getNumericValue(inputNumber.charAt(secondBall)));
        inputNumberArray.add(Character.getNumericValue(inputNumber.charAt(thirdBall)));

        return inputNumberArray;
    }

    private static String compareAnswerAndValue(ArrayList<Integer> generateAnswer, ArrayList<Integer> inputUserValue) {

        String answer = "";
        int strike = 0;
        int ball = 0;
        int firstBall = 0;
        int secondBall = 1;
        int thirdBall = 2;

        for (int j = 0; j < 3; j++) {
            if (Objects.equals((generateAnswer.get(firstBall)), inputUserValue.get(j)) && j == firstBall) {
                strike++;
            }
            if (Objects.equals((generateAnswer.get(firstBall)), inputUserValue.get(j)) && j != firstBall) {
                ball++;
            }
        }
        
        for (int j = 0; j < 3; j++) {
            if (Objects.equals((generateAnswer.get(secondBall)), inputUserValue.get(j)) && j == secondBall) {
                strike++;
            }
            if (Objects.equals((generateAnswer.get(secondBall)), inputUserValue.get(j)) && j != secondBall) {
                ball++;
            }
        }
        
        for (int j = 0; j < 3; j++) {
            if (Objects.equals((generateAnswer.get(thirdBall)), inputUserValue.get(j)) && j == thirdBall) {
                strike++;
            }
            if (Objects.equals((generateAnswer.get(thirdBall)), inputUserValue.get(j)) && j != thirdBall) {
                ball++;
            }
        }

        answer = outputInText(answer, strike, ball);

        return answer;
    }

    private static String outputInText(String answer, int strike, int ball) {
        if (strike == 0 && ball == 0) {
            answer += "낫싱";
        } else if (strike == 0) {
            answer += (ball + "볼");
        } else if (ball == 0) {
            answer += (strike + "스트라이크");
        } else {
            answer += (ball + "볼") + " " + (strike + "스트라이크");
        }
        return answer;
    }

    private static int restart() {
        System.out.println("계속하시겠습니까?1=계속,2=끝");
        int toBeContinue = Integer.parseInt(Console.readLine());
        int continueNumber = 1;
        int exitNumber = 2;

        if (toBeContinue != continueNumber && toBeContinue != exitNumber) {
            toBeContinue = exitNumber;
        }
        return toBeContinue;
    }
}

