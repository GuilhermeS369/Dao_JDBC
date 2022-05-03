package model.dao;

import java.util.List;

import model.entities.Department;

public interface DepartmentDao {
	// OPERA��O RESPONSAVEL POR INSERIR NO BANCO DE DADOS ESSE OBJETO Q SERA ENVIADO COMO PARAMETO DE ENTRADA
	void insert(Department obj);
	// OPERA��O ATUALIZAR UM OBJ DENTRO DO BANCO DE DADOS
	void update(Department obj);
	// OPERA��O QUE DELETARA OBJETOS CONFORME O ID
	void deleteById(Integer id);
	// OBJETO DO TIPO DEPARTAMENTO Q RECEBE UM ID PARA PROCURAR NO BANCO DE DADOS
	Department findById(Integer id);
	// OPERA��O QUE RETORNA UMA LISTA DE TODOS OS DEPARTAMENTOS
	List<Department> findAll();
}
