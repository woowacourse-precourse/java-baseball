package baseball.util;

import baseball.domain.game.GameResult;
import baseball.mvc.view.GameResultView;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;

public final class GameResultViewTestUtils {

    private static final String MESSAGE_FIELD_NAME = "message";

    private GameResultViewTestUtils() {
    }

    public static String getMessage(GameResultView view, GameResult gameResult, ByteArrayOutputStream out) {
        try {
            out.reset();

            final Field enumMessage = view.getClass().getDeclaredField(MESSAGE_FIELD_NAME);
            enumMessage.setAccessible(true);

            String format;

            if (gameResult.isOnlyBall()) {
                format = String.format((String) enumMessage.get(view), gameResult.getBall());
            } else if (gameResult.isOnlyStrike()) {
                format = String.format((String) enumMessage.get(view), gameResult.getStrike());
            } else {
                format = String.format((String) enumMessage.get(view), gameResult.getBall(), gameResult.getStrike());
            }

            System.out.println(format);
            return out.toString();
        } catch (Exception e) {
            return "";
        }
    }
}
