package baseball;

import static camp.nextstep.edu.missionutils.Console.*;
import static camp.nextstep.edu.missionutils.Randoms.*;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Application {
	public static <E> void main(String[] args) {
		System.out.println("숫자 야구 게임을 시작합니다.");
		
		HashSet<Integer> sourceNum = new HashSet<Integer>();
		for (int i = 0; i < 3; i++) {
			sourceNum.add(pickNumberInRange(1, 9));
		}
		List<Integer> targetNum = new ArrayList<Integer>(sourceNum);
		String targetNumStr = targetNum.toString();
		
		System.out.print("숫자를 입력해주세요 : ");
		String guessNum = readLine();
		
		if(guessNum.length() != 3) {
			assertThatIllegalArgumentException();
			
		} else {
			
			if(!(guessNum.equals(targetNumStr))) 
				return;
			System.out.print("숫자를 입력해주세요 : ");
			guessNum = readLine();
			
			List<String> guessNumList = Collections.emptyList();
			for(int i=0; i<3; i++) {
				guessNumList.add(guessNum.substring(i));
			}
	
			if (targetNum.contains(guessNumList)){
				
			} else {
				System.out.println("낫싱");
			}
			
		}
		
	}
	
}