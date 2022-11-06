package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(
	DisplayNameGenerator.ReplaceUnderscores.class
)
public class BallsTest {

	@DisplayName("balls 길이 검증 테스트")
	@Test
	void balls_길이_검증() {
		assertThatThrownBy(
			() -> new Balls(List.of(1, 2, 3, 4))
		).isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(
			() -> new Balls(List.of(1, 2))
		).isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(
			() -> new Balls(List.of(1))
		).isInstanceOf(IllegalArgumentException.class);

		assertThat(new Balls(List.of(1, 2, 3))).isNotNull();
	}

	@DisplayName("balls 중복 검증 테스트")
	@Test
	void balls_중복_검증() {
		assertThatThrownBy(
			() -> new Balls(List.of(1, 1, 1))
		).isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(
			() -> new Balls(List.of(2, 1, 2))
		).isInstanceOf(IllegalArgumentException.class);

		assertThat(new Balls(List.of(1, 2, 3))).isNotNull();
	}

	@DisplayName("숫자 비교 테스트 N:1 - 낫싱")
	@Test
	void compareTo_숫자_비교_N_1_낫싱() {
		Balls com = new Balls(List.of(4, 2, 5));
		BallStatus status = com.compareTo(new Ball(7, 1));
		assertThat(status).isEqualTo(BallStatus.NOTHING);
	}

	@DisplayName("숫자 비교 테스트 N:1 - 스트라이크")
	@Test
	void compareTo_숫자_비교_N_1_스트라이크() {
		Balls com = new Balls(List.of(4, 2, 5));
		BallStatus status = com.compareTo(new Ball(4, 1));
		assertThat(status).isEqualTo(BallStatus.STRIKE);
	}
	@DisplayName("숫자 비교 테스트 N:1 - 볼")
	@Test
	void compareTo_숫자_비교_N_1_볼() {
		Balls com = new Balls(List.of(4, 2, 5));
		BallStatus status = com.compareTo(new Ball(2, 1));
		assertThat(status).isEqualTo(BallStatus.BALL);
	}

	@DisplayName("숫자 비교 테스트 N:M - 낫싱")
	@Test
	void compareTo_숫자_비교_N_M_낫싱() {
		Balls com = new Balls(List.of(4, 2, 5));
		Balls player = new Balls(List.of(7, 8, 9));

		PlayResult result = com.compareTo(player);
		assertThat(result.getResult()).isEqualTo("낫싱");
	}

	@DisplayName("숫자 비교 테스트 N:M - 스트라이크")
	@Test
	void compareTo_숫자_비교_N_M_스트라이크() {
		Balls com = new Balls(List.of(4, 2, 5));
		Balls player = new Balls(List.of(1, 2, 3));

		PlayResult result = com.compareTo(player);
		assertThat(result.getResult()).isEqualTo("1스트라이크");
	}
}
