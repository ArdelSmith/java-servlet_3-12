import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 5L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		request.setAttribute("parent", request.getContextPath());
    	
		if (request.getSession(false) != null) {
			request.getSession(false).invalidate();
			response.sendRedirect(request.getContextPath() + "/auth");
			return;
		}

    }

}