package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

public class ServiceTests {

    @DisplayName("문자열을 한글자씩 잘라 리스트로 반환하는 메서드 테스트")
    @Test
    void stringToListTest(){
        //given
        Service service = new Service();
        List<String> expectedResult = new ArrayList<>();

        expectedResult.add("1");
        expectedResult.add("2");
        expectedResult.add("3");
        expectedResult.add("4");
        //when
        List<String> stringToList = service.stringToList("1234");
        //then
        assertEquals(expectedResult, stringToList);
    }

    @DisplayName("리스트에 이미 문자열이 있다면 추가하지 않는 메서드")
    @Test
    void AddToListExcludeContainsStringTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        Service service = new Service();
        List<String> testDuplicated = new ArrayList<>();
        testDuplicated.add("1");
        testDuplicated.add("2");
        List<String> testUnduplicated = new ArrayList<>(testDuplicated);

        Method testMethod = service.getClass().getDeclaredMethod("AddToListExcludeContainsString", List.class, String.class);
        testMethod.setAccessible(true);
        //when
        List<String> addDuplicatedString = (ArrayList)testMethod.invoke(service, testDuplicated,"1");
        List<String> addUnduplicatedString = (ArrayList) testMethod.invoke(service, testUnduplicated,"9");

        //then
        assertNotEquals(addDuplicatedString, addUnduplicatedString);
        assertEquals(2, addDuplicatedString.size());
        assertEquals(3, addUnduplicatedString.size());
    }

    @DisplayName("리스트에 이미 문자열이 있다면 추가하지 않는 메서드")
    @Test
    void generateRandomNumberTest() {
        //given
        Service service = new Service();
        for(int loopCount = 0; 1000 > loopCount; loopCount++){
            //when
            List<String> randomNumbers = service.generateRandomNumber(1, 9, 3);
            Set<String> deduplicateNumbers = new HashSet<>(randomNumbers);
            //then
            assertEquals(deduplicateNumbers.size(), 3);
        }
    }
}
