package baseball;

import org.junit.jupiter.api.*;

import java.util.LinkedHashSet;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;


class BaseballGameTest {

    final BaseballGame bg = new BaseballGame();


    void manipulateNumber(char[] arr) {
        char tmp;

        for(int i=0; i<3; i++) {
            do {
                tmp = bg.makeRandomNum();
            } while(tmp != arr[i]);

            bg.appendRandomNum(tmp);
        }
    }


    @Nested
    class Test1{

        @BeforeEach
        void beforeTestClass() {
            manipulateNumber("123".toCharArray());
        }

        @Test
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

            final var lst = new LinkedHashSet<Character>();
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
        void test3() {
            bg.resetNum();
            assertEquals(bg.getCorrectNum().size(), 0);
        }
    }
}