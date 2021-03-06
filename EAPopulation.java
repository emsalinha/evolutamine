import org.vu.contest.ContestEvaluation;

public interface EAPopulation
{
    public int evaluateInitialPopulation(ContestEvaluation evaluation);

    public void selectParents();

    public void crossover();

    public void mutate(double epsilon);

    public int evaluateOffspring(ContestEvaluation evaluation);

    public void selectSurvivors();
}
