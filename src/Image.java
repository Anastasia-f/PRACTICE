import java.sql.*;
import java.math.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Image {
    private Statement statement;

    public Image(Statement stmt) {

        statement = stmt;
    }

    public void select() {
        try {
            String sql = "SELECT * FROM public.image i ORDER BY i.lot_id";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String data = rs.getString("data");
                int lot_id = rs.getInt("lot_id");

                System.out.print("ID: " + id);
                System.out.print(", name: " + name);
                System.out.print(", data : " + data);
                System.out.println(", lot_id: " + lot_id);
            }

            rs.close();
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    public void insert() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("name: ");
        System.out.print("data:");
        System.out.print("lot_id: ");

        String name = scanner.nextLine();
        String data = scanner.nextLine();
        int lot_id = scanner.nextInt();
        try {
            String sql;
            sql = "INSERT INTO public.image(name, data, lot_id)\n" +
                    String.format("VALUES ('%s', '%s', %d);", name, data, lot_id);
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
            sql = "DELETE FROM public.image\n WHERE id = " + ID;
            this.statement.executeUpdate(sql);
        } catch (Exception var3) {
            var3.printStackTrace();
        }
    }

    public void update() {
        Scanner scanner = new Scanner(System.in);
        new Scanner(System.in);
        System.out.print("input new name and id: ");
        String name = scanner.nextLine();
        int ID = scanner.nextInt();
        try {
            System.out.println("Creating statement...");
            String sql = "UPDATE public.image SET name = ' " + name + " ' WHERE id = " + ID;
            statement.executeUpdate(sql);
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }
}