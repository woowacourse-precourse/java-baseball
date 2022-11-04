package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

public class Application {
	static HashMap<String,Integer> possibleBallResult = new HashMap<>();
	static List<Integer> computer = new ArrayList<>();
    public static void main(String[] args) {
    	randomComNum(computer);  //randomComNum 함수로 computer로부터 랜덤 숫자 정하기
    	String numstr="";      //numstr string에 사용자 입력 받기
    	
    	System.out.println("숫자 야구 게임을 시작합니다.");
		while(true) {
			int strikeCount=0;
			int ballCount=0;
			
			if(numstr.equals("1")) {  //게임을 새로 시작할 것인지 종료할 것인지 1,2 선택
				numstr="";            //numstr = ""로 만들어 else구문으로 다시 진입하게 만드는 장치
				continue;
			}
			else if(numstr.equals("2")) {
				System.out.println("게임종료");
				break;
			}
			else {                     //numstr이 1,2가 아니라면 무조건 else구문으로 들어와서 check
				System.out.print("숫자를 입력해주세요 : "); 
				numstr = Console.readLine();
				check(numstr,strikeCount,ballCount);
				System.out.println(print(ballCount,strikeCount));
			}
			if(strikeCount==3) {       //3개의 숫자를 모두 맞추고 난 후(strikeCount 3개) 게임 다시 시작, 종료를 고르는 구문
				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
				System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
				numstr = Console.readLine();
			}	
		}	
    }
    
    public static void randomComNum(List<Integer> computer) { //randomnumber 서로 다른 3자리수를 컴퓨터가 생성.
		while(computer.size()<3) {
			int randomNumber = Randoms.pickNumberInRange(1,9);
			if(!computer.contains(randomNumber)) {
				computer.add(randomNumber);
			}
		}
	}
    
    public static void check(String numstr,int strikeCount,int ballCount) {
    	String pattern = "^[1-9]{3}$";
		if(Pattern.matches(pattern,numstr)) {  //입력한 문자가 숫자가 아니면 IllegalArgumentException 발생
			throw new IllegalArgumentException();
		}
		
		String[] num = numstr.split("");
		HashSet<String> numSet = new HashSet<>(); //입력한 숫자들이 하나라도 중복이 되면 IllegalArgumentException 발생.
		for(int i=0;i<num.length;i++) {
			numSet.add(num[i]);
		}
		if(numSet.size()!=3) {
			throw new IllegalArgumentException();
		}
		
		possibleBallResult.put("볼",0);
		possibleBallResult.put("스트라이크",0);
			
		for(int i =0;i<num.length;i++) {
			if(Integer.parseInt(num[i])==computer.get(i)){  //스트라이크 개수 세기(computer 리스트 글자 하나와 사용자 입력 숫자 하나씩 같은지, 같은 위치인지까지 체크 - 스트라이크)
				strikeCount = possibleBallResult.getOrDefault("스트라이크",0 );
				strikeCount++;
				possibleBallResult.put("스트라이크", strikeCount);
			}
			else if(computer.contains(Integer.parseInt(num[i]))){ //볼 개수 세기(computer 리스트에 있는 모든 원소 중 사용자 입력 숫자가 하나라도 있는지 체크 - 볼)
				ballCount++;
				possibleBallResult.put("볼", ballCount);
			}
		}
	}
    
    public static String print(int ballCount, int strikeCount) {	
		String printResult="";
		if(ballCount==0 && strikeCount==0) {
			printResult="낫싱";
		}
		else if(ballCount>0 && strikeCount==0){
			printResult=String.valueOf(ballCount)+"볼";
		}
		else if(ballCount==0 && strikeCount>0) {
			printResult=String.valueOf(strikeCount)+"스트라이크";
		}
		else if(ballCount>0 && strikeCount>0){
			printResult=String.valueOf(ballCount)+"볼 "+String.valueOf(strikeCount)+"스트라이크";
		}
		return printResult;
	}
}
