package baseball;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

class Game{
    public static String targetNumber;
    public int game_clear=0;
    int[] arr;
//    public static int game_restart_flag;
    public Game(){
        this.game_clear=0;
        System.out.println("숫자 야구 게임을 시작합니다.");
        arr=new int[10];
        int num1=camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(1, 9);
        arr[num1]=1;
        int num2=0;
        int num3=0;
        while(true){
            num2=camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9);
            if(arr[num2]!=1){
                arr[num2]=1;
                break;
            }
        }
        while(true){
            num3=camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9);
            if(arr[num3]!=1){
                arr[num3]=1;
                break;
            }
        }
        this.targetNumber=Integer.toString(num1)+Integer.toString(num2)+Integer.toString(num3);
//        this.game_restart_flag=1;

    }
    public String Input(){
        String user_num="";
        System.out.println("숫자를 입력해 주세요 : ");
        user_num=camp.nextstep.edu.missionutils.Console.readLine();
        return user_num;
    }



}

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
//        int randomNumber = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(100, 999);
//        System.out.println(randomNumber);
        while(true){
            Game g=new Game();
            break;
//            if(g.game_restart_flag==2){
//                break;
//            }

        }


    }
}
