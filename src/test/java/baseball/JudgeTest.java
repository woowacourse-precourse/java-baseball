package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class JudgeTest {

	@Test
	void checkScore_메서드_테스트_3스트라이크(){
		Judge judge;
		ArrayList<Integer> targetNumber = new ArrayList<>(Arrays.asList(1,2,3));
		ArrayList<Integer> playerInputNumber = new ArrayList<>(Arrays.asList(1,2,3));
		judge = Judge.checkScore(targetNumber, playerInputNumber);
		int expectStrike = 3;
		int expectBalls = 0;
		assertThat(expectStrike).isEqualTo(judge.getStrike());
		assertThat(expectBalls).isEqualTo(judge.getBall());
	}

	@Test
	void checkScore_메서드_테스트_3볼(){
		Judge judge;
		ArrayList<Integer> targetNumber = new ArrayList<>(Arrays.asList(1,2,3));
		ArrayList<Integer> playerInputNumber = new ArrayList<>(Arrays.asList(3,1,2));
		judge = Judge.checkScore(targetNumber, playerInputNumber);
		int expectStrike = 0;
		int expectBalls = 3;
		assertThat(expectStrike).isEqualTo(judge.getStrike());
		assertThat(expectBalls).isEqualTo(judge.getBall());
	}

	@Test
	void checkScore_메서드_테스트_낫싱(){
		Judge judge;
		ArrayList<Integer> targetNumber = new ArrayList<>(Arrays.asList(1,2,3));
		ArrayList<Integer> playerInputNumber = new ArrayList<>(Arrays.asList(4,5,6));
		judge = Judge.checkScore(targetNumber, playerInputNumber);
		int expectStrike = 0;
		int expectBalls = 0;
		assertThat(expectStrike).isEqualTo(judge.getStrike());
		assertThat(expectBalls).isEqualTo(judge.getBall());
	}

	@Test
	void checkScore_메서드_테스트_1볼_1스트라이크(){
		Judge judge;
		ArrayList<Integer> targetNumber = new ArrayList<>(Arrays.asList(1,2,3));
		ArrayList<Integer> playerInputNumber = new ArrayList<>(Arrays.asList(3,2,6));
		judge = Judge.checkScore(targetNumber, playerInputNumber);
		int expectStrike = 1;
		int expectBalls = 1;
		assertThat(expectStrike).isEqualTo(judge.getStrike());
		assertThat(expectBalls).isEqualTo(judge.getBall());
	}

	@Test
	void checkScore_메서드_테스트_2볼(){
		Judge judge;
		ArrayList<Integer> targetNumber = new ArrayList<>(Arrays.asList(1,2,3));
		ArrayList<Integer> playerInputNumber = new ArrayList<>(Arrays.asList(3,6,2));
		judge = Judge.checkScore(targetNumber, playerInputNumber);
		int expectStrike = 0;
		int expectBalls = 2;
		assertThat(expectStrike).isEqualTo(judge.getStrike());
		assertThat(expectBalls).isEqualTo(judge.getBall());
	}


	@Test
	void checkScore_메서드_테스트_2스트라이크(){
		Judge judge;
		ArrayList<Integer> targetNumber = new ArrayList<>(Arrays.asList(1,2,3));
		ArrayList<Integer> playerInputNumber = new ArrayList<>(Arrays.asList(1,2,6));
		judge = Judge.checkScore(targetNumber, playerInputNumber);
		int expectStrike = 2;
		int expectBalls = 0;
		assertThat(expectStrike).isEqualTo(judge.getStrike());
		assertThat(expectBalls).isEqualTo(judge.getBall());
	}

	@Test
	void printHint_메서드_테스트_2스트라이크(){
		Judge judge;
		ArrayList<Integer> targetNumber = new ArrayList<>(Arrays.asList(1,2,3));
		ArrayList<Integer> playerInputNumber = new ArrayList<>(Arrays.asList(1,2,4));
		judge = Judge.checkScore(targetNumber, playerInputNumber);
		assertThat(judge.printHint()).isEqualTo(2 + Message.STRIKE.getMsg());
	}

	@Test
	void printHint_메서드_테스트_2볼(){
		Judge judge;
		ArrayList<Integer> targetNumber = new ArrayList<>(Arrays.asList(1,2,3));
		ArrayList<Integer> playerInputNumber = new ArrayList<>(Arrays.asList(4,1,2));
		judge = Judge.checkScore(targetNumber, playerInputNumber);
		assertThat(judge.printHint()).isEqualTo(2 + Message.BALL.getMsg());
	}

	@Test
	void printHint_메서드_테스트_낫싱(){
		Judge judge;
		ArrayList<Integer> targetNumber = new ArrayList<>(Arrays.asList(1,2,3));
		ArrayList<Integer> playerInputNumber = new ArrayList<>(Arrays.asList(4,5,6));
		judge = Judge.checkScore(targetNumber, playerInputNumber);
		assertThat(judge.printHint()).isEqualTo(Message.NOTHING.getMsg());
	}

	@Test
	void printHint_메서드_테스트_1볼_1스트라이크(){
		Judge judge;
		ArrayList<Integer> targetNumber = new ArrayList<>(Arrays.asList(1,2,3));
		ArrayList<Integer> playerInputNumber = new ArrayList<>(Arrays.asList(1,5,2));
		judge = Judge.checkScore(targetNumber, playerInputNumber);
		assertThat(judge.printHint()).isEqualTo(1+Message.BALL.getMsg()+" "+1+Message.STRIKE.getMsg());
	}

	@Test
	void printHint_메서드_테스트_3스트라이크(){
		Judge judge;
		ArrayList<Integer> targetNumber = new ArrayList<>(Arrays.asList(1,2,3));
		ArrayList<Integer> playerInputNumber = new ArrayList<>(Arrays.asList(1,2,3));
		judge = Judge.checkScore(targetNumber, playerInputNumber);
		assertThat(judge.isThreeStrike()).isEqualTo(true);
	}
	@Test
	void printHint_메서드_테스트_3스트라이크_아님(){
		Judge judge;
		ArrayList<Integer> targetNumber = new ArrayList<>(Arrays.asList(1,2,3));
		ArrayList<Integer> playerInputNumber = new ArrayList<>(Arrays.asList(1,2,4));
		judge = Judge.checkScore(targetNumber, playerInputNumber);
		assertThat(judge.isThreeStrike()).isEqualTo(false);
	}

}
