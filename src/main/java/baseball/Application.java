package baseball;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

	public static void main(String[] args) {

		startGame();

		List<String> playerNumbers = getPlayerNumbers();
		List<Integer> computerNumbers = getComputerNumbers();
		
		System.out.println(playerNumbers);
		System.out.println(computerNumbers);
	}

	public static List<Integer> getComputerNumbers() {
		
		List<Integer> computer = new ArrayList<>();
		while (computer.size() < 3) {
			
		    int randomNumber = Randoms.pickNumberInRange(1, 9);
		    if (!computer.contains(randomNumber)) {
		        computer.add(randomNumber);
		    }
		}
		return computer;
	}
	
	public static List<String> getPlayerNumbers() {

		Scanner scin = new Scanner(System.in);
		
		String numbers = scin.next();
		List<String> numberList = Arrays.asList(numbers.split(""));
		
		scin.close();
		return numberList;
	}

	public static void startGame() {

		System.out.println("숫자 야구 게임을 시작합니다.");
	}
}
