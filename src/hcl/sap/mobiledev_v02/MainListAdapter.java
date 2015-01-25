package hcl.sap.mobiledev_v02;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MainListAdapter extends ArrayAdapter<String> {
	private final Context context;
	private final String[] values;

	public MainListAdapter(Context context, String[] values) {
		super(context, R.layout.list_opts, values);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.values = values;
	}

	@SuppressLint("ViewHolder")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View viewHolder = inflater.inflate(R.layout.list_opts, parent, false);
		ImageView icon = (ImageView) viewHolder.findViewById(R.id.ivLogo);
		TextView txt_lbl = (TextView) viewHolder.findViewById(R.id.tvTextLabel);
		TextView txt_cntr = (TextView) viewHolder.findViewById(R.id.tvCounter);
		txt_lbl.setText(values[position]);
		if (position == 0) {
			icon.setImageResource(R.drawable.human);
		} else {
			icon.setImageResource(android.R.color.transparent);
		}
		return viewHolder;
	}
}
