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

}
