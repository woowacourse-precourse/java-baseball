package baseball;

import java.util.regex.Pattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ServiceTest {

    @DisplayName("문자열을 한글자씩 잘라 리스트로 반환하는 메서드 테스트")
    @Test
    void stringToListTest() {
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

    @DisplayName("리스트에 이미 문자열이 있다면 추가하지 않는 메서드 테스트")
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
        List<String> addDuplicatedString = (ArrayList) testMethod.invoke(service, testDuplicated, "1");
        List<String> addUnduplicatedString = (ArrayList) testMethod.invoke(service, testUnduplicated, "9");

        //then
        assertNotEquals(addDuplicatedString, addUnduplicatedString);
        assertEquals(2, addDuplicatedString.size());
        assertEquals(3, addUnduplicatedString.size());
    }

    @DisplayName("중복 제거한 난수 생성 메서드 테스트")
    @Test
    void generateRandomNumberTest() {
        //given
        Service service = new Service();
        for (int loopCount = 0; 1000 > loopCount; loopCount++) {
            //when
            List<String> randomNumbers = service.generateRandomNumber(1, 9, 3);
            Set<String> deduplicateNumbers = new HashSet<>(randomNumbers);
            //then
            assertEquals(deduplicateNumbers.size(), 3);
        }
    }

    @DisplayName("스트라이크(문자열 리스트의 값과 인덱스가 모두 같은)개수를 반환하는 메서드 테스트")
    @Test
    void getNumberOfStrikesTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        Service service = new Service();
        List<String> answerNumbers = new ArrayList<>();
        List<String> questionNumbers = new ArrayList<>();

        answerNumbers.add("1");
        answerNumbers.add("2");
        answerNumbers.add("3");
        questionNumbers.add("1");
        questionNumbers.add("2");
        questionNumbers.add("9");//해당 문자만 답과 다르다

        Method testMethod = service.getClass().getDeclaredMethod("getNumberOfStrikes", List.class, List.class);
        testMethod.setAccessible(true);
        //when
        int strikeCount = (int) testMethod.invoke(service, questionNumbers, answerNumbers);
        //then
        assertEquals(2, strikeCount);
    }

    @DisplayName("볼(문자열 리스트의 값은 포함되지만 인덱스는 다른 문자열)개수를 반환하는 메서드 테스트")
    @Test
    void getNumberOfBallsTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        Service service = new Service();
        List<String> answerNumbers = new ArrayList<>();
        List<String> questionNumbers = new ArrayList<>();

        answerNumbers.add("5");
        answerNumbers.add("1");
        answerNumbers.add("3");
        questionNumbers.add("1");//해당 문자는 인덱스가 다르고 값은 포함
        questionNumbers.add("6");//포함되지 않은 문자열
        questionNumbers.add("3");//해당 문자는 값과 인덱스가 동일(strikeCount가 1인 이유)

        int strikeCount = 1;

        Method testMethod = service.getClass().getDeclaredMethod("getNumberOfBalls", List.class, List.class, int.class);
        testMethod.setAccessible(true);
        //when
        int numberOfBalls = (int) testMethod.invoke(service, questionNumbers, answerNumbers, 1);
        //then
        assertEquals(1, numberOfBalls);
    }

    @DisplayName("볼카운트(볼, 스트라이크 개수)를 반환하는 메서드 테스트")
    @Test
    void getBallCountTest() {
        //given
        Service service = new Service();
        List<String> answerNumbers = new ArrayList<>();
        List<String> questionNumbers = new ArrayList<>();

        answerNumbers.add("5");
        answerNumbers.add("1");
        answerNumbers.add("3");
        questionNumbers.add("1");//ball
        questionNumbers.add("6");//포함되지 않은 문자열
        questionNumbers.add("3");//strike
        //when
        Map<String, Integer> ballCount = service.getBallCount(questionNumbers, answerNumbers);
        //then
        assertEquals(1, ballCount.get("strikeCount"));
        assertEquals(1, ballCount.get("ballCount"));
    }

    @DisplayName("유저의 문자열을 한글자씩 잘라 리스트로 반환하는 메서드 - 예외 테스트")
    @Test
    void getUserInputToListExceptionTest() {
        //given
        Service service = new Service();
        Pattern pattern = Pattern.compile("^[1-9]*$");
        //when, then
        assertThrows(IllegalArgumentException.class, () -> {
            service.getUserInputToList("012", 3, pattern);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            service.getUserInputToList("121", 3, pattern);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            service.getUserInputToList("1234", 3, pattern);
        });
    }

    @DisplayName("유저의 문자열을 한글자씩 잘라 리스트로 반환하는 메서드 - 정상 동작")
    @Test
    void getUserInputToListTest() {
        //given
        Service service = new Service();
        Pattern pattern = Pattern.compile("^[1-9]*$");
        List<String> testList = new ArrayList<>();

        testList.add("1");
        testList.add("2");
        testList.add("3");
        //when
        List<String> userInputList = service.getUserInputToList("123", 3, pattern);
        //then
        assertEquals(userInputList, testList);
    }

}
