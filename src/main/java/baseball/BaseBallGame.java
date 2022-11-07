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

//TODO setUserNumber, setComputerNumber, getUserNumber, getComputerNumber 구현하기

class BaseBallGame {
    private static BaseBallGame gameProgram = new BaseBallGame();

    private static int GOAL = 3;
    private static int ZERO = 0;
    public static String RESTART = "1";
    public static String EXIT = "2";

    private BaseBallGame() {
    }

    public static BaseBallGame getGame() {
        return gameProgram;
    }

    public void gameStart() {
        GameDisplay.gameStart();
    }

    public void gamePlaying() throws IllegalArgumentException {
        String computerNumber = getRandomDiff3DigitNumber();
        boolean isSolved = false;
        while (!isSolved) {
            isSolved = solvingProblem(computerNumber);
        }
        if (reStartGame()) {
            gamePlaying();
        }
    }

    public boolean reStartGame() {
        GameDisplay.QUESTIONS_ABOUT_RESTART();
        String answerToReplay = Console.readLine();

        if (!answerToReplay.equals(RESTART) && !answerToReplay.equals(EXIT)) {
            throw new IllegalArgumentException(GameDisplay.getInputErrorAboutRestart());
        }

        if (answerToReplay.equals(RESTART)) {
            return true;
        }
        GameDisplay.gameFinish();
        return false;
    }

    public boolean solvingProblem(String computerNumber) throws IllegalArgumentException {
        String userNumber = inputNumber();
        int ball, strike;
        List<Integer> hint = getHint(userNumber, computerNumber);
        ball = hint.get(0);
        strike = hint.get(1);

        return getSolveResult(strike, ball);

    }

    public boolean getSolveResult(int strike, int ball) {
        if (strike == GOAL) {
            GameDisplay.strike(GOAL);
            GameDisplay.answerCorrect();
            return true;
        }

        if (ball == ZERO && strike == ZERO) {
            GameDisplay.nothing();
        } else {
            if (ball == ZERO) {
                GameDisplay.strike(strike);
            } else if (strike == ZERO) {
                GameDisplay.ball(ball);
            } else {
                GameDisplay.ballAndStrike(ball, strike);
            }
        }

        return false;

    }


    public String inputNumber() throws IllegalArgumentException {
        GameDisplay.inputYourNumber();
        String inputStr = Console.readLine();
        inputValidation(inputStr);
        return inputStr;
    }

    public void inputValidation(String inputStr) {
        if (!is3DigitNumber(inputStr) || !isDiffDigitNumber(inputStr)) {
            throw new IllegalArgumentException(GameDisplay.getInputErrorAboutUserNumber());
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
