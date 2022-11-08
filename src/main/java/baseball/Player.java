package baseball;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

class Player {
	static int number;
	static String numberString;
	static List<Integer> numberList;

	static void writeNumber() {
		numberString = readLine();
	}
}