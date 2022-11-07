package baseball;

import static baseball.Result.getBallCount;
import static baseball.Result.getStrikeCount;
import static baseball.Result.getResult;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

class ResultTest {

	@Test
	void 볼_개수_세기_테스트() {
		List<Integer> pitcher = Arrays.asList(1, 2, 3);

		List<Integer> noBallHitter = Arrays.asList(4, 5, 6);
		List<Integer> oneBallHitter = Arrays.asList(5, 1, 6);
		List<Integer> twoBallHitter = Arrays.asList(6, 1, 2);
		List<Integer> threeBallHitter = Arrays.asList(2, 3, 1);
		List<Integer> threeStrikeHitter = Arrays.asList(1, 2, 3);

		assertThat(getBallCount(pitcher, noBallHitter)).isEqualTo(0);
		assertThat(getBallCount(pitcher, oneBallHitter)).isEqualTo(1);
		assertThat(getBallCount(pitcher, twoBallHitter)).isEqualTo(2);
		assertThat(getBallCount(pitcher, threeBallHitter)).isEqualTo(3);
		assertThat(getBallCount(pitcher, threeStrikeHitter)).isEqualTo(0);
	}

	@Test
	void 스트라이크_개수_세기_테스트() {
		List<Integer> pitcher = Arrays.asList(1, 2, 3);

		List<Integer> noStrikeNoBallHitter = Arrays.asList(4, 5, 6);
		List<Integer> noStrikeThreeBallHitter = Arrays.asList(3, 1, 2);
		List<Integer> oneStrikeHitter = Arrays.asList(3, 2, 1);
		List<Integer> twoStrikeHitter = Arrays.asList(1, 2, 4);
		List<Integer> threeStrikeHitter = Arrays.asList(1, 2, 3);

		assertThat(getStrikeCount(pitcher, noStrikeNoBallHitter)).isEqualTo(0);
		assertThat(getStrikeCount(pitcher, noStrikeThreeBallHitter)).isEqualTo(0);
		assertThat(getStrikeCount(pitcher, oneStrikeHitter)).isEqualTo(1);
		assertThat(getStrikeCount(pitcher, twoStrikeHitter)).isEqualTo(2);
		assertThat(getStrikeCount(pitcher, threeStrikeHitter)).isEqualTo(3);
	}

	@Test
	void 볼과_스트라이크_개수에_따른_출력결과_테스트() {
		assertThat(getResult(0, 0)).isEqualTo("낫싱");
		assertThat(getResult(1, 0)).isEqualTo("1볼");
		assertThat(getResult(1, 1)).isEqualTo("1볼 1스트라이크");
		assertThat(getResult(1, 2)).isEqualTo("1볼 2스트라이크");
		assertThat(getResult(2, 1)).isEqualTo("2볼 1스트라이크");
		assertThat(getResult(3, 0)).isEqualTo("3볼");
		assertThat(getResult(0, 3)).isEqualTo("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}
}
