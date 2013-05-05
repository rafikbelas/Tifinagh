package biz.aldaffah.salaty.activity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import biz.aldaffah.douaa.R;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.TextView;

// MainActivity represents main screen that is displayed to the user
// it Contains main data such as prayer times , remaining time until next prayer,
// city name , and so on ..
public class Main extends ListActivity {
	private SalatItem[] salats;
	
	public void onCreate(Bundle savedInstanceState) {
		try{
			Date date = new Date();   // given date
			Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
			calendar.setTime(date);   // assigns calendar to given date 
			final int dd = calendar.get(Calendar.DAY_OF_MONTH); // gets DAY
			final int mm = calendar.get(Calendar.MONTH)+1;        // gets MONTH
			final int yy = calendar.get(Calendar.YEAR);       // gets YEAR
			List<String> prayersList;
			prayersList = getPrayerTimes(getApplicationContext(),dd, mm, yy);
			
			List<String> list = prayersList;
			requestWindowFeature(Window.FEATURE_NO_TITLE);
			getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
			super.onCreate(savedInstanceState);
			this.setContentView(R.layout.main);
			setListAdapter(new ListAdapter(this, list));
	
		}catch (Exception e) {
			// TODO Apply AirBrake class in GitHub
			}
				
		TextView cityView = (TextView) findViewById(R.id.textView1);

		Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Regular.ttf");
		cityView.setTypeface(font);
		
	}
	
	public void onListItemClick(ListView parent, View v, int position, long id) {
		startActivity(new Intent(this, Douaa.class));
	}

	public void calculate(){
		try{
			Date date = new Date();   // given date
			Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
			calendar.setTime(date);   // assigns calendar to given date 
			final int dd = calendar.get(Calendar.DAY_OF_MONTH); // gets DAY
			final int mm = calendar.get(Calendar.MONTH)+1;        // gets MONTH
			final int yy = calendar.get(Calendar.YEAR);       // gets YEAR

			List<String> prayersList = getPrayerTimes(getApplicationContext(),dd, mm, yy);
			
			
		}catch (Exception e) {
			// TODO Apply AirBrake class in GitHub
			}
		}
		public static ArrayList<String>  getPrayerTimes(Context context, int dd, int mm, int yy){
		PrayTime prayTime = new PrayTime();
	      double latitude = -37.823689;
	      double longitude = 145.121597;
	      double timezone = 10;

		return prayTime.getDatePrayerTimes(yy, mm, dd,
				latitude, longitude, timezone);
		}


}