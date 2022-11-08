package baseball.custom;

import baseball.*;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FunctionTest {

	@Test
	void 숫자생성이_제대로_이루어지는지(){
		List<Integer> random_number_list = RandomNumber.createRandomNumber();

		assertThat(random_number_list.size()).isEqualTo(3);
	}

	@Test
	void 스코어_맵_스트라이크_테스트(){
		//given
		String test_input_value="123";
		List<Integer> randomNumber = RandomNumber.createRandomNumber();

		//when
		CompareNumber.compareUserNumberAndRandomNumber(test_input_value,randomNumber);
		int strike = RoundScore.getScoreMap().get("STRIKE");

		//then
		assertThat(strike).isGreaterThanOrEqualTo(0);
	}

	@Test
	void 스코어_맵_볼_테스트(){
		//given
		String test_input_value="123";
		List<Integer> randomNumber = RandomNumber.createRandomNumber();

		//when
		CompareNumber.compareUserNumberAndRandomNumber(test_input_value,randomNumber);
		int strike = RoundScore.getScoreMap().get("BALL");

		//then
		assertThat(strike).isGreaterThanOrEqualTo(0);
	}

	@Test
	void 게임종료_출력문_테스트(){
		//given
		String test_input_value="123";
		List<Integer> random_number_list = new ArrayList<>();

		random_number_list.add(1);
		random_number_list.add(2);
		random_number_list.add(3);

		//when
		CompareNumber.compareUserNumberAndRandomNumber(test_input_value,random_number_list);
		HashMap<String, Integer> score_map = RoundScore.getScoreMap();

		//then
		Game.scoreConsoleOutput(score_map);
	}

	@Test
	void 볼_스트라이크_출력문_테스트(){
		//given
		String test_input_value="123";
		List<Integer> random_number_list = new ArrayList<>();

		random_number_list.add(1);
		random_number_list.add(3);
		random_number_list.add(5);

		//when
		CompareNumber.compareUserNumberAndRandomNumber(test_input_value,random_number_list);
		HashMap<String, Integer> score_map = RoundScore.getScoreMap();

		//then
		Game.scoreConsoleOutput(score_map);
	}
}
