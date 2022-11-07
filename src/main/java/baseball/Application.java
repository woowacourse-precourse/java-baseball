package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    // 컴퓨터가 서로 다른 랜덤의 3자리 수를 정하는 함수
    private static void rand_num_decision(List<Integer> randnum){
        while (randnum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randnum.contains(randomNumber)) {
                randnum.add(randomNumber);
            }
        }
    }

    // 사용자로부터 3자리 수를 입력받는 함수
    private static String user_num_input(){
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    // 입력받은 값이 잘못되었는지 판별하여 애플리케이션을 종료할지 결정하는 함수
    private static boolean wrong(String num_input){
        if (num_input.length() > 3){
            return true;
        }
        return false;
    }

    // 게임 종료 뒤 입력받은 값을 토대로 게임 재시작을 할지 종료할지 결정하는 함수
    private static int game_reset(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Integer.parseInt(Console.readLine());
    }

    // 입력받은 수가 컴퓨터의 수와 같은 자리에 있는지, 다른 자리에 있는지, 아예 없는지 확인하는 함수
    private static int[] check(String user, List<Integer> com){
        int i, ball = 0, strike = 0;
        for (i = 0; i < 3; i++){
            // 사용자의 i번째 숫자가 컴퓨터의 i번째 숫자와 동일하면 strike +1
            if (Character.getNumericValue(user.charAt(i)) == com.get(i)){
                strike++;
                continue;
            }
            // 위의 경우를 만족하지 않으나 사용자의 i번째 숫자가 컴퓨터의 수 안에 있으면 ball +1
            if (com.contains(Character.getNumericValue(user.charAt(i)))){
                ball++;
            }
            // 이외의 경우는 ball, strike가 올라가지 않음
        }
        // 현재 예측에 대한 ball과 strike의 수 반환
        return new int[] {ball, strike};
    }

    // 입력한 숫자에 대해 컴퓨터의 숫자와 얼마나 근접한지(n볼 n스트라이크) 결과를 출력하는 함수
    private static boolean result(int[] bs){
        String output = "";
        // 1볼 이상일 경우 출력값에 볼 표기
        if (bs[0] != 0){
            output += Integer.toString(bs[0]) + "볼 ";
        }
        // 1스트라이크 이상일 경우 출력값에 스트라이크 표기
        if (bs[1] != 0){
            output += Integer.toString(bs[1]) + "스트라이크";
        }
        // 위 과정을 수행하고도 출력값이 없는 상황(볼, 스트라이크 모두 없는 상황)일 경우 출력값에 낫싱 표기
        if (output == ""){
            output = "낫싱";
        }
        // 예측 결과 출력
        System.out.println(output);
        // 만약 3스트라이크를 만족했을 경우 해당 게임 종료를 위해 false 반환
        if (bs[1] == 3){
            return false;
        }
        // 이외의 경우 계속 해당 게임 예측을 진행해야 하므로 true 반환
        else{
            return true;
        }
    }

    // 숫자야구를 한 게임 진행하는 함수
    private static int compare(List<Integer> com_num){
        // 사용자가 제시하는 숫자
        String user_num;
        // wrong_flag : 입력된 숫자 형식이 잘못된 경우를 체크
        // flag : 사용자가 이 게임에서 제시된 컴퓨터의 숫자를 정확히 맞추었는지 체크
        Boolean flag, wrong_flag;
        do{
            user_num = user_num_input();
            wrong_flag = wrong(user_num);
            // 사용자가 제시하는 숫자 형식이 잘못되었을 경우 에러 발생
            if (wrong_flag){
                throw new IllegalArgumentException();
            }
            // 정상적으로 입력된 숫자 형식일 경우 숫자 맞추기 1회 실행
            else{
                // 숫자를 정확히 맞추어 한 게임이 끝났는지를 체크, 끝나지 않았을 경우 계속 이 while문 수행
                flag = result(check(user_num, com_num));
            }
        } while (flag);
        // 한 게임이 종료된 뒤 새로운 게임을 실행할지를 결정
        return game_reset();
    }

    // 숫자야구 게임을 진행하는 함수
    private static void game(){
        // 게임이 계속 진행되는지를 결정
        int game_status;
        // 컴퓨터의 난수
        List<Integer> computer;

        do {
            // 새 게임 시작 시마다 컴퓨터의 난수를 재생성
            computer = new ArrayList<>();
            rand_num_decision(computer);
            // 컴퓨터의 난수를 넣어 숫자 야구 게임 1회 실행, 한 게임이 종료된 뒤 새로운 게임을 실행할지 체크, 이 값에 따라 while문 지속 수행
            game_status = compare(computer);
        } while (game_status == 1);
    }

    public static void main(String[] args) {

        // 시작 멘트
        System.out.println("숫자 야구 게임을 시작합니다.");
        // 게임 시작
        game();

    }
}
