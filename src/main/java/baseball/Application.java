package baseball;

import camp.nextstep.edu.missionutils.*;

import java.util.List;

public class Application {
	public static void main(String[] args) {
		String user_input_number = Console.readLine();
		try{
			Validation.validation("user_input_number_validation",user_input_number);
			List<Integer> random_number_list = RandomNumber.createRandomNumber();
		}catch (IllegalArgumentException e){
			return;
		}
	}
}
