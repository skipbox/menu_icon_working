package goals.dream.menu_icon_working;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import static java.util.logging.Logger.global;

public class MainActivity extends AppCompatActivity {
      //SharedPreferences========================================================
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String key_1 = "k1";
    public static final String key_2 = "k2";
    public static final String key_3 = "k3";

       public static final String key_show_buttons = "true"; //x
       public static final String key_bell = "key_bell_false"; //x
       public static final String key_star = "key_star_false"; //x
    //can also use integers
    SharedPreferences sharedpreferences;
//SharedPreferences========================================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //my stuff
        this.setTitle("this.setTitle");
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }//end of oncreate
Menu my_menu;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
     // Inflate the menu; this adds items to the action bar if it is present.
     getMenuInflater().inflate(R.menu.menu_main, menu);

    // Save the menu reference
    //Menu my_menu;
    my_menu = menu;
    //return super.onCreateOptionsMenu(menu);
    return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
         if (id == R.id.action_1) {
            finish();
            startActivity(getIntent());
            }
          if (id == R.id.action_2) {
            Toast.makeText(this, "action_2", Toast.LENGTH_SHORT).show();
            }
         if (id == R.id.action_3) {
            Toast.makeText(this, "action_3", Toast.LENGTH_SHORT).show();
            }
        if (id == R.id.action_settings) {
            Toast.makeText(this, "action_settings", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.action_exit) {
            Toast.makeText(this, "Bye bye", Toast.LENGTH_SHORT).show();
            finish();
            return true;
        }
 //menu icons below
        if (id == R.id.menu_top_star) {
            global_star=!global_star;
            set_menu_icons();
        }
         if (id == R.id.menu_top_bell) {
            //Toast.makeText(this, "menu_top_bell", Toast.LENGTH_SHORT).show();
            //MenuItem item_x = my_menu.findItem(R.id.menu_top_bell); //find ITEM

            global_bell=!global_bell;
            set_menu_icons();

//         if(global_bell == true){item_x.setIcon(R.drawable.ic_alarm_on_black_24dp);}
//         if(global_bell == false){item_x.setIcon(R.drawable.ic_alarm_off_black_24dp);}
//         global_bell=!global_bell;



             //set_menu_icons();
           // return true;
        }
        return super.onOptionsItemSelected(item);
    }

//For set Title : getActionBar().setTitle("Title");
//For set Icon: getActionBar().setIcon(R.drawable.YOUR_ICON_NAME);
//
          //button clicks------------------------------------------------------------------
    public void buttonOnClick(View view) {
        int the_id = view.getId();
        if (the_id == R.id.b1) {
            //ImageView img_1_x = (ImageView)findViewById(R.id.img_1);
            //getActionBar().setIcon(R.drawable.lock_2);
            //getActionBar().setTitle("Icon");


        }
        if (the_id == R.id.b2) {
            Toast.makeText(this, "but_2_works", Toast.LENGTH_SHORT).show();
        }
        if (the_id == R.id.b3) {
            Toast.makeText(this, "but_3_works", Toast.LENGTH_SHORT).show();
        }
    }


//IMAGE  clicks------------------------------------------------------------------
    public void img_click_control(View view) {
        int the_id = view.getId();
        if (the_id == R.id.img_v_1) {
            Toast.makeText(this, "but_2_works", Toast.LENGTH_SHORT).show();
        }
        if (the_id == R.id.img_v_2) {
            Toast.makeText(this, "img_v_2", Toast.LENGTH_SHORT).show();
        }
        if (the_id == R.id.img_v_3) {
            Toast.makeText(this, "img_v_3", Toast.LENGTH_SHORT).show();
        }
    }

Boolean global_bell = false;
Boolean global_star = false;
 //============== shared pref
        private void load_shared_pref() {
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String temp_1 = sharedpreferences.getString(key_bell,"false_false");
        String temp_2 = sharedpreferences.getString(key_star,"false_false");


        if(sharedpreferences.getString(key_bell,"default").equals("false_false")){
        global_bell = false;}
        if(sharedpreferences.getString(key_bell,"default").equals("true_true")){
        global_bell = true;}


          //global_bell=!global_bell;
        boolean key_show_buttons_x = Boolean.parseBoolean(sharedpreferences.getString(key_show_buttons,"true"));
        LinearLayout layout_show_hide_x = (LinearLayout)findViewById(R.id.layout_show_hide);
        if(key_show_buttons_x == true){layout_show_hide_x.setVisibility(View.VISIBLE);}
        if(key_show_buttons_x == false){layout_show_hide_x.setVisibility(View.GONE);}

        //php_data = "email_x="+temp_1+"&"+"pass_x="+temp_2;
        //TextView tv_debg_1_x =(TextView)findViewById(R.id.tv_debg_1);
       // tv_debg_1_x.setText(php_data);
    }
//==================
     //public void set_menu_icons (MenuItem item){
     public void set_menu_icons (){
        //notice its find by item not find by id
         MenuItem item_aaa = my_menu.findItem(R.id.menu_top_bell); //find ITEM
         if(global_bell == true){item_aaa.setIcon(R.drawable.ic_alarm_on_black_24dp);}
         if(global_bell == false){item_aaa.setIcon(R.drawable.ic_alarm_off_black_24dp);}

         MenuItem item_bbb = my_menu.findItem(R.id.menu_top_star); //find ITEM
         if(global_star == true){item_bbb.setIcon(R.drawable.transparent_bulb_off_200px);}
         if(global_star == false){item_bbb.setIcon(R.drawable.transparent_light_on);}

    }

}





        //repalce this with the sharedPref key

        //if(global_bell == true){item.setIcon(getResources().getDrawable(R.drawable.ic_alarm_on_black_24dp));}
        //if(global_bell == false){item.setIcon(getResources().getDrawable(R.drawable.ic_alarm_off_black_24dp));}
        //global_bell=!global_bell;
