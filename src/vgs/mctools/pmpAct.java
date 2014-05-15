package vgs.mctools;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.os.*;
import android.view.*;
import android.widget.*;

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

	}}