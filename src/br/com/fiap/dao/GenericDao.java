package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;

public class GenericDao<T> implements Dao<T> {

	private final Class<T> classe;
	protected EntityManager em;

	public GenericDao(Class<T> classe) {
		this.classe = classe;
	}

	@Override
	public void adicionar(T entidade) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(entidade);
		em.getTransaction().commit();
		em.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listar() {
		em = JpaUtil.getEntityManager();
		return em.createQuery("From " + classe.getSimpleName()).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> listaDiscByCurso(int id) {
		em = JpaUtil.getEntityManager();
		return em.createQuery("From " + classe.getSimpleName() + " where idcurso = :id").setParameter("id", id).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> listaDiscByProf(int id) {
		em = JpaUtil.getEntityManager();
		return em.createQuery("From " + classe.getSimpleName() + " where idprofessor = :id").setParameter("id", id).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> listaDiscByIdAndProf(int id, int idProf) {
		em = JpaUtil.getEntityManager();
		return em.createQuery("From " + classe.getSimpleName() + " where id = :id AND idprofessor = :idProf")
				.setParameter("id", id).setParameter("idProf", idProf).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> listaDiscByCursoAndProf(int idCurso, int idProf) {
		em = JpaUtil.getEntityManager();
		return em.createQuery("From " + classe.getSimpleName() + " where idcurso = :idCurso AND idprofessor = :idProf")
				.setParameter("idCurso", idCurso).setParameter("idProf", idProf).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> listaNotaByDisc(int id) {
		em = JpaUtil.getEntityManager();
		return em.createQuery("From " + classe.getSimpleName() + " where iddisciplina = :id").setParameter("id", id).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public T listaNotaByDiscAndAluno(int idaluno, int iddisc) {
		em = JpaUtil.getEntityManager();
		return (T) em.createQuery("From " + classe.getSimpleName() + " where idaluno = :idaluno AND iddisciplina = :iddisc")
				.setParameter("idaluno", idaluno).setParameter("iddisc", iddisc).getSingleResult();
	}

	@Override
	public T buscar(int id) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		T entidade = em.find(classe, id);
		em.getTransaction().commit();
		em.close();

		return entidade;
	}
	
	@SuppressWarnings("unchecked")
	public T buscarAluno(int idAluno, int idDisc) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		T entidade = (T) em.createQuery("From " + classe.getSimpleName() + " Where idaluno = :idaluno And iddisciplina = :iddisciplina")
				.setParameter("idaluno", idAluno).setParameter("iddisciplina", idDisc).getSingleResult();
		em.getTransaction().commit();
		em.close();

		return entidade;
	}

	@SuppressWarnings("unchecked")
	public T buscar(String email, String senha) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();

		T entidade = (T) em.createQuery("From " + classe.getSimpleName() + " Where email = :email And senha = :senha")
				.setParameter("email", email).setParameter("senha", senha).getSingleResult();

		em.getTransaction().commit();
		em.close();

		return entidade;
	}

	@Override
	public void atualizar(T entidade) {
			
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(entidade);
		em.getTransaction().commit();
		em.close();
	}
	
	

}
