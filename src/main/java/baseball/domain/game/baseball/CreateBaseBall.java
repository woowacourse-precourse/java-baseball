package baseball.domain.game.baseball;

import baseball.domain.Game;
import baseball.domain.Validator;
import baseball.refree.Refree;
import baseball.view.BaseBallInput;
import baseball.view.UserInput;
import camp.nextstep.edu.missionutils.Randoms;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateBaseBall implements Game {

    @Override
    public void startGame(String randomNumber, String input) throws IOException {
        Refree.compareToUserInput(randomNumber, input);
    }

    public UserInput getUserInputInput() {
        return new BaseBallInput();
    }

    @Override
    public boolean endGame() throws IOException {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int endGameInput = getUserInputInput().getEndGameInput();
        return (endGameInput == 2) ? true:false;
    }

    @Override
    public void validate(String input) {
        Validator.validate(input);
    }

    public String generateRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return translateIntegerToString(computer);
    }

    private String translateIntegerToString(List<Integer> number) {
        StringBuilder bld = new StringBuilder();
        for (Integer s : number) {
            bld.append(String.valueOf(s));
        }
        return bld.toString();
    }
}
