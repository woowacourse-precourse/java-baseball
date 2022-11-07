package baseball.mvc.structure;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.mvc.model.Model;
import baseball.util.GameStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ModelAndViewTest {

    private static final String TEST_KEY = "test";
    private static final String TEST_VALUE = "test";
    private static final String NONE_KEY = "none";

    private Model model = new Model();
    private ModelAndView mav = new ModelAndView(GameStatus.START);

    @Nested
    @DisplayName("getModelAttribute 메소드는")
    class GetAttributeMethodTest {

        @Test
        @DisplayName("만약 저장한 데이터의 key와 타입을 입력하면 해당 타입으로 데이터를 반환한다.")
        void success_test() {
            model.addAttribute(TEST_KEY, TEST_VALUE);
            mav.setModel(model);

            String result = model.getAttribute(TEST_KEY, String.class);

            assertThat(result).isEqualTo(TEST_VALUE);
        }

        @Test
        @DisplayName("만약 저장하지 않은 데이터의 key를 입력하면 null을 반환한다.")
        void null_test() {
            String result = model.getAttribute(NONE_KEY, String.class);

            assertThat(result).isNull();
        }
    }
}