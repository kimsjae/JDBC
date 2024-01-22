package dao;

import db.DBConnection;
import model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * <p> DAO - Data Access Object </p>
 * <p> SRP - 단일책임의 원칙 </p>
 */
public class BankDAO {

    public int deleteByNumber(int number) {
        // 소켓을 가져옴
        Connection conn = DBConnection.getInstance();
        try {
            String sql = "delete from account_tb where number = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, number);

            // flush해서 실행
            int num = pstmt.executeUpdate();
            return num;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int insert(String password, int balance) {
        // 소켓을 가져옴
        Connection conn = DBConnection.getInstance();
        try {
            String sql = "insert into account_tb(password, balance, created_at) values(?, ?, now())";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, password);
            pstmt.setInt(2, balance);

            // flush해서 실행
            int num = pstmt.executeUpdate();
            return num;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int updateByNumber(int balance, int number) {
        // 소켓을 가져옴
        Connection conn = DBConnection.getInstance();
        try {
            String sql = "update account_tb set balance = ? where number = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, balance);
            pstmt.setInt(2, number);

            // flush해서 실행
            int num = pstmt.executeUpdate();
            return num;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public Account selectByNumber(int number) {
        Connection conn = DBConnection.getInstance();
        try {
            String sql = "select * from account_tb where number = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, number);

            ResultSet rs = pstmt.executeQuery(); // 테이블형태의 데이터

            if(rs.next()) { // 커서 한칸 내리기
                Account account = new Account(
                        rs.getInt("number"),
                        rs.getString("password"),
                        rs.getInt("balance"),
                        rs.getTimestamp("created_at")
                );
                return account;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Account> selectAll() {
        Connection conn = DBConnection.getInstance();
        try {
            String sql = "select * from account_tb order by number desc";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery(); // 테이블형태의 데이터

            List<Account> accountList = new ArrayList<>();
            while(rs.next()) {
                Account account = new Account(
                        rs.getInt("number"),
                        rs.getString("password"),
                        rs.getInt("balance"),
                        rs.getTimestamp("created_at")
                );
                accountList.add(account);
            }
            return accountList;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
