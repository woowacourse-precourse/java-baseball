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

    private static boolean printResultAndContinue(Integer strike, Integer ball){
        StringBuilder printResult = new StringBuilder();
        if (strike == 0 && ball == 0){
            TextIO.Outln("낫싱");
            return true;
        }
        if (strike == 3){
            printResult.append(strike);
            printResult.append("스트라이크\n");
            printResult.append("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
            printResult.append("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            System.out.println(printResult);
            return false;
        }
        if (strike < 3 && ball != 0){
            printResult.append(ball);
            printResult.append("볼 ");
        }
        if (strike != 0){
            printResult.append(strike);
            printResult.append("스트라이크");
        }
        System.out.println(printResult);
        return true;
    }



}
