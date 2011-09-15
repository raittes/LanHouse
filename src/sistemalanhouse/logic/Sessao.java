package sistemalanhouse.logic;

public class Sessao {

    private Maquina maquina;
    private Cliente cliente;
    private Hora entrada;
    private Hora saida;
    public Sessao(Maquina m, Cliente c){
        this.maquina=m;
        this.cliente=c;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Maquina getMaquina() {
        return maquina;
    }

    public Hora getEntrada() {
        return entrada;
    }

    public void setEntrada(Hora entrada) {
        this.entrada = entrada;
    }

    public Hora getSaida() {
        return saida;
    }

    public void setSaida(Hora saida) {
        this.saida = saida;
    }
    public static class Hora {
        private int h;
        private int m;

        public Hora(int h, int m) {
            this.h=h;
            this.m=m;
        }
        @Override
        public String toString(){
            return (h+":"+m);
        }

        public int getH() {
            return h;
        }

        public void setH(int h) {
            this.h = h;
        }

        public int getM() {
            return m;
        }

        public void setM(int m) {
            this.m = m;
        }

    }
}
