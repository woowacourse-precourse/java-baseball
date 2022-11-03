package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;



public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // TODO : 1. 숫자 야구 게임 시작 문구 출력
        System.out.println("숫자 야구 게임을 시작합니다.");

        // TODO : 2. 컴퓨터가 가지고 있는 정답 문자열을 랜덤으로 지정
        // TODO : (각 자리마다 숫자가 다르게)
        String computer="";
        while(computer.length() < 3){
            int randomNumber = Randoms.pickNumberInRange(0,9);
            if (!computer.contains(Integer.toString(randomNumber))){
                computer += randomNumber;
            }
        }

        // TODO : 3. 사용자가 도전할 숫자를 입력
        System.out.print("숫자를 입력해주세요 : ");
        String guessingNumberString = Console.readLine();


}
