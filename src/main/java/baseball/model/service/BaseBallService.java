package baseball.model.service;

import baseball.model.domain.BaseBall;
import baseball.model.repository.MemoryBaseBallRepository;

public class BaseBallService {

    private final MemoryBaseBallRepository baseBallRepository;

    public BaseBallService() {
        this.baseBallRepository = new MemoryBaseBallRepository();
    }

    public BaseBall create() {
        BaseBall baseBall = new BaseBall();

        baseBallRepository.save(baseBall);

        return baseBall;
    }

    public BaseBall match(Long id, String input) {
        BaseBall baseBall = baseBallRepository.findById(id);

        baseBall.match(input);

        return baseBall;
    }
}
