package com.Servlet.CarDB.Servlets;

import java.io.IOException;
import java.util.List;

import com.Servlet.CarDB.Servlets.Dao.CarDao;
import com.Servlet.CarDB.Servlets.entitys.Car;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/DisplayAll")
public class DisplayAllServlet extends HttpServlet{

	private static final long serialVersionUID = 6191581139005353483L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	CarDao cd= new CarDao();
	List<Car> carlist=cd.displayAllCar();

	req.setAttribute("list", carlist);
	req.getRequestDispatcher("DisplayAll.jsp").forward(req, resp);
	
	
	}

	

}
