package baseball.model;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.Randoms;

class UserBaseballNumberTest {
	private static final int MIN_NUM = 1;
	private static final int MAX_NUM = 9;
	private static final int DIGIT = 3;

	@Test
	void 올바르지_않은_사용자_입력(){
		//given
		String sizeTwo = "12";
		String sizeFour = "2357";
		String containZero = "045";
		String containNonNumber = "a23";
		String containDuplicateNumber = "322";

		//when, then
		assertThatThrownBy(()-> new UserBaseballNumber(sizeTwo))
			.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(()-> new UserBaseballNumber(sizeFour))
			.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(()-> new UserBaseballNumber(containZero))
			.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(()-> new UserBaseballNumber(containNonNumber))
			.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(()-> new UserBaseballNumber(containDuplicateNumber))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 올바른_사용자_입력(){
		//given
		List<String> testStringList = new ArrayList<>();
		for(int i = 0; i<10000;i++){
			StringBuilder sb = new StringBuilder();
			while(sb.length() != DIGIT){
				int randomNum = Randoms.pickNumberInRange(MIN_NUM,MAX_NUM);
				String randomNumToString = String.valueOf(randomNum);
				if(sb.indexOf(randomNumToString) == -1)
					sb.append(randomNum);
			}
			testStringList.add(sb.toString());
		}

		for (String testString : testStringList){
			new UserBaseballNumber(testString);
		}
	}
}