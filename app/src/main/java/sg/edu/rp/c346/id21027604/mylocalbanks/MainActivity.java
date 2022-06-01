package sg.edu.rp.c346.id21027604.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    ImageView UOBLogo;
    ImageView OCBCLogo;
    ImageView DBSLogo;
    Button UOBBtn;
    Button OCBCBtn;
    Button DBSBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UOBBtn = findViewById(R.id.btnUOB);
        OCBCBtn = findViewById(R.id.btnOCBC);
        DBSBtn = findViewById(R.id.btnDBS);
        UOBLogo = findViewById(R.id.UOBLogo);
        OCBCLogo = findViewById(R.id.OCBCLogo);
        DBSLogo = findViewById(R.id.DBSLogo);

        registerForContextMenu(UOBBtn);
        registerForContextMenu(OCBCBtn);
        registerForContextMenu(DBSBtn);
    }

    String wordClicked = "";

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the Bank");

        if(v == UOBBtn) {
            wordClicked = "UOB";
        } else if(v == OCBCBtn) {
            wordClicked = "OCBC";
        } else if(v == DBSBtn) {
            wordClicked = "DBS";
        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("UOB")) {
            if(item.getItemId() == 0) {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);
            } else if(item.getItemId() == 1){
                long UOBPhone = Long.parseLong("18002222121");
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ UOBPhone ));
                startActivity(intentCall);
            }
        }
        if (wordClicked.equalsIgnoreCase("OCBC")) {
            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);
            } else if (item.getItemId() == 1) {
                long OCBCPhone = Long.parseLong("18003633333");
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + OCBCPhone));
                startActivity(intentCall);
            }
        }
        if (wordClicked.equalsIgnoreCase("DBS")) {
            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);
            } else if (item.getItemId() == 1) {
                long DBSPhone = Long.parseLong("18001111111");
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + DBSPhone));
                startActivity(intentCall);
            }
        }
        return super.onContextItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.language, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            UOBBtn.setText("UOB");
            OCBCBtn.setText("OCBC");
            DBSBtn.setText("DBS");
            return true;
        } else if (id == R.id.ChineseSelection) {
            UOBBtn.setText("大华银行");
            OCBCBtn.setText("华侨银行");
            DBSBtn.setText("星展银行");
            return true;
        } else {
            UOBBtn.setText("Translation Error!");
            OCBCBtn.setText("Translation Error!");
            DBSBtn.setText("Translation Error!");
        }
        return super.onOptionsItemSelected(item);
    }
}