package baseball.unit;

import baseball.setting.Setting;
import baseball.ui.OutputText;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class ControlGame {
    public List<Integer> createComputerNumber(){
        List<Integer> computerNumber = new ArrayList<>();
        OutputText.printStartGame();

        while (computerNumber.size() < Setting.INPUT_NUMBER) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }

        return computerNumber;
    }

    public boolean stopGame(){
        String line = readLine();
        int end = 0;
        try{
            end = Integer.parseInt(line);
            if(end == Setting.START_GAME) {
                return false;
            }

            if(end == Setting.END_GAME)
                return true;

        }catch (Exception e){
            throw new IllegalArgumentException();
        }

        throw new IllegalArgumentException();
    }
}
