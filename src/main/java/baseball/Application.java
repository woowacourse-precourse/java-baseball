package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static Scanner scan = new Scanner(System.in);
    public static HashMap<String,Integer> count_ball(List<Integer> target_ball, int input_ball){
        HashMap<String, Integer> ball_count = new HashMap<>();
        List<Integer> input = new ArrayList<>();
        for(int i=2; i>=0; i--){
            int count = (int)Math.pow(10,i);
            int tmp = input_ball/count;
            if(!input.contains(tmp)){
                input.add(tmp);
            }else{
                throw new IllegalArgumentException("!!!입력은 중복을 허용하지 않습니다!!!");
            }
            input_ball %=count;
        }

        for(int i=0; i<target_ball.size();i++){
            if(input.get(i)==target_ball.get(i)){
                ball_count.put("Strike",ball_count.getOrDefault("Strike",0)+1);
            }else if(input.contains(target_ball.get(i))){
                ball_count.put("Ball",ball_count.getOrDefault("Ball",0)+1);
            }
        }
        return ball_count;
    }
    public static List<Integer> get_rand(){
        List<Integer> target_ball = new ArrayList<>();
        while (target_ball.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!target_ball.contains(randomNumber)) {
                target_ball.add(randomNumber);
            }
        }
        return  target_ball;
    }
    public static int in_game(List<Integer>target_ball){

        while(true){
            System.out.print("숫자를 입력해주세요 : ");
            int input_ball = scan.nextInt();
            if(input_ball/1000>0){
                throw new IllegalArgumentException("숫자는 3개까지만 입력 가능합니다");
            }
            HashMap<String,Integer> ball_count = count_ball(target_ball,input_ball);
            if(ball_count.get("Strike")!=null&&ball_count.get("Strike")==3){
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int start_end = scan.nextInt();
                return start_end;
            }else if(ball_count.isEmpty()){
                System.out.println("낫싱");
            }else if(ball_count.get("Ball")==null){
                System.out.println(ball_count.get("Strike")+"스트라이크");
            }else if(ball_count.get("Strike")==null){
                System.out.println(ball_count.get("Ball")+"볼 ");
            }else{
                System.out.println(ball_count.get("Ball")+"볼 "+ball_count.get("Strike")+"스트라이크");
            }
        }


    }
    public static void main(String[] args)throws IllegalArgumentException {

        while(true) {
            List<Integer> target_ball = get_rand();
            int end_or_not ;
            System.out.println("숫자 야구 게임을 시작합니다.");
//            System.out.println(target_ball);
            end_or_not = in_game(target_ball);
            if(end_or_not==1){
                continue;
            }else if(end_or_not==2){
                break;
            }else {
                throw new IllegalArgumentException("!!!숫자는 1, 2중 하나입니다!!!");
            }
        }

    }
}
