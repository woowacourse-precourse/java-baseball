package baseball.domain.game.baseball;

import baseball.domain.GameCreator;
import baseball.view.BaseBallInput;
import baseball.view.UserInput;

import java.io.IOException;

public class ConcreteCreatorBaseBall extends GameCreator {
    @Override
    public void createGame() throws IOException {
        CreateBaseBall game = new CreateBaseBall();
        UserInput userInput = new BaseBallInput();
        String input = "";
        System.out.println("숫자 야구 게임을 시작합니다.");
        String randomNumber = game.generateRandomNumber();
        do {
            System.out.print("숫자를 입력해주세요 : ");
            input = userInput.getInput();
            game.startGame(randomNumber, input);
        } while (!input.equals(randomNumber));
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        }
    public void startGame() throws IOException {
        createGame();
        CreateBaseBall game = new CreateBaseBall();
        if (!game.endGame()){
            startGame();
        }
        System.out.println("게임 종료");
    }
}
