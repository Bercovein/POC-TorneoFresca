package UTN;

public class OrinarVikingoImp implements Orinar{

    public boolean Orinar(Humano humano) {

        try{
            boolean orina = false;

            if( humano.getIngerido()>= humano.getTolerancia()){
                orina = true;
            }
            return orina;

        }catch (NullPointerException e){
            throw e;
        }

    }
}
