package baseball.game;

import baseball.input.Input;
import baseball.output.Result;
import baseball.player.Computer;
import baseball.player.Player;
import baseball.rule.BaseballGameRule;

public class BaseballGame {

	Player player;
	Computer computer;
	BaseballGameRule baseballGameRule;
	boolean isGameRun = true;
	private static final String GAME_WIN = Result.THREE_STRIKE_ZERO_BALL.getMessage();
	private static final String GAME_OVER = "2";

	public BaseballGame() {
		this.player = new Player();
		this.computer = new Computer();
		this.baseballGameRule = new BaseballGameRule(player,computer);
	}

	public void start() {
		System.out.println("숫자 야구 게임을 시작합니다.");
		while (isGameRun) {
			System.out.print("숫자를 입력해주세요 : ");
			String number = Input.insertNumber();
			player.insertNumber(number);
			baseballGameRule.isPlayerNumberValidate();
			String result = Result.getResult(baseballGameRule.getScore());
			System.out.println(result);
			isEnd(result);
		}
	}
	private void isEnd(String result){
		if(result.equals(GAME_WIN)){
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			askRestart();
		}
	}
	private void askRestart(){
		String askNumber = Input.insertNumber();
		if(askNumber.equals(GAME_OVER)){
			isGameRun = false;
			return;
		}
		this.baseballGameRule = new BaseballGameRule(player,new Computer());
	}
}
