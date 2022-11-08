package baseball.view;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.domain.Balls;
import baseball.domain.CompareResult;

public class OutputViewTest {

	@DisplayName("결과 화면 출력 테스트 - 2볼 1스트라이크")
	@Test
	void display_결과_화면_출력_2볼_1스트라이크() {
		Balls com = new Balls(List.of(4, 2, 5));
		Balls player = new Balls(List.of(4, 5, 2));
		CompareResult result = com.compareTo(player);
		OutputView.display(result);
	}

	@DisplayName("결과 화면 출력 테스트 - 3스트라이크")
	@Test
	void display_결과_화면_출력_3스트라이크() {
		OutputView outputView = new OutputView();
		Balls com = new Balls(List.of(4, 2, 5));
		Balls player = new Balls(List.of(4, 2, 5));
		CompareResult result = com.compareTo(player);
		outputView.display(result);
	}

	@DisplayName("결과 화면 출력 테스트 - 낫싱")
	@Test
	void display_결과_화면_출력_낫싱() {
		OutputView outputView = new OutputView();
		Balls com = new Balls(List.of(4, 2, 5));
		Balls player = new Balls(List.of(7, 8, 9));
		CompareResult result = com.compareTo(player);
		outputView.display(result);
	}
}
