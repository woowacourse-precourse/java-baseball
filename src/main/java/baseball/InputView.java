package baseball;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
	static int getUserInput() { 
		System.out.print("숫자를 입력해 주세요 : ");
		int inputNum = Integer.parseInt(Console.readLine());
		return inputNum;
	}
	
	static boolean restartOrExit() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		int input = Integer.parseInt(Console.readLine());
		if(input == 1) return true;
		if(input == 2) return false;
		exit();
		return false;
	}
	
	static void checkIllegalInput(ArrayList<Integer> userInputNumbers) {
		if(userInputNumbers.size() != userInputNumbers.stream().distinct().count()) exit();
		if(userInputNumbers.size() != 3 || userInputNumbers.contains(0)) exit();
	}
	
	static void exit() {
		throw new IllegalArgumentException();
	}
}
