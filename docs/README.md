## 기능 명세서

### Game
실제 게임을 시작하는 클래스
1. 재시작/종료를 구분하는 기능

### GameEngine
애플리케이션으로부터 게임을 시작시키는 클래스

### Ball
스트라이크와 볼을 갖고 있는 클래스

### StrikeBallUtil
스트라이크와 볼과 관련된 유틸리티 클래스
1. Strike와 Ball의 개수를 구하기
2. 스트라이크와 볼의 개수를 출력하는 기능

### RandomNumberGeneratorUtil
랜덤으로 숫자를 만드는 유틸리티 클래스
1. Computer가 랜덤으로 세 개의 숫자 만들기

### InputNumberUtil
사용자가 숫자를 입력하는 유틸리티 클래스
1. User가 세 개의 숫자를 입력
2. User가 게임을 새로 시작할지 종료하는지 결정하는 숫자 입력

### UserValidator
User 입력 값에 대한 유효성 검사를 하는 유틸리티 클래스
1. 재시작 번호 유효성 검사
2. 세 개의 숫자를 입력할 때 0이 아닌 서로 다른 3개 숫자인지 유효성 검사

### BaseballConstant
상수들을 저장하는 추상 클래스
