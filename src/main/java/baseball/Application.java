package baseball;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.*;


class Computer{
    private List<Integer> numbers;

	public Computer(){
		numbers = new ArrayList<>();
//		numbers = Randoms.pickUniqueNumbersInRange(1,9,3);
		while (numbers.size()<3){
			int randomNumber = Randoms.pickNumberInRange(1,9);
			if (!numbers.contains(randomNumber)) numbers.add(randomNumber);
		}
		System.out.println("numbers = " + numbers);
	}

	public List<Integer> getNumbers(){return this.numbers;}

}

class User{
	private List<Integer> numbers;

	public User(){
		numbers = new ArrayList<>();
		String stringNumbers = Console.readLine();

		validationNumbersLength(stringNumbers);	//길이가 3인지 확인
		validationNumbersInteger(stringNumbers);	//입력받은게 모두 숫자인지 확인.
		generateNumbers(stringNumbers);
	}

	public void generateNumbers(String stringNumbers){
		int intNumbers = Integer.parseInt(stringNumbers);
		numbers.add(intNumbers/100);
		numbers.add((intNumbers%100)/10);
		numbers.add((intNumbers%100)%10);
	}

	public List<Integer> getNumbers(){return this.numbers;}

	public void validationNumbersLength(String stringNumbers) throws IllegalArgumentException{
		if (stringNumbers.length()!=3) {
			throw new IllegalArgumentException("숫자를 총 3개 입력해주세요.");
		}
	}

	public void validationNumbersInteger(String stringNumbers) throws IllegalArgumentException{

		for (int i=0;i<stringNumbers.length();i++){
			int digit = stringNumbers.charAt(i)-48;

			if (digit<1 || digit>9) throw new IllegalArgumentException("1부터 9까지의 숫자만 입력해주세요.");
			else this.getNumbers().add(digit);
		}
	}
}

class Match{
	private Computer computer;
	private User user;

	public Match(Computer computer, User user){
		this.computer=computer;
		this.user=user;
	}

	public int getStrike(){
		List<Integer> computerNumbers = computer.getNumbers();
		List<Integer> userNumbers = user.getNumbers();
		int strikeNumbers = 0;

		for (int i=0;i<3;i++){
			if (computerNumbers.get(i).equals(userNumbers.get(i))) strikeNumbers+=1;
		}
		return strikeNumbers;
	}

	public int getBall(){
		List<Integer> computerNumbers = computer.getNumbers();
		List<Integer> userNumbers = user.getNumbers();
		int ballNumber = 0;

		for (int i=0;i<3;i++){
			if (computerNumbers.contains(userNumbers.get(i))) ballNumber+=1;
		}
		return ballNumber;
	}

	public int play() throws IllegalArgumentException{
		int strike = getStrike();
		int ball = getBall()-strike;
		int restartOrEnd = 0;

		if (strike==3){
			System.out.println("3스트라이크");
			System.out.println("3개의 숫자를 모두 맞히셨습니다!게임 종료");
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			restartOrEnd = Integer.parseInt(Console.readLine());

			if (restartOrEnd != 1 && restartOrEnd != 2) throw new IllegalArgumentException("숫자 1 혹은 2만 입력해주세요");
		}
		else if (strike>0 || ball>0){
			if (strike==0){
				System.out.println(ball+"볼");
			}
			else if(ball==0){
				System.out.println(strike+"스트라이크");
			}
			else{
				System.out.println(ball+"볼 "+strike+"스트라이크");
			}
		}
		else{
			System.out.println("낫싱");
		}
		return restartOrEnd;
	}

}

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");
		Computer computer = new Computer();
		int restartOrEnd = 0;

		while (true){
			if (restartOrEnd==1) computer=new Computer();
			System.out.print("숫자를 입력해주세요 : ");
			User user = new User();

			Match match = new Match(computer,user);
			restartOrEnd = match.play();

			if (restartOrEnd==2) break;
		}


    }
}
