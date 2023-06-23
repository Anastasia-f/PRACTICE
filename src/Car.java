import java.sql.*;
import java.math.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Car {
    private Statement statement;

    public Car(Statement stmt) {

        statement = stmt;
    }
    public void select() {
        try {
            String sql = "SELECT * FROM public.car l ORDER BY l.id";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String brand = rs.getString("brand");
                int manufacture_year = rs.getInt("manufacture_year");
                int mileage = rs.getInt("mileage");
                int engine_volume = rs.getInt("engine_volume");
                int lot_id = rs.getInt("lot_id");

                System.out.print("ID: " + id);
                System.out.print(", brand: " + brand);
                System.out.print(", manufacture_year: " + manufacture_year);
                System.out.print(", mileage: " + mileage);
                System.out.print(", engine_volume: " + engine_volume);
                System.out.print(", lot_id: " + lot_id);
            }
            rs.close();
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
    public void insert() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("brand: ");
        System.out.print("manufacture_year:");
        System.out.print("mileage: ");
        System.out.print("engine_volume: ");
        System.out.print("lot_id: ");

        String brand = scanner.nextLine();
        int manufacture_year = scanner.nextInt();
        int mileage = scanner.nextInt();
        int engine_volume = scanner.nextInt();
        int lot_id = scanner.nextInt();

        try {
            String sql;
            sql = "INSERT INTO public.car (brand, manufacture_year, mileage, engine_volume, lot_id)\n" +
                    String.format("VALUES ('%s', %d, %d, %d, %d);", brand, manufacture_year, mileage, engine_volume, lot_id);
            statement.executeUpdate(sql);
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    public void delete() {
        String sql;
        Scanner scanner = new Scanner(System.in);
        System.out.print("input ID: ");
        int ID = scanner.nextInt();
        try {
            System.out.println("Creating statement...");
            sql = "DELETE FROM public.car\n " +
                    "WHERE id =" + ID;
            statement.executeUpdate(sql);

        } catch (Exception error) {
            //Handle errors for JDBC
            error.printStackTrace();
        }
    }

    public void update(){
        Scanner scanner = new Scanner(System.in);
        new Scanner(System.in);
        System.out.print("input new engine_volume and id: ");
        int engine_volume = scanner.nextInt();
        int ID = scanner.nextInt();
        try{
            String sql = "UPDATE public.car SET engine_volume = "+ engine_volume + " WHERE id = " + ID;
            statement.executeUpdate(sql);
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
}

