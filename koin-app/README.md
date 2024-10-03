# Koin - APP

- [Koin](https://insert-koin.io/) 을 활용하여 DI 를 적용한 샘플 앱입니다.
- [Koin Tutorial](https://insert-koin.io/docs/quickstart/android) 을 참고하여 구현하였습니다.

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
- [ ] ProductRepository 는 CartActivity, ProductActivity 사이에 공유되도록 구현한다.
- [ ] CartRepository 는 ViewModel LifeCycle 동안 유지되도록 구현한다.