package com.remotepatientmonitoringsystem.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Doctor Name : A.K. Roy", "Location Address : Behala", "Experience : 5 Yrs", "Contact No. : +91 1212121212", "600"},
                    {"Doctor Name : B.K. Das", "Location Address : Birati", "Experience : 6 Yrs", "Contact No. : +91 1212121213", "500"},
                    {"Doctor Name : C.K. Mondal", "Location Address : Bally", "Experience : 3 Yrs", "Contact No. : +91 1212121214", "800"},
                    {"Doctor Name : D.K. Banik", "Location Address : Andul", "Experience : 7 Yrs", "Contact No. : +91 1212121215", "500"},
                    {"Doctor Name : E.K. Nath", "Location Address : Kolkata", "Experience : 9 Yrs", "Contact No. : +91 1212121216", "700"},
            };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name : F.K. Jana", "Location Address : Kolkata", "Experience : 15 Yrs", "Contact No. : +91 1212121217", "700"},
                    {"Doctor Name : G.K. Sarkar", "Location Address : Belur", "Experience : 4 Yrs", "Contact No. : +91 1212121218", "500"},
                    {"Doctor Name : H.K. Maity", "Location Address : Howrah", "Experience : 10 Yrs", "Contact No. : +91 1212121219", "600"},
                    {"Doctor Name : I.K. Nath", "Location Address : Sirampur", "Experience : 5 Yrs", "Contact No. : +91 1212121210", "800"},
                    {"Doctor Name : J.K. Das", "Location Address : Hindmotor", "Experience : 25 Yrs", "Contact No. : +91 1212121211", "1600"},
            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name : K.K. Banik", "Location Address : Barasat", "Experience : 17 Yrs", "Contact No. : +91 1212121221", "800"},
                    {"Doctor Name : L.K. Roy", "Location Address : Madhyamgram", "Experience : 12 Yrs", "Contact No. : +91 1212121222", "500"},
                    {"Doctor Name : M.K. Chakraborty", "Location Address : Kalayani", "Experience : 9 Yrs", "Contact No. : +91 1212121223", "600"},
                    {"Doctor Name : N.K. Banerjee", "Location Address : Dumdum", "Experience : 3 Yrs", "Contact No. : +91 1212121224", "1700"},
                    {"Doctor Name : O.K. Dalal", "Location Address : Nagerbazar", "Experience : 5 Yrs", "Contact No. : +91 1212121225", "900"},
            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name : P.K. Debnath", "Location Address : Saltlake", "Experience : 7 Yrs", "Contact No. : +91 1212121226", "600"},
                    {"Doctor Name : Q.K. Talukdar", "Location Address : Karunamoyee", "Experience : 31 Yrs", "Contact No. : +91 1212121227", "1600"},
                    {"Doctor Name : R.K. Dey", "Location Address : Ultadnaga", "Experience : 27 Yrs", "Contact No. : +91 1212121228", "500"},
                    {"Doctor Name : S.K. Mirta", "Location Address : Howrah", "Experience : 21 Yrs", "Contact No. : +91 1212121229", "700"},
                    {"Doctor Name : T.K. Mallick", "Location Address : Laketown", "Experience : 16 Yrs", "Contact No. : +91 1212121230", "600"},
            };
    private String[][] doctor_details5 =
            {
                    {"Doctor Name : U.K. Rai", "Location Address : Birati", "Experience : 24 Yrs", "Contact No. : +91 1212121231", "1800"},
                    {"Doctor Name : V.K. Roy", "Location Address : Behala", "Experience : 8 Yrs", "Contact No. : +91 1212121232", "800"},
                    {"Doctor Name : W.K. Nath", "Location Address : Kolkata", "Experience : 24 Yrs", "Contact No. : +91 1212121233", "600"},
                    {"Doctor Name : X.K. Bal", "Location Address : Central", "Experience : 19 Yrs", "Contact No. : +91 1212121234", "700"},
                    {"Doctor Name : Y.K. Koley", "Location Address : Shreebhumi", "Experience : 20 Yrs", "Contact No. : +91 1212121235", "600"},
            };
    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewHADTitle);
        btn = findViewById(R.id.buttonHADBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("Family Physician")==0)
            doctor_details = doctor_details1;
        else
        if (title.compareTo("Dietitian")==0)
            doctor_details = doctor_details2;
        else
        if (title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if (title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for (int i=0; i<doctor_details.length;i++) {
            item = new HashMap<String,String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Consultant Fees : \u20B9"+doctor_details[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        ListView lst = findViewById(R.id.listViewHA);
        lst.setAdapter(sa);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}