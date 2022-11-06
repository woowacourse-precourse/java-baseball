package baseball.model.repository;

import baseball.model.domain.BaseBall;

import java.util.HashMap;
import java.util.Map;

public class MemoryBaseBallRepository {

    private static Map<Long, BaseBall> baseBallStore = new HashMap<>();
    private static long sequence = 0L;

    public BaseBall save(BaseBall baseBall) {
        baseBall.setId(++sequence);
        baseBallStore.put(baseBall.getId(), baseBall);

        return baseBall;
    }

    public BaseBall findById(Long id) {
        return baseBallStore.get(id);
    }
}
