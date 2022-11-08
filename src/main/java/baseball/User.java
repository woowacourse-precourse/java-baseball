package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Character.*;

public class User {

    private final static int MAX_SIZE = 3;

    private List<Integer> numbers = new ArrayList<>();
    private List<Integer> answers = new ArrayList<>();
    private Integer strike;
    private Integer ball;
    private boolean end;

    public User() {}

    public List<Integer> getNumbers() {
        return numbers;
    }

    public List<Integer> getAnswers() {
        return answers;
    }

    public Integer getStrike() {
        return strike;
    }

    public Integer getBall() {
        return ball;
    }

    public boolean isEnd() {
        return end;
    }

    public void insertAnswer(List<Integer> answer) {
        this.answers = answer;
    }

    public void inputNumber(String inputNumber) {
        this.numbers = listConverter(inputNumber);
        this.strike = 0;
        this.ball = 0;
        this.end = false;
    }

    //== 비즈니스 로직 ==//
    public void addStrike() {
        this.strike++;
    }

    public void addBall() {
        this.ball++;
    }

    public void correctAnswer() {
        this.end = true;
    }

    public void reset() {
        this.answers = new ArrayList<>();
        this.end = false;
    }

    //== 변환 로직 ==//
    private static List<Integer> listConverter(String inputNumber) {
        List<Character> numbers = characterConverter(inputNumber);
        validation(numbers);
        return integerConverter(numbers);
    }

    private static List<Character> characterConverter(String inputNumber) {
        List<Character> result = new ArrayList<>();
        for (int index = 0; index < inputNumber.length(); index++) {
            result.add(inputNumber.charAt(index));
        }
        return result;
    }

    private static List<Integer> integerConverter(List<Character> numbers) {
        return numbers.stream()
                .map(User::getIntegerNumber)
                .collect(Collectors.toList());
    }

    private static int getIntegerNumber(char number) {
        return number - '0';
    }

    //== 검증 로직 ==//
    private static void validation(List<Character> numbers) {
        isNumber(numbers);
        isMaxSize(numbers);
        isNotContainsZero(numbers);
        isNotDuplicationNumber(numbers);
    }

    private static void isNumber(List<Character> numbers) {
        for (Character number : numbers) {
            if (!isDigit(number)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void isMaxSize(List<Character> numbers) {
        if (isNotMaxSize(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isNotMaxSize(List<Character> numbers) {
        return numbers.size() != MAX_SIZE;
    }

    private static void isNotContainsZero(List<Character> numbers) {
        for (Character number : numbers) {
            if (isZero(number)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static boolean isZero(char number) {
        return number == '0';
    }

    private static void isNotDuplicationNumber(List<Character> numbers) {
        List<Character> contain = new ArrayList<>();
        numbers.forEach(number -> {
            if (contain.contains(number)) {
                throw new IllegalArgumentException();
            }
            contain.add(number);
        });
    }
}
