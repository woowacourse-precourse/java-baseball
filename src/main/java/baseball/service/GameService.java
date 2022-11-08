package baseball.service;

import baseball.dao.ComputerNumber;
import baseball.dto.Number;
import baseball.vo.*;

import java.util.List;
import java.util.stream.Collectors;

public class GameService {
    public Boolean addComputerNumber(int number) {
        Number dto = Number.getInstance();

        return dto.insert(new ComputerNumber(number));
    }

    public Boolean deleteComputerNumber(int number) {
        Number dto = Number.getInstance();
        List<ComputerNumber> computerNumbers = dto.findByNumber(number);

        return dto.deleteAll(computerNumbers);
    }

    public Scoreboard compareComputerNumberWith(int number) {
        Number dto = Number.getInstance();
        ComputerNumber computerNumber = dto.getOldest();
        TwoNumbers numbers = new TwoNumbers(computerNumber.getNumber(), number);

        return numbers.compare();
    }
}