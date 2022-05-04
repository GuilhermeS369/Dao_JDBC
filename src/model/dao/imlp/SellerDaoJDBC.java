package model.dao.imlp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao{
	
	private Connection conn;
	// POR AQUI PASSA OQ VEM DA FACTORY Q É A CONEXÃO
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null; //RECEBE O COMANDO
		ResultSet rs = null; //LISTA O RETORNO
		
		try {
			st = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName "
					+"FROM seller INNER JOIN department "
					+"ON seller.DepartmentId = department.Id "
					+"WHERE seller.Id = ?");
				st.setInt(1, id);
				rs = st.executeQuery();
				if (rs.next()) {
					Department dep = instantiateDepartment(rs);
					Seller obj = instantiateSeller(rs, dep);
					return obj;
			}
				return null;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
	
	@Override
	public List<Seller> findAll() {
		PreparedStatement st = null; //RECEBE O COMANDO
		ResultSet rs = null; //LISTA O RETORNO
		
		try {
			st = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "ORDER BY Name");
			
				rs = st.executeQuery();
				
				List<Seller> list = new ArrayList<>();
				Map<Integer, Department> map = new HashMap<>();
				
				while (rs.next()) {
					//AQUI BUSCO DENTRO DO MEU MAP SE EXISTE O MESMO ID
					//Q ESTA NO DepartmentId, CASO NÃO TENHA, A VARIAVEL DEP VAI SER NULL
					Department dep = map.get(rs.getInt("DepartmentId"));
					// CASO SEJA NULO, ELE INSTANCIA E INSERE NO MAP ID E O DEPARTAMENTO
					if (dep == null) {
					dep = instantiateDepartment(rs);
					map.put(rs.getInt("DepartmentId"), dep);
					}
				
					Seller obj = instantiateSeller(rs, dep);
					list.add(obj);
			}
				return list;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
	}
	
	@Override
	public List<Seller> findByDepartment(Department department) {
		PreparedStatement st = null; //RECEBE O COMANDO
		ResultSet rs = null; //LISTA O RETORNO
		
		try {
			st = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE DepartmentId = ? "
					+ "ORDER BY Name");
			
				st.setInt(1, department.getId());
				
				rs = st.executeQuery();
				
				List<Seller> list = new ArrayList<>();
				Map<Integer, Department> map = new HashMap<>();
				
				while (rs.next()) {
					//AQUI BUSCO DENTRO DO MEU MAP SE EXISTE O MESMO ID
					//Q ESTA NO DepartmentId, CASO NÃO TENHA, A VARIAVEL DEP VAI SER NULL
					Department dep = map.get(rs.getInt("DepartmentId"));
					// CASO SEJA NULO, ELE INSTANCIA E INSERE NO MAP ID E O DEPARTAMENTO
					if (dep == null) {
					dep = instantiateDepartment(rs);
					map.put(rs.getInt("DepartmentId"), dep);
					}
				
					Seller obj = instantiateSeller(rs, dep);
					list.add(obj);
			}
				return list;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
	}
	
	//FUNÇÕES Q INICIA UM TIPO SELLER E JA RETORNA COM OS DADOS DO BANCO DE DADOS
	private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException{
		
		Seller obj = new Seller();
		obj.setId(rs.getInt("Id"));
		obj.setName(rs.getString("Name"));
		obj.setEmail(rs.getString("Email"));
		obj.setBirthDate(rs.getDate("BirthDate"));
		obj.setBaseSalary(rs.getDouble("BaseSalary"));
		obj.setDepartment(dep);
		return obj;
		
	}
	//FUNÇÃO Q INICIA UM TIPO DEPARTAMENTO E O RETORNA JA COM OS DADOS DO BANCO
	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department dep = new Department();
		dep.setId(rs.getInt("DepartmentId"));
		dep.setName(rs.getString("DepName"));
		return dep;
		
	}

	

}

	

