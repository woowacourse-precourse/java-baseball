package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import camp.nextstep.edu.missionutils.Console;
import java.util.LinkedList;
import java.util.List;

public class Application {
	public static void main(String[] args) {
		boolean one_more_game= true;
		while(one_more_game){
			start_new_Baseball_Game();
			one_more_game = continue_or_exit();
		}
	}
	public static void start_new_Baseball_Game() {
		System.out.println("숫자 야구 게임을 시작합니다.");
		String computer_number = select_Random_Number();
		boolean is_3_Strike = true;
		while (is_3_Strike){
			is_3_Strike = game_play(computer_number);
		}
	}
	public static String select_Random_Number(){
		String computer_Random_Number = "";
		while(computer_Random_Number.length()<3){
			String now_number = String.valueOf(pickNumberInRange(1,9));
			if(!computer_Random_Number.contains(now_number)){
				computer_Random_Number+=now_number;
			}
		}
		return computer_Random_Number;
	}
	public static boolean game_play(String computer_number){
		System.out.println("숫자를 입력해주세요 : ");
		boolean is_3_Strike=false;
		String input_number = Console.readLine();
		input_number_exception_test(input_number);
		List<Integer> answer = compare_two_case(computer_number,input_number);
		System.out.println(calculate_Result(answer));
		if(answer.get(1)==3){
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			is_3_Strike = false;
			return is_3_Strike;
		}else{
			is_3_Strike = true;
			return is_3_Strike;
		}
	}
	public static void input_number_exception_test(String input) {
		if(input.length()!=3)
			throw new IllegalArgumentException();
		for(int i=0;i<3;i++){
			if(i!=input.indexOf(input.charAt(i)))
				throw new IllegalArgumentException();
		}
	}
	public static List<Integer> compare_two_case(String com, String user){
		List<Integer> answer = new LinkedList<>();
		answer.add(0); //ball의 수
		answer.add(0); //strike의 수
		for(int i=0; i<3; i++){
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
			return 1; //strike
		}else{
			return 0; //ball
		}
	}

	public static String calculate_Result(List<Integer> answer_list){
		String ball_count ="";
		String strike_count="";
		int ball = answer_list.get(0);
		if(ball !=0) {
			ball_count += ball+"볼";
		}
		int strike= answer_list.get(1);
		if(strike!=0){
			strike_count += strike+"스트라이크";
		}
		if(ball_count.equals("") && strike_count.equals("")){
			return "낫싱";
		}
		if(ball_count.equals("")){
			return strike_count;
		}
		if(strike_count.equals("")){
			return ball_count;
		}
		return ball_count+" "+strike_count;
	}
	public static  boolean continue_or_exit(){
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		int continue_or_exit = Integer.parseInt(Console.readLine());
		if(continue_or_exit==1)
			return true;
		return false;
	}
}
