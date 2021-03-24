package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ZooAnimal;
import model.ZooKeeper;

/**
 * Servlet implementation class ZooKeeperNavigationServlet
 */
@WebServlet("/zooKeeperNavigationServlet")
public class ZooKeeperNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZooKeeperNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ZooKeeperHelper zkh = new ZooKeeperHelper();
		String act = request.getParameter("doThisToZooKeeper");
		String path = "/viewAllZooKeepersServlet";
		
		if(act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ZooKeeper zooKeeperToDelete = zkh.searchForZooKeeperById(tempId);
				zkh.deleteZooKeeper(zooKeeperToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a zookeeper.");
			}
		}else if(act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ZooKeeper zooKeeperToEdit = zkh.searchForZooKeeperById(tempId);
				request.setAttribute("zooKeeperToEdit", zooKeeperToEdit);
				path = "/edit-zookeeper.jsp";
			}catch (NumberFormatException e) {
				System.out.println("Forgot to select a zookeeper.");
			}
		}else if(act.equals("add")) {
			path = "/index.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
