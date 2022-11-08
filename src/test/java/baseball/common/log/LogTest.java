package baseball.common.log;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class LogTest {

    @Test
    void getLogger_함수로_동일한_인스턴스_반환() {
        List<Log> logList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(() -> {
                logList.add(Log.getLogger());
            });

            thread.start();
        }

        while (logList.size() < 100) {

        }
        
        Log log = logList.get(0);

        long sameCount = logList.stream()
                .filter(i -> i == log)
                .count();

        assertThat(sameCount).isEqualTo(logList.size());
    }
}