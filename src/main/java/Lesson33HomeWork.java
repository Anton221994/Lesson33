import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lesson33HomeWork {

    //Домашнее задание
    //добавить 5 манагеров +
    //1)проставить для всех пользоватлей сумму, которую они потратили+
    //2)сделать отдельную функцию для добавления данных в таблицы манагер и юзер+
    // 3)связать между собой манагеров и юзеров, сумма у менеджера равна, той сумме, которую потратили все его клиенты
    //4) сделать возможность обновления суммы у конкретного пользователся+
    //домашку закинуть на гит и прописать примеры работы в файле readme

    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String user = "postgres";
    private static final String password = "7193";

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement = null;

        connection = DriverManager.getConnection(url, user, String.valueOf(password));
        statement = connection.createStatement();
        ResultSet resultSet;
        String query = "SELECT * FROM manager160 WHERE sum = (SELECT sum FROM ov160 where manager_id IN (SELECT id FROM ov160))";
        resultSet = statement.executeQuery(query);

        List<Manager> list = new ArrayList<>();
        while (resultSet.next()) {
            Manager manager = new Manager();
            manager.setId(resultSet.getLong(1));
            manager.setName(resultSet.getString(2));
            manager.setDept(resultSet.getInt(3));
            manager.setSum(resultSet.getInt(4));

            list.add(manager);
        }
        System.out.println(list);

//        addManager(statement);
//        setUserSum(statement);
//        setUserData(statement);
//        updateUserSum(statement);


    }

    public static void addManager(Statement statement) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name manager");
        String nameManager = scanner.nextLine();
        System.out.println("Enter dept of manager");
        int deptOfManager = scanner.nextInt();

        String sql = "insert into manager160 (first_name, dept) values " +
                "('" + nameManager + "' , '" + deptOfManager + "')";
        statement.execute(sql);

    }

    public static void setUserSum(Statement statement) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter sum for User");
        int sum = scanner.nextInt();
        String sql = " insert into ov160 (sum) values " + "('" + sum + "')";
        statement.execute(sql);
    }

    public static void setUserAndManagerData(Statement statement) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter firstName for User ");
        String firstNameUser = scanner.nextLine();
        System.out.println("Enter lastName for User");
        String lastNameUser = scanner.nextLine();
        System.out.println("Enter age for User");
        int ageUser = scanner.nextInt();
        System.out.println("Enter managerId for User");
        int managerIdForUser = scanner.nextInt();
        System.out.println("Enter sum for User");
        int sumUser = scanner.nextInt();
        String sql = "insert into ov160(first_name,last_name,age,manager_id,sum) values" +
                "('" + firstNameUser + "','" + lastNameUser + "','" + ageUser + "', " +
                "'" + managerIdForUser + "', '" + sumUser + "')";
        statement.execute(sql);
        System.out.println("Enter manager firstName");
        String nameManager = scanner.nextLine();
        System.out.println("Enter manager dept");
        int dept = scanner.nextInt();
        String sql1 = "insert into ov160(first_name, dept) values" +
                "('" + nameManager + "','" + dept + "')";
        statement.execute(sql1);


    }

    public static void updateSumForUser(Statement statement) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id user");
        long idUser = scanner.nextInt();
        System.out.println("Enter new sum for user");
        int sum = scanner.nextInt();
        String sql = "update ov160 set sum = '" + sum + "' where id ='" + idUser + "'";
        statement.execute(sql);


    }


}
