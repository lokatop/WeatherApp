# WeatherApp
My Weather App

Использованные технологии: retrofit2,rxJava2,Moxy2(В сочетании с AndroidX)

Приложение о погоде.
Что реализовано:
1) Взаимодействие с Api сайта https://developer.accuweather.com/ (retrofit)
2) AutoCopleteText(поиск города -> Показывает в поиске город и страну)(RxJava+retrofit)
3) Загрузка текущих данных о погоде в городе(RxJava+retrofit)
4) Сохранение состояния при повороте экрана или иной смене конфигурации экрана (Moxy)
5) Реализован архитектурный подход Mvp

Что будет реализовано в ближайшее время:
1) Кэширование в БД с использованием библиотеки Room для его использования при отсутствии интернет соединения.
