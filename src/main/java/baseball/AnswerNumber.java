package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class AnswerNumber {
    private List<String> answerNumber;
    private List<String> saveAnswerNumber = new ArrayList<>();

    public AnswerNumber(){
        answerNumber = new ArrayList<>();
    }

    public List<String> saveAnswerNumber(){
        return saveAnswerNumber;
    }

    public void RandomNumber(){
        HashSet<String> numbers = new HashSet<>();
        while (numbers.size() < 4){
            String num = String.valueOf(pickNumberInRange(1,9));
            numbers.add(num);
            if(restartNumberValidator()){
                numbers.clear();
            }
        }
    }

    public boolean restartNumberValidator(){
        String numbers = answerNumberList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
        return saveAnswerNumber.contains(numbers);
    }
}
