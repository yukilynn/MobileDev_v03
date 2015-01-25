package hcl.sap.mobiledev_v02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class MainList extends ActionBarActivity {
	private ListView listView;
	private long lastPress;
	private Toast alert;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_list);

		listView = (ListView) findViewById(R.id.list);

		String[] values = new String[] { "Sales Order", "Sales Quotations",
				"Service Contract" };

		MainListAdapter mainAdapter = new MainListAdapter(this, values);
		listView.setAdapter(mainAdapter);

		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				// TODO Auto-generated method stub
				if (position == 0) {
					Intent intent = new Intent(MainList.this,
							SalesOrdList.class);
					startActivity(intent);
				}
			}
		});
	}

	/*
	 * to exit the application when back button pressed twice
	 */
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub

		long currentTime = System.currentTimeMillis();
		if (currentTime - lastPress > 3000) {
			alert = Toast.makeText(getBaseContext(), "Press again to exit",
					Toast.LENGTH_SHORT);
			alert.show();
			lastPress = currentTime;
		} else {
			alert.cancel();
			super.onBackPressed();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_list, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.action_preferences:
			Toast.makeText(this, "Preferences selected", Toast.LENGTH_SHORT)
					.show();
			return true;
		case R.id.action_help:
			Toast.makeText(this, "Help selected", Toast.LENGTH_SHORT).show();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}
