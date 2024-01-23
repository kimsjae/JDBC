import controller.BankController;
import db.RequestMapping;
import lombok.AllArgsConstructor;

import java.lang.reflect.Method;

/**
 * 책임(SRP) : 라우팅
 */
@AllArgsConstructor
public class Dispatcher {
    private BankController con;


    public void route(String path) {
        Method[] methods = con.getClass().getDeclaredMethods();

        for(Method method : methods) {
            RequestMapping rm = method.getDeclaredAnnotation(RequestMapping.class);

            if (rm == null) {
                continue;
            }
            if (rm.uri().equals(path)) {
                try {
                    method.invoke(con); // con.login();이랑 같음
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


//    public void route(String url) {
//        // 라우터, 디스패쳐
//        if (url.equals("insert")) {
//            con.insert();
//        } else if (url.equals("delete")) {
//            con.delete();
//        } else if (url.equals("update")) {
//            con.update();
//        } else if (url.equals("selectOne")) {
//            con.selectOne();
//        } else if (url.equals("selectAll")) {
//            con.selectAll();
//        }
//    }
}
