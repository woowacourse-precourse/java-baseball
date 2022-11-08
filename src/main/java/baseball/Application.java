package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

enum Baseball {
    BALL(0, "볼"), STRIKE(1, "스트라이크");

    private final int index;
    private final String name;

    private Baseball(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }
}

public class Application {
    private static final int LENGTH_OF_NUMBERS = 3;
    private static final String CONTINUE = "1";
    private static final String EXIT = "2";
    private static final int MIN_DIGIT = 1;
    private static final int MAX_DIGIT = 9;
    private static final String NOTHING = "낫싱";
    private static Baseball ball = Baseball.BALL;
    private static Baseball strike = Baseball.STRIKE;

    public static void main(String[] args) {
        String option;
        boolean isUserPlayingGame = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while ( isUserPlayingGame ) {
            play369Game();
            System.out.println("게임을 새로 시작하려면 " + CONTINUE + ", 종료하려면 " + EXIT + "를 입력하세요.");
            option = Console.readLine();
            if ( !isValidOption(option) ) {
                throw new IllegalArgumentException("잘못된 옵션을 입력하셨습니다.");
            }

            if ( option.equals(EXIT) ) {
                isUserPlayingGame = false;
            }
        }
    }

    public static boolean isValidOption (String option) {
        return Pattern.matches("[12]", option);
    }

    public static void play369Game() {
        List<Integer> answer = makeAnswer();

        boolean isGuessCorrect = false;
        while ( !isGuessCorrect ) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            if ( !isValidNumbersForGame(input) ) {
                throw new IllegalArgumentException("잘못된 형식의 숫자를 입력하셨습니다.\n" + MIN_DIGIT + "부터 " + MAX_DIGIT + "사이의 서로 다른 " + LENGTH_OF_NUMBERS + "자리 숫자를 입력해주시기 바랍니다.");
            }
            List<Integer> guess = stringToNumberList(input);
            List<Integer> evaluation = evaluateGuess(guess, answer);
            System.out.println(evaluationToString(evaluation));
            if ( isEqualToAnswer(evaluation) ) {
                System.out.println(LENGTH_OF_NUMBERS + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
                isGuessCorrect = true;
            }
        }
    }

    public static boolean isEqualToAnswer (List<Integer> evaluation) {
        return evaluation.get(strike.getIndex()) == LENGTH_OF_NUMBERS;
    }

    public static String evaluationToString (List<Integer> evaluation) {
        StringBuilder sb = new StringBuilder();

        if ( hasBall(evaluation) ) {
            sb.append(evaluation.get(ball.getIndex())).append(ball.getName());
        }

        if ( hasStrike(evaluation) ) {
            if ( hasBall(evaluation) ) {
                sb.append(" ");
            }
            sb.append(evaluation.get(strike.getIndex())).append(strike.getName());
        }

        if ( sb.length() == 0 ) {
            sb.append(NOTHING);
        }
        return sb.toString();
    }

    public static boolean hasBall (List<Integer> evaluation) {
        return evaluation.get(ball.getIndex()) > 0;
    }

    public static boolean hasStrike (List<Integer> evaluation) {
        return evaluation.get(strike.getIndex()) > 0;
    }

    /**
     * Return list of ball and strike count.
     * First element of the list (index 0) is ball count and second one (index 1) is strike count.
     *
     * @param guess list of numbers to be evaluated.
     * @param answer answer number list of the 369 game.
     * @return list of ball and strike count in this order.
     */
    public static List<Integer> evaluateGuess (List<Integer> guess, List<Integer> answer) {
        int ballCount = countBall(guess, answer);
        int strikeCount = countStrike(guess, answer);
        return Arrays.asList(ballCount, strikeCount);
    }

    public static int countBall (List<Integer> guess, List<Integer> answer) {
        int countOfCommonNumbers = countCommonNumber(guess, answer);
        int countOfNumbersInSamePosition = countNumbersInSamePosition(guess, answer);
        return countOfCommonNumbers - countOfNumbersInSamePosition;
    }

    public static int countStrike (List<Integer> guess, List<Integer> answer) {
        return countNumbersInSamePosition(guess, answer);
    }

    public static int countCommonNumber (List<Integer> guess, List<Integer> answer) {
        return (int) guess.stream().filter(answer::contains).count();

    }

    public static int countNumbersInSamePosition (List<Integer> guess, List<Integer> answer) {
        return (int) IntStream.range(0, LENGTH_OF_NUMBERS)
                .filter(i -> Objects.equals(guess.get(i), answer.get(i)))
                .count();
    }

    public static List<Integer> stringToNumberList (String numbersInString) {
        List<Integer> numberList = new ArrayList<>();
        int number;
        for ( int i = 0; i < LENGTH_OF_NUMBERS; i++ ) {
            number = numbersInString.charAt(i) - '0';
            numberList.add(number);
        }
        return numberList;
    }

    public static boolean isValidNumbersForGame (String input) {
        if (!isOnlyNumbers(input)) {
            return false;
        }

        if (!hasCorrectSize(input)) {
            return false;
        }

        if (!isAllUnique(input)) {
            return false;
        }

        if (hasZero(input)) {
            return false;
        }

        return true;
    }

    public static boolean isOnlyNumbers (String input) {
        return Pattern.matches("^[0-9]*$", input);
    }

    public static boolean hasCorrectSize (String input) {
        return input.length() == LENGTH_OF_NUMBERS;
    }

    public static boolean isAllUnique (String input) {
        Set<Character> uniqueNumbers = new HashSet<>();
        for (Character number : input.toCharArray()) {
            uniqueNumbers.add(number);
        }
        return uniqueNumbers.size() == LENGTH_OF_NUMBERS;
    }

    public static boolean hasZero (String input) {
        return Pattern.matches(".*0.*", input);
    }

    public static List<Integer> makeAnswer() {
        List<Integer> answer = new ArrayList<>();
        int randomNumber;
        while ( answer.size() < LENGTH_OF_NUMBERS ) {
            randomNumber = Randoms.pickNumberInRange(MIN_DIGIT, MAX_DIGIT);
            if (answer.contains(randomNumber)) {
                continue;
            }
            answer.add(randomNumber);
        }
        return answer;
    }
}
