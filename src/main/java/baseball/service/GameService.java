package baseball.service;

import baseball.dao.ComputerNumber;
import baseball.dto.Number;
import baseball.vo.Scoreboard;

public class GameService {
    public Boolean addComputerNumber(int number) {
        Number dto = Number.getInstance();

        return dto.insert(new ComputerNumber(number));
    }

    public Scoreboard compareComputerNumberWith(int number) {
        return new Scoreboard();
    }
}