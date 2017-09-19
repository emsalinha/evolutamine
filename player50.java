import java.lang.Exception;
import java.util.Properties;
import java.util.Random;

import org.vu.contest.ContestEvaluation;
import org.vu.contest.ContestSubmission;


public class player50 implements ContestSubmission
{
    Random rnd;
    ContestEvaluation evaluation;
    private int evaluation_limit;
    private Population population;
    private final int populationSize = 100;
    String name;

    public player50()
    {
        name = "evolutamine";
        rnd = new Random();
    }

    public void setSeed(long seed)
    {
        // Set seed of algortihms random process
        rnd.setSeed(seed);
    }

    public void setEvaluation(ContestEvaluation evaluation)
    {
        // Set evaluation problem used in the run
        this.evaluation = evaluation;

        // Get evaluation properties
        Properties props = evaluation.getProperties();
        // Get evaluation limit
        evaluation_limit = Integer.parseInt(props.getProperty("Evaluations"));
        // Property keys depend on specific evaluation
        // E.g. double param = Double.parseDouble(props.getProperty("property_name"));
        boolean isMultimodal = Boolean.parseBoolean(props.getProperty("Multimodal"));
        boolean hasStructure = Boolean.parseBoolean(props.getProperty("Regular"));
        boolean isSeparable = Boolean.parseBoolean(props.getProperty("Separable"));

        // Do sth with property values, e.g. specify relevant settings of your algorithm
        if (isMultimodal) {
            // Do sth
        } else {
            // Do sth else
        }
    }

    public void run()
    {
        // Run your algorithm here
        int evals = 0;

        // init population
        population = initPopulation();

        // calculate fitness
        population.calculateFitness(evaluation);

        while (evals < evaluation_limit) {
            // Select parents

            // Apply crossover / mutation operators

            // Check fitness of unknown function
            try {
                population.calculateFitness(evaluation);
            } catch (NullPointerException e) {
                System.out.println("\033[1mEvaluation limit reached!\033[0m");
                break;
            }

            // Select survivors

            evals++;
        }
    }

    private Population initPopulation()
    {
        return new Population(populationSize, rnd);
    }
}
