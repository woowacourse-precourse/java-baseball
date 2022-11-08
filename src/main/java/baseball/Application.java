package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static boolean checkPickNumbInMakingNum(List<Integer> nowMakingNumber, int pickRandomNum) {
        for (int i : nowMakingNumber) {
            if (i == pickRandomNum) {
                return false;
            }
        }
        return true;
    }

    public static String makeRandomNumber() {
        List<Integer> nowMakingNum = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int randNum = pickNumberInRange(1, 9);

            if (checkPickNumbInMakingNum(nowMakingNum, randNum)) {
                nowMakingNum.add(randNum);
            } else {
                i--;
            }
        }

        String makeNumber = nowMakingNum.toString().replaceAll("[^0-9]", "");

        return makeNumber;
    }

    static boolean checkInputAllNumber(String Input) {
        int asciiOne = (int) '1';
        int asciiNine = (int) '9';

        for (int k = 0; k < 3; k++) {
            int separatedNum = (int) Input.charAt(k);

            if (separatedNum < asciiOne || separatedNum > asciiNine) {
                return false;
            }
        }
        return true;
    }

    static boolean checkInputLength(String Input) {
        if (Input.length() != 3) {
            return false;
        }
        return true;
    }

    static boolean checkInputSameNumber(String Input) {
        int allSameNum = 0;

        for (int k = 0; k < 3; k++) {
            int SameNumCount = Input.length() - Input.replace(String.valueOf(Input.substring(k, k + 1)), "").length();
            allSameNum += SameNumCount;
        }

        if (allSameNum != 3) {
            return false;
        }

        return true;
    }

    static void checkInput(String Input) {
        if (!checkInputLength(Input)) {
            throw new IllegalArgumentException();
        } else if (!checkInputAllNumber(Input)) {
            throw new IllegalArgumentException();
        } else if (!checkInputSameNumber(Input)) {
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> checkNumStrike(String nowRandomNumber, String userInputNum) {
        List<Integer> printList = Arrays.asList(0, 0);

        for (int i = 0; i < 3; i++) {
            if (nowRandomNumber.charAt(i) == userInputNum.charAt(i)) {
                printList.set(1, printList.get(1) + 1);
            }
        }
        return printList;
    }

    public static List<Integer> checkNumBall(String currentRandomNumber, String inputRandomNum, List<Integer> printList) {
        for (int i = 0; i < 3; i++) {
            if (currentRandomNumber.contains(String.valueOf(inputRandomNum.charAt(i)))) {
                printList.set(0, printList.get(0) + 1);
            }
        }

        printList.set(0, printList.get(0) - printList.get(1));

        return printList;
    }

    public static int printBallStrike(List<Integer> printList) {
        int endValue = 0;

        if (printList.get(1) == 0 && printList.get(0) == 0) {
            System.out.println("낫싱");
        } else if (printList.get(1) == 0) {
            System.out.println(printList.get(0) + "볼");
        } else if (printList.get(0) == 0 && printList.get(1) == 3) {
            System.out.println(printList.get(1) + "스트라이크");
            endValue = 1;
        } else if (printList.get(0) == 0) {
            System.out.println(printList.get(1) + "스트라이크");
        } else {
            System.out.println(printList.get(0) + "볼 " + printList.get(1) + "스트라이크");
        }

        return endValue;
    }

    public static void playGame() {
        int endValue = 0;

        System.out.println("숫자 야구 게임을 시작합니다.");
        String randomNum = makeRandomNumber();

        while (endValue == 0) {
            System.out.println("숫자를 입력해주세요 : ");

            String inputNum = readLine();
            checkInput(inputNum);

            List<Integer> printList;
            printList = checkNumStrike(randomNum, inputNum);
            printList = checkNumBall(randomNum, inputNum, printList);

            endValue = printBallStrike(printList);
        }
    }
}
