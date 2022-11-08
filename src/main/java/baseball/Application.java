package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.ResultResponse.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다");
        while (true) {
            List<Integer> randomNumber = createRandomNumber();
            while(true){
                System.out.print("숫자를 입력해주세요 : ");
                String inputNumber = Console.readLine();
                checkInputCondition(inputNumber);

                List<Integer> listedInputNumber = convertIntegerIntoList(inputNumber);

                int[] countResult = countBallsAndStrikes(randomNumber, listedInputNumber);
                String resultMessage = getResultMessage(countResult);
                System.out.println(resultMessage);

                if (resultMessage.equals("3스트라이크")) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            int exitCode = Integer.parseInt(Console.readLine());
            if (exitCode == 2) {
                break;
            }
        }
    }

    private static List<Integer> createRandomNumber() {
        List<Integer> createdNumber = new ArrayList<>();
        while (createdNumber.size() != 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!createdNumber.contains(randomNumber)) {
                createdNumber.add(randomNumber);
            }
        }

        return createdNumber;
    }

    static void checkInputCondition(String inputNumber) {
        if (inputNumber.equals("")) {
            throw new IllegalArgumentException();
        }

        List<Integer> checkList = new ArrayList<>(3);

        for (int i = 0; i < inputNumber.length(); i++) {
            int target = Integer.parseInt(String.valueOf(inputNumber.charAt(i)));
            if (!checkList.contains(target) && target > 0 && target <= 9) {
                checkList.add(target);
            }
        }

        if (inputNumber.length() != 3 || checkList.size() < 3) {
            throw new IllegalArgumentException();
        }
    }

    static List<Integer> convertIntegerIntoList(String number) {
        List<Integer> listNumber = new ArrayList<>();

        for (int i = 0; i < number.length(); i++) {
            listNumber.add(Integer.parseInt(String.valueOf(number.charAt(i))));
        }

        return listNumber;
    }

    static int[] countBallsAndStrikes(List<Integer> answer, List<Integer> inputNumber) {
        int[] returnArr = new int[2];
        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < 3; i++) {
            if (answer.get(i) == inputNumber.get(i)) {
                strikeCount++;
            } else if (answer.get(i) != inputNumber.get(i) && answer.contains(inputNumber.get(i))) {
                ballCount++;
            }
        }

        returnArr[0] = ballCount;
        returnArr[1] = strikeCount;

        return returnArr;
    }

    static String getResultMessage(int[] countResult) {
        int ballCount = countResult[0];
        int strikeCount = countResult[1];
        String resultMessage = "";

        if (ballCount == 0 && strikeCount == 0) {
            resultMessage = NOTHING.getResultMessage();
        } else if (ballCount == 1 && strikeCount == 0) {
            resultMessage = ONE_BALL.getResultMessage();
        } else if (ballCount == 1 & strikeCount == 1) {
            resultMessage = ONE_BALL_ONE_STRIKE.getResultMessage();
        } else if (ballCount == 1 && strikeCount == 2) {
            resultMessage = ONE_BALL_TWO_STRIKE.getResultMessage();
        } else if (ballCount == 2 && strikeCount == 0) {
            resultMessage = TWO_BALL.getResultMessage();
        } else if (ballCount == 2 && strikeCount == 1) {
            resultMessage = TWO_BALL_ONE_STRIKE.getResultMessage();
        } else if (ballCount == 0 && strikeCount == 1) {
            resultMessage = ONE_STRIKE.getResultMessage();
        } else if (ballCount == 0 && strikeCount == 2) {
            resultMessage = TWO_STRIKE.getResultMessage();
        } else if (ballCount == 3 && strikeCount == 0) {
            resultMessage = THREE_BALL.getResultMessage();
        } else if (ballCount == 0 && strikeCount == 3) {
            resultMessage = THREE_STRIKE.getResultMessage();
        }
        return resultMessage;
    }
}
