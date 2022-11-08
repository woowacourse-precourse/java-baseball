package model;

import camp.nextstep.edu.missionutils.Console;

public class User {
	private int[] answer;

	public User() {
		this.answer = new int[3];
	}

	public void setnumber() {
		System.out.print("숫자를 입력해주세요 : ");
		
		String input;
		try {
			input = Console.readLine();
			int number = Integer.parseInt(input);
			
			answer[0] = number / 100;
			number %= 100;
			answer[1] = number / 10;
			answer[2] = number % 10;
			
			if (answer[0] == answer[1] || answer[1] == answer[2] || answer[0] == answer[2]) {
				throw new IllegalArgumentException();
			} // 같은수 입력할 시
		} catch (Exception exception) {
			throw new IllegalArgumentException();
		}
	}

	public int[] getnumber() {
		return this.answer;
	}
}
