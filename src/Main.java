// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
import java.sql.*;
import java.util.Scanner;
import java.math.*;
import java.text.DecimalFormat;
import java.time.LocalDateTime;


public class Main {
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost/auction";

    //  Database credentials
    static final String USER = "nastya";
    static final String PASS = "28062002";

    public static int someFunction(){
        Scanner scanner = new Scanner(System.in);
        Scanner scanner_1 = new Scanner(System.in);
        System.out.print("1 - insert: ");
        System.out.print("2 - read: ");
        System.out.print("3 - update: ");
        System.out.print("4 - delete: ");
        System.out.print("Введите значение: ");
        int value_1 = scanner_1.nextInt();
        return value_1;
    }
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");


            Scanner scanner = new Scanner(System.in);
            Scanner scanner_1 = new Scanner(System.in);
            int value_1;

            System.out.print("1 - clothes: ");
            System.out.print("2 - lot: ");
            System.out.print("3 - bidhistory: ");
            System.out.print("4 - car: ");
            System.out.print("5 - user: ");
            System.out.print("6 - image: ");
            System.out.print("7 - lotstatuslog: ");
            System.out.print("8 - other: ");
            System.out.print("9 - review: ");
            System.out.println("10 - joined tables");
            System.out.print("Введите значение: ");
            int value = scanner.nextInt();

            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            Lot lot = new Lot(stmt);

            switch (value) {
                case 1:
                    value_1 = someFunction();
                    Clothes clothes = new Clothes(stmt);
                    switch (value_1) {
                        case 1:
                            clothes.insert();
                            break;
                        case 2:
                            clothes.select();
                            break;
                        case 3:
                            clothes.update();
                            break;
                        case 4:
                            clothes.delete();
                            break;
                    }
                    break;

                case 2:
                    value_1 = someFunction();
                    switch(value_1){
                        case 1:
                            lot.insert();
                            break;
                        case 2:
                            lot.select();
                            break;
                        case 3:
                            lot.update();
                            break;
                        case 4:
                            lot.delete();
                            break;
                    }
                    break;
                case 3:
                    value_1 = someFunction();
                    Bidhistory bidhistory = new Bidhistory(stmt);
                    switch(value_1){
                        case 1:
                            bidhistory.insert();
                            break;
                        case 2:
                            bidhistory.select();
                            break;
                        case 3:
                            bidhistory.update();
                            break;
                        case 4:
                            bidhistory.delete();
                            break;
                    }
                    break;
                case 4:
                    value_1 = someFunction();
                    Car car = new Car(stmt);
                    switch(value_1){
                        case 1:
                            car.insert();
                            break;
                        case 2:
                            car.select();
                            break;
                        case 3:
                            car.update();
                            break;
                        case 4:
                            car.delete();
                            break;
                    }
                    break;
                case 5:
                    value_1 = someFunction();
                    user user = new user(stmt);
                    switch(value_1){
                        case 1:
                            user.insert();
                            break;
                        case 2:
                            user.select();
                            break;
                        case 3:
                            user.update();
                            break;
                        case 4:
                            user.delete();
                            break;
                    }
                    break;
                case 6:
                    value_1 = someFunction();
                    Image image = new Image(stmt);
                    switch(value_1){
                        case 1:
                            image.insert();
                            break;
                        case 2:
                            image.select();
                            break;
                        case 3:
                            image.update();
                            break;
                        case 4:
                            image.delete();
                            break;
                    }
                    break;
                case 7:
                    value_1 = someFunction();
                    Lotstatuslog lotstatuslog = new Lotstatuslog(stmt);
                    switch(value_1){
                        case 1:
                            lotstatuslog.insert();
                            break;
                        case 2:
                            lotstatuslog.select();
                            break;
                        case 3:
                            System.out.print("you cant update log");
                            break;
                        case 4:
                            System.out.print("you cant delete log");
                            break;
                    }
                    break;
                case 8:
                    value_1 = someFunction();
                    Other other = new Other(stmt);
                    switch (value_1) {
                        case 1:
                            other.insert();
                            break;
                        case 2:
                            other.select();
                            break;
                        case 3:
                            other.update();
                            break;
                        case 4:
                            other.delete();
                            break;
                    }
                    break;
                case 9:
                    value_1 = someFunction();
                    Review review = new Review(stmt);
                    switch(value_1){
                        case 1:
                            review.insert();
                            break;
                        case 2:
                            review.select();
                            break;
                        case 3:
                            review.update();
                            break;
                        case 4:
                            review.delete();
                            break;
                    }
                    break;
                case 10:
                    lot.select_with_join();
                    return;
                default:
                    System.out.println("Вы ввели другое значение");
            }
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("bye!");
    }
}






