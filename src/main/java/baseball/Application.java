package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            String stringQuizNumber = getStringQuizNumber();

            while (isNotEqualNumber(getUserInput(), stringQuizNumber)) {
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            if (doesUserWantToStop()) {
                break;
            }
        }
    }

    public static boolean isNotEqualNumber(String userInput, String stringQuizNumber) {
        if (userInput.equals(stringQuizNumber)) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        }

        List<Integer> numberList = new ArrayList<Integer>();
        for (int i = 0; i < stringQuizNumber.length(); i++) {
            numberList.add(stringQuizNumber.charAt(i) - '0');
        }

        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < stringQuizNumber.length(); i++) {
            int eachUserInputNum = userInput.charAt(i) - '0';

            if (eachUserInputNum == numberList.get(i)) {
                strikeCount++;
            } else if (numberList.contains(eachUserInputNum)) {
                ballCount++;
            }
        }

        String ballInfo = String.format("%d볼", ballCount);
        String strikeInfo = String.format("%d스트라이크", strikeCount);

        List<String> msgList = new ArrayList<String>();

        if (ballCount != 0) {
            msgList.add(ballInfo);
        }

        if (strikeCount != 0) {
            msgList.add(strikeInfo);
        }

        if (msgList.isEmpty()) {
            System.out.println("낫싱");
        } else {
            System.out.println(String.join(" ", msgList));
        }

        return true;
    }

    private static String getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = readLine();
        if (validateUserInput(userInput)) {
            return userInput;
        } else {
            throw new IllegalArgumentException("잘못된 입력을 하셨습니다. 숫자 3자리만 입력해주세요");
        }
    }

    private static boolean doesUserWantToStop() {
        String userInput = readLine();
        if (userInput.equals("1")) {
            return false;
        } else if (userInput.equals("2")) {
            return true;
        } else {
            throw new IllegalArgumentException("잘못된 입력을 하셨습니다. 1 혹은 2를 입력해주세요");
        }
    }

    private static boolean validateUserInput(String userInput) {
        if (userInput.length() != 3) {
            return false;
        }

        List<Integer> numberList = new ArrayList<>();

        for (int idx = 0; idx < userInput.length(); idx++) {
            int eachNum = userInput.charAt(idx) - '0';

            if (eachNum < 1 || eachNum > 9) {
                return false;
            }

            if (!numberList.contains(eachNum)) {
                numberList.add(eachNum);
            } else {
                return false;
            }
        }

        return true;
    }

    public static String getStringQuizNumber() {
        List<Integer> quizEachNumList = new ArrayList<>();

        while (quizEachNumList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!quizEachNumList.contains(randomNumber)) {
                quizEachNumList.add(randomNumber);
            }
        }

        StringBuilder returnString = new StringBuilder();
        for (Integer integer : quizEachNumList) {
            returnString.append(integer);
        }

        return returnString.toString();
    }
}
