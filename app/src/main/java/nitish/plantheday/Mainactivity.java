package nitish.plantheday;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 * Created by nitish on 2/7/2016.
 */
public class Mainactivity extends Activity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        Button BT1 = (Button) findViewById(R.id.main_bt1);

        BT1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                Intent main_i1 = new Intent(Mainactivity.this,Plan.class);
                startActivity(main_i1);


            }
        });
    }




    }

