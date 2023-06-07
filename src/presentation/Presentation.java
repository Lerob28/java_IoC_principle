package presentation;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Presentation {
    public static void main(String[] args) {
        /*
        * injection de dependance statique
        * Programation statique
        */
        /*IDao dao = new DaoImpl();
        MetierImpl metier = new MetierImpl();
        metier.setDao(dao);
        System.out.println("Temperature : "+metier.calcul());*/


        /*
         * injection de dependance dynamique ( Utilisation de l'API reflexion )
         * programmation dynamique
         */
        Scanner scanner;
        try {
            // recupere le nom des classes a charger dans l'app depuis le fichier de config
            scanner = new Scanner(new File("config.txt"));
            String daoClassName = scanner.next();
            String metierClassName = scanner.next();

            // charge dynamiquement les classes en memoire
            Class cDao = Class.forName(daoClassName);
            Class cMetier = Class.forName(metierClassName);

            // cree une instance de ces classes dynamiquement
            IDao dao = (IDao) cDao.newInstance();
            IMetier metier = (IMetier) cMetier.newInstance();

            // injection dynamique de dependeance
            Method m = cMetier.getMethod("setDao", IDao.class);
            m.invoke(metier, dao);

            System.out.println("Temperature : "+metier.calcul());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch ( Exception e) {
            throw new RuntimeException(e);
        }
    }
}