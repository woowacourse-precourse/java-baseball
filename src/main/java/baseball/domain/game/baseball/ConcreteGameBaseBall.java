package baseball.domain.game.baseball;

import baseball.domain.Game;
import baseball.domain.GameCreator;
import baseball.view.BaseBallInput;
import camp.nextstep.edu.missionutils.Randoms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConcreteGameBaseBall extends GameCreator {

    @Override
    public Game createGame() throws IOException {
        BaseBallInput baseBallInput = new BaseBallInput();
        baseBallInput.getInput();
        return null;
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
