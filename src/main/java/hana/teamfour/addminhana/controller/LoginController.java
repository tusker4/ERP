package hana.teamfour.addminhana.controller;

import hana.teamfour.addminhana.DAO.EmployeeDAO;
import hana.teamfour.addminhana.entity.EmployeeEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    private final EmployeeDAO employeeDAO = new EmployeeDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        RequestDispatcher dispatcher = request.getRequestDispatcher("./views/login.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String id = request.getParameter("id");
        String pw = request.getParameter("pw");

        EmployeeEntity employee = employeeDAO.login(id, pw);
        if (employee != null) {
            request.getSession().setAttribute("login", employee);
            request.getSession().setMaxInactiveInterval(60 * 30); // 60초 * 30분 (테스트할 때 세션 시간 늘리시면 됩니다)
            response.sendRedirect(request.getContextPath());
        } else {
            request.setAttribute("isLoginSuccess", "false");
            RequestDispatcher dispatcher = request.getRequestDispatcher("./views/login.jsp");
            dispatcher.forward(request, response);
        }
    }
}
