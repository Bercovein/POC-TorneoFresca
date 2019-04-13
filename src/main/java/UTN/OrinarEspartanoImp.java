package UTN;

public class OrinarEspartanoImp implements Orinar {
    public boolean Orinar(Humano humano) {

        try{
            boolean orina = false;

            Integer tolerancia = humano.getTolerancia();

            if(humano instanceof Espartano){
                Espartano h;
                h = (Espartano)humano;
                tolerancia = Math.round(tolerancia + h.getToleranciaExtra());
            }else if(humano instanceof Tabernero){
                Tabernero h;
                h = (Tabernero)humano;
                tolerancia = Math.round(tolerancia + h.getToleranciaExtra());
            }

            if(humano.getIngerido()>= tolerancia){
                orina = true;
            }
            return orina;
        }catch (ClassCastException e){
            throw e;
        }
    }
}
