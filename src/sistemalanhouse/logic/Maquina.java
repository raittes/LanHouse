package sistemalanhouse.logic;

/**
 *
 * @author grad
 */
public class Maquina {

    private String hostname;
    private String ip;
    private String mac;
    private short mesa;
    private short numero;

    public Maquina(String hostname, String ip, String mac,short mesa, short numero){
        this.hostname = hostname;
        this.ip = ip;
        this.mac = mac;
        this.mesa = mesa;
        this.numero = numero;
    }
    
    @Override
    public String toString(){
        return hostname;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public short getMesa() {
        return mesa;
    }

    public void setMesa(short mesa) {
        this.mesa = mesa;
    }

    public short getNumero() {
        return numero;
    }

    public void setNumero(short numero) {
        this.numero = numero;
    }


}
