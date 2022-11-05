package baseball.model.data;

import baseball.controller.computer.Computer;
import baseball.controller.user.User;

import java.util.LinkedHashMap;

public class Data {
	Computer computer = new Computer();
	User user = new User();

	public static LinkedHashMap<Integer, Integer> comNumMap;
	public static LinkedHashMap<Integer, Integer> userNumMap;

	public static int computerNumber;
	public static int computerNumIdx;
	public static int userNumber;
	public static int userNumIdx;

	public void fetchComputerNumbers() {
		comNumMap = computer.getNumbers();
	}

	public void fetchUserNumbers() {
		userNumMap = user.getNumbers();
	}

	public void checkEachNumAndIdx(int comIdx, int userIdx) {
		computerNumber = extractNumber(comNumMap, comIdx);
		computerNumIdx = extractIndex(comNumMap, comIdx);
		userNumber = extractNumber(userNumMap, userIdx);
		userNumIdx = extractIndex(userNumMap, userIdx);
	}

	public int extractNumber(LinkedHashMap<Integer, Integer> numbersMap, int idx) {
		return (int) numbersMap.keySet().toArray()[idx];
	}

	public int extractIndex(LinkedHashMap<Integer, Integer> numbersMap, int idx) {
		return (int) numbersMap.values().toArray()[idx];
	}

	public LinkedHashMap<Integer, Integer> getComNumMap() {
		return comNumMap;
	}

	public LinkedHashMap<Integer, Integer> getUserNumMap() {
		return userNumMap;
	}

}
