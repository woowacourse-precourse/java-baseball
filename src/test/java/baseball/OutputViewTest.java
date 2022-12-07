package baseball;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


import baseball.view.OutputView;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    @Test
    void when_round_end_info_insert() {
        //given
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        String EXPECTED = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        //when
        OutputView.getRestartGameMessage();

        //then
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo(EXPECTED);
    }

    @Test
    void when_input_2_get_stop_message() {
        //given
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        String EXPECTED = "게임을 완전히 종료합니다.";
        //when
        OutputView.getEndGameMessage();

        //then
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo(EXPECTED);
    }

    @Test
    void when_swingBat_nothing_get_낫싱() {
        //given
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        String EXPECTED = "낫싱";
        //when
        OutputView.getResultGameMessage(0, 1, 1);

        //then
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo(EXPECTED);
    }

    @Test
    void when_swingBat_all_get_3스트라이크() {
        //given
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        String EXPECTED = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
        //when
        OutputView.getResultGameMessage(1, 1, 1);

        //then
        assertThat(outputStreamCaptor.toString()).isEqualTo(EXPECTED);
    }

    @Test
    void when_swingBat_2strike_get_2스트라이크() {
        //given
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        String EXPECTED = "0볼 2스트라이크";
        //when
        OutputView.getResultGameMessage(2, 0, 2);

        //then
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo(EXPECTED);
    }

    @Test
    void when_start_run_get_start_message() {
        //given
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        String EXPECTED = "숫자 야구 게임을 시작합니다.";
        //when
        OutputView.getStartGameMessage();

        //then
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo(EXPECTED);
    }

    @Test
    void when_runnig_game_get_input_info_message() {
        //given
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        String EXPECTED = "숫자를 입력해 주세요 :";
        //when
        OutputView.getInputMessage();

        //then
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo(EXPECTED);
    }
}