package com.example.myfrontapplication2;

/**
 * Created by Panda on 2018/01/25.
 */
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.CallableStatement;
import java.util.ArrayList;

public class ContactInformationDAO extends AppCompatActivity {

    SQLiteDatabase db;

    public ContactInformationDAO(SQLiteDatabase db) {

        this.db = db;
    }

    public int insertcontactinformation(String name, String location, String memo, Bitmap picture) {
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("location", location);
        values.put("memo", memo);
        byte[] pictureP = new byte[0];
        try {
            pictureP = getByteObject(picture);

        } catch (IOException e) {
            e.printStackTrace();
        }
        values.put("picture", pictureP);


        long ret;
        try {
            ret = db.insert("ContactinformationTable", null, values);
        } finally {

        }
        if (ret == -1) {
            return 0;/*失敗*/
        } else {
            return 1;/*成功*/

        }

    }

    public ArrayList<Contactinformation> select() {
        String[] columns = new String[]{"No", "name", "location", "memo", "picture"};
        Cursor ret;
        ArrayList<Contactinformation> list = new ArrayList<Contactinformation>();

        try {
            ret = db.query("ContactinformationTable", columns, null, null, null, null, null);

            if (ret.moveToFirst()) {
                do {
                    Contactinformation contactinformation = new Contactinformation();
                    contactinformation.setNo(ret.getInt(ret.getColumnIndex("No")));
                    contactinformation.setName(ret.getString(ret.getColumnIndex("Name")));
                    contactinformation.setLocation(ret.getString(ret.getColumnIndex("location")));
                    contactinformation.setMemo(ret.getString(ret.getColumnIndex("memo")));
                    try{
                    contactinformation.setPicture(getBitmapObject(ret.getBlob(ret.getColumnIndex("picture"))));}
                    catch (Exception e){

                    }
                    list.add(contactinformation);



                } while (ret.moveToNext());
            }
        } finally {

        }
        return list;
    }

    /**
     * Bitmapオブジェクトをbyte配列に変換↓
     * @param bitmap
     * @return
     * @throws IOException
     */
    public static byte[] getByteObject(final Bitmap bitmap) throws IOException
    {
        ByteArrayOutputStream byteos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteos);

        CachedBitmap cachedBitmap = new CachedBitmap(bitmap);
        out.writeObject(cachedBitmap);

        return byteos.toByteArray();
    }

    /**
     * byte配列をBitmapオブジェクトに変換
     * @param objByte
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Bitmap getBitmapObject(final byte[] objByte) throws IOException, ClassNotFoundException
    {
        ByteArrayInputStream byteis = new ByteArrayInputStream(objByte);
        ObjectInputStream in = new ObjectInputStream(byteis);

        CachedBitmap cachedBitmap = (CachedBitmap) in.readObject();

        return cachedBitmap.getBitmap();
    }

}
