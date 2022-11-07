package baseball;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NumberTest {
    private static final int GAME_NUMBER_SIZE = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final String REGAX = "^["+MIN_NUMBER+"-"+MAX_NUMBER+"]*$";

    private static Number number;

    @BeforeEach
    private void initNumber() {
        number = new Number();
    }

    @Test
    void 올바른_컴퓨터_랜덤_숫자_생성() {
        number.createRandomNumber();
        assertTrue(checkVaild());
    }

    @Test
    void 올바른_사용자_숫자() {
        number.getUserNumberForTest("123");
        assertTrue(checkVaild());
    }

    @Test
    void 문자_입력() {
        assertThrows( IllegalArgumentException.class,
                () -> number.getUserNumberForTest("wef")
        );
    }

    @Test
    void 올바르지_않은_입력_길이_case1() {
        assertThrows( IllegalArgumentException.class,
                () -> number.getUserNumberForTest("7858")
        );
    }

    @Test
    void 올바르지_않은_입력_길이_case2() {
        assertThrows( IllegalArgumentException.class,
                () -> number.getUserNumberForTest("23")
        );
    }

    @Test
    void 올바르지_않은_입력_패턴_case1() {
        assertThrows( IllegalArgumentException.class,
                () -> number.getUserNumberForTest("170")
        );
    }

    @Test
    void 올바르지_않은_입력_패턴_case2() {
        assertThrows( IllegalArgumentException.class,
                () -> number.getUserNumberForTest("605")
        );
    }

    @Test
    void 올바르지_않은_입력_패턴_case3() {
        assertThrows( IllegalArgumentException.class,
                () -> number.getUserNumberForTest("7a0")
        );
    }

    @Test
    void 중복이_존재하는_입력() {
        assertThrows( IllegalArgumentException.class,
                () -> number.getUserNumberForTest("277")
        );
    }

    private boolean checkVaild() {
        return checkPattern() 
                && checkSize() 
                && checkDuplicate();
    }

    private boolean checkPattern() {
        return Pattern.compile(REGAX).matcher(number.getGameNumber().stream().map(String::valueOf).collect(Collectors.joining(""))).matches();
    }

    private boolean checkSize() {
        return GAME_NUMBER_SIZE == number.getGameNumber().size();
    }

    private boolean checkDuplicate() {
        List<Integer> gameNumberList = number.getGameNumber();
        Set<Integer> gameNumberSet = convertListToSet(gameNumberList);
        return gameNumberList.size() == gameNumberSet.size();
    }

    private Set<Integer> convertListToSet(List<Integer> gameNumberList) {
        Set<Integer> checkDuplication = new HashSet<>();
        for(Integer num: gameNumberList) {
            checkDuplication.add(num);
        }
        return checkDuplication;
    }
}