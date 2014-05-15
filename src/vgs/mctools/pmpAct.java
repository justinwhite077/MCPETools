package vgs.mctools;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.net.*;
import java.io.*;
import android.util.*;

public class pmpAct extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{


        super.onCreate(savedInstanceState);


        setContentView(R.layout.pmp);

		ActionBar ab = getActionBar(); 
		ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#CF8349"));     
		ab.setBackgroundDrawable(colorDrawable);

		Button btn1 = (Button)findViewById(R.id.tpcompass);
        btn1.setOnClickListener(tpcom);

		Button btn2 = (Button)findViewById(R.id.economy);
        btn2.setOnClickListener(dollard);

		Button btn3 = (Button)findViewById(R.id.portal);
        btn3.setOnClickListener(por);

		Button btn4 = (Button)findViewById(R.id.nogrief);
        btn4.setOnClickListener(noGri);

    }

	View.OnClickListener por = new View.OnClickListener() {
		public void onClick(View v) {
			Intent myIntent = new Intent(pmpAct.this, DownloadFile.class);
			startActivity(myIntent);
			
		}};

	View.OnClickListener tpcom = new View.OnClickListener() {
		public void onClick(View v) {
			
		}};

	View.OnClickListener dollard = new View.OnClickListener() {
		public void onClick(View v) {
			// it was the 1st button
			
		}};

	View.OnClickListener noGri = new View.OnClickListener() {
		public void onClick(View v) {
			// it was the 1st button
			
		}};
		
	}