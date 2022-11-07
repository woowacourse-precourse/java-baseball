package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

//***함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.***
//11/07 디버깅, 리팩토링(한 번에 한 가지 일만, 최대한 작게), 코드 컨벤션, 커밋 컨벤션, 테스트 케이스 추가(11/08로)
//11/08 리팩토링, 코드 컨벤션, 테스트 케이스 추가하기()
public class Application {
    public static void main(String[] args) {
        playGame();
    }
    public static void playGame(){
        List<Integer> whatComputerInputs = new ArrayList<>();
        boolean startAgain = false;
        System.out.println(Referee.START_GAME.ordered());
        putRandomNumbersTo(whatComputerInputs);
        while (startAgain == false) {
            List<Integer> whatClientInputs = getWhatClientInputs();
            checkNothing(whatComputerInputs, whatClientInputs);
            startAgain = shoutBallsAndStrikes(whatComputerInputs, whatClientInputs);
        }
        if (startAgain == true) {
            String finishOrRestart = askFinishOrRestart();
            confirmFinishOrRestart(finishOrRestart);
        }
    }
    public static List<Integer> getWhatClientInputs() {
        String guessedNumbers;
        guessedNumbers = inputThreeDistinctNumbers();
        isValid(guessedNumbers);
        List<Integer> whatClientInputs = stringToIntegerList(guessedNumbers);
        return whatClientInputs;
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
        return guessedNumbers;//***문제없음
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
        int ball = countBalls(numbersToGetRight, guessedNumbers);
        int strike = countStrikes(numbersToGetRight, guessedNumbers);
        if (strike == 3) {
            System.out.println(strike + Referee.STRIKE.ordered());
            return true;
        }
        if (ball != 0 && strike == 0) {
            System.out.println(ball + Referee.BALL.ordered());
            return false;
        }
        if (ball == 0 && strike != 0) {
            System.out.println(strike + Referee.STRIKE.ordered());
            return false;
        }
        if (ball != 0 && strike != 0) {
            System.out.println(ball + Referee.BALL.ordered() + strike + Referee.STRIKE.ordered());
            return false;
        }
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