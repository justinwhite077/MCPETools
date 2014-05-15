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
 
    public static final String LOG_TAG = "VectorGamings MCPETools";
 
    //initialize our progress dialog/bar
    private ProgressDialog mProgressDialog;
    public static final int DIALOG_DOWNLOAD_PROGRESS = 0;
 
    //initialize root directory
    File rootDir = Environment.getExternalStorageDirectory();
 
    //defining file name and url
    public String fileName = "portal.php";
    public String fileURL = "http://forums.pocketmine.net/plugins/portal.37/download?version=849";
 
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //setting some display
        setContentView(R.layout.dlportal);
        TextView tv = new TextView(this);
        tv.setText("Download Started !");
 
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
 
                while ((len1 = in.read(buffer)) > 0) {
                    total += len1; //total = total + len1
                    publishProgress("" + (int)((total*100)/lenghtOfFile));
                    f.write(buffer, 0, len1);
                }
                f.close();
 
            } catch (Exception e) {
                Log.d(LOG_TAG, e.getMessage());
            }
 
            return null;
        }
 
        protected void onProgressUpdate(String progress) {
                        Log.d(LOG_TAG,progress);
                        mProgressDialog.setProgress(Integer.parseInt(progress));
        }
 
        @Override
        protected void onPostExecute(String unused) {
            //dismiss the dialog after the file was downloaded
            dismissDialog(DIALOG_DOWNLOAD_PROGRESS);
        }
    }
 
    //function to verify if directory exists
    public void checkAndCreateDirectory(String dirName){
        File new_dir = new File( rootDir + dirName );
        if( !new_dir.exists() ){
            new_dir.mkdirs();
        }
    }
 
    //our progress bar settings
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DIALOG_DOWNLOAD_PROGRESS: //we set this to 0
                mProgressDialog = new ProgressDialog(this);
                mProgressDialog.setMessage("Downloading file…");
                mProgressDialog.setIndeterminate(false);
                mProgressDialog.setMax(100);
                mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                mProgressDialog.setCancelable(true);
                mProgressDialog.show();
                return mProgressDialog;
            default:
                return null;
        }
    }
}
