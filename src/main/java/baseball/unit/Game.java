package baseball.unit;

import baseball.setting.Setting;
import baseball.ui.OutputText;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {

    private final List<Integer> computerNumber;

    public Game(List<Integer> computerNumber) {
        this.computerNumber = computerNumber;
    }


    public boolean playAndIsNotStrike(){
        int countStrike = 0;
        int countBall = 0;

        List<Integer> counts = calculate(inputGuessNumber());
        countStrike = counts.get(0);
        countBall = counts.get(1);

        return isNotStrike(countStrike, countBall);
    }

    private List<Integer> inputGuessNumber(){
        List<Integer> inputNumber = new ArrayList<>();
        OutputText.printInputNumber();

        String inputLine = readLine();
        if (!isRightInput(inputLine)) {
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

    private List<Integer> calculate(List<Integer> inputNumber){
        List<Integer> res = new ArrayList<>();
        int countStrike = 0;
        int countBall = 0;

        for(int i=0; i<inputNumber.size(); i++){
            int cNum = computerNumber.get(i);
            int iNum = inputNumber.get(i);

            if(cNum == iNum){
                countStrike++;
            }
            else if(computerNumber.contains(iNum)){
                countBall++;
            }
        }
        res.add(countStrike);
        res.add(countBall);

        return res;
    }

    private boolean isNotStrike(int countStrike, int countBall){
        if(countStrike > 0 && countBall == 0){
            OutputText.printJudgeStrike(countStrike);
            if(countStrike == Setting.INPUT_NUMBER) {
                OutputText.printEndGame();
                return false;
            }
        }

        if(countStrike == 0 && countBall == 0){
            OutputText.printJudgeNothing();
        }

        if(countStrike > 0 && countBall > 0){
            OutputText.printJudgeStrikeAndBall(countStrike, countBall);
        }


        if(countStrike == 0 && countBall > 0){
            OutputText.printJudgeBall(countBall);
        }
        return true;
    }

}
