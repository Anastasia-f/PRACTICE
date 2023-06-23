// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
import java.sql.*;
import java.math.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Lot {
    private Statement statement;

    public Lot(Statement stmt) {

        statement = stmt;
    }

    public void select_with_join() {

        try {
            String sql = "SELECT l.id as lot_id, \n" +
                    "\tl.starting_date,\n" +
                    "\tl.closing_date, \n" +
                    "\tl.starting_price,\n" +
                    "\tb.price,\n" +
                    "\tb.bidding_date,\n" +
                    "\tl.brief_info, \n" +
                    "\tl.\"name\",\n" +
                    "\tu.id as user_id,\n" +
                    "\tu.first_name,\n" +
                    "\tu.last_name,\n" +
                    "\tu.email\n" +
                    "FROM public.lot l\n" +
                    "JOIN public.\"user\" u ON l.owner_id = u.id\n" +
                    "JOIN public.bidhistory b ON l.id = b.lot_id\n" +
                    "ORDER BY l.id";
            ResultSet rs = statement.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("lot_id");
                String starting_date = rs.getString("starting_date");
                String closing_date = rs.getString("closing_date");
                double starting_price = rs.getDouble("starting_price");
                double price = rs.getDouble("price");
                String bidding_date = rs.getString("bidding_date");
                String brief_info = rs.getString("brief_info");
                String name = rs.getString("name");
                int user_id = rs.getInt("user_id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String email = rs.getString("email");

                System.out.print("ID: " + id);
                System.out.print(", starting_date: " + starting_date);
                System.out.print(", closing_date: " + closing_date);
                System.out.print(", starting_price: " + starting_price);
                System.out.print(", price: " + price);
                System.out.print(", bidding_date: " + bidding_date);
                System.out.print(", brief_info: " + brief_info);
                System.out.print(", name: " + name);
                System.out.print(", user_id: " + user_id);
                System.out.print(", first_name: " + first_name);
                System.out.print(", last_name: " + last_name);
                System.out.println(", email: " + email);
            }
            rs.close();
        } catch (Exception error) {
            error.printStackTrace();
        }

    }

    public void insert() {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner_1 = new Scanner(System.in);
        System.out.print("starting_date: ");
        System.out.print("closing_date:");
        System.out.print("starting_price: ");
        System.out.print("step: ");
        System.out.print("brief_info: ");
        System.out.print("status_name: ");
        System.out.print("name: ");
        System.out.print("item_type: ");
        System.out.print("owner_id: ");

        String starting_date = scanner.nextLine();
        String closing_date = scanner.nextLine();
        int starting_price = scanner.nextInt();
        int step = scanner.nextInt();
        scanner.nextLine();
        String brief_info = scanner.nextLine();
        String status_name = scanner.nextLine();
        String name = scanner.nextLine();
        String item_type = scanner.nextLine();
        int owner_id = scanner.nextInt();

        try {
            String sql;
            sql = "INSERT INTO public.lot (starting_date, closing_date, starting_price, step, brief_info, status_name, \"name\", item_type, owner_id)\n" +
                    String.format("VALUES ('%s', '%s', %d, %d, '%s', '%s', '%s', '%s', %d);", starting_date, closing_date, starting_price, step, brief_info, status_name, name, item_type, owner_id);
            statement.executeUpdate(sql);
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    public void select() {
        try {
            String sql = "SELECT * FROM public.lot l ORDER BY l.id";
            ResultSet rs = statement.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                String starting_date = rs.getString("starting_date");
                String closing_date = rs.getString("closing_date");
                double starting_price = rs.getDouble("starting_price");
                double step = rs.getDouble("step");
                String brief_info = rs.getString("brief_info");
                String status_name = rs.getString("status_name");
                String name = rs.getString("name");
                String item_type = rs.getString("item_type");
                String owner_id = rs.getString("owner_id");

                System.out.print("ID: " + id);
                System.out.print(", name: " + name);
                System.out.print(", starting_date: " + starting_date);
                System.out.print(", closing_date: " + closing_date);
                System.out.print(", starting_price: " + starting_price);
                System.out.print(", step: " + step);
                System.out.print(", brief_info: " + brief_info);
                System.out.print(", status_name: " + status_name);
                System.out.print(", item_type: " + item_type);
                System.out.println(", owner_id: " + owner_id);
            }
            rs.close();
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    public void delete() {
        String sql;
        Scanner scanner = new Scanner(System.in);
        Scanner scanner_1 = new Scanner(System.in);
        System.out.print("input ID: ");
        int ID = scanner.nextInt();
        try {
            System.out.println("Creating statement...");
            sql = "DELETE FROM public.lot\n " +
                    "WHERE id = " + ID;
            statement.executeUpdate(sql);

        } catch (Exception error) {
            error.printStackTrace();
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
            String sql = "UPDATE public.lot SET name = ' " + name + " ' WHERE id = " + ID;
            statement.executeUpdate(sql);
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
}




