package baseball;

import java.util.List;

public class CompareNumber {

	public static int STRIKE=0;
	public static int BALL=0;

	public static void compareUserNumberAndRandomNumber(String user_number, List<Integer> random_number_list){
		char[] user_number_list = user_number.toCharArray();

		for (int i=0;i<3;i++) {
			for (int k=0;k<3;k++){
				getUserNumberInStrike(user_number_list, random_number_list,i,k);
			}
		}
		RoundScore.addScoreAtUserInputNumber(STRIKE, BALL);
	}

	public static void getUserNumberInStrike(char[] user_num_list, List<Integer> random_number_list,
											 		int index1,int index2) {

		int user_num =Integer.parseInt(String.valueOf(user_num_list[index1]));

		if (user_num==random_number_list.get(index2)&&index1==index2) {
			STRIKE++;
		}
		else {
			getUserNumberInBall(user_num,random_number_list,index1,index2);
		}
	}

	private static void getUserNumberInBall(int user_num, List<Integer> random_number_list,
													int index1,int index2) {

		if (user_num==random_number_list.get(index2)&&index1!=index2) {
			BALL++;
		}
	}

	public static void setInitializeScore(){
		STRIKE=0;
		BALL=0;
	}
}
