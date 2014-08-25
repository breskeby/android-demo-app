package org.acme.demo.demoicnndbclient;

import org.springframework.web.client.RestTemplate;

import android.R.color;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.crashlytics.android.Crashlytics;
import com.google.gson.Gson;

public class MainActivity extends Activity {
    private static final String TAG = "ICNDB";

    private Button jokeButton;
    private TextView jokeView;

    // "true" ctor arg --> add default message converters
    private RestTemplate template = new RestTemplate(true);
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        url = getString(R.string.URL);
        setContentView(R.layout.activity_main);

        jokeView = (TextView) findViewById(R.id.text_view);
        jokeButton = (Button) findViewById(R.id.icndb_button);
        jokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new JokeTask().execute();
                jokeButton.setTextColor(getResources().getColor(color.holo_red_dark));
            }
        });

        if (BuildConfig.REPORT_CRASHES) {
            Crashlytics.start(this);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private class JokeTask extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {
            String jsonTxt = template.getForObject(url, String.class);
            Log.d(TAG, jsonTxt);
            IcndbJoke joke = new Gson().fromJson(jsonTxt, IcndbJoke.class);
            return joke.getJoke();
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            jokeButton.setTextColor(getResources().getColor(
                    color.holo_green_dark));
            jokeView.setText(result);
        }
    }
}
