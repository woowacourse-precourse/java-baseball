package baseball.constant;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ViewConstantsTest {

	@Test
	void valueOf_메소드로_아이템_확인() {
		//when, then
		assertThat(ViewConstants.valueOf("GAME_START_MESSAGE")).isEqualTo(ViewConstants.GAME_START_MESSAGE);
	}

	@Test
	void get_메소드로_출력할_문자열_리턴() {
		//given
		List<String> result = new ArrayList<>();

		//when
		for (ViewConstants output : ViewConstants.values()) {
			result.add(output.get());
		}

		//then
		assertThat(result).containsExactly("숫자 야구 게임을 시작합니다.", "숫자를 입력해주세요 : ", "%d볼", "%d스트라이크", "낫싱",
			"%d개의 숫자를 모두 맞히셨습니다! 게임 종료", "게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.");
	}
}