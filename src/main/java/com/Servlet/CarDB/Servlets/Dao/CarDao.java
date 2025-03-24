package com.Servlet.CarDB.Servlets.Dao;

import java.util.List;


import com.Servlet.CarDB.Servlets.entitys.Car;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class CarDao {
	//Scanner scan = new Scanner(System.in);
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("mysql-config");
	public void addCar(int carId, String model, String brand, String color, int price) {
		EntityManager em= emf.createEntityManager();
		EntityTransaction et= em.getTransaction();
		et.begin();
		Car c= new Car();
		c.setCarId(carId);
		c.setBrand(brand);
		c.setModel(model);
		c.setColor(color);
		c.setPrice(price);
		em.persist(c);
		et.commit();
		em.close();
	}

	public List<Car> displayAllCar(){
		EntityManager em= emf.createEntityManager();
		EntityTransaction et= em.getTransaction();
		et.begin();
		CriteriaBuilder cb= em.getCriteriaBuilder();
		CriteriaQuery<Car> cq= cb.createQuery(Car.class);
		Root<Car>  root =cq.from(Car.class);
		cq.select(root);
		TypedQuery<Car> q= em.createQuery(cq);
		List<Car> clist=q.getResultList();
		et.commit();
		em.close();
		return clist;
	}

	public Car findCar(int carId) {
		EntityManager em= emf.createEntityManager();
		EntityTransaction et= em.getTransaction();
		et.begin();
		Car car=em.find(Car.class, carId);
		et.commit();
		em.close();
		return car;
	}

	public void updateCar(int carId, String model, String brand, String color, int price) {
		EntityManager em= emf.createEntityManager();
		EntityTransaction et= em.getTransaction();
		et.begin();
		Car car=em.find(Car.class, carId);
		car.setBrand(brand);
		car.setModel(model);
		car.setColor(color);
		car.setPrice(price);
		em.merge(car);
		et.commit();
		em.close();
	}

	public void deleteCar(int carId) {
		EntityManager em= emf.createEntityManager();
		EntityTransaction et= em.getTransaction();
		et.begin();
		Car car=em.find(Car.class, carId);
		em.remove(car);
		et.commit();
		em.close();
	}

}
