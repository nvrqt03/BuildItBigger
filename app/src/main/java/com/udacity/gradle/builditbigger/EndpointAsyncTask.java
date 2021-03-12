package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Pair;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

import ajmitchell.android.mylibrary.JokeLibraryMainActivity;

public class EndpointAsyncTask extends AsyncTask<Context, Void, String> {

    private static MyApi myApiService = null;
    private Context context;

    @Override
    protected String doInBackground(Context... args) {
        if (myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });
            myApiService = builder.build();
        }
        context = args[0];

        try {
            return myApiService.tellJoke().execute().getData();
        } catch (IOException e) {
            return null;
        }
    }

//    @Override
//    protected String doInBackground(Pair<Context, String>... pairs) {
//        return null;
//    }

    @Override
    protected void onPostExecute(String s) {
        //Jokes jokes = new Jokes();
        Intent intent = new Intent(context, JokeLibraryMainActivity.class);
        intent.putExtra("joke", s);
        context.startActivity(intent);
        Toast.makeText(context, s, Toast.LENGTH_LONG).show();
    }
}
