package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.Collectors;

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

        public boolean checkIsItNothing(ArrayList<String> answer, ArrayList<String> userNumList){
            for (String num : userNumList){
                if(answer.contains(num)){
                    return false;
                }
            }
            return true ;
        }

        public boolean isStrikeThree(int strikeCount){
            return strikeCount == 3;
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

        public Map<String, Object> calculateStrikeAndBall(ArrayList<String> answer, ArrayList<String> containedNumList){
            Map<String,Object> resultMap = new HashMap<>();
            int containedNumCnt = countContained(containedNumList);
            int strikeCnt = countStrike(answer, containedNumList);
            int ballCnt = countBall(containedNumCnt, strikeCnt);
            resultMap.put("strikeCount", strikeCnt);
            resultMap.put("ballCount", ballCnt);
            resultMap.put("isStrikeThree", validations.isStrikeThree(strikeCnt));
            return  resultMap;
        }

        public void printStartMessage(){
            System.out.println("숫자 야구 게임을 시작합니다.");
        }

        public void printNothing(){
            System.out.println("낫싱");
        }

        public void printStrike(int strikeCount){
            if(strikeCount==0){
                System.out.println();
            }else {
                System.out.printf("%d스트라이크\n", strikeCount);
            }
        }
        public void printBall(int ballCount){
            if(ballCount!=0) {
                System.out.printf("%d볼 ", ballCount);
            }
        }

    }
}
