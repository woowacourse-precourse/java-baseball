package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.lang.model.type.ArrayType;


class BaseBallGame {
    private static BaseBallGame gameProgram = new BaseBallGame();
    private static String GAME_START = "숫자 야구 게임을 시작합니다.";
    private static String QUESTIONS_ABOUT_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static String RESTART = "1";
    private static String EXIT = "2";
    private static String GAME_FINISH = "게임 종료";
    private static String INPUT_ERROR_ABOUT_RESTART = "재시작에 대한 입력이 잘못되었습니다.";
    private static String INPUT_ERROR_ABOUT_USER_NUMBER = "서로 다른 세자리 수를 입력해주세요.";
    private static String CORRECT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static String STRIKE = "스트라이크";
    private static String BALL = "볼";
    private static String NOTHING = "낫싱";
    private static String INPUT_YOUR_NUMBER = "숫자를 입력해주세요 : ";
    private static int GOAL = 3;
    private static int ZERO = 0;

    private BaseBallGame() {
    }

    public static BaseBallGame getGame() {
        return gameProgram;
    }

    public void gameStart() {
        System.out.println(GAME_START);
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
        System.out.println(QUESTIONS_ABOUT_RESTART);
        String answerToReplay = Console.readLine();

        if (!answerToReplay.equals(RESTART) && !answerToReplay.equals(EXIT)) {
            throw new IllegalArgumentException(INPUT_ERROR_ABOUT_RESTART);
        }

        if (answerToReplay.equals(RESTART)) {
            return true;
        }
        System.out.println(GAME_FINISH);
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
            System.out.println(GOAL + STRIKE);
            System.out.println(CORRECT);
            return true;
        }

        if (ball == ZERO && strike == ZERO) {
            System.out.println(NOTHING);
        } else {
            if (ball == ZERO) {
                System.out.println(strike + STRIKE);
            } else if (strike == ZERO) {
                System.out.println(ball + BALL);
            } else {
                System.out.println(ball + BALL + " " + strike + STRIKE);
            }
        }

        return false;

    }


    public String inputNumber() {
        System.out.print(INPUT_YOUR_NUMBER);
        String inputStr = Console.readLine();
        inputValidation(inputStr);
        return inputStr;
//        return Integer.parseInt(inputStr);
    }

    public void inputValidation(String inputStr) {
        if (!is3DigitNumber(inputStr) || !isDiffDigitNumber(inputStr)) {
            throw new IllegalArgumentException(INPUT_ERROR_ABOUT_USER_NUMBER);
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

        for (int currentDigitIdx = 0; currentDigitIdx < numLength; currentDigitIdx++) {
            int finalCurrentDigit = currentDigitIdx;

            String currentDigitOfUser = userNumList.get(currentDigitIdx);
            String currentDigitOfComputer = computerNumList.get(currentDigitIdx);
            String diffDigitsOfComputer = IntStream.range(0, numLength)
                    .filter(i -> i != finalCurrentDigit)
                    .mapToObj(computerNumList::get)
                    .collect(Collectors.joining(""));

            if (currentDigitOfUser.equals(currentDigitOfComputer)) {
                strike++;
            }
            if (diffDigitsOfComputer.contains(currentDigitOfUser)
            ) {
                ball++;
            }
//            if (userNumList.get(currentDigit).equals(computerNumList.get((currentDigit + 1) % numLength))
//                    || userNumList.get(currentDigit).equals(computerNumList.get((currentDigit + 2) % numLength))
//            ) {
//                ball++;
//            }

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
