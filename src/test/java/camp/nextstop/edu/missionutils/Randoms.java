package camp.nextstop.edu.missionutils;

import static camp.nextstep.edu.missionutils.Randoms.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.RepeatedTest;

public class Randoms {

	@RepeatedTest(50)
	public void pickUniqueNumbersInRange_테스트() {
	    //given
		int startInclusive = 1;
		int endInclusive = 9;
		int count = 5;

	    //when
		List<Integer> uniqueNumbersInRange =
			pickUniqueNumbersInRange(startInclusive, endInclusive, count);

		//then
		assertThat(uniqueNumbersInRange.size()).isEqualTo(count);
		for (Integer integer : uniqueNumbersInRange) {
			assertThat(integer).isGreaterThanOrEqualTo(startInclusive);
			assertThat(integer).isLessThanOrEqualTo(endInclusive);
		}
	}

}
