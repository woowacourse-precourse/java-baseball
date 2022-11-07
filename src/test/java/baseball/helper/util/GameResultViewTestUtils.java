package baseball.helper.util;

import baseball.domain.game.GameResult;
import baseball.helper.exception.CannotReflectionException;
import baseball.mvc.view.GameResultView;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;

public final class GameResultViewTestUtils {

    private static final String MESSAGE_FIELD_NAME = "message";

    private GameResultViewTestUtils() {
    }

    public static String getMessage(GameResultView view, GameResult gameResult, ByteArrayOutputStream out) {
        out.reset();

        Field message = ReflectionFieldUtils.processReflectionField(GameResultView.class, MESSAGE_FIELD_NAME);

        try {
            String format;

            if (gameResult.isOnlyBall()) {
                format = String.format((String) message.get(view), gameResult.getBall());
            } else if (gameResult.isOnlyStrike()) {
                format = String.format((String) message.get(view), gameResult.getStrike());
            } else {
                format = String.format((String) message.get(view), gameResult.getBall(), gameResult.getStrike());
            }
            System.out.println(format);
            return out.toString();
        } catch (Exception e) {
            throw new CannotReflectionException(e);
        }
    }
}
