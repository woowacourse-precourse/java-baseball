package baseball.game;

import baseball.data.BaseballData;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import net.bytebuddy.pool.TypePool.Resolution.Illegal;

/**
 * 1. 입력받은 문자열에서 입력 오류가 있는지 검사.
 * 2. 오류가 없으면 정수형으로 변환 후 리스트에 옮긴다.
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
        checkPlayerStringException(playerNumberString); // 문자열 예외 검사
        tempNumbers = Integer.parseInt(playerNumberString);
        parsedNumbers = divideNumbers(tempNumbers);
        checkPlayerIntegerExceptions(parsedNumbers); // 정수 예외 검사

        return parsedNumbers;
    }

    /**
     * 숫자 입력에서 발생할 수 있는 오류들 체크<br>
     * 중복된 숫자가 있음.<br>
     * @param parsedNumbers 플레이어가 입력한 숫자 리스트
     * @throws IllegalArgumentException
     */
    public void checkPlayerIntegerExceptions(List<Integer> parsedNumbers) throws IllegalArgumentException{
        Set<Integer> playerNumbersHashSet = new HashSet<>(parsedNumbers);
        if(playerNumbersHashSet.size() != parsedNumbers.size()){
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
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

    public void checkPlayerStringException(String playerNumberString){
        checkIsDigitPlayerNumberString(playerNumberString);
        if(playerNumberString.length() > BaseballData.GAME_SIZE){
            throw new IllegalArgumentException("너무 많은 글자를 입력했습니다.");
        } else if(playerNumberString.length() < BaseballData.GAME_SIZE){
            throw new IllegalArgumentException("너무 적은 글자를 입력했습니다.");
        }
    }

    public void checkIsDigitPlayerNumberString(String playerNumberString){
        char oneCharacter;
        for(int index = 0; index < playerNumberString.length(); index ++ ){
            oneCharacter = playerNumberString.charAt(index);
            if(!Character.isDigit(oneCharacter)){
                throw new IllegalArgumentException("숫자만 입력해주세요.");
            }
        }
    }

    public void checkExceptionsPlayerRestartString(String playerRestartString){
        if(playerRestartString.length() != BaseballData.RESTART_SIZE){
            throw new IllegalArgumentException("한 글자만 입력해주세요.");
        }else if(!(playerRestartString.equals(BaseballData.RESTART)) &&
            !(playerRestartString.equals(BaseballData.GAME_OVER))){
            throw new IllegalArgumentException("1과 2의 입력만 허용 됩니다.");
        }
    }

    public boolean checkPlayerRestartString(String playerRestartString){
        if(playerRestartString.equals(BaseballData.RESTART)){
            return true;
        }
        return false;
    }
}
