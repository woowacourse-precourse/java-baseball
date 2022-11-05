package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

    }

    public static class Validations{
        public void isCorrectInput(String inputNum) throws IllegalArgumentException{
            List<String> inputNumList = List.of(inputNum.split(""));
            if( !(isSizeThree(inputNumList) && isNumber(inputNumList)) ){
                throw new IllegalArgumentException();
            }
        }

        private boolean isSizeThree(List<String> inputNumList) {
            return inputNumList.size() == 3;
        }
        private boolean isNumber(List<String> inputNumList) {
            long numFilter = inputNumList.stream().filter(s -> s.matches("[0-9]")).count();

            return numFilter == 3 ;
        }

        public boolean checkIsItNothing(List<String> answer, List<String> userNumList){
            for (String num : userNumList){
                if(answer.contains(num)){
                    return false;
                }
            }
            return true ;
        }


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
//            String inputNum = Console.readLine();
            String inputNum = "423";
            try{
                validations.isCorrectInput(inputNum);
            }catch (IllegalArgumentException e){
                e.printStackTrace();
            }
            return Arrays.asList(inputNum.split(""));
        }

        public List<String> findContainedNumbers(List<String> answer, List<String> userNumList){
            for(int i = 0 ; i < 3 ; i++){
                String checkNum = userNumList.get(i);
                if(!answer.contains(checkNum)){
                    userNumList.set(i, null);
                }
            }
            return userNumList;
        }

        public int countContained(List<String> containedNumbers){
            return (int) containedNumbers.stream()
                    .filter(Objects::nonNull)
                    .count();
        }
        public int countStrike(List<String> answer, List<String> containedNumbers){
            return (int) containedNumbers.stream()
                    .filter(num->num.equals(answer.get(containedNumbers.indexOf(num))))
                    .count();
        }
        public int countBall(int countContained, int countStrike){
            return countContained - countStrike;
        }
    }
}
