package hcl.sap.mobiledev_v02;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class BizPartList extends ActionBarActivity {

	static final String KEY_TAG = "companydata";
	static final String KEY_ID = "id";
	static final String KEY_DOC = "doc_series";
	static final String KEY_BP = "bizpart";
	static final String KEY_COID = "co_id";
	static final String KEY_CP = "contact";
	static final String KEY_CURR = "currency";
	static final String KEY_SEMP = "sls_emp";
	static final String KEY_RMRK = "remark";
	
//	private final static int BIZPART_DATA = 1;
	
	ListView list;
	BinderData adapter = null;
	List<HashMap<String,String>> bizPartCollection;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_list);
		
		try {
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse (getAssets().open("companydata.xml"));
			
			bizPartCollection = new ArrayList<HashMap<String,String>>();
			
			doc.getDocumentElement().normalize();
			
			NodeList bizPartList = doc.getElementsByTagName("companydata");
			
			HashMap<String,String> map = null;
			
			for (int i = 0; i < bizPartList.getLength(); i++) {
				map = new HashMap<String,String>();
				Node firstBizPartNode = bizPartList.item(i);
				
				if (firstBizPartNode.getNodeType() == Node.ELEMENT_NODE) {
					Element firstBizPartElement = (Element)firstBizPartNode;
					
					//1.------
					NodeList idList = firstBizPartElement.getElementsByTagName(KEY_ID);
					Element firstIdElement = (Element)idList.item(0);
					NodeList textIdList = firstIdElement.getChildNodes();
					//--id
					map.put(KEY_ID, ((Node)textIdList.item(0)).getNodeValue().trim());
					
					//2.------
					NodeList docSeriesList = firstBizPartElement.getElementsByTagName(KEY_DOC);
					Element firstDocSeriesElement = (Element)docSeriesList.item(0);
					NodeList textDocSeriesList = firstDocSeriesElement.getChildNodes();
					//--doc series
					map.put(KEY_DOC, ((Node)textDocSeriesList.item(0)).getNodeValue().trim());
					
					//3.------
					NodeList bizPartNameList = firstBizPartElement.getElementsByTagName(KEY_BP);
					Element firstBizPartNameElement = (Element)bizPartNameList.item(0);
					NodeList textBizPartNameList = firstBizPartNameElement.getChildNodes();
					//--business partner
					map.put(KEY_BP, ((Node)textBizPartNameList.item(0)).getNodeValue().trim());
					
					//4.------
					NodeList companyIDList = firstBizPartElement.getElementsByTagName(KEY_COID);
					Element firstCompanyIDElement = (Element)companyIDList.item(0);
					NodeList textCompanyIDList = firstCompanyIDElement.getChildNodes();
					//--business partner
					map.put(KEY_COID, ((Node)textCompanyIDList.item(0)).getNodeValue().trim());
					
					//5.------
					NodeList contactNameList = firstBizPartElement.getElementsByTagName(KEY_CP);
					Element firstContactElement = (Element)contactNameList.item(0);
					NodeList textContactList = firstContactElement.getChildNodes();
					//--contact person
					map.put(KEY_CP, ((Node)textContactList.item(0)).getNodeValue().trim());
					
					//6.------
					NodeList currencyList = firstBizPartElement.getElementsByTagName(KEY_CURR);
					Element firstCurrencyElement = (Element)currencyList.item(0);
					NodeList textCurrencyList = firstCurrencyElement.getChildNodes();
					//--currency
					map.put(KEY_CURR, ((Node)textCurrencyList.item(0)).getNodeValue().trim());
					
					//7.------
					NodeList salesEmpList = firstBizPartElement.getElementsByTagName(KEY_SEMP);
					Element firstSalesEmpElement = (Element)salesEmpList.item(0);
					NodeList textSalesEmpList = firstSalesEmpElement.getChildNodes();
					//--sales employee
					map.put(KEY_SEMP, ((Node)textSalesEmpList.item(0)).getNodeValue().trim());
					
					//8.------
					NodeList remarkList = firstBizPartElement.getElementsByTagName(KEY_RMRK);
					Element firstRemarkElement = (Element)remarkList.item(0);
					NodeList textRemarkList = firstRemarkElement.getChildNodes();
					//--remark
					map.put(KEY_RMRK, ((Node)textRemarkList.item(0)).getNodeValue().trim());
					
					//Add to the ArrayList
					bizPartCollection.add(map);
				}
			}
			
			BinderData bindingData = new BinderData(this, bizPartCollection);
			
			list = (ListView) findViewById(R.id.list);
			
			Log.i("BEFORE", "<<------------- Before SetAdapter-------------->>");

			list.setAdapter(bindingData);

			Log.i("AFTER", "<<------------- After SetAdapter-------------->>");
			
			list.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					// TODO Auto-generated method stub
					Intent i = new Intent();
					i.setClass(BizPartList.this, AddSalesOrd.class);
					
					i.putExtra("position", String.valueOf(position + 1));
					
					/* selected item parameters
					 * 1.	Doc. Series
					 * 2.	Business Partner
					 * 3.	Contact Person
					 * 4.	Currency
					 * 5.	Sales Employee  
					 * 6.	Remark
					 */
					
					i.putExtra("doc_series", bizPartCollection.get(position).get(KEY_DOC));
					i.putExtra("bizpart", bizPartCollection.get(position).get(KEY_BP));
					i.putExtra("contact", bizPartCollection.get(position).get(KEY_CP));
					i.putExtra("currency", bizPartCollection.get(position).get(KEY_CURR));
					i.putExtra("sls_emp", bizPartCollection.get(position).get(KEY_SEMP));
					i.putExtra("remark", bizPartCollection.get(position).get(KEY_RMRK));
					
//					startActivityForResult(i, BIZPART_DATA);
					startActivity(i);
				}
				
			});
		}
		catch (IOException ex) {
			Log.e("Error", ex.getMessage());
		}
		catch (Exception ex) {
			Log.e("Error", "Loading exception");
		}
	}
	
//	@Override
//	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//		// TODO Auto-generated method stub
//		if (requestCode == BIZPART_DATA) {
//			if (resultCode == RESULT_OK) {
//				Log.i("POSITIVE", "DATA OK");
//			} else {
//				Log.i("NEGATIVE", "DATA NOT OK");
//			}
//		}
//	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_list, menu);
		return true;
	}
}
