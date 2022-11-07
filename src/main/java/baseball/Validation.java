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

        return false;
    }
}
