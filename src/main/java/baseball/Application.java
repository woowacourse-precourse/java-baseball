package baseball;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
	
	static List<Integer> computerNUM = new ArrayList<>();
	
	
    public static void main(String[] args) {
    	
    }
    //랜덤 값 지정 camp.nextstep.edu.missionutils.Randoms 사용 
    static int computer(int digit){
    	int randomNUM = 0;
    	while(computerNUM.size()<3) {
    		randomNUM = pickNumberInRange(1,9);
    		computerNUM.add(randomNUM);
    	}
    	return computerNUM.get(digit);
    	//computer(0);
    }
}
