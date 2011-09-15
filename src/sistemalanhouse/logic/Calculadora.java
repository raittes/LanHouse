package sistemalanhouse.logic;
public class Calculadora {
    public static long calculeTempo(Sessao.Hora entrada, Sessao.Hora saida){
        long horas,minutos;

        int horaInicio, horaFim, minInicio, minFim;

        horaInicio = entrada.getH();
        minInicio = entrada.getM();
        horaFim = saida.getH();
        minFim = saida.getM();
        
        horas = horaFim - horaInicio;
        
        if (minFim > minInicio)
            minutos = minFim - minInicio;
        else
            minutos = (minFim+60) - minInicio;
        if(horas > 0){
            minutos+= horas*60; 
        }
        return minutos;        
    }
    
    public static float calculePreco(long tempo, float tarifa){
        // tarifa a cada 5 minutos de uso;
        return   (tempo/5)*tarifa;
    }

}
