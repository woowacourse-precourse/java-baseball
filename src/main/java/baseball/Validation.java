package baseball;

public class Validation {
    public static <T>boolean validation(String validation_case,T validation_param){
        if (validation_case.equals("user_input_number_validation")&&validation_param instanceof String){
            String user_input_number = (String) validation_param;

            boolean user_input_number_regex_match = user_input_number.matches("^[0-9]*$");
            boolean user_input_number_length = user_input_number.length() == 3;

            if (user_input_number_length&&user_input_number_regex_match) {
                return true;
            }
        }
        else if (validation_case.equals("user_retry_condition_validation")&&validation_param instanceof String){
            String user_input_retry = (String) validation_param;
            boolean retry_regex = user_input_retry.matches("1|2");
            if (!retry_regex){
                return true;
            }
        }
        else if (validation_case.equals("user_input_not_duplication_number")&&validation_param instanceof String){

            String user_input_number = (String) validation_param;
            char[] user_input_array = user_input_number.toCharArray();

            boolean duplication_flag=true;

            for (int i=0;i<user_input_array.length-1;i++){
                duplication_flag = checkDuplicationNumber(user_input_array[i], user_input_array[i + 1], duplication_flag);
            }

            return duplication_flag;
        }

        return false;
    }

    private static boolean checkDuplicationNumber(char now_index_number,char next_index_number,boolean duplication_flag){
        if (now_index_number==next_index_number){
            duplication_flag=false;
        }
        return duplication_flag;
    }
}
