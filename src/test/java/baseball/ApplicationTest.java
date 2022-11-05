package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

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
    void generateComputerRandomNumber_테스트(){
        //given
        final Core T = new Core();

        //when
        final List<Integer> computerRandomNumber = T.generateComputerRandomNumber();

        //then
        assertThat(computerRandomNumber.size()).as("컴퓨터 랜덤 숫자 리스트 길이 검사").isEqualTo(3);
        assertThat(computerRandomNumber.size()).as("컴퓨터 랜덤 숫자 리스트 중복 요소 검사").isEqualTo(new HashSet<>(computerRandomNumber).size());
        for(int digit : computerRandomNumber){
            assertThat(digit).as("컴퓨터 랜덤 숫자 리스트 요소 범위 검사").isBetween(1,9);
        }
    }

    @Test
    void countStrike_테스트(){
        //given
        final Core T = new Core();
        final List<List<Integer>> case1 = List.of(List.of(1,2,3), List.of(4,5,6));  // 0 strike
        final List<List<Integer>> case2 = List.of(List.of(1,2,3), List.of(4,2,6));  // 1 strike
        final List<List<Integer>> case3 = List.of(List.of(1,2,3), List.of(1,2,6));  // 2 strike
        final List<List<Integer>> case4 = List.of(List.of(1,2,3), List.of(4,2,3));  // 2 strike
        final List<List<Integer>> case5 = List.of(List.of(1,2,3), List.of(1,2,3));  // 3 strike

        //when
        final int result1 = T.countStrike(case1.get(0), case1.get(1));
        final int result2 = T.countStrike(case2.get(0), case2.get(1));
        final int result3 = T.countStrike(case3.get(0), case3.get(1));
        final int result4 = T.countStrike(case4.get(0), case4.get(1));
        final int result5 = T.countStrike(case5.get(0), case5.get(1));


        //then
        assertThat(result1).as("countStrike 테스트").isEqualTo(0);
        assertThat(result2).as("countStrike 테스트").isEqualTo(1);
        assertThat(result3).as("countStrike 테스트").isEqualTo(2);
        assertThat(result4).as("countStrike 테스트").isEqualTo(2);
        assertThat(result5).as("countStrike 테스트").isEqualTo(3);
    }

    @Test
    void isDigitStrike_테스트(){
        //given
        final Core T = new Core();
        final List<List<Integer>> case1 = List.of(List.of(1,2,3), List.of(4,2,3));  // 2 strike

        //when
        final boolean result1 = T.isDigitStrike(case1.get(0), case1.get(1), 0); //false
        final boolean result2 = T.isDigitStrike(case1.get(0), case1.get(1), 1); //true
        final boolean result3 = T.isDigitStrike(case1.get(0), case1.get(1), 2); //true

        //then
        assertThat(result1).as("isDigitalStrike 테스트").isEqualTo(false);
        assertThat(result2).as("isDigitalStrike 테스트").isEqualTo(true);
        assertThat(result3).as("isDigitalStrike 테스트").isEqualTo(true);
    }

    @Test
    void isDigitBall_테스트(){
        //given
        final Core T = new Core();
        final List<List<Integer>> case1 = List.of(List.of(1,2,3), List.of(2,1,3));
        final List<List<Integer>> case2 = List.of(List.of(1,2,3), List.of(4,5,6));

        //when
        final boolean result1 = T.isDigitBall(case1.get(0), case1.get(1), 0);   //true
        final boolean result2 = T.isDigitBall(case1.get(0), case1.get(1), 1);   //true
        final boolean result3 = T.isDigitBall(case1.get(0), case1.get(1), 2);   //false

        final boolean result4 = T.isDigitBall(case2.get(0), case2.get(1), 0);   //false
        final boolean result5 = T.isDigitBall(case2.get(0), case2.get(1), 1);   //false
        final boolean result6 = T.isDigitBall(case2.get(0), case2.get(1), 2);   //false

        //then
        assertThat(result1).as("isDigitBall 테스트").isEqualTo(true);
        assertThat(result2).as("isDigitBall 테스트").isEqualTo(true);
        assertThat(result3).as("isDigitBall 테스트").isEqualTo(false);

        assertThat(result4).as("isDigitBall 테스트").isEqualTo(false);
        assertThat(result5).as("isDigitBall 테스트").isEqualTo(false);
        assertThat(result6).as("isDigitBall 테스트").isEqualTo(false);
    }

    @Test
    void countBall_테스트(){
        //given
        final Core T = new Core();
        final List<List<Integer>> case1 = List.of(List.of(1,2,3), List.of(4,5,6));  // 0 balls
        final List<List<Integer>> case2 = List.of(List.of(3,4,5), List.of(8,5,6));  // 1 balls
        final List<List<Integer>> case3 = List.of(List.of(1,2,3), List.of(2,1,3));  // 2 balls
        final List<List<Integer>> case4 = List.of(List.of(3,6,8), List.of(6,8,3));  // 3 balls
        final List<List<Integer>> case5 = List.of(List.of(6,4,3), List.of(3,6,4));  // 3 balls

        //when
        final int result1 = T.countBall(case1.get(0), case1.get(1));
        final int result2 = T.countBall(case2.get(0), case2.get(1));
        final int result3 = T.countBall(case3.get(0), case3.get(1));
        final int result4 = T.countBall(case4.get(0), case4.get(1));
        final int result5 = T.countBall(case5.get(0), case5.get(1));

        //then
        assertThat(result1).as("countBall 테스트").isEqualTo(0);
        assertThat(result2).as("countBall 테스트").isEqualTo(1);
        assertThat(result3).as("countBall 테스트").isEqualTo(2);
        assertThat(result4).as("countBall 테스트").isEqualTo(3);
        assertThat(result5).as("countBall 테스트").isEqualTo(3);

    }

    @Test
    void isEndFlagged_테스트(){
        //given
        final Core T = new Core();
        final int case1 = 0;   //0 strike
        final int case2 = 1;   //1 strike
        final int case3 = 2;   //2 strikes
        final int case4 = 3;   //3 strikes

        //when
        final boolean result1 = T.isEndFlagged(case1);  //false
        final boolean result2 = T.isEndFlagged(case2);  //false
        final boolean result3 = T.isEndFlagged(case3);  //false
        final boolean result4 = T.isEndFlagged(case4);  //true

        //then
        assertThat(result1).as("isEndFlagged 테스트").isEqualTo(false);
        assertThat(result2).as("isEndFlagged 테스트").isEqualTo(false);
        assertThat(result3).as("isEndFlagged 테스트").isEqualTo(false);
        assertThat(result4).as("isEndFlagged 테스트").isEqualTo(true);
    }

    @Test
    void validateUserInputOneOrTwo_정상처리_테스트(){
        //given
        final Core T = new Core();
        final String case1 = "1";
        final String case2 = "2";

        //when
        final Throwable thrown1 = catchThrowable(()->{T.validateUserInputOneOrTwo(case1);});
        final Throwable thrown2 = catchThrowable(()->{T.validateUserInputOneOrTwo(case2);});

        //then
        assertThat(thrown1).as("validateUserInputOneOrTwo 정상처리 테스트").doesNotThrowAnyException();
        assertThat(thrown2).as("validateUserInputOneOrTwo 정상처리 테스트").doesNotThrowAnyException();
    }

    @Test
    void validateUserInputOneOrTwo_예외처리_테스트(){
        //given
        final Core T = new Core();
        final String case1 = "3";
        final String case2 = "294";
        final String case3 = "Exception String";
        final String case4 = "";


        //when
        final Throwable thrown1 = catchThrowable(()->{T.validateUserInputOneOrTwo(case1);});
        final Throwable thrown2 = catchThrowable(()->{T.validateUserInputOneOrTwo(case2);});
        final Throwable thrown3 = catchThrowable(()->{T.validateUserInputOneOrTwo(case3);});
        final Throwable thrown4 = catchThrowable(()->{T.validateUserInputOneOrTwo(case4);});

        //then
        assertThat(thrown1).as("validateUserInputOneOrTwo 예외처리 테스트").isInstanceOf(IllegalArgumentException.class).hasMessageContaining("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
        assertThat(thrown2).as("validateUserInputOneOrTwo 예외처리 테스트").isInstanceOf(IllegalArgumentException.class).hasMessageContaining("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
        assertThat(thrown3).as("validateUserInputOneOrTwo 예외처리 테스트").isInstanceOf(IllegalArgumentException.class).hasMessageContaining("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
        assertThat(thrown4).as("validateUserInputOneOrTwo 예외처리 테스트").isInstanceOf(IllegalArgumentException.class).hasMessageContaining("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
    }

    @Test
    void validateUserInputThreeDifferentNumbers_정상처리_테스트(){
        //given
        final Core T = new Core();
        final String case1 = "384";
        final String case2 = "247";

        //when
        final Throwable thrown1 = catchThrowable(()->{T.validateUserInputThreeDifferentNumbers(case1);});
        final Throwable thrown2 = catchThrowable(()->{T.validateUserInputThreeDifferentNumbers(case2);});

        //then
        assertThat(thrown1).as("validateUserInputThreeDifferentNumbers 정상처리 테스트").doesNotThrowAnyException();
        assertThat(thrown2).as("validateUserInputThreeDifferentNumbers 정상처리 테스트").doesNotThrowAnyException();
    }

    @Test
    void validateUserInputThreeDifferentNumbers_예외처리_테스트(){
        //given
        final Core T = new Core();
        final String case1 = "000";
        final String case2 = "272";
        final String case3 = "12345";
        final String case4 = "";
        final String case5 = "Exception String";

        //when
        final Throwable thrown1 = catchThrowable(()->{T.validateUserInputThreeDifferentNumbers(case1);});
        final Throwable thrown2 = catchThrowable(()->{T.validateUserInputThreeDifferentNumbers(case2);});
        final Throwable thrown3 = catchThrowable(()->{T.validateUserInputThreeDifferentNumbers(case3);});
        final Throwable thrown4 = catchThrowable(()->{T.validateUserInputThreeDifferentNumbers(case4);});
        final Throwable thrown5 = catchThrowable(()->{T.validateUserInputThreeDifferentNumbers(case5);});

        //then
        assertThat(thrown1).as("validateUserInputThreeDifferentNumbers 예외처리 테스트").isInstanceOf(IllegalArgumentException.class).hasMessageContaining("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
        assertThat(thrown2).as("validateUserInputThreeDifferentNumbers 예외처리 테스트").isInstanceOf(IllegalArgumentException.class).hasMessageContaining("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
        assertThat(thrown3).as("validateUserInputThreeDifferentNumbers 예외처리 테스트").isInstanceOf(IllegalArgumentException.class).hasMessageContaining("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
        assertThat(thrown4).as("validateUserInputThreeDifferentNumbers 예외처리 테스트").isInstanceOf(IllegalArgumentException.class).hasMessageContaining("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
        assertThat(thrown5).as("validateUserInputThreeDifferentNumbers 예외처리 테스트").isInstanceOf(IllegalArgumentException.class).hasMessageContaining("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
    }

    @Test
    void stringToIntegerList_테스트(){
        //given
        final Core T = new Core();
        final String case1 = "123";
        final String case2 = "837";

        //when
        final List<Integer> result1 = T.stringToIntegerList(case1);
        final List<Integer> result2 = T.stringToIntegerList(case2);

        //then
        assertThat(result1).as("stringToIntegerList 테스트").isEqualTo(List.of(1,2,3));
        assertThat(result2).as("stringToIntegerList 테스트").isEqualTo(List.of(8,3,7));

    }

    @Test
    void printGameResult_테스트(){
        //given
        final Core T = new Core();
        final List<Integer> case1 = List.of(3,0);   // 3 strikes
        final List<Integer> case2 = List.of(0,0);   // 0 strikes 0 balls
        final List<Integer> case3 = List.of(2,1);   // 2 strikes 1 balls
        final List<Integer> case4 = List.of(1,2);   // 1 strikes 2 balls
        final List<Integer> case5 = List.of(2,0);   // 2 strikes 0 balls
        final List<Integer> case6 = List.of(0,2);   // 0 strikes 1 balls

        //when
        final OutputStream result1 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result1));
        T.printGameResult(case1.get(0), case1.get(1));

        final OutputStream result2 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result2));
        T.printGameResult(case2.get(0), case2.get(1));

        final OutputStream result3 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result3));
        T.printGameResult(case3.get(0), case3.get(1));

        final OutputStream result4 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result4));
        T.printGameResult(case4.get(0), case4.get(1));

        final OutputStream result5 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result5));
        T.printGameResult(case5.get(0), case5.get(1));

        final OutputStream result6 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result6));
        T.printGameResult(case6.get(0), case6.get(1));

        //then
        assertThat(result1.toString().strip()).as("printGameResult 테스트").isEqualTo("3스트라이크");
        assertThat(result2.toString().strip()).as("printGameResult 테스트").isEqualTo("낫싱");
        assertThat(result3.toString().strip()).as("printGameResult 테스트").isEqualTo("1볼 2스트라이크");
        assertThat(result4.toString().strip()).as("printGameResult 테스트").isEqualTo("2볼 1스트라이크");
        assertThat(result5.toString().strip()).as("printGameResult 테스트").isEqualTo("2스트라이크");
        assertThat(result6.toString().strip()).as("printGameResult 테스트").isEqualTo("2볼");
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
