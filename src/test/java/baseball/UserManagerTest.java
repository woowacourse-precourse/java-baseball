package baseball;

import org.junit.jupiter.api.Test;

import java.io.*;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class UserManagerTest {

    // 사용자 입력
    void putSystemInput(String input) {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    /**
     * getPredictInput
     */
    @Test
    void getPredictInput_자리수_이탈_예외_테스트() {
        String predictInput = "1234";
        putSystemInput(predictInput);

        assertSimpleTest(() ->
                        assertThatThrownBy(UserManager::getPredictInput)
                                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void getPredictInput_숫자_범위_이탈_예외_테스트() {
        String predictInput = "304";
        putSystemInput(predictInput);

        assertSimpleTest(() ->
                assertThatThrownBy(UserManager::getPredictInput)
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void getPredictInput_공백_예외_테스트() {
        String predictInput = "1 4";
        putSystemInput(predictInput);

        assertSimpleTest(() ->
                assertThatThrownBy(UserManager::getPredictInput)
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void getPredictInput_중복_예외_테스트() {
        String predictInput = "114";
        putSystemInput(predictInput);

        assertSimpleTest(() ->
                assertThatThrownBy(UserManager::getPredictInput)
                        .isInstanceOf(IllegalArgumentException.class));
    }

    /**
     * getRepeatInput
     */
    @Test
    void getRepeatInput_자리수_이탈_예외_테스트() {
        String predictInput = "12";
        putSystemInput(predictInput);

        assertSimpleTest(() ->
                assertThatThrownBy(UserManager::getPredictInput)
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void getRepeatInput_숫자_범위_이탈_예외_테스트() {
        String predictInput = "3";
        putSystemInput(predictInput);

        assertSimpleTest(() ->
                assertThatThrownBy(UserManager::getPredictInput)
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void getRepeatInput_공백_예외_테스트() {
        String predictInput = "1 ";
        putSystemInput(predictInput);

        assertSimpleTest(() ->
                assertThatThrownBy(UserManager::getPredictInput)
                        .isInstanceOf(IllegalArgumentException.class));
    }

}
