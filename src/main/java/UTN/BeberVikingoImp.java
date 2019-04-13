package UTN;

public class BeberVikingoImp implements Beber {
    public Integer Beber(Humano humano, Pinta pinta) {

        try{
            Float graduacion = pinta.getGraduacion();

            if(humano instanceof Vikingo){
                Vikingo h;
                h = (Vikingo)humano;
                graduacion = graduacion - h.getBebedorProfesional();
            }else if(humano instanceof Tabernero){
                Tabernero h;
                h = (Tabernero)humano;
                graduacion = graduacion - h.getBebedorProfesional();
            }

            Integer bebido = Math.round(humano.getImc() * graduacion);

            return (humano.getIngerido() + bebido);

        }catch (ClassCastException e){
            throw e;
        }
    }
}
