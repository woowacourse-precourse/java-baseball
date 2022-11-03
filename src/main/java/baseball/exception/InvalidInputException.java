package baseball.exception;

public class InvalidInputException{

	private static final String SIZE_ERROR = "세 자리수를 입력해주세요";
	private static final String CONVET_RERROR = "숫자만 입력해주세요";
	private static final String DUPLICATE_ERROR = "각 자리수가 다르게 입력해주세요";
	private static final String NUMBER_ERROR = "각 자리수의 범위를 맞춰주세요";

	public static void sizeError(){
		throw new IllegalArgumentException(SIZE_ERROR);
	}
	public static void convertError(){
		throw new IllegalArgumentException(CONVET_RERROR);
	}
	public static void duplicateError(){
		throw new IllegalArgumentException(DUPLICATE_ERROR);
	}

	public static void numberError(){
		throw new IllegalArgumentException(NUMBER_ERROR);
	}


}
