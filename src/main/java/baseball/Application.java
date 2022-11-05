package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        // TODO: 프로그램 구현
        Application.Processing processing = new Application.Processing();
        processing.printStartMessage();
        do{
            ArrayList<String> answer = processing.makeRandomAnswer();
            processing.startGame(answer);
        }
        while(processing.askContinue());

    }

    public static class Validations{
        public void isCorrectInput(String inputNum){
            List<String> inputNumList = List.of(inputNum.split(""));
            if(!(isSizeThree(inputNumList) && isNumber(inputNumList)) && !inputNumList.isEmpty()){
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

        public void startGame(ArrayList<String> answer) throws IllegalArgumentException{
            boolean flag = false ;
            while (!flag){
                ArrayList<String> playerInput = askInputNumber();
                if(validations.checkIsItNothing(answer, playerInput)){
                    printNothing();
                }else{
                    playerInput = findContainedNumbers(answer, playerInput);
                    Map<String, Object> resultMap = calculateStrikeAndBall(answer, playerInput);
                    printBall((int)resultMap.get("ballCount"));
                    printStrike((int)resultMap.get("strikeCount"));
                    flag = (boolean)resultMap.get("isStrikeThree");
                }
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }

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

        public ArrayList<String> askInputNumber() {
            System.out.print("숫자를 입력해주세요 : ");
            String inputNum = Console.readLine();

            validations.isCorrectInput(inputNum);

            return new ArrayList<>(Arrays.asList(inputNum.split("")));
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

        public boolean askContinue() {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String inputNum = Console.readLine();
            if (inputNum.contentEquals("1")){
                return true;
            }else if(inputNum.contentEquals("2")){
                return false;
            }else{
                throw new IllegalArgumentException();
            }
        }
    }
}
