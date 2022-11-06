package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class BaseballServiceTest {

    @Test
    void getBallAndStrikeCounts_테스트() throws NoSuchFieldException, IllegalAccessException {
        //given
        BaseballService baseballService = new BaseballService(3);
        Field field = baseballService.getClass().getDeclaredField("answerNumberList");
        field.setAccessible(true);

        //when
        field.set(baseballService,List.of(1,2,3));
        List<Integer> inputNumberList = List.of(1,3,2);
        List<Integer> ballAndStrikeCounts = baseballService.getBallAndStrikeCounts(inputNumberList);

        //then
        assertEquals(List.of(2,1),ballAndStrikeCounts);
    }

    @Test
    void setAnswerNumberList_테스트() throws NoSuchFieldException, IllegalAccessException {
        //given
        BaseballService baseballService = new BaseballService(3);
        Field field = baseballService.getClass().getDeclaredField("answerNumberList");
        field.setAccessible(true);

        //when
        baseballService.setAnswerNumberList();
        List<Integer> answerNumberList = (List<Integer>) field.get(baseballService);
        Set<Integer> answerNumberSet = new HashSet<>(answerNumberList);

        //then
        assertEquals(3,answerNumberList.size());
        assertEquals(answerNumberSet.size(), answerNumberList.size());

    }

    @Test
    void addRandomNumberToList_테스트() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        BaseballService baseballService = new BaseballService(3);
        Method method = baseballService.getClass().getDeclaredMethod("addRandomNumberToList", List.class);
        method.setAccessible(true);

        List<Integer> list = new ArrayList<>();

        //when
        for (int i = 0; i < 3; i ++){
            method.invoke(baseballService, list);
        }
        Set<Integer> set = new HashSet<>(list);

        //then
        assertEquals(3, list.size());
        assertEquals(set.size(),list.size());
    }
}