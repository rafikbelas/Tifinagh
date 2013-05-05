package biz.aldaffah.tifinagh.activity;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import biz.aldaffah.tifinagh.R;

public class ImageAdapter extends BaseAdapter {
	int[] imageIDs = {
  R.drawable.a, 
  R.drawable.b, 
  R.drawable.c, 
  R.drawable.cue, 
  R.drawable.d, 
  R.drawable.dj,
  R.drawable.e, 
  R.drawable.f, 
  R.drawable.gh, 
  R.drawable.ghi, 
  R.drawable.h, 
  R.drawable.i, 
  R.drawable.j, 
  R.drawable.z, 
  R.drawable.y, 
  R.drawable.x, 
  R.drawable.w, 
  R.drawable.u, 
  R.drawable.th, 
  R.drawable.tch, 
  R.drawable.t, 
  R.drawable.s, 
  R.drawable.r, 
  R.drawable.q, 
  R.drawable.n, 
  R.drawable.m, 
  R.drawable.l, 
  R.drawable.k,   
  };

	private Context context;
	
	public ImageAdapter(Context c){
		context = c;
	}
	
	
	public View getView(int position, View convertView, ViewGroup parent){
		ImageView imageView;
		if (convertView == null){
			
			imageView = new ImageView(context);
			imageView.setLayoutParams(new GridView.LayoutParams(85,85));
			imageView.setScaleType(ScaleType.CENTER_CROP);
			imageView.setPadding(5, 5, 5, 5);			
		}else {
			imageView = (ImageView) convertView;
		}
		imageView.setImageResource(imageIDs[position]);
		return imageView;					
	}
@Override
public int getCount() {
	// TODO Auto-generated method stub
	return imageIDs.length;
}
@Override
public Object getItem(int arg0) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public long getItemId(int arg0) {
	// TODO Auto-generated method stub
	return 0;
}
}
