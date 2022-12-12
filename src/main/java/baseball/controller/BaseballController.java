package baseball.controller;

import baseball.dto.NumbersRequestDTO;
import baseball.dto.ResultResponseDTO;
import baseball.model.Success;
import baseball.service.BaseballService;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.function.Supplier;

public class BaseballController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BaseballService baseballService;

    public BaseballController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.baseballService = new BaseballService();
    }

    public void turnOn() {
        baseballService.turnOnGame();
        outputView.printGameStart();
    }
    
    public void newGame() {
        baseballService.startNewGame();
    }

    public void bettingForm() {
        try {
            outputView.printRoundStart();
            int inputNumbers = inputView.readInt();
            NumbersRequestDTO numbersRequestDTO = new NumbersRequestDTO(inputNumbers);
            betting(numbersRequestDTO); // 따지자면 리다이렉트?
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
        }
    }

    public void betting(NumbersRequestDTO numbersRequestDTO) {
        ResultResponseDTO resultResponseDTO = baseballService.bettingBall(numbersRequestDTO);
        outputView.printRoundResult(resultResponseDTO);
        if (resultResponseDTO.getSuccess() == Success.SUCCESS) {
            gameComplete();
        }
        if (resultResponseDTO.getSuccess() == Success.FAIL) {
            bettingForm();
        }
    }

    private void gameComplete() {
        outputView.printGameEnd();
    }
}
