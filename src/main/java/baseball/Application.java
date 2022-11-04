package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Application {
	static HashMap<String,Integer> possibleBallResult = new HashMap<>();
	static List<Integer> computer = new ArrayList<>();
    public static void main(String[] args) {
    	randomComNum(computer);  //randomComNum 함수로 computer로부터 랜덤 숫자 정하기
    }
    
    public static void randomComNum(List<Integer> computer) { //randomnumber 서로 다른 3자리수를 컴퓨터가 생성.
		while(computer.size()<3) {
			int randomNumber = Randoms.pickNumberInRange(1,9);
			if(!computer.contains(randomNumber)) {
				computer.add(randomNumber);
			}
		}
	}
}
