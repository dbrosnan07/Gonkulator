package brosnetic.gonkulator.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import brosnetic.gonkulator.R;
import brosnetic.gonkulator.persistence.UserSharedPreferences;

/**
 * Created by dbros on 10/29/2018.
 */

public class Disclaimer extends Fragment implements View.OnClickListener
{
    //Attributes
    private View view;
    private CheckBox disclaimerCheckbox;
    private Context context;
    private static UserSharedPreferences userSharedPreferences;

    public Disclaimer()
    {
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        this.context = context;
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
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onStart()
    {
        super.onStart();
        userSharedPreferences = UserSharedPreferences.getInstance();
    }

    @Override
    public void onClick(View v)
    {
        //userSharedPreferences = UserSharedPreferences.getInstance(getActivity());

        if(disclaimerCheckbox.isChecked())
        {
            Log.i("Disclaimer", "isChecked");
            userSharedPreferences.setDisclaimerFlag(true);
        }
        else
        {
            Log.i("Disclaimer", "isNotChecked");
            userSharedPreferences.setDisclaimerFlag(false);
        }

        Log.i("Disclaimer => flag: ", String.valueOf(userSharedPreferences.getDisclaimerFlag()));
    }


//    public void onCheckboxClicked(View view)
//    {
//        // Is the view now checked?
//        boolean checked = ((CheckBox) view).isChecked();
//
//        if(checked)
//        {
//            userSharedPreferences.setDisclaimerFlag(true);
//        }
//        else
//        {
//            userSharedPreferences.setDisclaimerFlag(false);
//        }
//    }




}
