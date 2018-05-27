package banco;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DAOGenerico<T> {

    private static EntityManager entityManager;
    private Class<T> classe;

    public DAOGenerico(Class<T> classe) {
        entityManager = Fabrica.getFabrica().getEntityManager();
        this.classe = classe;
    }

    public T salvar(T objeto) {
        try {
            if (!entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().begin();
            }
            entityManager.persist(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception exception) {
            entityManager.getTransaction().rollback();
            exception.printStackTrace();
        }
        return objeto;
    }

    public T alterar(T objeto) {
        try {
            if (!entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().begin();
            }
            entityManager.merge(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception exception) {
            entityManager.getTransaction().rollback();
            exception.printStackTrace();
        }
        return objeto;
    }

    public boolean excluir(Long id) {
        try {
            if (!entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().begin();
            }
            T objeto = entityManager.find(classe, id);
            if (objeto != null) {
                entityManager.remove(objeto);
                return true;
            }
            entityManager.getTransaction().commit();
        } catch (Exception exception) {
            entityManager.getTransaction().rollback();
            exception.printStackTrace();
        }
        return false;
    }

    public List<T> buscarTodos() {
        Query query = null;
        try {
            query = entityManager.createQuery("from " + classe.getSimpleName());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return query.getResultList();
    }

    public T buscarPorId(Long id) {
        T objeto = null;
        try {
            objeto = entityManager.find(classe, id);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return objeto;
    }

}
