## Телеграм бот
##### 1. Окружение
1. Вариант 1
    1. Java 11+
    2. Maven 3.x
    
2. Вариант 2
   1. Docker-compose
##### 2. Установка и запуск
1. Вариант 1
    1. Клонировать репозитори
    ```git clone https://github.com/PoMaHcKu/city-exp```
    2. Открыть любую реализацию командной строки и перейти в директорию с исходным кодом
    3. Собрать проект командой ```mvn clean install```
    4. Запустить программу командой ```java -jar target/city-exp-bot.jar```
   
2. Вариант 2
   1. Выполнить пункты 1 и 2 из варианта 1
   2. Собрать и запустить программу командой ```docker-compose up```
   
##### 3. Использование
   1. Найти в телеграмме бота **@city_expo_bot** с именем **city_expo**
   2. Отправить команду ```/start```
   3. Писать названия белорусских городов
