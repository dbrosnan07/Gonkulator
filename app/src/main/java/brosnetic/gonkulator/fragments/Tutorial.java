package brosnetic.gonkulator.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnRenderListener;
import brosnetic.gonkulator.R;

/**
 * Created by dbros on 10/29/2018.
 */

public class Tutorial extends Fragment implements OnRenderListener
{
    //Attributes
    View view;
    PDFView pdfView;

    public Tutorial()
    {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragment_tutorial, container, false);
        pdfView = (PDFView)view.findViewById(R.id.pdfView);
        pdfView.fromAsset("introduction.pdf")
                .onRender(this)
                .load();
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
