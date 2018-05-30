package controle;

import banco.DAOGenerico;
import entidades.Fornecedor;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class FornecedorMB {

    private Fornecedor fornecedor;
    private List<Fornecedor> listaFornecedor;
    private DAOGenerico<Fornecedor> daoFornecedor;

    public FornecedorMB() {
        fornecedor = new Fornecedor();
        daoFornecedor = new DAOGenerico<Fornecedor>(Fornecedor.class);
        listaFornecedor = new ArrayList<Fornecedor>();
        preencherLista();
    }

    private void preencherLista() {
        listaFornecedor = daoFornecedor.buscarTodos();
    }

    public void inserir() {
        if (fornecedor.getId() == null) {
            daoFornecedor.salvar(fornecedor);
        } else {
            daoFornecedor.alterar(fornecedor);
        }
        preencherLista();
        fornecedor = new Fornecedor();
    }

    public void remover(Long id) {
        daoFornecedor.excluir(id);
        preencherLista();
    }

//GETTERS AND SETTERS-----------------------------------------------------------
    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public List<Fornecedor> getListaFornecedor() {
        return listaFornecedor;
    }

    public void setListaFornecedor(List<Fornecedor> listaFornecedor) {
        this.listaFornecedor = listaFornecedor;
    }

    public DAOGenerico<Fornecedor> getDaoFornecedor() {
        return daoFornecedor;
    }

    public void setDaoFornecedor(DAOGenerico<Fornecedor> daoFornecedor) {
        this.daoFornecedor = daoFornecedor;
    }

}
