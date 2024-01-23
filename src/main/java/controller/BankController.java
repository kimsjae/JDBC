package controller;

import dao.BankDAO;
import db.RequestMapping;
import lombok.AllArgsConstructor;

/**
 * 책임(SRP) : 유효성검사(바디데이터), 파싱(바디데이터), 적절한 DAO 찾기
 */
@AllArgsConstructor

public class BankController {

    private BankDAO dao;

    @RequestMapping(uri = "/insert")
    public void insert() {
        System.out.println("controller : insert");
        dao.insert("1234",1000);
    }

    @RequestMapping(uri = "/delete")
    public void delete() {
        System.out.println("controller : delete");
        dao.deleteByNumber(4);
    }

    @RequestMapping(uri = "/update")
    public void update() {
        System.out.println("controller : update");
        dao.updateByNumber(1000,7);
    }

    @RequestMapping(uri = "/selectOne")
    public void selectOne() {
        System.out.println("controller : selectOne");
        dao.selectByNumber(7);
    }

    @RequestMapping(uri = "/selectAll")
    public void selectAll() {
        System.out.println("controller : selectAll");
        dao.selectAll();
    }
}
