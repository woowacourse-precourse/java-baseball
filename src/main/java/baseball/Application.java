package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

    }

    public static class Validations{
        public void isCorrectInput(String inputNum) throws IllegalArgumentException{
            List<String> inputNumList = List.of(inputNum.split(""));
            if( !(isSizeThree(inputNumList) && isNumber(inputNumList)) && !inputNumList.isEmpty() ){
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

        public ArrayList<String> makeRandomAnswer(){
            List<Integer> answer = new ArrayList<>();
            while ( answer.size() < 3 ){
                int randomNumber = Randoms.pickNumberInRange(1,9) ;
                if ( !answer.contains(randomNumber) ){
                    answer.add(randomNumber);
                }
            }
            return (ArrayList<String>) answer.stream().map(Object::toString).collect(Collectors.toList());
        }

        public ArrayList<String> askInputNumber(){
//            String inputNum = Console.readLine();
            ArrayList<String> returnList = new ArrayList<>();
            String inputNum = "423";
            try{
                validations.isCorrectInput(inputNum);
                List<String> splitList = Arrays.asList(inputNum.split(""));
                returnList.addAll(splitList);
            }catch (IllegalArgumentException e){
                e.printStackTrace();
            }
            return returnList ;
        }

        public ArrayList<String> findContainedNumbers(ArrayList<String> answer, ArrayList<String> userNumList){
            for(int i = 0 ; i < 3 ; i++){
                String checkNum = userNumList.get(i);
                if(!answer.contains(checkNum)){
                    userNumList.set(i, "-1");
                }
            }
            return userNumList;
        }

        public int countContained(ArrayList<String> containedNumbers){
            return (int) containedNumbers.stream()
                    .filter(num -> num.matches("[0-9]"))
                    .count();
        }
        public int countStrike(ArrayList<String> answer, ArrayList<String> containedNumbers){
            return (int) containedNumbers.stream()
                    .filter(num->num.equals(answer.get(containedNumbers.indexOf(num))))
                    .count();
        }
        public int countBall(int countContained, int countStrike){
            return countContained - countStrike;
        }
    }
}
