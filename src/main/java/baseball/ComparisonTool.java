package baseball;

import java.util.List;

/**
* ComparisonTool
* 컴퓨터와 입력값을 비교하기 위해 만든 class
* 
* @author mirasoy
* @version 0.1, 작업 내용
*/

public class ComparisonTool {
	
	List<Integer> computer; //컴퓨터 입력값

	/**
     * 컴퓨터 값을 인스턴스 변수로 설정
     * @param 컴퓨터 값 
     */
	public ComparisonTool(List<Integer> computer) {
		this.computer = computer;
	}
	
	
	/**
     * 사용자의 입력값을 비교하여 결과 도출
     * @param 사용자의 입력값
     * @return 비교결과
     */
	public ComparisonResults compaerResult(List<Integer> user) {
		
		ComparisonResults result = new ComparisonResults();

		int count = 0;
		int ball = 0;
		
		for (int i = 0; i < user.size(); i++) {
			if(computer.get(i) == user.get(i)) {
				count++;
			}else if(computer.contains(user.get(i))){
				ball++;
			}
		}
		
		result.strike = count;
		result.ball = ball;
		return result;
	}

	
}
