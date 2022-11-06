package baseball.process;

import java.util.List;

public class CompareNumber {

    private final List<Integer> computerNumber;

    private final List<Integer> inputNumber;


    public CompareNumber(List<Integer> computerNumber, List<Integer> inputNumber) {
        this.computerNumber = computerNumber;
        this.inputNumber = inputNumber;
    }

    public int countStrike(){
        int countStrike = 0;

        for(int i=0; i<inputNumber.size(); i++){
            if(computerNumber.get(i) == inputNumber.get(i)){
                countStrike++;
            }
        }

        return countStrike;
    }

    public int countBall(){
        int countBall = 0;

        for(int i=0; i<inputNumber.size(); i++){
            if(computerNumber.contains(inputNumber.get(i))){
                countBall++;
            }
        }

        return 0;
    }

}
