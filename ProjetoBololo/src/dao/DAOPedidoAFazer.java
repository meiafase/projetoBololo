package dao;

import java.util.List;

public interface DAOPedidoAFazer<T> {
	List<T> listar();
	void concluir(Integer id);
}
