package baseball.util;

import baseball.mvc.view.GameInputView;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.util.function.Consumer;

public final class GameInputViewTestUtils {

    private static final String MESSAGE_FIELD_NAME = "message";

    private GameInputViewTestUtils() {
    }

    public static String getMessage(GameInputView view, Consumer<String> printLog, ByteArrayOutputStream out) {
        try {
            out.reset();

            final Field enumMessage = view.getClass().getDeclaredField(MESSAGE_FIELD_NAME);
            enumMessage.setAccessible(true);

            printLog.accept((String) enumMessage.get(view));
            return out.toString();
        } catch (Exception e) {
            return "";
        }
    }
}
