package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UnitTest {

    Application application;
    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    @BeforeEach
    public void init(){
        application = new Application();
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void printStartGame_정상_테스트(){
        //given

        //when
        application.printStartGame();

        //then
    }

    @Test
    public void makeRandomNumber_정상_테스트(){
        //given

        //when
        int result = application.makeRandomNumber();
        boolean state = checkIfEachDifferent(result);

        //then
        Assertions.assertThat(result).isGreaterThanOrEqualTo(100);
        Assertions.assertThat(result).isLessThanOrEqualTo(999);
        Assertions.assertThat(state).isEqualTo(true);
    }

    @Test
    public void insertNumber_정상_테스트(){
        //given
        String input = "130";

        //when
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int result = application.insertNumber();

        //then
        Assertions.assertThat(result).isEqualTo(130);
    }

    @Test
    public void insertNumber_예외_테스트_입력받는_것이_문자일때(){
        //given
        String input = "abc";

        //when
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //then
        assertThatThrownBy(() -> application.insertNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력하신 변수가 숫자형이 아닙니다");
    }

    @Test
    public void insertNumber_예외_테스트_입력받는_것이_실수일때(){
        //given
        String input = "13.01";

        //when
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //then
        assertThatThrownBy(() -> application.insertNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력하신 변수가 숫자형이 아닙니다");
    }

    @Test
    public void insertNumber_예외_테스트_입력받는_것이_음수일때(){
        //given
        String input = "-130";

        //when
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //then
        assertThatThrownBy(() -> application.insertNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력하신 변수가 3자리 정수가 아닙니다");
    }

    @Test
    public void insertNumber_예외_테스트_입력받는_것이_4자리정수일때(){
        //given
        String input = "1234";

        //when
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //then
        assertThatThrownBy(() -> application.insertNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력하신 변수가 3자리 정수가 아닙니다");
    }

    @Test
    public void insertNumber_예외_테스트_입력받는_것이_2자리정수일때(){
        //given
        String input = "12";

        //when
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //then
        assertThatThrownBy(() -> application.insertNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력하신 변수가 3자리 정수가 아닙니다");
    }

    @Test
    public void insertNumber_예외_테스트_입력받는_것이_백의자리와_십의자리가_같을때(){
        //given
        String input = "112";

        //when
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //then
        assertThatThrownBy(() -> application.insertNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3자리가 모두 다른 숫자가 아닙니다");
    }

    @Test
    public void insertNumber_예외_테스트_입력받는_것이_십의자리와_일의자리가_같을때(){
        //given
        String input = "211";

        //when
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //then
        assertThatThrownBy(() -> application.insertNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3자리가 모두 다른 숫자가 아닙니다");
    }
    @Test
    public void insertNumber_예외_테스트_입력받는_것이_백의자리와_일의자리가_같을때(){
        //given
        String input = "121";

        //when
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //then
        assertThatThrownBy(() -> application.insertNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3자리가 모두 다른 숫자가 아닙니다");
    }
    @Test
    public void insertNumber_예외_테스트_입력받는_것이_모든자릿수가_같을때(){
        //given
        String input = "111";

        //when
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //then
        assertThatThrownBy(() -> application.insertNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3자리가 모두 다른 숫자가 아닙니다");
    }

    @Test
    public void judge_모두_맟주었을떄_테스트(){
        //given
        int answer = 123;
        int value = 123;

        //when
        int[] judge = application.judge(answer, value);

        //then
        Assertions.assertThat(judge).containsExactly(3,0);
    }

    @Test
    public void judge_모두_틀렸을때_테스트(){
        //given
        int answer = 123;
        int value = 312;

        //when
        int[] judge = application.judge(answer, value);

        //then
        Assertions.assertThat(judge).containsExactly(0,3);
    }

    @Test
    public void judge_백의_자리가_다를_경우_테스트(){
        //given
        int answer = 123;
        int value = 223;

        //when
        int[] judge = application.judge(answer, value);

        //then
        Assertions.assertThat(judge).containsExactly(2,1);
    }
    @Test
    public void judge_십의_자리가_다를_경우_테스트(){
        //given
        int answer = 123;
        int value = 143;

        //when
        int[] judge = application.judge(answer, value);

        //then
        Assertions.assertThat(judge).containsExactly(2,1);
    }
    @Test
    public void judge_일의_자리가_다를_경우_테스트(){
        //given
        int answer = 123;
        int value = 124;

        //when
        int[] judge = application.judge(answer, value);

        //then
        Assertions.assertThat(judge).containsExactly(2,1);
    }
    @Test
    public void judge_백의자리와_십의자리가_다를떄_테스트(){
        //given
        int answer = 123;
        int value = 213;

        //when
        int[] judge = application.judge(answer, value);

        //then
        Assertions.assertThat(judge).containsExactly(1,2);
    }
    @Test
    public void judge_십의자리와_일의자리가_다를떄_테스트(){
        //given
        int answer = 123;
        int value = 132;

        //when
        int[] judge = application.judge(answer, value);

        //then
        Assertions.assertThat(judge).containsExactly(1,2);
    }
    @Test
    public void judge_백의자리와_일의자리가_다를떄_테스트(){
        //given
        int answer = 123;
        int value = 321;

        //when
        int[] judge = application.judge(answer, value);

        //then
        Assertions.assertThat(judge).containsExactly(1,2);
    }

    @Test
    public void printJudge_3스트라이크_출력(){
        //given
        int [] score = {3,0};
        //when
        application.printJudge(score);

        //then
        assertEquals("3스트라이크", outputStreamCaptor.toString().trim());
    }
    @Test
    public void printJudge_낫싱_출력(){
        //given
        int [] score = {0,3};
        //when
        application.printJudge(score);

        //then
        assertEquals("낫싱", outputStreamCaptor.toString().trim());
    }
    @Test
    public void printJudge_2볼_1스트라이크_출력(){
        //given
        int [] score = {1,2};
        //when
        application.printJudge(score);

        //then
        assertEquals("2볼 1스트라이크", outputStreamCaptor.toString().trim());
    }
    @Test
    public void printJudge_1볼_2스트라이크_출력(){
        //given
        int [] score = {2,1};
        //when
        application.printJudge(score);

        //then
        assertEquals("1볼 2스트라이크", outputStreamCaptor.toString().trim());
    }
    @Test
    public void printJudge_첫번째_원소가_범위_밖에_있을떄(){
        //given
        int [] score = {4,1};
        //when

        //then
        assertThatThrownBy(() -> application.printJudge(score))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("score가 범위 안에 있지 않습니다");
    }
    @Test
    public void printJudge_두번째_원소가_범위_밖에_있을떄(){
        //given
        int [] score = {1,4};
        //when

        //then
        assertThatThrownBy(() -> application.printJudge(score))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("score가 범위 안에 있지 않습니다");
    }

    @Test
    public void isEnd_3스트라이크일떄_true를_리턴하는지_확인(){
        //given
        int [] score = {3,0};
        //when
        boolean state = application.isEnd(score);
        //then
        assertThat(state).isEqualTo(true);
    }
    @Test
    public void isEnd_1볼_2스트라이크일떄_false를_리턴하는지_확인(){
        //given
        int [] score = {2,1};
        //when
        boolean state = application.isEnd(score);
        //then
        assertThat(state).isEqualTo(false);
    }
    @Test
    public void isEnd_2볼_1스트라이크일떄_false를_리턴하는지_확인(){
        //given
        int [] score = {1,2};
        //when
        boolean state = application.isEnd(score);
        //then
        assertThat(state).isEqualTo(false);
    }
    @Test
    public void isEnd_낫싱일떄_false를_리턴하는지_확인(){
        //given
        int [] score = {0,3};
        //when
        boolean state = application.isEnd(score);
        //then
        assertThat(state).isEqualTo(false);
    }
    @Test
    public void printEndGame_state_true_일때_문구를_출력하는지_확인(){
        //given
        final String content = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        //when
        application.printEndGame(true);

        //then
        assertEquals(content, outputStreamCaptor.toString().trim());
    }
    @Test
    public void printEndGame_state_false_일때_문구를_출력하는지_확인(){
        //given
        //when
        application.printEndGame(false);

        //then
        assertEquals("",outputStreamCaptor.toString().trim());
    }
    private boolean checkIfEachDifferent(int result){
        int i1 = result/100;
        int i2 = (result % 100) / 10;
        int i3 = (result%10);
        return (i1 != i2) && (i2 != i3) && (i1 != i3);
    }
}