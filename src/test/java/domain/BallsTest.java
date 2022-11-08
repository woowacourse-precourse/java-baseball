package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.domain.Balls;

public class BallsTest {

	@Test
	@DisplayName("공들 중에 해당 번호가 존재하는지, 존재한다면 인덱스를 반환하는 테스트")
	void containsAndIndexOfInBalls() {
		// given
		Balls balls = new Balls(Arrays.asList(1, 2, 3));

		// when
		int index = balls.containsAndIndexOf(1);

		// then
		assertThat(index).isEqualTo(0);
	}
}
