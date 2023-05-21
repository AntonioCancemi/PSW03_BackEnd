package DAO;

import java.util.List;

import model.Magazine;

public interface IMagazineDAO {
	public void save(Magazine e);

	public Magazine getById(Integer id);

	public void delete(Magazine e);

	public void update(Magazine e);

	public List<Magazine> getAll();
}
