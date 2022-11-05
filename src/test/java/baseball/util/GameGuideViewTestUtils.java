package baseball.util;

import baseball.mvc.view.GameGuideView;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;

public final class GameGuideViewTestUtils {

    private static final String MESSAGE_FIELD_NAME = "message";

    private GameGuideViewTestUtils() {
    }

    public static String getMessage(GameGuideView view, ByteArrayOutputStream out) {
        try {
            out.reset();

            final Field enumMessage = view.getClass().getDeclaredField(MESSAGE_FIELD_NAME);
            enumMessage.setAccessible(true);

            System.out.println((String) enumMessage.get(view));
            return out.toString();
        } catch (Exception e) {
            return "";
        }
    }
}

