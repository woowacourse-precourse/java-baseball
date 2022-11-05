package baseball.Domain;

public class ThrowBall {
   private char firstCount;
   private char secondCount;
   private char thirdCount;

   public void threeThrow(String input)
   {
      firstCount = input.charAt(0);
      secondCount = input.charAt(1);
      thirdCount = input.charAt(2);
   }
}
