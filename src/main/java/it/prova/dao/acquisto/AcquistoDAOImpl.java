package it.prova.dao.acquisto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;

import it.prova.model.Acquisto;

public class AcquistoDAOImpl implements AcquistoDAO{
private EntityManager entityManager;
	
	@Override
	public List<Acquisto> list() throws Exception {
		return entityManager.createQuery("from Acquisto", Acquisto.class).getResultList();
	}

	@Override
	public Optional<Acquisto> findOne(Long id) throws Exception {
		Acquisto result = entityManager.find(Acquisto.class, id);
		return result != null ? Optional.of(result) : Optional.empty();
	}

	@Override
	public void update(Acquisto input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		input = entityManager.merge(input);
	}

	@Override
	public void insert(Acquisto input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(input);
	}

	@Override
	public void delete(Acquisto input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(input));
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Acquisto> findByExampleEager(Acquisto example) throws Exception {
		Map<String, Object> paramaterMap = new HashMap<String, Object>();
		List<String> whereClauses = new ArrayList<String>();

		StringBuilder queryBuilder = new StringBuilder("select a from Acquisto a join a.utenteAcquirente u where a.id = a.id ");

		if (StringUtils.isNotEmpty(example.getDescrizione())) {
			whereClauses.add(" a.descrizione  like :descrizione ");
			paramaterMap.put("descrizione", "%" + example.getDescrizione() + "%");
		}
		if (example.getPrezzo() < 0) {
			whereClauses.add("a.prezzo >= :prezzo ");
			paramaterMap.put("prezzo", example.getPrezzo());
		}
		if (example.getDataAcquisto() != null) {
			whereClauses.add("a.data >= :data ");
			paramaterMap.put("data", example.getDataAcquisto());
		}
		if (example.getUtenteAcquirente().getId() != null) {
			whereClauses.add("u.id = :idUtente ");
			paramaterMap.put("idUtente", example.getUtenteAcquirente().getId());
		}

		queryBuilder.append(!whereClauses.isEmpty() ? " and " : "");
		queryBuilder.append(StringUtils.join(whereClauses, " and "));
		TypedQuery<Acquisto> typedQuery = entityManager.createQuery(queryBuilder.toString(), Acquisto.class);

		for (String key : paramaterMap.keySet()) {
			typedQuery.setParameter(key, paramaterMap.get(key));
		}

		return typedQuery.getResultList();
	}
}
