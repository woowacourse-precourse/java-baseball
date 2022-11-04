package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

    }

    public static class Validations{


    }
    public static class Processing {
        private final Validations validations = new Validations();

        public List<String> makeRandomAnswer(){
            List<Integer> answer = new ArrayList<>();
            while ( answer.size() < 3 ){
                int randomNumber = Randoms.pickNumberInRange(1,9) ;
                if ( !answer.contains(randomNumber) ){
                    answer.add(randomNumber);
                }
            }
            return answer.stream().map(Object::toString).collect(Collectors.toList());
        }

        public List<String> askInputNumber(){
            String inputNum = Console.readLine();
            return Arrays.asList(inputNum.split(""));
        }
    }
}
