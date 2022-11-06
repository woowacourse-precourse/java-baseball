package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static baseball.constant.ConstantValue.*;

public class GameManager {
    public GameManager(){
    }

    public int [] playGame(List<Integer> computer, List<Integer> player){
        int[] score = new int[3];
        for(int i = 0; i < BASEBALL_NUMBER_SIZE; i++){
            int computerNumber = computer.get(0);
            int computerIndex = i;

            int result = calculateScore(computerNumber, computerIndex, player);
            score[result]++;
        }
        return score;
    }

    public int calculateScore(int computerNumber, int computerIndex, List<Integer> player) {
        for(int i = 0; i < BASEBALL_NUMBER_SIZE; i++){
            int playerNumber = player.get(0);
            int playerIndex = i;

            if(computerNumber == playerNumber && computerIndex == playerIndex){
                return STRIKE;
            }
            if(computerNumber == playerNumber){
                return BALL;
            }
        }
        return NOTHING;
    }

    public void printResult(int[] score){
        StringBuilder sb = new StringBuilder();
        if(score[STRIKE] == 0 && score[BALL] == 0){
            System.out.println("낫싱");
            return;
        }
        if(score[BALL] != 0){
            sb.append(String.format("%d볼 ", score[BALL]));
        }
        if(score[STRIKE] != 0){
            sb.append(String.format("%스트라이크", score[STRIKE]));
        }
        System.out.println(sb);
    }

    public List<Integer> toList(String number){
        return Arrays.stream(number.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<Integer> createComputerNumber(){
        List<Integer> computer = new ArrayList<>();
        while(computer.size() < BASEBALL_NUMBER_SIZE){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
