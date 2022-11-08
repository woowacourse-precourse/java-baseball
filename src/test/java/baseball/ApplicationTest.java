package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.*;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest extends NsTest {

    static String ANSWER1 = "123";
    static String ANSWER2 = "456";
    static int[] ANSWER1_ARR = Arrays.stream(ANSWER1.split("")).mapToInt(Integer::parseInt).toArray();
    static int[] ANSWER2_ARR = Arrays.stream(ANSWER2.split("")).mapToInt(Integer::parseInt).toArray();

    static String START_GAME = "1";
    static String END_GAME = "2";
    static String TEST_STRING = "test";
    static List<Character> TEST_STRING_TO_CHAR_LIST = List.of('t','e','s','t');

    static final String GAME_GET_NUMBER = "숫자를 입력해주세요 : ";
    static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    static final String GAME_RESTART_OR_END = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    static final String GAME_CORRECT_ANSWER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    List<String> onlyResult(String input) {
        input = input.replace("\r", "");
        input = input.replace(GAME_START, "");
        input = input.replace(GAME_CORRECT_ANSWER, "");
        input = input.replace(GAME_GET_NUMBER, "");
        input = input.replace(GAME_RESTART_OR_END, "");
        input = input.replace(" ", "");
        List<String> result = new ArrayList<>(List.of(input.split("\n")));
        result.remove("");
        return result;
    }

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
    void inGameTest_예외_네_개의_숫자_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void inGameTest_예외_숫자가_아닌_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("num"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void inGameTest_예외_0이_포함된_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("103"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void inGameTest_예외_중복된_숫자_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("113"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void endGameTest_예외_1이나_2가_아닌_숫자() {
        String notValidInput = "3";
        assertSimpleTest(() ->
                assertThatThrownBy(() ->
                        assertRandomNumberInRangeTest(
                                () -> {
                                    run(ANSWER1, notValidInput);
                                },
                                ANSWER1_ARR[0], ANSWER1_ARR[1], ANSWER1_ARR[2]
                        ))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void endGameTest_예외_숫자가_아닌_입력() {
        String notValidInput = "X";
        assertSimpleTest(() ->
                assertThatThrownBy(() ->
                        assertRandomNumberInRangeTest(
                                () -> {
                                    run(ANSWER1, notValidInput);
                                },
                                ANSWER1_ARR[0], ANSWER1_ARR[1], ANSWER1_ARR[2]
                        ))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void inGameTest_볼_갯수_세기() {
        String[] inputs = {"312", "234", "345", ANSWER1, END_GAME};
        assertRandomNumberInRangeTest(
                () -> {
                    run(inputs);
                },
                ANSWER1_ARR[0], ANSWER1_ARR[1], ANSWER1_ARR[2]
        );
        assertThat(onlyResult(output())).containsExactly("3볼", "2볼", "1볼", "3스트라이크");
    }

    @Test
    void inGameTest_스트라이크_갯수_세기() {
        String[] inputs = {"145", "124", "123", END_GAME};
        assertRandomNumberInRangeTest(
                () -> {
                    run(inputs);
                },
                ANSWER1_ARR[0], ANSWER1_ARR[1], ANSWER1_ARR[2]
        );
        assertThat(onlyResult(output())).containsExactly("1스트라이크", "2스트라이크", "3스트라이크");
    }


    @Test
    void inGameTest_매치되지_않음() {
        String[] inputs = {"456", ANSWER1, END_GAME};
        assertRandomNumberInRangeTest(
                () -> {
                    run(inputs);
                },
                ANSWER1_ARR[0], ANSWER1_ARR[1], ANSWER1_ARR[2]
        );
        assertThat(onlyResult(output())).containsExactly("낫싱", "3스트라이크");
    }

    @Test
    void inGameTest_정답_입력() {
        String[] inputs = {ANSWER1, END_GAME};
        assertRandomNumberInRangeTest(
                () -> {
                    run(inputs);
                },
                ANSWER1_ARR[0], ANSWER1_ARR[1], ANSWER1_ARR[2]
        );
        assertThat(onlyResult(output())).containsExactly("3스트라이크");
    }

    @Test
    void printTest_기본_게임_진행_문구() {
        String[] inputs = {ANSWER1, END_GAME};
        assertRandomNumberInRangeTest(
                () -> {
                    run(inputs);
                },
                ANSWER1_ARR[0], ANSWER1_ARR[1], ANSWER1_ARR[2]
        );
        assertThat(output()).contains(
                GAME_START,
                GAME_GET_NUMBER,
                GAME_CORRECT_ANSWER,
                GAME_RESTART_OR_END);
    }

    @Test
    void UtilsTest_CharConvert() {
        String input = TEST_STRING;
        List<Character> list = Utils.StringToCharList(input);
        HashSet<Character> set = Utils.StringToCharSet(input);
        List<Character> answerList = new ArrayList<>(TEST_STRING_TO_CHAR_LIST);
        HashSet<Character> answerSet = new HashSet<>(TEST_STRING_TO_CHAR_LIST);

        assertThat(list).isEqualTo(answerList);
        assertThat(set).isEqualTo(answerSet);
    }

    @Test
    void UtilsTest_addOneToMap() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put(TEST_STRING, 1);
        HashMap<String, Integer> answerMap = map;
        answerMap.put(TEST_STRING, 2);
        Utils.addOneToMap(map, TEST_STRING);
        assertThat(map).isEqualTo(answerMap);
    }

    @Test
    void InputTest_InGame() {
        byte[] buf = "123".getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        List<Character> input = Input.getInputInGame();
        assertThat(input).isEqualTo(List.of('1','2','3'));
    }

    @Test
    void InputTest_EndGame(){
        byte[] bufRestart = "1".getBytes();
        System.setIn(new ByteArrayInputStream(bufRestart));
        char inputRestart = Input.getInputEndGame();

        byte[] bufEnd = "2".getBytes();
        System.setIn(new ByteArrayInputStream(bufEnd));
        char inputEnd = Input.getInputEndGame();

        assertThat(inputRestart).isEqualTo('1');
        assertThat(inputEnd).isEqualTo('2');
    }
    /*   @Test
       void

       @Test
       void

       @Test
       void


       @Test*/
    void GameTest_생성된_숫자가_중복되지_않는_세자리_숫자() {

    }


    @Test
    void printTest_볼_only_문구() {

    }

    @Test
    void printTest_스트라이크_only_문구() {

    }

    @Test
    void printTest_볼_and_스트라이크_문구() {

    }

    @Test
    void printTest_낫싱_문구() {

    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
