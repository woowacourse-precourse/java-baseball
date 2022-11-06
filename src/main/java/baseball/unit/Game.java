package baseball.unit;

import baseball.setting.Setting;
import baseball.ui.OutputText;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {

    private final List<Integer> computerNumber;

    private final List<Integer> inputNumber;

    private int countStrike;

    private int countBall;


    public Game(List<Integer> computerNumber) {
        this.computerNumber = computerNumber;
        this.inputNumber = new ArrayList<>();
        this.countStrike = 0;
        this.countBall= 0;
    }

    public void inputGuessNumber(){
        String inputLine = new String();

        OutputText.printInputNumber();

        inputLine = readLine();
        if (!isRightInput(inputLine)) {
            throw new IllegalArgumentException();
        }

        for(String str : inputLine.split("")){
            this.inputNumber.add(Integer.parseInt(str));
        }
        calculate();
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

    private void calculate(){
        for(int i=0; i<inputNumber.size(); i++){
            if(computerNumber.get(i) == inputNumber.get(i)){
                countStrike++;
            }
            else if(computerNumber.contains(inputNumber.get(i))){
                countBall++;
            }
        }
    }

    public boolean isAllStrike(){
        boolean correct = false;

        if(countStrike == 0 && countBall == 0){
            OutputText.printJudgeNothing();
        }

        if(countStrike > 0 && countBall > 0){
            OutputText.printJudgeStrikeAndBall(countStrike, countBall);
        }

        if(countStrike > 0 && countBall == 0){
            OutputText.printJudgeStrike(countStrike);
            if(countStrike == Setting.INPUT_NUMBER) {
                OutputText.printEndGame();
                correct = true;
            }
        }
        if(countStrike == 0 && countBall > 0){
            OutputText.printJudgeBall(countBall);
        }
        return correct;
    }





}
