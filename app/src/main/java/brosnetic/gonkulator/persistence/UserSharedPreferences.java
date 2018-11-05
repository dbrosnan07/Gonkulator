package brosnetic.gonkulator.persistence;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * Created by dbros on 10/20/2018.
 * Class: UserSharedPrerferences
 * Use: Singleton class for storing/retrieving data from local file. Uses package enum(Preferences) for obtaining file keys/id
 */

//Singleton for accessing user shared preferences(file storage/persistence)
public class UserSharedPreferences
{
    //Attributes
    private static UserSharedPreferences instance = null;
    private final SharedPreferences sharedPreferences;
    private final String fileName = "sharedPreferencesFile";

    //Constructor
    private UserSharedPreferences(Context context)
    {
        sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
    }

    //Get instance method
    public static synchronized UserSharedPreferences getInstance(Context context)
    {
        if(instance == null)
        {
            instance = new UserSharedPreferences(context.getApplicationContext());
        }

        return instance;
    }

    public static synchronized UserSharedPreferences getInstance()
    {
        if(instance != null)
        {
            return instance;
        }

        throw new IllegalArgumentException("Should use getInstance(Context) at least once before using this method.");
    }

    //Get methods
    public boolean getFirstRunFlag()
    {
        return sharedPreferences.getBoolean(Preferences.FIRST_RUN_FLAG.name(), true);
    }

    public boolean getDisclaimerFlag()
    {
        return sharedPreferences.getBoolean(Preferences.FIRST_RUN_FLAG.name(), false);
    }

    //Set methods
    public void setFirstRunFlag(final boolean isFirst)
    {
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putBoolean(Preferences.FIRST_RUN_FLAG.name(), isFirst);
//        editor.commit();

        sharedPreferences.edit().putBoolean(Preferences.FIRST_RUN_FLAG.name(), isFirst).apply();
    }

    public void setDisclaimerFlag(final boolean isDisclaimerAgreed)
    {
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putBoolean(Preferences.DISCLAIMER_FLAG.name(), isDisclaimerAgreed);
//        editor.commit();

        sharedPreferences.edit().putBoolean(Preferences.DISCLAIMER_FLAG.name(), isDisclaimerAgreed).apply();
    }













}
