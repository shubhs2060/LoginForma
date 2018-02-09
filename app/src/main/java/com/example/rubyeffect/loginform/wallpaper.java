package com.example.rubyeffect.loginform;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.InputStream;

public class wallpaper extends AppCompatActivity {

    String URL = "http://www.androidbegin.com/wp-content/uploads/2013/07/HD-Logo.gif";
    ImageView image;
    Button button;
    ProgressDialog mProgressDialog;
    private String images[] = {"https://static.pexels.com/photos/490411/pexels-photo-490411.jpeg", "https://static.pexels.com/photos/240040/pexels-photo-240040.jpeg", "http://images.all-free-download.com/images/graphiclarge/beautiful_scenery_04_hd_pictures_166258.jpg"};
    private int currImage = 0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the layout from image.xml
        setContentView(R.layout.activity_wallpaper);
        setInitialImage();
        setImageRotateListener();
        // Locate the ImageView in activity_main.xml
        image = (ImageView) findViewById(R.id.image);

        // Locate the Button in activity_main.xml
        button = (Button) findViewById(R.id.button);

        // Capture button click
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Execute DownloadImage AsyncTask
                new DownloadImage().execute(URL);
            }
        });
    }
    private void setImageRotateListener() {
        final Button rotatebutton = (Button) findViewById(R.id.btnRotateImage);
        rotatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                currImage++;
                if (currImage == 3) {
                    currImage = 0;
                }
                setCurrentImage();
            }
        });
    }

    private void setInitialImage() {
        setCurrentImage();
    }


    private void setCurrentImage() {

        final ImageView imageView = (ImageView) findViewById(R.id.image);
        imageView.setImageResource(Integer.parseInt(images[currImage]));

    }
    // DownloadImage AsyncTask
    private class DownloadImage extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(wallpaper.this);
            // Set progressdialog title
            mProgressDialog.setTitle("Download Image Tutorial");
            // Set progressdialog message
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            // Show progressdialog
            mProgressDialog.show();
        }

        @Override
        protected Bitmap doInBackground(String... URL) {

            String imageURL = URL[0];

            Bitmap bitmap = null;
            try {
                // Download Image from URL
                InputStream input = new java.net.URL(imageURL).openStream();
                // Decode Bitmap
                bitmap = BitmapFactory.decodeStream(input);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            // Set the bitmap into ImageView
            image.setImageBitmap(result);
            // Close progressdialog
            mProgressDialog.dismiss();
        }
    }
}