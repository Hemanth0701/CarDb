package com.Servlet.CarDB.Servlets;

import java.io.IOException;

import com.Servlet.CarDB.Servlets.Dao.CarDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 7586161121521434788L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int carId =Integer.parseInt(req.getParameter("carId"));
		CarDao cd= new CarDao();
		cd.deleteCar(carId);
		resp.sendRedirect("DisplayAll");
	}
}
