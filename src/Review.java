import java.sql.*;
import java.math.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Review {
    private Statement statement;

    public Review(Statement stmt) {

        statement = stmt;
    }

    public void select(){
        try{
            String sql = "SELECT * FROM public.review u ORDER BY u.id";
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {

                int id = rs.getInt("id");
                String text = rs.getString("text");
                String date = rs.getString("date");
                int user_id = rs.getInt("user_id");


                System.out.print("ID: " + id);
                System.out.print(", text: " + text);
                System.out.print(", date: " + date);
                System.out.print(", user_id: " + user_id);
            }
            rs.close();
        } catch(Exception error){
            error.printStackTrace();
        }
    }

    public void insert()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("text: ");
        System.out.print("date:");
        System.out.print("user_id: ");
        String text = scanner.nextLine();
        String date = scanner.nextLine();
        int user_id = scanner.nextInt();
        try {
            String sql;
            sql = "INSERT INTO public.review (text, date, user_id)\n" +
                    String.format("VALUES ('%s', '%s', %d);", text, date, user_id);
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
            sql = "DELETE FROM public.review\n WHERE id = " + ID;
            this.statement.executeUpdate(sql);
        } catch (Exception var3) {
            var3.printStackTrace();
        }
    }

    public void update() {
        Scanner scanner = new Scanner(System.in);
        new Scanner(System.in);
        System.out.print("input new text and id: ");
        String text = scanner.nextLine();
        int ID = scanner.nextInt();

        try {
            System.out.println("Creating statement...");
            String sql = "UPDATE public.review SET text = ' " + text + " ' WHERE id = " + ID;
            statement.executeUpdate(sql);
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }
}