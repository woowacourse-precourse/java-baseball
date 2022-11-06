package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberServiceImpl implements NumberService {
    public static final int NUM_MATCHES = 3;
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;

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
        final String userInput = Console.readLine();

        /*
         * 정규표현식을 이용한 유효성 검사로 아래의 정규표현식의 의미는 다음과 같음
         *
         * ([${start}-${end}]) -> 사용자가 입력한 값의 첫번째 값이 올바른지 검사, 이것은 백레퍼런스의 1번 임
         * (?!\\1) -> 부정 룩어헤드(Negative Lookahead)로 백레퍼런스의 1번이 아닌 경우를 의미함, 이것은 zero-width 연산임을 기억해야 함
         * ([${start}-${end}])(?!\\1)([${start}-${end}]) -> 사용자가 입력한 값의 첫번째 값이 정상 범위이며,
         *                                                  두번째 값은 첫번째 값과 동일하지 않으면서 정상 범위인 경우를 뜻 함
         */
        final String regexUserNumbers = "^([${start}-${end}])(?!\\1)([${start}-${end}])(?!\\1|\\2)[${start}-${end}]$"
                .replaceAll("\\$\\{start}", Integer.toString(START_INCLUSIVE))
                .replaceAll("\\$\\{end}", Integer.toString(END_INCLUSIVE));

        if (userInput.matches(regexUserNumbers)) {
            userNumbers = userInput.codePoints()
                    .mapToObj(Character::getNumericValue)
                    .collect(Collectors.toList());
        } else {
            throw new IllegalArgumentException("Your input string: " + userInput);
        }
    }

    @Override
    public void evaluateNumbers() {

    }
}
