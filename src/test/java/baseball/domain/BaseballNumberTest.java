package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballNumberTest {
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 9;
    private static final int DIGIT = 3;

    @Test
    void 올바르지_않은_사용자_입력() {
        //given
        String sizeTwo = "12";
        String sizeFour = "2357";
        String containZero = "045";
        String containNonNumber = "a23";
        String containDuplicateNumber = "322";

        //when, then
        assertThatThrownBy(() -> BaseballNumber.createByUserInput(sizeTwo))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> BaseballNumber.createByUserInput(sizeFour))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> BaseballNumber.createByUserInput(containZero))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> BaseballNumber.createByUserInput(containNonNumber))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> BaseballNumber.createByUserInput(containDuplicateNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 올바른_사용자_입력() {
        //given
        List<String> testStringList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            StringBuilder sb = new StringBuilder();
            while (sb.length() != DIGIT) {
                int randomNum = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
                String randomNumToString = String.valueOf(randomNum);
                if (StringBuilderNotContainString(sb, randomNumToString)) {
                    sb.append(randomNum);
                }
            }
            testStringList.add(sb.toString());
        }

        for (String testString : testStringList) {
            BaseballNumber.createByUserInput(testString);
        }
    }

    private static boolean StringBuilderNotContainString(StringBuilder sb, String randomNumToString) {
        return sb.indexOf(randomNumToString) == -1;
    }

    @Test
    void 랜덤한_BaseballNumber_생성() {
        BaseballNumber comBaseballNumber = BaseballNumber.createByRandom();
        List<Integer> numbers = comBaseballNumber.getNumbers();
    }
}
