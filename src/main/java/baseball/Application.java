package baseball;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
public class Application {
	
	public static void gameStart() {
		System.out.println("숫자 야구 게임을 시작합니다.");
	}
	
	public static List<Integer> computerNumber(){
		List<Integer> computer = new ArrayList<>();
		while (computer.size() < 3) {
		    int randomNumber = Randoms.pickNumberInRange(1, 9);
		    if (!computer.contains(randomNumber)) {
		        computer.add(randomNumber);
		    }
		}
		return computer;
	}
	
	public static String inputNumber() {
		System.out.println("숫자를 입력해주세요 : ");
		String input=Console.readLine();
		return input;
	}
	
    public static void main(String[] args) {
    	
    }
}
