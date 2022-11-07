package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Distinguisher {
	
	public String distinguish(List<Integer> randomNumber, String input) {
		List<Integer> inputList = new ArrayList<>();
		for(char c : input.toCharArray()) {
			inputList.add(c-'0');
		}
		return distinguish(randomNumber, inputList);
	}

	
	public String distinguish(List<Integer> randomNumber, List<Integer> input) {
		int strikeCount = getStrikeCount(randomNumber, input);
		int ballCount = getBallCount(randomNumber, input);
		
		if(strikeCount==0 && ballCount==0) {
			return "낫싱";
		}
		StringBuilder sb = new StringBuilder();
		if(ballCount>0) {
			sb.append(ballCount);
			sb.append("볼 ");
		}
		if(strikeCount>0) {
			sb.append(strikeCount);
			sb.append("스트라이크");
		}else {
			sb.delete(sb.length()-1, sb.length());
		}
		
		return sb.toString();
	}
	
	private int getStrikeCount(List<Integer> randomNumber, List<Integer> input) {
		int strikeCount = 0;
		int size = randomNumber.size();
		
		for(int i=0;i<size;i++) {
			if(randomNumber.get(i)==input.get(i)) {
				strikeCount++;
			}
		}
		return strikeCount;
	}
	
	private int getBallCount(List<Integer> randomNumber, List<Integer> input) {
		int ballCount = 0;
		int size = randomNumber.size();
		Set<Integer> randomNumberSet = new HashSet<>();
		
		for(int i=0; i<size; i++) {
			randomNumberSet.add(randomNumber.get(i));
		}
		
		for(int i=0; i<size; i++) {
			if(randomNumber.get(i)==input.get(i)) {
				continue;
			}
			int element = input.get(i);
			
			if(randomNumberSet.contains(element)) {
				ballCount++;
			}
		}
		return ballCount;
	}
}
