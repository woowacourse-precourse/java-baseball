package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.*;

public class Application{
    public static void main(String[] args) {
    	int answer = makeRandomNumber();
    	
    	return;
        // TODO: 프로그램 구현
    }
    
    public static int makeRandomNumber() {
    	int result = 0;
    	int cnt = 1;
    	
    	List<Integer> uniqueNumberList = new ArrayList<>();
    	uniqueNumberList = Randoms.pickUniqueNumbersInRange(1,9,9);
    	
    	for(int i=0;i<uniqueNumberList.size();i++) {
    		result += uniqueNumberList.get(i)*cnt;
    		cnt*=10;
    	}
    	return result;
    }
}
