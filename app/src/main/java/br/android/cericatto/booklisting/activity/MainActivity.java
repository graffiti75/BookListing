package br.android.cericatto.booklisting.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import br.android.cericatto.booklisting.R;
import br.android.cericatto.booklisting.adapter.BookAdapter;
import br.android.cericatto.booklisting.model.BookItem;
import br.android.cericatto.booklisting.parse.JsonRawUtils;
import br.android.cericatto.booklisting.tasks.GetDataAsyncTask;
import br.android.cericatto.booklisting.utils.Utils;

/**
 * MainActivity.java.
 *
 * @author Rodrigo Cericatto
 * @since Sep 8, 2016
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //--------------------------------------------------
    // Constants
    //--------------------------------------------------

    private static final String URL = "https://www.googleapis.com/books/v1/volumes?q=";

    //--------------------------------------------------
    // Attributes
    //--------------------------------------------------

    private Activity mActivity = MainActivity.this;

    private EditText mEditText;
    private Button mButton;
    private LinearLayout mProgressBarLinearLayout;
    private RecyclerView mRecyclerView;
    private TextView mTextView;

    //--------------------------------------------------
    // Activity Life Cycle
    //--------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setLayout();
    }

    //--------------------------------------------------
    // Methods
    //--------------------------------------------------

    private void setLayout() {
        mEditText = (EditText) findViewById(R.id.id_edit_text);
        mButton = (Button) findViewById(R.id.id_button);
        mButton.setOnClickListener(this);
        mProgressBarLinearLayout = (LinearLayout) findViewById(R.id.id_progress_bar_linear_layout);
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recycler_view);
        mTextView = (TextView) findViewById(R.id.id_text_view);
    }

    private void getData() {
        final String editTextContent = mEditText.getText().toString();
        if (!Utils.isEmpty(editTextContent)) {
            GetDataAsyncTask task = new GetDataAsyncTask() {
                @Override
                protected void onPostExecute(String data) {
                    // Check number of books found.
                    JSONObject rootJsonObject;
                    try {
                        rootJsonObject = new JSONObject(data);
                        String totalItems = JsonRawUtils.parseString(rootJsonObject, "totalItems");
                        if (Integer.valueOf(totalItems) <= 0) {
                            mProgressBarLinearLayout.setVisibility(View.GONE);
                            mTextView.setVisibility(View.VISIBLE);
                            mRecyclerView.setVisibility(View.GONE);
                            String text = getString(R.string.no_books_found) + " '" + editTextContent + "'.";
                            mTextView.setText(text);
                        } else {
                            mProgressBarLinearLayout.setVisibility(View.GONE);
                            mTextView.setVisibility(View.GONE);
                            mRecyclerView.setVisibility(View.VISIBLE);
                            List<BookItem> list = JsonRawUtils.parseBookData(data);
                            setRecyclerViewLayout(list);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            };
            task.execute(mActivity, URL + editTextContent, mProgressBarLinearLayout);
        } else {
            Toast.makeText(mActivity, mActivity.getString(R.string.empty_keyword), Toast.LENGTH_LONG).show();
        }
    }

    public void setRecyclerViewLayout(List<BookItem> list) {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        BookAdapter adapter = new BookAdapter(this, list);
        mRecyclerView.setAdapter(adapter);
    }

    //--------------------------------------------------
    // View.OnClickListener
    //--------------------------------------------------

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_button:
                mProgressBarLinearLayout.setVisibility(View.VISIBLE);
                if (Utils.hasConnection(mActivity)) {
                    getData();
                } else {
                    mProgressBarLinearLayout.setVisibility(View.GONE);
                    Toast.makeText(mActivity, mActivity.getString(R.string.google_books_api_error), Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}