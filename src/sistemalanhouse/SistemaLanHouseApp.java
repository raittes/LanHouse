/*
 * SistemaLanHouseApp.java
 */

package sistemalanhouse;

import java.util.ArrayList;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;
import sistemalanhouse.auxiliar.CriaMaquinas;
import sistemalanhouse.logic.BD;
import sistemalanhouse.logic.Cliente;
import sistemalanhouse.logic.Maquina;

/**
 * The main class of the application.
 */
public class SistemaLanHouseApp extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        BD bd = new BD(new ArrayList<Cliente>(), new ArrayList<Maquina>());
        
        //Gera automaticamente!
        CriaMaquinas creator = new CriaMaquinas(bd);
        show(new SistemaLanHouseView(this, bd));
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of SistemaLanHouseApp
     */
    public static SistemaLanHouseApp getApplication() {
        return Application.getInstance(SistemaLanHouseApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(SistemaLanHouseApp.class, args);


    }
}
