package dao;

public class DaoImpl2 implements IDao{
    @Override
    public double getTemperature() {
        double tempo = 23.86d; // temperature provient d'un Rest service
        return tempo;
    }
}
