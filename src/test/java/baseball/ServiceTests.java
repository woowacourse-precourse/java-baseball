package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceTests {

    @DisplayName("문자열을 한글자씩 잘라 리스트로 반환하는 서비스 테스트")
    @Test
    void stringToListTest(){
        Service service = new Service();
        List<String> stringToList = service.stringToList("1234");
        List<String> expectedResult = new ArrayList<>();

        expectedResult.add("1");
        expectedResult.add("2");
        expectedResult.add("3");
        expectedResult.add("4");

        assertEquals(expectedResult, stringToList);
    }
}
