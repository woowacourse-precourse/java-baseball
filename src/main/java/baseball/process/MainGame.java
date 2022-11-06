package baseball.process;

import baseball.setting.Setting;
import baseball.ui.OutputText;
import baseball.unit.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class MainGame {

    private final OutputText outputText;
    private final Setting setting;

    public MainGame(OutputText outputText, Setting setting){
        this.outputText = outputText;
        this.setting = setting;
    }

    public List<Integer> inputGuessNumber(){
        List<Integer> inputNumber = new ArrayList<>();

        outputText.inputNumber();
        String inputLine = readLine();
        if(!isRightInput(inputLine)){
            throw new IllegalArgumentException();
        }

        inputNumber.addAll(Arrays.asList(Integer.parseInt(String.valueOf(inputLine.split("")))));

        return inputNumber;
    }

    private boolean isRightInput(String inputNumber){
        List<Character> chars = new ArrayList<>();

        if(inputNumber.split("").length != setting.INPUT_NUMBER){
            return false;
        }

        if(inputNumber.matches("[^1-9]")){
            return false;
        }

        for(int i=0; i<inputNumber.length(); i++){
            char chr = inputNumber.charAt(i);
            if(chars.contains(chr)){
                return false;
            }
            chars.add(chr);
        }

        return true;
    }

    public boolean judge(int countStrike, int countBall){
        boolean correct = false;

        if(countStrike == 0 && countBall == 0){
            outputText.nothing();
        }

        if(countStrike > 0 && countBall > 0){
            if(countStrike == Setting.INPUT_NUMBER) {
                outputText.strike(countStrike);
                correct = true;
            }
            else {
                outputText.strikeAndBall(countStrike, countBall);
            }
        }

        if(countStrike > 0 && countBall == 0){
            outputText.strike(countStrike);
        }
        if(countStrike == 0 && countBall > 0){
            outputText.ball(countBall);
        }
        return correct;
    }

}

