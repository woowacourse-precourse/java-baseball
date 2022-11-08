package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        make_number();
    }
    public static void start(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public static List<Integer> make_number(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3){
            int random_number = Randoms.pickNumberInRange(1,9);
            if (!computer.contains(random_number)){
                computer.add(random_number);
            }
        }
        return computer;
    }
    public static int input_number(){

    }
    public static int wrong_number(){

    }
    public static int check_strike(){

    }
    public static int check_ball(){

    }
    public static void check_message(){

    }
    public static void end_message(){

    }
    public static int end_game(){

    }
}
