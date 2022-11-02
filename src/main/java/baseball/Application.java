package baseball;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class Application {

	public static void main(String[] args) {

		startGame();

		ArrayList<String> playerNumbers = getPlayerNumbers();
		
		System.out.println(playerNumbers);
	}

	public static ArrayList<String> getPlayerNumbers() {

		Scanner scin = new Scanner(System.in);
		
		String numbers = scin.next();
		
		List<String> numberList = Arrays.asList(numbers.split(""));
		
		ArrayList<String> playerNumbers = new ArrayList<String>(numberList);
		
		scin.close();
		
		return playerNumbers;
	}

	public static void startGame() {

		System.out.println("숫자 야구 게임을 시작합니다.");
	}
}
