package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다. ");

        while (true) {
            List<Integer> computer = createRandomNumbers();

        }

    }

    private static void startGame(List<Integer> computer) {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");

            int[] inputNumbers = getThreeInts();

        }
    }

    private static int[] getThreeInts() {
        String input = Console.readLine();

        int inputNumber = Integer.parseInt(input);
        int[] inputNumbers = new int[3];

        inputNumbers[0] = inputNumber / 100;
        inputNumbers[1] = (inputNumber / 10) % 10;
        inputNumbers[2] = inputNumber % 10;
        
        return inputNumbers;
    }

    public static List<Integer> createRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }
}
