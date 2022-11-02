package baseball;

public class Output {
	static void startGame() {
		System.out.println("숫자 야구 게임을 시작합니다.");
	}
	
	static void progressGame() {
		System.out.print("숫자를 입력해주세요 : ");
	}
	
	static void oneGameResult(int ball, int strike) {
		System.out.println(ball+"볼 "+strike+"스트라이크");
	}	
	
	static void wrongEverything() {
		System.out.println("낫싱");
	}
	
	static void rightEverything() {
		System.out.println("3스트라이크");
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}
	
	static void endGame() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}
}
