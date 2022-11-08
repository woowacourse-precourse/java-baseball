package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {
        List<Integer> whatComputerInputs = new ArrayList<>();
        boolean isGameFinished = false;

        System.out.println(Referee.START_GAME.ordered());
        putRandomNumbersTo(whatComputerInputs);
        while (isGameFinished == false) {
            List<Integer> whatClientInputs = getWhatClientInputs();
            checkNothing(whatComputerInputs, whatClientInputs);
            isGameFinished = shoutBallsAndStrikes(whatComputerInputs, whatClientInputs);
        }
        if (isGameFinished == true) {
            String finishOrRestart = askFinishOrRestart();
            confirmFinishOrRestart(finishOrRestart);
        }
    }

    public static void putRandomNumbersTo(List<Integer> digitsToCompare) {
        while (digitsToCompare.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            getDistinctNumbers(randomNumber, digitsToCompare);
        }
    }

    public static void getDistinctNumbers(int randomNumber, List<Integer> digitsToCompare) {
        if (!digitsToCompare.contains(randomNumber)) {
            digitsToCompare.add(randomNumber);
        }
    }

    public static List<Integer> getWhatClientInputs() {
        String guessedNumbers = inputThreeDistinctNumbers();
        isValid(guessedNumbers);
        List<Integer> whatClientInputs = makeStringToIntegerList(guessedNumbers);
        return whatClientInputs;
    }

    public static String inputThreeDistinctNumbers() {
        System.out.print(Referee.ASK_NUMBERS.ordered());
        String answeredNumbers = Console.readLine();
        return answeredNumbers;
    }

    public static List<Integer> makeStringToIntegerList(String numbers) {
        String[] temporaryArray = numbers.split("");
        List<Integer> guessedNumbers = new ArrayList<>();
        for (String stringNumber : temporaryArray) {
            guessedNumbers.add(Integer.parseInt(stringNumber));
        }
        return guessedNumbers;
    }

    public static void isValid(String whatClientInputs) {
        try {
            throwExceptionWhenItIsBlank(whatClientInputs);
            throwExceptionWhenLengthIsNotThree(whatClientInputs);
            throwExceptionWhenDigitsAreSame(whatClientInputs);
            throwExceptionWhenItIsNotNumber(whatClientInputs);
        } catch (Exception exit_program) {
            makeException();
        }
    }

    public static void throwExceptionWhenItIsBlank(String whatClientInputs) {
        if (whatClientInputs.isBlank()) {
            makeException();
        }
    }

    public static void throwExceptionWhenLengthIsNotThree(String whatClientInputs) {
        if (whatClientInputs.length() != 3) {
            makeException();
        }
    }

    public static void throwExceptionWhenDigitsAreSame(String whatClientInputs) {
        if (whatClientInputs.charAt(0) == whatClientInputs.charAt(1)
                || whatClientInputs.charAt(1) == whatClientInputs.charAt(2)
                || whatClientInputs.charAt(0) == whatClientInputs.charAt(2)) {
            makeException();
        }
    }

    public static void throwExceptionWhenItIsNotNumber(String certainNumber) {
        boolean numberOrNot = false;
        for (int characterIndex = 0; characterIndex < certainNumber.length(); characterIndex++) {
            //ASCII Code ((int)'0')==48, ((int)'9'==57)
            if ((int) certainNumber.charAt(characterIndex) >= 48
                    || (int) certainNumber.charAt(characterIndex) <= 57) {
                numberOrNot = true;
            }
        }
        if (numberOrNot == false) {
            makeException();
        }
    }

    public static void makeException() {
        IllegalArgumentException exit_program = new IllegalArgumentException();
        throw exit_program;
    }

    public static void checkNothing(List<Integer> numbersToGetRight, List<Integer> guessedNumbers) {
        int ball = countBalls(numbersToGetRight, guessedNumbers);
        int strike = countStrikes(numbersToGetRight, guessedNumbers);
        if (ball == 0 && strike == 0) {
            System.out.println(Referee.NOTHING.ordered());
        }
    }

    public static int countBalls(List<Integer> numbersToGetRight, List<Integer> guessedNumbers) {
        int ball = 0;
        for (int commonIndex = 0; commonIndex < 3; commonIndex++) {
            if (numbersToGetRight.contains(guessedNumbers.get(commonIndex))
                    && numbersToGetRight.get(commonIndex) != guessedNumbers.get(commonIndex))
                ball++;
        }
        return ball;
    }

    public static int countStrikes(List<Integer> numbersToGetRight, List<Integer> guessedNumbers) {
        int strike = 0;
        for (int commonIndex = 0; commonIndex < 3; commonIndex++) {
            if (numbersToGetRight.get(commonIndex) == guessedNumbers.get(commonIndex)) {
                strike++;
            }
        }
        return strike;
    }

    public static boolean shoutBallsAndStrikes(List<Integer> numbersToGetRight, List<Integer> guessedNumbers) {
        int strike = countStrikes(numbersToGetRight,guessedNumbers);
        int ball = countBalls(numbersToGetRight,guessedNumbers);
        if (strike == 3) {
            return declareThreeStrike(strike, ball);
        }
        if (ball != 0 && strike == 0) {
            return declareBall(strike, ball);
        }
        if (ball == 0 && strike != 0) {
            return declareStrike(strike, ball);
        }
        if (ball != 0 && strike != 0) {
            return declareBallAndStrike(strike, ball);
        }
        return false;
    }

    public static boolean declareThreeStrike(int strike, int ball) {
        System.out.println(strike + Referee.STRIKE.ordered());
        return true;
    }

    public static boolean declareBall(int strike, int ball) {
        System.out.println(ball + Referee.BALL.ordered());
        return false;
    }

    public static boolean declareStrike(int strike, int ball) {
        System.out.println(strike + Referee.STRIKE.ordered());
        return false;
    }

    public static boolean declareBallAndStrike(int strike, int ball) {
        System.out.println(ball + Referee.BALL.ordered() + strike + Referee.STRIKE.ordered());
        return false;
    }

    public static String askFinishOrRestart() {
        System.out.println(Referee.FINISH_GAME.ordered());
        System.out.print(Referee.ASK_AGAIN_OR_NOT.ordered());
        String finishOrRestart = Console.readLine();
        return finishOrRestart;
    }

    public static void confirmFinishOrRestart(String finishOrRestart) {
        if (Integer.parseInt(finishOrRestart) == 2) {
            return;
        }
        if (Integer.parseInt(finishOrRestart) == 1) {
            playGame();
            return;
        }
        if (Integer.parseInt(finishOrRestart) != 2) {
            makeException();
        }
    }
}

enum Referee {
    START_GAME("숫자 야구 게임을 시작합니다"),
    ASK_NUMBERS("숫자를 입력해주세요 : "),
    BALL("볼 "),
    STRIKE("스트라이크 "),
    NOTHING("낫싱"),
    FINISH_GAME("세 개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    ASK_AGAIN_OR_NOT("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String saying;

    Referee(String saying) {
        this.saying = saying;
    }

    public String ordered() {
        return saying;
    }
}