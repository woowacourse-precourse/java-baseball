package baseball;

public enum GameRules {
	DIGIT_NUMBER(3){
		@Override
		public int getValue() {
			return DIGIT_NUMBER.getValue();
		}
	},
	MINIMUM_NUMBER(1){
		@Override
		public int getValue() {
			return MINIMUM_NUMBER.getValue();
		}
	},
	MAXIMUM_NUMBER(9){
		@Override
		public int getValue() {
			return MAXIMUM_NUMBER.getValue();
		}
	},
	GAME_RESTART(1){
		@Override
		public int getValue() {
			return GAME_RESTART.getValue();
		}
	},
	GAME_END(2){
		@Override
		public int getValue() {
			return GAME_END.getValue();
		}
	};

	GameRules(int code) {
	}

	public abstract int getValue();
}
