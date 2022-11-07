package baseball;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BaseballGameManagerTest {

    BaseballGameManager manager;
    DividedRandomNumberElementListMaker listMaker = new DividedRandomNumberElementListMaker();

    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void calculatBasebassScore_메서드로_겹치는_숫자_점수_계산() throws Exception {
        //given
        List<Integer> inputElementList = List.of(1, 2, 3);
        manager = new BaseballGameManager(List.of(3, 2, 4), listMaker);

        //when
        BaseballScore baseballScore = manager.calculateBaseballScore(inputElementList);

        //then
        assertThat(baseballScore.getBallCount()).isEqualTo(1);
        assertThat(baseballScore.getStrikeCount()).isEqualTo(1);
    }

    @Test
    public void printBasebassScore_메서드로_겹치는_숫자_점수_출력() throws Exception {
        //given
        manager = new BaseballGameManager(List.of(1, 2, 3), listMaker);
        BaseballScore baseballScore = new BaseballScore(1, 1);

        //when
        manager.printBaseballScore(baseballScore);

        //then
        assertEquals("1볼 1스트라이크", outputStreamCaptor.toString().trim());
    }

    @Test
    public void printBasebassScore_메서드로_겹치지_않는_숫자_점수_출력() throws Exception {
        //given
        manager = new BaseballGameManager(List.of(1, 2, 3), listMaker);
        BaseballScore baseballScore = new BaseballScore(0, 0);

        //when
        manager.printBaseballScore(baseballScore);

        //then
        assertEquals("낫싱", outputStreamCaptor.toString().trim());
    }
    
    @Test
    public void _3자리숫자_입력_예외처리_3자리가_넘는_숫자_입력시_NumberFormatException() throws Exception {
        //given
        String input = "1234";
        
        //when
        try {
            if (input.length() != 3) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.out.println("3자리가 넘음");
        }

        //then
        assertEquals("3자리가 넘음", outputStreamCaptor.toString().trim());
    }

    @Test
    public void _3자리숫자_입력_예외처리_3자리가_안되는_숫자_입력시_NumberFormatException() throws Exception {
        //given
        String input = "12";

        //when
        try {
            if (input.length() != 3) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.out.println("3자리가 안됨");
        }

        //then
        assertEquals("3자리가 안됨", outputStreamCaptor.toString().trim());
    }

    @Test
    public void _3자리숫자_입력_예외처리_빈문자_입력시_NumberFormatException() throws Exception {
        //given
        String input = "";

        //when
        try {
            if (input.length() == 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.out.println("빈 문자 입력됨");
        }

        //then
        assertEquals("빈 문자 입력됨", outputStreamCaptor.toString().trim());
    }

    @Test
    public void _3자리숫자_입력_예외처리_숫자가_아닌값_입력시_NumberFormatException() throws Exception {
        String input = "ans31vnsladn";

        assertThatThrownBy(() -> Integer.parseInt(input)).isInstanceOf(NumberFormatException.class);
    }
}