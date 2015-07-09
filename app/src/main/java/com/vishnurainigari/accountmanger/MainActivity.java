package com.vishnurainigari.accountmanger;

import java.util.ArrayList;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.content.ClipData.*;

public class MainActivity extends Activity {

    private ArrayList<Item> list = null;
    private ListView listView;
    private VishnuListAdapter listadaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = getData();
        listView = (ListView) findViewById(R.id.listView1);
        listadaptor = new VishnuListAdapter(this, R.layout.view_layout, list);
        listView.setAdapter(listadaptor);
    }

    private ArrayList<Item> getData() {
        ArrayList<Item> accountsList = new ArrayList<Item>();

        //Getting all registered Google Accounts;

        try {
            Account[] accounts = AccountManager.get(this).getAccounts();
            for (Account account : accounts) {
                Item item = new Item( account.type, account.name);
                accountsList.add(item);
            }
        } catch (Exception e) {
            Log.i("Exception", "Exception:" + e);
        }

        //For all registered accounts;
		/*try {
			Account[] accounts = AccountManager.get(this).getAccounts();
			for (Account account : accounts) {
				Item item = new Item( account.type, account.name);
				accountsList.add(item);
			}
		} catch (Exception e) {
			Log.i("Exception", "Exception:" + e);
		}*/
        String Acc1 = "";
        String Acc2 = "" ;
        String Acc3 = "";

        return accountsList;
    }
}