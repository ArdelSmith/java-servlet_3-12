import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.UserCreationService;

import java.io.*;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

	private static final long serialVersionUID = 5L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		request.setAttribute("parent", request.getContextPath());
		getServletContext().getRequestDispatcher("/registration.jsp").forward(request, response);
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		Boolean result = UserCreationService.CreateUser(request.getParameter("username").toString(), request.getParameter("password").toString(), 
				request.getParameter("email").toString());
		if (result) response.sendRedirect(request.getContextPath() + "/auth");
		else response.sendRedirect(request.getContextPath() + "/registration");
    }
}