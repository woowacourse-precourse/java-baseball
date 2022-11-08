> ## Application 구현 Flow
>  > #### Computer Class  
> > > 컴퓨터의 동작을 구현한 Class  
> > > 1. 컴퓨터 입력 생성
> > > - generateTarget() : 중복되지 않는 3자리 수 생성  
> >  #### User Class
> > > 유저의 동작을 구현한 Class
> > > 1. 유저 인풋 받기
> > > 2. 유저 인풋 validation 체크
> > > - getUserInput() : 중복되지 않는 3자리 입력을 받음  
> > > - valid() : 입력받은 값이 유효한지 확인, 유효하지 않으면 Exception 발생
> >  #### Application Class
> > > 전체 게임의 흐름을 구현한 Class  
> > > 1. 스트라이크, 볼 개수 세기
> > > 2. 진행 상황 출력
> > > 3. 새로운 게임 시작 or 게임 종료
> > > - startGame() : 새로운 게임 시작 or 게임 종료
> > > - getStrikeNum() : 스트라이크 개수 세기
> > > - getBallNum() : 볼 개수 세기
> > > - checkSuccesssAndPrintResult() : 3진아웃인지를 확인 + 현재 상황 출력