package brosnetic.gonkulator.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;
import brosnetic.gonkulator.R;
import brosnetic.gonkulator.fragments.Disclaimer;
import brosnetic.gonkulator.fragments.MenuHome;
import brosnetic.gonkulator.fragments.Tutorial;
import brosnetic.gonkulator.fragments.ViewPagerAdapter;
import brosnetic.gonkulator.persistence.UserSharedPreferences;


public class Introduction extends AppCompatActivity implements TabLayout.OnTabSelectedListener
{
    //Attributes
    private String TAG;
    private static UserSharedPreferences userSharedPreferences;
    private AppBarLayout appBarLayout;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;


    //System methods
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        TAG = this.getLocalClassName();
        Log.i(TAG, "onCreate()");

        //Setup views
        appBarLayout = (AppBarLayout) findViewById(R.id.appbarid);
        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        viewPager = (ViewPager) findViewById(R.id.viewpager_id);

        //Setup viewPager adapter
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        addFragments();
        viewPager.setAdapter(adapter);

        //Setup tabLayout with viewPager
        tabLayout.setupWithViewPager(viewPager);


        tabLayout.addOnTabSelectedListener(this);
    }



    @Override
    protected void onStart()
    {
        super.onStart();

        Log.i(TAG, "onStart()");

        //Instantiate attributes
        userSharedPreferences = UserSharedPreferences.getInstance();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.i(TAG, "onResume()");
    }




    //Custom methods
    private void addLayoutTabs()
    {
        TabLayout.Tab disclaimerTab = tabLayout.newTab();
        disclaimerTab.setTag("Disclaimer");
        disclaimerTab.setText("Disclaimer");
        tabLayout.addTab(disclaimerTab, 0);

        TabLayout.Tab tutorialTab = tabLayout.newTab();
        tutorialTab.setTag("Tutorial");
        tutorialTab.setText("Tutorial");
        tabLayout.addTab(tutorialTab, 1);

        TabLayout.Tab menuTab = tabLayout.newTab();
        menuTab.setTag("Menu");
        menuTab.setText("Menu");
        tabLayout.addTab(menuTab, 2);
    }



    private void addFragments()
    {
        adapter.addFragment(new Disclaimer(), "Disclaimer");      //Future task: only load(disclaimer) if not accepted
        adapter.addFragment(new Tutorial(), "Tutorial");
        adapter.addFragment(new MenuHome(), "Main Menu");
    }


    //TabListener event methods
    @Override
    public void onTabSelected(TabLayout.Tab tab)
    {
        //If menu tab then start activity(MainMenu)     *first check for disclaimer flag

        Log.i(TAG, "onTabSelected()");

        //Verify disclaimer accepted
        if(!userSharedPreferences.getDisclaimerFlag())
        {
            viewPager.invalidate();

            //Reload disclaimer fragment
            finish();
            startActivity(getIntent());
            Toast.makeText(this, "You must accept disclaimer to use app", Toast.LENGTH_LONG).show();
            return;
        }


        //If tab Tutorial
        if(tab.getPosition() == 1)
        {

        }

        //If tab Main Menu
        if(tab.getPosition() == 2)
        {
            //Start Activity(MainMenu)
            Intent intent = new Intent(this, MainMenu.class);
            startActivity(intent);
            finish();

        }

//        if(tab.getTag().equals("Menu"))
//        {
//            //Start Activity(MainMenu)
//            Intent intent = new Intent(this, MainMenu.class);
//            startActivity(intent);
//            finish();
//        }


//        if(tab.getPosition() == 2 && tab.getText().equals("Menu"))
//        {
//
//        }



    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab)
    {
        Log.i(TAG, "onTabUnselected()");

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab)
    {
        Log.i(TAG, "onTabReselected()");

    }


}
