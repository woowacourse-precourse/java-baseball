package baseball.view;

import baseball.controller.GameController;
import camp.nextstep.edu.missionutils.Console;

public class View {
	public void printResult(int num, int type) {
		if (type == 0)
			System.out.println("숫자 야구 게임을 시작합니다.");
		if (type == 1)
			System.out.print(num + "스트라이크 ");
		if (type == 2)
			System.out.print(num +"볼 ");
		if (type == 3)
			System.out.print("낫싱 ");
		if (type == 4)
			System.out.print("숫자를 입력해주세요 : ");
		if (type == 5)
			System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		if (type == 6)
			System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}

	public String inputNumber() {
		return Console.readLine();
	}
}
