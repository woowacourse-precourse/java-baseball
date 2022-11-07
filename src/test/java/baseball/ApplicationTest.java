package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import util.TestHelper;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest extends NsTest {

    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void verifyInput(){
        //  given
        String input = "345";
        //  when
        int [] actual = Application.verifyInput(input);
        int [] expected = {3,4,5};
        //  then
        assertArrayEquals(expected, actual);
    }

    @Test
    void verifyInput_NumberFormatException(){
        //  given
        String input = "abc";
        //  then
        assertThrows(NumberFormatException.class,() -> Application.verifyInput(input));
    }

    @Test
    void verifyInput_IllegalArgumentException(){
        //  given
        String input = "1234";
        //  then
        assertThrows(IllegalArgumentException.class,() -> Application.verifyInput(input));
    }

    @Test
    void compareInputToTarget(){
        //  given
        String input = "123";

        int[] inputNumbers = TestHelper.stringToArray(input);
        List<Integer> targetNumbers = TestHelper.stringToList(input);

        Map<String, Integer> expected = TestHelper.createMapForTest(0, 3);
        //  when
        Map<String, Integer> actual = Application.compareInputToTarget(inputNumbers, targetNumbers);
        //  then
        assertEquals(expected,actual);
    }

    @Test
    void initializeMap(){
    	//  given
        Map<String, Integer> expected = TestHelper.createMapForTest(0, 0);
        //  when
        Map<String, Integer> actual = Application.initializeMap();
    	//  then
    	assertEquals(expected,actual);
    }

    @Test
    void convertMapToString(){
    	//  given
        String expected = "2볼 1스트라이크";
        Map<String, Integer> inputMap = TestHelper.createMapForTest(2,1);
        //  when
        String actual = Application.convertMapToString(inputMap);
    	//  then
        assertEquals(expected, actual);
    }

    @Test
    void removeZeroValueInMap(){
    	//  given
        Map<String, Integer> expected = new LinkedHashMap<>();
        expected.put("볼", 2);
        //  when
        Map<String, Integer> actual = TestHelper.createMapForTest(2,0);
        Application.removeZeroValueInMap(actual);
    	//  then
        assertEquals(expected, actual);
    }

    @Test
    void mapToStringInOrder(){
    	//  given
        String expected = "2볼 1스트라이크";
        Map<String, Integer> inputMap = TestHelper.createMapForTest(2,1);
        //  when
        String actual = Application.mapToStringInOrder(inputMap);
    	//  then
        assertEquals(expected, actual);
    }

    @Test
    void verifyFlag_NumberFormatException(){
    	//  given
        String input = "A";
    	//  then
        assertThrows(NumberFormatException.class, () -> Application.verifyFlag(input));
    }

    @Test
    void verifyFlag_IllegalArgumentException(){
        //  given
        String input = "12";
        //  then
        assertThrows(IllegalArgumentException.class, () -> Application.verifyFlag(input));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
