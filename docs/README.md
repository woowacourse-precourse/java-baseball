# 🔗 기능 목록
## 1. Application ✅
### main
    - BaseBallGame 객체 생성
    - logic 실행 (예외 발생 시 catch)

## 2. BaseBallGame ✅
### logic / getResult / printResult
    - Computer, User 객체 생성 후 게임 시작
    - user로부터 입력 받기 (예외 발생 시 catch)
    - user의 입력 결과 계산
    - user의 입력 결과 출력
    - 정답일 경우, 재시작 의사 묻기

## 3. Computer ✅
### createNumList
    - 컴퓨터의 3자리 숫자 : 1에서 9까지 서로 다른 임의의 수 3개 선택

## 4. User ✅
### createNumList, exceptionCheck
    - 사용자의 3자리 숫자 : 1에서 9까지 서로 다른 임의의 수 3개 선택
    - 잘못된 입력일 경우 예외 처리 (IllegalArgumentException)