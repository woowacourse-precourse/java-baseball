package baseball;

import java.util.HashSet;
import java.util.Set;

public class InputValidation {
	int start = 0;
	int end = 9;
	int size = 3;
	
	public InputValidation() {}
	
	public InputValidation(int start, int end, int size) {
		this.start = start;
		this.end = end;
		this.size = size;
	}

	
	public boolean isValidRandomNumbers(int inputData) {
		String data = Integer.toString(inputData);
		
		return isValidRandomNumbers(data);
	}
	
	
	public boolean isValidRandomNumbers(String inputData) {
		if(inputData.length()!=size) {
			return false;
		}
		Set<Character> set = new HashSet<>();
		for(char randomNumber : inputData.toCharArray()) {
			
			char startChar = (char) ('0' + start);
			char endChar = (char) ('0' + end);
			
			if((randomNumber < startChar) || (randomNumber > endChar)) {
				return false;
			}
			if(set.contains(randomNumber)) {
				return false;
			}
			set.add(randomNumber);
		}
		return true;
	}

	
	public boolean isValidReStart(int input) {
		String data = Integer.toString(input);
		
		return isValidRandomNumbers(data);
	}
	
	
	public boolean isValidReStart(String input) {
		if(input.equals("1")||input.equals("2")){
			return true;
		}else {
			return false;
		}
	}
}
