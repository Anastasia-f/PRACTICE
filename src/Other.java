import java.sql.*;
import java.math.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Other {
    private Statement statement;
    public Other(Statement stmt) {

        statement = stmt;
    }
    public void select() {
        try {
            String sql = "SELECT * FROM public.other l ORDER BY l.id";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int lot_id = rs.getInt("lot_id");

                System.out.print("ID: " + id);
                System.out.print(", name: " + name);
                System.out.print(", lot_id: " + lot_id);
               }
            rs.close();
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
    public void insert() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("name: ");
        System.out.print("lot_id:");

        String name = scanner.nextLine();
        int lot_id = scanner.nextInt();
        try {
            String sql;
            sql = "INSERT INTO public.other (name, lot_id)\n" +
                    String.format("VALUES ('%s',%d);", name, lot_id);
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
            sql = "DELETE FROM public.other\n " +
                    "WHERE id = " + ID;
            statement.executeUpdate(sql);

        } catch (Exception error) {
            error.printStackTrace();
        }
    }
    public void update(){
        Scanner scanner = new Scanner(System.in);
        new Scanner(System.in);
        System.out.print("input new name and id: ");
        String name = scanner.nextLine();
        int ID = scanner.nextInt();

        try{
            String sql = "UPDATE public.other SET name = ' " + name + " ' WHERE id = " + ID;
            statement.executeUpdate(sql);

        } catch (Exception error) {
            error.printStackTrace();
        }
    }
}

