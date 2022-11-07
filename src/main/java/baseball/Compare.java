package baseball;

import java.util.List;

public class Compare {
	public int howMany(List<Integer> computer, List<Integer> player) {
		int result = 0;
		for (int i = 0; i < player.size(); i++) {
			if (computer.contains(player.get(i))) {
				result += 1;
			}
		}
		return result;
	}
}