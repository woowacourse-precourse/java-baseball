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

    public String getNumbers(){
        return new String(numbers);
    }

}
