package brosnetic.gonkulator.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import brosnetic.gonkulator.R;

/**
 * Created by dbros on 10/29/2018.
 */

public class MenuHome extends Fragment
{
    View view;

    public MenuHome()
    {
    }

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState)
//    {
//        super.onCreate(savedInstanceState);
//
//        //Start Activity(Introduction)
//
//    }
//
//    @Override
//    public void startActivity(Intent intent)
//    {
//        super.startActivity(intent);
//    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragment_menu_home, container, false);
        //return view;
        return super.onCreateView(inflater, container, savedInstanceState);
    }

}
