package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

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

}