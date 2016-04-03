package alvi17.songbidhansongsodhonsomuho;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import adapters.ExpandaleListAdapter;

public class MainActivity extends AppCompatActivity {


    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, String> listDataChild;


    AdView adView;
    FrameLayout fm;
    private InterstitialAd interstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        expListView = (ExpandableListView) findViewById(R.id.expandableListView);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandaleListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=MRA17"));
                startActivity(browserIntent);
                Snackbar.make(view, "Visit Our Play Store Account For More Apps", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });



        adView = new AdView(this);
        adView.setAdUnitId("ca-app-pub-6508526601344465/7391646435");
        adView.setAdSize(AdSize.BANNER);
        LinearLayout layout = (LinearLayout)findViewById(R.id.linearLayout);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        layout.addView(adView);

        interstitial=new  InterstitialAd(this);
        interstitial.setAdUnitId("ca-app-pub-6508526601344465/2562664039");
        AdRequest aRequest = new AdRequest.Builder().build();

        // Begin loading your interstitial.
        interstitial.loadAd(aRequest);

        interstitial.setAdListener(
                new AdListener() {
                    @Override
                    public void onAdLoaded() {
                        super.onAdLoaded();
                        interstitial.show();
                    }
                }
        );

    }


    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, String>();

        // Adding child data
        listDataHeader.add(getResources().getString(R.string.first_title));
        listDataHeader.add(getResources().getString(R.string.second_title));
        listDataHeader.add(getResources().getString(R.string.third_title));
        listDataHeader.add(getResources().getString(R.string.fourth_title));
        listDataHeader.add(getResources().getString(R.string.fifth_title));
        listDataHeader.add(getResources().getString(R.string.sixth_title));
        listDataHeader.add(getResources().getString(R.string.seventh_title));
        listDataHeader.add(getResources().getString(R.string.eighth_title));
        listDataHeader.add(getResources().getString(R.string.ninth_title));
        listDataHeader.add(getResources().getString(R.string.tenth_title));
        listDataHeader.add(getResources().getString(R.string.eleventh_title));
        listDataHeader.add(getResources().getString(R.string.twelvth_title));
        listDataHeader.add(getResources().getString(R.string.thirteenth_title));
        listDataHeader.add(getResources().getString(R.string.fourteenth_title));
        listDataHeader.add(getResources().getString(R.string.fifteenth_title));
        listDataHeader.add(getResources().getString(R.string.sixteenth_title));

        // Adding child data


        listDataChild.put(listDataHeader.get(0), getResources().getString(R.string.first)); // Header, Child data
        listDataChild.put(listDataHeader.get(1),getResources().getString(R.string.second) );
        listDataChild.put(listDataHeader.get(2),getResources().getString(R.string.third) );
        listDataChild.put(listDataHeader.get(3),getResources().getString(R.string.fourth) );
        listDataChild.put(listDataHeader.get(4),getResources().getString(R.string.fifth) );
        listDataChild.put(listDataHeader.get(5),getResources().getString(R.string.sixth) );
        listDataChild.put(listDataHeader.get(6), getResources().getString(R.string.seventh));
        listDataChild.put(listDataHeader.get(7), getResources().getString(R.string.eightth));
        listDataChild.put(listDataHeader.get(8), getResources().getString(R.string.ninth));
        listDataChild.put(listDataHeader.get(9), getResources().getString(R.string.tenth));
        listDataChild.put(listDataHeader.get(10),getResources().getString(R.string.eleventh) );
        listDataChild.put(listDataHeader.get(11),getResources().getString(R.string.twelvth) );
        listDataChild.put(listDataHeader.get(12),getResources().getString(R.string.thirtheenth) );
        listDataChild.put(listDataHeader.get(13),getResources().getString(R.string.fourteenth) );
        listDataChild.put(listDataHeader.get(14),getResources().getString(R.string.fifteenth) );
        listDataChild.put(listDataHeader.get(15),getResources().getString(R.string.sixteenth) );

     //   listDataChild.put(listDataHeader.get(1), nowShowing);

     //   listDataChild.put(listDataHeader.get(2), comingSoon);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }
}
