package my.tomcat;

import java.io.IOException;

/**
 * @author wangjie
 * @version 2018/11/9
 */
public class HelloWorldServlet extends MyServlet {
    @Override
    public void doGet(MyRequest myRequest,MyResponse myResponse){
        try{
            myResponse.write("get world...");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(MyRequest myRequest,MyResponse myResponse){
        try{
            myResponse.write("post world...");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
