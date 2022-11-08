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
	
	public static boolean userNumberValidation(String input) {
		boolean valid=true;
		
		if(input.length() > 3 || input.length() <= 0) {
			valid=false;
		}
		for(int i=0;i<3;i++) {
			if(input.charAt(i) > '9' || input.charAt(i) < '1') {
				valid=false;
			}
		}
		if(input.charAt(0)==input.charAt(1) || input.charAt(0)==input.charAt(2) 
				|| input.charAt(1)==input.charAt(2)) {
			valid=false;
		}
		return valid;
	}
	
	public static List<Integer> userNumber(String input) {
		List<Integer> user = new ArrayList<>();
		if(userNumberValidation(input)) {
			for(int i=0;i < 3; i++) {
				user.add(Character.getNumericValue(input.charAt(i)));
			}
			return user;
		}
		else {
			throw new IllegalArgumentException("올바른 값을 입력하세요");
		}
	}
	
    public static void main(String[] args) {
    	
    }
}
