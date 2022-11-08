package baseball.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(
	DisplayNameGenerator.ReplaceUnderscores.class
)
public class BallsTest {

	private static final String INVALID_SIZE_ERR_MESSAGE
		= "야구 번호는 3개만 가능합니다.";

	private static final String DUPLICATED_ERR_MESSAGE
		= "야구 번호는 중복될 수 없습니다.";

	@DisplayName("balls 길이 검증 테스트")
	@Test
	void balls_길이_검증() {
		assertThatThrownBy(
			() -> new Balls(List.of(1, 2, 3, 4))
		).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(INVALID_SIZE_ERR_MESSAGE);

		assertThatThrownBy(
			() -> new Balls(List.of(1, 2))
		).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(INVALID_SIZE_ERR_MESSAGE);

		assertThatThrownBy(
			() -> new Balls(List.of(1))
		).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(INVALID_SIZE_ERR_MESSAGE);

		assertDoesNotThrow(() -> new Balls(List.of(1, 2, 3)));
	}

	@DisplayName("balls 중복 검증 테스트")
	@Test
	void balls_중복_검증() {
		assertThatThrownBy(
			() -> new Balls(List.of(1, 1, 1))
		).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(DUPLICATED_ERR_MESSAGE);

		assertThatThrownBy(
			() -> new Balls(List.of(2, 1, 2))
		).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(DUPLICATED_ERR_MESSAGE);

		assertDoesNotThrow(() -> new Balls(List.of(1, 2, 3)));
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

		CompareResult result = com.compareTo(player);
		assertThat(result.isAllNothing()).isEqualTo(true);
	}

	@DisplayName("숫자 비교 테스트 N:M - 스트라이크")
	@Test
	void compareTo_숫자_비교_N_M_스트라이크() {
		Balls com = new Balls(List.of(4, 2, 5));
		Balls player = new Balls(List.of(1, 2, 3));

		CompareResult result = com.compareTo(player);
		assertThat(result.getStrikes()).isEqualTo(1);
	}

	@DisplayName("숫자 비교 테스트 N:M - 1볼 1스트라이크")
	@Test
	void compareTo_숫자_비교_N_M_1볼_1스트라이크() {
		Balls com = new Balls(List.of(4, 2, 5));
		Balls player = new Balls(List.of(4, 5, 6));

		CompareResult result = com.compareTo(player);
		assertThat(result.getBalls()).isEqualTo(1);
		assertThat(result.getStrikes()).isEqualTo(1);
	}

	@DisplayName("숫자 비교 테스트 N:M - 2볼 1스트라이크")
	@Test
	void compareTo_숫자_비교_N_M_2볼_1스트라이크() {
		Balls com = new Balls(List.of(4, 2, 5));
		Balls player = new Balls(List.of(4, 5, 2));

		CompareResult result = com.compareTo(player);
		assertThat(result.getBalls()).isEqualTo(2);
		assertThat(result.getStrikes()).isEqualTo(1);
	}

	@DisplayName("숫자 비교 테스트 N:M - 2볼")
	@Test
	void compareTo_숫자_비교_N_M_2볼() {
		Balls com = new Balls(List.of(4, 2, 5));
		Balls player = new Balls(List.of(1, 5, 2));

		CompareResult result = com.compareTo(player);
		assertThat(result.getBalls()).isEqualTo(2);
	}

	@DisplayName("숫자 비교 테스트 N:M - 3스트라이크")
	@Test
	void compareTo_숫자_비교_N_M_3스트라이크() {
		Balls com = new Balls(List.of(4, 2, 5));
		Balls player = new Balls(List.of(4, 2, 5));

		CompareResult result = com.compareTo(player);
		assertThat(result.getStrikes()).isEqualTo(3);
	}

	@DisplayName("숫자 비교 테스트 N:M - 결과 출력")
	@Test
	void getCompareResult_숫자_비교_N_M_결과출력() {
		Balls com = new Balls(List.of(4, 2, 5));
		Balls player = new Balls(List.of(4, 5, 2));

		CompareResult result = com.compareTo(player);
		assertThat(result.getResults())
			.isEqualTo(List.of("2볼", "1스트라이크"));
	}
}
