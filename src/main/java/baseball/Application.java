package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> whatComputerInputs = new ArrayList<>();
        System.out.println(Referee.START_GAME.ordered());
        putRandomNumbersTo(whatComputerInputs);
        playGame(whatComputerInputs);
    }

    public static void playGame(List<Integer> whatComputerInputs) {
        String whatClientInputs;
        whatClientInputs = inputThreeDistinctNumbers();
        isValid(whatClientInputs);
        List<Integer> guessedNumbers = stringToIntegerList(whatClientInputs);
        checkNothing(whatComputerInputs, guessedNumbers);
        finishOrRestart();
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

    public static String inputThreeDistinctNumbers() {
        System.out.print(Referee.ASK_NUMBERS.ordered());
        String answeredNumbers = Console.readLine();
        return answeredNumbers;
    }

    public static void isValid(String whatClientInputs) {
        if (whatClientInputs.isBlank() || whatClientInputs.length() != 3) {
            makeException();
        }
        if (whatClientInputs.charAt(0) == whatClientInputs.charAt(1)
                || whatClientInputs.charAt(1) == whatClientInputs.charAt(2)
                || whatClientInputs.charAt(0) == whatClientInputs.charAt(2)) {
            makeException();
        }
        isNumber(whatClientInputs);
    }

    public static void isNumber(String certainNumber) {
        boolean numberOrNot = false;
        for (int characterIndex = 0; characterIndex < certainNumber.length(); characterIndex++) {
            //ASCII Code ((int)'0')==48, ((int)'9'==57)
            if ((int) certainNumber.charAt(characterIndex) >= 48 || (int) certainNumber.charAt(characterIndex) <= 57) {
                numberOrNot = true;
            }
        }
        if (numberOrNot == false) {
            makeException();
        }
    }

    public static void makeException() {
        IllegalArgumentException exit_program = new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        throw exit_program;
    }

    public static List<Integer> stringToIntegerList(String numbers) {
        String[] temporaryArray = numbers.split("");
        List<Integer> guessedNumbers = new ArrayList<>();
        for (String stringNumber : temporaryArray) {
            guessedNumbers.add(Integer.parseInt(stringNumber));
        }
        return guessedNumbers;
    }

    public static void checkNothing(List<Integer> numbersToGetRight, List<Integer> guessedNumbers) {
        int ballOrStrike = 0;
        for (int guessedNumber : guessedNumbers) {
            if (numbersToGetRight.contains(guessedNumber)) {
                ballOrStrike++;
            }
        }
        if (ballOrStrike == 0) {
            System.out.println(Referee.NOTHING.ordered());
            playGame(numbersToGetRight);
        }
        checkBallAndStrike(numbersToGetRight, guessedNumbers, ballOrStrike);
    }

    public static void checkBallAndStrike(List<Integer> numbersToGetRight, List<Integer> guessedNumbers, int ballOrStrike) {
        int strike = 0;
        for (int commonIndex = 0; commonIndex < 3; commonIndex++) {
            if (numbersToGetRight.get(commonIndex) == guessedNumbers.get(commonIndex)) {
                strike++;
            }
        }
        if (strike == 0) {
            System.out.println(ballOrStrike + Referee.BALL.ordered());
            playGame(numbersToGetRight);
        }
        if (strike != 0 && strike != 3) {
            System.out.println((ballOrStrike - strike) + Referee.BALL.ordered() + strike + Referee.STRIKE.ordered());
            playGame(numbersToGetRight);
        }
    }

    public static void finishOrRestart() {
        System.out.println(Referee.FINISH_GAME.ordered());
        System.out.print(Referee.ASK_AGAIN_OR_NOT.ordered());
        String yesOrNo = Console.readLine();
        checkOneOrTwo(yesOrNo);
        if(Integer.parseInt(yesOrNo)==2) {
            System.out.print("");
        }
    }

    public static void checkOneOrTwo(String yesOrNo){
        isNumber(yesOrNo);
        if(Integer.parseInt(yesOrNo)==1){
            List<Integer> whatComputerInputs = new ArrayList<>();
            putRandomNumbersTo(whatComputerInputs);
            playGame(whatComputerInputs);
        }
        if(Integer.parseInt(yesOrNo)!=2){
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