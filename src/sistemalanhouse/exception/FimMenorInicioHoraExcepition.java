/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemalanhouse.exception;

/**
 *
 * @author marcos
 */
public class FimMenorInicioHoraExcepition extends Exception{

    public FimMenorInicioHoraExcepition() {
        
    }
    
    public String getMessage(){
        return "Hora Final Menor que Hora Inicial!";
    }

}
