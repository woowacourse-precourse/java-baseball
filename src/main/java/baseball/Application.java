package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Application {
    public static List<Integer> IntegerToList(Integer Input){
        List<Integer> userInputList = new ArrayList<>();
        while(Input > 0){
            userInputList.add(Input%10);
            Input /= 10;
        }
        Collections.reverse(userInputList);
        return userInputList;
    }

    public static void checkUserInput(String userInput){
        Integer userInputInteger = Integer.valueOf(userInput);
        Set<Integer> userInputSet = new HashSet<>(IntegerToList(userInputInteger));
        if(userInputSet.size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public static Map<String, Integer> playball(Integer answer, Integer userInputInteger){
        List<Integer> answerList = IntegerToList(answer);
        List<Integer> userInputList = IntegerToList(userInputInteger);
        Map<String, Integer> score = new HashMap<>(Map.of(
                "Ball", 0,
                "Strike", 0));

        for(int i=0; i<userInputList.size(); i++){
            Object ball = userInputList.get(i);

            if(answerList.contains(ball) && answerList.indexOf(ball) == i){
                score.put("Strike", score.get("Strike")+1);
            }
            if(answerList.contains(ball) && answerList.indexOf(ball) != i){
                score.put("Ball", score.get("Ball")+1);
            }
        }
        return score;
    }

    public static String printResult(Map<String, Integer> score){
        String answer = "";

        if(score.get("Ball") != 0){
            answer += score.get("Ball").toString() + "볼 ";
        }
        if(score.get("Strike") != 0){
            answer += score.get("Strike").toString() + "스트라이크";
        }
        if(answer.length() == 0){
            answer = "낫싱";
        }
        return answer;
    }

    public static void playOneGame(Integer answer){
        String result = "";

        while(!result.equals("3스트라이크")) {
            String userInput = camp.nextstep.edu.missionutils.Console.readLine();
            checkUserInput(userInput);

            Integer userInputInteger = Integer.valueOf(userInput);
            result = printResult(playball(answer, userInputInteger));
            System.out.println(result);
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static int determineAnswer(){
        List<String> answer = new ArrayList<>();
        while(answer.size()<3) {
            String randomNumber = Integer.toString(Randoms.pickNumberInRange(1, 9));
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return Integer.parseInt(answer.get(0) + answer.get(1) + answer.get(2));
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int gameStarter = 1;
        while(gameStarter == 1){
            System.out.println("숫자야구 게임을 시작합니다.");
            int answer = determineAnswer();

            playOneGame(answer);

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            gameStarter = Integer.parseInt(camp.nextstep.edu.missionutils.Console.readLine());
        }
    }
}
