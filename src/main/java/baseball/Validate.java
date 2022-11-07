package baseball;

public class Validate {
	public void checkCorrectInput(String number){

	}

	public static boolean isNumeric(String number){
		try{
			Integer.parseInt(number);
			return true;
		}catch (NumberFormatException e){
			return false;
		}
	}

}
