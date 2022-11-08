package baseball;

import static baseball.Util.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    public static void gameStart(){
        TextIO.Outln("숫자 야구 게임을 시작합니다.");
        while (gameProcess()){
        }
    }

    private static boolean gameProcess(){
        return repeatGuessAnswer(setRandomAnswer());
    }

    private static String setRandomAnswer(){
        List<Integer> numberCandidate = new ArrayList<>();

        while (numberCandidate.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            listFilterPush(numberCandidate, randomNumber);
        }

        return numberCandidate.stream().map(String::valueOf).collect(Collectors.joining(""));
    }


}
