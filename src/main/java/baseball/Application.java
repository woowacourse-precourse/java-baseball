package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다");
        while (true) {
            List<Integer> randomNumber = createRandomNumber();
            while(true){
                System.out.print("숫자를 입력해주세요 : ");
                int inputNumber = Integer.parseInt(Console.readLine());
                checkInputCondition(inputNumber);

                List<Integer> listedInputNumber = convertIntegerIntoList(inputNumber);
//                System.out.println("randomNumber = " + randomNumber);

                int[] countResult = countBallsAndStrikes(randomNumber, listedInputNumber);
                String resultMessage = printResult(countResult);
                System.out.println(resultMessage);
                if (countResult[1] == 3) {
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

    private static void checkInputCondition(int inputNumber) {
        List<Integer> checkList = new ArrayList<>(3);
        String strNumber = String.valueOf(inputNumber);

        for (int i = 0; i < strNumber.length(); i++) {
            int target = Integer.parseInt(String.valueOf(strNumber.charAt(i)));
            if (!checkList.contains(target) && target > 0 && target <= 9) {
                checkList.add(target);
            }
        }

        if (strNumber.length() > 3 ||checkList.size() < 3) {
            throw new IllegalArgumentException();
        }
    }

    private static List<Integer> convertIntegerIntoList(int number) {
        String strNumber = String.valueOf(number);
        List<Integer> listNumber = new ArrayList<>();

        for (int i = 0; i < strNumber.length(); i++) {
            listNumber.add(Integer.parseInt(String.valueOf(strNumber.charAt(i))));
        }

        return listNumber;
    }

    private static int[] countBallsAndStrikes(List<Integer> answer, List<Integer> inputNumber) {
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

    private static String printResult(int[] countResult) {
        int ballCount = countResult[0];
        int strikeCount = countResult[1];

        StringBuilder outputStringBuilder = new StringBuilder();

        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
        } else if (ballCount > 0 && strikeCount > 0) {
            outputStringBuilder.append(ballCount);
            outputStringBuilder.append("볼 ");
            outputStringBuilder.append(strikeCount);
            outputStringBuilder.append("스트라이크");
        } else if (ballCount == 0 && strikeCount > 0) {
            outputStringBuilder.append(strikeCount);
            outputStringBuilder.append("스트라이크");
        } else if (ballCount > 0 && strikeCount == 0) {
            outputStringBuilder.append(ballCount);
            outputStringBuilder.append("볼");
        }

        return outputStringBuilder.toString();
    }
}
