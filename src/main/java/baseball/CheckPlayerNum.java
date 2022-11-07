package baseball;

import java.util.Set;
import java.util.HashSet;


public class CheckPlayerNum {
   private String playerNumber;

   public String getUserNumber() {
       return playerNumber;
   }

   public void setPlayerNumber(String playerNumber) {
       if(isStringLengthCorrect(playerNumber) && isDigitPlayerNumber(playerNumber) && isDifferentPlayerNumber(playerNumber)) {
           this.playerNumber = playerNumber;
       }
   }

   public static boolean isStringLengthCorrect(String word) throws IllegalArgumentException {
       if(word.length() != 3) {
           throw new IllegalArgumentException("게임 종료");
       }
       return true;
   }

   public static boolean isDigitPlayerNumber(String word) throws IllegalArgumentException {
       for(int i = 0; i < word.length(); i++) {
           isDigitCharInString(word, i);
       }
       return true;
   }

   public static boolean isDifferentPlayerNumber(String word) throws IllegalArgumentException {
       Set<Character> set = new HashSet<>();

       for(int i = 0; i < word.length();i++) {
           set.add(word.charAt(i));
       }
       if(set.size() != word.length()) {
           throw new IllegalArgumentException("게임 종료");
       }
       return true;
   }

   public static boolean isDigitCharInString(String word, int index) throws IllegalArgumentException {
       if(!Character.isDigit(word.charAt(index))) {
           throw new IllegalArgumentException("게임 종료");
       }
       return true;
   }
}
