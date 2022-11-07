package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RefereeTest {

    @Test
    void 사용자_입력_검증() throws IllegalArgumentException {
        List<Integer> userNumbers = Arrays.asList(1, 2, 3);
        String validString = "456";
        String invalidString1 = "123";
        String invalidString2 = "113";
        String invalidString3 = "1234";
        String invalidString4 = "ㅁㄴㅇ";

        Assertions.assertThat(Referee.validateUserInput(validString, userNumbers)).isEqualTo(true);
        assertThatThrownBy(() -> Referee.validateUserInput(invalidString1, userNumbers)).isInstanceOf(
                IllegalArgumentException.class);
        assertThatThrownBy(() -> Referee.validateUserInput(invalidString2, userNumbers)).isInstanceOf(
                IllegalArgumentException.class);
        assertThatThrownBy(() -> Referee.validateUserInput(invalidString3, userNumbers)).isInstanceOf(
                IllegalArgumentException.class);
        assertThatThrownBy(() -> Referee.validateUserInput(invalidString4, userNumbers)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    void 낫싱_검증() {
        Assertions.assertThat(Referee.checkNothing(0, 0)).isEqualTo(true);
        Assertions.assertThat(Referee.checkNothing(1, 1)).isEqualTo(false);
    }

    @Test
    void 맞는_숫자_세기() {
        List<Integer> originList = Arrays.asList(1, 2, 3);
        List<Integer> comparedList1 = Arrays.asList(1, 2, 4);
        List<Integer> comparedList2 = Arrays.asList(1, 4, 5);
        List<Integer> comparedList3 = Arrays.asList(4, 5, 6);

        Assertions.assertThat(Referee.correctNumberCount(originList, originList)).isEqualTo(3);
        Assertions.assertThat(Referee.correctNumberCount(originList, comparedList1)).isEqualTo(2);
        Assertions.assertThat(Referee.correctNumberCount(originList, comparedList2)).isEqualTo(1);
        Assertions.assertThat(Referee.correctNumberCount(originList, comparedList3)).isEqualTo(0);
    }

    @Test
    void 스트라이크_개수_세기() {
        List<Integer> originList = Arrays.asList(1, 2, 3);
        List<Integer> comparedList1 = Arrays.asList(1, 2, 4);
        List<Integer> comparedList2 = Arrays.asList(1, 4, 5);
        List<Integer> comparedList3 = Arrays.asList(4, 5, 6);

        Assertions.assertThat(Referee.getStrikeCount(originList, originList)).isEqualTo(3);
        Assertions.assertThat(Referee.getStrikeCount(originList, comparedList1)).isEqualTo(2);
        Assertions.assertThat(Referee.getStrikeCount(originList, comparedList2)).isEqualTo(1);
        Assertions.assertThat(Referee.getStrikeCount(originList, comparedList3)).isEqualTo(0);
    }

    @Test
    void 볼_개수_세기() {
        List<Integer> originList = Arrays.asList(1, 2, 3);
        List<Integer> comparedList1 = Arrays.asList(2, 3, 1);
        List<Integer> comparedList2 = Arrays.asList(2, 3, 4);
        List<Integer> comparedList3 = Arrays.asList(2, 4, 5);

        Assertions.assertThat(Referee.getBallCount(originList, originList)).isEqualTo(0);
        Assertions.assertThat(Referee.getBallCount(originList, comparedList1)).isEqualTo(3);
        Assertions.assertThat(Referee.getBallCount(originList, comparedList2)).isEqualTo(2);
        Assertions.assertThat(Referee.getBallCount(originList, comparedList3)).isEqualTo(1);
    }
}
