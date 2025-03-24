package com.Servlet.CarDB.Servlets;

import java.io.IOException;

import com.Servlet.CarDB.Servlets.Dao.CarDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Update-Car")
public class UpdateDataServlet extends HttpServlet {

	private static final long serialVersionUID = -4404197130186831933L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int carId =Integer.parseInt(req.getParameter("id"));
		String model = req.getParameter("model");
		String brand=req.getParameter("brand");
		String color=req.getParameter("color");
		int price=Integer.parseInt(req.getParameter("price"));
		CarDao cd= new CarDao();
		cd.updateCar( carId, model,brand,color,price);
		resp.sendRedirect("DisplayAll");
	}

}
