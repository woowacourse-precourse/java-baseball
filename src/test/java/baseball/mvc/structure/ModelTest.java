package baseball.mvc.structure;

import static org.junit.jupiter.api.Assertions.*;

import baseball.util.ModelTestUtils;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ModelTest {

    private static final String TEST_KEY = "test";
    private static final String TEST_VALUE = "test";

    private Model model;

    @BeforeEach
    void beforeEach() {
        model = new Model();
    }

    @Nested
    @DisplayName("addAttribute 메소드는")
    class AddAttributeMethodTest {

        @Test
        @DisplayName("만약 저장할 데이터를 입력하면 Object 타입으로 데이터를 저장한다.")
        void success_test() {
            model.addAttribute(TEST_KEY, TEST_VALUE);

            Map<String, Object> modelDataMap = ModelTestUtils.getModelDataMap(model);

            Assertions.assertThat((String) modelDataMap.get(TEST_KEY)).isEqualTo(TEST_VALUE);
        }
    }

    @Nested
    @DisplayName("getAttribute 메소드는")
    class GetAttributeMethodTest {

        private static final String NONE_KEY = "none";

        @Test
        @DisplayName("만약 저장한 데이터의 key와 타입을 입력하면 해당 타입으로 데이터를 반환한다.")
        void success_test() {
            model.addAttribute(TEST_KEY, TEST_VALUE);

            String result = model.getAttribute(TEST_KEY, String.class);

            Assertions.assertThat(result).isEqualTo(TEST_VALUE);
        }

        @Test
        @DisplayName("만약 저장하지 않은 데이터의 key를 입력하면 null을 반환한다.")
        void null_test() {
            String result = model.getAttribute(NONE_KEY, String.class);

            Assertions.assertThat(result).isNull();
        }
    }

}