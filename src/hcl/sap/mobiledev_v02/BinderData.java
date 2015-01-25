package hcl.sap.mobiledev_v02;

import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class BinderData extends BaseAdapter {
	
	static final String KEY_TAG = "companydata";
	static final String KEY_ID = "id";
	static final String KEY_DOC = "doc_series";
	static final String KEY_BP = "bizpart";
	static final String KEY_COID = "co_id";
	static final String KEY_CP = "contact";
	static final String KEY_CURR = "currency";
	static final String KEY_SEMP = "sls_emp";
	static final String KEY_RMRK = "remark";
	
	LayoutInflater inflater;
	List<HashMap<String,String>> bizPartCollection;
	ViewHolder holder;
	
	public BinderData() {
		// TODO Auto-generated constructor stub
	}
	
	public BinderData(Activity act, List<HashMap<String,String>> map) {
		this.bizPartCollection = map;
		
		inflater = (LayoutInflater) act.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return bizPartCollection.size();
	}
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View vi = convertView;
		if (convertView == null) {
			vi = inflater.inflate(R.layout.list_view, null);
			holder = new ViewHolder();
			
			holder.tvBizPartnerName = (TextView)vi.findViewById(R.id.tvBizPartnerName); // Business Partner Name
			holder.tvBizPartnerID = (TextView)vi.findViewById(R.id.tvBizPartnerID); // Business Partner ID / Company ID
			
			vi.setTag(holder);
		} else {
			holder = (ViewHolder)vi.getTag();
		}
		
		holder.tvBizPartnerName.setText(bizPartCollection.get(position).get(KEY_BP));
		holder.tvBizPartnerID.setText(bizPartCollection.get(position).get(KEY_COID));
		
		return vi;
	}
	
	
}
