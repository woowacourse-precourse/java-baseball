//package baseball;
//
//import org.junit.jupiter.api.Test;
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//public class ComputerNumberTest {
//    @Test
//    void 컴퓨터수_범위_테스트() {
//        //when
//        List<Integer> computerNum = GameModel.createComputerNumber();
//        //then
//        assertThat(computerNum.stream().allMatch(v -> 1 <= v && v <= 9)).isTrue();
//    }
//
//    @Test
//    void 컴퓨터수_서로다른수_테스트() {
//        //given
//        Set<Integer> numbers = new HashSet<>();
//        //when
//        List<Integer> computerNum = GameModel.createComputerNumber();
//        numbers.addAll(computerNum);
//        //then
//        assertThat(numbers.size()).isEqualTo(3);
//    }
//}
