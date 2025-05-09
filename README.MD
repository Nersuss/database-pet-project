# Приложуха на PostgreSQL

**Как собрать проект:**
1. Склонировать или скачать реп **(git clone)**

2. Создать базу данных в **Postgres**

3. Заменить логин и пароль от **Postgres**\
Файл **application.yml**
- datasource:
    - url: jdbc:postgresql://localhost:5432/pay-system
    - username: postgres
    - password: postgres
4. Запустить **ActiveMQ**
5. Заменить логин и пароль от **ActiveMQ**
Файл **application.yml**
- activemq:
  - url: http://127.0.0.1:8161
  - user: admin
  - password: admin
