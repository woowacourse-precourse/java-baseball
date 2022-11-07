# 기능 목록

## Target
- (public)본인 객체를 그대로 복사
- (public)index를 입력받아, index에 해당하는 요소를 반환
- (public)element를 입력받아, 해당 element가 list에 존재 여부를 반환
- (public)index를 입력받아, 해당 index에 해당하는 요소를 Check 값으로 변경(이후 탐색이 불가능하게 하기 위함)
- (private)Set을 List로 변경
- (private)1부터 9까지 순서가 보장된 랜덤인 수 3개를 생성

## BallCountGuess
- (public)index를 입력받아, index에 해당하는 요소를 반환
- (public)추측값 리스트를 반환
- (public)index를 입력받아, 해당 index에 해당하는 요소를 Check 값으로 변경(이후 탐색이 불가능하게 하기 위함)

## StrikeAndBallCount
- (public)타겟 값과 추측 값 비교하여 스트라이크 카운트 수 파악, 만약 스트라이크면 해당 요소에 체크 진행
- (public)타겟 값과 추측 값 비교하여 볼 카운트 수 파악
- (public)아웃 여부 판단
- (public)현재 카운트 값을 통해 사용자에게 출력할 문자열로 변환
- (private)스트라이크 카운트를 문자열로 변경하여 stringBuilder에 추가
- (private)볼 카운트를 문자열로 변경하여 stringBuilder에 추가
- (private)낫싱 여부 판단

## GamePlayer
- (public)게임실행, 사용자가 아웃될 때까지 추측 값 입력 요청
- (private)게임오버 여부 판단

## Application
- (public)사용자가 종료 요청을 보내기 전까지 게임을 반복하여 실행
- (private)사용자가 게임 종료 여부 판단

## InputValidator
- (public)재시작 여부 메시지 검증
- (public)추측값 입력 메시지 검증
- (private)메시지에 중복된 값이 있는지를 검증
- (private)메시지를 Character단위로 나눠 Set으로 저장
- (private)메시지 중복 여부를 판단
- (private)메시지가 주어진 Regex에 충족하는지 검증

# 예외 처리 목록
- 추측 값 입력 시 1~9까지 3자리 수를 입력하지 않을 때
- 추측 값에 중복된 값이 있을 때
- 게임 재시작 여부에 1~2인 수를 입력하지 않을 때

# 열거형 목록
- 메시지를 포함한 Enum
  - 게임 시작시 메시지
  - 숫자 입력 요청 메시지
  - 게임 종료시 메시지
- 볼카운트에 대한 Enum
  - 스트라이크
  - 볼
  - 낫싱
- 메시지 검증에 대한 Enum
  - 추측 값 입력값 Regex
  - 재시작 요청 입력값 Regex
