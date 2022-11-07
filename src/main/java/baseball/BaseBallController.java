package baseball;

import java.util.Map;

public class BaseBallController {

    private BaseBallModel baseBallModel = null;

    public BaseBallController(int numbersLength){
        baseBallModel = new BaseBallModel(numbersLength);
    }

    public void startGame(){
        baseBallModel.generateNumbers();
    }

    public Map<String, Integer> playGame(String inputNumbers) throws IllegalArgumentException{
        try{
            baseBallModel.checkNumbers(inputNumbers);
        }
        catch(IllegalArgumentException ex){
            throw ex;
        }

        Map<String, Integer> result = baseBallModel.gameResult(inputNumbers);

        return result;
    }

    public boolean restartGame(int flag) throws IllegalArgumentException{
        boolean result;
        try {
            result = baseBallModel.restartGame(flag);
        }
        catch(IllegalArgumentException ex){
            throw ex;
        }

        return result;
    }

}
