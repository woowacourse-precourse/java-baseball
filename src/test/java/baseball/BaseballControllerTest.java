package baseball;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import java.util.List;
import org.junit.jupiter.api.Test;

class BaseballControllerTest {

    @Test
    void getBallAndStrikeCount_테스트() throws NoSuchFieldException, IllegalAccessException {
        //given
        BaseballController baseballController = new BaseballController(3);
        Field baseballServiceField = baseballController.getClass().getDeclaredField("baseballService");
        baseballServiceField.setAccessible(true);
        BaseballService baseballService = (BaseballService) baseballServiceField.get(baseballController);

        Field answerListField = baseballService.getClass().getDeclaredField("answerNumberList");
        answerListField.setAccessible(true);

        //when
        List<Integer> answerList = (List<Integer>) answerListField.get(baseballService);
        String inputString = "";
        for (int number : answerList) {
            inputString += number;
        }
        List<Integer> result = baseballController.getBallAndStrikeCount(inputString);

        //then
        assertEquals(List.of(0, 3), result);
    }

    @Test
    void getBallAndStrikeCount_입력값_길이_예외처리_테스트() throws NoSuchFieldException, IllegalAccessException {
        //given
        BaseballController baseballController = new BaseballController(3);
        boolean exceptionCatched = false;
        //when
        try {
            baseballController.getBallAndStrikeCount("1234");
        } catch (IllegalArgumentException e) {
            exceptionCatched = true;
        }

        //then
        assertTrue(exceptionCatched);
    }

    @Test
    void getBallAndStrikeCount_문자열_예외처리_테스트() throws NoSuchFieldException, IllegalAccessException {
        //given
        BaseballController baseballController = new BaseballController(3);
        boolean exceptionCatched = false;
        //when
        try {
            baseballController.getBallAndStrikeCount("12a");
        } catch (IllegalArgumentException e) {
            exceptionCatched = true;
        }

        //then
        assertTrue(exceptionCatched);
    }

    @Test
    void getBallAndStrikeCount_중복값_예외처리_테스트() throws NoSuchFieldException, IllegalAccessException {
        //given
        BaseballController baseballController = new BaseballController(3);
        boolean exceptionCatched = false;
        //when
        try {
            baseballController.getBallAndStrikeCount("112");
        } catch (IllegalArgumentException e) {
            exceptionCatched = true;
        }

        //then
        assertTrue(exceptionCatched);
    }

    @Test
    void getBallAndStrikeCount_0_예외처리_테스트() throws NoSuchFieldException, IllegalAccessException {
        //given
        BaseballController baseballController = new BaseballController(3);
        boolean exceptionCatched = false;
        //when
        try {
            baseballController.getBallAndStrikeCount("120");
        } catch (IllegalArgumentException e) {
            exceptionCatched = true;
        }

        //then
        assertTrue(exceptionCatched);
    }

    @Test
    void restartGame_테스트() {
        //given
        BaseballController baseballController = new BaseballController(3);

        //when
        boolean restart = baseballController.restartGame("1");
        boolean notRestart = baseballController.restartGame("2");

        //then
        assertTrue(restart);
        assertFalse(notRestart);
    }

    @Test
    void restartGame_예외처리_테스트() {
        //given
        BaseballController baseballController = new BaseballController(3);
        boolean exceptionCatched = false;
        //when
        try {
            baseballController.restartGame("3");
        } catch (IllegalArgumentException e) {
            exceptionCatched = true;
        }

        //then
        assertTrue(exceptionCatched);
    }
}