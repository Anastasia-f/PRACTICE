import java.sql.*;
import java.math.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class user {
    private Statement statement;

    public user(Statement stmt) {

        statement = stmt;
    }

    public void select(){
        try{
            String sql = "SELECT * FROM public.\"user\" u ORDER BY u.id";
            ResultSet rs = statement.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                String role = rs.getString("role");
                String status = rs.getString("status");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String email = rs.getString("email");
                String user_passowrd = rs.getString("user_password");
                int phone  = rs.getInt("phone");
                String passport_data = rs.getString("passport_data");


                //Display values
                System.out.print("ID: " + id);
                System.out.print(", role: " + role);
                System.out.print(", status : " + status );
                System.out.print(", first_name: " + first_name);
                System.out.print(", last_name: " + last_name);
                System.out.print(", email: " + email);
                System.out.print(", user_passoword: " + user_passowrd);
                System.out.print(", phone: " + phone);
                System.out.print(", passport_data : " + passport_data );
            }
            //STEP 6: Clean-up environment
            rs.close();
        } catch(Exception error){
            error.printStackTrace();
        }
    }

    public void insert()
    {
        Scanner scanner = new Scanner(System.in);
        new Scanner(System.in);
        System.out.print("role: ");
        System.out.print("status:");
        System.out.print("first_name: ");
        System.out.print("last_name: ");
        System.out.print("email: ");
        System.out.print("user_password: ");
        System.out.print("phone: ");
        System.out.print("passport_data: ");
        String role = scanner.nextLine();
        String status = scanner.nextLine();
        String first_name = scanner.nextLine();
        String last_name = scanner.nextLine();
        String email = scanner.nextLine();
        String user_password = scanner.nextLine();
        String passport_data = scanner.nextLine();
        int phone = scanner.nextInt();
        try {
            String sql;


            sql = "INSERT INTO public.user (\"role\", status, first_name, last_name, email, user_password, phone, passport_data)\n" +
                    String.format("VALUES ('%s', '%s', '%s', '%s', '%s', '%s', %d, '%s');", role, status, first_name, last_name, email, user_password, phone, passport_data);

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
            String sql = "DELETE FROM public.user\n WHERE id = " + ID;
            this.statement.executeUpdate(sql);
        } catch (Exception var3) {
            var3.printStackTrace();
        }
    }

    public void update() {
        Scanner scanner = new Scanner(System.in);
        new Scanner(System.in);
        System.out.print("input new password and id: ");
        String user_password = scanner.nextLine();
        int ID = scanner.nextInt();

        try {
            System.out.println("Creating statement...");
            String sql = "UPDATE public.user SET user_password = ' " + user_password + " ' WHERE id = " + ID;
            statement.executeUpdate(sql);
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }
}