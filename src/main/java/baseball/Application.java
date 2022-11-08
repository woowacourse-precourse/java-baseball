package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class Application {
    public static void main(String[] args) {

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
        String[] str = {"볼 ", "스트라이크 "};
        for (int i = 0; i < ballAndStrike.length; i++) {
            if (ballAndStrike[i] > 0) {
                System.out.println(ballAndStrike[i] + str[i]);
            }
        }
    }
}
