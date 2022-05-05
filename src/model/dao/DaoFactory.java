package model.dao;

import db.DB;
import model.dao.imlp.DepartmentDaoJDBC;
import model.dao.imlp.SellerDaoJDBC;

public class DaoFactory {
	//CRIAMOS UM CREATESELLERDAO DO TIPO SELLERDAO Q � DO TIPO
	// INTERFACE CONTENDO SEUS METODOS E NELE PEDIMOS PRA RETORNAR
	//UMA INSTANCIADE SELLERDAOJDBC COM A FUN��O DB.GETCONNECTION
	public static SellerDao createSellerDao() {
		
		return new SellerDaoJDBC(DB.getConnection());
	}
	
	public static DepartmentDao createDepartmentDao() {
		
		return new DepartmentDaoJDBC(DB.getConnection());
	}
	
	
}
