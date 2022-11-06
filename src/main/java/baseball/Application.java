package baseball;

import camp.nextstep.edu.missionutils.*;

public class Application {
	public static void main(String[] args) {
		String user_input_number = Console.readLine();
		try{
			Validation.validation("user_input_number_validation",user_input_number);
		}catch (IllegalArgumentException e){
			return;
		}
	}
}
