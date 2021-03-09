package ajmitchell.android.mylibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeLibraryMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_library_main);
        TextView textView = findViewById(R.id.joke_text);

        String joke = null;
        Intent intent = getIntent();
        joke = intent.getStringExtra("joke");

        if (joke != null) {
            textView.setText(joke);
        } else {
            textView.setText("Whoops, there was an error!");
        }
    }
}