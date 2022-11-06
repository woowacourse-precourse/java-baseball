package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
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
        checkBalls();
        checkStrikes();
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
        if (isNumber(whatClientInputs) == false) {
            makeException();
        }
    }

    public static boolean isNumber(String certainNumber) {
        for (int characterIndex = 0; characterIndex < certainNumber.length(); characterIndex++) {
            //ASCII Code ((int)'0')==48, ((int)'9'==57)
            if ((int) certainNumber.charAt(characterIndex) >= 48 || (int) certainNumber.charAt(characterIndex) <= 57) {
                return true;
            }
        }
        return false;
    }

    public static void makeException() {
        IllegalArgumentException exit_program = new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        throw exit_program;
    }

    public static List<Integer> stringToIntegerList(String numbers){
        String[] temporaryArray = numbers.split("");
        List<Integer> gussedNumbers = new ArrayList<>();
        for(String stringNumber = temporaryArray){
           gussedNumbers.add(Integer.parseInt(stringNumber));
        }
        return gussedNumbers;
    }

    public static void checkNothing(List<Integer> numbersToGetRight, List<Integer> guessedNumbers){
        int ballOrStrike = 0;
        for(int guessedNumber : guessedNumbers) {
            if (numbersToGetRight.contains(guessedNumber)) {
                ballOrStrike++;
            }
        }
        if(ballOrStrike==0){
            System.out.println(Referee.NOTHING.ordered());
            playGame(numbersToGetRight);
        }
        checkBalls(numbersToGetRight, ballOrStrike);
    }

    public static int checkBalls(List<Integer> numbersToGetRight, int ballOrStrike){

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