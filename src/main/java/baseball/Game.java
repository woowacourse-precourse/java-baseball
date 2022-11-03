package baseball;

import baseball.validate.Validation;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {
	public Game() {

	}

	public int run() {
		System.out.println("숫자 야구 게임을 시작합니다.");
		System.out.print("숫자를 입력해주세요 : ");
		String input = Console.readLine();

		Validation.validateAnswer(input);

		String[] splitInput = input.split("");

		List<Integer> hitter = new ArrayList<>();
		for (String s : splitInput) {
			hitter.add(Integer.parseInt(s));
		}


		return 0;
	}
}
