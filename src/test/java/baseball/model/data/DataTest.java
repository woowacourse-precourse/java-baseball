package baseball.model.data;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class DataTest {
	Data data = new Data();

	@Test
	void testProcessedComputerNumberContainsThreeValues() {
		assertThat(data.getComNumMap().size()).isEqualTo(3);
	}


}
