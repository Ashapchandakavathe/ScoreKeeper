package in.ac.bldeacet.scorekeeper;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mScoreText1;
    private TextView mScoreText2;

    private int mScore1;
    private int mScore2;

    static final String STATE_SCORE_1="Team 1 Score";
    static final String STATE_SCORE_2="Team 2 Score";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScoreText1=(TextView) findViewById(R.id.Score_1);
        mScoreText2=(TextView) findViewById(R.id.Score_2);



        if (savedInstanceState !=null){

            mScoreText1.setText(String.valueOf(mScore1));
            mScoreText2.setText(String.valueOf(mScore2));

        }
    }

    public  boolean onCreateOptionMenu(Menu menu ){
        getMenuInflater().inflate(R.menu.main_menu,menu);

        int nightMode= AppCompatDelegate.getDefaultNightMode();
        if(nightMode==AppCompatDelegate.MODE_NIGHT_YES) {
            menu.findItem(R.id.night_mode). setTitle("Day mode");
        }else{
            menu.findItem(R.id.night_mode).setTitle("Night mode");
        }
        return true;
    }

    public boolean onOptionItemSelected(MenuItem item){
        if(item.getItemId()==R.id.night_mode){
            int nightmode=AppCompatDelegate.getDefaultNightMode();

            if(nightmode==AppCompatDelegate.MODE_NIGHT_YES){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            recreate();
            return  true;
        }
        return  super.onOptionsItemSelected(item);
    }

    public void decreaseScore(View view) {
        int viewID = view.getId();
        switch (viewID) {

            case R.id.decreaseTeam1:
               int mScore1=0;
                mScore1--;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            case R.id.decreaseTeam2:
                int mScore2=0;
                mScore2--;
                mScoreText2.setText(String.valueOf(mScore2));
        }
    }


    public void increaseScore(View view) {

        int viewID = view.getId();
        switch (viewID) {

            case R.id.increaseTeam1:
                int mScore1=0;
                mScore1++;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            case R.id.increaseTeam2:
                int mScore2=0;
                mScore2++;
                mScoreText2.setText(String.valueOf(mScore2));
        }

    }
    protected  void  onSaveInstenceState(Bundle outState){
        outState.putInt(STATE_SCORE_1, mScore1);
        outState.putInt(STATE_SCORE_2, mScore2);
        super.onSaveInstanceState(outState);

    }
}
