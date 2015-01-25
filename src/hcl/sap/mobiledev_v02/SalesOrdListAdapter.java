package hcl.sap.mobiledev_v02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SalesOrdListAdapter extends ArrayAdapter<String> {
	private final Context context;
	private final String[] values;

	public SalesOrdListAdapter(Context context, String[] values) {
		super(context, R.layout.sls_ord_list, values);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.values = values;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View viewHolder = inflater.inflate(R.layout.sls_ord_list, parent, false);
		ImageView logo = (ImageView) viewHolder.findViewById(R.id.ivLogo);
		TextView txt_lbl = (TextView) viewHolder.findViewById(R.id.tvTextLabel);
		TextView txt_disp = (TextView) viewHolder.findViewById(R.id.tvTextDisp);
		txt_lbl.setText(values[position]);
		
//		if (position == 1 || position == 4 || position == 5 || position == 6 || position == 7
//				|| position == 8 || position == 9 || position == 10) {
//			arrow.setImageResource(R.drawable.arrow);
//		} else {
//			arrow.setImageResource(android.R.color.transparent);
//		}
//		
		return viewHolder;
	}

}
