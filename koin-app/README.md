# Koin - APP

- [Koin](https://insert-koin.io/) 을 활용하여 DI 를 적용한 샘플 앱입니다.
- [Koin Tutorial](https://insert-koin.io/docs/quickstart/android) 을 참고하여 구현하였습니다.
- [Koin Test](https://insert-koin.io/docs/reference/koin-test/testing) 를 참고해서 테스트했습니다.
- [Robolectric - AndroidX Test](https://robolectric.org/androidx_test/) 를 활용하여 Instrument Test 했습니다.
# 기능 요구 사항

## Step 1
- [x] CartRepository 는 앱 전체 LifeCycle 동안 유지되도록 구현한다.
- [x] ProductRepository 는 앱 전체 LifeCycle 동안 유지되도록 구현한다.
- [x] DateFormatter 는 앱 전체 LifeCycle 동안 유지되도록 구현한다.

---

## Step 2
- [x] 액티비티 컨택스트를 활용해서 DateFormatter 를 생성하도록 구현한다. (Application Context 사용이 더 바람직하나 연습을 위해~)
- [x] DateFormatter 는 Activity LifeCycle 동안 유지되도록 구현한다.
- [x] DateFormatter 는 Configuration Changes 에도 살아남을 수 있도록 구현한다.
- [x] CartRepository 는 ViewModel LifeCycle 동안 유지되도록 구현한다.


# 연습 후기
### 장점)
- ⭐️⭐️ 빌드시간에 영향을 안준다. (Hilt 는 빌드 타임에 코드가 생성돼서 빌드시간이 늘어나서 짜증나는데 이건 진짜 좋은듯)
- ⭐️⭐️ 공식 문서가 진짜 가독성 있게 잘 정리되어 있어 쉽게 따라할 수 있었다.
- ⭐️⭐️ Test 도 진짜 쉬움
- ⭐️ Only Kotlin 인 점이 장점인듯
- 에러 발생시 Debugger 가 잘 동작해서 에러 로깅이 쉬움 (Hilt 는 진짜 알아보기 힘들다)
- Hilt 처럼 KSP 를 활용 해서 빌드 타임에 코드를 만드는 방식도 있었음

### 단점)
- 🚨🚨🚨  런타임에 DI가 동작하기 때문에 실수하면 앱이 죽는다 -> Test 코드가 진짜 필수 일듯
- 🚨🚨 같은 Activity 만드려면 각 Activity 마다 ScopeID 를 다르게 해줘야함 (이게 진짜 불편함...)
- 🚨🚨 Scope Component 가 진짜 짜증난다 🔥
  좀 더 딥하게 얘기하자면, ViewModel 의 생명주기를 따르는 레포지토리를 만들고, Activity 에서 by ViewModel() 에 넘겨주고 싶었는데
  불가능함. ViewModel 내부에 서비스 로케이터 패턴으로 레포지토리를 가져오는 방식으로 해결해야함 😨
  Hilt 는 Android Scope 를 좀 더 친절하게 지원해주는듯~
- 🚨 좀 심화된 내용은 한국 Reference 가 거의 없었다


### 결론)
그래서 뭐가 더 나음??을 한 번 더 고민해봤을 때 Hilt 가 더 쉽고 좋은 거 같다.
근데 Hilt 를 Koin 처럼 아직 심화된 개념을 적용해본 적이 없어서.. 확답은 못하겠다.
Hilt 테스트도 좀 해봐야 확실히 정할 수 있을 것 같다!!