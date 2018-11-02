package brosnetic.gonkulator.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import brosnetic.gonkulator.R;
import brosnetic.gonkulator.persistence.UserSharedPreferences;


public class MainMenu extends Activity
{
    //Attributes
    private String TAG;
    private static UserSharedPreferences userSharedPreferences;


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

        //Instantiate attributes
        userSharedPreferences = UserSharedPreferences.getInstance();
    }


    @Override
    protected void onResume()
    {
        super.onResume();
        Log.i(TAG, "onResume()");

        //Instantiate attributes
        userSharedPreferences = UserSharedPreferences.getInstance();


        Log.i(TAG, String.valueOf(userSharedPreferences.getFirstRunFlag()));
        Log.i(TAG, String.valueOf(userSharedPreferences.getDisclaimerFlag()));



        //To-Do: call methods from ActivityStateNavigator to handle activity logic

        //Activity navigator logic
        if(userSharedPreferences.getFirstRunFlag() == true)
        {
            //Start Activity(Introduction)
            Intent intent = new Intent(this, Introduction.class);
            startActivity(intent);
            finish();
        }
    }






}
