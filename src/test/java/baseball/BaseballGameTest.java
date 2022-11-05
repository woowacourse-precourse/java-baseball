package baseball;

import org.junit.jupiter.api.*;

import java.util.LinkedHashSet;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;


class BaseballGameTest {

    BaseballGame bg = new BaseballGame();


    void manipulateNumber(char[] arr) {
        char tmp;

        for(int i=0; i<3; i++) {
            do {
                tmp = bg.makeRandomNum();
            } while(tmp != arr[i]);

            bg.putRandomNum(tmp);
        }
    }


    @Nested
    class Test1{

        @BeforeEach
        void beforeTestClass() {
            manipulateNumber("123".toCharArray());
        }

        @Test
        @DisplayName("랜덤 값이 제대로 실행 되는가?")
        void test1() {
            Iterator<Character> iteration = bg.getCorrectNum().iterator();

            assertAll(
                    () -> assertEquals('1', iteration.next()),
                    () -> assertEquals('2', iteration.next()),
                    () -> assertEquals('3', iteration.next())
            );
        }

        @Test
        void test2() {
            final LinkedHashSet<Character> lst = new LinkedHashSet<>();
            lst.add('1');
            lst.add('3');
            lst.add('4');

            bg.submitNum(lst);
            assertAll(
                    () -> assertEquals(bg.getBall(), 1),
                    () -> assertEquals(bg.getStrike(), 1)
            );
        }

        @Test
        @DisplayName("값이 제대로 삭제가 되는가?")
        void test3() {
            bg.resetNum();
            assertEquals(bg.getCorrectNum().size(), 0);
        }
    }
}