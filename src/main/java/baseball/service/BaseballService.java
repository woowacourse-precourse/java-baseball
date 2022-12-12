package baseball.service;

import baseball.dto.Hints;
import baseball.dto.NumbersRequestDTO;
import baseball.dto.ResultResponseDTO;
import baseball.model.*;
import baseball.model.User;

public class BaseballService {

    private Computer computer;
    private User user;

    public void turnOnGame() {
        computer = new Computer();
        user = new User();
    }

    public void startNewGame() {
        computer.pickRandomNumbers();
    }

    public ResultResponseDTO bettingBall(NumbersRequestDTO numbersRequestDTO) {
        user.updateNumbers(numbersRequestDTO.getInputNumber());
        Hints hints = computer.drawUserNumbers(user);
        return new ResultResponseDTO(hints, Success.getSuccess(hints));
    }

}
