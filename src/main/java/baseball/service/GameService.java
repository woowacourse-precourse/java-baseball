package baseball.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import baseball.model.Game;
import camp.nextstep.edu.missionutils.Randoms;

public class GameService {

    private final int MAX_COUNT = 3;
    private final int MAX_VALUE = 9;
    private final int MIN_VALUE = 1;

    public void validate(Game game) {
        List<Integer> numbers = game.getNumbers();

        if(numbers.size() < MAX_COUNT) {
            throw new IllegalArgumentException("3개 미만의 숫자를 입력할 수 없습니다.");
        }

        if(numbers.size() > MAX_COUNT) {
            throw new IllegalArgumentException("3개 초과의 숫자를 입력할 수 없습니다.");
        }

        for(int num : game.getNumbers()){
            if (num < MIN_VALUE || num > MAX_VALUE) {
                throw new IllegalArgumentException("1에서 9 사이의 숫자만 입력할 수 있습니다.");
            }
        }

        boolean isDuplicated = numbers.stream()
               .distinct()
               .count() != numbers.size();

        if(isDuplicated) {
            throw new IllegalArgumentException("중복되는 숫자는 입력할 수 없습니다.");
        }
    }

    public Game initAnswer(Game game) {
        List<Integer> newAnswer = new ArrayList<>();

        while(newAnswer.size() < MAX_COUNT){
            int randomNumber = Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
            if(!newAnswer.contains(randomNumber)){
                newAnswer.add(randomNumber);
            }
        }

        game.setNumbers(newAnswer);

        return game;
    }

    public Game initInput(Game game, String inputStr) {
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < inputStr.length(); i++){
            int nextNumber = (inputStr.charAt(i)) - '0';

            if(nextNumber != ' ' - '0') {
                list.add(nextNumber);
            }
        }

        game.setNumbers(list);

        return game;
    }

    public boolean compareAnswer(Game answer, Game userInput) {
        int ball = 0;
        int strike = 0;

        List<Integer> answerList = answer.getNumbers();
        List<Integer> userList = userInput.getNumbers();

        for(int index = 0; index < answerList.size(); index++){
            int answerNum = answerList.get(index);
            int userNum = userList.get(index);

            if(answerNum == userNum){
                strike++;
            }

            if(answerNum != userNum && answerList.contains(userNum)){
                ball++;
            }
        }

        printOutput(ball, strike);

        if(strike == MAX_COUNT) {
            return true;
        }

        return false;
    }

    public void printOutput(int ball, int strike) {
        StringBuilder sb = new StringBuilder();

        if(ball > 0){
            sb.append(ball + "볼 ");
        }

        if(strike > 0){
            sb.append(strike + "스트라이크");
        }

        if(strike == 0 && ball == 0){
            sb.append("낫싱");
        }

        System.out.println(sb.toString());
    }
}
