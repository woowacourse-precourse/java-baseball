package baseball.component;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameController {



    private List<Integer> readPlayerNumbers(){
        System.out.print("숫자를 입력해주세요 : ");
        String playerInputString = Console.readLine();

        List<Integer> playerNumbers = new ArrayList<>();
        for(int index = 0; index < playerInputString.length(); index++){
            int number = Character.getNumericValue(playerInputString.charAt(index));
            playerNumbers.add(number);
        }

        return playerNumbers;
    }

    private List<Integer> generateThreeRandomNumbers(){
        List<Integer> randomNumbers = new ArrayList<>();
        while(randomNumbers.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }
}
