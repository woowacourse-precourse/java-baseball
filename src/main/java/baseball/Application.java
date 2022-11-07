package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {

    /*
     * 컴퓨터가 세자리의 랜덤 숫자를 선택, 각 자리값을 리스트에 담아 반환
     */
    public List<Integer> computersChoice() {

        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    /*
     * 사용자가 세자리의 숫자를 입력, 각 자리값을 리스트에 담아 반환
     */
    public List<Integer> usersChoice(){

        String input = Console.readLine();
        inputExceptionHandler(input);   // 입력값 예외처리

        List<Integer> user = new ArrayList<>();

        for (int i = 0; i < input.length(); i++){
            user.add(Character.getNumericValue(input.charAt(i)));
        }

        return user;
    }

    /*
     * 사용자 입력 예외를 처리함
     */
    public void inputExceptionHandler(String input){
        // TODO: 사용자 입력 예외를 처리함
    }

    /*
     * 컴퓨터가 고른 숫자와 사용자가 입력한 숫자를 비교하여 결과를 반환
     */
    public String getGameResult(List<Integer> computer, List<Integer> user){
        // TODO: 컴퓨터가 고른 숫자와 사용자가 입력한 숫자를 비교하여 결과를 반환
        return "";
    }

    /*
     * 게임 종료 후 숫자 야구 게임 재시작 여부 반환
     */
    public boolean restartGame(){
        // TODO: 게임 종료 후 숫자 야구 게임 재시작 여부 반환
        return false;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
