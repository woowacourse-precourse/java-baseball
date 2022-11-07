package baseball;

public class Validator {
    
    private static boolean checkLength(String input){
        if(input.length()!=3)return false;
        return true;
    }

    private static boolean checkDigit(String input){
        int l = input.length();

        for(int i=0; i<l; i++){
             if(!Character.isDigit(input.charAt(i)))return false;
        }
        return true;
    }

    private static boolean checkRange(String input){
        int l = input.length();
        int c;
        for(int i=0; i<l; i++){
            c=Character.getNumericValue(input.charAt(i));
            if(c<1||c>9)return false;
        }
        return true;
    }

    private static boolean checkDifferent(String input){
        int l = input.length();
        for(int i=0; i<l-1; i++){
            if(input.substring(i+1,l).indexOf(input.charAt(i)) != -1) return false;
        }
        return true;
    }

    public static boolean checkStart(String input)throws IllegalArgumentException{
        if(checkLength(input)
                &&checkDigit(input)
                &&checkRange(input)
                &&checkDifferent(input))return true;
        throw new IllegalArgumentException();
    }

    public static boolean checkEndInput(String input) throws IllegalArgumentException{
        if(input.equals("1")||input.equals("2"))return true;
        throw new IllegalArgumentException();
    }
}
