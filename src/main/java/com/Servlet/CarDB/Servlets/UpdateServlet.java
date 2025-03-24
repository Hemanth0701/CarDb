package com.Servlet.CarDB.Servlets;

import java.io.IOException;

import com.Servlet.CarDB.Servlets.Dao.CarDao;
import com.Servlet.CarDB.Servlets.entitys.Car;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

	private static final long serialVersionUID = -3864292331519829047L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int carId =Integer.parseInt(req.getParameter("carId"));
		CarDao cd= new CarDao();
		Car c=cd.findCar(carId);
		req.setAttribute("Car", c);
		req.getRequestDispatcher("update.jsp").forward(req, resp);
	}
}
