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
    public void startGame() throws IOException {
        UserInput userInput = getUserInputInput();
        String input = userInput.getInput();
        String randomNumber = generateRandomNumber();
        Refree refree = new Refree();
        refree.compareToUserInput(randomNumber, input);
    }

    public UserInput getUserInputInput(){
        UserInput input = new BaseBallInput();
        return input;
    }

    @Override
    public void endGame() {

    }

    @Override
    public void validate(String input) {
        Validator.validate(input);
    }

    String generateRandomNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return translateIntegerToString(computer);
    }

    private String translateIntegerToString(List<Integer> number){
        StringBuilder bld = new StringBuilder();
        for(Integer s : number){
            bld.append(String.valueOf(s));
        }
        return bld.toString();
    }
}
