import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.*;

@WebServlet("/auth")
public class AuthorizationServlet extends HttpServlet {
    private static final long serialVersionUID = 4L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Проверяем, авторизован ли пользователь
        if (request.getParameter("username").toString() != null) {
            // Если пользователь уже авторизован, перенаправляем на mypage.jsp
    		HttpSession session = request.getSession(true);
    		session.setAttribute("username", request.getParameter("username").toString());
    		request.setAttribute("path", "/files?path=C:/Users/" + request.getParameter("username").toString());
        	response.sendRedirect(request.getContextPath() + "/files?path=C:/Users/" + request.getParameter("username").toString());
        } else {
            response.sendRedirect(request.getContextPath() + "/");
        }

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		request.setAttribute("parent", request.getContextPath());
		getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
    }

}
