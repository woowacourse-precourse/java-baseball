package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class RefereeTest {

    Referee referee = new Referee();

    @Test
    void three_strikes_zero_balls() {
        final int STRIKES = 3;
        final int BALLS = 0;
        List<Integer> computer = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
        }};
        List<Integer> player = computer;

        referee.setComputerList(computer);
        referee.setPlayerList(player);
        referee.updateHint();

        assertThat(referee.getStrikes()).isEqualTo(STRIKES);
        assertThat(referee.getBalls()).isEqualTo(BALLS);
    }

    @Test
    void two_strikes_zero_balls() {
        final int STRIKES = 2;
        final int BALLS = 0;
        List<Integer> computer = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
        }};
        List<Integer> player = new ArrayList<>() {{
            add(1);
            add(2);
            add(4);
        }};
        referee.setComputerList(computer);
        referee.setPlayerList(player);
        referee.updateHint();

        assertThat(referee.getStrikes()).isEqualTo(STRIKES);
        assertThat(referee.getBalls()).isEqualTo(BALLS);
    }

    @Test
    void one_strikes_two_balls() {
        final int STRIKES = 1;
        final int BALLS = 2;
        List<Integer> computer = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
        }};
        List<Integer> player = new ArrayList<>() {{
            add(1);
            add(3);
            add(2);
        }};
        referee.setComputerList(computer);
        referee.setPlayerList(player);
        referee.updateHint();

        assertThat(referee.getStrikes()).isEqualTo(STRIKES);
        assertThat(referee.getBalls()).isEqualTo(BALLS);
    }

    @Test
    void one_strikes_one_balls() {
        final int STRIKES = 1;
        final int BALLS = 1;
        List<Integer> computer = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
        }};
        List<Integer> player = new ArrayList<>() {{
            add(1);
            add(3);
            add(4);
        }};
        referee.setComputerList(computer);
        referee.setPlayerList(player);
        referee.updateHint();

        assertThat(referee.getStrikes()).isEqualTo(STRIKES);
        assertThat(referee.getBalls()).isEqualTo(BALLS);
    }

    @Test
    void one_strikes_zero_balls() {
        final int STRIKES = 1;
        final int BALLS = 0;
        List<Integer> computer = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
        }};
        List<Integer> player = new ArrayList<>() {{
            add(1);
            add(4);
            add(5);
        }};
        referee.setComputerList(computer);
        referee.setPlayerList(player);
        referee.updateHint();

        assertThat(referee.getStrikes()).isEqualTo(STRIKES);
        assertThat(referee.getBalls()).isEqualTo(BALLS);
    }

    @Test
    void zero_strikes_three_balls() {
        final int STRIKES = 0;
        final int BALLS = 3;
        List<Integer> computer = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
        }};
        List<Integer> player = new ArrayList<>() {{
            add(3);
            add(1);
            add(2);
        }};
        referee.setComputerList(computer);
        referee.setPlayerList(player);
        referee.updateHint();

        assertThat(referee.getStrikes()).isEqualTo(STRIKES);
        assertThat(referee.getBalls()).isEqualTo(BALLS);
    }

    @Test
    void zero_strikes_two_balls() {
        final int STRIKES = 0;
        final int BALLS = 2;
        List<Integer> computer = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
        }};
        List<Integer> player = new ArrayList<>() {{
            add(4);
            add(1);
            add(2);
        }};
        referee.setComputerList(computer);
        referee.setPlayerList(player);
        referee.updateHint();

        assertThat(referee.getStrikes()).isEqualTo(STRIKES);
        assertThat(referee.getBalls()).isEqualTo(BALLS);
    }

    @Test
    void zero_strikes_one_balls() {
        final int STRIKES = 0;
        final int BALLS = 1;
        List<Integer> computer = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
        }};
        List<Integer> player = new ArrayList<>() {{
            add(4);
            add(5);
            add(2);
        }};
        referee.setComputerList(computer);
        referee.setPlayerList(player);
        referee.updateHint();

        assertThat(referee.getStrikes()).isEqualTo(STRIKES);
        assertThat(referee.getBalls()).isEqualTo(BALLS);
    }

    @Test
    void zero_strikes_zero_balls() {
        final int STRIKES = 0;
        final int BALLS = 0;
        List<Integer> computer = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
        }};
        List<Integer> player = new ArrayList<>() {{
            add(4);
            add(5);
            add(6);
        }};
        referee.setComputerList(computer);
        referee.setPlayerList(player);
        referee.updateHint();

        assertThat(referee.getStrikes()).isEqualTo(STRIKES);
        assertThat(referee.getBalls()).isEqualTo(BALLS);
    }
}