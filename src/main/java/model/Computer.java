package model;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
	private int[] guessnumber;

	public Computer() {
		this.guessnumber = new int[3];
	}

	public void setnumber() {
		int[] guessnumber = new int[3];
		boolean[] visited = new boolean[10];
		int count = 0;
		while (count < 3) {
			int num = Randoms.pickNumberInRange(1, 9);
			if (!visited[num]) {
				visited[num] = true;
				guessnumber[count] = num;
				count++;
			}
		} // 서로 다른 맞춰야 하는 수

		this.guessnumber = guessnumber;
	}

	public int[] getnumber() {
		return this.guessnumber;
	}
}
