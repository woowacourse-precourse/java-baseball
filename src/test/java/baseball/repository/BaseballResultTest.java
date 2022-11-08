package baseball.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@DisplayName("경기결과 ")
class BaseballResultTest{
    BaseballResult baseballResult = new BaseballResult();
    @Test
    void 쓰리스트라이크_트루_테스트() {
        List<Integer> computer = new ArrayList<>(List.of(1, 2, 3));
        List<Integer> player = new ArrayList<>(List.of(1, 2, 3));
        Assertions.assertThat(baseballResult.progressJudgement(computer, player)).isEqualTo(true);
    }

    @Test
    void 쓰리스트라이크_폴스_테스트() {
        List<Integer> computer = new ArrayList<>(List.of(1, 2, 3));
        List<Integer> player = new ArrayList<>(List.of(1, 2, 4));

        Assertions.assertThat(baseballResult.progressJudgement(computer, player)).isEqualTo(false);
    }

    @Test
    void 볼_스트라이크_개수_테스트() {
        List<Integer> computer = new ArrayList<>(List.of(1, 2, 3));
        List<Integer> player = new ArrayList<>(List.of(1, 2, 4));
        baseballResult.progressJudgement(computer, player);
        Map<String, Integer> result = baseballResult.getResult();
        Assertions.assertThat(result.get("strike") == 2 && result.get("ball") == 0).isEqualTo(true);
    }

    @Test
    void 볼만_있는_경우_테스트() {
        List<Integer> computer = new ArrayList<>(List.of(1, 2, 3));
        List<Integer> player = new ArrayList<>(List.of(2, 3, 4));
        baseballResult.progressJudgement(computer, player);
        Map<String, Integer> result = baseballResult.getResult();
        Assertions.assertThat(result.get("strike") == 0 && result.get("ball") == 2).isEqualTo(true);
    }

    @Test
    void 스트라이크만_있는_경우_테스트() {
        List<Integer> computer = new ArrayList<>(List.of(1, 2, 3));
        List<Integer> player = new ArrayList<>(List.of(5, 4, 3));
        baseballResult.progressJudgement(computer, player);
        Map<String, Integer> result = baseballResult.getResult();
        Assertions.assertThat(result.get("strike") == 1 && result.get("ball") == 0).isEqualTo(true);
    }
}