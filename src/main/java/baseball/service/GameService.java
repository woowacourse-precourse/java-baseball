package baseball.service;

import java.util.ArrayList;
import java.util.List;

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
    }

    public Game initAnswer(Game game) {
        game.setNumbers(Randoms.pickUniqueNumbersInRange(MIN_VALUE, MAX_VALUE, MAX_COUNT));

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

        //printOutput(ball, strike);

        if(strike == MAX_COUNT) {
            return true;
        }

        return false;
    }


}
