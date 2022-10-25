package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("-----------> Teste 1 - findById: <-----------");
		Seller seller = sellerDao.findById(5);
		System.out.println(seller);
		
		System.out.println("\n-----------> Teste 2 - findByDepartment: <-----------");
		Department department = new Department(1, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller x : list) {
			System.out.println(x);
		}
		
		System.out.println("\n-----------> Teste 3 - findAll: <-----------");
		list = sellerDao.findAll();
		for(Seller x : list) {
			System.out.println(x);
		}
		
		System.out.println("\n-----------> Teste 4 - insert: <-----------");
		Seller newSeller = new Seller(null, "Greg White", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted. New id: " + + newSeller.getId());
		
		System.out.println("\n-----------> Teste 5 - update: <-----------");
		seller = sellerDao.findById(1);
		seller.setName("Martha Martins");
		sellerDao.update(seller);
		System.out.println("Update completed.");
	}
}
