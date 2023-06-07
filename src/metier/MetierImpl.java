package metier;

import dao.IDao;

public class MetierImpl implements  IMetier{
    private IDao dao;

    public void setDao(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {
        double result = dao.getTemperature();
        return result * 7;
    }
}
