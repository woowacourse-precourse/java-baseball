package baseball;


/**
* ComparisonResults
* 컴퓨터와 입력값을 비교한 결과값
* 
* @author mirasoy
* @version 0.1, 작업 내용
*/
public class ComparisonResults {
	int strike; 	//Strike의 갯수
	int ball;		//ball의 갯수

	@Override
	public String toString() {

		String result = "";
		if (ball > 0) {
			result += ball + "볼";
		}
		if (strike > 0) {
			if (ball > 0) {
				result += " ";
			}
			result += strike + "스트라이크";
		}
		if (ball + strike == 0) {
			result += "낫싱";
		}
		return result;
	}	
}
