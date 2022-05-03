package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		
		Department obj = new Department(1, "Brinquedos");
		System.out.println(obj);
		Seller sell = new Seller(1, "Luiz", "guilherme460@yahoo.com.br", sdf1.parse("22/06/1999"), 2000.0, obj );
		System.out.println(sell);
	}

}
