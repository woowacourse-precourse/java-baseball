package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*camp.nextstep.edu.missionutils에서 제공하는 Randoms 
 * 및 Console API를 사용하여 구현해야 한다.*/

class baseball {
	
	int user_num;
    Scanner number = new Scanner(System.in);
	int temp;
	int result_num;
	List<Integer> cmp_List = new ArrayList<>(3);
	baseball(){
		System.out.println("숫자 야구 게임을 시작합니다.");
		get_gamenum();
		result();
	}
	
	/*
	 * baseball(int i){ System.out.println("숫자 야구 게임을 시작합니다."); }
	 */
	
	void repeat_game(){
		
	}
	
	int get_gamenum() {
		System.out.println("숫자를 입력해주세요 : "); // 세자리수 제한 구현필요
		user_num = number.nextInt();
		return user_num;
	}
	
	void game() {
		System.out.println("숫자를 모두 맞히셨습니다! 게임 종료");
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		repeat_game();
	}
	
	void result() {
		//random사용해서 정답과 비교수를 compare로 넘김
		result_num = 713;
		user_num = 713;
		
		if(compare(this.result_num, this.user_num) == 1) {
		game();
		}
		
	}
	
	int compare(int result_num, int user_num) {
		System.out.println("3스트라이크");
		return 1;
	}
	
	
}


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    	//야구게임
    baseball baseball_game = new baseball();

    
    
    
    
    
    
    
    
    }
}

