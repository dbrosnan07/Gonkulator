package brosnetic.gonkulator.persistence;

/**
 * Created by dbros on 10/20/2018.
 */

public enum Preferences
{
    FIRST_RUN_FLAG("FIRST_RUN_FLAG"),
    DISCLAIMER_FLAG("DISCLAIMER_FLAG");

    private final String preference;

    Preferences(String preference)
    {
        this.preference = preference;
    }
}
