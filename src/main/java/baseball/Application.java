package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
*
2. 컴퓨터(상대방)의 숫자를 설정하는 함수
3. 입력 받은 숫자를 규칙에 따라 결과를 리턴해주는 함수. 리턴값이 -1이면 맞춘것으로 하여 재시작 여부 질문
4. 재시작or종료 함수. 재시작이면 continue, 아니면 break!!
* */
class game{
    List<Integer> computer;
    List<Integer> my_num_list;
    int my_num;
    int ball_cnt;
    int strike_cnt;
    boolean end_gamer=false;
    Scanner sc = new Scanner(System.in);
    public game(){
        setComputerNum();
        ball_setter();
    };
    public void ball_setter(){
        ball_cnt=0;
        strike_cnt=0;
    }
    public void setComputerNum(){
        this.computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
    public void get_My_num(){
        System.out.print("숫자를 입력해주세요 : ");
        this.my_num = sc.nextInt();
        makeMynumToList();
    }
    public void ball_counter(){
        ball_setter();
        for(int i=0;i<computer.size();i++){
            ball_checker(i);
        }
    }
    public void ball_checker(int my_index){
        int temp_my = my_num_list.get(my_index);
        int temp_cmp = computer.get(my_index);
        if((temp_cmp != temp_my)&&computer.contains(temp_my)){
            this.ball_cnt++;
        } else if (temp_cmp==temp_my) {
            this.strike_cnt++;
        }
    }
    public void ball_commenter(){
        if (ball_cnt+strike_cnt==0){
            System.out.println("낫싱");
        }else if (strike_cnt==3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            System.out.println("게임을 새로 시작하려면 1,종료하려면 2를 입력하세요.");
            setEnd_gamer(sc.nextInt());
        }else{
            if(ball_cnt==0){
                System.out.printf("%d스트라이크",strike_cnt);
            }else if(strike_cnt==0){
                System.out.printf("%볼",ball_cnt);
            }else{
                System.out.printf("%볼 %d스트라이크",ball_cnt,strike_cnt);
            }
        }

    }
    public void makeMynumToList(){
        my_num_list.clear();
        my_num_list.add(my_num/100);
        my_num_list.add((my_num%100)/10);
        my_num_list.add(my_num%10);
    }
    public void setEnd_gamer(int flag){
        if(flag==1){
            this.end_gamer = false;
        }else{
            this.end_gamer = true;
        }
    }

}

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다");
        while (true){
            game baseball = new game();
            baseball.get_My_num();
            baseball.ball_counter();
            if (baseball.end_gamer){
                break;
            };
        }
    }
}
