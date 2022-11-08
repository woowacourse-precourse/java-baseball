package baseball;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import camp.nextstep.edu.missionutils.*;

public class Application {
	public static void main(String[] args) {
		String answer = makeRandomNumber();
		String input;
		int strikeCount = 0;
		String keepGoing = "1";

		System.out.println("숫자 야구 게임을 시작합니다.");

		while (keepGoing.equals("1")) {
			System.out.print("숫자를 입력해주세요 : ");
			input = Console.readLine();
			if (!uniqueNumCheck(input))
				throw new IllegalArgumentException("입력된 값은 서로 다른 세자리 숫자로 이루어져야 합니다.");

			strikeCount = comparison(answer, input);

			if (strikeCount == 3) {
				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
				System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
				keepGoing = Console.readLine();
				answer = makeRandomNumber();
			}

			if (!(keepGoing.equals("1") || keepGoing.equals("2")))
				throw new IllegalArgumentException("잘못된 값이 입력되었습니다.");
		}

		return;
	}

	public static String makeRandomNumber() {
		String result = "";
		int temp = 0;
		List<Integer> numberList = new LinkedList<>();

		for (int i = 1; i < 10; i++)
			numberList.add(i);

		for (int i = 0; i < 3; i++) {
			temp = Randoms.pickNumberInRange(1, 9);
			while (numberList.contains(temp)) {
				numberList.remove(numberList.indexOf(temp));
				result += temp;
			}
		}

		return result;
	}

	public static boolean uniqueNumCheck(String input) {
		String[] inputSet = input.split("");
		HashSet<String> hash = new HashSet<>();
		for (String s : inputSet)
			hash.add(s);
		if (hash.size() == 3)
			return true;
		else
			return false;
	}

	public static int comparison(String comNum, String userNum) {
		int strikeCount = 0;
		int ballCount = 0;
		String[] comNumSet = comNum.split("");
		String[] userNumSet = userNum.split("");
		HashSet<String> hash = new HashSet<>();

		for (int i = 0; i < comNumSet.length; i++) {
			hash.add(comNumSet[i]);
			hash.add(userNumSet[i]);
			if (comNumSet[i].equals(userNumSet[i]))
				strikeCount++;
		}

		ballCount = 6 - hash.size() - strikeCount;

		if (ballCount > 0)
			System.out.print(ballCount + "볼 ");
		if (strikeCount > 0)
			System.out.print(strikeCount + "스트라이크 ");
		if (ballCount + strikeCount == 0)
			System.out.print("낫싱");
		System.out.println();

		return strikeCount;
	}
}
