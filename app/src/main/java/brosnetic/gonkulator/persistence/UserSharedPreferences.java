package brosnetic.gonkulator.persistence;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.compat.BuildConfig;

/**
 * Created by dbros on 10/20/2018.
 * Class: UserSharedPrerferences
 * Use: Singleton class for storing/retrieving data from local file. Uses package enum(Preferences) for obtaining file keys/id
 */

//Singleton for accessing user shared preferences(file storage/persistence)
public class UserSharedPreferences extends Application
{
    //Attributes
    private static UserSharedPreferences instance = null;
    private final SharedPreferences sharedPreferences;
    private final String packageName;

    //Constructor
    UserSharedPreferences()
    {
        //fileName = context.getResources().getString(R.string.shared_preferences_file_name);     //defined in res->values
        packageName = BuildConfig.APPLICATION_ID;
        sharedPreferences = getApplicationContext().getSharedPreferences(packageName, Context.MODE_PRIVATE);
    }

    //Get instance method
    public static synchronized UserSharedPreferences getInstance()
    {
        if(instance == null)
        {
            instance = new UserSharedPreferences();
        }

        return instance;
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
        sharedPreferences.edit().putBoolean(Preferences.FIRST_RUN_FLAG.name(), isFirst).apply();
    }

    public void setDisclaimerFlag(final boolean isDisclaimerAgreed)
    {
        sharedPreferences.edit().putBoolean(Preferences.DISCLAIMER_FLAG.name(), isDisclaimerAgreed).apply();
    }













}
