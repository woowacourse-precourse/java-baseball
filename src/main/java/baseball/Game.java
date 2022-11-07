package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Game {
    public static int ANSWER_SIZE = 3;
    public static int MIN_NUMBER_OF_ANSWER = 1;
    public static int MAX_NUMBER_OF_ANSWER = 9;

    private final List<Integer> answer;
    Game(List<Integer> answer){
        this.answer = answer;
    }

    static List<Integer> computerSelectNumbers(){
        List<Integer> selectedNums = new ArrayList<>();
        while (selectedNums.size() < ANSWER_SIZE) {
            int randomNumber = pickNumberInRange(MIN_NUMBER_OF_ANSWER, MAX_NUMBER_OF_ANSWER);
            if (!selectedNums.contains(randomNumber)) {
                selectedNums.add(randomNumber);
            }
        }
        return selectedNums;
    }

    public List<Integer> getBallStrikeCnt(List<Integer> playerGuess){
        int strike = countStrike(playerGuess);
        int ball = countNumbersContainedInAnswer(playerGuess) - strike;

        return List.of(ball, strike);
    }
    int countNumbersContainedInAnswer(List<Integer> playerGuess){
        return (int) playerGuess.stream()
                .filter(input -> answer.contains(input))
                .count();
    }

    int countStrike(List<Integer> playerGuess){
        int strike = 0;
        for(int idx = 0; idx < ANSWER_SIZE; idx++){
            if(playerGuess.get(idx) == answer.get(idx)){
                strike++;
            }
        }
        return strike;
    }
}
