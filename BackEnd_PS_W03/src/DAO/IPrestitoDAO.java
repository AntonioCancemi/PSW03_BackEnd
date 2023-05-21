package DAO;

import java.util.List;

import model.Prestito;

public interface IPrestitoDAO {
	public void save(Prestito e);

	public Prestito getById(Integer id);

	public void delete(Prestito e);

	public void update(Prestito e);

	public List<Prestito> getAll();
}
