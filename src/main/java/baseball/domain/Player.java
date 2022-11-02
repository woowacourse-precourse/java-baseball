package baseball.domain;

import baseball.util.StringToArrayList;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Player {

	public List<Integer> getInput() {
		String playerInput = Console.readLine();
		return StringToArrayList.convert(playerInput);
	}

}
