package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Nested
    class ValidCheckTest {
        @Test
        void testExceptionNumber() {
            HashMap<Integer, Integer> dummyHashmap = new HashMap<>();
            dummyHashmap.put(1, 1);
            dummyHashmap.put(2, 2);
            dummyHashmap.put(3, 3);
            assertThatThrownBy(() -> ValidCheck.checkExceptionNumber("1232", dummyHashmap))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void testExceptionNumber2() {
            HashMap<Integer, Integer> dummyHashmap = new HashMap<>();
            dummyHashmap.put(1, 1);
            dummyHashmap.put(2, 2);
            assertThatThrownBy(() -> ValidCheck.checkExceptionNumber("122", dummyHashmap))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void testExceptionNumber3() {
            HashMap<Integer, Integer> dummyHashmap = new HashMap<>();
            dummyHashmap.put(1, 1);
            dummyHashmap.put(2, 2);
            dummyHashmap.put(3, 3);
            assertThat(ValidCheck.checkExceptionNumber("123", dummyHashmap)).isNull();
        }

        @Test
        void testIsContinue() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> ValidCheck.checkExceptionIsContinue("1234"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void testIsContinue2() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> ValidCheck.checkExceptionIsContinue("a"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @Nested
    class GameManagerTest {
        @Test
        void scanNumber() {
            String input = "123";
            OutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            HashMap<Integer, Integer> inputNumberMap = GameManager.scanNumber();
            HashMap<Integer, Integer> expectResult = new HashMap<>();
            expectResult.put(1, 1);
            expectResult.put(2, 2);
            expectResult.put(3, 3);
            assertThat(inputNumberMap).isEqualTo(expectResult);
        }

        @Test
        void scanIsContinue() {
            String input = "1";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            GameManager.scanIsContinue();
            assertThat(GameManager.getIsContinue()).isEqualTo(true);
        }

        @Test
        void scanIsContinue2() {
            String input = "2";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            GameManager.scanIsContinue();
            assertThat(GameManager.getIsContinue()).isEqualTo(false);
        }

        @Test
        void scanIsContinue3() {
            String input = "3";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> GameManager.scanIsContinue())
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void judgeNumber() {
            String input = "123";
            OutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            GameManager.scanNumber();
            HashMap<Character, Integer> result = GameManager.judgeResult();
            assertThat(result).containsKeys('S', 'B', 'O');
            ArrayList<Integer> numArray = new ArrayList<>(result.values());
            assertThat(numArray.stream().mapToInt(Integer::intValue).sum()).isEqualTo(3);
        }

        @Test
        void printResult() {
            HashMap<Character, Integer> resultHash = new HashMap<>();
            resultHash.put('S', 1);
            resultHash.put('B', 1);
            resultHash.put('O', 1);
            GameManager.setResultHash(resultHash);
            OutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            GameManager.printResult();
            assertThat(out.toString()).isEqualTo("1볼 1스트라이크\n");
        }

        @Test
        void printResult2() {
            HashMap<Character, Integer> resultHash = new HashMap<>();
            resultHash.put('S', 3);
            resultHash.put('B', 0);
            resultHash.put('O', 0);
            GameManager.setResultHash(resultHash);
            OutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            GameManager.printResult();
            assertThat(out.toString()).isEqualTo("3스트라이크\n");
        }
    }

    @Nested
    class ComputerTest {
        @Test
        void generatingNumber() {
            HashMap<Integer, Integer> RandomNumberMap = Computer.generateRandomNumber();
            assertThat(RandomNumberMap).hasSize(3);
            assertThat(RandomNumberMap).containsValues(1, 2, 3);
            assertThat(RandomNumberMap).doesNotContainKey(0);
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
