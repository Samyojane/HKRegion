package com.nadakacheri.samyojane_app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class SqlLiteOpenHelper_Class_Kan extends SQLiteAssetHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DB_PATH_SUFFIX = "/databases/";
    SQLiteDatabase database;
    Cursor cursor;

    private static final String DATABASE_NAME_reasons = "Reasons_Master.db";
    private String Table_1_re = "CreamyLayerReasons";
    private String Table_2_re = "CertificateRejectionReason";
    private String Table_3_re = "Purpose_of_Certificate";
//    private String Reasons_re = "Reasons";
//    private String Purpose_re = "Purpose";
    private String SlNo = "SlNo";

    private static final String DATABASE_NAME_cat_caste = "CATEGORY_CASTE_MASTER.sqlite";
    static String Table_CAT_MASTER = "CAT_MASTER";
    public static String RTM_res_category_code = "RTM_res_category_code";
    public static String RTM_res_category_kdesc = "RTM_res_category_kdesc";
    public static String RTM_res_category_edesc = "RTM_res_category_edesc";
    public static String General_SCST = "General_SCST";

    private static final String DATABASE_NAME_Minority_caste = "Religion_Master.sqlite";
    static String Table_Minority_CASTE_MASTER = "Religion_master";
    public static String RGM_religion_code = "RGM_religion_code";
    public static String RGM_religion_kdesc = "RGM_religion_kdesc";
    public static String RGM_religion_edesc = "RGM_religion_edesc";
    public static String RGM_Minority = "RGM_Minority";

    static String Table_CASTE_EXCEPT_OBC = "CASTE_EXCEPT_OBC";
    public static String CM_CASTE_ID = "CM_CASTE_ID";
    public static String CM_res_category_code = "CM_res_category_code";
    public static String CM_caste_code = "CM_caste_code";
    public static String CM_caste_Slno = "CM_caste_Slno";
    public static String CM_caste_sub_slno = "CM_caste_sub_slno";
    public static String CM_caste_kdesc = "CM_caste_kdesc";
    public static String CM_caste_edesc = "CM_caste_edesc";
    public static String CM_isEWS = "CM_isEWS";

    static String Table_CASTE_OBC = "CASTE_OBC";
    public static String OBC_OCM_CASTE_ID = "OBC_OCM_CASTE_ID";
    public static String OBC_OCM_caste_Slno = "OBC_OCM_caste_Slno";

    private static String DATABASE_NAME_docs_type = "DOCUMENT_TYPE_MASTER.db";
    private static String Table_DOCS_Type = "DOCUMENT_TYPE_MASTER";
    private static String Doc_Code = "DTM_document_code";
    static String Doc_Name_E = "DTM_document_edesc";
    static String Doc_Name_K = "DTM_document_kdesc";

    private static final String DATABASE_NAME_District_master = "LG_DISTRICT_MASTER.sqlite";
    static String Table_DISTRICT_MASTER = "LG_DISTRICT_MASTER";
    public static String LDM_State_Code = "LDM_State_Code";
    public static String LDM_district_code = "LDM_district_code";
    public static String LDM_district_kname = "LDM_district_kname";
    public static String LDM_district_ename = "LDM_district_ename";
    public static String LDM_Old_NK_DistrictCode = "LDM_Old_NK_DistrictCode";
    public static String LDM_Flag = "LDM_Flag";
    public static String LDM_EVP_Flag = "LDM_EVP_Flag";


    private static final String DATABASE_NAME_Taluk_master = "LG_TALUK_MASTER.sqlite";
    static String Table_TALUK_MASTER = "LG_Taluk_Master";
    public static String LTM_State_Code = "LTM_State_Code";
    public static String LTM_District_code = "LTM_District_code";
    public static String LTM_Taluk_code = "LTM_Taluk_code";
    public static String LTM_Taluk_kName = "LTM_Taluk_kName";
    public static String LTM_Taluk_eName = "LTM_Taluk_eName";
    public static String LTM_Old_NK_DistrictCode = "LTM_Old_NK_DistrictCode";
    public static String LTM_Old_NK_TalukCode = "LTM_Old_NK_TalukCode";
    public static String LTM_isMobileIntegrated = "LTM_isMobileIntegrated";
    public static String LTM_mnemonic_code = "LTM_mnemonic_code";
    public static String LTM_Org_Taluk_Code = "LTM_Org_Taluk_Code";
    public static String LTM_Is_Special = "LTM_Is_Special";

    private static final String DATABASE_NAME_Hobli_master = "LG_HOBLI_MASTER.sqlite";
    static String Table_Hobli_MASTER = "LG_HOBLI_MASTER";
    public static String LHM_State_Code = "LHM_State_Code";
    public static String LHM_District_code = "LHM_District_code";
    public static String LHM_Taluk_code = "LHM_Taluk_code";
    public static String LHM_Hobli_Code = "LHM_Hobli_Code";
    public static String LHM_Hobli_kName = "LHM_Hobli_kName";
    public static String LHM_Hobli_eName = "LHM_Hobli_eName";
    public static String LHM_Old_NK_DistrictCode = "LHM_Old_NK_DistrictCode";
    public static String LHM_Old_NK_TalukCode = "LHM_Old_NK_TalukCode";
    public static String LHM_Old_NK_HobliCode = "LHM_Old_NK_HobliCode";
    public static String LHM_Desig_Office_Code = "LHM_Desig_Office_Code";
    public static String LHM_IsKasaba = "LHM_IsKasaba";

    private static String DATABASE_NAME_town_ward = "LG_TOWN_WARD_MASTER.sqlite";

    private static String DATABASE_Name_ID_Type = "ID_MASTER.db";

    static String ID_Master_tbl="ID_MASTER";
    static String ID_Code = "ID_Code";

    private static Context ctx;

    public SqlLiteOpenHelper_Class_Kan(Context context) {
        super(context, DATABASE_NAME_reasons, null, DATABASE_VERSION);
        ctx = context;
    }

    public SqlLiteOpenHelper_Class_Kan(){
        super(ctx, DATABASE_NAME_cat_caste, null, DATABASE_VERSION);
    }

    public SqlLiteOpenHelper_Class_Kan(Activity activity, Context context){
        super(context, DATABASE_NAME_cat_caste, null, DATABASE_VERSION);
        ctx = context;
    }

    public SqlLiteOpenHelper_Class_Kan(Context context, String str){
        super(context, DATABASE_NAME_docs_type, null, DATABASE_VERSION);
        ctx = context;
    }

    public SqlLiteOpenHelper_Class_Kan(Context context, String str, String str1){
        super(context, DATABASE_NAME_town_ward, null, DATABASE_VERSION);
        ctx = context;
    }

    public SqlLiteOpenHelper_Class_Kan(Context context, String str, String str1, String str2){
        super(context, DATABASE_Name_ID_Type, null, DATABASE_VERSION);
        ctx = context;
    }

    public SqlLiteOpenHelper_Class_Kan(Context context, String str, String str1, String str2,String str3){
        super(context, DATABASE_NAME_Minority_caste, null, DATABASE_VERSION);
        ctx = context;
    }

    public SqlLiteOpenHelper_Class_Kan(Context context, int data){
        super(context, DATABASE_NAME_District_master, null, DATABASE_VERSION);
        ctx = context;
    }
    public SqlLiteOpenHelper_Class_Kan(Context context, int data, int data1){
        super(context, DATABASE_NAME_Taluk_master, null, DATABASE_VERSION);
        ctx = context;
    }

    public SqlLiteOpenHelper_Class_Kan(Context context, int data, int data1, int data2){
        super(context, DATABASE_NAME_Hobli_master, null, DATABASE_VERSION);
        ctx = context;
    }

    public String Get_K_DocsName(int docs_ID){
        String docs_Name=null;
        database = this.getReadableDatabase();
        cursor = database.rawQuery("select * from "+ Table_DOCS_Type +" where "+ Doc_Code+"="+docs_ID, null);
        if(cursor.getCount()>0){
            if (cursor.moveToNext()){
                docs_Name = cursor.getString(cursor.getColumnIndexOrThrow(Doc_Name_K));
            }
        }
        return docs_Name;
    }

    public String Get_E_DocsName(int docs_ID){
        String docs_Name=null;
        database = this.getReadableDatabase();
        cursor = database.rawQuery("select * from "+ Table_DOCS_Type +" where "+ Doc_Code+"="+docs_ID, null);
        if(cursor.getCount()>0){
            if (cursor.moveToNext()){
                docs_Name = cursor.getString(cursor.getColumnIndexOrThrow(Doc_Name_E));
            }
        }
        return docs_Name;
    }

    public String GetCreamyLayerReason_BY_Code(int code, String col_name){
        String str="";
        database = this.getReadableDatabase();
        cursor = database.rawQuery("select * from "+ Table_1_re + " where "+SlNo+"="+code, null);
        if(cursor.getCount()>0){
            if(cursor.moveToNext()){
                str = cursor.getString(cursor.getColumnIndexOrThrow(col_name));
            }
        }
        return str;
    }
    public int Get_CreamyLayerReasons(String str, String col_name){
        int num=0;
        database = this.getReadableDatabase();
        cursor = database.rawQuery("Select SlNo from "+ Table_1_re +" where "+ col_name +"='"+str+"'" , null);
        if(cursor.getCount()>0){
            if(cursor.moveToNext()) {
                num = cursor.getInt(cursor.getColumnIndex(SlNo));
            }
        }
        return num;
    }

    public String Get_CertificateRejectionReason_BY_Code(int code, String col_name){
        String str="";
        database = this.getReadableDatabase();
        cursor = database.rawQuery("select * from "+Table_2_re+" where "+ SlNo+"="+code, null);
        if(cursor.getCount()>0){
            if(cursor.moveToNext()){
                str = cursor.getString(cursor.getColumnIndexOrThrow(col_name));
            }
        }
        return str;
    }

    public int Get_CertificateRejectionReason(String str, String col_name){
        int num=0;
        database = this.getReadableDatabase();
        cursor = database.rawQuery("Select * from "+ Table_2_re +" where "+ col_name +"='"+str+"'" , null);
        if(cursor.getCount()>0){
            if(cursor.moveToNext()) {
                num = cursor.getInt(cursor.getColumnIndex(SlNo));
            }
        }
        return num;
    }

    public String Get_Purpose_BY_Code(int code, String col_name){
        String str="";
        database = this.getReadableDatabase();
        cursor = database.rawQuery("select * from "+Table_3_re+ " where "+ SlNo+"="+code, null);
        if(cursor.getCount()>0){
            if(cursor.moveToNext()){
                str = cursor.getString(cursor.getColumnIndexOrThrow(col_name));
            }
        }
        return str;
    }

    public int Get_Purpose(String str, String col_name){
        int num=0;
        database = this.getReadableDatabase();
        cursor = database.rawQuery("Select * from "+Table_3_re+" where "+ col_name +"='"+str+"'" , null);
        if(cursor.getCount()>0){
            if(cursor.moveToNext()) {
                num = cursor.getInt(cursor.getColumnIndex(SlNo));
            }
        }
        return num;
    }

    public List<SpinnerObject> Get_Category(String str, String add){
        List<SpinnerObject> objects = new ArrayList<>();
        Log.d("Category1", "Get_Category enter");
        try{
            database = this.getReadableDatabase();
            cursor = database.rawQuery("select * from "+Table_CAT_MASTER+" where "+General_SCST+"='"+str+"'", null);
            objects.add ( new SpinnerObject( "0" , add ) );
            if (cursor.getCount()>0){
                if(cursor.moveToNext()) {
                    do {
                        objects.add(new SpinnerObject(cursor.getString(cursor.getColumnIndex(RTM_res_category_code)), cursor.getString(cursor.getColumnIndex(RTM_res_category_kdesc))));
                    } while (cursor.moveToNext());
                }
            }
            else {
                Log.d("Category1", "cursor count not greater than 0");
            }
            Log.d("Category1", String.valueOf(objects));
            cursor.close();
            database.close();


        }catch(Exception e){
            Log.d("Catch", String.valueOf(e));
        }
        return objects;
    }

    public List<SpinnerObject> Get_HKDistrict(String add){
        List<SpinnerObject> objects = new ArrayList<>();
        Log.d("Category1", "Get_Category enter");
        try{
            database = this.getReadableDatabase();
            cursor = database.rawQuery("select * from "+Table_DISTRICT_MASTER+" where "+LDM_Old_NK_DistrictCode+" = "+4+" or "
                    +LDM_Old_NK_DistrictCode+" = "+5+" or "+LDM_Old_NK_DistrictCode+" = "+6+" or "+LDM_Old_NK_DistrictCode+" = "+7+" or "
                    +LDM_Old_NK_DistrictCode+" = "+12+" or "+LDM_Old_NK_DistrictCode+" = "+30+" or "+LDM_Old_NK_DistrictCode+" = "+31 +" order by "+LDM_district_kname,null);
            objects.add ( new SpinnerObject( "0" , add) );
            if (cursor.getCount()>0){
                if(cursor.moveToNext()) {
                    do {
                        objects.add(new SpinnerObject(cursor.getString(cursor.getColumnIndex(LDM_district_code)), cursor.getString(cursor.getColumnIndex(LDM_district_kname))));
                    } while (cursor.moveToNext());
                }
            }
            else {
                Log.d("Category1", "cursor count not greater than 0");
            }
            Log.d("Category1", String.valueOf(objects));
            cursor.close();
            database.close();

        }catch(Exception e){
            Log.d("Catch", String.valueOf(e));
        }
        return objects;
    }

    public List<SpinnerObject> Get_HKTaluk(String add, int distCode){
        List<SpinnerObject> objects = new ArrayList<>();
        Log.d("Category1", "Get_Category enter");
        try{
            database = this.getReadableDatabase();
            if(distCode ==0) {
                cursor = database.rawQuery("select * from " + Table_TALUK_MASTER + " order by " + LTM_Taluk_kName, null);
            }else {
                cursor = database.rawQuery("select * from " + Table_TALUK_MASTER + " where "+LTM_District_code + " = "+distCode+" order by " + LTM_Taluk_kName, null);
            }
            objects.add ( new SpinnerObject( "0" , add) );
            if (cursor.getCount()>0){
                if(cursor.moveToNext()) {
                    do {
                        objects.add(new SpinnerObject(cursor.getString(cursor.getColumnIndex(LTM_Taluk_code)), cursor.getString(cursor.getColumnIndex(LTM_Taluk_kName))));
                    } while (cursor.moveToNext());
                }
            }
            else {
                Log.d("Category1", "cursor count not greater than 0");
            }
            Log.d("Category1", String.valueOf(objects));
            cursor.close();
            database.close();

        }catch(Exception e){
            Log.d("Catch", String.valueOf(e));
        }
        return objects;
    }

    public List<SpinnerObject> Get_HKHobli(String add, int talukCode){
        List<SpinnerObject> objects = new ArrayList<>();
        Log.d("Category1", "Get_Category enter");
        try{
            database = this.getReadableDatabase();
            if(talukCode ==0) {
                cursor = database.rawQuery("select * from " + Table_Hobli_MASTER + " order by " + LHM_Hobli_kName, null);
            }else {
                cursor = database.rawQuery("select * from " + Table_Hobli_MASTER + " where "+LHM_Taluk_code + " = "+talukCode+" order by " + LHM_Hobli_kName, null);
            }
            objects.add ( new SpinnerObject( "0" , add) );
            if (cursor.getCount()>0){
                if(cursor.moveToNext()) {
                    do {
                        objects.add(new SpinnerObject(cursor.getString(cursor.getColumnIndex(LHM_Hobli_Code)), cursor.getString(cursor.getColumnIndex(LHM_Hobli_kName))));
                    } while (cursor.moveToNext());
                }
            }
            else {
                Log.d("Category1", "cursor count not greater than 0");
            }
            Log.d("Category1", String.valueOf(objects));
            cursor.close();
            database.close();

        }catch(Exception e){
            Log.d("Catch", String.valueOf(e));
        }
        return objects;
    }


    @SuppressLint("Range")
    public String Get_HKDistrictByCode(int distCode){
        String dist = null;
        try{
            database = this.getReadableDatabase();
            cursor = database.rawQuery("select * from "+Table_DISTRICT_MASTER+" where "+LDM_district_code+" = "+distCode+" order by "+LDM_district_kname, null);
            if (cursor.getCount()>0){
                if(cursor.moveToNext()) {
                    do {
                        dist = cursor.getString(cursor.getColumnIndex(LDM_district_kname));
                    } while (cursor.moveToNext());
                }
            }
            else {
                Log.d("Category1", "cursor count not greater than 0");
            }
            cursor.close();
            database.close();

        }catch(Exception e){
            Log.d("Catch", String.valueOf(e));
        }
        return dist;
    }

    @SuppressLint("Range")
    public String Get_HKTalukByCode(int talukCode){
        String taluk = null;
        try{
            database = this.getReadableDatabase();
            cursor = database.rawQuery("select * from "+Table_TALUK_MASTER+" where "+LTM_Taluk_code+" = "+talukCode+" order by "+LTM_Taluk_kName, null);
            if (cursor.getCount()>0){
                if(cursor.moveToNext()) {
                    do {
                        taluk = cursor.getString(cursor.getColumnIndex(LTM_Taluk_kName));
                    } while (cursor.moveToNext());
                }
            }
            else {
                Log.d("Category1", "cursor count not greater than 0");
            }
            cursor.close();
            database.close();

        }catch(Exception e){
            Log.d("Catch", String.valueOf(e));
        }
        return taluk;
    }

    @SuppressLint("Range")
    public String Get_HKHobliByCode(int hobliCode){
        String hobli = null;
        try{
            database = this.getReadableDatabase();
            cursor = database.rawQuery("select * from "+Table_Hobli_MASTER+" where "+LHM_Hobli_Code+" = "+hobliCode+" order by "+LHM_Hobli_kName, null);
            if (cursor.getCount()>0){
                if(cursor.moveToNext()) {
                    do {
                        hobli = cursor.getString(cursor.getColumnIndex(LHM_Hobli_kName));
                    } while (cursor.moveToNext());
                }
            }
            else {
                Log.d("Category1", "cursor count not greater than 0");
            }
            cursor.close();
            database.close();

        }catch(Exception e){
            Log.d("Catch", String.valueOf(e));
        }
        return hobli;
    }

    public int Get_HKDistrictCodeByName(String name){
        int num=0;
        Log.d("Category1", "Get_Category enter");
        try{
            database = this.getReadableDatabase();
            cursor = database.rawQuery("select * from "+Table_DISTRICT_MASTER+" where "+LDM_district_kname+" = '"+name+"'" , null);
            if (cursor.getCount()>0){
                if(cursor.moveToNext()) {
                    num = cursor.getInt(cursor.getColumnIndex(LDM_district_code));
                }
                return num;
            }
            cursor.close();
            database.close();

        }catch(Exception e){
            Log.d("Catch", String.valueOf(e));
        }
        return num;
    }


    public List<SpinnerObject> Get_Category_OBC(String str, String add){
        List<SpinnerObject> objects = new ArrayList<>();
        Log.d("Category1", "Get_Category enter");
        try{
            database = this.getReadableDatabase();
            cursor = database.rawQuery("select * from "+Table_CAT_MASTER+" where "+General_SCST+"='"+str+"'", null);
            objects.add ( new SpinnerObject( "0" , add) );
            if (cursor.getCount()>0){
                if(cursor.moveToNext()) {
                    do {
                        objects.add(new SpinnerObject(cursor.getString(cursor.getColumnIndex(RTM_res_category_code)), cursor.getString(cursor.getColumnIndex(RTM_res_category_edesc))));
                    } while (cursor.moveToNext());
                }
            }
            else {
                Log.d("Category1", "cursor count not greater than 0");
            }
            Log.d("Category1", String.valueOf(objects));
            cursor.close();
            database.close();


        }catch(Exception e){
            Log.d("Catch", String.valueOf(e));
        }
        return objects;
    }

    public String GetCategory_BY_Code(int catCode){
        String str = "";
        database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("select * from "+ Table_CAT_MASTER+ " where "+RTM_res_category_code+"="+catCode, null);
        if(cursor.getCount()>0){
            if(cursor.moveToFirst()){
                str = cursor.getString(cursor.getColumnIndexOrThrow(RTM_res_category_kdesc));
            } else {
                cursor.close();
            }
            return str;
        }
        Log.d("Category", str);
        return str;
    }

    public int GetCategoryCode(String str){
        int num=0;
        database = this.getReadableDatabase();
        cursor = database.rawQuery("select * from "+ Table_CAT_MASTER+" where "+RTM_res_category_kdesc+"='"+str+"'", null);
        if(cursor.getCount()>0){
            if(cursor.moveToNext()){
                num = cursor.getInt(cursor.getColumnIndex(RTM_res_category_code));
            }
            return num;
        }
        Log.d("Category_Code", String.valueOf(num));
        return num;
    }

    public List<SpinnerObject> Get_Category_NK(){
        List<SpinnerObject> objects = new ArrayList<>();
        Log.d("Category_NK", "Get_Category enter");
        try{
            database = this.getReadableDatabase();
            cursor = database.rawQuery("select * from "+Table_CAT_MASTER, null);
            objects.add ( new SpinnerObject( "0" , "-- ??????????????? --") );
            if (cursor.getCount()>0){
                if(cursor.moveToNext()) {
                    do {
                        objects.add(new SpinnerObject(cursor.getString(cursor.getColumnIndex(RTM_res_category_code)), cursor.getString(cursor.getColumnIndex(RTM_res_category_kdesc))));
                    } while (cursor.moveToNext());
                }
            }
            else {
                Log.d("Category_NK", "cursor count not greater than 0");
            }
            Log.d("Category_NK", String.valueOf(objects));
            cursor.close();
            database.close();


        }catch(Exception e){
            Log.d("Catch", String.valueOf(e));
        }
        return objects;
    }

    public List<SpinnerObject> GetCaste(int num){
        List<SpinnerObject> objects = new ArrayList<>();
        try {
            database = this.getReadableDatabase();
            cursor = database.rawQuery("select * from "+ Table_CASTE_EXCEPT_OBC+" where "+CM_res_category_code+"='"+num+"' order by "+CM_caste_kdesc, null);
            if(cursor.getCount()>0){
                if(cursor.moveToNext()){
                    do{
                        objects.add(new SpinnerObject(cursor.getString(cursor.getColumnIndex(CM_res_category_code)), cursor.getString(cursor.getColumnIndex(CM_caste_kdesc))));
                    }while (cursor.moveToNext());
                }
            }
            cursor.close();
            database.close();
        }
        catch (Exception e){
            Log.d("Catch", String.valueOf(e));
        }
        Log.d("Caste", String.valueOf(objects));
        return objects;
    }
    public List<SpinnerObject> GetMinorityCasteByCode(int num){
        List<SpinnerObject> objects = new ArrayList<>();
        try {
            database = this.getReadableDatabase();
            cursor = database.rawQuery("select * from "+ Table_Minority_CASTE_MASTER+" where "+RGM_Minority+"= 'Y'"+" order by "+RGM_religion_kdesc, null);
            if(cursor.getCount()>0){
                if(cursor.moveToNext()){
                    do{
                        objects.add(new SpinnerObject(cursor.getString(cursor.getColumnIndex(RGM_religion_code)), cursor.getString(cursor.getColumnIndex(RGM_religion_kdesc))));
                    }while (cursor.moveToNext());
                }
            }
            cursor.close();
            database.close();
        }
        catch (Exception e){
            Log.d("Catch", String.valueOf(e));
        }
        Log.d("Caste", String.valueOf(objects));
        return objects;
    }

    public List<SpinnerObject> GetCaste_EWS(){
        List<SpinnerObject> objects = new ArrayList<>();
        try {
            database = this.getReadableDatabase();
            cursor = database.rawQuery("select * from "+ Table_CASTE_EXCEPT_OBC+" where "+CM_isEWS+"='Y' order by "+CM_caste_kdesc, null);
            if(cursor.getCount()>0){
                if(cursor.moveToNext()){
                    do{
                        objects.add(new SpinnerObject(cursor.getString(cursor.getColumnIndex(CM_res_category_code)), cursor.getString(cursor.getColumnIndex(CM_caste_kdesc))));
                    }while (cursor.moveToNext());
                }
            }
            cursor.close();
            database.close();
        }
        catch (Exception e){
            Log.d("Catch", String.valueOf(e));
        }
        Log.d("Caste", String.valueOf(objects));
        return objects;
    }

    public int  GetCaste_EWSCode(String ews_caste){
        int num =0;
        try {
            database = this.getReadableDatabase();
            cursor = database.rawQuery("select * from "+ Table_CASTE_EXCEPT_OBC+" where "+CM_isEWS+"='Y' and "+ CM_caste_kdesc +"='"+ews_caste+"'"+" order by "+CM_caste_kdesc, null);
            if(cursor.getCount()>0){
                if(cursor.moveToNext()){
                    do{
                        num = cursor.getColumnIndex(CM_res_category_code);
                    }while (cursor.moveToNext());
                }
            }
            cursor.close();
            database.close();
        }
        catch (Exception e){
            Log.d("Catch", String.valueOf(e));
        }
        Log.d("Caste", String.valueOf(num));
        return num;
    }



    public List<SpinnerObject> GetCaste_OBC(int num){
        List<SpinnerObject> objects = new ArrayList<>();
        try {
            database = this.getReadableDatabase();
            cursor = database.rawQuery("select * from "+ Table_CASTE_OBC+" where "+CM_res_category_code+"='"+num+"' order by "+CM_caste_edesc, null);
            if(cursor.getCount()>0){
                if(cursor.moveToNext()){
                    do{
                        objects.add(new SpinnerObject(cursor.getString(cursor.getColumnIndex(CM_res_category_code)), cursor.getString(cursor.getColumnIndex(CM_caste_edesc))));
                    }while (cursor.moveToNext());
                }
            }
            cursor.close();
            database.close();
        }
        catch (Exception e){
            Log.d("Catch", String.valueOf(e));
        }
        Log.d("Caste", String.valueOf(objects));
        return objects;
    }

    @SuppressLint("Range")
    public List<SpinnerObject> GetDocsName() {
        List<SpinnerObject> objects = new ArrayList<>();
        try {
            database = this.getReadableDatabase();
            cursor = database.rawQuery("select * from " + Table_DOCS_Type , null);
            objects.add ( new SpinnerObject( "0" , "-- ??????????????? --") );
            if (cursor.getCount() > 0) {
                if (cursor.moveToNext()) {
                    do {
                        objects.add(new SpinnerObject(cursor.getString(cursor.getColumnIndex(Doc_Code)), cursor.getString(cursor.getColumnIndex(Doc_Name_E))));
                    } while (cursor.moveToNext());
                }
            }
            cursor.close();
            database.close();
        } catch (Exception e) {
            Log.d("Catch", String.valueOf(e));
        }
        Log.d("Caste", String.valueOf(objects));
        return objects;
    }
    public String GetCaste_BY_Code(int CatCode,int casteCode){
        String str=null;
        database = this.getReadableDatabase();
        cursor = database.rawQuery("select * from "+Table_CASTE_EXCEPT_OBC+" where "+CM_res_category_code+"="+CatCode+" and "+CM_CASTE_ID+"="+casteCode +" order by "+CM_caste_kdesc, null);
        if(cursor.getCount()>0){
            if(cursor.moveToNext()){
                str = cursor.getString(cursor.getColumnIndexOrThrow(CM_caste_kdesc));
            }
        }
        else {
            //Log.d("Caste_Name", str);
        }
        return str;
    }

    @SuppressLint("Range")
    public int GetDocsCode(String str){
        int num=0;
        database = this.getReadableDatabase();
        cursor = database.rawQuery("select * from "+ Table_DOCS_Type+" where "+Doc_Name_E+"='"+str+"'", null);
        if(cursor.getCount()>0){
            if(cursor.moveToNext()){
                num = cursor.getInt(cursor.getColumnIndex(Doc_Code));
            }
            return num;
        }
        Log.d("Category_Code", String.valueOf(num));
        return num;
    }

    @SuppressLint("Range")
    public int GetCasteCode(String str, int catCode){
        int num=0;
        database = this.getReadableDatabase();
        cursor = database.rawQuery("select * from "+ Table_CASTE_EXCEPT_OBC+" where "+CM_caste_kdesc+"='"+str+"' and "+CM_res_category_code+" = "+catCode+" order by "+CM_caste_kdesc, null);
        if(cursor.getCount()>0){
            if(cursor.moveToNext()){
                num = cursor.getInt(cursor.getColumnIndex(CM_CASTE_ID));
            }
            return num;
        }
        Log.d("Caste_Code", String.valueOf(num));
        return num;
    }

    public int GetMinorityCasteCode(String str, int catCode){
        int num=0;
        database = this.getReadableDatabase();
        cursor = database.rawQuery("select * from "+ Table_Minority_CASTE_MASTER+" where "+RGM_religion_kdesc+"='"+str+"' order by "+RGM_religion_kdesc, null);
        if(cursor.getCount()>0){
            if(cursor.moveToNext()){
                num = cursor.getInt(cursor.getColumnIndex(RGM_religion_code));
            }
            return num;
        }
        Log.d("Caste_Code", String.valueOf(num));
        return num;
    }

    public String GetCaste_OBC_BY_Code(int casteCode){
        String str="";
        database = this.getReadableDatabase();
        cursor = database.rawQuery("select * from "+ Table_CASTE_OBC +" where "+OBC_OCM_CASTE_ID+"="+casteCode+" order by "+CM_caste_edesc, null);
        if(cursor.getCount()>0){
            if (cursor.moveToNext()){
                str = cursor.getString(cursor.getColumnIndexOrThrow(CM_caste_edesc));
            }
            return str;
        }
        Log.d("Caste", str);
        return str;
    }
    public String GetMinorityCaste_BY_Code(int casteCode){
        String str="";
        database = this.getReadableDatabase();
        cursor = database.rawQuery("select * from "+ Table_Minority_CASTE_MASTER +" where "+RGM_religion_code+"="+casteCode+" order by "+RGM_religion_kdesc, null);
        if(cursor.getCount()>0){
            if (cursor.moveToNext()){
                str = cursor.getString(cursor.getColumnIndexOrThrow(RGM_religion_kdesc));
            }
            return str;
        }
        Log.d("Caste", str);
        return str;
    }

    public int GetCasteCode_OBC(String str){
        int num=0;
        database = this.getReadableDatabase();
        cursor = database.rawQuery("select * from "+ Table_CASTE_OBC+" where "+CM_caste_edesc+"='"+str+"' order by "+CM_caste_edesc, null);
        if(cursor.getCount()>0){
            if(cursor.moveToNext()){
                num = cursor.getInt(cursor.getColumnIndex(OBC_OCM_CASTE_ID));
            }
            return num;
        }
        Log.d("Caste_Code", String.valueOf(num));
        return num;
    }

    public List<SpinnerObject> Get_Category_Service9999(String add){
        List<SpinnerObject> objects = new ArrayList<>();
        Log.d("Category1", "Get_Category enter");
        try{
            database = this.getReadableDatabase();
            cursor = database.rawQuery("select * from "+Table_CAT_MASTER+" where "+RTM_res_category_code+" between 1 and 7", null);
            objects.add ( new SpinnerObject( "0" , add) );
            if (cursor.getCount()>0){
                if(cursor.moveToNext()) {
                    do {
                        objects.add(new SpinnerObject(cursor.getString(cursor.getColumnIndex(RTM_res_category_code)), cursor.getString(cursor.getColumnIndex(RTM_res_category_kdesc))));
                    } while (cursor.moveToNext());
                }
            }
            else {
                Log.d("Category1", "cursor count not greater than 0");
            }
            Log.d("Category1", String.valueOf(objects));
            cursor.close();
            database.close();


        }catch(Exception e){
            Log.d("Catch", String.valueOf(e));
        }
        return objects;
    }

    public String GetID_Name(int Id_Code, String col_name){
        Log.d("ID_Code: ",""+Id_Code);
        String str=null;
        database = this.getReadableDatabase();
        cursor = database.rawQuery("select * from "+ ID_Master_tbl + " where "+ID_Code+"="+Id_Code, null);
        if (cursor.getCount()>0){
            if (cursor.moveToFirst()){
                str = cursor.getString(cursor.getColumnIndexOrThrow(col_name));
            }
            return str;
        }
        Log.d("ID_Name: ",""+str);
        return str;
    }

    private void CopyReasonDataBaseFromAsset() throws IOException {

        InputStream myInput = ctx.getAssets().open(DATABASE_NAME_reasons);

        // Path to the just created empty db
        String outFileName = getReasonDatabasePath();

        // if the path doesn't exist first, create it
        File f = new File(ctx.getApplicationInfo().dataDir + DB_PATH_SUFFIX);
        if (!f.exists())
            f.mkdir();

        // Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

        // transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }

        // Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    private void CopyCatCasteDataBaseFromAsset() throws IOException {

        InputStream myInput = ctx.getAssets().open(DATABASE_NAME_cat_caste);

        // Path to the just created empty db
        String outFileName = getCatCasteDatabasePath();

        // if the path doesn't exist first, create it
        File f = new File(ctx.getApplicationInfo().dataDir + DB_PATH_SUFFIX);
        if (!f.exists())
            f.mkdir();

        // Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

        // transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }
        // Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

    private void CopyMinorityCasteDataBaseFromAsset() throws IOException {

        InputStream myInput = ctx.getAssets().open(DATABASE_NAME_Minority_caste);

        // Path to the just created empty db
        String outFileName = getMinorityCasteDatabasePath();

        // if the path doesn't exist first, create it
        File f = new File(ctx.getApplicationInfo().dataDir + DB_PATH_SUFFIX);
        if (!f.exists())
            f.mkdir();

        // Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

        // transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }
        // Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

    private void CopyDocTypeDataBaseFromAsset() throws IOException {

        InputStream myInput = ctx.getAssets().open(DATABASE_NAME_docs_type);

        // Path to the just created empty db
        String outFileName = getDocsTypeDatabasePath();

        // if the path doesn't exist first, create it
        File f = new File(ctx.getApplicationInfo().dataDir + DB_PATH_SUFFIX);
        if (!f.exists())
            f.mkdir();

        // Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

        // transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }
        // Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

    private void CopyTownWardDataBaseFromAsset() throws IOException {

        InputStream myInput = ctx.getAssets().open(DATABASE_NAME_town_ward);

        // Path to the just created empty db
        String outFileName = getTownWardDatabasePath();

        // if the path doesn't exist first, create it
        File f = new File(ctx.getApplicationInfo().dataDir + DB_PATH_SUFFIX);
        if (!f.exists())
            f.mkdir();

        // Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

        // transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }
        // Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

    private void CopyIDTypeDataBaseFromAsset() throws IOException {

        InputStream myInput = ctx.getAssets().open(DATABASE_Name_ID_Type);

        // Path to the just created empty db
        String outFileName = getIDTypeDatabasePath();

        // if the path doesn't exist first, create it
        File f = new File(ctx.getApplicationInfo().dataDir + DB_PATH_SUFFIX);
        if (!f.exists())
            f.mkdir();

        // Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

        // transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }

        // Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    private void CopyHKDistrictDataBaseFromAsset() throws IOException {

        InputStream myInput = ctx.getAssets().open(DATABASE_NAME_District_master);

        // Path to the just created empty db
        String outFileName = getHKDistrictDatabasePath();

        // if the path doesn't exist first, create it
        File f = new File(ctx.getApplicationInfo().dataDir + DB_PATH_SUFFIX);
        if (!f.exists())
            f.mkdir();

        // Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

        // transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }
        // Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

    private static String getReasonDatabasePath() {
        return ctx.getApplicationInfo().dataDir + DB_PATH_SUFFIX + DATABASE_NAME_reasons;
    }

    private static String getCatCasteDatabasePath() {
        return ctx.getApplicationInfo().dataDir + DB_PATH_SUFFIX + DATABASE_NAME_cat_caste;
    }
    private static String getMinorityCasteDatabasePath() {
        return ctx.getApplicationInfo().dataDir + DB_PATH_SUFFIX + DATABASE_NAME_Minority_caste;
    }

    private static String getDocsTypeDatabasePath() {
        return ctx.getApplicationInfo().dataDir + DB_PATH_SUFFIX + DATABASE_NAME_docs_type;
    }

    private static String getTownWardDatabasePath() {
        return ctx.getApplicationInfo().dataDir + DB_PATH_SUFFIX + DATABASE_NAME_town_ward;
    }

    private static String getIDTypeDatabasePath() {
        return ctx.getApplicationInfo().dataDir + DB_PATH_SUFFIX + DATABASE_Name_ID_Type;
    }

    private static String getHKDistrictDatabasePath() {
        return ctx.getApplicationInfo().dataDir + DB_PATH_SUFFIX + DATABASE_NAME_District_master;
    }
    private static String getTalukMasterDatabasePath() {
        return ctx.getApplicationInfo().dataDir + DB_PATH_SUFFIX + DATABASE_NAME_Taluk_master;
    }

    private static String getHobliMasterDatabasePath() {
        return ctx.getApplicationInfo().dataDir + DB_PATH_SUFFIX + DATABASE_NAME_Hobli_master;
    }

    public void open_Reasons_Master_Tbl() throws SQLException {
        File dbFile = ctx.getDatabasePath(DATABASE_NAME_reasons);

        if (!dbFile.exists()) {
            try {
                CopyReasonDataBaseFromAsset();
                System.out.println("Copying success from Assets folder");
            } catch (IOException e) {
                throw new RuntimeException("Error creating source database", e);
            }
        }

        SQLiteDatabase.openDatabase(dbFile.getPath(), null, SQLiteDatabase.NO_LOCALIZED_COLLATORS | SQLiteDatabase.CREATE_IF_NECESSARY);
    }

    public void open_Cat_Caste_Tbl() throws SQLException {
        File dbFile = ctx.getDatabasePath(DATABASE_NAME_cat_caste);

        if (!dbFile.exists()) {
            try {
                CopyCatCasteDataBaseFromAsset();
                System.out.println("Copying success from Assets folder1");
            } catch (IOException e) {
                throw new RuntimeException("Error creating source database1", e);
            }
        }

        SQLiteDatabase.openDatabase(dbFile.getPath(), null, SQLiteDatabase.NO_LOCALIZED_COLLATORS | SQLiteDatabase.CREATE_IF_NECESSARY);
    }

    public void open_Minority_Caste_Tbl() throws SQLException {
        File dbFile = ctx.getDatabasePath(DATABASE_NAME_Minority_caste);

        if (!dbFile.exists()) {
            try {
                CopyMinorityCasteDataBaseFromAsset();
                System.out.println("Copying success from Assets folder1");
            } catch (IOException e) {
                throw new RuntimeException("Error creating source database1", e);
            }
        }

        SQLiteDatabase.openDatabase(dbFile.getPath(), null, SQLiteDatabase.NO_LOCALIZED_COLLATORS | SQLiteDatabase.CREATE_IF_NECESSARY);
    }

    public void open_Docs_Type_Tbl() throws SQLException {
        File dbFile = ctx.getDatabasePath(DATABASE_NAME_docs_type);

        if (!dbFile.exists()) {
            try {
                CopyDocTypeDataBaseFromAsset();
                System.out.println("Copying success from Assets folder1");
            } catch (IOException e) {
                throw new RuntimeException("Error creating source database1", e);
            }
        }

        SQLiteDatabase.openDatabase(dbFile.getPath(), null, SQLiteDatabase.NO_LOCALIZED_COLLATORS | SQLiteDatabase.CREATE_IF_NECESSARY);
    }

    public void open_Town_Ward_Tbl() throws SQLException {
        File dbFile = ctx.getDatabasePath(DATABASE_NAME_town_ward);

        if (!dbFile.exists()) {
            try {
                CopyTownWardDataBaseFromAsset();
                System.out.println("Copying success from Assets folder");
            } catch (IOException e) {
                throw new RuntimeException("Error creating source database", e);
            }
        }

        SQLiteDatabase.openDatabase(dbFile.getPath(), null, SQLiteDatabase.NO_LOCALIZED_COLLATORS | SQLiteDatabase.CREATE_IF_NECESSARY);
    }

    public void open_ID_Type_Tbl() throws SQLException {
        File dbFile = ctx.getDatabasePath(DATABASE_Name_ID_Type);

        if (!dbFile.exists()) {
            try {
                CopyIDTypeDataBaseFromAsset();
                System.out.println("Copying success from Assets folder");
            } catch (IOException e) {
                throw new RuntimeException("Error creating source database", e);
            }
        }

        SQLiteDatabase.openDatabase(dbFile.getPath(), null, SQLiteDatabase.NO_LOCALIZED_COLLATORS | SQLiteDatabase.CREATE_IF_NECESSARY);
    }

    public void open_HKDistrict_Tbl() throws SQLException {
        File dbFile = ctx.getDatabasePath(DATABASE_NAME_District_master);

        if (!dbFile.exists()) {
            try {
                CopyHKDistrictDataBaseFromAsset();
                System.out.println("Copying success from Assets folder1");
            } catch (IOException e) {
                throw new RuntimeException("Error creating source database1", e);
            }
        }

        SQLiteDatabase.openDatabase(dbFile.getPath(), null, SQLiteDatabase.NO_LOCALIZED_COLLATORS | SQLiteDatabase.CREATE_IF_NECESSARY);
    }
    public void open_HK_Taluk_Tbl() throws SQLException {
        File dbFile = ctx.getDatabasePath(DATABASE_NAME_Taluk_master);

        if (!dbFile.exists()) {
            try {
                CopyHKTalukDataBaseFromAsset();
                System.out.println("Copying success from Assets folder1");
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Error creating source database1", e);
            }
        }
        Log.d("dbFile.getPath",""+dbFile.getPath());
        SQLiteDatabase.openDatabase(dbFile.getPath(), null, SQLiteDatabase.NO_LOCALIZED_COLLATORS | SQLiteDatabase.CREATE_IF_NECESSARY);
    }

    public void open_HK_hobli_Tbl() throws SQLException {
        File dbFile = ctx.getDatabasePath(DATABASE_NAME_Hobli_master);

        if (!dbFile.exists()) {
            try {
                CopyHKHobliDataBaseFromAsset();
                System.out.println("Copying success from Assets folder1");
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Error creating source database1", e);
            }
        }
        Log.d("dbFile.getPath",""+dbFile.getPath());
        SQLiteDatabase.openDatabase(dbFile.getPath(), null, SQLiteDatabase.NO_LOCALIZED_COLLATORS | SQLiteDatabase.CREATE_IF_NECESSARY);
    }
    private void CopyHKTalukDataBaseFromAsset() throws IOException {

        InputStream myInput = ctx.getAssets().open(DATABASE_NAME_Taluk_master);

        // Path to the just created empty db
        String outFileName = getTalukMasterDatabasePath();

        // if the path doesn't exist first, create it
        File f = new File(ctx.getApplicationInfo().dataDir + DB_PATH_SUFFIX);
        if (!f.exists())
            f.mkdir();

        // Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

        // transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }
        // Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

    private void CopyHKHobliDataBaseFromAsset() throws IOException {

        InputStream myInput = ctx.getAssets().open(DATABASE_NAME_Hobli_master);

        // Path to the just created empty db
        String outFileName = getHobliMasterDatabasePath();

        // if the path doesn't exist first, create it
        File f = new File(ctx.getApplicationInfo().dataDir + DB_PATH_SUFFIX);
        if (!f.exists())
            f.mkdir();

        // Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

        // transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }
        // Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }
}
