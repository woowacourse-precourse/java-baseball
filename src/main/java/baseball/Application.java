package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Application {
    static List<Integer> computerRandomNumber;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        gameStart();
    }

    private static void gameStart() {
        computerRandomNumber = computerGetRandomNumber();
        System.out.println(computerRandomNumber);

        boolean isNumberAvailable = playerInputCheck();
        System.out.println("playerInputNumber 의 isNumberAvailable : " + isNumberAvailable);
        // 입력한 값이 잘못된 값이면 종료함
        if (!isNumberAvailable) {
            return;
        }

        // 결과값을 출력
        System.out.println("결과값 출력 예정");


        // 1이면 다시 시작, 2이면 종료료
    }

    private static List<Integer> computerGetRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static boolean playerInputCheck() {
        String input = Console.readLine();
        boolean checkInput = false;

        if (isInteger(input)) {
            checkInput = isLengthThree(input);
            System.out.println("isLengthThree 의 checkInput : " + checkInput);
            checkInput = isNumberDifferent(checkInput, input);
            System.out.println("isNumberDifferent 의 checkInput : " + checkInput);
        }
        return checkInput;
    }

    private static boolean isInteger(String input) {
        try {
            Integer.valueOf(input);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("숫자가 아닌 잘못된 값을 입력했습니다. 게임을 종료합니다.");
            e.printStackTrace();
            return false;
        }
    }

    private static boolean isLengthThree(String input) {
        boolean checkLength = true;
        try {
            if (input.length() != 3) {
                checkLength = false;
                System.out.println("숫자의 길이가 3이 아닌 잘못된 값을 입력했습니다. 게임을 종료합니다.");
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return checkLength;
    }

    private static boolean isNumberDifferent(boolean middleCheck, String input) {
        Set<Character> set = new LinkedHashSet<>();
        for (int i = 0; i < input.length(); i++) {
            set.add(input.charAt(i));
        }

        if (middleCheck) {
            middleCheck = isRepeat(set);
        }
        return middleCheck;
    }

    private static boolean isRepeat(Set<Character> set) {
        boolean checkRepeat = true;
        try {
            if (set.size() != 3) {
                checkRepeat = false;
                System.out.println("서로 다른 숫자가 아닌 잘못된 값을 입력했습니다. 게임을 종료합니다.");
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return checkRepeat;
    }
}
