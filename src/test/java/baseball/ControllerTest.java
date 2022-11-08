//
//package baseball;
//
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//import java.util.Map;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//
//public class ControllerTest {
//
//    @Test
//    void 컴퓨터수_플레이어수_비교하기_테스트() {
//        List<Integer> computerNumber = List.of(8, 9, 3);
//        List<Integer> playerNumber = List.of(1, 2, 3);
//        Map<String, Integer> resultMap = Map.of("strike", 1, "nothing", 2);
//        GameController controller = new GameController();
//        assertThat(controller.checkAnswer(computerNumber, playerNumber)).isEqualTo(resultMap);
//
//    }
//
//    @Test
//    void 컴퓨터수_플레이어수_비교하기_테스트2() {
//        List<Integer> computerNumber = List.of(7, 9, 3);
//        List<Integer> playerNumber = List.of(1, 7, 3);
//        Map<String, Integer> resultMap = Map.of("strike", 1, "ball", 1, "nothing", 1);
//        GameController controller = new GameController();
//        assertThat(controller.checkAnswer(computerNumber, playerNumber)).isEqualTo(resultMap);
//    }
//
//    @Test
//    void 결과값_문자열_테스트1() {
//        Map<String, Integer> resultMap = Map.of("strike", 1, "ball", 1, "nothing", 1);
//        String hint = "1볼 1스트라이크";
//        GameController controller = new GameController();
//        String result = controller.createHint(resultMap);
//        System.out.println(result);
//
//        assertThat(result).isEqualTo(hint);
//    }
//
//    @Test
//    void 결과값_문자열_테스트2() {
//        Map<String, Integer> resultMap = Map.of("nothing", 3);
//        String hint = "낫싱";
//        GameController controller = new GameController();
//        String result = controller.createHint(resultMap);
//        System.out.println(result);
//
//        assertThat(result).isEqualTo(hint);
//    }
//
//    @Test
//    void 결과값_문자열_테스트3() {
//        Map<String, Integer> resultMap = Map.of("strike", 2, "nothing", 1);
//        String hint = "2스트라이크";
//        GameController controller = new GameController();
//        String result = controller.createHint(resultMap);
//        System.out.println(result);
//
//        assertThat(result).isEqualTo(hint);
//    }
//}
//
