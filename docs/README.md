## ⚙️ 기능 목록
### 🏁 시작 : gameStart()
> 1. 숫자 생성 : buildTarget()
> 2. 시작 문구 출력 : gameStart()
>   * 프로그램 시작 시에만 출력

### ⚾️ 진행 : swing()
> 1. 사용자로부터 예측 값 입력 받기 : inputSwing()
>   * 입력한 수가 조건을 만족하는지 판별, 잘못된 값일 경우 IllegalArgumentException 발생
> 2. 판정 : judge()
>   * 스트라이크 판정 : judgeStrike()
>   * 볼 판정 : judgeBall()
> 3. 출력 : showBallCount()
>    * judge()에서 얻은 볼카운트를 출력
>    * 3스트라이크일 경우 '종료' 페이즈 시행

### 🧹 종료 : gameEnd()
> 1. 종료 메세지 출력 : outputMessage()
> 2. 재시작 : restart()
>    * 재시작 여부를 입력 받음 : confirm()
>    * confirm()이 1일 경우 '시작' 페이즈로, 2일 경우 종료
