package it.prova.dao.acquisto;
import java.util.List;

import it.prova.dao.IBaseDAO;
import it.prova.model.Acquisto;

public interface AcquistoDAO extends IBaseDAO<Acquisto>{
	
	public List<Acquisto> findByExampleEager(Acquisto example) throws Exception;

}
