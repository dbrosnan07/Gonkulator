package brosnetic.gonkulator.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.compat.BuildConfig;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnRenderListener;
import brosnetic.gonkulator.R;
import brosnetic.gonkulator.persistence.Preferences;

/**
 * Created by dbros on 10/29/2018.
 */

public class Tutorial extends Fragment implements OnRenderListener
{
    //Attributes
    View view;
    PDFView pdfView;
    SharedPreferences sharedPreferences;

    public Tutorial()
    {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragment_tutorial, container, false);
        pdfView = (PDFView)view.findViewById(R.id.pdfView);
        sharedPreferences = this.getActivity().getSharedPreferences(BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE);
        boolean disclaimerAccepted = sharedPreferences.getBoolean(Preferences.DISCLAIMER_FLAG.name(), false);

        //If disclaimer accepted then load pdf view
        if(disclaimerAccepted)
        {
            pdfView.fromAsset("introduction.pdf")
                    .onRender(this)
                    .load();
        }

        return view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onInitiallyRendered(int nbPages, float pageWidth, float pageHeight)
    {
        pdfView.fitToWidth();
        pdfView.enableDoubletap(true);
    }


}
