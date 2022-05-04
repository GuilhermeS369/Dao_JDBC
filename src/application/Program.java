package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Program {

	public static void main(String[] args)  {
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller FindById ====");
		
		Seller seller = sellerDao.findById(2);
		
		System.out.println("Nome do Vendedor: " + seller.getName());
	}

}
