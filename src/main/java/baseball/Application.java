package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import camp.nextstep.edu.missionutils.Console;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Application {
	public static void start_new_Baseball_Game() {
		System.out.println("숫자 야구 게임을 시작합니다.");
		String computer_num = select_Random_Number();
		boolean game_continue = true;
		while (game_continue){
			game_continue = game_play(computer_num);
		}
	}
	public static String select_Random_Number(){
		String com_Random_Num = "";
		while(com_Random_Num.length()<3){
			String now_num = String.valueOf(pickNumberInRange(1,9));
			if(!com_Random_Num.contains(now_num)){
				com_Random_Num+=now_num;
			}
		}
		return com_Random_Num;
	}
	public static boolean game_play(String computer_num){
		System.out.println("숫자를 입력해주세요 : ");
		String input_num = Console.readLine();
		input_num_exception_test(input_num);
		List<Integer> answer = compare_two_case(computer_num,input_num);
		System.out.println("\n"+calculate_Result(answer));
		if(answer.get(1)==3){
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
			return false;
		}else{
			return true;
		}
	}
	public static List<Integer> compare_two_case(String com, String user){
		List<Integer> answer = Collections.emptyList();
		answer = new LinkedList<>();
		answer.add(0);
		answer.add(0);
		for(int i=0; i<2; i++){
			String now_num =String.valueOf(user.charAt(i));
			if(com.contains(now_num)){
				int ball_or_strike = is_Strike_or_Ball(com,now_num,i);
				answer.set(ball_or_strike,answer.get(ball_or_strike)+1);
			}
		}
		return answer;
	}
	public static int is_Strike_or_Ball(String com, String number, int index){
		if(com.indexOf(number)==index){
			return 1;
		}else{
			return 0;
		}
	}

	public static String calculate_Result(List<Integer> answer_list){
		String ball_cnt ="";
		String strike_cnt="";
		int ball = answer_list.get(0);
		if(ball !=0) {
			ball_cnt += ball+"볼";
		}
		int strike= answer_list.get(1);
		if(strike!=0){
			strike_cnt += strike+"스트라이크";
		}
		if(ball_cnt.equals("") && strike_cnt.equals("")){
			return "낫싱";
		}
		if(ball_cnt.equals("")){
			return strike_cnt;
		}
		if(strike_cnt.equals("")){
			return ball_cnt;
		}
		return ball_cnt+" "+strike_cnt;
	}
	public static  boolean continue_or_exit(){
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		int continue_or_exit = Integer.parseInt(Console.readLine());
		if(continue_or_exit==1)
			return true;
		return false;
	}
	public static void input_num_exception_test(String input) {
		if(input.length()!=3)
			throw new IllegalArgumentException();
		for(int i=0;i<3;i++){
			if(i!=input.indexOf(input.charAt(i)))
				throw new IllegalArgumentException();
		}
	}
	public static void main(String[] args) {
        boolean is_contiue = true;
		while(is_contiue){
			start_new_Baseball_Game();
			is_contiue = continue_or_exit();
		}
    }
}
