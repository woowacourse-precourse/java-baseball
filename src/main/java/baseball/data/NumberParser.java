package baseball.data;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import net.bytebuddy.pool.TypePool.Resolution.Illegal;

/**
 * 문자열로 입력받은 숫자들을 리스트에 옮겨담는다.
 */
public class NumberParser {

    /**
     * 문자열로 입력받은 플레이어의 숫자를 리스트로 변환해서 전달.
     * @param playerNumberString 아직 문자열로 저장되어있는 숫자들
     * @return 리스트로 입력받은 숫자를 변환
     */
    public List<Integer> parsePlayerNumber(String playerNumberString) {
        List<Integer> parsedNumbers;
        int tempNumbers;
        try{
            tempNumbers = Integer.parseInt(playerNumberString);
            parsedNumbers = divideNumbers(tempNumbers);
            checkGuessPhaseExceptions(parsedNumbers);
        }
        catch(Exception e){
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        return parsedNumbers;
    }

    /**
     * 숫자 입력에서 발생할 수 있는 오류들 체크<br>
     * 1. 중복된 숫자가 있음.<br>
     * 2. 입력받은 숫자가 세 자리 수가 아님.<br>
     * @param parsedNumbers 플레이어가 입력한 숫자 리스트
     * @throws IllegalArgumentException
     */
    public void checkGuessPhaseExceptions(List<Integer> parsedNumbers) throws IllegalArgumentException {
        Set<Integer> tempSet = new HashSet<>(parsedNumbers);
        if(tempSet.size() != parsedNumbers.size()){
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        } else if(parsedNumbers.size() != BaseballData.GAME_SIZE){
            throw new IllegalArgumentException("3개의 숫자만 입력해주세요");
        }
    }

    /**
     * Integer형을 자릿수끼리 분리해서 리스트에 저장
     * @param dividend 피제수
     * @return 플레이어가 입력한 숫자들을 리스트로 전달
     */
    public List<Integer> divideNumbers(int dividend){
        List<Integer> tempNumbers = new ArrayList<>();
        int divider = BaseballData.DIVIDE_INITIATE;
        int tempAnswer = 0;
        while(divider > 0){
            tempAnswer = dividend / divider; // 자랏수 임시 저장
            tempNumbers.add(tempAnswer); // 리스트에 자릿수 저장
            dividend = dividend - tempAnswer * divider; // 가장 왼쪽의 자릿값을 빼기
            divider = divider / BaseballData.DIVIDE_TARGET; // 자릿수 한칸 이동
        }
        return tempNumbers;
    }
}
