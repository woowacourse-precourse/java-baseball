package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Collections;
public class Application {
    public static void main(String[] args) {
        startNumberBaseballGame();
    }

    static List<Integer> answerRandomNumber = new ArrayList<>();
    static void startNumberBaseballGame(){
        getAnswerRandomNumber();
        System.out.println("랜덤 숫자 부여 = " + answerRandomNumber);
        String answer = "";
        String oneOrTwo = "";
        // 게임 시작
        System.out.println("숫자 야구 게임을 시작합니다");
        while(true){
            System.out.print("숫자를 입력해주세요 : ");
            answer = getAnswerCheckMessage(answerRandomNumber, getListByInputNumber(Console.readLine()));
            System.out.println(answer);
            if(!inputNumberIsAnswer(answer)) {
                break;
            }
        }
    }
    static List<Integer> getAnswerRandomNumber(){
        // 랜덤 3자리 숫자 생성
        while(answerRandomNumber.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!answerRandomNumber.contains(randomNumber)){
                answerRandomNumber.add(randomNumber);
            }
            else{
                System.out.println("랜덤숫자 중복됨. 다시 부여.");
            }
        }
        return answerRandomNumber;
    }
    static Integer stringToInteger(String input){
        try{
            Integer answer = Integer.parseInt(input);
            return answer;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    static List<Integer> getListByInputNumber (String inputNumber){

        String number = inputNumber;

        Integer inputNumberStringToInteger = stringToInteger(number);

        List<Integer> listByInputNumber = new ArrayList<>();

        while(inputNumberStringToInteger!=0){
            if(listByInputNumber.contains(inputNumberStringToInteger%10)){
                throw new IllegalArgumentException();
            } else {
                listByInputNumber.add(inputNumberStringToInteger%10);
                inputNumberStringToInteger = inputNumberStringToInteger/10;
            }
        }

        if(listByInputNumber.size() != 3){
            throw new IllegalArgumentException();
        }

        Collections.reverse(listByInputNumber);

        System.out.println("입력 숫자 = "+listByInputNumber);

        return listByInputNumber;
    }

    static HashMap getNumberAndIndexByList(List<Integer> answerList){
        HashMap<Integer,Integer> indexAndNumber = new HashMap<>();
        for(int answer=0;answer<answerList.size();answer++){
            indexAndNumber.put(answerList.get(answer), answer);
        }
        return indexAndNumber;
    }

    static boolean inputNumberIsAnswer(String inputNumber){

        boolean answer = false;

        if(inputNumber.equals("3스트라이크")){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String restartOrEnd = Console.readLine();
            if(restartOrEnd.equals("1")){
                answerRandomNumber.clear();
                getAnswerRandomNumber();
                restartOrEnd = "";
                System.out.println("랜덤 숫자 부여 = " + answerRandomNumber);
                answer = true;
            } else if (restartOrEnd.equals("2")) {
                answer = false;
            } else {
                throw new IllegalArgumentException();
            }

        } else answer = true;

        return answer;
    }

    static String getAnswerCheckMessage(List<Integer> computerAnswer, List<Integer> myAnswer){

        String ballMessage = "볼";
        String strikeMessage = "스트라이크";
        String totalMessage = "";

        HashMap<Integer,Integer> indexAndNumber = getNumberAndIndexByList(myAnswer);
        computerAnswer = answerRandomNumber;

        int ballCount = 0;
        int strikeCount = 0;

        for(int com=0;com<computerAnswer.size();com++){
            if(indexAndNumber.get(computerAnswer.get(com)) == null){
                continue;
            } else if(indexAndNumber.get(computerAnswer.get(com)) != null && indexAndNumber.get(computerAnswer.get(com)) == com){
                strikeCount++;
            } else if (indexAndNumber.get(computerAnswer.get(com)) != null && indexAndNumber.get(computerAnswer.get(com)) != com) {
                ballCount++;
            }
        }

        if(ballCount == 0 && strikeCount == 0){
            totalMessage += "낫싱";
        }
        else {
            if (ballCount==0){
                totalMessage += strikeCount+strikeMessage;
            } else if (strikeCount==0) {
                totalMessage += ballCount+ballMessage;
            } else if (ballCount !=0 && strikeCount != 0) {
                totalMessage += ballCount+ballMessage+" "+strikeCount+strikeMessage;
            }
        }


        return totalMessage;
    }
}
