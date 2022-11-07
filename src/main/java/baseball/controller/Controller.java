package baseball.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import baseball.service.Service;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Controller {

	static Service service = new Service();

	public static void gameStart() {
		service.gameStart(getComputerNumbers());
	}

	public static List<Integer> getComputerNumbers() {
		return service.setComputerNumbers();
	}

	public static List<Integer> getUserNumbers() {
		return service.setUserNumbers();
	}

	public static Map<String, Integer> getGameScore(List<Integer> comNumber) {
		return service.setGameScore(comNumber);
	}

	public void getScoreProcess(Map<String, Integer> userScore) {
		service.scoreProcess(userScore);
	}

	public static void getGameContinued() {
		service.gameContinued();
	}
}