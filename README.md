# TaskTracker

Это бэкенд приложения для управления задачами, на данный момент реализован класс TaskManager, который позволяет управлять задачами.  

Задачи имеют три типа:
* Task
* Epic
* SubTask

Все задачи имеют текущий статус, статусов может быть три:
* NEW - новая, это первый статус, дается задаче автоматически при создании
* IN_PROGRESS - в работе, этот статус присваивается вручную, когда задача берется в работу
* DONE - завершена, это конечный статус задачи, он присваивается вручную когда задача закрывается

Каждая задача имеет уникальный id, которым управляет TaskManager, id присваивается задаче в момент её добавления в хранилище, то есть у новых объектов типа Эпик, Задача, Подзадача при создании id=null, это означает что при обновлении задачи (update) необходимо явным образом добавить ей id существующей задачи. 

## Task
Task - обычная задача, это основной тип задач, задача не может входить в Epic.


## Epic
Epic - эпик (большая задача), которая может содержать в себе SubTask задачи.
Эпик нельзя удалить, если в нём есть подзадачи, сначала нужно удалить сами подзадачи

## SubTask
SubTask - подзадача задачи Task, подзадача не может быть сама по себе, это всегда часть Epic.
Чтобы добавить подзадачу, необходимо создать её указав в конструкторе эпик.


___
(с) Приложение написано на java в рамках обучения Яндекс.Практика