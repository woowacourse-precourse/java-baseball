package baseball.service;

import baseball.dao.ComputerNumber;
import baseball.dto.Number;
import baseball.vo.*;

public class GameService {
    public Boolean addComputerNumber(int number) {
        Number dto = Number.getInstance();

        return dto.insert(new ComputerNumber(number));
    }

    public Scoreboard compareComputerNumberWith(int number) {
        Number dto = Number.getInstance();
        ComputerNumber computerNumber = dto.latest();
        TwoNumbers numbers = new TwoNumbers(computerNumber.getNumber(), number);

        return numbers.compare();
    }
}