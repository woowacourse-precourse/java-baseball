//package baseball;
//
//import camp.nextstep.edu.missionutils.test.NsTest;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
//import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThatThrownBy;
//import static org.junit.jupiter.api.Assertions.*;
//
//class ApplicationTest2 extends NsTest {
//    @DisplayName("올바른 랜덤 값 생성")
//    @Test
//    void createTargetNums_test() {
//        List<Integer> result = Application.createTargetNums();
//        assertEquals(3, result.size());
//        for(int element : result)
//            assertThat(element).isBetween(1, 9);
//        Set<Integer> numSet = new HashSet<>(result);
//        assertEquals(3,numSet.size());
//    }
//    @DisplayName("Input 유효성 테스트")
//    @Test
//    void isValidInput_test(){
//        assertFalse(Application.isValidInput(""));
//        assertFalse(Application.isValidInput("1234"));
//        assertFalse(Application.isValidInput("abcd"));
//        assertFalse(Application.isValidInput("111"));
//        assertFalse(Application.isValidInput("012"));
//        assertFalse(Application.isValidInput("A12"));
//
//        assertTrue(Application.isValidInput("123"));
//    }
//    @DisplayName("볼 스트라이크 계산 테스트1")
//    @Test
//    void count_BallStrike_test1(){
//        //case1
//        //target :456
//        //user:457
//        //expected value: 0 ball 2 strikes
//        ArrayList<Integer> target = new ArrayList<>(List.of(4,5,6));
//        ArrayList<Integer> user = new ArrayList<>(List.of(4,5,7));
//        ArrayList<Integer> ans = new ArrayList<>(List.of(0,2));
//        assertEquals(ans,Application.count_BallStrike(target,user));
//    }
//    @DisplayName("볼 스트라이크 계산 테스트2")
//    @Test
//    void count_BallStrike_test2(){
//        //case2
//        //target :123
//        //user:231
//        //expected value: 3 ball 0 strikes
//        ArrayList<Integer> target = new ArrayList<>(List.of(1,2,3));
//        ArrayList<Integer> user = new ArrayList<>(List.of(2,3,1));
//        ArrayList<Integer> ans = new ArrayList<>(List.of(3,0));
//        assertEquals(ans,Application.count_BallStrike(target,user));
//    }
//    @DisplayName("볼 스트라이크 계산 테스트3")
//    @Test
//    void count_BallStrike_test3(){
//        //case3
//        //target :123
//        //user:456
//        //expected value: 0 ball 0 strikes
//        ArrayList<Integer> target = new ArrayList<>(List.of(1,2,3));
//        ArrayList<Integer> user = new ArrayList<>(List.of(4,5,6));
//        ArrayList<Integer> ans = new ArrayList<>(List.of(0,0));
//        assertEquals(ans,Application.count_BallStrike(target,user));
//    }
//    @DisplayName("볼 스트라이크 계산 테스트4")
//    @Test
//    void count_BallStrike_test4(){
//        //case4
//        //target :123
//        //user:132
//        //expected value: 2 ball 1 strikes
//        ArrayList<Integer> target = new ArrayList<>(List.of(1,2,3));
//        ArrayList<Integer> user = new ArrayList<>(List.of(1,3,2));
//        ArrayList<Integer> ans = new ArrayList<>(List.of(2,1));
//        assertEquals(ans,Application.count_BallStrike(target,user));
//    }
//
//    @Override
//    public void runMain() {
//        Application.main(new String[]{});
//    }
//}
