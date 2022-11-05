package baseball.common.log;

import java.util.Arrays;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class Log {

    private static class LogInstanceHolder {
        private static final Log INSTANCE = new Log();
    }

    private final Logger log = Logger.getLogger(Log.class.getName());

    private Log() {
        log.setUseParentHandlers(false);
        Handler handler = new ConsoleHandler();
        handler.setFormatter(new LogFormatter());
        log.addHandler(handler);
    }

    public static Log getLogger() {
        return LogInstanceHolder.INSTANCE;
    }


    public void warn(Throwable e, String msg) {
        log.warning(msg);
        log.warning(Arrays.toString(e.getStackTrace()));
    }


}
