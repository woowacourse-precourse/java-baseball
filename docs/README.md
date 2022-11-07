## :pencil:  기능 목록
- computer에서 랜덤 숫자 3개를 list에 담는다.
- user가 입력한 input값을 검사한 다음 list에 담는다.
- user와 computer를 비교한다.
- 결과를 출력한다.
- user가 computer의 랜덤숫자 3개를 모두 맞춘 경우 새 게임 혹은 게임종료를 선택한다.
- 맞추지 못한 경우 다시 user의 입력값을 받는다.
- 예외처리
	- user의 입력값의 길이가 3이 아닌 경우 IllegalArgumentException 처리
	- user의 입력값 중에서 중복된 숫자가 있는 경우 IllegalArgumentException 처리
	- user의 입력값 중에서 0을 입력했을 경우 IllegalArgumentException 처리
	- user의 입력값이 숫자가 아닌 값을 입력했을 경우 NumberFormatException 처리
	- 새게임은 1, 게임 종료는 2말고 다른 값을 입력한 경우 IllegalArgumentException 처리
	

