package baseball;

import java.util.ArrayList;
import java.util.Objects;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ArrayList<Integer> inputUserNumber;
        int restartNumber;
        do {
            System.out.println("숫자 야구 게임을 시작합니다!!!");
            ArrayList<Integer> generateAnswer = generateAnswer();
            System.out.println("정답은" + generateAnswer);
            restartNumber = getRestartNumber(generateAnswer);
        } while (restartNumber != 2 && restartNumber != 0);
        System.out.println("게임 종료");
        if (restartNumber == 0) {
            throw new IllegalArgumentException();
        }
    }

    private static int getRestartNumber(ArrayList<Integer> generateAnswer) {
        int restartNumber;
        ArrayList<Integer> inputUserNumber;
        while (true) {
            inputUserNumber = inputUserNumber();
            if (inputUserNumber.get(0) == 0) {
                restartNumber = 0;
                break;
            }
            String numberReferee = numberReferee(generateAnswer, inputUserNumber);
            System.out.println(numberReferee);
            if (numberReferee.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                restartNumber = restart();
                break;
            }
        }
        return restartNumber;
    }

    public static ArrayList<Integer> generateAnswer() {
        ArrayList<Integer> answerNumber = new ArrayList<>();
        while (answerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerNumber.contains(randomNumber)) {
                answerNumber.add(randomNumber);
            }
        }
        return answerNumber;
    }

    public static ArrayList<Integer> inputUserNumber() {
        ArrayList<Integer> inputNumberArray = new ArrayList<>();
        String inputNumber = Console.readLine();

        if (inputNumber.charAt(0) == inputNumber.charAt(1) || inputNumber.charAt(0) == inputNumber.charAt(2)
            || inputNumber.charAt(1) == inputNumber.charAt(2) || inputNumber.length() != 3
            || !Character.isDigit(inputNumber.charAt(0)) || !Character.isDigit(inputNumber.charAt(1))
            || !Character.isDigit(inputNumber.charAt(2)) || inputNumber.charAt(0) == 0 || inputNumber.charAt(1) == 0
            || inputNumber.charAt(2) == 0) {
            inputNumberArray.add(0);

            return inputNumberArray;
        }

        inputNumberArray.add(Character.getNumericValue(inputNumber.charAt(0)));
        inputNumberArray.add(Character.getNumericValue(inputNumber.charAt(1)));
        inputNumberArray.add(Character.getNumericValue(inputNumber.charAt(2)));

        return inputNumberArray;
    }

    public static String numberReferee(ArrayList<Integer> generateAnswer, ArrayList<Integer> inputUserNumber) {

        String answer = "";
        int strike = 0;
        int ball = 0;
        int firstBall = 0;
        int secondBall = 1;
        int thirdBall = 2;

        for (int j = 0; j < 3; j++) {
            if (Objects.equals((generateAnswer.get(firstBall)), inputUserNumber.get(j)) && j == firstBall) {
                strike++;
            }
            if (Objects.equals((generateAnswer.get(firstBall)), inputUserNumber.get(j)) && j != firstBall) {
                ball++;
            }
        }
        for (int j = 0; j < 3; j++) {
            if (Objects.equals((generateAnswer.get(secondBall)), inputUserNumber.get(j)) && j == secondBall) {
                strike++;
            }
            if (Objects.equals((generateAnswer.get(secondBall)), inputUserNumber.get(j)) && j != secondBall) {
                ball++;
            }
        }
        for (int j = 0; j < 3; j++) {
            if (Objects.equals((generateAnswer.get(thirdBall)), inputUserNumber.get(j)) && j == thirdBall) {
                strike++;
            }
            if (Objects.equals((generateAnswer.get(thirdBall)), inputUserNumber.get(j)) && j != thirdBall) {
                ball++;
            }
        }

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

    public static int restart() {
        System.out.println("계속하시겠습니까?1=계속,2=끝");
        int toBeContinue = Integer.parseInt(Console.readLine());
        if (toBeContinue != 1 && toBeContinue != 2) {
            toBeContinue = 2;
        }
        return toBeContinue;
    }
}

