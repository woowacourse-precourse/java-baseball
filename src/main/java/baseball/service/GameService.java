package baseball.service;

import baseball.domain.Computer;
import baseball.dto.ScoreDTO;

import java.util.List;

public class GameService {

    private Computer computer;

    public GameService() {
        this.computer = new Computer();
    }

    public ScoreDTO calculate(String input, Boolean type) {

        if (type == true)
            this.computer = new Computer();

        List<Integer> randomNumbers = computer.getRandomNumbers();

        ScoreDTO scoreDTO = new ScoreDTO();
        for (int i=0; i<input.length(); i++) {
            int nowIndex = randomNumbers.indexOf(input.charAt(i) - '0');

            if (nowIndex == -1)
                continue;

            if (nowIndex == i)
                scoreDTO.plusStrikeCount();
            else
                scoreDTO.plusBallCount();
        }
        return scoreDTO;
    }
}
