package baseball;

public class Output {
	void oneGameResult(int ball, int strike) {
		System.out.printf("%d볼 %d스트라이크",ball,strike);
	}	
	
	void wrongEverything() {
		System.out.println("낫싱");
	}
	
	void rightEverything() {
		System.out.println("3스트라이크");
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}
}
