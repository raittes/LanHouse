package sistemalanhouse.logic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author grad
 */
public class BD {

    private List<Cliente> clientes;
    private List<Maquina> maquinas;
    private List<Sessao> sessao;

    public BD(List<Cliente> clientes, List<Maquina> maquinas) {
        //this.clientes = clientes;
        //this.maquinas = maquinas;
        this.clientes = new ArrayList();
        this.maquinas = new ArrayList();
        this.sessao   = new ArrayList();
    }

    public List<Sessao> getSessao() {
        return sessao;
    }

    public void setSessao(List<Sessao> sessao) {
        this.sessao = sessao;
    }

    

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Maquina> getMaquinas() {
        return maquinas;
    }

    public void setMaquinas(List<Maquina> maquinas) {
        this.maquinas = maquinas;
    }
      


}
