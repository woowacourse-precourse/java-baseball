# 기능목록단위
- (void) startGame
  : 게임 실행
- (ArrayList) createNum
  : 서로다른 임의의 세가지 수 리스트로 반환
- (boolean) isRightNum
  : 길이가 3인 숫자인지 확인
- (int[]) checkingNum
  : 입력값과 결과값 비교하여 결과 반환
- (boolean) isContain
  : 매개변수로 들어온 숫자가 결과값 안에 포함되어있는지 확인
- (boolean) isCorrectPosition
  : 매개변수로 들어온 숫자의 위치데이터가 정답의 숫자 위치데이터와 일치하는지 확인
- (boolean) endGame
  : 입력값 "1"이면 게임 재실행, "2"면 게임 종료