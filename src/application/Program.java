package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args)  {
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller FindById ====");
		
		Seller seller = sellerDao.findById(2);
		
		Scanner sc = new Scanner(System.in);
		
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
		
		System.out.println("\n === TEST 4: INSERT ====");
		Seller seller2 = new Seller(null,"Luiz", "teste@teste.com", new Date(), 9999.99, department );
		sellerDao.insert(seller2);
			System.out.println("Inserido! O novo id = " + seller2.getId());
			
		System.out.println("\n === TEST 5: UPDATE ====");	
		Seller seller3 = sellerDao.findById(1);
		seller3.setName("Bruce Wayne");
		sellerDao.update(seller3);
		System.out.println("Update completed");
		
		System.out.println("=== TEST 6: SELLER DELETE ====");	
		System.out.println("Digite um id para deletar: ");
		int cod = sc.nextInt();
		sellerDao.deleteById(cod);
		System.out.println("Deletado com sucesso.");
		
		sc.close();
	}

}
