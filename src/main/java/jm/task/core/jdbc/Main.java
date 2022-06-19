package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();

        userService.saveUser("Kirill","Ivanov", (byte) 24);
        System.out.println("User с именем – \"Kirill\" добавлен в базу данных");
        userService.saveUser("Bob","Smirnov", (byte) 33);
        System.out.println("User с именем – \"Bob\" добавлен в базу данных");
        userService.saveUser("Anton","Sidorov", (byte) 38);
        System.out.println("User с именем – \"Anton\" добавлен в базу данных");
        userService.saveUser("Tom","Raider", (byte) 24);
        System.out.println("User с именем – \"Tom\" добавлен в базу данных");

        System.out.println(userService.getAllUsers());

        userService.cleanUsersTable();
        userService.dropUsersTable();



    }
}

//    Создание таблицы User(ов)
// Добавление 4 User(ов) в таблицу с данными на свой выбор.
// После каждого добавления должен быть вывод в консоль ( User с именем – name добавлен в базу данных )
//         Получение всех User из базы и вывод в консоль ( должен быть переопределен toString в классе User)
//         Очистка таблицы User(ов)
//         Удаление таблицы