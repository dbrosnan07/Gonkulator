package brosnetic.gonkulator.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dbros on 10/29/2018.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter
{
    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> fragmentListTitles = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position)
    {
//        switch (position)
//        {
//            case 0:
//                Disclaimer disclaimerTab = new Disclaimer();
//                return disclaimerTab;
//            case 1:
//                Tutorial tutorialTab = new Tutorial();
//                return tutorialTab;
//            default:
//                return null;
//        }

        return fragmentList.get(position);
    }

    @Override
    public int getCount()
    {
        return fragmentListTitles.size();
//        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        return fragmentListTitles.get(position);
    }






    public void addFragment(Fragment fragment, String title)
    {
        fragmentList.add(fragment);
        fragmentListTitles.add(title);
    }


}
