package baseball.screen;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class OutputResolverTest {

    OutputResolver outputResolver = new OutputResolver();

    @Test
    void buildPrompt() {
        try {
            Method buildPrompt =
                    outputResolver.
                    getClass().
                    getDeclaredMethod("buildPrompt", Integer.class, Integer.class);

            buildPrompt.setAccessible(true);

            assertResultPrompt(buildPrompt, 0, 0, "낫싱");

            assertResultPrompt(buildPrompt, 1, 1, "1볼 1스트라이크");

            assertResultPrompt(buildPrompt, 2, 0, "2볼");

            assertResultPrompt(buildPrompt, 0, 3, "3스트라이크");

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private void assertResultPrompt(
        Method buildPrompt,
        int ball, int strike, String prompt) throws IllegalAccessException, InvocationTargetException {

        String resultPrompt = (String) buildPrompt.invoke(outputResolver, ball, strike);
        assertThat(resultPrompt).isEqualTo(prompt);
    }

}