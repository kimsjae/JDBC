import controller.BankController;
import dao.BankDAO;

import java.nio.file.Path;

public class BankApp {
    public static void main(String[] args) {

        BankDAO dao = new BankDAO();
        BankController con = new BankController(dao);
        Dispatcher dis = new Dispatcher(con);

        //dis.route("/insert");
        //dis.route("/delete");
        //dis.route("/update");
        dis.route("/selectOne");
        //dis.route("/selectAll");
    }
}
