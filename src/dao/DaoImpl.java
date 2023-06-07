package dao;

public class DaoImpl implements IDao{
    @Override
    public double getTemperature() {
        double tempo = 24.0d; // temperature provient d'une BD
        return tempo;
    }
}
