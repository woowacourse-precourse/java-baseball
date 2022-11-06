package baseball.process;

import baseball.setting.Setting;
import baseball.ui.OutputText;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class EndGame {

    public boolean continueGame(){
        String line = readLine();
        int end = 0;
        try{
            end = Integer.parseInt(line);
            if(end == Setting.START_GAME)
                return true;

            if(end == Setting.END_GAME)
                return false;

        }catch (Exception e){
            throw new IllegalArgumentException();
        }


        throw new IllegalArgumentException();
    }




}
