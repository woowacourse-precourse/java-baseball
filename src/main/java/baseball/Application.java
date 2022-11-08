package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

	// 숫자야구 타겟 넘버
	static int targetNumber;

	// 맞히는 사람이 입력한 숫자
	static int inputNumber;

	public static void main(String[] args) {
		// TODO: 프로그램 구현
		boolean run = gameRun();

		// 프로그램 시작
		while (run) {

			boolean curGame = true;
			setTarget();

			// 게임 시작
			while (curGame) {

				inputNumber();

				curGame = compareTargetInput();

				if (!curGame) {
					run = gameover();
				}

			}

		}

	}

	// 게임 처음 시작
	public static boolean gameRun() {
		System.out.println("숫자 야구 게임을 시작합니다.");
		return true;
	}

	// 타겟 값 설정 기능
	public static void setTarget() {
		List<Integer> target = new ArrayList<>();
		while (target.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!target.contains(randomNumber)) {
				target.add(randomNumber);
			}
		}
		targetNumber = target.get(0) * 100 + target.get(1) * 10 + target.get(2);
	}

	// 숫자 넣는 기능
	public static void inputNumber() {
		System.out.print("숫자를 입력해주세요 : ");
		String str = Console.readLine();

		// 입력은 3자리 숫자로만 들어온다 생각하고
		// 그 외의 입력들은 전부 에러 처리
		if (str.length() != 3) {
			throw new IllegalArgumentException();
		}

		// 각 자리의 char가 0~9까지의 수인지 확인
		for (int i = 0; i < 3; i++) {
			char c = str.charAt(i);
			if (!(c >= 48 && c <= 57)) {
				throw new IllegalArgumentException();
			}
		}

		// 위의 예외가 아닌경우 인풋에 넣어줌
		inputNumber = Integer.parseInt(str);
	}

	// 타겟과 입력값 비교해서 결과 알려주는 기능
	public static boolean compareTargetInput() {

		int ballCnt = 0;
		int strikeCnt = 0;

		String targetStr = String.valueOf(targetNumber);
		String inputStr = String.valueOf(inputNumber);

		// 볼과 스트라이크 판단
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (targetStr.charAt(j) == inputStr.charAt(i)) {
					if (i == j) {
						strikeCnt++;
					} else {
						ballCnt++;
					}
				}
			}
		}

		// 전부 스트라이크인 경우
		if (strikeCnt == 3) {
			printresult(ballCnt, strikeCnt);
			return false;
		} else {
			printresult(ballCnt, strikeCnt);
			return true;
		}

	}

	// 결과 출력 기능
	public static void printresult(int ballCnt, int strikeCnt) {
		if (strikeCnt == 3) {
			System.out.println(strikeCnt + "스트라이크");
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			return;
		}

		if (strikeCnt == 0 && ballCnt == 0) {
			System.out.println("낫싱");
			return;
		}

		if (strikeCnt == 0) {
			System.out.println(ballCnt + "볼");
			return;
		}

		if (ballCnt == 0) {
			System.out.println(strikeCnt + "스트라이크");
			return;
		}

		System.out.println(ballCnt + "볼 " + strikeCnt + "스트라이크");
	}

	// 게임 끝낼지 말지 고르는 기능
	public static boolean gameover() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
		String str = Console.readLine();

		// 길이가 1이 아니거나 입력값이 1,2가 아니면 예외 발생
		if ((str.length() != 1) || !(str.charAt(0) == '1' || str.charAt(0) == '2')) {
			throw new IllegalArgumentException();
		}

		if (str.charAt(0) == '1') {
			return true;
		} else if (str.charAt(0) == '2') {
			return false;
		}

		return false;

	}

}
