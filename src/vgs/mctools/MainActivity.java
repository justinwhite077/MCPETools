package vgs.mctools;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
		
		
        super.onCreate(savedInstanceState);
		
		
        setContentView(R.layout.main);
		
		ActionBar ab = getActionBar(); 
		ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#CF8349"));     
		ab.setBackgroundDrawable(colorDrawable);
		
		TextView txt = (TextView) findViewById(R.id.Home);
		Typeface font = Typeface.createFromAsset(getAssets(), "mcpe.ttf");
		txt.setTypeface(font);
		
		Button btn1 = (Button)findViewById(R.id.gomods);
        btn1.setOnClickListener(mods);
		
		Button btn2 = (Button)findViewById(R.id.gopmp);
        btn2.setOnClickListener(pmp);
		
		Button btn3 = (Button)findViewById(R.id.gotp);
        btn3.setOnClickListener(tp);
		
		Button btn4 = (Button)findViewById(R.id.goother);
        btn4.setOnClickListener(other);
		
    }
	
	View.OnClickListener mods = new View.OnClickListener() {
		public void onClick(View v) {
			// it was the 1st button
			
			Intent myIntent = new Intent(MainActivity.this, modsAct.class);
			startActivity(myIntent);
		}};
		
	View.OnClickListener pmp = new View.OnClickListener() {
		public void onClick(View v) {
			Intent myIntent2 = new Intent(MainActivity.this, pmpAct.class);
			startActivity(myIntent2);
		}};
		
	View.OnClickListener tp = new View.OnClickListener() {
		public void onClick(View v) {
			// it was the 1st button
			Intent myInten = new Intent(MainActivity.this, tpAct.class);
			startActivity(myInten);
		}};
		
	View.OnClickListener other = new View.OnClickListener() {
		public void onClick(View v) {
			// it was the 1st button
			Intent myIntnt = new Intent(MainActivity.this, otherAct.class);
			startActivity(myIntnt);
		}};
}