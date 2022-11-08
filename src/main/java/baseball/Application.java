package baseball;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

class Game{
    public static String targetNumber;
    public int game_clear=0;
    int strike_num=0;
    int ball_num=0;
    int continue_game;
    int[] target_check;
//    public static int game_restart_flag;
    public Game(){
        this.continue_game=1;
        this.strike_num=0;
        this.ball_num=0;
        this.game_clear=0;
        System.out.println("숫자 야구 게임을 시작합니다.");
        target_check=new int[]{0,0,0,0,0,0,0,0,0,0};
        int num1=camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(1, 9);
        target_check[num1]=1;
        int num2=0;
        int num3=0;
        while(true){
            num2=camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9);
            if(target_check[num2]!=1){
                target_check[num2]=1;
                break;
            }
        }
        while(true){
            num3=camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9);
            if(target_check[num3]!=1){
                target_check[num3]=1;
                break;
            }
        }
        this.targetNumber=Integer.toString(num1)+Integer.toString(num2)+Integer.toString(num3);
//        this.game_restart_flag=1;

    }
    public String Input(){
        String user_num="";
        System.out.print("숫자를 입력해 주세요 : ");
        user_num=camp.nextstep.edu.missionutils.Console.readLine();
        return user_num;
    }
    public int isBall(int ball_check_num){
        if(ball_check_num==1){
            return 1;
        }
        return 0;
    }
    public void ball_and_strike_print(int ball, int strike){
        String to_print="";
        if(ball>0){
            to_print+=ball;
            to_print+="볼 ";
        }
        if(strike>0){
            to_print+=strike;
            to_print+="스트라이크";
        }
        if(to_print==""){
            System.out.println("낫싱");
        }else{
            System.out.println(to_print);
        }
        if(strike==3){
            game_clear=1;
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }

    }
    boolean check_user_input_len(String input){
        if(input.length()==3){
            return true;
        }else{
            return false;
        }
    }
    boolean check_user_input_isnum(String input){
        try {
            int input_num=Integer.parseInt(input);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }
    boolean check_user_input_isEqualExist(String input){
        int[] input_visit=new int[]{0,0,0,0,0,0,0,0,0,0};
        for(int i=0;i<3;++i){
            int curNum=Integer.parseInt(input.substring(i,i+1));
            input_visit[curNum]+=1;
        }
        for(int i=0;i<10;++i){
            if(input_visit[i]>1){
                return false;
            }
        }
        return true;
    }
    int check_new_game(String input){
        int input_num;
        try{
            input_num=Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
        if(input_num!=1 && input_num!=2){
            throw new IllegalArgumentException();
        }
        return input_num;
    }
    void check_user_num(String input){
        if(!check_user_input_len(input)){
            throw new IllegalArgumentException();
        }
        if(!check_user_input_isnum(input)){
            throw new IllegalArgumentException();
        }
        if(!check_user_input_isEqualExist(input)){
            throw  new IllegalArgumentException();
        }
    }
    public void check(){
        strike_num=0;
        ball_num=0;
        String curString=Input();
        check_user_num(curString);
        int[] ball_check=new int[]{0,0,0,0,0,0,0,0,0,0};
        for(int i=0;i<3;++i){
            String partial_string=curString.substring(i,i+1);
            int partial_string_num=Integer.parseInt(partial_string);
            ball_check[partial_string_num]=1;
            if(curString.charAt(i)==targetNumber.charAt(i)){
                ball_check[partial_string_num]=2;
                ++strike_num;
            }
        }
        for(int i=0;i<10;++i){
            if(ball_check[i]==target_check[i]){
                ball_num+=isBall(ball_check[i]);
            }
        }
        ball_and_strike_print(ball_num,strike_num);
        if(game_clear==1){
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String user_game_flag=camp.nextstep.edu.missionutils.Console.readLine();
            int game_flag=check_new_game(user_game_flag);

            if(game_flag==2){
                continue_game=0;
            }

        }
        System.out.println(targetNumber);
        System.out.println(strike_num);
        System.out.println(ball_num);


    }
    public void game_processing(){
        while(true){
            check();
            if(game_clear==1){
                break;
            }

        }
    }



}

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
//        int randomNumber = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(100, 999);
//        System.out.println(randomNumber);
        while(true){
            Game g=new Game();
            g.game_processing();
            if(g.continue_game==0){
                break;
            }
//            if(g.game_restart_flag==2){
//                break;
//            }

        }


    }
}
