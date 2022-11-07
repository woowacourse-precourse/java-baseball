package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    static boolean endGameState() {
        System.out.println("3개의 숫자를 모두 맟히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String myNumber = Console.readLine();
        if (myNumber.equals("1")) {
            return true;
        }
        if (myNumber.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException();
    }

    static List<Integer> compareNumber(List<Integer> computerNum, String myNum, Integer myIdx) {
        List<Integer> ballcount = Arrays.asList(0, 0);
        int myCompareNum = Character.getNumericValue(myNum.charAt(myIdx));
        int comCompareNum;
        for (int comIdx = 0; comIdx < 3; comIdx++) {
            comCompareNum = computerNum.get(comIdx);
            if (myCompareNum == comCompareNum && myIdx != comIdx) {
                ballcount.set(0, 1);
            }
            if (myCompareNum == comCompareNum && myIdx == comIdx) {
                ballcount.set(1, 1);
            }
        }
        return ballcount;
    }

    static boolean printResult(int ball, int strike) {
        if (strike == 3) {
            System.out.println("3스트라이크");
            return true;
        }
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return false;
        }
        if (strike == 0) {
            System.out.println(ball + "볼");
            return false;
        }
        if (ball == 0) {
            System.out.println(strike + "스트라이크");
            return false;
        }

        System.out.println(ball + "볼 " + strike + "스트라이크");
        return false;
    }

    static boolean playGame(List<Integer> computerNum, String myNum) {
        int ball = 0;
        int strike = 0;
        for (int myIdx = 0; myIdx < myNum.length(); myIdx++) {
            List<Integer> ballcount = compareNumber(computerNum, myNum, myIdx);
            if (ballcount.get(0) == 1) {
                ball += 1;
            }
            if (ballcount.get(1) == 1) {
                strike += 1;
            }
        }
        return printResult(ball, strike);
    }

    static void checkInputRule(String myNumber) {
        // 입력받은 값이 3자리인지
        if (myNumber.length() != 3) {
            throw new IllegalArgumentException();
        }

        // 각 자리가 1~9까지의 수로 이루어져 있는지
        int chkNum;
        for (int numIdx = 0; numIdx < myNumber.length(); numIdx++) {
            chkNum = Character.getNumericValue(myNumber.charAt(numIdx));
            if (chkNum < 1 || chkNum > 9) {
                throw new IllegalArgumentException();
            }
        }

        // 각 자리가 서로 다른 숫자인지
        if (myNumber.charAt(0) == myNumber.charAt(1)) {
            throw new IllegalArgumentException();
        }
        if (myNumber.charAt(0) == myNumber.charAt(2)) {
            throw new IllegalArgumentException();
        }
        if (myNumber.charAt(1) == myNumber.charAt(2)) {
            throw new IllegalArgumentException();
        }
    }

    static String pickMyNum() throws IllegalArgumentException {
        try {
            System.out.print("숫자를 입력해주세요 : ");
            String myNumber = Console.readLine();
            checkInputRule(myNumber);
            return myNumber;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    static List<Integer> pickComputerNum() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    static boolean startGameState() throws IllegalArgumentException {
        try {
            List<Integer> computerNum = pickComputerNum();
            boolean isWin = false;
            while (!isWin) {
                String myNum = pickMyNum();
                isWin = playGame(computerNum, myNum);
            }
            return endGameState();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }

    }

    static void startApplicationState() throws IllegalArgumentException {
        // 리턴값에 따라 반복 여부 결정 필요
        try {
            boolean againGame = true;
            while (againGame) {
                againGame = startGameState();
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }

    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        try {
            startApplicationState();
        } catch (IllegalArgumentException e) {
            System.out.println("게임 종료");
            throw new IllegalArgumentException();
        }
        System.out.println("게임 종료");
    }
}
