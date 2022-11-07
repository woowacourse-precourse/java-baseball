package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.testhelper.ComparingResultExample;
import baseball.testhelper.ComparingTestCases;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class QuestionNumberSetterTest {

    QuestionNumberSetter questionNumberSetter = new QuestionNumberSetter();

    @Test
    @DisplayName("랜덤 숫자 결정 기능 테스트")
    void pickThreeRandomNumbersTest() {
        List<Integer> randomNumbers = questionNumberSetter.pickThreeRandomNumbers();
        String randomNumbersString = randomNumbers.stream()
                .map(Object::toString).collect(Collectors.joining());

        // 숫자 범위(1~9) 및 숫자 개수(3) 테스트
        assertThat(randomNumbersString).containsPattern("^[1-9]{3}$");

        // 서로 다른 수를 갖고 있는지 테스트
        Set<String> checkOverlapSet = new HashSet<>();
        new ArrayList<>(Arrays.asList(randomNumbersString.split("")))
                .forEach(number -> assertThat(checkOverlapSet.add(number)).isTrue());
    }

    @Test
    @DisplayName("사용자 입력 숫자에 대한 결과 반환 기능 테스트")
    void compareWithRandomNumbersTest() throws NoSuchFieldException, IllegalAccessException {
        // 테스트를 위해 랜덤 숫자 임의로 설정
        Field randomNumbersField = QuestionNumberSetter.class.getDeclaredField("randomNumbers");
        randomNumbersField.setAccessible(true);
        randomNumbersField.set(questionNumberSetter,
                ComparingResultExample.RANDOM_NUMBER.getNumbers());

        ComparingTestCases comparingTest = new ComparingTestCases(questionNumberSetter);

        comparingTest.oneBallTest();
        comparingTest.twoBallTest();
        comparingTest.threeBallTest();

        comparingTest.oneStrikeTest();
        comparingTest.twoStrikeTest();
        comparingTest.threeStrikeTest();

        comparingTest.oneBallOneStrikeTest();
        comparingTest.twoBallOneStrikeTest();

        comparingTest.nothingTest();
    }
}
