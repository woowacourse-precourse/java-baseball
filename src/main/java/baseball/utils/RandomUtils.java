package baseball.utils;


public class RandomUtils {
	public int[] getRandomNumbers() {
		int[] numbers = new int[3];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int)(Math.random() * 9) + 1;

			// 중복 확인 및 제거
			for (int j = 0; j < i; j++) {
				if (numbers[i] == numbers[j]) {
					i--;
					break;
				}
			}
		}
		return numbers;
	}

}
