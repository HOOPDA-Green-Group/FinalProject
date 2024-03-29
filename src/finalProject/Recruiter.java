package finalProject;

import java.util.Random;
import java.util.logging.Level;

/**
 * 
 * 
 * @author
 * @version 04/11/2023
 */
public class Recruiter extends Role {

    /** The chance the recruiter has to recruite someone **/
    private static final double RECRUITING_CHANCE = 50.0;
    
    /**
     * Constructor
     */
    public Recruiter() {

    }

    /**
     * Try to recruit a non member
     * @param target The person to be recruiter
     * @param organization The organization
     * @return If the target was successfully recruited or not
     */
    public boolean tryToRecruit(Person target, Organization organization) {
        Random rand = new Random();
        if(target != null) {
            if(rand.nextDouble(100) > RECRUITING_CHANCE) {
                recruit(target, organization);
                return true;
            }
            else return false;
        }
        else {
            logger.log(Level.WARNING, "Object target is null");
            return false;
        }
    }

    /**
     * Successfully recruit a non member
     * @param recruitee The non member
     * @param organization The organization
     */
    public void recruit(Person recruitee, Organization organization) {
        if(recruitee != null && organization != null) {
            organization.getMembers().add(recruitee);
        }
        else {
            logger.log(Level.WARNING, "The input recruitee or organization is null.");
        }
    }
}