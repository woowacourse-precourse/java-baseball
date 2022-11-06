package baseball.process;

import baseball.setting.Setting;
import baseball.ui.OutputText;
import baseball.unit.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class MainGame {

    public List<Integer> inputGuessNumber(){
        List<Integer> inputNumber = new ArrayList<>();

        OutputText.printInputNumber();
        String inputLine = readLine();
        if(!isRightInput(inputLine)){
            throw new IllegalArgumentException();
        }

        for(String str : inputLine.split("")){
            inputNumber.add(Integer.parseInt(str));
        }

        return inputNumber;
    }

    private boolean isRightInput(String inputNumber){
        List<Character> chars = new ArrayList<>();

        if(inputNumber.split("").length != Setting.INPUT_NUMBER){
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
            OutputText.printJudgeNothing();
        }

        if(countStrike > 0 && countBall > 0){
            OutputText.printJudgeStrikeAndBall(countStrike, countBall);
        }

        if(countStrike > 0 && countBall == 0){
            if(countStrike == Setting.INPUT_NUMBER) {
                OutputText.printJudgeStrike(countStrike);
                correct = true;
            }
            else {
                OutputText.printJudgeStrike(countStrike);
            }
        }
        if(countStrike == 0 && countBall > 0){
            OutputText.printJudgeBall(countBall);
        }
        return correct;
    }

}

