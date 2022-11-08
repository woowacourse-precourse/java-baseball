package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

import static baseball.Application.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 컴퓨터_난수_테스트(){
       List<Integer> testList = computerList();
        assertEquals(3, testList.size());
    }

    @Test
    void 사용자_입력_정상입력_테스트(){
        String test = "132";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        InputStream in = new ByteArrayInputStream(test.getBytes());
        System.setIn(in);
        List<Integer> numList = userNumList();

        assertEquals(3, numList.size());
    }

    @Test
    void 사용자_3자리_이상_입력_오류_테스트(){

        String test = "1233";
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        InputStream inputStream = new ByteArrayInputStream(test.getBytes());
        System.setIn(inputStream);

        assertThrows(IllegalArgumentException.class, () ->{
            List<Integer> numlist = userNumList();
        });
    }

    @Test
    void 사용자_중복_입력_오류_테스트(){
        String test = "122";
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        InputStream inputStream = new ByteArrayInputStream(test.getBytes());
        System.setIn(inputStream);

        assertThrows(IllegalArgumentException.class, ()->{
            List<Integer> numList = userNumList();
        });
    }


    @Test
    void 컴퓨터_사용자_입력값_비교_3스트라이크(){
        List<Integer> comList = computerList();
        String userNum ="";
        for (int i: comList) {
            userNum += i;
        }

        System.out.println("user : " + userNum);
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        InputStream inputStream = new ByteArrayInputStream(userNum.getBytes());
        System.setIn(inputStream);

        List<Integer> userNumList = userNumList();

        String test = checkResult(comList,userNumList);
        System.out.println("test : " +test);
        assertEquals("3스트라이크", test);
    }

    @Test
    void 컴퓨터_사용자_입력값_테스트(){
        List<Integer> comList = computerList();
        System.out.println("comList : " + comList);

        String userNum ="";
        for (int i: comList) {
            userNum += i;
        }

        String test = "";
        for (int r = userNum.length(); r > 0; r--) {
            test += userNum.charAt(r-1);
        }

        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        InputStream inputStream = new ByteArrayInputStream(test.getBytes());
        System.setIn(inputStream);

        List<Integer> userNumList = userNumList();

        String result = checkResult(comList,userNumList);
        assertEquals("2볼 1스트라이크", result);
    }
}
