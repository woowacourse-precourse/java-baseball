package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


class BaseBallGame {
    private static BaseBallGame device = new BaseBallGame();

    private static int GOAL = 3;
    private static int ZERO = 0;
    public static String RESTART = "1";
    public static String EXIT = "2";

    private static String userNumber = "";
    private static String computerNumber = "";

    public static void setUserNumber(String inputNumber) {
        BaseBallGame.userNumber = inputNumber;
    }

    public static void setComputerNumber(String randomNumber) {
        BaseBallGame.computerNumber = randomNumber;
    }

    public static String getUserNumber() {
        return BaseBallGame.userNumber;
    }

    public static String getComputerNumber() {
        return BaseBallGame.computerNumber;
    }

    private BaseBallGame() {
    }

    public static BaseBallGame getDevice() {
        return device;
    }

    public void start() {
        Display.start();
    }

    public void playing() throws IllegalArgumentException {
        boolean isSolved = false;

        setComputerNumber(getRandomDiff3DigitNumber());

        while (!isSolved) {
            isSolved = solvingProblem(computerNumber);
        }

        if (restart()) {
            playing();
        }
    }

    public boolean restart() {
        Display.QUESTIONS_ABOUT_RESTART();
        String answerToReplay = Console.readLine();

        if (!answerToReplay.equals(RESTART) && !answerToReplay.equals(EXIT)) {
            throw new IllegalArgumentException(Display.getInputErrorAboutRestart());
        }

        if (answerToReplay.equals(RESTART)) {
            return true;
        }

        Display.finish();
        return false;
    }

    public boolean solvingProblem(String computerNumber) throws IllegalArgumentException {
        int ball, strike;

        String inputNumber = inputNumber();
        setUserNumber(inputNumber);

        List<Integer> hint = getHint();
        ball = hint.get(0);
        strike = hint.get(1);

        return getSolveResult(strike, ball);
    }

    public boolean getSolveResult(int strike, int ball) {
        if (strike == GOAL) {
            Display.printHint(ball, strike);
            Display.answerCorrect();

            return true;
        }

        Display.printHint(ball, strike);

        return false;
    }


    public String inputNumber() throws IllegalArgumentException {
        Display.inputYourNumber();
        String inputStr = Console.readLine();
        inputValidation(inputStr);

        return inputStr;
    }

    public void inputValidation(String inputStr) {
        if (!is3DigitNumber(inputStr) || !isDiffDigitNumber(inputStr)) {
            throw new IllegalArgumentException(Display.getInputErrorAboutUserNumber());
        }
    }

    public boolean is3DigitNumber(String inputStr) {
        int x = 3;
        String inputNumberRegex = "^[1-9]{3}$";

        return inputStr.matches(inputNumberRegex);
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

        while (randomDiff3DigitNumber.length() < GOAL) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!randomDiff3DigitNumber.contains(Integer.toString(randomNumber))) {
                randomDiff3DigitNumber += Integer.toString(randomNumber);
            }
        }

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
        }

        ballAndStrike.add(ball);
        ballAndStrike.add(strike);

        return ballAndStrike;
    }


    public List<Integer> getHint() {
        List<String> userNumList = new ArrayList<String>(
                Arrays.asList(BaseBallGame.getUserNumber().split(""))
        );

        List<String> computerNumList = new ArrayList<String>(
                Arrays.asList(BaseBallGame.getComputerNumber().split(""))
        );

        List<Integer> ballAndStrikeList = ballAndStrikeCount(userNumList, computerNumList);

        return ballAndStrikeList;
    }


}
