package baseball;

public class Validation {

        public static <T>void validation(String validation_case,T validation_param){
                if (validation_case.equals("user_input_number_validation")&&validation_param instanceof String){
                        String user_input_number = (String) validation_param;

                        boolean user_input_number_regex_match = user_input_number.matches("^[^0-9]*$");
                        boolean user_input_number_length = user_input_number.length() != 3;

                        if (user_input_number_length||user_input_number_regex_match) {
                                throw new IllegalArgumentException("non-numeric value entered");
                        }
                }
        }
}
