package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.model.User;
import java.lang.reflect.Method;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {
    User user;

    @BeforeEach
    void init() {
        user = new User("123");
    }

    @Test
    void 사용자에게_받은_입력값이_숫자로만_이루어_져있는지() throws Exception{
        Method method = User.class.getDeclaredMethod("isNumberOfString", String.class);
        method.setAccessible(true);

        String testForTrueText = "123";
        boolean predictTrueResult = (boolean) method.invoke(user, testForTrueText);
        assertThat(predictTrueResult).isEqualTo(true);

        String testForFalseText = "apple123";
        boolean predictFalseResult = (boolean) method.invoke(user, testForFalseText);
        assertThat(predictFalseResult).isEqualTo(false);
    }

    @Test
    void 사용자에게_받은_입력값이_각_숫자가_1에서_9까지의_수인지_체크() throws Exception {
        Method method = User.class.getDeclaredMethod("isNumberFromOneToNine", List.class);
        method.setAccessible(true);

        List<Integer> testForTrueList = List.of(1, 5, 9);
        boolean predictTrueResult = (boolean) method.invoke(user, testForTrueList);
        assertThat(predictTrueResult).isEqualTo(true);

        List<Integer> testForFalseList = List.of(0, 5, 9);
        boolean predictFalseResult = (boolean) method.invoke(user, testForFalseList);
        assertThat(predictFalseResult).isEqualTo(false);
    }

    @Test
    void 사용자에게_받은_입력값이_각_숫자가_서로_다른지() throws Exception {
        Method method = User.class.getDeclaredMethod("isComposedUniqueNumber", List.class);
        method.setAccessible(true);

        List<Integer> testForTrueList = List.of(3, 2, 7);
        boolean predictTrueResult = (boolean) method.invoke(user, testForTrueList);
        assertThat(predictTrueResult).isEqualTo(true);

        List<Integer> testForFalseList = List.of(2, 2, 9);
        boolean predictFalseResult = (boolean) method.invoke(user, testForFalseList);
        assertThat(predictFalseResult).isEqualTo(false);
    }

    @Test
    void 사용자에게_받은_입력값이_3자리_수인지() throws Exception{
        Method method = User.class.getDeclaredMethod("isThreeInSize", List.class);
        method.setAccessible(true);

        List<Integer> testForTrueList = List.of(5, 1, 7);
        boolean predictTrueResult = (boolean) method.invoke(user, testForTrueList);
        assertThat(predictTrueResult).isEqualTo(true);

        List<Integer> testForFalseList = List.of(5, 1, 7, 4);
        boolean predictFalseResult = (boolean) method.invoke(user, testForFalseList);
        assertThat(predictFalseResult).isEqualTo(false);
    }
}
