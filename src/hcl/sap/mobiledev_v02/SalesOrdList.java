package hcl.sap.mobiledev_v02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class SalesOrdList extends ActionBarActivity {
	private ListView listView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_list);
		
		listView = (ListView) findViewById(R.id.list);
		
		String[] values = new String[] {"A123 : Sales Order" };
		
		SalesOrdListAdapter slsListAdapter = new SalesOrdListAdapter(this, values);
		listView.setAdapter(slsListAdapter);

		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
//				int itemPosition = position;
//				String itemValue = (String) listView.getItemAtPosition(position);
				Intent intent = new Intent(SalesOrdList.this, AddSalesOrd.class);
				startActivity(intent);
			}
		});	
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_list, menu);
		return true;
	}
	
}
