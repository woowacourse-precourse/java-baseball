package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    final static int DIGIT_1 = 0;
    final static int DIGIT_10 = 1;
    final static int DIGIT_100 = 2;

    final static int STRIKE = 0;
    final static int BALL = 1;
    final static int NOTHING = 2;

    public static List<Integer> computerDigitValue;

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean gameOver = false;
        while (!gameOver) {
            gameStart();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String userInput;
            try {
                userInput = camp.nextstep.edu.missionutils.Console.readLine();
            } catch (IllegalArgumentException e) {
                return;
            }
            if (userInput.equals("2")) {
                gameOver = true;
            }
        }
    }

    public static void gameStart() throws IllegalArgumentException {
        int randomNumber = getRandomThreeDigitNumber();
        computerDigitValue = disassembleDigitNumber(randomNumber);

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            int userInput = Integer.parseInt(camp.nextstep.edu.missionutils.Console.readLine());
            isValidData(userInput);
            List<Integer> result = compareUserInputAndComputerSelect(userInput);
            String resultString = getResultString(result);
            System.out.println(resultString);
            if (resultString.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    public static String getResultString(List<Integer> result) {
        int strike = result.get(STRIKE);
        int ball = result.get(BALL);
        int nothing = result.get(NOTHING);
        String resultString = "";

        if (nothing == 3) {
            return "낫싱";
        }
        if (ball > 0) {
            resultString = String.format("%d볼", ball);
        }
        if (strike > 0) {
            resultString = String.format("%d스트라이크", strike);
        }
        if (ball > 0 && strike > 0) {
            resultString = String.format("%d볼 %d스트라이크", ball, strike);
        }

        return resultString;
    }


    public static List<Integer> compareUserInputAndComputerSelect(int userInput) {
        List<Integer> point = new ArrayList<>(Arrays.asList(0, 0, 0));
        List<Integer> disassembledNumber = disassembleDigitNumber(userInput);
        for (int digit = DIGIT_1; digit <= DIGIT_100; digit++) {
            int number = disassembledNumber.get(digit);
            int result = getScore(number, digit);
            int p = point.get(result) + 1;
            point.set(result, p);
        }

        return point;
    }

    public static int getScore(int number, int DIGIT) {
        if (computerDigitValue.get(DIGIT) == number) {
            return STRIKE;
        }
        if (computerDigitValue.contains(number)) {
            return BALL;
        } else {
            return NOTHING;
        }
    }

    public static boolean isValidData(int userInput) throws IllegalArgumentException {
        List<Integer> disassembledNumber = disassembleDigitNumber(userInput);
        if (disassembledNumber.size() != 3) {
            throw new IllegalArgumentException();
        }

        List<Integer> duplicatedList = new ArrayList<>();
        for (int number : disassembledNumber) {
            if (duplicatedList.contains(number)) {
                throw new IllegalArgumentException();
            }
            duplicatedList.add(number);
        }

        return true;
    }

    public static List<Integer> toPlaceValue(List<Integer> disassembledNumber) {
        List<Integer> placeValue = new ArrayList<Integer>();
        int digit = 1;
        for (int number : disassembledNumber) {
            placeValue.add(number * digit);
            digit *= 10;
        }

        return placeValue;
    }

    public static List<Integer> disassembleDigitNumber(int number) {
        List<Integer> disassembledNumber = new ArrayList<Integer>();
        for (; number > 0; number /= 10) {
            disassembledNumber.add(number % 10);
        }

        return disassembledNumber;
    }

    public static int getRandomThreeDigitNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        int randomValue = 0;
        for (int number : computer) {
            randomValue = randomValue * 10 + number;
        }

        return randomValue;
    }
}
