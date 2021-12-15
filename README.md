# Лабораторная работа №6
## Тема:
Настройки и состояние приложения.
## Цель:
Научиться сохранять данные при изменении ориентации смартфона.
## Задания:
1.	Разработать мобильное приложение для сохранения данных из полей;
## Порядок выполнения:
1.Создадим проект. Добавим 2 кнопки, TextView и поле EditText.  
![изображение](https://i.imgur.com/ZR9kyrw.png)  
2. Добавим обработчики кнопок:  
![изображение](https://i.imgur.com/XUxBgUE.png)  
3.Добавим следующий код (В методе onSaveInstanseState сохраняем введённые данные. В методе onRestoreInstanceState - восстанавливаем их):
![изображение](https://i.imgur.com/7H7MdLE.png)  
4. Проверим работоспособность. Так как при повороте Activity уничтожается и заново создаётся, проверим сохранение данных поворотом телефона.  
![изображение](https://i.imgur.com/j6qHB0D.png)  
![изображение](https://i.imgur.com/q5ruGkT.png)
