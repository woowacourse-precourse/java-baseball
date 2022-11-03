package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest extends NsTest {
	Computer computer = new Computer();
	User user = new User();
	Game game = new Game();

	@DisplayName("숫자 생성의 범위를 확인한다")
	@Test
	void testNumberCreationRange() {
		int randomNumber = computer.createOneRandomNumber();

		assertThat(randomNumber).isBetween(1, 9);
	}

	@DisplayName("난수 생성을 확인한다")
	@RepeatedTest(50)
	void testRandomNumberGeneration() {

        /*
          랜덤으로 숫자가 만들어지는 것을 확인하기 위해서
          일정 수준을 여러번 생성하는 시나리오를 가정한다.
          즉,
          9의 크기를 가진 배열에 모든 숫자를 계속 해서 채워 넣는다면
          특정 반복 횟수를 지나
          모든 공간이 채워진다면
          랜덤 숫자가 만들어지는 것이라고 가정하고
          이를 검증한다.

          배열의 공간        0 1 2 3 4 5 6 7 8
          랜덤 숫자          1 2 3 4 5 6 7 8 9
          호출시 1로 초기화   1 1 1 1 1 1 1 1 1 => 합계 9
         */

		int[] counts = new int[10];

		for (int counter = 0; counter < 70; counter++) {
			int randomNumber = computer.createOneRandomNumber();
			counts[randomNumber] = 1;
		}

		int sum = 0;

		for (int counter = 0; counter < 10; counter++) {
			sum += counts[counter];
		}

		assertEquals(9, sum);
	}

	@DisplayName("난수 생성 후 저장시 중복을 확인한다")
	@Test
	void canVerifyDuplication() {
		List<Integer> list1 = List.of(3, 3);
		List<Integer> list2 = List.of(1, 7);
		List<Integer> list3 = List.of(2, 5);

		assertThat(computer.hasDuplication(list1, 3)).isTrue();
		assertThat(computer.hasDuplication(list2, 7)).isTrue();
		assertThat(computer.hasDuplication(list3, 6)).isFalse();
	}

	@DisplayName("최종 생성된 컴퓨터 난수의 자리수를 확인한다")
	@RepeatedTest(30)
	void testComputerNumberSize() {
		assertThat(computer.getNumbers().size()).isEqualTo(3);
	}

	@DisplayName("최종 생성된 컴퓨터 난수의 중복 여부를 확인한다")
	@RepeatedTest(30)
	void testComputerNumberWithoutDuplication() {
		LinkedHashMap<Integer, Integer> desirableMap = new LinkedHashMap<>() {
			{
				put(5, 0);
				put(5, 1);
				put(5, 2);
			}
		};

		assertThat(computer.getNumbers()).isNotSameAs(desirableMap);
	}

	@DisplayName("컴퓨터 생성 난수의 자료형 전처리 수행을 테스트한다")
	@Test
	void testComputerNumberIsProcessed() {
		List<Integer> createdList = List.of(5, 9, 1);
		LinkedHashMap<Integer, Integer> desirableMap = new LinkedHashMap<>(){
			{
				put(5, 0);
				put(9, 1);
				put(1, 2);
			}
		};
		assertThat(computer.processNumbers(createdList)).isEqualTo(desirableMap);
	}


	@DisplayName("유저가 입력한 숫자의 중복 여부를 확인한다")
	@Test
	void testUserInputDuplication() {
		assertThat(user.hasDuplication("221")).isTrue();
	}

	@DisplayName("유저가 입력한 숫자의 길이가 설정된 숫자와 같은지 확인한다")
	@Test
	void testUserInputLength() {
		assertThat(user.followDigitRule("591", 3)).isTrue();
	}

	@DisplayName("유저의 입력이 숫자로만 구성되어 있는지 확인한다")
	@Test
	void testUserInputIsNumberOnly() {
		assertThat(user.isNumberOnly("591")).isTrue();
		assertThat(user.isNumberOnly("ad3")).isFalse();
	}


	@DisplayName("유저 입력 오류시 예외 처리가 작동하는지 확인한다")
	@Test
	void testUserHandleException() {
		assertThatCode(() -> user.handleInputError("222"))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("잘못입력하였습니다. 프로그램을 종료합니다.");
	}

	@DisplayName("유저 입력에 대한 자료형 전처리 수행을 테스트한다")
	@Test
	void testUserInputIsProcessed() {
		LinkedHashMap<Integer, Integer> desirableMap = new LinkedHashMap<>(){
			{
				put(5, 0);
				put(9, 1);
				put(1, 2);
			}
		};
		assertThat(user.processNumbers("591")).isEqualTo(desirableMap);
	}

	@DisplayName("스트라이크를 확인한다")
	@Test
	void verifyStrike(){
		assertThat(game.isStrike(2,1,2,1)).isTrue();
	}

	@DisplayName("볼을 확인한다")
	@Test
	void verifyBall(){
		assertThat(game.isBall(6,5,6,2)).isTrue();
	}


	@Test
	void 게임종료_후_재시작() {
		assertRandomNumberInRangeTest(
				() -> {
					run("246", "135", "1", "597", "589", "2");
					assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
				},
				1, 3, 5, 5, 8, 9
		);
	}

	@Test
	void 예외_테스트() {
		assertSimpleTest(() ->
				assertThatThrownBy(() -> runException("1234"))
						.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Override
	public void runMain() {
		Application.main(new String[]{});
	}
}
