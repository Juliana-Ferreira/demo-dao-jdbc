package application;

import java.util.List;
import java.util.Scanner;

import db.DB;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("-----------> Teste 1 - findById: <-----------");
		Department department = departmentDao.findById(5);
		System.out.println(department);
		
		System.out.println("\n-----------> Teste 2 - findAll: <-----------");
		List<Department> list = departmentDao.findAll();
		for(Department x : list) {
			System.out.println(x);
		}
		
		System.out.println("\n-----------> Teste 3 - insert: <-----------");
		Department newDepartment = new Department(null, "Finance");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted. New id: " + newDepartment.getId());
		
		System.out.println("\n-----------> Teste 4 - update: <-----------");
		department = departmentDao.findById(7);
		department.setName("Financial");
		departmentDao.update(department);
		System.out.println("Update completed.");
		
		System.out.println("\n-----------> Teste 5 - delete: <-----------");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed.");
		
		sc.close();
		DB.closeConnection();
	}
}
