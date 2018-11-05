package brosnetic.gonkulator.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.compat.BuildConfig;
import android.util.Log;
import brosnetic.gonkulator.R;
import brosnetic.gonkulator.persistence.Preferences;


public class MainMenu extends Activity
{
    //Attributes
    private String TAG;
    SharedPreferences sharedPreferences;


    //System methods     *Start flow: onCreate() -> onStart() -> onResume()
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        TAG = this.getLocalClassName();
        Log.i(TAG, "onCreate()");
    }


    @Override
    protected void onStart()
    {
        super.onStart();
        Log.i(TAG, "onStart()");

        //To-Do: add internet connection diagnostics(networking)
        //To-Do: add google sheet cloud connection diagnostics(networking)
    }


    @Override
    protected void onResume()
    {
        super.onResume();
        Log.i(TAG, "onResume()");


        //Check sharedPreferences
        sharedPreferences = getSharedPreferences(BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE);
        boolean isFirstRun = sharedPreferences.getBoolean(Preferences.FIRST_RUN_FLAG.name(), true);
        Log.i(TAG, String.valueOf(isFirstRun));

        if(isFirstRun)
        {
            //Start Activity(Introduction)
            Intent intent = new Intent(this, Introduction.class);
            startActivity(intent);
            finish();
        }
    }






}
