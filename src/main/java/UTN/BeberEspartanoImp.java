package UTN;

public class BeberEspartanoImp implements Beber {
    public Integer Beber(Humano humano, Pinta pinta) {

        try{

            Integer bebido = Math.round((humano.getImc() * pinta.getGraduacion()));

            return (humano.getIngerido() + bebido);

        }catch(NullPointerException e){
            throw e;
        }

    }
}
