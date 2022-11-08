package baseball.entity;

import static utils.Constant.DIGIT_LENGTH;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


public class Computer {
    private List<Integer> answer;
    private int[] map;

    public void initialize(){
        createAnswer();
        createMap();
    }

    private void createAnswer(){
        answer = new ArrayList<>();
        while (answer.size() < DIGIT_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

    private void createMap(){
        map = IntStream.generate(() -> 0).limit(10).toArray();

        int length = answer.size();
        for(int i = 0; i < length; i++){
            int pos = length - i;
            map[answer.get(i)] = pos;
        }
    }

    public int compareAnswer(int predict){
        int ball, strike;
        ball = strike = 0;

        int q = predict;
        for(int i = 1; q != 0; i++){
            int num = q % 10;
            int pos = map[num];

            if(pos > 0){
                if(i == pos) {
                    strike++;
                }else{
                    ball++;
                }
            }

            q /= 10;
        }

        return ball * 10 + strike;
    }
}
