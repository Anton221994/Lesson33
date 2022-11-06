import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lesson33HomeWork {

    //Äîìàøíåå çàäàíèå
    //äîáàâèòü 5 ìàíàãåðîâ +
    //1)ïðîñòàâèòü äëÿ âñåõ ïîëüçîâàòëåé ñóììó, êîòîðóþ îíè ïîòðàòèëè+
    //2)ñäåëàòü îòäåëüíóþ ôóíêöèþ äëÿ äîáàâëåíèÿ äàííûõ â òàáëèöû ìàíàãåð è þçåð+
    // 3)ñâÿçàòü ìåæäó ñîáîé ìàíàãåðîâ è þçåðîâ, ñóììà ó ìåíåäæåðà ðàâíà, òîé ñóììå, êîòîðóþ ïîòðàòèëè âñå åãî êëèåíòû
    //4) ñäåëàòü âîçìîæíîñòü îáíîâëåíèÿ ñóììû ó êîíêðåòíîãî ïîëüçîâàòåëñÿ+
    //äîìàøêó çàêèíóòü íà ãèò è ïðîïèñàòü ïðèìåðû ðàáîòû â ôàéëå readme

    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String user = "postgres";
    private static final String password = "7193";

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement = null;

        connection = DriverManager.getConnection(url, user, String.valueOf(password));
        statement = connection.createStatement();

       addManager(statement);
       setUserSum(statement);
       setUserAndManagerData(statement);
       updateSumForUser(statement);


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
