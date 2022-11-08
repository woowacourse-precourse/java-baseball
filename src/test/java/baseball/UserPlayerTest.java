package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.model.UserPlayer;

public class UserPlayerTest {
	@DisplayName("객체 생성 테스트")
	@Test
	public void createUser() {
	//	given
		UserPlayer userPlayer = UserPlayer.getInstance();

	//	when
		userPlayer.setNumberList("593");

	//	then
		assertThat(userPlayer.getNumberList()).isEqualTo(List.of(5, 9, 3));

	}

	@DisplayName("싱글톤 객체 확인 테스트")
	@Test
	public void isSingletonObject() {
		//	given
		UserPlayer userPlayer = UserPlayer.getInstance();
		UserPlayer otherUserPlayer = UserPlayer.getInstance();

		//	when
		userPlayer.setNumberList("593");
		userPlayer.setNumberList("832");

		//	then
		assertThat(userPlayer.getNumberList()).isEqualTo(List.of(8,3,2));
		assertThat(userPlayer).isEqualTo(otherUserPlayer);

	}

	@DisplayName("입력값 변경시 객체변화 테스트")
	@Test
	public void modifyUserList() {
		//	given
		UserPlayer userPlayer = UserPlayer.getInstance();

		//	when
		userPlayer.setNumberList("593");
		userPlayer.setNumberList("726");

		//	then
		assertThat(userPlayer.getNumberList()).isEqualTo(List.of(7,2,6));

	}
}
