package nitish.plantheday;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by nitish on 2/7/2016.
 */

public class Plan extends Activity {


    TextView Plan_tv1, Plan_tv2;
    Button Plan_bt1,Plan_bt2;
    EditText Plan_et1;
    public static final String PREFERENCES_TODO = "TODO_List_Shared_Preferences";
    final Context context = this;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plan);

        Plan_tv1 = (TextView) findViewById(R.id.plan_tv1);
        Plan_tv2 = (TextView) findViewById(R.id.plan_tv2);
        Plan_bt1 = (Button) findViewById(R.id.plan_bt1);
        Plan_et1 = (EditText) findViewById(R.id.plan_et1);
        Plan_bt2 = (Button) findViewById(R.id.plan_bt2);

        final ArrayList<String> noteList = new ArrayList<String>();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(Plan.this, R.layout.activity_listview, noteList);

      final ListView listView = (ListView) findViewById(R.id.task_list);



        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        Plan_tv2.setText(date);


        final SharedPreferences prefs = context.getSharedPreferences(PREFERENCES_TODO,
                MODE_PRIVATE);






        Plan_bt1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


                noteList.add(Plan_et1.getText().toString());

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(Plan.this, R.layout.activity_listview, noteList);

                listView.setAdapter(adapter);
                Plan_et1.setText("");




            }
        });


        Plan_bt2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


                SharedPreferences.Editor editor = prefs.edit();
               // This will remove all entries of the specific SharedPreferences
                editor.clear();
                for (int i = 0; i < adapter.getCount(); ++i){
                    // This assumes you only have the list items in the SharedPreferences.
                    editor.putString(String.valueOf(i), adapter.getItem(i));
                }
                editor.commit();


                Toast.makeText(getBaseContext(),"DONEEEEE",
                        Toast.LENGTH_SHORT).show();








            }
        });

    }






    }

