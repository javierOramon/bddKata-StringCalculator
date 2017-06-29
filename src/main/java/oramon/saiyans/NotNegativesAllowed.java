package oramon.saiyans;

public class NotNegativesAllowed extends Error {

    @Override
    public String getMessage() {
        return "no negatives allowed";
    }
}
