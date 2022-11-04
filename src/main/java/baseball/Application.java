package baseball;


import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import camp.nextstep.edu.missionutils.Console;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Application {
	public static boolean game_play(String computer_num){
		System.out.print("숫자를 입력해주세요 : ");
		String input_num = Console.readLine();
		//input에 따른 예외 처리 필요.
		List<Integer> answer = compare_two_case(computer_num,input_num);
		if(Collections.emptyList().equals(answer)){
			System.out.println("낫싱");
		}else{
			System.out.println(calculate_Result(answer));
		}
		if(answer.get(2)==3){
			System.out.println("축하합니다!");
			return true;
		}else{
			return false;
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
	public static int is_Strike_or_Ball(){
		int answer = 0;
		return answer;
	}
	public static List<Integer> compare_two_case(String com, String user){
		List<Integer> answer = Collections.emptyList();
		if(com.equals(user)){
			return answer;
		}
		answer = new LinkedList<>();
		answer.add(0);
		answer.add(0);
		answer.add(0);
		for(int i=0; i<3; i++){
			char now_num = user.charAt(i);
			if(com.contains(String.valueOf(now_num))){
				answer.set(is_Strike_or_Ball(),answer.get(is_Strike_or_Ball())+1);
			}
		}
		return answer;
	}
	public static String calculate_Result(List<Integer> answer_list){
		return "tmp";
	}
    public static void start_new_Baseball_Game() {
    	System.out.println("숫자 야구 게임을 시작합니다.");
    	String computer_num = select_Random_Number();
		boolean game_continue = true;
		while (game_continue){
			game_continue = game_play(computer_num);
		}
    }
	public static void main(String[] args) {
        start_new_Baseball_Game();
    }
}
