import java.sql.*;
import java.math.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Lotstatuslog {
    private Statement statement;
    public Lotstatuslog(Statement stmt) {

        statement = stmt;
    }
    public void select() {
        try {
            String sql = "SELECT * FROM public.lotstatuslog i ORDER BY i.lot_id";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                int lot_prev_status = rs.getInt("lot_prev_status");
                int lot_new_status = rs.getInt("lot_new_status");
                String change_date = rs.getString("change_date");
                int lot_id = rs.getInt("lot_id");

                System.out.print("ID: " + id);
                System.out.print(", lot_prev_status: " + lot_prev_status);
                System.out.print(", lot_new_status : " + lot_new_status);
                System.out.print(", change_date: " + change_date);
                System.out.print(", lot_id: " + lot_id);
            }

            rs.close();
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    public void insert() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("lot_prev_status: ");
        System.out.print("lot_new_status:");
        System.out.print("change_date: ");
        System.out.print("lot_id: ");

        int lot_prev_status = scanner.nextInt();
        int lot_new_status = scanner.nextInt();
        scanner.nextLine();
        String change_date = scanner.nextLine();
        int lot_id = scanner.nextInt();

        try {
            String sql;
            sql = "INSERT INTO public.lotstatuslog (lot_prev_status, lot_new_status, change_date, lot_id)\n" +
                    String.format("VALUES (%d, %d, '%s', %d);", lot_prev_status, lot_new_status, change_date, lot_id);
            statement.executeUpdate(sql);
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
}