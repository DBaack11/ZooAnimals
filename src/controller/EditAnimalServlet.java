package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ZooAnimal;

/**
 * Servlet implementation class EditAnimalServlet
 */
@WebServlet("/editAnimalServlet")
public class EditAnimalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAnimalServlet() {
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
		ZooAnimalHelper zah = new ZooAnimalHelper();
		
		String animal = request.getParameter("animal");
		String gender = request.getParameter("gender");
		String strAge = request.getParameter("age");
		int age = Integer.parseInt(strAge);
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		ZooAnimal animalToUpdate = zah.searchForAnimalById(tempId);
		animalToUpdate.setAnimal(animal);
		animalToUpdate.setGender(gender);
		animalToUpdate.setAge(age);
		
		zah.updateAnimal(animalToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllAnimalsServlet").forward(request, response);
	}

}
