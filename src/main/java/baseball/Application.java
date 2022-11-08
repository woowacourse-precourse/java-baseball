package baseball;

import java.util.Scanner;

import baseball.controller.BaseballController;

public class Application {

	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		System.out.println("숫자 야구 게임을 시작합니다.");
		while (true) {
			final BaseballController controller = BaseballController.of();
			start(controller, scanner);
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			final int type = scanner.nextInt();
			final boolean result = controller.restart(type);
			if (!result) {
				break;
			}
		}
	}

	public static void start(BaseballController controller, Scanner scanner) {
		while (true) {
			System.out.print("숫자를 입력해주세요 : ");
			final int number = scanner.nextInt();
			final boolean result = controller.play(number);
			if (result) {
				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
				break;
			}
		}
	}

}
