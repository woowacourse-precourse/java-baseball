package baseball.custom;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;


import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidationTest extends NsTest {

	@Test
	void 만약_한글_문자열이_입력된_경우(){
		assertSimpleTest(() ->
				assertThatThrownBy(() -> runException("자바서버개발자이성호"))
						.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 만약_영문_문자열이_입력된_경우(){
		assertSimpleTest(() ->
				assertThatThrownBy(() -> runException("JavaServerDeveloper"))
						.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 만약_중복된_숫자3자리가_입력된_경우(){
		assertSimpleTest(() ->
				assertThatThrownBy(() -> runException("777"))
						.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 만약_입력된_숫자가_3자리가_아닌_경우(){
		assertSimpleTest(() ->
				assertThatThrownBy(() -> runException("1279"))
						.isInstanceOf(IllegalArgumentException.class)
		);
	}



	@Override
	protected void runMain() {
		Application.main(new String[]{});
	}
}
