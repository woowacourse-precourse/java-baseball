package baseball;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseBallModel {

    private Integer numberLength = null;
    private String numbers = "";


    public BaseBallModel(int numberLength){
        this.numberLength = numberLength;
    }

    public String generateNumbers(){
        while(numbers.length() < numberLength){
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if(!numbers.contains(Integer.toString(randomNumber))){
                numbers += randomNumber;
            }
        }

        return new String(numbers);
    }

    public boolean checkNumbers(String inputNumbers){
        if(inputNumbers.length() != this.numberLength){
            throw new IllegalArgumentException();
        }

        for(int i = 0; i < this.numberLength; i++){
            String cloneNumbers = new String(inputNumbers);

            if(cloneNumbers.replace(Character.toString(inputNumbers.charAt(i)), "").length() != this.numberLength-1){
                return false;
            }
        }

        return true;
    }

    public String getNumbers(){
        return new String(numbers);
    }

}
