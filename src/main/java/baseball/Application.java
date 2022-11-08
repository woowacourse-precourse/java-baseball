package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class Application {
    static int[] randomArr;
    static boolean checkRun;

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        randomArr = initRandomValue();
        checkRun = true;
        while (checkRun) {
            int inputValue = getInputValue();
            int[] ballAndStrike = compareToNum(inputValue, randomArr);
            printBallAndStrike(ballAndStrike);
            boolean correct = isCorrect(ballAndStrike);
            if (correct) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String oneAndTow = Console.readLine();
                checkOneAndTowCheck(oneAndTow);
                runOrEnd(oneAndTow);
            }
        }
    }

    static void runOrEnd(String oneAndTow) {
        int num = Integer.parseInt(oneAndTow);
        if (num == 1) {
            randomArr = initRandomValue();
        } else {
            checkRun = false;
        }
    }

    static void checkOneAndTowCheck(String str) {
        try {
            Integer.parseInt(str);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        if (!(Integer.parseInt(str) == 1 || Integer.parseInt(str) == 2)) {
            throw new IllegalArgumentException();
        }
    }

    static int getRandomValue() {
        Set<Integer> set = new HashSet<>();
        int result = 0;
        for (int i = 0; i < 3; i++) {
            int random = Randoms.pickNumberInRange(1, 9);
            if (set.contains(random)) {
                i--;
            } else {
                result = result * 10 + random;
                set.add(random);
            }
        }
        return result;
    }

    static boolean validationOfInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            return false;
        }
        if (input.length() != 3) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        int intInput = Integer.parseInt(input);
        for (int i = 0; i < 3; i++) {
            set.add(intInput % 10);
            intInput /= 10;
        }
        if (set.size() != 3) {
            return false;
        }
        return true;
    }

    static int getInputValue() {
        System.out.println("숫자를 입력해 주십시오.");
        String input = Console.readLine();
        boolean valid = validationOfInput(input);
        if (!valid) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(input);
    }

    static int[] getIntToArr(int num) {
        int[] arr = new int[10];
        for (int i = 0; i < 3; i++) {
            arr[num % 10] = i + 1;
            num /= 10;
        }
        return arr;
    }

    static int[] initRandomValue() {
        int randomValue = getRandomValue();
        return getIntToArr(randomValue);
    }

    static int[] compareToNum(int input, int[] randomArr) {
        int[] result = new int[2];
        for (int i = 0; i < 3; i++) {
            int num = input % 10;
            input /= 10;
            if (randomArr[num] == i + 1) {
                result[1]++;
            } else if (randomArr[num] > 0) {
                result[0]++;
            }
        }
        return result;
    }

    static void printBallAndStrike(int[] ballAndStrike) {
        String[] str = {"볼 ", "스트라이크\n"};
        boolean check = true;
        for (int i = 0; i < ballAndStrike.length; i++) {
            if (ballAndStrike[i] > 0) {
                System.out.print(ballAndStrike[i] + str[i]);
                check = false;
            }
        }
        if(check){
            System.out.println("낫싱");
        }
    }

    static boolean isCorrect(int[] ballAndStrike) {
        if (ballAndStrike[1] == 3) {
            return true;
        }
        return false;
    }
}
