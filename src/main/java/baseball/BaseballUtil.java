package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


/**
* BaseballUtil
* Baseball에서 사용하는 공통 기능에 대한 class
* 
* @author mirasoy
* @version 0.1, 작업 내용
* @see None
*/
public class BaseballUtil {
	
	
	/**
     * 컴퓨터 임의 수 생성기능
     * 3자리의 숫자 , 중복 없음 
     * @return 중복이 없는 사이즈 3의 Interger List
     */
	public static List<Integer> getRandomInteger() {
		
		List<Integer> computer = new ArrayList<Integer>();
    	while (computer.size() < 3) {
    	    int randomNumber = Randoms.pickNumberInRange(1, 9);
    	    if (!computer.contains(randomNumber)) {
    	        computer.add(randomNumber);
    	    }
    	}
		return computer;
	}
	
	/**
     * 사용자의 정답을 입력 받음
     * 3자리의 숫자 , 중복 없음 
     * @return 중복이 없는 사이즈 3의 Interger List
     */
	public static List<Integer> getUserInteger() {
	
		List<Integer> user =  new ArrayList<Integer>();
		String userInputText = Console.readLine();
		if(checkValidation(userInputText)) {
			user = stringToIntegerList(userInputText);
		}else{
			throw new IllegalArgumentException();
		}
		return user;
	}


	/**
     * 사용자의 입력값의 유효성을 확인함
     * @param 사용자의 입력값
     * @return 유효성 여부(유효 true, 무효 false)
     */

	private static boolean checkValidation(String userInputText) {
		
		boolean validation = true;
		//자리수 확인
		if(userInputText.length() != 3){
			validation  = false;
		}
		//숫자여부 확인
		for(char component : userInputText.toCharArray()) {
			if( 49 > component || component > 57) {
				validation = false;
			}
		}
		//중복숫자 확인
		for(char component : userInputText.toCharArray()) {
			long countComponent = userInputText.chars()
	                .filter(c -> c == component)
	                .count();
			if(countComponent != 1) {
				validation = false;
			}
		}
		
		return validation;
	}
	
	/**
     * String을 Integer List로 변환한다
     * @param 숫자로 구성된 String
     * @return String으로 만든 Interger List
     */

	private static List<Integer> stringToIntegerList(String inputString) {
		
		List<Integer> integerList =  new ArrayList<Integer>();
		
		for(char component : inputString.toCharArray()) {
			if( 48 < component && component < 58) {
				int charToInt = Character.getNumericValue(component);
				integerList.add(charToInt);
			}
		}
		
		return integerList;
	}

}
