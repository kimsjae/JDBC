import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BankApp {
    public static void main(String[] args) {
        Connection conn = DBConnection.getInstance();
        try {
            String insert = "insert into account_tb(password, balance, created_at) values(?, ?, now())";
            String update = "update account_tb set balance = balance + ? where number = ?";
            String delete = "delete from account_tb where number = ?";


            PreparedStatement pstmt = conn.prepareStatement(delete);
            //pstmt.setString(1,"1234"); // 몇 번째 물음표를 사용할거냐, 0이 아니라 1부터 시작
            //pstmt.setInt(2,1000);
//            pstmt.setInt(1, 5000);
//            pstmt.setInt(2, 2);
//            pstmt.setInt(1,2000);
//            pstmt.setInt(2,1);
            pstmt.setInt(1, 3);

            int num = pstmt.executeUpdate();
            System.out.println(num);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
