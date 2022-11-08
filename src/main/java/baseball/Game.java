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

    private static String inputPlayerNumber(){
        TextIO.Out("숫자를 입력해주세요 : ");
        String userInput = TextIO.In(false);

        return userInput;
    }

    private static Integer getBallCount(String answer, String userInput){
        int result = 0;

        for(int i=0; i<3; i++){
            String substring = getSubstring(answer, i);
            result += booleanToInteger(substring.contains(getSingleString(userInput, i)));
        }

        return result;
    }

    private static Integer getStrikeCount(String answer, String userInput){
        int result = 0;
        for(int i=0; i<3; i++) {
            String userInputAtom = getSingleString(userInput, i);
            String answerAtom = getSingleString(answer, i);
            result += booleanToInteger(userInputAtom.equals(answerAtom));
        }
        return result;
    }

    private static boolean getComparationResult(String answer, String userInput){
        return printResultAndContinue(getStrikeCount(answer, userInput),getBallCount(answer, userInput));
    }


}
