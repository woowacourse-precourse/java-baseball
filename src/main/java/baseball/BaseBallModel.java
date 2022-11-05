package baseball;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Map;

public class BaseBallModel {

    private Integer numberLength = null;
    private String numbers = "";


    public BaseBallModel(int numberLength){
        this.numberLength = numberLength;
    }

    public String generateNumbers(){
        numbers = "";
        while(numbers.length() < numberLength){
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if(!numbers.contains(Integer.toString(randomNumber))){
                numbers += randomNumber;
            }
        }

        return new String(numbers);
    }

    public void checkNumbers(String inputNumbers) throws IllegalArgumentException{
        if(inputNumbers.length() != this.numberLength){
            throw new IllegalArgumentException();
        }

        for(int i = 0; i < this.numberLength; i++){
            String cloneNumbers = new String(inputNumbers);

            if(cloneNumbers.replace(Character.toString(inputNumbers.charAt(i)), "").length() != this.numberLength-1){
                throw new IllegalArgumentException();
            }
        }
    }

    public Map<String, Integer> gameResult(String inputNumbers){
        Map<String, Integer> result = new HashMap<>();

        result.put("ball", getBall(inputNumbers));
        result.put("strike", getStrike(inputNumbers));

        return result;
    }

    private int getBall(String inputNumbers){
        int ballCount = 0;

        for(int i = 0; i < this.numberLength; i++){
            String tmpInputNumber = Character.toString(inputNumbers.charAt(i));
            if(this.numbers.contains(tmpInputNumber) && i != numbers.indexOf(tmpInputNumber)){
                ballCount += 1;
            }
        }

        return ballCount;
    }

    private int getStrike(String inputNumbers){
        int strikeCount = 0;

        for(int i = 0; i < this.numberLength; i++){
            if(this.numbers.indexOf(inputNumbers.charAt(i)) == i){
                strikeCount += 1;
            }
        }

        return strikeCount;
    }

    public boolean restartGame(int flag) throws IllegalArgumentException{
        if(flag == 1){
            generateNumbers();
            return true;
        }
        else if(flag == 2){
            return false;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public String getNumbers(){
        return new String(numbers);
    }

}
