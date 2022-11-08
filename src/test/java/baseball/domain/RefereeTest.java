package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RefereeTest {

	private Referee referee;

	@BeforeEach
	public void init() {
		referee = new Referee();
	}

	@ParameterizedTest(name = "{index} : 심판 판정 테스트 ({1})")
	@CsvSource(value = {"123:3스트라이크", "312:3볼", "321:2볼 1스트라이크", "134:1볼 1스트라이크", "456:낫싱"}, delimiter = ':')
	public void 심판_판정_테스트(String input, String expected) {
		//given
		Balls playerBalls = new Balls(input);
		Balls computerBalls = new Balls("123");
		//when
		PlayResult playResult = referee.judge(playerBalls, computerBalls);
		//then
		assertThat(playResult.toString()).isEqualTo(expected);
	}
}
