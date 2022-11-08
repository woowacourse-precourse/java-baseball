package baseball;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.controller.MatchJudgmentController;
import baseball.model.ComputerPlayer;
import baseball.model.UserPlayer;

public class BaseballGameModelTest {

	@DisplayName("게임모델 작동 테스트")
	@Test
	void runGameModel() {
	//	given
		ComputerPlayer computerPlayer = new ComputerPlayer();
		MatchJudgmentController baseballGameModel = new MatchJudgmentController(computerPlayer);
		UserPlayer userPlayer = UserPlayer.getInstance();

	//	when
		userPlayer.setNumberList("593");
		List<Integer> scoreResult = baseballGameModel.getMatchResult();
		List<Integer> computerAnswer = computerPlayer.getNumberList();

	//	then
		System.out.println("computerAnswer = " + computerAnswer);
		System.out.println("result = " + scoreResult);
	}
}
