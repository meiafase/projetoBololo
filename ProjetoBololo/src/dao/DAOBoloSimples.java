package dao;

import java.util.List;

public interface DAOBoloSimples<T> {
	
	T inserir(T entidade);
	T atualizar(T entidade);
	void deletar(Integer id);
	List<T> listar();
}
