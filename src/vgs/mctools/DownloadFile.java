package vgs.mctools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.TextView;

public class DownloadFile extends Activity {

    public static final String LOG_TAG = "Android Downloader by The Code Of A Ninja";

    //initialize our progress dialog/bar
    private ProgressDialog mProgressDialog;
    public static final int DIALOG_DOWNLOAD_PROGRESS = 0;

    //initialize root directory
    File rootDir = Environment.getExternalStorageDirectory();

    //defining file name and url
    public String fileName = "codeofaninja.jpg";
    public String fileURL = "https://lh4.googleusercontent.com/-HiJOyupc-tQ/TgnDx1_HDzI/AAAAAAAAAWo/DEeOtnRimak/s800/DSC04158.JPG";

    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        //setting some display
        setContentView(R.layout.dlportal);
        TextView tv = new TextView(this);
        tv.setText("Android Download File With Progress Bar");

        //making sure the download directory exists
        checkAndCreateDirectory("/MCPETools");

        //executing the asynctask
        new DownloadFileAsync().execute(fileURL);
    }

    //this is our download file asynctask
    class DownloadFileAsync extends AsyncTask<String, String, String>
	{

		@Override
		protected String doInBackground(String[] p1)
		{
			// TODO: Implement this method
			return null;
		}


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showDialog(DIALOG_DOWNLOAD_PROGRESS);
        }


        @Override
        protected String doInBackground(String aurl) {

            try {
                //connecting to url
                URL u = new URL(fileURL);
                HttpURLConnection c = (HttpURLConnection) u.openConnection();
                c.setRequestMethod("GET");
                c.setDoOutput(true);
                c.connect();

                //lenghtOfFile is used for calculating download progress
                int lenghtOfFile = c.getContentLength();

                //this is where the file will be seen after the download
                FileOutputStream f = new FileOutputStream(new File(rootDir + "/MCPETools/", fileName));
                //file input is from the url
                InputStream in = c.getInputStream();

                //here’s the download code
                byte[] buffer = new byte[1024];
                int len1 = 0;
                long total = 0;