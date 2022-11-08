package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 컴퓨터 입력값

        int coin = 1;
        List<Integer> comNumber = computerList();

        while (coin == 1){
            System.out.println("comnumber : " + comNumber);

            // 사용자에게 1 ~ 9까지 중복되지 않는 3개의 숫자를 입력받는다.
            List<Integer> userNum = userNumList();



            String value = checkResult(comNumber, userNum);
            System.out.println(value);

            if(value.equals("3스트라이크")){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
                coin = Integer.parseInt(Console.readLine());
            }

            // 재시작 후 값을 다시 할당함
            if(comNumber.equals(userNum) && coin == 1){
                comNumber = computerList();
            }

            if(coin == 2){
                System.out.println("게임 종료");
            }
        }

    }


    /**
     * 1~9까지 컴퓨터의 수를 랜덤하게 발생시키는 함수이다.
     *
     * @return List<Integer>
     * @date 2022.11.06
     * @author lacred
     */
    public static List<Integer> computerList() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    /**
     * 사용자에게 1 ~ 9까지 중복되지 않는 숫자를 입력 받는 함수
     *
     * @return List<Integer>
     * @throws IllegalArgumentException
     * @date 2022.11.07
     * @author lacred
     */
    public static List<Integer> userNumList() {
        String userNum = Console.readLine();
        List<Integer> userNumList = new ArrayList<>();

        for (int i = 0; i < userNum.length() ; i++) {
            if(userNumList.contains(Character.getNumericValue(userNum.charAt(i)))){
                throw new IllegalArgumentException();
            }

            if(Character.getNumericValue(userNum.charAt(i)) > 0 && Character.getNumericValue(userNum.charAt(i))<10){
                userNumList.add(Character.getNumericValue(userNum.charAt(i)));
            }else{
                throw new IllegalArgumentException();
            }
        }

        if(userNumList.stream().count() != 3 ){
            throw new IllegalArgumentException();
        }

        return userNumList;
    }

    /**
     * 컴퓨터와 사용자의 입력 값을 비교한다.
     *
     *  같은 자리 같은 수 : 스트라이크
     *  다른 자리 같은 수 : 볼
     *  일치 하는 값이 없음 : 낫싱
     * @param comNumber, userNumber
     * @return List<String>
     * @date 2022.11.08
     * @author lacred
    * */
    public static String checkResult(List<Integer> comNumber, List<Integer> userNumber){

        // 사용자의 입력 값과 컴퓨터의 입력 값을 확인한다.
        List<String> checkValue = new ArrayList<>();

        // 사용자와 컴퓨터가 입력한 값을 비교함
        for (int i = 0; i < comNumber.size() ; i++) {
            if(comNumber.get(i) == userNumber.get(i)) {
                checkValue.add("스트라이크");
            } else if (Collections.frequency(comNumber, userNumber.get(i)) != 0) {
                checkValue.add("볼");
            }
        }

        String value = checkScore(checkValue);
        return value;
    }

    /**
    * 사용자가 입력한 값을 검출한다.
     *
     * @param List<String>
     * @return String
     * @date 2022.11.08
     * @author lacred
    * */
    public static String checkScore(List<String> paramScore){

        String score = "";
        //입력된 값을 찾음
        if(paramScore.contains("볼")){
            score += Integer.toString(Collections.frequency(paramScore,"볼"))+"볼 ";
        }

        if (paramScore.contains("스트라이크")) {
            score += Integer.toString(Collections.frequency(paramScore, "스트라이크")) + "스트라이크";
        }

        if(paramScore.size() <= 0 ) {
            score = "낫싱";
        }
        System.out.println("score : " + score);

        return score;
    }

}
