package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.assertj.core.util.Arrays;

public class Application {
	
    public static void main(String[] args) {
    }
    
    // 컴퓨터 랜덤 숫자 만들기
    public static int RandomNum() {
    	int num = (int) (Math.random()*9 + 1);
    	return num;
    }
    
    // 리스트 배열에 랜덤 숫자 추가
    public static List<Integer> ComputerRandomMake(){
    	List<Integer> computerNum = new ArrayList<>();
    	while(computerNum.size() < 3) {
    		int random = RandomNum();
    		if(computerNum.contains(random)) {
    			continue;
    		} else {
    			computerNum.add(random);    			
    		}
    	}
    	return computerNum;
    }
    
    // 사용자 입력받은 값 리스트 담기
    public static List<Integer> userInputList() {
    	List<Integer> userInputList = new ArrayList<>();
    	Scanner sc = new Scanner(System.in);
    	int userInput = sc.nextInt();
    	userInputList = IntStream.of(inputToList(userInput)).boxed().collect(Collectors.toList());
    	return userInputList;
    }
    
    // 사용자 입력받은 값 리스트로 변환
    public static int [] inputToList(int userInput){
    	int[] userInputList = Stream.of(String.valueOf(userInput).split("")).mapToInt(Integer::parseInt).toArray();
    	return userInputList;
    }
    
    // 자리 상관없이 일치하는 값의 갯수
    public static int totalMatch(List<Integer> computer, List<Integer> userInput) {
    	int total = 0;
    	for(int i= 0 ; i < 3 ; i++) {
    		if(computer.contains(userInput.get(i))) total ++;
    	}
    	return total;
    }
    
}
