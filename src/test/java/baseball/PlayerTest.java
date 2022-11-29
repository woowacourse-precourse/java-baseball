package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import baseball.domain.Computer;
import baseball.domain.Player;

public class PlayerTest {
	Player player;
	List<Integer> userNumberList;

	@BeforeEach
	void setUp() {
		player = new Player();
		userNumberList = player.getPlayerNumberList();
	}

	@Test
	void separateNumbersByUnit_메서드로_각_자릿수_구분() {
		String input = "123";

		player.separateNumbersByUnit(input);

		assertThat(player.getPlayerNumberList().get(0)).isEqualTo(1);
		assertThat(player.getPlayerNumberList().get(1)).isEqualTo(2);
		assertThat(player.getPlayerNumberList().get(2)).isEqualTo(3);
	}
}
