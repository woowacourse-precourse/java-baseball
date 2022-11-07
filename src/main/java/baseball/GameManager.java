package baseball;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

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
     * 게임 시작
     * 정답을 맞출때까지 사용자의 숫자맞추기 게임 진행
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
	
	/**
     * 게임 종료 문구 출력
     */
	public void endGame() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}
	
	/**
     * 재게임 여부 확인
     * @return 재게임 여부 (재게임 : true / 그만두기 : false / 그외 : 예외)
     * @exception 1,2 외의 값 입력시 IllegalArgumentException 발생 
     */
	public boolean confirmRestart() {
		
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String continueResult = Console.readLine();
		
		if(continueResult.equals("1")) {
			return true;
		}
		if(continueResult.equals("2")) {
			return false;
		}
		if(continueResult.equals("1")||continueResult.equals("2")) {
			throw new IllegalArgumentException();
		}
		
		return false;
	}
	
	/**
     * 시스템 종료
     */
	public void terminateGame() {
		System.out.println("숫자 야구 게임을 종료합니다.");
    	System.exit(0);
	}

	
}
