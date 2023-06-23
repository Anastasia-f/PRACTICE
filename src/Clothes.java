import java.sql.Statement;
import java.sql.*;
import java.math.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Clothes {
    private Statement statement;

    public Clothes(Statement stmt) {

        statement = stmt;
    }

    public void insert() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("brand: ");
        System.out.print("material:");
        System.out.print("size: ");
        System.out.print("lot_id: ");

        String brand = scanner.nextLine();
        String material = scanner.nextLine();
        int size = scanner.nextInt();
        int lot_id = scanner.nextInt();
        try {
            String sql;
            sql = "INSERT INTO public.clothes (brand, material, size, lot_id)\n" +
                    String.format("VALUES ('%s', '%s', %d, %d);", brand, material,size, lot_id);

            statement.executeUpdate(sql);
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
    public void select() {
        try {
            String sql = "SELECT * FROM public.clothes l ORDER BY l.id";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String brand = rs.getString("brand");
                String material = rs.getString("material");
                int size = rs.getInt("size");
                int lot_id = rs.getInt("lot_id");

                System.out.print("ID: " + id);
                System.out.print(", brand: " + brand);
                System.out.print(", material: " + material);
                System.out.print(", size: " + size);
                System.out.print(", lot_id: " + lot_id);

            }
            rs.close();
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
            sql = "DELETE FROM public.clothes\n " +
                    "WHERE id = " + ID;
            statement.executeUpdate(sql);
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
    public void update(){
        Scanner scanner = new Scanner(System.in);
        new Scanner(System.in);
        System.out.print("input new size and id: ");
        int size = scanner.nextInt();
        int ID = scanner.nextInt();
        try{

            System.out.println("Creating statement...");
            String sql = "UPDATE public.clothes SET size = " + size + "WHERE id = " + ID;
            statement.executeUpdate(sql);

        } catch (Exception error) {
            error.printStackTrace();
        }
    }
}