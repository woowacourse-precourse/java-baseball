package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.IntStream;
import javax.lang.model.type.ArrayType;


class BaseBallGame {
    private static BaseBallGame gameProgram = new BaseBallGame();
    private static int GOAL = 3;
    private static int ZERO = 0;

    private BaseBallGame() {
    }

    public static BaseBallGame getGame() {
        return gameProgram;
    }

    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void gamePlaying() {
        try {
            String computerNumber = getRandomDiff3DigitNumber();
            boolean isSolved = false;
            while (!isSolved) {
                isSolved = solvingProblem(computerNumber);
            }
            if (reStartGame()) {
                gamePlaying();
            }
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public boolean reStartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String answerToReplay = Console.readLine();

        if (!answerToReplay.equals("1") && !answerToReplay.equals("2")) {
            throw new IllegalArgumentException("재시작에 대한 입력이 잘못되었습니다.");
        }

        if (answerToReplay.equals("1")) {
            return true;
        }
        System.out.println("게임 종료");
        return false;
    }

    public boolean solvingProblem(String computerNumber) {
        String userNumber = inputNumber();
        int ball, strike;
        List<Integer> hint = getHint(userNumber, computerNumber);
        ball = hint.get(0);
        strike = hint.get(1);

        return getSolveResult(strike, ball);

    }

    public boolean getSolveResult(int strike, int ball) {
        if (strike == GOAL) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        if (ball == ZERO && strike == ZERO) {
            System.out.println("낫싱");
        } else {
            if (ball == ZERO) {
                System.out.println(strike + "스트라이크");
            } else if (strike == ZERO) {
                System.out.println(ball + "볼");
            } else {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            }
        }

        return false;

    }


    public String inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputStr = Console.readLine();
        inputValidation(inputStr);
        return inputStr;
//        return Integer.parseInt(inputStr);
    }

    public void inputValidation(String inputStr) {
        if (!is3DigitNumber(inputStr) || !isDiffDigitNumber(inputStr)) {
            throw new IllegalArgumentException("서로 다른 세자리 수를 입력해주세요.");
        }
    }

    public boolean is3DigitNumber(String inputStr) {
        String inputNumberRegex = "^[1-9]{3}$";
        if (!inputStr.matches(inputNumberRegex)) {
            return false;
        }
        return true;
    }


    public boolean isDiffDigitNumber(String inputStr) {
        HashSet<String> removeDuplStr = new HashSet<String>(Arrays.asList(inputStr.split("")));
        if (removeDuplStr.size() != 3) {
            return false;
        }
        return true;
    }

    public String getRandomDiff3DigitNumber() {
        String randomDiff3DigitNumber = "";

        while (randomDiff3DigitNumber.length() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomDiff3DigitNumber.contains(Integer.toString(randomNumber))) {
                randomDiff3DigitNumber += Integer.toString(randomNumber);
            }
        }

//        return Integer.parseInt(randomDiff3DigitNumber);
        return randomDiff3DigitNumber;
    }

    public List<Integer> ballAndStrikeCount(List<String> userNumList, List<String> computerNumList) {
        int strike = 0;
        int ball = 0;
        List<Integer> ballAndStrike = new ArrayList<Integer>();
        int numLength = userNumList.size();

        for (int listIdx = 0; listIdx < numLength; listIdx++) {
            if (userNumList.get(listIdx).equals(computerNumList.get(listIdx))) {
                strike++;
            }
            if (userNumList.get(listIdx).equals(computerNumList.get((listIdx + 1) % numLength))
                    || userNumList.get(listIdx).equals(computerNumList.get((listIdx + 2) % numLength))
            ) {
                ball++;
            }

        }
        ballAndStrike.add(ball);
        ballAndStrike.add(strike);
        return ballAndStrike;
    }


    public List<Integer> getHint(String userNumber, String computerNumber) {
        List<String> userNumList = new ArrayList<String>(
                Arrays.asList(userNumber.split("")));
        List<String> computerNumList = new ArrayList<String>(
                Arrays.asList(computerNumber.split("")));

        List<Integer> ballAndStrikeList = ballAndStrikeCount(userNumList, computerNumList);

        return ballAndStrikeList;
    }


}
