package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.provider.Arguments;


import java.io.*;
import java.util.*;
import java.util.stream.Stream;

import static baseball.Application.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ApplicationTest extends NsTest {
    public static InputStream generateUserInput(String input){
        return new ByteArrayInputStream(input.getBytes());
    }
    public InputStream createInputStream(String user,String reGameAnswer){
        List<InputStream> inputStreams=Arrays.asList(generateUserInput(user),generateUserInput(reGameAnswer));
       return new SequenceInputStream(Collections.enumeration(inputStreams));
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
    void 게임시작_테스트(){
        InputStream in=generateUserInput("123");
        System.setIn(in);
        assertThrows(NoSuchElementException.class, () -> {
            StartGame(1);
        });
    }
    @Test
    void 숫자생성_테스트(){
        List<Integer> computer=getNumberBaseball();
        assertThat(computer.size()==3);
    }
    @Test
    void 중복체크_테스트(){
        List<Integer> computer=List.of(1,2);
        checkDuplicate(2,computer);
        assertThat(computer.size()==2);

    }
    @Test
    void 입력_테스트() {

        String input = "123";
        InputStream in=generateUserInput(input);
        System.setIn(in);
        List<Integer> user=getInput();
        assertThat(user).containsExactly(1,2,3);

    }
    @Test
    void 입력조건_테스트() {
        assertThat(lengthCheck("123")).isTrue();
        assertThat(lengthCheck("1234")).isFalse();
        assertThat(digitCheck("123")).isTrue();
        assertThat(digitCheck("asd")).isFalse();
        assertThat(duplicateCheck("123")).isTrue();
        assertThat(duplicateCheck("111")).isFalse();

    }
    @Test
    void checkError_테스트() {
        String[] input = new String[]{"122", "aaa", "1234", "aa", "333"};
        for (int i = 0; i < input.length; i++) {
            assertThat(checkError(input[i])).isTrue();
        }
        assertThat(checkError("123")).isFalse();
    }
    @Test
    void Checknum_테스트(){
        List<Integer> computer = new ArrayList<>(Arrays.asList(1,2,3));
        InputStream in=generateUserInput("123");
        System.setIn(in);
        assertThrows(NoSuchElementException.class, () -> {
            checkNumber(computer);
        });



    }
    @Test
    void 입력받은숫자_리스트변환테스트(){
        String trynumber= "468";
        List<Integer> user=transformInteger(trynumber);
        assertThat(user).containsExactly(4,6,8);
    }
    @Test
    void 스트라이크체크_테스트(){
        assertThat(strikeCheck(1,1)==1);

        assertThat(strikeCheck(2,1)==0);
    }
    @Test
    void 스트라이크카운트_테스트(){
        strikeAnswer(2);
        assertThat(output()).isEqualTo("2스트라이크");
    }
    @Test
    void 볼or스트라이크_테스트(){
        List<Integer> computer=new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> user=new ArrayList<>(Arrays.asList(1,3,5));
        assertThat(ballorstrikeCheck(user.get(1),computer,1)==1);
    }
    @Test
    void 볼체크_테스트(){
        List<Integer> computer=new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> user=new ArrayList<>(Arrays.asList(1,3,5));
        assertThat(ballCheck(user.get(1),computer,1)==1);
        assertThat(ballCheck(user.get(0),computer,0)==0);

    }
    @Test
    void 볼카운트_테스트(){

        List<Integer> computer=new ArrayList<>(Arrays.asList(8,4,6));
        List<Integer> user=transformInteger("468");
        assertThat(ballCount(user,computer)==3);
        user=transformInteger("648");
        assertThat(ballCount(user,computer)==2);
        user=transformInteger("126");
        assertThat(ballCount(user,computer)==1);

    }
    @Test
    void 스트라이크카운트_볼카운트_출력테스트(){
        resultAnswer(2,1);
        assertThat(output()).isEqualTo("1볼 2스트라이크");
    }

    @Test
    void 승리출력_테스트(){
        printWin();
        assertThat(output()).contains("3스트라이크","게임 종료","새로 시작");
    }
    @Test
    void 게임재시작답변_테스트(){
        InputStream in=generateUserInput("1");
        System.setIn(in);
        assertThat(gameSwitch()==1);
    }
    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("122"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("sss"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("sssg"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
