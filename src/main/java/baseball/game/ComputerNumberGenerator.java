package baseball.game;

import baseball.data.GameData;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

/**
 * 랜덤 숫자 3개를 겹치지 않게 생성하는 클래스
 */
public class ComputerNumberGenerator {
    public List<Integer> generateComputerNumbers(){
        List<Integer> computer = new ArrayList<>(0);
        int randomNumber;

        while(computer.size() < GameData.GAME_SIZE){
            randomNumber = Randoms.pickNumberInRange(GameData.MINIMUM_NUMBER,
                GameData.MAXIMUM_NUMBER);
            if(!computer.contains(randomNumber)){ // 숫자가 겹치는지 검사
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
