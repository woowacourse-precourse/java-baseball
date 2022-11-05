package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UnitTest {

    Application application;

    @BeforeEach
    public void init(){
        application = new Application();
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
    private boolean checkIfEachDifferent(int result){
        int i1 = result/100;
        int i2 = (result % 100) / 10;
        int i3 = (result%10);
        return (i1 != i2) && (i2 != i3) && (i1 != i3);
    }
}