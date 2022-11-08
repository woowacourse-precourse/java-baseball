package baseball;

import java.util.HashMap;

public class ResultComparison {
	   
	   boolean print(String computer, String user) {
		  HashMap<String, Integer> count = resultCompare(computer,user);
		  
		  String strike ="스트라이크";
		  String ball = "볼";	
		  boolean gameEnd = false;
		  String countInformation = count.get(ball)+ball+" "+count.get(strike)+strike;
	     
	      
	      if(count.get(ball).equals(0)){
	    	  countInformation = count.get(strike)+strike;
	      }//if
	      if(count.get(strike).equals(0)) {
	    	  countInformation = count.get(ball)+ball;
	      }//if
	      if(count.get(ball).equals(0) && count.get(strike).equals(0)) {
	    	  countInformation = "낫싱";
	      }//if
	      if(count.get(strike).equals(3)) {
	    	 countInformation =count.get(strike) + strike + System.lineSeparator() + "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	         gameEnd = true;
	      }//if
	      
	      System.out.println(countInformation);
	      return gameEnd;
	   }//print
	   
	   private HashMap<String,Integer> resultCompare(String computer, String user) {
		  String strike ="스트라이크";
		  String ball = "볼";
		  
	      HashMap<String, Integer> count = new HashMap<String, Integer>();
	      count.put(strike, 0);
	      count.put(ball, 0);
	      
	      for(int digit=0; digit<3; digit++) {
	         if(computer.charAt(digit)==user.charAt(digit)) {
	            count.put(strike,count.get(strike)+1);
	         }//if
	      }//for
	      
	      for(int digit=0; digit<3;digit++) {
	         if(computer.charAt(digit)!=user.charAt(digit) && -1!=computer.indexOf(user.charAt(digit))) {
	            count.put(ball,count.get(ball)+1);
	         }//if
	      }//for
	      
	      return count;
	   }//resultCompare
}// end class
