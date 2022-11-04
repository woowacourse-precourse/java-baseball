package baseball;


import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import camp.nextstep.edu.missionutils.Console;

public class Application {
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
	public static String compare_two_case(String com, String user){
		return "tmp";
	}
    public static void start_new_Baseball_Game() {
    	System.out.println("숫자 야구 게임을 시작합니다.");
    	String computer_num = select_Random_Number();
		System.out.print("숫자를 입력해주세요 : ");
		String input_num = Console.readLine();
		//input에 따른 예외 처리 필요.
		System.out.println(compare_two_case(computer_num,input_num));
    }
	public static void main(String[] args) {
        start_new_Baseball_Game();
    }
}
