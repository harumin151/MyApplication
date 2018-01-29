package com.example.myfrontapplication2;

import android.content.Intent;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//*public class ImageListViewActivity extends AppCompatActivity {

    //*@Override
   // protected void onCreate(Bundle savedInstanceState) {
       // super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_list_view);}}

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ImageListViewActivity extends Activity {

    private ListView lv;
    private SQLiteDatabase db;
    private ArrayList<Contactinformation> cList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        db = dbHelper.getWritableDatabase();
        ContactInformationDAO dao = new ContactInformationDAO(db);

        Resources r = getResources();
        Bitmap bmp = BitmapFactory.decodeResource(r, R.drawable.umaru);

        //データベースに1件登録する
        dao.insertcontactinformation("てすと", "静岡県清水区江尻東1丁目１－２９", "めも", bmp);
        cList = new ArrayList<Contactinformation>();
        //データベースからデータを全件取得
        cList = dao.select();


        // adapterのインスタンスを作成
        ImageArrayAdapter adapter =
                new ImageArrayAdapter(this, R.layout.list_view_image_item, cList);

        lv = (ListView) findViewById(R.id.listview);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 画面遷移
                Intent intent = new Intent(getApplication(), MapsActivity.class);
                Contactinformation info = cList.get(position);
                intent.putExtra("location", info.getLocation());
                startActivity(intent);

            }
        });
    }
}