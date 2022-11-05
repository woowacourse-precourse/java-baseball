package baseball.viewer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BaseballViewerTest {

    private final BaseballViewer viewer = new BaseballViewer();

    @Test
    void getMessage_함수로_지정된_메세지_가져오기() {
        BaseballView view = BaseballView.messagebuilder()
                .announcement(BaseballTextType.WELCOME_MESSAGE)
                .build();

        String result = viewer.getMessage(view);
        assertThat(result).isEqualTo(BaseballTextType.WELCOME_MESSAGE.getText());
    }

    @Test
    void getMessage_함수로_볼_메세지_가져오기() {
        BaseballView view = BaseballView.messagebuilder()
                .ball(2)
                .build();

        String result = viewer.getMessage(view);
        assertThat(result).isEqualTo("2" + BaseballTextType.BALL.getText());
    }

    @Test
    void getMessage_함수로_스트라이크_메세지_가져오기() {
        BaseballView view = BaseballView.messagebuilder()
                .strike(2)
                .build();

        String result = viewer.getMessage(view);
        assertThat(result).isEqualTo("2" + BaseballTextType.STRIKE.getText());
    }

    @Test
    void getMessage_함수에_빈_입력시_낫싱_메세지_반환() {
        BaseballView emptyView = BaseballView.messagebuilder()
                .build();

        String emptyResult = viewer.getMessage(emptyView);
        assertThat(emptyResult).isEqualTo(BaseballTextType.NOTHING.getText());
    }

    @Test
    void getMessage_함수에_0볼_0스크라이크_입력시_낫싱_메세지_반환() {
        BaseballView zeroView = BaseballView.messagebuilder()
                .ball(0)
                .strike(0)
                .build();

        String zeroResult = viewer.getMessage(zeroView);
        assertThat(zeroResult).isEqualTo(BaseballTextType.NOTHING.getText());
    }
}