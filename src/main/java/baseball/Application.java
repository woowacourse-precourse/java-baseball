package baseball;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.*;


class Computer{
    private List<Integer> numbers = new ArrayList<>();

	public List<Integer> getNumbers(){return this.numbers;}
	public void generateNumbers(){
		numbers = Randoms.pickUniqueNumbersInRange(1,9,3);
	}
}

class User{
	private List<Integer> numbers = new ArrayList<>();

	public List<Integer> getNumbers(){return this.numbers;}

	public void checkNumbersLength(String stringNumbers) throws IllegalArgumentException{
		if (stringNumbers.length()!=3) {
			throw new IllegalArgumentException("숫자를 총 3개 입력해주세요.");
		}
	}

	public void checkNumbersInteger(String stringNumbers) throws IllegalArgumentException{

		for (int i=0;i<stringNumbers.length();i++){
			int digit = stringNumbers.charAt(i)-48;

			if (digit<1 || digit>9) throw new IllegalArgumentException("1부터 9까지의 숫자만 입력해주세요.");
			else this.getNumbers().add(digit);
		}
	}
	public void inputNumbers() throws IllegalArgumentException {
		String stringNumbers = Console.readLine();

		checkNumbersLength(stringNumbers);	//길이가 3인지 확인
		checkNumbersInteger(stringNumbers);	//입력받은게 모두 숫자인지 확인.

	}
}

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");

//		int checkReplayOrEnd = -1;
//		while (checkReplayOrEnd != 2){}
        Computer computer = new Computer();
		computer.generateNumbers();
		System.out.println("computer.getNumbers() = " + computer.getNumbers());

		User user = new User();
		user.inputNumbers();
		System.out.println("user.getNumbers() = " + user.getNumbers());

    }
}
