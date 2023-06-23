import java.sql.*;
import java.math.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Bidhistory {
    private Statement statement;

    public Bidhistory(Statement stmt) {

        statement = stmt;
    }

    public void select(){
        try{
            String sql = "SELECT * FROM public.bidhistory u ORDER BY u.id";
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                int price = rs.getInt("price");
                String bidding_date = rs.getString("bidding_date");
                int bidder_id = rs.getInt("bidder_id");

                System.out.print("ID: " + id);
                System.out.print(", price: " + price);
                System.out.print(", bidding_date : " + bidding_date );
                System.out.print(", bidder_id: " + bidder_id);
            }
            rs.close();
        } catch(Exception error){
            error.printStackTrace();
        }
    }

    public void insert()
    {
        Scanner scanner = new Scanner(System.in);
        new Scanner(System.in);
        System.out.print("price: ");
        System.out.print("bidding_date:");
        System.out.print("bidder_id: ");
        System.out.print("lot_id: ");

        int price = scanner.nextInt();
        scanner.nextLine();
        String bidding_date = scanner.nextLine();
        int bidder_id = scanner.nextInt();
        int lot_id = scanner.nextInt();

        try {
            String sql;
            sql = "INSERT INTO public.bidhistory (price, bidding_date, bidder_id, lot_id)\n" +
                    String.format("VALUES ( %d, '%s',  %d,  %d);", price, bidding_date, bidder_id, lot_id);
            statement.executeUpdate(sql);
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
    public void delete() {
        Scanner scanner = new Scanner(System.in);
        new Scanner(System.in);
        System.out.print("input ID: ");
        int ID = scanner.nextInt();
        try {
            String sql = "DELETE FROM public.bidhistory\n WHERE id = " + ID;
            this.statement.executeUpdate(sql);
        } catch (Exception var3) {
            var3.printStackTrace();
        }
    }
    public void update() {
        Scanner scanner = new Scanner(System.in);
        new Scanner(System.in);
        System.out.print("input new price and id: ");
        int price = scanner.nextInt();
        int ID = scanner.nextInt();
        try {
            String sql = "UPDATE public.bidhistory SET price =" + price +  " WHERE id = " + ID;
            statement.executeUpdate(sql);
        } catch (Exception var2) {
            var2.printStackTrace();
        }  }

    }

