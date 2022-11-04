package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Application {
    public List<Integer> userInputToList(Integer userInput){
        List userInputList = new ArrayList<>();
        while(userInput > 0){
            userInputList.add(userInput%10);
            userInput /= 10;
        }
        Collections.reverse(userInputList);
        return userInputList;
    }

    public static void checkUserInput(Object userInput){
        try{
            Class userInputClass = userInput.getClass();
            if(userInputClass != Integer.class){
                throw new IllegalArgumentException();
            }

            Integer userInputInteger = Integer.valueOf((int)userInput);
            Set userInputSet = new HashSet(userInputToList(userInputInteger));
            if(userInputSet.size() != 3){
                throw new IllegalArgumentException();
            }
        }
        catch(IllegalArgumentException e){
            System.out.println("IllegalArgumentException occurs");
        }
        catch(Exception e){
            System.out.println("Other Exception occurs");
        }
    }

    public static Map<String, Integer> playball(Integer answer, Integer userInput){
        List answerList = userInputToList(answer);
        List userInputList = userInputToList(userInput);
        Map<String, Integer> score = Map.of(
                "Ball",0,
                "Strike",0)

        for(int i=0; i<userInputList.size(); i++){
            Integer ball = userInputList.get(i);

            if(answerList.contains(ball) && answerList.indexOf(ball) == i){
                score.put("Strike", score.get("Strike")+1);
            }
            if(answerList.contains(ball) && answerList.indexOf(ball) != i){
                score.put("Ball", score.get("Ball")+1);
            }
        }
        return score;
    }

    public String printResult(Map<String, Integer> score){
        String answer = "";

        if(!score.get("Ball") == 0){
            answer += score.get("Ball").toString() + "볼 "
        }
        if(!score.get("Strike") == 0){
            answer += score.get("Strike").toString() + "스트라이크"
        }

        if(answer.length() == 0){
            answer = "낫싱";
        }
        return answer;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
