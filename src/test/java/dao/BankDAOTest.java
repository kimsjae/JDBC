package dao;

import model.Account;
import org.junit.jupiter.api.Test;

import java.sql.PreparedStatement;
import java.util.List;

public class BankDAOTest {

    @Test
    public void selectAll_test() {
        BankDAO dao = new BankDAO();
        List<Account> accountList = dao.selectAll();

        System.out.println(accountList.size());

        for (Account a : accountList) {
            System.out.println(a);
        }


    }

    @Test
    public void selectByNumber_test() {
        int number = 4;

        BankDAO dao = new BankDAO();
        Account account = dao.selectByNumber(number);

        if (account == null) {
            System.out.println(number + "로 조회된 값이 없습니다.");
        } else {
            System.out.println(account);
//            System.out.println(account.getNumber());
//            System.out.println(account.getPassword());
//            System.out.println(account.getBalance());
//            System.out.println(account.getCreatedAt());
        }
    }

    @Test
    public void deleteByNumber_test() {
        // given
        int number = 5;

        // when
        BankDAO dao = new BankDAO();
        int result = dao.deleteByNumber(number);

        // then
        if (result == 1) {
            System.out.println("삭제 성공");
        } else if (result == 0){
            System.out.println(number + "번호를 찾을 수 없습니다.");
        } else {
            System.out.println("삭제 실패");
        }
    }

    @Test
    public void insert_test() {
        // given
        String password = "1111";
        int balance = 10000;

        // when
        BankDAO dao = new BankDAO();
        int result = dao.insert(password, balance);

        // then
        if (result == 1) {
            System.out.println("입력 성공");
        } else {
            System.out.println("입력 실패");
        }

    }

    @Test
    public void updateByNumber_test() {
        int balance = 1000;
        int number = 6;

        BankDAO dao = new BankDAO();
        int result = dao.updateByNumber(balance, number);

        if (result == 1) {
            System.out.println("변경 성공");
        } else if (result == 0) {
            System.out.println("변경 사항 없음");
        } else {
            System.out.println("변경 실패");
        }
    }
}
