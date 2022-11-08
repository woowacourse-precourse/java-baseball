package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class game{
    List<Integer> computer = new ArrayList<>();
    List<Integer> my_num_list = new ArrayList<>();
    int my_num;
    int ball_cnt;
    int strike_cnt;
    int end_gamer=-1;
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
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
    public void get_My_num(){
        System.out.print("숫자를 입력해주세요 : ");
        my_num = Integer.parseInt(Console.readLine());
        if (my_num >= 1000){
            throw new IllegalArgumentException();
        }
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
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            System.out.println("게임을 새로 시작하려면 1,종료하려면 2를 입력하세요.");
            setEnd_gamer(Integer.parseInt(Console.readLine()));
        }else{
            if(ball_cnt==0){
                System.out.printf("%d스트라이크\n",strike_cnt);
            }else if(strike_cnt==0){
                System.out.printf("%d볼\n",ball_cnt);
            }else{
                System.out.printf("%d볼 %d스트라이크\n",ball_cnt,strike_cnt);
            }
        }

    }
    public void makeMynumToList(){
        if(my_num_list.size()>0){
            my_num_list.clear();
        }
        my_num_list.add(my_num/100);
        my_num_list.add((my_num%100)/10);
        my_num_list.add(my_num%10);
    }
    public void setEnd_gamer(int flag){
        if(flag==1){
            this.end_gamer = 1;
        }else{
            this.end_gamer = 2;
        }
    }

}

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다");
        loopout:
        while (true){
            game baseball = new game();
            while (true) {
                baseball.get_My_num();
                baseball.ball_counter();
                baseball.ball_commenter();
                if (baseball.end_gamer==1) {
                    break;
                }else if(baseball.end_gamer==2){
                    System.out.println("게임 종료");
                    break loopout;
                }
            }
        }

    }
}
