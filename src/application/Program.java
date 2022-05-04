package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args)  {
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller FindById ====");
		
		Seller seller = sellerDao.findById(2);
		
		System.out.println("Nome do Vendedor: " + seller.getName());
		
		System.out.println("\n === TEST 2: FindByDepartment ====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);	
		
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n === TEST 3: FindAll ====");
		List<Seller> list2 = sellerDao.findAll();
		
		for (Seller obj : list2) {
			System.out.println(obj);
		}
		
	}

}
