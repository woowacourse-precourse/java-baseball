package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import camp.nextstep.edu.missionutils.*;

public class Application{
    public static void main(String[] args) {
    	String answer = makeRandomNumber();
    	String input;
    	int strikeCount = 0;
    	String keepGoing = "1";
    	
    	System.out.println(answer);
    	
    	System.out.println("숫자 야구 게임을 시작합니다.");
    	
    	while(keepGoing.equals("1")) {
        	System.out.print("숫자를 입력해주세요 : ");
        	input = Console.readLine();
        	
        	strikeCount = comparison(answer,input);
        	
        	if(strikeCount == 3) {
        		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        		keepGoing = Console.readLine();
        	}  	
    	}
 
    	return;
    }
    
    public static String makeRandomNumber() {
    	String result = "";
    	List<Integer> uniqueNumberList = new ArrayList<>();
    	
    	uniqueNumberList = Randoms.pickUniqueNumbersInRange(1,9,9);
    	
    	for(int i=0;i<3;i++) {
    		result += uniqueNumberList.get(i);
    	}
    	
    	return result;
    }
    
    public static int comparison(String comNum,String userNum) {
    	int strikeCount = 0;
    	int ballCount = 0;
    	String[] comNumSet = comNum.split("");
    	String[] userNumSet = userNum.split("");
    	HashSet<String> hash = new HashSet<>();
    	
    	for(int i=0;i<3;i++) {
    		hash.add(comNumSet[i]);
    		hash.add(userNumSet[i]);
    		if(comNumSet[i].equals(userNumSet[i]))
    			strikeCount++;
    	}
    	
    	ballCount = 6-hash.size()-strikeCount;
    	
    	if(ballCount>0)
    		System.out.print(ballCount+"볼 ");
    	if(strikeCount>0)
    		System.out.print(strikeCount+"스트라이크 ");
    	System.out.println();
    	
    	return strikeCount;	
    }
}
