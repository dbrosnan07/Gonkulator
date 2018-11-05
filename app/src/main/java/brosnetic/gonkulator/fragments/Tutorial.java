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

public class Tutorial extends Fragment
{
    View view;

    public Tutorial()
    {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragment_tutorial, container, false);
        //return view;
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
