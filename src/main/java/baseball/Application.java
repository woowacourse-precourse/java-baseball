package baseball;

import camp.nextstep.edu.missionutils.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String startText = "숫자 야구 게임을 시작합니다.";
        String askInputText = "숫자를 입력해주세요 : ";
        boolean newGame = false;

        printStartText(startText);
        do {
            int exitCode = 2;
            String input = "";
            List<Integer> computer = new ArrayList<>();
            boolean isCorrect = false;

            computer = createRandomNumber();
            do {
                List<Integer> user = new ArrayList<>();
                printAskInputText(askInputText);
                input = getInput();
                ableToParseInt(input); // 입력받은 문자열이 세자리 숫자로 변환이 가능한지 검증
                user = StringToIntegerList(input);// 검증 받은 문자열을 한자리씩 정수로 형변환 하고 리스트에 저장
                checkInputThreeDifferentNumber(user);
                isCorrect = compareAndPrintResult(computer, user);
            } while (!isCorrect);

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            input = getInput();
            checkInputOneOrTwo(input);
            exitCode = Integer.parseInt(input);

            if (exitCode == 1) {
                newGame = true;
            }
            if (exitCode == 2) {
                newGame = false;
            }
        } while (newGame);
        System.out.println("게임 종료");

    }

    private static void printStartText(String txt) {
        System.out.println(txt);
    }

    private static List<Integer> createRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static void printAskInputText(String txt) {
        System.out.printf(txt);
    }

    private static String getInput() {
        String input = "";
        input = Console.readLine();
        return input;
    }

    private static void ableToParseInt(String input) {
        try {
            int temp = 0;
            temp = Integer.parseInt(input);
        } catch (Exception e) {
            IllegalArgumentException exception = new IllegalArgumentException();
            throw exception;
        }
    }

    private static void checkInputThreeDifferentNumber(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numbers.size() != 3 || numberSet.size() != 3) {
            IllegalArgumentException exception = new IllegalArgumentException();
            throw exception;
        }
    }

    private static void checkInputOneOrTwo(String input) {
        int inputCode = 0;
        ableToParseInt(input);
        inputCode = Integer.parseInt(input);
        if (!(inputCode == 1 || inputCode == 2)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean compareAndPrintResult(List<Integer> computer, List<Integer> input) {
        boolean result = false;
        int strikeCount = 0;
        int ballCount = 0;
        for (int i = 0; i < input.size(); i++) {
            int sameNumberIndex = computer.indexOf(input.get(i)); // if not found, indexOf function will return -1
            if (sameNumberIndex == i && sameNumberIndex != -1) {
                strikeCount++;
            }
            if (sameNumberIndex != i && sameNumberIndex != -1) {
                ballCount++;
            }
        }
        printComparisonResult(strikeCount, ballCount);
        if (strikeCount == 3) {
            result = true;
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        return result;
    }

    private static void printComparisonResult(int strikeCount, int ballCount) {
        String printText = "";
        List<String> printTextList = new ArrayList<>();

        if (strikeCount == 0 && ballCount == 0) {
            printTextList.add("낫싱");
        }
        if (ballCount != 0) {
            printTextList.add(Integer.toString(ballCount) + "볼");
        }
        if (strikeCount != 0) {
            printTextList.add(Integer.toString(strikeCount) + "스트라이크");
        }

        for (int i = 0; i < printTextList.size(); i++) {
            if (printText != "") {
                printText += " " + printTextList.get(i);
            } else {
                printText += printTextList.get(i);
            }
        }

        System.out.println(printText);
    }

    private static List<Integer> StringToIntegerList(String input) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            result.add(Character.getNumericValue(input.charAt(i)));
        }
        return result;
    }
}
