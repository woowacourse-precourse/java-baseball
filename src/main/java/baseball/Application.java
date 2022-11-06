package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    // 컴퓨터 랜덤 숫자 생성
    private static List<Integer> getRandomNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> inputPlayerNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        String playerNumber = Console.readLine();

        if (!checkPlayerNumber(playerNumber)) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
        }

        List<Integer> player = new ArrayList<>();
        for (int i = 0; i < playerNumber.length(); i++) {
            char charNum = playerNumber.charAt(i);
            int intNum = Character.getNumericValue(charNum);
            player.add(intNum);
        }

        return player;
    }

    public static Boolean checkPlayerNumber(String playNumber) {
        // 문자열이 3자리인지 check
        if(playNumber.length()!=3){
            return false;
        }

        // 숫자 판단(1~9), 중복 판별
        List<Integer> player = new ArrayList<>();
        for(int i=0; i<playNumber.length(); i++){
            // 숫자판별
            char charNum = playNumber.charAt(i);
            if(!Character.isDigit(charNum)){
                return false;
            }else if(charNum=='0'){
                return false;
            }

            // 중복판별
            int intNum = Character.getNumericValue(charNum);
            if(player.contains(intNum)){
                return false;
            } else {
                player.add(intNum);
            }
        }

        return true;
    }

    // 게임 재시작/종료 선택
    public static String inputIsReStart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String isReStart = Console.readLine();
        return isReStart;
    }

    private static boolean isNothing(List<Integer> computer, List<Integer> player){
        boolean check=true;
        for(int i=0;i<player.size();i++){
            if(computer.contains(player.get(i))){
                check=false;
                break;
            }
        }
        return check;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true){
            // 컴퓨터 랜덤 숫자 생성
            List<Integer> computer = getRandomNumber();

            // 사용자 숫자 입력
            List<Integer> player;
            try {
                player = inputPlayerNumber();
            } catch (IllegalArgumentException exception){
                System.out.println(exception.getMessage());
                break;
            }

            if(isNothing(computer, player)){
                System.out.println("낫싱");
            } else{

            }

            // 게임 재시작/종료 선택
            String isReStart = inputIsReStart();
            if(!isReStart.equals("1")){
                break;
            }
        }


    }
}
