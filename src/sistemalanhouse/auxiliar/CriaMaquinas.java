package sistemalanhouse.auxiliar;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import sistemalanhouse.logic.BD;
import sistemalanhouse.logic.Maquina;

public class CriaMaquinas {
    BD bd;
    
    public CriaMaquinas(BD bd){
        this.bd = bd;
        
        List<Maquina> lista = new ArrayList();
        lista.add(new Maquina("Venus","150.162.100.1","AB-AA-12",(short)1,(short)1));
        lista.add(new Maquina("Marte","150.162.100.2","AB-CC-33",(short)1,(short)2));
        lista.add(new Maquina("Terra","150.162.100.3","AB-AA-DD",(short)1,(short)3));
        lista.add(new Maquina("Netuno","150.162.100.7","FF-BA-A5",(short)2,(short)1));
        lista.add(new Maquina("Urano","150.162.100.5","FF-00-1A",(short)2,(short)2));
        lista.add(new Maquina("Saturno","150.162.100.13","FF-AA-12",(short)2,(short)3));
        System.out.println("Maquinas geradas automaticamente!");
        bd.setMaquinas(lista);
    }
}
