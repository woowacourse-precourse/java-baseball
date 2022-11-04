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
    	String numstr="";      //numstr string에 사용자 입력 받기
    	
    	System.out.println("숫자 야구 게임을 시작합니다.");
		while(true) {
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
}
