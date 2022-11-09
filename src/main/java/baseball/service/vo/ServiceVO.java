package baseball.service.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.IntPredicate;

public class ServiceVO {

	private static boolean gameSet = true;
	private static Integer Strike, ball;
	private static String userAnotherNumbers;
	private static String continued;
	private static List<Integer> userNumber = new ArrayList<>();
	private static Map<String, Integer> userScore = new HashMap<>();
	private static List<Integer> computerNumbers = new ArrayList<>();

	public static List<Integer> getComputerNumbers() {
		return computerNumbers;
	}

	public static void setComputerNumbers(List<Integer> computerNumbers) {
		ServiceVO.computerNumbers = computerNumbers;
	}

	public static String getContinued() {
		return continued;
	}

	public static void setContinued(String continued) {
		ServiceVO.continued = continued;
	}

	public static boolean isGameSet() {
		return gameSet;
	}

	public static void setGameSet(boolean gameSet) {
		ServiceVO.gameSet = gameSet;
	}

	public static void setUserAnotherNumbers(String userAnotherNumbers) {
		ServiceVO.userAnotherNumbers = userAnotherNumbers;
	}

	public String getUserAnotherNumbers() {
		return userAnotherNumbers;
	}

	public static Map<String, Integer> getUserScore() {
		return userScore;
	}

	public static void setUserScore(Map<String, Integer> userScore) {
		ServiceVO.userScore = userScore;
	}

	public static List<Integer> getUserNumber() {
		return userNumber;
	}

	public static void setUserNumber(List<Integer> userNumber) {
		ServiceVO.userNumber = userNumber;
	}

	public static Integer getStrike() {
		return Strike;
	}

	public static void setStrike(Integer strike) {
		Strike = strike;
	}

	public static Integer getBall() {
		return ball;
	}

	public static void setBall(Integer ball) {
		ServiceVO.ball = ball;
	}
}
