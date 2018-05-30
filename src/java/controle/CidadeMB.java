package controle;

import banco.DAOGenerico;
import entidades.Cidade;
import entidades.Estado;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CidadeMB {

    private Cidade cidade;
    private List<Cidade> listaCidade;
    private DAOGenerico<Cidade> daoCidade;

    public CidadeMB() {
        cidade = new Cidade();
        listaCidade = new ArrayList<Cidade>();
        daoCidade = new DAOGenerico<Cidade>(Cidade.class);
        preencherLista();
    }

    private void preencherLista() {
        listaCidade = daoCidade.buscarTodos();
    }

    public void inserir() {
        if (cidade.getId() == null) {
            daoCidade.salvar(cidade);
        } else {
            daoCidade.alterar(cidade);
        }
        preencherLista();
        cidade = new Cidade();
    }

    public void remover(Long id) {
        daoCidade.excluir(id);
        preencherLista();
    }

//GETTERS AND SETTERS-----------------------------------------------------------
    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<Cidade> getListaCidade() {
        return listaCidade;
    }

    public void setListaCidade(List<Cidade> listaCidade) {
        this.listaCidade = listaCidade;
    }

    public DAOGenerico<Cidade> getDaoCidade() {
        return daoCidade;
    }

    public void setDaoCidade(DAOGenerico<Cidade> daoCidade) {
        this.daoCidade = daoCidade;
    }
}
