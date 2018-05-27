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
    private List<Cidade> listaCidades;
    private DAOGenerico<Cidade> daoCidade;
    private Estado estado;

    public CidadeMB() {
        cidade = new Cidade();
        listaCidades = new ArrayList<Cidade>();
        daoCidade = new DAOGenerico<Cidade>(Cidade.class);
    }

    private void preencherListaCidades() {
        listaCidades = daoCidade.buscarTodos();
    }

    public void inserir() {
        if (cidade.getId() == null) {
            daoCidade.salvar(cidade);
        } else {
            daoCidade.alterar(cidade);
        }
        preencherListaCidades();
        cidade = new Cidade();
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<Cidade> getListaCidades() {
        return listaCidades;
    }

    public void setListaCidades(List<Cidade> listaCidades) {
        this.listaCidades = listaCidades;
    }

    public DAOGenerico<Cidade> getDaoCidade() {
        return daoCidade;
    }

    public void setDaoCidade(DAOGenerico<Cidade> daoCidade) {
        this.daoCidade = daoCidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
