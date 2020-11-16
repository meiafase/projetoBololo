package dao;


public interface DAOEditar<T> {

	T atualizarNome(T entidade);
	T atualizarSobrenome(T entidade);
	T atualizarCpf(T entidade);
	T atualizarEmail(T entidade);
	T atualizarRua(T entidade);
	T atualizarNumeroCasa(T entidade);
	T atualizarCep(T entidade);
	T atualizarDdd(T entidade);
	T atualizarNumero(T entidade);
}
