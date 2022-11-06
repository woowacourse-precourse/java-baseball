package baseball;

import java.util.List;

/**
* GameManager
* 게임 진행을 위한 클래스
* 
* @author mirasoy
* @version 0.1, 작업 내용
*/

public class GameManager {
	
	private ComparisonTool comparisonTool;
	
	/**
     * 게임 시작 문구 출력
     */
	public void open() {
		System.out.println("숫자 야구 게임을 시작합니다.");
	}
	
	/**
     * 게임 셋팅
     * 랜덤한 컴퓨터 값 설정
     */
	public void setGame() {
		List<Integer> computer = BaseballUtil.getRandomInteger();
		comparisonTool = new ComparisonTool(computer);
	}
	
	/**
     * 게임 셋팅
     * 랜덤한 컴퓨터 값 설정
     */
	public void startGame() {

		ComparisonResults result= new ComparisonResults();
    	while(result.strike != 3) {
    		System.out.print("숫자를 입력해주세요 : ");
        	List<Integer> user = BaseballUtil.getUserInteger();
        	result = comparisonTool.compaerResult(user);
        	System.out.println(result);
    	}
	}

	
}
