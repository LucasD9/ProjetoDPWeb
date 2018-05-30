package controle;

import banco.DAOGenerico;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import entidades.Estado;

@ManagedBean
@SessionScoped
public class EstadoMB {

    private Estado estado;
    private List<Estado> listaEstado;
    private DAOGenerico<Estado> daoEstado;

    public EstadoMB() {
        estado = new Estado();
        listaEstado = new ArrayList<Estado>();
        daoEstado = new DAOGenerico<Estado>(Estado.class);
        preencherLista();
    }

    private void preencherLista() {
        listaEstado = daoEstado.buscarTodos();
    }

    public void remover(Long id) {
        daoEstado.excluir(id);
        preencherLista();
    }

    public void inserir() {
        if (estado.getId() == null) {
            daoEstado.salvar(estado);
        } else {
            daoEstado.alterar(estado);
        }
        preencherLista();
        estado = new Estado();
    }

//GETTERS AND SETTERS-----------------------------------------------------------
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Estado> getListaEstado() {
        return listaEstado;
    }

    public void setListaEstados(List<Estado> listaEstado) {
        this.listaEstado = listaEstado;
    }
}
