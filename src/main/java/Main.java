import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private final static String url = "jdbc:postgresql://localhost:5432/postgres";
    private final static String username = "postgres";
    private final static String password = "7193";

    public static void main(String[] args) throws Exception {
        Connection connection = null;
        Statement statement = null;

        connection = DriverManager.getConnection(url, username, String.valueOf(password));
        statement = connection.createStatement();

        //создание таблицы
//        statement.executeUpdate("create table ov160 ( " +
//                "id serial primary key," +
//                "first_name varchar(50)," +
//                "last_name varchar(50)," +
//                "age int)");


        // Задание 1 :вводим с консоли данные человека и с помощью инсерт запроса создаем запись в таблице
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter name");
//        String name = scanner.nextLine();
//        System.out.println("Enter lastname");
//        String lastName = scanner.nextLine();
//        System.out.println("Enter age");
//        int age = scanner.nextInt();

//        String query = "insert into ov160 (first_name, last_name, age) values " +
//                "('" + name + "', '" + lastName + "', " + age + ")";
//        statement.execute(query);


        //Извлекаем данные из таблицы SQL.(Делаем запрос в БД, делаем класс User с одинаковыми полями что и в БД,
        // извлекаем данные и помещаем их в Arraylist.
//        String query = "select * from ov160";
//        ResultSet resultSet;
//        resultSet = statement.executeQuery(query);
//
//        // 1 способо вывода информации
//        while(resultSet.next()){
//            System.out.println(resultSet.getString(2));
//        }

        //2 способ вывода информации

//        List<User> list = new ArrayList<>();
//        while (resultSet.next()) {
//            User user = new User();
//            user.setId(resultSet.getLong(1));
//            user.setAge(resultSet.getInt(4));
//            user.setName(resultSet.getString(2));
//            user.setLastName(resultSet.getString(3));
//
//            list.add(user);
//        }
//
//        System.out.println(list);


//        // Задание 2 добавить в таблицу еще 5 юзеров, сделать поиск по юзера по имени и фамилии,
//        поиск юзеров с клавиатуры

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter name");
//        String name = scanner.nextLine();
//        System.out.println("Enter lastName");
//        String lastName = scanner.nextLine();
//
//        String query1 = "select * from ov160 where first_name = '" + name + "' and " + "last_name = '"+lastName+"'";
//        ResultSet resultset;
//        resultset = statement.executeQuery(query1);
//        List<User> list = new ArrayList<>();
//
//        while(resultset.next()){
//            User user = new User();
//            user.setId(resultset.getLong(1));
//            user.setName(resultset.getString(2));
//            user.setLastName(resultset.getString(3));
//            user.setAge(resultset.getInt(4));
//
//            list.add(user);
//
//        }
//        System.out.println(list);

        //Задание 3: Найти всех пользователей которые удовлетворяют следующим условиям. Минимальный возраст,
        // и максимальный возраст, ввод с клавиатуры, найти все пользователей которые подходя в этот диапазон.

//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter minAge");
//        int firstNumber = scanner.nextInt();
//        System.out.println("Enter maxAge");
//        int secondNumber = scanner.nextInt();
//
//        String query = "select * from ov160 where age >= " + firstNumber + "and age <= " + secondNumber;
//
//        ResultSet resultSet;
//        resultSet = statement.executeQuery(query);
//
//        List<User> list = new ArrayList<>();
//        while (resultSet.next()) {
//            User user = new User();
//            user.setId(resultSet.getLong(1));
//            user.setAge(resultSet.getInt(4));
//            user.setName(resultSet.getString(2));
//            user.setLastName(resultSet.getString(3));
//
//            list.add(user);
//        }
//
//        System.out.println(list);


        // Задание 5: создать таблицу manager 160 c колонками  id, имя , dept, sum
//        statement.executeUpdate(" create table manager160(" +
//                "id primary serial key " +
//                "first_name varchar(50)" +
//                "dept int " +
//                "sum int ");
        // дополнили таблицу ov160 колонкой (manager_id)
//        statement.executeUpdate("alter table ov160 add column manager_id int");
//        statement.executeUpdate("alter table ov160 add column sum int");


        //Домашнее задание
        //добавить 5 манагеров
        //statement.executeUpdate("update ov160 set last_name = 'petrov' where id = 1");
        //1)проставить для всех пользоватлей сумму, которую они потратили
        //2)сделать отдельную функцию для добавления данных в таблицы манагер и юзер
        // 3)связать между собой манагеров и юзеров, сумма у менеджера равна, той сумме, которую потратили все его клиенты
        //4) сделать возможность обновления суммы у конкретного пользователся
        //домашку закинуть на гит и прописать примеры работы в файле readme

    }



}