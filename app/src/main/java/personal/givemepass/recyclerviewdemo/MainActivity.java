package personal.givemepass.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ArrayList<String> myDataset = new ArrayList<>();
		for(int i = 0; i < 100; i++){
			myDataset.add(i + "");
		}
		MyAdapter myAdapter = new MyAdapter(myDataset);
		RecyclerView mList = (RecyclerView) findViewById(R.id.list_view);
		final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
		layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
		mList.setLayoutManager(layoutManager);
		mList.setAdapter(myAdapter);
	}
	public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
		private List<String> mData;

		public class ViewHolder extends RecyclerView.ViewHolder {
			public TextView mTextView;
			public ViewHolder(View v) {
				super(v);
				mTextView = (TextView) v.findViewById(R.id.info_text);
			}
		}

		public MyAdapter(List<String> data) {
			mData = data;
		}

		@Override
		public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			View v = LayoutInflater.from(parent.getContext())
					.inflate(R.layout.item, parent, false);
			ViewHolder vh = new ViewHolder(v);
			return vh;
		}

		@Override
		public void onBindViewHolder(ViewHolder holder, int position) {
			holder.mTextView.setText(mData.get(position));

		}

		@Override
		public int getItemCount() {
			return mData.size();
		}
	}
}
