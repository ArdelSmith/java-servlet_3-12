import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 2L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		request.setAttribute("parent", request.getContextPath());
    	
		if (request.getSession(false) != null) {
			String file = new File(".").getAbsolutePath();
			response.sendRedirect(request.getContextPath() + "/files?path=" + file.replace("\\", "/"));
			return;
		}
		getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
    }

}