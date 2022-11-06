package baseball.process;

import baseball.setting.Setting;
import baseball.ui.OutputText;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class EndGame {

    private final OutputText outputText;

    public EndGame(OutputText outputText){
        this.outputText = outputText;

        outputText.endGame();
    }

    public boolean continueGame(){
        String end = readLine();
        if(end == Setting.START_GAME){
            return true;
        }
        if(end == Setting.END_GAME){
            return false;
        }

        throw new IllegalArgumentException();
    }




}
