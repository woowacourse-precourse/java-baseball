baseball game

1. 기본생성자 baseball()<br>
		game()
			
2. getRandomNum()
		랜덤번호를 입력받아 해당 값 correct List에 저장
		
3. getUserInputNum()
		유저의 문제를 입력받아 해당 값 tmp_List에 저장
		
4. game()<br>
		게임진행<br>
		getRandomNum()를 통해 랜덤넘버 받은 후 게임 시작
		getUserInputNum을 받은 후
		compare를 통해 비교, 이후 result로 결과값 도출 후
		게임 종료 시 repeatGame()로 반복여부확인
		
5. compare() 
		userNumList, correct를 각각 비교한 후 반환  
		
6. result()
		결과값 확인
		
7. repeatGame()
		게임이 완료된 후 다시 시작할 것인지 확인