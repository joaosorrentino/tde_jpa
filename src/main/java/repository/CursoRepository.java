package repository;

import entities.Curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class CursoRepository {
    public void inserirCurso(EntityManagerFactory emf, Curso curso){
        EntityManager em = emf.createEntityManager();
        // Iniciar uma transação. É necessário para realizar operações de persistência, como salvar um objeto no banco de dados.
        em.getTransaction().begin();
        em.persist(curso);
        em.getTransaction().commit();

        em.close();
    }
}
