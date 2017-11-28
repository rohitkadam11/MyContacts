package rohitkadam.mycontacts;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabase extends SQLiteOpenHelper {

    static final String dbname="contacts.db";
    static final String tablename="contacts";
    static final String columnname="name";
    static final  String columnnumber="number";
    static final String createquery="create table contacts (name text,number text)";

    public MyDatabase(Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(createquery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long insert(Contact contact){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(columnname,contact.getName());
        contentValues.put(columnnumber,contact.getNumber());

        long id=sqLiteDatabase.insert(tablename,null,contentValues);
        return id;
    }
}