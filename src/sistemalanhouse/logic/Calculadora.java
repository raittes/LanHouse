package sistemalanhouse.logic;

import sistemalanhouse.exception.FimMenorInicioHoraExcepition;

public class Calculadora {
    public static long calculeTempo(Sessao sessao) throws FimMenorInicioHoraExcepition{
        long horas,minutos;

        int horaInicio, horaFim, minInicio, minFim;

        horaInicio = sessao.getEntrada().getH();
        minInicio = sessao.getEntrada().getM();
        horaFim = sessao.getSaida().getH();
        minFim = sessao.getSaida().getM();
        
        horas = horaFim - horaInicio;
        
        if (minFim > minInicio)
            minutos = minFim - minInicio;
        else{
            horas--;
            minutos = (minFim+60) - minInicio;
        }
        if(horas < 0|| minutos<0){
             throw new FimMenorInicioHoraExcepition();
        }
        return minutos+= horas*60;
    }
    
    public static float calculePreco(long tempo, float tarifa){
        // tarifa a cada 5 minutos de uso;
        return   (tempo/5)*tarifa;
    }

}
