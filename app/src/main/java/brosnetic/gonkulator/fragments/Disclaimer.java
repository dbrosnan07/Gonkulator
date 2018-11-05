package brosnetic.gonkulator.fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.compat.BuildConfig;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import brosnetic.gonkulator.R;
import brosnetic.gonkulator.persistence.Preferences;

/**
 * Created by dbros on 10/29/2018.
 */

public class Disclaimer extends Fragment implements View.OnClickListener
{
    //Attributes
    private View view;
    private CheckBox disclaimerCheckbox;
    SharedPreferences sharedPreferences;

    public Disclaimer()
    {
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        //Initialize
        view = inflater.inflate(R.layout.fragment_disclaimer, container, false);
        disclaimerCheckbox = (CheckBox)view.findViewById(R.id.checkBox);
        disclaimerCheckbox.setOnClickListener(this);
        return view;
    }

    @Override
    public void onStart()
    {
        super.onStart();
    }

    @Override
    public void onClick(View v)
    {
        sharedPreferences = this.getActivity().getSharedPreferences(BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE);

        if(disclaimerCheckbox.isChecked())
        {
            Log.i("Disclaimer", "isChecked");
            sharedPreferences.edit().putBoolean(Preferences.DISCLAIMER_FLAG.name(), true).commit();
        }
        else
        {
            Log.i("Disclaimer", "isNotChecked");
            sharedPreferences.edit().putBoolean(Preferences.DISCLAIMER_FLAG.name(), false).commit();
        }

        Log.i("Disclaimer(flag) ", String.valueOf(sharedPreferences.getBoolean(Preferences.DISCLAIMER_FLAG.name(), false)));
    }


}
