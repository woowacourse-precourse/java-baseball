package baseball;

import java.util.List;

public class Application {

	public static void main(String[] args) {

		System.out.println("숫자 야구 게임을 시작합니다.");
		ComputerNum computerNum = new ComputerNum();
		Input input = new Input();
		Compare compare = new Compare();
		Judge judge = new Judge();
		Askretry askretry = new Askretry();
		boolean again = true;

		while (again) {
			List<Integer> computer = computerNum.create();
			String result = "";
			while (!result.equals("3스트라이크")) {
				result = judge.judgement(computer, input.playerNumber());
				System.out.println(result);
			}
			again = askretry.askRetry();
		}
	}

}



