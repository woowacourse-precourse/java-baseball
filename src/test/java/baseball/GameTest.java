package baseball;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class GameTest {
    Game game = new Game();

    @Nested
    class 게임_재시작_테스트 {
        @Test
        void 게임_재시작_테스트_true() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
            Method checkInputPlayGameMethod = Game.class.getDeclaredMethod("checkInputPlayGame", String.class);
            checkInputPlayGameMethod.setAccessible(true);
            boolean isPlay = (boolean) checkInputPlayGameMethod.invoke(game, "1");
            assertThat(isPlay).isEqualTo(true);
        }

        @Test
        void 게임_재시작_테스트_false() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
            Method checkInputPlayGameMethod = Game.class.getDeclaredMethod("checkInputPlayGame", String.class);
            checkInputPlayGameMethod.setAccessible(true);
            boolean isPlay = (boolean) checkInputPlayGameMethod.invoke(game, "");
            assertThat(isPlay).isEqualTo(false);
        }
    }

    @Nested
    class 중복숫자_테스트 {
        @Test
        void 중복숫자_테스트1_true() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
            Method checkUserInputDuplicateNumberMethod = Game.class.getDeclaredMethod("checkUserInputDuplicateNumber", String.class);
            checkUserInputDuplicateNumberMethod.setAccessible(true);
            boolean isNotDuplicated = (boolean) checkUserInputDuplicateNumberMethod.invoke(game, "123");
            assertThat(isNotDuplicated).isEqualTo(true);
        }

        @Test
        void 중복숫자_테스트2_true() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
            Method checkUserInputDuplicateNumberMethod = Game.class.getDeclaredMethod("checkUserInputDuplicateNumber", String.class);
            checkUserInputDuplicateNumberMethod.setAccessible(true);
            boolean isNotDuplicated = (boolean) checkUserInputDuplicateNumberMethod.invoke(game, "201");
            assertThat(isNotDuplicated).isEqualTo(true);
        }

        @Test
        void 중복숫자_테스트3_false() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
            Method checkUserInputDuplicateNumberMethod = Game.class.getDeclaredMethod("checkUserInputDuplicateNumber", String.class);
            checkUserInputDuplicateNumberMethod.setAccessible(true);
            boolean isNotDuplicated = (boolean) checkUserInputDuplicateNumberMethod.invoke(game, "122");
            assertThat(isNotDuplicated).isEqualTo(false);
        }
    }

    @Nested
    class 숫자변환_테스트 {
        @Test
        void 숫자변환_테스트1_true() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
            Method checkUserInputNumberMethod = Game.class.getDeclaredMethod("checkUserInputNumber", String.class);
            checkUserInputNumberMethod.setAccessible(true);
            boolean isNumber = (boolean) checkUserInputNumberMethod.invoke(game, "122");
            assertThat(isNumber).isEqualTo(true);
        }

        @Test
        void 숫자변환_테스트2_false() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
            Method checkUserInputNumberMethod = Game.class.getDeclaredMethod("checkUserInputNumber", String.class);
            checkUserInputNumberMethod.setAccessible(true);
            boolean isNumber = (boolean) checkUserInputNumberMethod.invoke(game, "012");
            assertThat(isNumber).isEqualTo(false);
        }

        @Test
        void 숫자변환_테스트3_false() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
            Method checkUserInputNumberMethod = Game.class.getDeclaredMethod("checkUserInputNumber", String.class);
            checkUserInputNumberMethod.setAccessible(true);
            boolean isNumber = (boolean) checkUserInputNumberMethod.invoke(game, "2");
            assertThat(isNumber).isEqualTo(false);
        }

        @Test
        void 숫자변환_테스트4_false() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
            Method checkUserInputNumberMethod = Game.class.getDeclaredMethod("checkUserInputNumber", String.class);
            checkUserInputNumberMethod.setAccessible(true);
            boolean isNumber = (boolean) checkUserInputNumberMethod.invoke(game, "가");
            assertThat(isNumber).isEqualTo(false);
        }

        @Test
        void 숫자변환_테스트5_false() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
            Method checkUserInputNumberMethod = Game.class.getDeclaredMethod("checkUserInputNumber", String.class);
            checkUserInputNumberMethod.setAccessible(true);
            boolean isNumber = (boolean) checkUserInputNumberMethod.invoke(game, "12가3");
            assertThat(isNumber).isEqualTo(false);
        }

        @Test
        void 숫자변환_테스트6_false() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
            Method checkUserInputNumberMethod = Game.class.getDeclaredMethod("checkUserInputNumber", String.class);
            checkUserInputNumberMethod.setAccessible(true);
            boolean isNumber = (boolean) checkUserInputNumberMethod.invoke(game, "+13");
            assertThat(isNumber).isEqualTo(false);
        }

        @Test
        void 숫자변환_테스트7_false() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
            Method checkUserInputNumberMethod = Game.class.getDeclaredMethod("checkUserInputNumber", String.class);
            checkUserInputNumberMethod.setAccessible(true);
            boolean isNumber = (boolean) checkUserInputNumberMethod.invoke(game, "");
            assertThat(isNumber).isEqualTo(false);
        }
    }

    @Nested
    class 영포함여부_테스트 {
        @Test
        void 영포함여부_테스트1_true() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
            Method checkUserInputContainZeroMethod = Game.class.getDeclaredMethod("checkUserInputContainZero", String.class);
            checkUserInputContainZeroMethod.setAccessible(true);
            boolean isNumber = (boolean) checkUserInputContainZeroMethod.invoke(game, "132");
            assertThat(isNumber).isEqualTo(false);
        }

        @Test
        void 영포함여부_테스트2_true() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
            Method checkUserInputContainZeroMethod = Game.class.getDeclaredMethod("checkUserInputContainZero", String.class);
            checkUserInputContainZeroMethod.setAccessible(true);
            boolean isNumber = (boolean) checkUserInputContainZeroMethod.invoke(game, "1332");
            assertThat(isNumber).isEqualTo(false);
        }

        @Test
        void 영포함여부_테스트3_true() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
            Method checkUserInputContainZeroMethod = Game.class.getDeclaredMethod("checkUserInputContainZero", String.class);
            checkUserInputContainZeroMethod.setAccessible(true);
            boolean isNumber = (boolean) checkUserInputContainZeroMethod.invoke(game, "");
            assertThat(isNumber).isEqualTo(false);
        }

        @Test
        void 영포함여부_테스트4_false() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
            Method checkUserInputContainZeroMethod = Game.class.getDeclaredMethod("checkUserInputContainZero", String.class);
            checkUserInputContainZeroMethod.setAccessible(true);
            boolean isNumber = (boolean) checkUserInputContainZeroMethod.invoke(game, "103");
            assertThat(isNumber).isEqualTo(true);
        }
    }

    @Nested
    class 문자열길이체크_테스트 {
        @Test
        void 문자열길이체크_테스트1_true() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
            Method checkUserInputLengthMethod = Game.class.getDeclaredMethod("checkUserInputLength", String.class);
            checkUserInputLengthMethod.setAccessible(true);
            boolean isNumber = (boolean) checkUserInputLengthMethod.invoke(game, "153");
            assertThat(isNumber).isEqualTo(true);
        }

        @Test
        void 문자열길이체크_테스트2_true() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
            Method checkUserInputLengthMethod = Game.class.getDeclaredMethod("checkUserInputLength", String.class);
            checkUserInputLengthMethod.setAccessible(true);
            boolean isNumber = (boolean) checkUserInputLengthMethod.invoke(game, "가나1");
            assertThat(isNumber).isEqualTo(true);
        }

        @Test
        void 문자열길이체크_테스트3_false() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
            Method checkUserInputLengthMethod = Game.class.getDeclaredMethod("checkUserInputLength", String.class);
            checkUserInputLengthMethod.setAccessible(true);
            boolean isNumber = (boolean) checkUserInputLengthMethod.invoke(game, "31");
            assertThat(isNumber).isEqualTo(false);
        }
    }

    @Nested
    class 사용자입력체크_테스트 {
        @Test
        void 사용자입력체크_테스트1_정상() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
            Method checkUserInputMethod = Game.class.getDeclaredMethod("checkUserInput", String.class);
            checkUserInputMethod.setAccessible(true);
            checkUserInputMethod.invoke(game, "325");
        }

        @Test
        void 사용자입력체크_테스트2_정상() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
            Method checkUserInputMethod = Game.class.getDeclaredMethod("checkUserInput", String.class);
            checkUserInputMethod.setAccessible(true);
            checkUserInputMethod.invoke(game, "129");
        }
    }

    @Nested
    class 랜덤넘버생성_테스트 {
        @Test
        void 랜덤넘버생성_테스트1_true() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
            Method createSecretNumberMethod = Game.class.getDeclaredMethod("createSecretNumber");
            createSecretNumberMethod.setAccessible(true);
            Method checkUserInputMethod = Game.class.getDeclaredMethod("checkUserInput", String.class);
            checkUserInputMethod.setAccessible(true);
            for (int i = 0; i < 100; i++) {
                List<Integer> secretNumber = (List<Integer>) createSecretNumberMethod.invoke(game);
                String secretString = secretNumber.stream().map(String::valueOf)
                        .collect(Collectors.joining());
                checkUserInputMethod.invoke(game, secretString);
            }
        }
    }
}
