分以下几个步骤：
（1）提供Socket服务
（2）进行请求的转发
（3）把请求和响应封装成request/response

2、封装请求对象：通过输入流，对HTTP协议进行解析，拿到了HTTP请求头的方法和URL：

3、封装响应对象：基于HTTP协议的格式进行输出写入。
MyResponse
 

4、servlet请求处理基类：Tomcat是满足Servlet规范的容器，所以Tomcat需要提供API：doGet/doPost/service。
MyServlet 


5、Servlet实现类：提供2个实现类，用于测试。
FindGirlServlet  MyServlet 

6、Servlet配置：对比之前在web开发中，会在web.xml中通过和指定哪个URL交给哪个servlet来处理。
ServletMapping ServletMappingConfig 

7、启动类：
tomcat的处理流程：把URL对应处理的Servlet关系形成，解析HTTP协议，封装请求/响应对象，利用反射实例化具体的Servlet进行处理。
MyTomcat 





