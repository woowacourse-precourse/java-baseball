package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Application {

    // 정답 숫자 생성
    public static ArrayList answer_number() {

        ArrayList<Integer> answer = new ArrayList<>();

        while (answer.size() < 3) {

            int num = Randoms.pickNumberInRange(1, 9);

            if (answer.contains(num) == true) {
                continue;
            } else {
                answer.add(num);
            }
        }
        return answer;
    }

    // 정답 체크
    public static String answer_check(ArrayList answer, ArrayList attempt){

        int strike=0;
        int ball=0;

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(answer.get(i)==attempt.get(j) && i==j){
                    strike+=1;
                }
                if(answer.get(i)==attempt.get(j) && i!=j){
                    ball+=1;
                }
            }
        }

        if(strike==0 && ball==0){
            return "낫싱";
        }
        else{
            if(strike==0){
                return ball+"볼";
            }

            else if(ball==0){
                return strike+"스트라이크";
            }
            else{
                return ball+"볼 "+strike+"스트라이크";
            }
        }

    }

    public static boolean duplicate_check(ArrayList<Integer> attempt){


        for(int i=0; i<attempt.size()-1; i++){
            for(int j=i+1; j<attempt.size(); j++){
                if(attempt.get(i)==attempt.get(j)){
                    return false;
                }
            }
        }

        return true;



    }


    public static void main(String[] args) {

//        Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
//        사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
        // TODO: 프로그램 구현


        System.out.println("숫자 야구 게임을 시작합니다.");

        // 정답 숫자 생성
        ArrayList<Integer> answer = answer_number();


        while(true) {
            int user;
            System.out.print("숫자를 입력해주세요  : ");


            // 사용자의 입력 받기
            String origin = Console.readLine();

            try {
                user = Integer.parseInt(origin);
            } catch (IllegalArgumentException e) {
                break;
            }


            ArrayList<Integer> attempt = new ArrayList<>();




            if (duplicate_check(attempt) == false || attempt.size() != 3) {
                throw new IllegalArgumentException();

            }


            // 정답인 경우

            if(answer.equals(attempt)){
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int choice = Integer.parseInt(Console.readLine());

                // 게임 종료
                if(choice==2){
                    break;
                }

                // 게임 새로 시작
                else{
                    answer = answer_number();
                }
            }

            // 정답이 아닌 경우
            else{
                System.out.println(answer_check(answer,attempt));
            }


        }




    }
}