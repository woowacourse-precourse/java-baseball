package baseball.game;

import baseball.data.GameData;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumberGenerator {
    public List<Integer> generateComputerNumbers(){
        List<Integer> computer = new ArrayList<>(0);
        int randomNumber;

        while(computer.size() < GameData.GAME_SIZE){
            randomNumber = Randoms.pickNumberInRange(GameData.MINIMUM_NUMBER, GameData.MAXIMUM_NUMBER);
            if(!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
