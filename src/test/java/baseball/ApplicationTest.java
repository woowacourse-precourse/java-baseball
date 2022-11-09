package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import model.Computer;
import model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ApplicationTest extends NsTest {

    @Test
        // 컴퓨터 135, 589
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
        // 컴퓨터 135, 589
    void 게임종료_후_재시작_3() {
        assertRandomNumberInRangeTest(
            () -> {
                run("246", "135", "1", "197", "589", "2");
                assertThat(output()).contains("낫싱", "3스트라이크", "1볼", "3스트라이크", "게임 종료");
            },
            1, 3, 5, 5, 8, 9
        );
    }

    @Test
        // 컴퓨터 135, 589
    void 게임종료_후_재시작_2() {
        assertRandomNumberInRangeTest(
            () -> {
                run("123", "589", "1", "597", "589", "2");
                assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크",
                    "게임 종료");
            },
            5, 8, 9, 5, 8, 9
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
    void 예외_테스트_추가_1() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("111"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_추가_2() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_추가_3() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("qwe"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // TODO: USER 테스트
    private static User user_;

    @BeforeAll
    static void initAll() {
        user_ = new User();
    }

    @Test
    @DisplayName("입력을 제대로 받았는지 확인")
    void 문자_입력_테스트() throws Exception {
        //given
        User user = new User();
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        // when
        user.inputNumOfUser();
        int result = user.getNumSelecUser();
        // then
        assertThat(result).isEqualTo(123);
    }

    @Test
    @DisplayName("실수 입력받을때")
    void 문자_입력_예외_테스트_case_1() throws Exception {
        //given
        User user = new User();
        String input = "문자를입력";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        // when
        // then
        assertThatThrownBy(user::inputNumOfUser).isInstanceOf(
            IllegalArgumentException.class);
    }

    @Test
    @DisplayName("음수 입력받을때")
    void 문자_입력_예외_테스트_case_2() throws Exception {
        //given
        User user = new User();
        String input = "-3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        // when
        // then
        assertThatThrownBy(user::inputNumOfUser).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 길이가 초가할때 예외처리")
    void 문자_입력_예외_테스트_case_3() throws Exception {
        //given
        User user = new User();
        String input = "1234";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        // when
        // then
        assertThatThrownBy(user::inputNumOfUser).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 길이가 초과할때 예외처리")
    void 문자_입력_예외_테스트_case_연습() throws Exception {
        //given asdasd
        User user = new User();
        String input = "1234";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        // when
        // then
        assertThatThrownBy(user::inputNumOfUser).isInstanceOf(
            IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력한 숫자가 각각 자릿수가 같은지 확인")
    void 문자_입력_예외_테스트_case_4() throws Exception {
        //given
        User user = new User();
        String input = "111";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        // when
        // then
        assertThatThrownBy(user::inputNumOfUser).isInstanceOf(IllegalArgumentException.class);
    }

    // TODO: computer
    @Test
    @DisplayName("컴퓨터의 랜덤 숫자 3개를 가진 List의 크기가 3인가를 테스트")
    void 컴퓨터_랜덤_숫자_생성_크기_테스트_case_1() throws Exception {
        //given
        Computer computer = new Computer();
        computer.initComputer();
        // when
        List<Integer> resultList = computer.getNumThreeRanOfComputerList();
        // then
        assertThat(resultList.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("컴퓨터의 랜덤 숫자 3개를 가진 List의 크기가 3인가를 테스트")
    void 컴퓨터_랜덤_숫자_생성_크기_테스트_case_메서드_연습() throws Exception {
        //given
        Computer computer = new Computer();
        computer.initComputer();
        // when
        int result = computer.getNumThreeRanOfComputerList().size();
        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("컴퓨터의 List를 initComputer메서드를 호출할때 랜덤이 되는가")
    void 컴퓨터_랜덤숫자_리스트_초기화_case_1() throws Exception {
        //given
        Computer computer = new Computer();
        // when
        computer.initComputer();
        List<Integer> resultList_1 = computer.getNumThreeRanOfComputerList();
        computer.initComputer();
        List<Integer> resultList_2 = computer.getNumThreeRanOfComputerList();
        // then
        assertNotEquals(resultList_1, resultList_2);
    }

    @Test
    void 유저숫자_스트라이트_볼_낫싱_체크_case() throws Exception {
        //given
        List<List<Integer>> numInputUser = new ArrayList<>(List.of(
            // 스트라이크 3 , 볼 0
            List.of(123),
            // 스트라이크 2 , 볼 0
            List.of(124, 143, 423),
            // 스트라이크 1 , 볼 2
            List.of(132, 321, 213),
            // 스트라이크 1 , 볼 1
            List.of(182, 134, 521, 324, 813, 283),
            // 스트라이크 1 , 볼 0
            List.of(184, 826, 483),
            // 스트라이크 0 , 볼 1
            List.of(416, 651, 247, 562, 357, 635),
            // 스트라이크 0 , 볼 2
            List.of(712, 218, 251, 238, 732, 352, 314, 381, 431),
            // 스트라이크 0 , 볼 3
            List.of(312, 231),
            // 스트라이크 0 , 볼 0
            List.of(798, 486, 589, 497, 465, 564, 464, 564, 654, 899, 789)
        ));
        Computer computer = new Computer();
        computer.numThreeRanOfComputerList = new ArrayList<>(List.of(
            1, 2, 3
        ));
        List<List<Integer>> trueList = new ArrayList<>(
            List.of(
                List.of(3, 0),
                List.of(2, 0),
                List.of(1, 2),
                List.of(1, 1),
                List.of(1, 0),
                List.of(0, 1),
                List.of(0, 2),
                List.of(0, 3),
                List.of(0, 0)
            )
        );
        List<List<Integer>> ResultList = new ArrayList<>();
        // when
        for (List<Integer> list : numInputUser) {
            for (int num : list) {
                computer.initCntStrikeBall();
                computer.checkThreeInputNumOfUser2Game(num);
            }
            ResultList.add(List.of(computer.getCntStrike(), computer.getCntBall()));
        }
        // then
        assertThat(ResultList).containsAll(trueList);
    }


    @Test
    void 컴퓨터가_유저에게_힌트를_준다() throws Exception {
        //given
        List<Integer> numInputUser = new ArrayList<>(List.of(
            // 3스트라이크
            123,
            // 2스트라이크
            124,
            // 2볼 1스트라이크
            132,
            // 1볼 1스트라이크
            182,
            // 1스트라이크
            184,
            // 1볼
            416,
            // 2볼
            712,
            // 3볼
            312,
            // 낫싱
            798
        ));
        Computer computer = new Computer();
        computer.numThreeRanOfComputerList = new ArrayList<>(List.of(
            1, 2, 3
        ));
        List<String> hints = new ArrayList<>(
            List.of(
                "3스트라이크",
                "2스트라이크",
                "2볼 1스트라이크",
                "1볼 1스트라이크",
                "1스트라이크",
                "1볼 ",
                "2볼 ",
                "3볼 ",
                "낫싱"
            )
        );
        List<String> hintResult = new ArrayList<>();
        // when
        for (int num : numInputUser) {
            computer.checkThreeInputNumOfUser2Game(num);
            hintResult.add(computer.toString());
            computer.initCntStrikeBall();

        }
        // then
        assertThat(hintResult).containsAll(hints);
    }

    @Test
        // Computer.isEndTheGame
    void 게임종료_확인_case_1() {
        Computer computer = new Computer();
        computer.numThreeRanOfComputerList = new ArrayList<>(List.of(
            1, 2, 3
        ));
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        computer.checkThreeInputNumOfUser2Game(123);
        boolean result = computer.isEndTheGame();
        assertThat(result).isTrue();
    }

    @ParameterizedTest(name = "유저가 던지는 숫자, 3스트라이크를 제외한다.")
    @ValueSource(ints = {124, 143, 423, 132, 321, 213, 182, 134, 521, 324, 813, 283, 184,
        826, 483, 416, 651, 247, 562, 357, 635, 712, 218, 251, 238, 732, 352, 314, 381, 431,
        312, 231, 798, 486, 589, 497, 465, 564, 464, 564, 654, 899, 789})
    @DisplayName("게임 종류가 안되야 된다. false가 결과 ")
    void 게임종료_확인_case_2(int testInt) {
        Computer computer = new Computer();
        computer.numThreeRanOfComputerList = new ArrayList<>(List.of(
            1, 2, 3
        ));
        ArrayList<Boolean> resultList = new ArrayList<>();
        computer.checkThreeInputNumOfUser2Game(testInt);
        boolean result = computer.isEndTheGame();
        assertFalse(result);
    }

    @ParameterizedTest(name = "게임진행을 위한 입력에 들어가는 값 1과 2가 들어간다.")
    @ValueSource(strings = {"1", "2"})
    @DisplayName("게임 진행의 값을 얻는 함수")
    void 게임_진행의_값을_얻는_함수_테스트_1(String str) throws Exception {
        //given
        User user = new User();
        // 입력을 담는다.
        InputStream in = new ByteArrayInputStream(str.getBytes());
        System.setIn(in);
        // when
        user.inputProceedNum();
        String result = String.valueOf(user.getNumProceedUser());
        // then
        assertThat(result).isEqualTo(str);
    }

    @ParameterizedTest(name = "게임진행을 위한 값에대한 예외처리 확인")
    @ValueSource(strings = {"0", "812", "-1", "asdfasdf"})
    @DisplayName("게임진행을 위한 값에대한 예외 테스트")
    void 게임_진행의_값을_얻는_함수_예외테스트_1(String str) throws Exception {
        //given
        User user = new User();
        // 입력을 담는다.
        InputStream in = new ByteArrayInputStream(str.getBytes());
        System.setIn(in);
        // when
        // then
        assertThatThrownBy(user::inputProceedNum).isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
