package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다");
            System.out.print("숫자를 입력해주세요 : ");
            int inputNumber = Integer.parseInt(Console.readLine());


            try {
                checkInputCondition(inputNumber);
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 입력입니다");
            }

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
}
