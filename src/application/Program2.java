package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("=== TESTE 1: INSERT ====");
		Department dep1 = new Department(null, "Biju");
		departmentDao.insert(dep1);
		System.out.println("INSERIDO COM SUCESSO");
		
		System.out.println("=== TESTE 2: findById ====");
		Department dep2 = departmentDao.findById(2);	
		System.out.println(dep2);
		
		System.out.println("=== TESTE 3: UPDATE ====");
		departmentDao.update(new Department(3, "Moda"));
		System.out.println();
		
		System.out.println("=== TESTE 4: DELETE ====");
		System.out.println("DIGITE UM ID PARA DELETAR: ");
		int x = sc.nextInt();
		departmentDao.deleteById(x);
		System.out.println("DELETADO COM SUCESSO");
		
		System.out.println("=== TESTE 5: findAll ====");
		List<Department> listDep = departmentDao.findAll();
		for(Department d : listDep) {
		System.out.println(d);
		}
		sc.close();
	}
}		
