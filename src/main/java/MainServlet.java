
import java.io.*;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/files")
public class MainServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session == null) {
			response.sendRedirect(request.getContextPath() + "/auth");
			return;
		}
		else {
			if (session.getAttribute("username") == null) {
				response.sendRedirect(request.getContextPath() + "/auth");
				return;
			}
			String path = "path";
	        if (request.getParameter(path) == null) {
	            request.setAttribute("path", Paths.get("C:/Users/" + session.getAttribute("username")).toAbsolutePath().toString());
	        }
	        else {
	        	if (isNestedFolder(new File("C:/Users/" + session.getAttribute("username").toString()), 
	        			new File(request.getParameter(path).toString()))) {
	        		request.setAttribute("path", request.getParameter(path));
	        	}
	        	else {
	        		request.setAttribute("path", "C:/Users/" + session.getAttribute("username").toString());
	        		response.sendRedirect(request.getContextPath() + "/files?path=" + request.getAttribute("path"));
	        		return;
	        	}
	        }
	        request.setAttribute("username", session.getAttribute("username").toString());
	        File dir = new File(request.getAttribute(path).toString());
	        File[] arrFiles = dir.listFiles();
	        Arrays.sort(arrFiles);
	        request.setAttribute("prevLink", request.getContextPath());
	        if (Paths.get(request.getParameter(path)).getParent() != null){
	        	request.setAttribute("parent", Paths.get(request.getParameter(path)).getParent().toAbsolutePath().toString()
	                    .replace("\\", "/"));
	        }
	        else {
	        	String str = Paths.get(request.getParameter(path)).toAbsolutePath().toString().replace("\\", "/");
	        	request.setAttribute("parent", str);
	        }
	        request.setAttribute("date", new Date(System.currentTimeMillis()));
	        request.setAttribute("list", arrFiles);
	        request.setAttribute("url", request.getRequestURI());
	        getServletContext().getRequestDispatcher("/mypage.jsp").forward(request, response);
		}
    }
	public static boolean isNestedFolder(File a, File b) {
        return b.toPath().startsWith(a.toPath());
    }

}