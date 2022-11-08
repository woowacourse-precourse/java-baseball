package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Application {
    static List<Integer> computerRandomNumber;
    static List<Integer> playerInputNumber;
    static boolean restartFlag = true;

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        gameStart();
    }

    private static void gameStart() {
        computerRandomNumber = computerGetRandomNumber();
//        System.out.println(computerRandomNumber);

        playerTurn();
        gameRestart();
    }

    private static void gameRestart() {
        if (!restartFlag) {
            return;
        }

        boolean check = false;
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();

        if (Integer.valueOf(input).equals(1)) {
            check = true;
        }
        if (Integer.valueOf(input).equals(2)) {
            check = false;
        }

        if (check) {
            gameStart();
        }
    }

    private static void playerTurn() {
        boolean isNumberAvailable = playerInputCheck();
//        System.out.println("playerInputNumber 의 isNumberAvailable : " + isNumberAvailable);
        // 입력한 값이 잘못된 값이면 종료함
        if (!isNumberAvailable) {
            restartFlag = false;
            return;
        }

        // 결과값을 출력
        resultOutput();
    }

    private static void resultOutput() {
        int nothingCount = 0;
        int strikeCount = 0;
        int ballCount = 0;

        nothingCount = nothingOutput();

        if (nothingCount == 3) {
            System.out.println("낫싱");
        } else {
            strikeCount = strikeOutPut();
            ballCount = ballOutput(strikeCount);
        }

        makeResultSentence(strikeCount, ballCount);
        if (strikeCount != 3) {
            playerTurn();
        }
    }

    private static void makeResultSentence(int strikeCount, int ballCount) {
        StringBuilder sentence = new StringBuilder();

        if (strikeCount == 3) {
            sentence.append("3스트라이크 \n");
            sentence.append("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }

        if (ballCount != 0) {
            sentence.append(ballCount);
            sentence.append("볼 ");
        }

        if (1 <= strikeCount && strikeCount <= 2) {
            sentence.append(strikeCount);
            sentence.append("스트라이크");
        }

        System.out.println(sentence);
    }

    private static int nothingOutput() {
        int nothingCount = 0;

        for (int i = 0; i < 3; i++) {
            if (!computerRandomNumber.contains(playerInputNumber.get(i))) {
                nothingCount += 1;
            }
        }
//        System.out.println("nothingCount : " + nothingCount);
        return nothingCount;
    }

    private static int strikeOutPut() {
        int strikeCount = 0;

        for (int i = 0; i < 3; i++) {
            if (computerRandomNumber.get(i).equals(playerInputNumber.get(i))) {
                strikeCount += 1;
            }
        }
//        System.out.println("strikeCount : " + strikeCount);
        return strikeCount;
    }

    private static int ballOutput(int strikeCount) {
        int ballCount = 0;

        for (int i = 0; i < 3; i++) {
            if (computerRandomNumber.contains(playerInputNumber.get(i))) {
                ballCount += 1;
            }
        }
        ballCount = ballCount - strikeCount;
//        System.out.println("ballCount : " + ballCount);
        return ballCount;
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
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        boolean checkInput = true;

        if (isInteger(input)) {
            isLengthThree(input);
            isNumberDifferent(input);
        }
        return checkInput;
    }

    private static boolean isInteger(String input) {
        try {
            Integer.valueOf(input);
            return true;
        } catch (NumberFormatException e) {
//            System.out.println("숫자가 아닌 잘못된 값을 입력했습니다. 게임을 종료합니다.");
            e.printStackTrace();
            return false;
        }
    }

    private static void isLengthThree(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("숫자의 길이가 3이 아닌 잘못된 값을 입력했습니다. 게임을 종료합니다.");
        }
    }

    private static void isNumberDifferent(String input) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < input.length(); i++) {
            set.add(Integer.parseInt(String.valueOf(input.charAt(i))));
        }

        if (set.size() != 3) {
            throw new IllegalArgumentException("서로 다른 숫자가 아닌 잘못된 값을 입력했습니다. 게임을 종료합니다.");
        }
        playerInputNumber = new ArrayList<>(set);
    }
}
