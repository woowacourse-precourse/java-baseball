package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class AnswerNumber {
    private List<Integer> answerNumberList;

    public AnswerNumber(){
        answerNumber = new ArrayList<>();
    }

    public List<String> saveAnswerNumber(){
        return saveAnswerNumber;
    }

    public void RandomNumber(){
        HashSet<Integer> numbers = new LinkedHashSet<>();
        while (numbers.size() < Game.BALLSIZE){
            int num = Randoms.pickNumberInRange(1,9);
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
