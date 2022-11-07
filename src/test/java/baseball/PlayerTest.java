package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlayerTest {
	static Player player = new Player("123");
	@Test
	void Player_객체_접근_테스트(){
		assertThat(player.getNumber()).isEqualTo("123");
	}

	@Test
	void Player_재시작_코드_입력(){
		player.setPlayAgain(1);
		assertThat(player.getPlayAgain()).isEqualTo(true);
	}

	@Test
	void Player_게임종료_코드_입력(){
		player.setPlayAgain(2);
		assertThat(player.getPlayAgain()).isEqualTo(false);
	}

}
