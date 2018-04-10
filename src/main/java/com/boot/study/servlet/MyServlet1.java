package com.boot.study.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by hujh on 2018/3/26.
 */
//这个不需要添加. 在@Configurtion里定义
//@WebServlet(urlPatterns="/myServlet1/*", description="Servlet的说明")
public class MyServlet1 extends HttpServlet {

        private static final long serialVersionUID = 1L;

    @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           System.out.println(">>>>>>>>>>doGet()<<<<<<<<<<<");
           doPost(req, resp);
           }

@Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           System.out.println(">>>>>>>>>>doPost()<<<<<<<<<<<");
           resp.setContentType("text/html");
           PrintWriter out = resp.getWriter();
           out.println("<html>");
           out.println("<head>");
           out.println("<title>HelloWorld</title>");
           out.println("</head>");
           out.println("<body>");
           out.println("<h1>这是：MyServlet1</h1>");
           out.println("</body>");
           out.println("</html>");
           }
}