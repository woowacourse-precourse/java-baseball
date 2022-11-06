package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberServiceImpl implements NumberService {
    public static final int NUM_MATCHES = 3;
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;

    /*
     * 정규표현식을 이용한 유효성 검사로 아래의 정규표현식의 의미는 다음과 같음
     *
     * ([${start}-${end}]) -> 사용자가 입력한 값의 첫번째 값이 올바른지 검사, 이것은 백레퍼런스의 1번 임
     * (?!\\1) -> 부정 룩어헤드(Negative Lookahead)로 백레퍼런스의 1번이 아닌 경우를 의미함, 이것은 zero-width 연산임을 기억해야 함
     * ([${start}-${end}])(?!\\1)([${start}-${end}]) -> 사용자가 입력한 값의 첫번째 값이 정상 범위이며,
     *                                                  두번째 값은 첫번째 값과 동일하지 않으면서 정상 범위인 경우를 뜻 함
     */
    private static final String USER_NUMBERS_REGEX_TO_VALID =
            "^([${start}-${end}])(?!\\1)([${start}-${end}])(?!\\1|\\2)[${start}-${end}]$";

    private static final Integer NOT_FOUND_USER_NUMBER = 0;
    private static final Integer NOT_FOUND_INDEX_COMPUTER = -1;

    private List<Integer> computerNumbers;
    private List<Integer> userNumbers;

    @Override
    public void pickNumbersByComputer() {
        computerNumbers = IntStream.generate(() -> Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE))
                .distinct()
                .limit(NUM_MATCHES)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public void enterNumbersByUser() {
        final String userInput = Console.readLineWithValidation(parsedUserNumberRegexToValid());

        userNumbers = userInput.codePoints()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());
    }

    private String parsedUserNumberRegexToValid() {
        return USER_NUMBERS_REGEX_TO_VALID
                .replaceAll("\\$\\{start}", Integer.toString(START_INCLUSIVE))
                .replaceAll("\\$\\{end}", Integer.toString(END_INCLUSIVE));
    }

    @Override
    public Score evaluateNumbers() {
        final Map<ThrowingType, Long> scoreTable = IntStream.range(0, NUM_MATCHES)
                .mapToObj(this::evaluateNumber)
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));

        return new Score(scoreTable);
    }

    private ThrowingType evaluateNumber(Integer idxUser) {
        final Integer idxComputer = indexComputerOf(idxUser);

        if (idxComputer.equals(NOT_FOUND_INDEX_COMPUTER)) {
            return ThrowingType.NOTHING;
        } else if (idxComputer.equals(idxUser)) {
            return ThrowingType.STRIKE;
        } else {
            return ThrowingType.BALL;
        }
    }

    private Integer indexComputerOf(Integer idxUser) {
        final Integer userNumber = Optional.ofNullable(userNumbers)
                .map(list -> list.get(idxUser))
                .orElse(NOT_FOUND_USER_NUMBER);

        return Optional.ofNullable(computerNumbers)
                .map(list -> list.indexOf(userNumber))
                .orElse(NOT_FOUND_INDEX_COMPUTER);
    }
}
