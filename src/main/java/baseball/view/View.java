package baseball.view;

public class View {
	public void printResult(int num) {
		switch (num) {
			case 1:
				System.out.print("스트라이크");
				break;
			case 2:
				System.out.print("볼");
				break;
			case 3:
				System.out.print("낫싱");
				break;
		}
	}
}
