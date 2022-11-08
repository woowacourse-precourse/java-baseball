package baseball;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class MessageTest {

	@Test
	public void 게임_시작_문구(){
		assertThat(Message.GAME_START.getMsg()).isEqualTo("숫자 야구 게임을 시작합니다.");
		assertThat(Message.GAME_START.getMsg()).isNotEqualTo("숫자 야구 게임을 시작합니다");
	}

	@Test
	public void 숫자_입력_문구(){
		assertThat(Message.INPUT_THREE_DIGIT.getMsg()).isEqualTo("숫자를 입력하세요 : ");
		assertThat(Message.INPUT_THREE_DIGIT.getMsg()).isNotEqualTo("숫자를 입력하세요:");
	}

	@Test
	public void 게임_재시작_문구(){
		assertThat(Message.RESTART_GAME.getMsg()).isEqualTo("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		assertThat(Message.RESTART_GAME.getMsg()).isNotEqualTo("게임을 새로 시작하려면 2, 종료하려면 1를 입력하세요.");
	}

	@Test
	public void 게임_종료_문구(){
		assertThat(Message.END_GAME.getMsg()).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		assertThat(Message.END_GAME.getMsg()).isNotEqualTo("4개의 숫자를 모두 맞히셨습니다!게임종료");
	}

	@Test
	public void 볼_문구(){
		assertThat(Message.BALL.getMsg()).isEqualTo("볼");
		assertThat(Message.BALL.getMsg()).isNotEqualTo("스트라이크");
	}

	@Test
	public void 스트라이크_문구(){
		assertThat(Message.STRIKE.getMsg()).isEqualTo("스트라이크");
		assertThat(Message.STRIKE.getMsg()).isNotEqualTo("낫싱");
	}

	@Test
	public void 낫싱_문구(){
		assertThat(Message.NOTHING.getMsg()).isEqualTo("낫싱");
		assertThat(Message.NOTHING.getMsg()).isNotEqualTo("볼");
	}

	@Test
	public void 올바르지_않은_입력_문구(){
		assertThat(Message.INVALID_INPUT_END_GAME.getMsg()).isEqualTo("올바르지 않은 입력입니다. 게임을 종료합니다.");
		assertThat(Message.INVALID_INPUT_END_GAME.getMsg()).isNotEqualTo("숫자 야구 게임을 시작합니다.");
	}
}
