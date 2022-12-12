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

    public BaseballController(InputView inputView, OutputView outputView, BaseballService baseballService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.baseballService = baseballService;
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
            betting(numbersRequestDTO); // 따지자면 PRG 패턴 중 Post
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
        }
    }

    public void betting(NumbersRequestDTO numbersRequestDTO) {
        ResultResponseDTO resultResponseDTO = baseballService.bettingBall(numbersRequestDTO);
        outputView.printRoundResult(resultResponseDTO);
        if (resultResponseDTO.getSuccess() == Success.SUCCESS) {
            gameComplete(); // 이게 리다이렉트
        }
        if (resultResponseDTO.getSuccess() == Success.FAIL) {
            bettingForm(); // 이게 리다이렉트
        }
    }

    private void gameComplete() {
        outputView.printGameEnd();
    }
}
