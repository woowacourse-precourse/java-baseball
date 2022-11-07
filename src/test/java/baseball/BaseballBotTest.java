package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballBotTest {

    BaseballBot baseballBot = new BaseballBot();

    @BeforeEach
    void init() {
        baseballBot.createRandomValue();
    }

    @Test
    void checkAnswerUniqueNumber() {
        try {
            String answer = getAnswer();
            assertThat(isUniqueNumber(answer)).isEqualTo(true);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private String getAnswer() throws NoSuchFieldException, IllegalAccessException {
        Field field = baseballBot.getClass().getDeclaredField("answer");
        field.setAccessible(true);

        return (String) field.get(baseballBot);
    }

    boolean isUniqueNumber(String value) {
        Set<Character> numberSet = new HashSet<>();

        for (int i = 0; i < value.length(); i++) {
            char curChar = value.charAt(i);

            if (numberSet.contains(curChar)) {
                return false;
            }

            numberSet.add(value.charAt(i));
        }

        return true;
    }

    @Test
    void get3StrikeTest() {
        try {
            String answer = getAnswer();
            String allStrikeStr = answer;

            int strikeNum = getStrikeNum(allStrikeStr);
            int ballNum = getBallNum(allStrikeStr, strikeNum);

            assertThat(strikeNum).isEqualTo(3);
            assertThat(ballNum).isEqualTo(0);

        } catch (NoSuchFieldException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void get3BallTest() {
        try {
            String answer = getAnswer();
            String allBallStr = shuffleStr(answer);

            int strikeNum = getStrikeNum(allBallStr);
            int ballNum = getBallNum(allBallStr, strikeNum);

            assertThat(strikeNum).isEqualTo(0);
            assertThat(ballNum).isEqualTo(3);

        } catch (NoSuchFieldException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private String shuffleStr(String str) {
        return str.substring(1) + str.charAt(0);
    }

    private int getStrikeNum(String testInput) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method getStrikeNumMethod = baseballBot.getClass().getDeclaredMethod("getStrikeNum", String.class);
        getStrikeNumMethod.setAccessible(true);
        return (int) getStrikeNumMethod.invoke(baseballBot, testInput);
    }

    private int getBallNum(String shuffledAnswer, int strikeNum) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method getBallNumMethod = baseballBot.getClass().getDeclaredMethod("getBallNum", String.class, int.class);
        getBallNumMethod.setAccessible(true);
        return (int) getBallNumMethod.invoke(baseballBot, shuffledAnswer, strikeNum);
    }
}