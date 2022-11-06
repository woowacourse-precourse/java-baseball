package baseball.game.service;

import baseball.game.domain.Computer;
import baseball.utils.RandomUtils;

public class GameService {
    private Computer computer;

    public GameService(){
        computer=new Computer();
    }
    public void computeComputerNumbers() {
        computer.setNumberList(RandomUtils.getRandomNumberList());
    }
}
