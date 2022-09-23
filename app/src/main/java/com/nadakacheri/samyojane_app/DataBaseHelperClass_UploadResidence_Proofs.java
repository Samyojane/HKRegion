package com.nadakacheri.samyojane_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHelperClass_UploadResidence_Proofs extends SQLiteOpenHelper {

    static int DATABASE_VERSION = 1;
    public static String DATABASE_NAME = "UploadResidence_Proofs.db";
    public static String TABLE_NAME = "UploadResidenceProofs";
    public static String TABLE_NAME_1 = "FetchResidenceProofs";

    public static String GSCNO = "GSCNO";
    public static String Id = "Id";
    public static String District = "District";
    public static String Taluk = "Taluk";
    public static String RuralorUrban = "RuralorUrban";
    public static String Hobli = "Hobli";
    public static String Village = "Village";
    public static String VillageName = "VillageName";
    public static String Town = "Town";
    public static String Ward = "Ward";
    public static String StayingFrom = "StayingFrom";
    public static String StayingTo = "StayingTo";
    public static String Address1 = "Address1";
    public static String Address2 = "Address2";
    public static String Address3 = "Address3";
    public static String Pincode = "Pincode";
    public static String DocumentId = "DocumentId";
    public static String Document = "Document";



    public static String GSCNo = "GSCNo";
    public static String HKDistrict = "HKDistrict";
    public static String HKTaluk = "HKTaluk";
    public static String HKHobli = "HKHobli";
    public static String HKVillage = "HKVillage";
    public static String HKHabitation = "HKHabitation";
    public static String HKTown = "HKTown";
    public static String HKWard = "HKWard";
    public static String HKR_FromDate = "HKR_FromDate";
    public static String HKR_ToDate = "HKR_ToDate";
    public static String HKR_Address = "HKR_Address";
    public static String HKR_Address1 = "HKR_Address1";
    public static String HKR_Address2 = "HKR_Address2";
    public static String HKR_PinCode = "HKR_PinCode";
    public static String HKR_Document_Code = "HKR_Document_Code";
    public static String HKR_File = "HKR_File";

    String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + Id + " INTEGER PRIMARY KEY NOT NULL,"+ GSCNO +" TEXT,"
            + District +" int,"+ Taluk +" int,"+ RuralorUrban +" TEXT,"+ Hobli +" int,"+ Village +" int,"+ Town +" int,"
            + Ward +" int,"+ VillageName +" TEXT,"+ StayingFrom +" TEXT,"+ StayingTo +" TEXT,"+ Address1 +" TEXT,"+ Address2 +" TEXT,"+ Address3 +" TEXT,"
            + Pincode +" BIGINT,"+ DocumentId +" int,"+ Document +" TEXT)";

    String CREATE_TABLE_1 = "CREATE TABLE " + TABLE_NAME_1 + "(" + Id + " INTEGER PRIMARY KEY NOT NULL,"+ GSCNo +" TEXT,"
            + HKDistrict +" int,"+ HKTaluk +" int,"+ RuralorUrban +" TEXT,"+ HKHobli +" int,"+ HKVillage +" int,"+ HKTown +" int,"
            + HKWard +" int,"+ HKHabitation +" int,"+ HKR_FromDate +" TEXT,"+ HKR_ToDate +" TEXT,"+ HKR_Address +" TEXT,"+ HKR_Address1 +" TEXT,"+ HKR_Address2 +" TEXT,"
            + HKR_PinCode +" BIGINT,"+ HKR_Document_Code +" int,"+ HKR_File +" TEXT)";

    public DataBaseHelperClass_UploadResidence_Proofs(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.i("Note", "DataBase Opened");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        db.execSQL(CREATE_TABLE_1);
        Log.i("Note",TABLE_NAME+" Table Created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        Log.i("Note", "Table Upgraded");
        db.execSQL(CREATE_TABLE);
        db.execSQL(CREATE_TABLE_1);
    }

    public boolean insertData(String gscno, int district, int taluk,String RorU,int hobli, int village, int town, int ward,String villageName,
                              String stayingFrom, String stayingTo, String address1, String address2, String address3, String pincode,
                              int documentId, String document) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(GSCNO,gscno);
        contentValues.put(District,district);
        contentValues.put(Taluk,taluk);
        contentValues.put(RuralorUrban,RorU);
        contentValues.put(Hobli,hobli);
        contentValues.put(Village,village);
        contentValues.put(VillageName,villageName);
        contentValues.put(Town,town);
        contentValues.put(Ward,ward);
        contentValues.put(StayingFrom,stayingFrom);
        contentValues.put(StayingTo, stayingTo);
        contentValues.put(Address1, address1);
        contentValues.put(Address2, address2);
        contentValues.put(Address3, address3);
        contentValues.put(Pincode, pincode);
        contentValues.put(DocumentId,documentId);
        contentValues.put(Document,document);
        Long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;

    }














}
