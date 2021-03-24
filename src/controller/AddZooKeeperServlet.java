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
 * Servlet implementation class AddZooKeeperServlet
 */
@WebServlet("/addZooKeeperServlet")
public class AddZooKeeperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddZooKeeperServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String department = request.getParameter("department");
		
		
		ZooKeeper zk = new ZooKeeper(name, department);
		ZooKeeperHelper zkh = new ZooKeeperHelper();
		zkh.insertZooKeeper(zk);;
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		
	}

}
