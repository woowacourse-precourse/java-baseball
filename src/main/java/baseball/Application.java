package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

enum BaseballResult {
    NOTHING("낫싱"),
    BALL("볼"),
    STRIKE("스트라이크");

    private final String korName;

    BaseballResult(String korName) {
        this.korName = korName;
    }

    @Override
    public String toString() {
        return korName;
    }
}

class BaseballNumber {
    private List<DecimalNumber> numbers;

    public static final int MAX_DIGIT_CRITERIA = 3;

    public BaseballNumber(String strBaseballNumber) {
        validateBaseballNumbersLength(strBaseballNumber.length());
        List<DecimalNumber> numbers = splitStrNumberToList(strBaseballNumber);
        validateBaseballNumbers(numbers);
        this.numbers = numbers;
    }

    private BaseballNumber() { }

    public static BaseballNumber makeRandomBaseballNumber() {
        BaseballNumber baseballNumber = new BaseballNumber();

        baseballNumber.numbers = new ArrayList<>();
        while (baseballNumber.numbers.size() < 3) {
            DecimalNumber randomNumber = new DecimalNumber(Randoms.pickNumberInRange(1, 9));
            validateListHasDuplicateBaseballNumber(baseballNumber.numbers, randomNumber);
            baseballNumber.numbers.add(randomNumber);
        }

        return baseballNumber;
    }

    private void validateBaseballNumbers(List<DecimalNumber> baseballNumbers) throws IllegalArgumentException {
        validateBaseballNumbersLength(baseballNumbers.size());
        validateDuplicateBaseballNumber(baseballNumbers);
    }

    private void validateBaseballNumbersLength(int length) {
        if (length != 3) {
            throw new IllegalArgumentException("올바른 3자리의 수를 입력해주세요.");
        }
    }

    private void validateDuplicateBaseballNumber(List<DecimalNumber> baseballNumbers) throws IllegalArgumentException {
        List<DecimalNumber> duplicateDecimals = new ArrayList<>();
        for (int i = 0; i < MAX_DIGIT_CRITERIA; i++) {
            DecimalNumber number = baseballNumbers.get(i);
            validateListHasDuplicateBaseballNumber(duplicateDecimals, number);
        }
    }

    private static void validateListHasDuplicateBaseballNumber(List<DecimalNumber> numbers, DecimalNumber number) throws IllegalArgumentException {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException("중복되지 않은 3자리의 수를 입력해주세요.");
        }
    }

    private static List<DecimalNumber> splitStrNumberToList(String strBaseballNumber) {
        return IntStream.range(0, MAX_DIGIT_CRITERIA)
                .mapToObj(i -> new DecimalNumber(Character.getNumericValue(strBaseballNumber.charAt(i))))
                .collect(Collectors.toList());
    }

    public DecimalNumber indexOf(int index) {
        if (index >= MAX_DIGIT_CRITERIA) {
            throw new IllegalArgumentException("최대 인덱스는 2입니다.");
        }
        return numbers.get(index);
    }

    public boolean contains(DecimalNumber number) {
        return numbers.contains(number);
    }

    public BaseballResult getIndexOfGameResult(int index, BaseballNumber computerNumber) {
        DecimalNumber comparingDecimal = this.indexOf(index);

        if (comparingDecimal.equals(computerNumber.indexOf(index))) {
            return BaseballResult.STRIKE;
        }

        if (computerNumber.contains(comparingDecimal)) {
            return BaseballResult.BALL;
        }

        return BaseballResult.NOTHING;
    }

    @Override
    public String toString() {
        return "BaseballNumber" + numbers;
    }
}


class DecimalNumber {
    int value;
    private static final int START_CRITERIA = 1;
    private static final int END_CRITERIA = 9;

    public DecimalNumber(int value) {
        validateDecimalNumber(value);
        this.value = value;
    }

    private static void validateDecimalNumber(int value) {
        if (!isValidateRange(value)) {
            throw new IllegalArgumentException(String.format("%d - %d 사이의 올바른 범위의 수를 입력해주세요.\n", START_CRITERIA, END_CRITERIA));
        }
    }

    private static boolean isValidateRange(int value) {
        return (value >= START_CRITERIA) && (value <= END_CRITERIA);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DecimalNumber that = (DecimalNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "{" + value + '}';
    }
}

public class Application {

    public static void main(String[] args) {
        printGameStartMessage();

        int gameRestartUserSelection;
        do {
            runBaseballGame();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            gameRestartUserSelection = Integer.parseInt(Console.readLine());
        } while (isRestartGame(gameRestartUserSelection));
    }

    private static void runBaseballGame() {
        BaseballNumber computerNumber = BaseballNumber.makeRandomBaseballNumber();

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            BaseballNumber userNumber = new BaseballNumber(Console.readLine());

            HashMap<BaseballResult, Integer> gameResultMap = new HashMap<>();
            for (int i = 0; i < BaseballNumber.MAX_DIGIT_CRITERIA; i++) {
                BaseballResult currentIdxGameResult = userNumber.getIndexOfGameResult(i, computerNumber);
                gameResultMap.put(currentIdxGameResult, gameResultMap.getOrDefault(currentIdxGameResult, 0) + 1);
            }
            System.out.println(getBaseballGameResult(gameResultMap));

            if (gameResultMap.getOrDefault(BaseballResult.STRIKE, 0) == BaseballNumber.MAX_DIGIT_CRITERIA) {
                System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n", BaseballNumber.MAX_DIGIT_CRITERIA);
                break;
            }
        }
    }

    private static void printGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private static String getBaseballGameResult(HashMap<BaseballResult, Integer> gameResult) {
        StringBuilder sb = new StringBuilder();

        Optional<Integer> nothingCnt = Optional.ofNullable(gameResult.get(BaseballResult.NOTHING));
        if (nothingCnt.isPresent() && nothingCnt.get() == 3) {
            sb.append(BaseballResult.NOTHING).append('\n');
            return sb.toString();
        }

        Optional<Integer> ballCnt = Optional.ofNullable(gameResult.get(BaseballResult.BALL));
        ballCnt.ifPresent(integer -> sb.append(integer).append(BaseballResult.BALL).append(" "));

        Optional<Integer> strikeCnt = Optional.ofNullable(gameResult.get(BaseballResult.STRIKE));
        strikeCnt.ifPresent(integer -> sb.append(integer).append(BaseballResult.STRIKE).append(" "));

        return sb.toString();
    }

    private static boolean isRestartGame(int userSelect) {
        return userSelect == 1;
    }
}

