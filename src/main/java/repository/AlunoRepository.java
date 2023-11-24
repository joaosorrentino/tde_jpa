package repository;

import entities.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class AlunoRepository {
    public void inserirAluno(EntityManagerFactory emf, Aluno aluno){
        EntityManager em = emf.createEntityManager();
        // Iniciar uma transação. É necessário para realizar operações de persistência, como salvar um objeto no banco de dados.
        em.getTransaction().begin();
        em.persist(aluno);
        em.getTransaction().commit();

        em.close();
    }
    public void mostrarAluno(EntityManagerFactory emf){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try{
            transaction.begin();
            Query query = em.createQuery("select aluno from Aluno aluno");
            List<Aluno> resultList = query.getResultList();

            for(Aluno aluno: resultList){
                System.out.println(aluno);
            }
            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    public void exibirAlunosdeCurso(EntityManagerFactory emf, String nomeCurso){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Query query = em.createQuery("SELECT a FROM Aluno a.curso c Where c.nome = c.nomeCurso ");
            List<Aluno> resultList = query.getResultList();
            for(Aluno a: resultList){
                System.out.print(a);

            }
            transaction.commit();
        } catch ( Exception e){
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
