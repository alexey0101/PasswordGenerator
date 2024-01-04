### Simple Password Generator

Simple password generator

В сервисе доступен один метод: /api/v1/password/generate. (В ветке dev: /dev/api/v1/password/generate)

Описание методов и примеры использования доступны с помощью Postman коллекции: https://api.postman.com/collections/16525845-e1f15b1b-070c-49cf-bd62-789344f7df5a?access_key=PMAT-01HK044VF5M18M6PEYGSJN3E4Q

Docker-compose файл доступен по ссылке: https://github.com/alexey0101/PasswordGenerator/blob/master/Docker/docker-compose.yml

Для запуска приложения необходимо запустить docker-compose up.
Для разворачивания dev-ветки необходимо изменить переменные route и SPRING_PROFILES_ACTIVE в docker-compose файле на значение "dev"

Для установки порта необходимо установить нужный порт в переменной ports следующим образом: *port*:8080.

Веб интерфейс доступен на главной странице: * host */
