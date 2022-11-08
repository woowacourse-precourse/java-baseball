package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RefereeTest {

    @Test
    void strike_ball_개수에_따른_String_반환_검사1() {
        Referee referee = new Referee();
        List<Integer> target = new ArrayList<>(List.of(1,2,3));
        List<Integer> user = new ArrayList<>(List.of(1,2,4));
        referee.setBallAndStrike(target, user);
        String result = referee.resultMessage();

        assertEquals("2스트라이크", result);
    }
    @Test
    void strike_ball_개수에_따른_String_반환_검사2() {
        Referee referee = new Referee();
        List<Integer> target = new ArrayList<>(List.of(1,2,3));
        List<Integer> user = new ArrayList<>(List.of(3,1,2));
        referee.setBallAndStrike(target, user);
        String result = referee.resultMessage();

        assertEquals("3볼", result);
    }
    @Test
    void strike_ball_개수에_따른_String_반환_검사3() {
        Referee referee = new Referee();
        List<Integer> target = new ArrayList<>(List.of(1,2,3));
        List<Integer> user = new ArrayList<>(List.of(4,5,6));
        referee.setBallAndStrike(target, user);
        String result = referee.resultMessage();

        assertEquals("낫싱", result);
    }
    @Test
    void strike_ball_개수에_따른_String_반환_검사4() {
        Referee referee = new Referee();
        List<Integer> target = new ArrayList<>(List.of(3,2,1));
        List<Integer> user = new ArrayList<>(List.of(1,2,4));
        referee.setBallAndStrike(target, user);
        String result = referee.resultMessage();

        assertEquals("1볼 1스트라이크", result);
    }
}