## 요구 사항

## 알고리즘 흐름
1. 랜덤한 세 자리 정수 생성
2. 세 자리 정수 입력 받기
<br>
2-1. 입력 형식이 잘못되었을 경우, Exception 발생
3. 입력받은 정수와 각 자릿수 비교 -> strike 수 계산
4. strike 인덱스를 제외한 모든 쌍 비교 -> ball 수 계산
5. 스트라이크, 볼 개수 출력 <br>
5-1. stike가 3개이면, 게임 종료, (1, 2) 중 입력받기 <br>
5-1-1. 1을 입력받았을 경우, continue <br>
5-1-2. 2를 입력받았을 경우, break <br>
5-2. 스트라이크, 볼 개수 출력, continue

## 기능 목록

1. main(): 입출력, 전체적인 프로세스 관리
2. getThreeRandomNumber(): 컴퓨터의 세 자리 수 생성
3. disposeOfInputNumber(): 입력받은 수 처리 후 반환
4. isValidBaseballNumber(): 입력받은 수의 야구 게임 유효성 검증
5. isValidRestartNumber(): 게임 재시작 여부에 대한 입력의 유효성 검증
6. getNumberOfStrikes(): 스트라이크 개수 계산
7. getNumberOfBalls(): 볼 개수 계산
8. disposeOfGameResult(): 점수 계산 후 출력, 상황에 따른 값 반환
9. determineStopOrNot() : 게임이 종료되었을 시, 재시작과 종료를 처리해주는 메서드