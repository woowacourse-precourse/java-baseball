package model;

import camp.nextstep.edu.missionutils.Console;

public class User {
	private static final String start_game_input_usernumber = "숫자를 입력해주세요 : ";
	private int[] input;

	public User() {
		this.input = new int[3];
	}

	public void setnumber() {
		System.out.print(start_game_input_usernumber);
		
		try {
			int number = Integer.parseInt(Console.readLine());
			
			input[0] = number / 100;
			number %= 100;
			input[1] = number / 10;
			input[2] = number % 10;
			
			if (input[0] == input[1] || input[1] == input[2] || input[0] == input[2]) {
				throw new IllegalArgumentException();
			} // 같은수 입력할 시
		} catch (Exception exception) {
			throw new IllegalArgumentException();
		}
	}

	public int[] getnumber() {
		return this.input;
	}
}
