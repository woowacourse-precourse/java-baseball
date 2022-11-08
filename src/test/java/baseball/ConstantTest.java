package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class ConstantTest{

	@Test
	public void 올바른_숫자_나오는지_최소(){
		assertThat(Constant.MIN_VALUE.getNumber()).isEqualTo(1);
	}

	@Test
	public void 올바른_숫자_나오는지_최대(){
		assertThat(Constant.MAX_VALUE.getNumber()).isEqualTo(9);
	}

	@Test
	public void 숫자_길이_체크(){
		String number1 = "123";
		String number2 = "1234";
		assertThat(Constant.NUMBER_LENGTH.getNumber()).isEqualTo(number1.length());
		assertThat(Constant.NUMBER_LENGTH.getNumber()).isNotEqualTo(number2.length());

	}

	@Test
	public void 올바른_숫자_나오는지_재시작(){
		assertThat(Constant.RESTART.getNumber()).isEqualTo(1);
	}

	@Test
	public void 올바른_숫자_나오는지_끝내기(){
		assertThat(Constant.END_GAME.getNumber()).isEqualTo(2);
	}

	@Test
	public void 틀리는_테스트(){
		assertThat(Constant.MIN_VALUE.getNumber()).isNotEqualTo(5);
	}

}
