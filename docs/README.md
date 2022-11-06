# 숫자야구게임 기능목록

- Integer List화 기능(IntegerToList): Integer의 각 자릿수를 List에 저장하여 반환
- 입력값 예외 확인/처리 기능(checkUserInput): userInput이 서로 다른 세자리수가 아닐 때, IllegalArgumentException 발생
- 숫자야구 판단 기능(playball): 입력값과 답을 비교하여 스트라이크, 볼 개수를 map으로 반환
- 숫자야구 결과 출력 기능(printResult): 위 판단 결과를 출력할 String 반환
- 숫자야구 한 판 구동 기능(playOneGame): 3스트라이크가 나올 때까지 userInput으로 숫자야구 진행하여 결과 출력, 매번 입력값이 들어올 때마다 유효한 값이 입력되었는 지 확인
- 랜덤 answer 생성 기능(determineAnswer): 서로 다른 3개의 숫자를 random으로 골라 세자릿수로 합쳐서 반환 
- 게임 진행 및 다시시작 기능(main): answer를 생성하고 게임 한 판을 진행한다. gameStarter로 게임을 계속 진행할 지 결정할 수 있다.