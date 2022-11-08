package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.HashMap;

class FunctionTest extends NsTest {
	static List<Integer> computerNumber = new ArrayList<>();
	@BeforeEach
	void setting() {
		computerNumber = baseball.Application.makeComputer();
	}
	
    @Test
    void 생성된_컴퓨터수_3자리인지() {
        assertThat(computerNumber.size()).isEqualTo(3);
    }
    
    @Test
    void 생성된_컴퓨터수_1에서9_사이인지() {
    	for(int i=0;i<3;i++) {
    		assertThat(computerNumber.get(i)).isBetween(1,9);
    	}
    }
    
    @Test
    void 생성된_컴퓨터수_3자리_모두다른수인지() {
    	Map<Integer,Object> map = new HashMap<>();
    	for(int i=0;i<3;i++) {
    		map.put(computerNumber.get(i),"");
    	}
    	assertThat(map.size()).isEqualTo(3);
    }
    
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
