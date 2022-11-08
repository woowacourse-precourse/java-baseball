package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

class BullsAndCows {
    List<Integer> computerNumber;
    BullsAndCowsResult bullsAndCowsResult;

    private static List<Integer> creatRandomNumber() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    public BullsAndCows(BullsAndCowsResult bullsAndCowsResult) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        this.bullsAndCowsResult = bullsAndCowsResult;
        computerNumber = creatRandomNumber();
    }

    void start() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        List<Integer> userInputNumber = checkExceptionAndInputToList(userInput);

        bullsAndCowsResult.init();

        for (int i = 0; i < computerNumber.size(); i++) {
            int userIndex = findNumberIndex(userInputNumber, computerNumber.get(i));
            bullsAndCowsResult.addCount(userIndex, i);
        }

        bullsAndCowsResult.printResult();
    }

    boolean isContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String answer = Console.readLine();

        return answer.equals("1");
    }

    public static int findNumberIndex(List<Integer> userInputNumber, int c) {
        if (userInputNumber.contains(c)) {
            return userInputNumber.indexOf(c);
        } else {
            return -1;
        }
    }

    public static List<Integer> checkExceptionAndInputToList(String userInput) throws IllegalArgumentException {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자가 아닙니다.");
        }

        List<Integer> userInputNumber = new ArrayList<>();

        char[] charArray = userInput.toCharArray();

        for (char c : charArray) {
            int number = (int) c - '0';

            if (!isValidNumber(number)) {
                throw new IllegalArgumentException("1 ~ 9 사이 숫자가 아닙니다.");
            }

            if (userInputNumber.contains(number)) {
                throw new IllegalArgumentException("서로 다른 숫자가 아닙니다.");
            }

            userInputNumber.add(number);
        }

        return userInputNumber;
    }

    public static boolean isValidNumber(int number) {
        return 1 <= number && number <= 9;
    }
}
