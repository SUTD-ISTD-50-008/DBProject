package com.example.dbproject;

import java.util.ArrayList;
import java.util.List;
import android.support.v7.app.ActionBarActivity;
import android.app.ActionBar;
import android.widget.SearchView;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.os.Build;

import java.util.Arrays;
import java.util.LinkedList;

import com.example.dbproject.LoadMoreListView.OnLoadMoreListener;
import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;



public class BookListActivity extends ListActivity {
	public static ArrayList<Book> books;
	public static MyAdapter adapter;

	// list with the data to show in the listview
	private LinkedList<String> mListItems;

	// The data to be displayed in the ListView
	/*private String[] mNames = { "Fabian", "Carlos", "Alex", "Andrea", "Karla",
			"Freddy", "Lazaro", "Hector", "Carolina", "Edwin", "Jhon",
			"Edelmira", "Andres" };*/

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loadmore);
		getActionBar().setDisplayShowTitleEnabled(false);
		getActionBar().setDisplayShowHomeEnabled(false);

		//mListItems = new LinkedList<String>();
		//mListItems.addAll(Arrays.asList(mNames));

        adapter = new MyAdapter(this, generateData());

		setListAdapter(adapter);

		// set a listener to be invoked when the list reaches the end
		((LoadMoreListView) getListView())
				.setOnLoadMoreListener(new OnLoadMoreListener() {
					public void onLoadMore() {
						// Do the work to load more items at the end of list
						// here
						new LoadDataTask().execute();
					}
				});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.book_list, menu);
        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search)
                .getActionView();
        searchView.setQueryHint("Search by title");
        searchView.setSubmitButtonEnabled(true);
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getComponentName()));

	    return super.onCreateOptionsMenu(menu);
	}
	//This is the key method that will populate the listview with all the books
	private ArrayList<Book> generateData(){
		books=new ArrayList<Book>();
		books.add(new Book("Thomas Tallis", "1510-1585"));
		books.add(new Book("Josquin Des Prez", "1440-1521"));
		books.add(new Book("Pierre de La Rue", "1460-1518"));
		books.add(new Book("Johann Sebastian Bach", "1685-1750"));
		books.add(new Book("George Frideric Handel", "1685-1759"));
		books.add(new Book("Antonio Vivaldi", "1678-1741"));
		books.add(new Book("George Philipp Telemann", "1681-1767"));
		books.add(new Book("Franz Joseph Haydn", "1732-1809"));
		books.add(new Book("Wolfgang Amadeus Mozart", "1756-1791"));
		books.add(new Book("Barbara of Portugal", "1711Ð1758"));
		books.add(new Book("Frederick the Great", "1712Ð1786"));
		books.add(new Book("Thomas Tallis", "1510-1585"));
		books.add(new Book("Josquin Des Prez", "1440-1521"));
		books.add(new Book("Pierre de La Rue", "1460-1518"));
		books.add(new Book("Johann Sebastian Bach", "1685-1750"));
		books.add(new Book("George Frideric Handel", "1685-1759"));
		books.add(new Book("Antonio Vivaldi", "1678-1741"));
		books.add(new Book("George Philipp Telemann", "1681-1767"));
		books.add(new Book("Franz Joseph Haydn", "1732-1809"));
		books.add(new Book("Wolfgang Amadeus Mozart", "1756-1791"));
		books.add(new Book("Barbara of Portugal", "1711Ð1758"));
		books.add(new Book("Frederick the Great", "1712Ð1786"));
		books.add(new Book("Thomas Tallis", "1510-1585"));
		books.add(new Book("Josquin Des Prez", "1440-1521"));
		books.add(new Book("Pierre de La Rue", "1460-1518"));
		books.add(new Book("Johann Sebastian Bach", "1685-1750"));
		books.add(new Book("George Frideric Handel", "1685-1759"));
		books.add(new Book("Antonio Vivaldi", "1678-1741"));
		books.add(new Book("George Philipp Telemann", "1681-1767"));
		books.add(new Book("Franz Joseph Haydn", "1732-1809"));
		books.add(new Book("Wolfgang Amadeus Mozart", "1756-1791"));
		books.add(new Book("Barbara of Portugal", "1711Ð1758"));
		books.add(new Book("Frederick the Great", "1712Ð1786"));
		return books;
	}

	private class LoadDataTask extends AsyncTask<Void, Void, Void> {

		@Override
		protected Void doInBackground(Void... params) {

			if (isCancelled()) {
				return null;
			}

			// Simulates a background task
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}

			//for (int i = 0; i < mNames.length; i++)
			//	mListItems.add(mNames[i]);

			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			books.add(new Book("added after", "pull down"));

			// We need notify the adapter that the data have been changed
			((BaseAdapter) getListAdapter()).notifyDataSetChanged();

			// Call onLoadMoreComplete when the LoadMore task, has finished
			((LoadMoreListView) getListView()).onLoadMoreComplete();

			super.onPostExecute(result);
		}

		@Override
		protected void onCancelled() {
			// Notify the loading more operation has finished
			((LoadMoreListView) getListView()).onLoadMoreComplete();
		}
		

	}
}
