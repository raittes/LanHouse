/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemalanhouse.auxiliar;

import java.util.ArrayList;
import sistemalanhouse.logic.BD;
import sistemalanhouse.logic.Cliente;
import sistemalanhouse.logic.Maquina;

/**
 *
 * @author marcos
 */
public class CriaUsuarios {
    private final BD bd;

    public CriaUsuarios(BD bd) {
        this.bd = bd;
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        clientes.add(new Cliente("marcos", 33413142, "marcos", 203942));
        clientes.add(new Cliente("paulo", 33413142, "souza", 203923));
        clientes.add(new Cliente("souza", 33413142, "brito", 2039223));
        clientes.add(new Cliente("brito", 33413142, "paulo", 38423));
        bd.setClientes(clientes);
 }

    public BD getBd() {
        return bd;
    }

}
