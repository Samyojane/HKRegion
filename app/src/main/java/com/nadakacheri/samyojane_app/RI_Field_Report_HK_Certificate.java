package com.nadakacheri.samyojane_app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nadakacheri.samyojane_app.model.ResidenceDetails;

import org.checkerframework.checker.units.qual.A;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

public class RI_Field_Report_HK_Certificate  extends AppCompatActivity {

    TextView tvHobli, tvTaluk, tvRI_Name, tvServiceName, tv_V_T_Name, txt_ReportNo;
    String RI_Name,district, taluk, hobli, VA_Circle_Name, VA_Name, applicant_Id, applicant_name;
    int district_Code, taluk_Code, hobli_Code, va_Circle_Code, villageCode, town_code, ward_code;
    String village_name, service_name;
    String serviceCode, habitationCode, town_Name, ward_Name, option_Flag;
    TextView txt_raiseLoc, title, RI_Recommendation, ApplicantID, ApplicantName, txt_add1, txt_add2, txt_add3, txt_add_Pin, AnnualIncome, ReservationGiven, Remarks;
    String appID, appName, address1, address2, address3, add_pin, appAnnualIncome, appReservationGiven, remarks;
    int appTitle_Code, binCom_Code, fatTitle_Code;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase database,hkdatabase;
    SqlLiteOpenHelper_Class sqlLiteOpenHelper_class;
    SQLiteAssetHelper_Masters sqLiteAssetHelper_masters;
    Activity activity;
    String raisedLoc, eng_certi, report_no;
    SharedPreferences sharedPreferences;
    String uName_get, mobileNum, fatTitle_Name, fatherName, binCom_Name;
    int DesiCode;
    final int min = 1111;
    final int max = 9999;
    int random;
    EditText tvIncome;
    Button btnSave, btnBack, btnDownDocs, btnViewDocs;
    TextView tvVillageName, tvAppCategory, tvAppCaste, tvAnnualIncome,tvRemarksColor,tvRemarks, txt_appMobileNum, txt_BinCom, txt_appFatherName;
    boolean return_Value;
    InputMethodManager imm;
    InputMethodSubtype ims;
    RadioGroup radioGroup2, radioGroup3;
    RadioButton radioButton2, radioButton22, radioButton3, radioButton33;
    private ArrayList<ResidenceDetails> residenceList= new ArrayList<>();
    private hk_residence_adapter myAdapter;


    InputFilter filter_Eng = (source, start, end, dest, dstart, dend) -> {
        Log.d("Source",""+source);
        String num = "1234567890೧೨೩೪೫೬೭೮೯೦";
        String op1 = "~`!@#$%^&*()_-''+={}[]:/?><,.\\\"\";£€¢¥₩§|×÷¿■□♤♡◇♧°•○●☆▪¤《》¡₹Π℅®©™∆√¶";
        String l1 = "ಅಆಇಈಉಊಋಎಏಐಒಓಔಅಂಅಃ";
        String l2 = "ಕಕಾಕಿಕೀಕುಕೂಕೃಕೆಕೇಕೈಕೊಕೋಕೌಕಂಕಃಕ್";
        String l3 = "ಖಖಾಖಿಖೀಖುಖೂಖೃಖೆಖೇಖೈಖೊಖೋಖೌಖಂಖಃಖ್";
        String l4 = "ಗಗಾಗಿಗೀಗುಗೂಗೃಗೆಗೇಗೈಗೊಗೋಗೌಗಂಗಃಗ್";
        String l5 = "ಘಘಾಘಿಘೀಘುಘೂಘೃಘೆಘೇಘೈಘೊಘೋಘೌಘಂಘಃಘ್";
        String l6 = "ಙಙಾಙಿಙೀಙುಙೂಙೃಙೆಙೇಙೈಙೊಙೋಙೌಙಂಙಃಙ್";
        String l7 = "ಚಚಾಚಿಚೀಚುಚೂಚೃಚೆಚೇಚೈಚೊಚೋಚೌಚಂಚಃಚ್";
        String l8 = "ಛಛಾಛಿಛೀಛುಛೂಛೃಛೆಛೇಛೈಛೊಛೋಛೌಛಂಛಃಛ್";
        String l9 = "ಜಜಾಜಿಜೀಜುಜೂಜೃಜೆಜೇಜೈಜೊಜೋಜೌಜಂಜಃಜ್";
        String l10 = "ಝಝಾಝಿಝೀಝುಝೂಝೃಝೆಝೇಝೈಝೊಝೋಝೌಝಂಝಃಝ್";
        String l11 = "ಞಞಾಞಿಞೀಞುಞೂಞೃಞೆಞೇಞೈಞೊಞೋಞೌಞಂಞಃಞ್";
        String l12 = "ಟಟಾಟಿಟೀಟುಟೂಟೃಟೆಟೇಟೈಟೊಟೋಟೌಟಂಟಃಟ್";
        String l13 = "ಠಠಾಠಿಠೀಠುಠೂಠೃಠೆಠೇಠೈಠೊಠೋಠೌಠಂಠಃಠ್";
        String l14 = "ಡಡಾಡಿಡೀಡುಡೂಡೃಡೆಡೇಡೈಡೊಡೋಡೌಡಂಡಃಡ್";
        String l15 = "ಢಢಾಢಿಢೀಢುಢೂಢೃಢೆಢೇಢೈಢೊಢೋಢೌಢಂಢಃಢ್";
        String l16 = "ಣಣಾಣಿಣೀಣುಣೂಣೃಣೆಣೇಣೈಣೊಣೋಣೌಣಂಣಃಣ್";
        String l17 = "ತತಾತಿತೀತುತೂತೃತೆತೇತೈತೊತೋತೌತಂತಃತ್";
        String l18 = "ಥಥಾಥಿಥೀಥುಥೂಥೃಥೆಥೇಥೈಥೊಥೋಥೌಥಂಥಃಥ್";
        String l19 = "ದದಾದಿದೀದುದೂದೃದೆದೇದೈದೊದೋದೌದಂದಃದ್";
        String l20 = "ಧಧಾಧಿಧೀಧುಧೂಧೃಧೆಧೇಧೈಧೊಧೋಧೌಧಂಧಃಧ್";
        String l21 = "ನನಾನಿನೀನುನೂನೃನೆನೇನೈನೊನೋನೌನಂನಃನ್";
        String l22 = "ಪಪಾಪಿಪೀಪುಪೂಪೃಪೆಪೇಪೈಪೊಪೋಪೌಪಂಪಃಪ್";
        String l23 = "ಫಫಾಫಿಫೀಫುಫೂಫೃಫೆಫೇಫೈಫೊಫೋಫೌಫಂಫಃಫ್";
        String l24 = "ಬಬಾಬಿಬೀಬುಬೂಬೃಬೆಬೇಬೈಬೊಬೋಬೌಬಂಬಃಬ್";
        String l25 = "ಭಭಾಭಿಭೀಭುಭೂಭೃಭೆಭೇಭೈಭೊಭೋಭೌಭಂಭಃಭ್";
        String l26 = "ಮಮಾಮಿಮೀಮುಮೂಮೃಮೆಮೇಮೈಮೊಮೋಮೌಮಂಮಃಮ್";
        String l27 = "ಯಯಾಯಿಯೀಯುಯೂಯೃಯೆಯೇಯೈಯೊಯೋಯೌಯಂಯಃಯ್";
        String l28 = "ರರಾರಿರೀರುರೂರೃರೆರೇರೈರೊರೋರೌರಂರಃರ್";
        String l29 = "ಱಱಾಱಿಱೀಱುಱೂಱೃಱೆಱೇಱೈಱೊಱೋಱೌಱಂಱಃಱ್";
        String l30 = "ಲಲಾಲಿಲೀಲುಲೂಲೃಲೆಲೇಲೈಲೊಲೋಲೌಲಂಲಃಲ್";
        String l31 = "ವವಾವಿವೀವುವೂವೃವೆವೇವೈವೊವೋವೌವಂವಃವ್";
        String l32 = "ಶಶಾಶಿಶೀಶುಶೂಶೃಶೆಶೇಶೈಶೊಶೋಶೌಶಂಶಃಶ್";
        String l33 = "ಷಷಾಷಿಷೀಷುಷೂಷೃಷೆಷೇಷೈಷೊಷೋಷೌಷಂಷಃಷ್";
        String l34 = "ಸಸಾಸಿಸೀಸುಸೂಸೃಸೆಸೇಸೈಸೊಸೋಸೌಸಂಸಃಸ್";
        String l35 = "ಹಹಾಹಿಹೀಹುಹೂಹೃಹೆಹೇಹೈಹೊಹೋಹೌಹಂಹಃಹ್";
        String l36 = "ಳಳಾಳಿಳೀಳುಳೂಳೃಳೆಳೇಳೈಳೊಳೋಳೌಳಂಳಃಳ್";

        String blockCharacterSet = num+op1+l1+l2+l3+l4+l5+l6+l7+l8+l9+l10+l11+l12+l13+l14+l15+l16+l17+l18+l19+l20
                +l21+l22+l23+l24+l25+l26+l27+l28+l29+l30+l31+l32+l33+l34+l35+l36;

        for (int i = start; i < end; i++) {
            Log.d("source.charAt(i)",""+i+" : "+source.charAt(i));
            if (blockCharacterSet.contains(("" + source.charAt(i)))) {
                Log.d("Blocked",""+source);
                return "";
            }
        }
        Log.d("Filter_valid","Not blocked");

        return null;
    };

    InputFilter filter_Kan = (source, start, end, dest, dstart, dend) -> {
        Log.d("Source",""+source);
        String l1 = "abcdefghijklmnopqrstuvwxyz";
        String l2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String op1 = "~`!@#$%^&*()_-''+={}[]:/?><,.\\\"\";£€¢¥₩§|×÷¿■□♤♡◇♧°•○●☆▪¤《》¡₹Π℅®©™∆√¶1234567890೧೨೩೪೫೬೭೮೯೦";
        String blockCharacterSet = l1+l2+op1;

        for (int i = start; i < end; i++) {
            Log.d("source.charAt(i)",""+i+" : "+source.charAt(i));
            if (blockCharacterSet.contains("" + source.charAt(i))) {
                Log.d("Blocked",""+source);
                return "";
            }
        }
        Log.d("Filter_valid","Not blocked");
        return null;
    };
    GPSTracker gpsTracker;
    double latitude, longitude;
    ProgressDialog dialog;
    String option2, option3;
    private RecyclerView recyclerView;

    @SuppressLint({"ClickableViewAccessibility", "Range"})
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ri_field_report_hk_certificate);

        option2="Y";
        option3="Y";

        tvTaluk = findViewById(R.id.taluk);
        tvHobli = findViewById(R.id.hobli);
        tvRI_Name = findViewById(R.id.RI_name);
        txt_ReportNo = findViewById(R.id.txt_ReportNo);

        btnBack = findViewById(R.id.btnBack);
        txt_raiseLoc = findViewById(R.id.txt_raiseLoc);
        tvServiceName = findViewById(R.id.tvServiceName);
        title = findViewById(R.id.title);
        RI_Recommendation = findViewById(R.id.RI_Recommendation);
        tvVillageName = findViewById(R.id.tvVillageName);
        ApplicantID = findViewById(R.id.tvApplicantID);
        ApplicantName = findViewById(R.id.ApplicantName);
        txt_add1 = findViewById(R.id.txt_add1);
        txt_add2 = findViewById(R.id.txt_add2);
        txt_add3 = findViewById(R.id.txt_add3);
        txt_add_Pin = findViewById(R.id.txt_add_Pin);
        AnnualIncome = findViewById(R.id.AnnualIncome);
        ReservationGiven = findViewById(R.id.ReservationGiven);
        radioGroup2 = findViewById(R.id.radioGroup1);
        radioGroup3 = findViewById(R.id.radioGroup2);
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton22 = findViewById(R.id.radioButton22);
        radioButton3 = findViewById(R.id.radioButton3);
        radioButton33 = findViewById(R.id.radioButton33);
        Remarks = findViewById(R.id.Remarks);
        tvIncome = findViewById(R.id.tvIncome);
        tvRemarks = findViewById(R.id.tvRemarks);
        btnSave = findViewById(R.id.btnSave);
        tvAppCategory = findViewById(R.id.tvAppCategory);
        tvAppCaste = findViewById(R.id.tvAppCaste);
        tvAnnualIncome = findViewById(R.id.tvAnnualIncome);
        tv_V_T_Name = findViewById(R.id.tv_V_T_Name);
        tvRemarksColor = findViewById(R.id.tvRemarksColor);
        btnDownDocs = findViewById(R.id.btnDownDocs);
        btnViewDocs = findViewById(R.id.btnViewDocs);
        txt_appMobileNum = findViewById(R.id.txt_appMobileNum);
        txt_BinCom = findViewById(R.id.txt_BinCom);
        txt_appFatherName = findViewById(R.id.txt_appFatherName);
        recyclerView = findViewById(R.id.recyclerView);

        Intent i = getIntent();
        district_Code = i.getIntExtra("district_Code",0);
        district = i.getStringExtra("district");
        taluk_Code = i.getIntExtra("taluk_Code",0);
        taluk = i.getStringExtra("taluk");
        hobli_Code = i.getIntExtra("hobli_Code",0);
        hobli = i.getStringExtra("hobli");
        va_Circle_Code = i.getIntExtra("va_Circle_Code",0);
        VA_Circle_Name = i.getStringExtra("VA_Circle_Name");
        applicant_Id = i.getStringExtra("applicant_Id");
        applicant_name = i.getStringExtra("applicant_name");
        RI_Name = i.getStringExtra("RI_Name");
        VA_Name = i.getStringExtra("VA_Name");
        village_name = i.getStringExtra("strSearchVillageName");
        service_name = i.getStringExtra("strSearchServiceName");
        villageCode = i.getIntExtra("villageCode", 0);
        habitationCode = i.getStringExtra("habitationCode");
        serviceCode = i.getStringExtra("serviceCode");
        town_code = i.getIntExtra("town_code", 0);
        town_Name = i.getStringExtra("town_Name");
        ward_code = i.getIntExtra("ward_code", 0);
        ward_Name = i.getStringExtra("ward_Name");
        option_Flag = i.getStringExtra("option_Flag");
        eng_certi = i.getStringExtra("eng_certi");
        report_no = i.getStringExtra("report_No");

        sharedPreferences = getSharedPreferences(Constants.SHARED_PREFERENCES, Context.MODE_PRIVATE);
        DesiCode = sharedPreferences.getInt(Constants.DesiCode_RI, 19);
        uName_get = sharedPreferences.getString(Constants.uName_get, "");


        if (report_no == null) {
            Date c1 = Calendar.getInstance().getTime();

            SimpleDateFormat df1 = new SimpleDateFormat("dd/MM/yy", Locale.ENGLISH);
            String formattedDate1 = df1.format(c1);

            Log.d("formattedDate", "" + formattedDate1);

            random = new Random().nextInt((max - min) + 1) + min;
            Log.d("Random_Num", String.valueOf(+random));

            report_no = formattedDate1 + "\\" + random;
            Log.d("report_no", "" + report_no);
        }


        String strVAName = getString(R.string.shri_smt)+" "+VA_Name+", "+getString(R.string.village_accountant);
        title.setText(strVAName);
        title.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);

        RI_Recommendation.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);

        if (eng_certi.equals("K")){
            tvRemarks.setFilters(new InputFilter[] { filter_Kan });
        }else if (eng_certi.equals("E")){
            tvRemarks.setFilters(new InputFilter[] { filter_Eng });
        }

        tvRemarks.setOnTouchListener((v, event) -> {
            if(Objects.equals(eng_certi, "K")){
                check_Kannada_Key_lang();
            }
            else if(Objects.equals(eng_certi, "E")) {
                check_English_Key_lang();
            }
            return false;
        });

        tvTaluk.setText(taluk);
        tvHobli.setText(hobli);
        tvRI_Name.setText(RI_Name);
        tvServiceName.setText(service_name);
        txt_ReportNo.setText(report_no);

        String villageTownName;

        if(!Objects.equals(villageCode, "99999")){
            Log.d("Data","Rural");
            villageTownName = getString(R.string.village_name)+" : ";
            tv_V_T_Name.setText(villageTownName);
            tvVillageName.setText(village_name);
        }else if(!Objects.equals(town_code, "9999")){
            Log.d("Data","Urban");
            villageTownName = getString(R.string.ward_name_num)+" : ";
            tv_V_T_Name.setText(villageTownName);
            tvVillageName.setText(ward_Name);
        }

        openHelper = new DataBaseHelperClass_btnDownload_ServiceParameter_Tbl_RI(this);
        database = openHelper.getWritableDatabase();

        openHelper = new DataBaseHelperClass_UploadResidence_Proofs(this);
        hkdatabase = openHelper.getWritableDatabase();

        Cursor cursor = database.rawQuery("select * from "+ DataBaseHelperClass_btnDownload_ServiceParameter_Tbl_RI.TABLE_NAME+" where "
                + DataBaseHelperClass_btnDownload_ServiceParameter_Tbl_RI.GSCNo+"='"+applicant_Id+"'", null);
        if(cursor.getCount()>0){
            if(cursor.moveToFirst()){
                eng_certi = cursor.getString(cursor.getColumnIndex(DataBaseHelperClass_btnDownload_ServiceParameter_Tbl_RI.ST_Eng_Certificate));
                raisedLoc = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseHelperClass_btnDownload_ServiceParameter_Tbl_RI.Raised_Location));
                appID = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseHelperClass_btnDownload_ServiceParameter_Tbl_RI.GSCNo));
                appName = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseHelperClass_btnDownload_ServiceParameter_Tbl_RI.Applicant_Name));
                address1 = cursor.getString(cursor.getColumnIndex(DataBaseHelperClass_btnDownload_ServiceParameter_Tbl_RI.Address1));
                address2 = cursor.getString(cursor.getColumnIndex(DataBaseHelperClass_btnDownload_ServiceParameter_Tbl_RI.Address2));
                address3 = cursor.getString(cursor.getColumnIndex(DataBaseHelperClass_btnDownload_ServiceParameter_Tbl_RI.Address3));
                add_pin = cursor.getString(cursor.getColumnIndex(DataBaseHelperClass_btnDownload_ServiceParameter_Tbl_RI.PinCode));
                appTitle_Code = cursor.getInt(cursor.getColumnIndex(DataBaseHelperClass_btnDownload_ServiceParameter_Tbl_RI.ApplicantTiitle));
                binCom_Code = cursor.getInt(cursor.getColumnIndex(DataBaseHelperClass_btnDownload_ServiceParameter_Tbl_RI.BinCom));
                fatTitle_Code = cursor.getInt(cursor.getColumnIndex(DataBaseHelperClass_btnDownload_ServiceParameter_Tbl_RI.RelationTitle));
                fatherName = cursor.getString(cursor.getColumnIndex(DataBaseHelperClass_btnDownload_ServiceParameter_Tbl_RI.FatherName));
                appAnnualIncome = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseHelperClass_btnDownload_ServiceParameter_Tbl_RI.AnnualIncome));
                appReservationGiven = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseHelperClass_btnDownload_ServiceParameter_Tbl_RI.Can_Certificate_Given));
                mobileNum = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseHelperClass_btnDownload_ServiceParameter_Tbl_RI.Mobile_No));
                remarks = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseHelperClass_btnDownload_ServiceParameter_Tbl_RI.VA_Remarks));
            }
        } else {
            cursor.close();
        }

        setHKRecyclerView();
        fetchHKResidenceData(applicant_Id);
        if(Objects.equals(raisedLoc, "N") || Objects.equals(raisedLoc, "S")){
            txt_raiseLoc.setText(getString(R.string.nadakacheri_raised));
        }else if(Objects.equals(raisedLoc, "P") || Objects.equals(raisedLoc, "B") || Objects.equals(raisedLoc, "K") || Objects.equals(raisedLoc, "G") || Objects.equals(raisedLoc, "I")){
            txt_raiseLoc.setText(getString(R.string.online));
        }else if(Objects.equals(raisedLoc, "E")){
            txt_raiseLoc.setText(getString(R.string.seva_sindhu));
        }else if(Objects.equals(raisedLoc, "W")){
            txt_raiseLoc.setText(getString(R.string.wallet));
        }else {
            txt_raiseLoc.setText(getString(R.string.not_specified));
        }

        gpsTracker = new GPSTracker(getApplicationContext(), this);

        if (gpsTracker.canGetLocation()) {
            latitude = gpsTracker.getLatitude();
            longitude = gpsTracker.getLongitude();
            Log.d("Location", ""+latitude+""+longitude);
        } else {
            //gpsTracker.showSettingsAlert();
            Toast.makeText(getApplicationContext(), getString(R.string.switch_on_gps), Toast.LENGTH_SHORT).show();
        }

        dialog = new ProgressDialog(this, R.style.CustomDialog);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage(getString(R.string.loading));
        dialog.setIndeterminate(true);
        dialog.setProgress(1);

        sqLiteAssetHelper_masters = new SQLiteAssetHelper_Masters(this, activity);
        sqLiteAssetHelper_masters.open_Title_MASTER_Tbl();
        fatTitle_Name = sqLiteAssetHelper_masters.Get_Title_By_Code(fatTitle_Code, getString(R.string.title_desc_name));
        binCom_Name = sqLiteAssetHelper_masters.Get_BinCom_By_Code(binCom_Code, getString(R.string.bincom_desc_name));


        String father_or_Husband_Name = fatTitle_Name + " " + fatherName;
        ApplicantID.setText(applicant_Id);
        ApplicantName.setText(appName);
        txt_add1.setText(address1);
        txt_add2.setText(address2);
        txt_add3.setText(address3);
        txt_add_Pin.setText(add_pin);
        txt_appFatherName.setText(father_or_Husband_Name);
        txt_appMobileNum.setText(mobileNum);
        txt_BinCom.setText(binCom_Name);
       // AnnualIncome.setText(appAnnualIncome);
       // ReservationGiven.setText(appReservationGiven);
//        Remarks.setText(remarks);

        radioGroup2.setOnCheckedChangeListener((group, checkedId) -> {
            // find which radio button is selected
            if (checkedId == R.id.radioButton3) {
                option2 = "Y";
                Remarks.setVisibility(View.VISIBLE);
                tvIncome.setVisibility(View.GONE);
                tvRemarks.setVisibility(View.GONE);
                ReservationGiven.setVisibility(View.VISIBLE);
                AnnualIncome.setVisibility(View.VISIBLE);

                tvAppCategory.setTextColor(Color.parseColor("#0000ff"));
                tvAppCaste.setTextColor(Color.parseColor("#0000ff"));
                tvAnnualIncome.setTextColor(Color.parseColor("#000000"));
                tvRemarksColor.setTextColor(Color.parseColor("#000000"));
            } else if (checkedId == R.id.radioButton33) {
                option2 = "N";
                Remarks.setVisibility(View.GONE);
                tvIncome.setVisibility(View.VISIBLE);
                tvRemarks.setVisibility(View.VISIBLE);
                ReservationGiven.setVisibility(View.GONE);
                AnnualIncome.setVisibility(View.GONE);

                tvAppCategory.setTextColor(Color.parseColor("#0000ff"));
                tvAppCaste.setTextColor(Color.parseColor("#0000ff"));
                tvAnnualIncome.setTextColor(Color.parseColor("#0000ff"));
                tvRemarksColor.setTextColor(Color.parseColor("#0000ff"));
            }
            Log.d("option", ""+option2);
        });

        radioGroup3.setOnCheckedChangeListener((group, checkedId) -> {
            // find which radio button is selected
            if (checkedId == R.id.radioButton2) {
                option3 = "Y";
            } else if (checkedId == R.id.radioButton22) {
                option3 = "N";
            }
        });

        btnBack.setOnClickListener(v -> onBackPressed());

        btnSave.setOnClickListener(v -> {
            try {
                if (gpsTracker.canGetLocation()) {
                    latitude = gpsTracker.getLatitude();
                    longitude = gpsTracker.getLongitude();
                    Log.d("Location", latitude + "" + longitude);
                } else {
                    //gpsTracker.showSettingsAlert();
                    Toast.makeText(getApplicationContext(), getString(R.string.switch_on_gps), Toast.LENGTH_SHORT).show();
                }

                if (latitude != 0.0 && longitude != 0.0) {
                    if (option2.equals("N")) {
                    }
                    else
                    {
                        StoreData_in_DB_When_Correct();
                    }

                }
            }catch (Exception e){
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), ""+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public String StoreData_in_DB_When_Correct(){
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.ENGLISH);
        String currDate = dateFormat.format(date);

        openHelper = new DataBaseHelperClass_btnDownload_ServiceParameter_Tbl_RI(RI_Field_Report_HK_Certificate.this);
        database = openHelper.getWritableDatabase();

        Cursor cursor = database.rawQuery("select * from " + DataBaseHelperClass_btnDownload_ServiceParameter_Tbl_RI.TABLE_NAME + " where "
                + DataBaseHelperClass_btnDownload_ServiceParameter_Tbl_RI.GSCNo + "='"+applicant_Id+"'", null);
        if(cursor.getCount()>0) {
            try {
                database.execSQL("update " + DataBaseHelperClass_btnDownload_ServiceParameter_Tbl_RI.TABLE_NAME + " set "
                        + DataBaseHelperClass_btnDownload_ServiceParameter_Tbl_RI.DataUpdateFlag + "=1 where "
                        + DataBaseHelperClass_btnDownload_ServiceParameter_Tbl_RI.GSCNo + "='" + applicant_Id + "'");

                database.execSQL("update " + DataBaseHelperClass_btnDownload_ServiceParameter_Tbl_RI.TABLE_NAME_1 + " set "
                        + DataBaseHelperClass_btnDownload_ServiceParameter_Tbl_RI.UPD_vLat + "=" + latitude + ","
                        + DataBaseHelperClass_btnDownload_ServiceParameter_Tbl_RI.UPD_vLong + "=" + longitude + ","
                        + DataBaseHelperClass_btnDownload_ServiceParameter_Tbl_RI.UPD_Can_Certificate_Given + "='" + option3 + "',"
                        + DataBaseHelperClass_btnDownload_ServiceParameter_Tbl_RI.UPD_DifferFromAppinformation + "='" + option2 + "',"
                        + DataBaseHelperClass_btnDownload_ServiceParameter_Tbl_RI.UPD_Report_No + "='" + report_no + "',"
                        + DataBaseHelperClass_btnDownload_ServiceParameter_Tbl_RI.UPD_ReportDate + "='" + currDate + "',"
                        + DataBaseHelperClass_btnDownload_ServiceParameter_Tbl_RI.UPD_DataUpdateFlag + "=1"
                        + " where " + DataBaseHelperClass_btnDownload_ServiceParameter_Tbl_RI.UPD_GSCNo + "='" + applicant_Id + "'");

                Intent i = new Intent(RI_Field_Report_HK_Certificate.this, RI_Field_Report_FirstScreen.class);
                i.putExtra("applicant_Id", applicant_Id);
                i.putExtra("district_Code", district_Code);
                i.putExtra("taluk_Code", taluk_Code);
                i.putExtra("hobli_Code", hobli_Code);
                i.putExtra("district", district);
                i.putExtra("taluk", taluk);
                i.putExtra("RI_Name", RI_Name);
                i.putExtra("VA_Name", VA_Name);
                i.putExtra("hobli", hobli);
                i.putExtra("va_Circle_Code", va_Circle_Code);
                i.putExtra("VA_Circle_Name", VA_Circle_Name);
                i.putExtra("strSearchServiceName", service_name);
                i.putExtra("strSearchVillageName", village_name);
                i.putExtra("serviceCode", serviceCode);
                i.putExtra("villageCode", villageCode);
                i.putExtra("habitationCode", habitationCode);
                i.putExtra("option_Flag", option_Flag);
                i.putExtra("town_Name", town_Name);
                i.putExtra("town_code", town_code);
                i.putExtra("ward_Name", ward_Name);
                i.putExtra("ward_code", ward_code);
                startActivity(i);
                finish();
                Log.d("Database", "ServiceParameters Database Updated");
                Toast.makeText(getApplicationContext(), getString(R.string.updated_successfully), Toast.LENGTH_SHORT).show();
                Log.d("Data", "StoreData_in_DB_When_Correct : Update_success");
                return "Update_success";
            }catch (Exception e){
                e.printStackTrace();
                return "Update_failed";
            }
        }
        else {
            cursor.close();
            Log.d("Data", "StoreData_in_DB_When_Correct : Update_Failed");
            return "Update_Failed";
        }

    }

    private void fetchHKResidenceData(String gscNo)
    {

        Cursor resiCursor = hkdatabase.rawQuery("select * from "+ DataBaseHelperClass_UploadResidence_Proofs.TABLE_NAME_1+" where "
                + DataBaseHelperClass_UploadResidence_Proofs.GSCNo+"='"+gscNo+"'", null);
        if(resiCursor.getCount()>0){
            if(resiCursor.moveToFirst()) {
                do {
                    ResidenceDetails residenceData = new ResidenceDetails();
                    residenceData.setDistrictCode(resiCursor.getInt(resiCursor.getColumnIndexOrThrow(DataBaseHelperClass_UploadResidence_Proofs.HKDistrict)));
                    residenceData.setTalukCode(resiCursor.getInt(resiCursor.getColumnIndexOrThrow(DataBaseHelperClass_UploadResidence_Proofs.HKTaluk)));
                    residenceData.setHobliCode(resiCursor.getInt(resiCursor.getColumnIndexOrThrow(DataBaseHelperClass_UploadResidence_Proofs.HKHobli)));
                    residenceData.setHabitationCode(resiCursor.getInt(resiCursor.getColumnIndexOrThrow(DataBaseHelperClass_UploadResidence_Proofs.HKVillage)));
                    residenceData.setTownCode(resiCursor.getInt(resiCursor.getColumnIndexOrThrow(DataBaseHelperClass_UploadResidence_Proofs.HKTown)));
                    residenceData.setWardCode(resiCursor.getInt(resiCursor.getColumnIndexOrThrow(DataBaseHelperClass_UploadResidence_Proofs.HKWard)));
                    residenceData.setVillageName(resiCursor.getString(resiCursor.getColumnIndexOrThrow(DataBaseHelperClass_UploadResidence_Proofs.HKHabitation)));
                    residenceData.setResidingFrom(resiCursor.getString(resiCursor.getColumnIndexOrThrow(DataBaseHelperClass_UploadResidence_Proofs.HKR_FromDate)));
                    residenceData.setResidingTo(resiCursor.getString(resiCursor.getColumnIndexOrThrow(DataBaseHelperClass_UploadResidence_Proofs.HKR_ToDate)));
                    //  previousDate = resiCursor.getString(resiCursor.getColumnIndexOrThrow(DataBaseHelperClass_UploadResidence_Proofs.StayingTo));
                    residenceData.setAddr1(resiCursor.getString(resiCursor.getColumnIndexOrThrow(DataBaseHelperClass_UploadResidence_Proofs.HKR_Address)));
                    residenceData.setAddr2(resiCursor.getString(resiCursor.getColumnIndexOrThrow(DataBaseHelperClass_UploadResidence_Proofs.HKR_Address1)));
                    residenceData.setAddr3(resiCursor.getString(resiCursor.getColumnIndexOrThrow(DataBaseHelperClass_UploadResidence_Proofs.HKR_Address2)));
                    residenceData.setPincode(resiCursor.getString(resiCursor.getColumnIndexOrThrow(DataBaseHelperClass_UploadResidence_Proofs.HKR_PinCode)));
                    residenceData.setProofFile(resiCursor.getString(resiCursor.getColumnIndexOrThrow(DataBaseHelperClass_UploadResidence_Proofs.HKR_File)));
                    residenceData.setAddrProofDoc(resiCursor.getInt(resiCursor.getColumnIndexOrThrow(DataBaseHelperClass_UploadResidence_Proofs.HKR_Document_Code)));

                    residenceList.add(residenceData);

                    myAdapter.notifyDataSetChanged();
                } while (resiCursor.moveToNext());
            }
        } else {
            resiCursor.close();
        }
    }

    private void setHKRecyclerView()
    {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        residenceList = new ArrayList<>();
        myAdapter = new hk_residence_adapter(this,residenceList,new hk_residence_adapter.OnItemCheckListener() {
            @Override
            public void onItemClick(ResidenceDetails itemToDelete) {
                openHelper = new DataBaseHelperClass_UploadResidence_Proofs(RI_Field_Report_HK_Certificate.this);
                database = openHelper.getWritableDatabase();

                database.execSQL("delete from " + DataBaseHelperClass_UploadResidence_Proofs.TABLE_NAME
                        + " where " + DataBaseHelperClass_UploadResidence_Proofs.GSCNO + "='" + applicant_Id + "' and "
                        + DataBaseHelperClass_UploadResidence_Proofs.District +  "=" + itemToDelete.getDistrictCode() +" and "
                        + DataBaseHelperClass_UploadResidence_Proofs.Taluk +  "=" + itemToDelete.getTalukCode() +" and "
                        + DataBaseHelperClass_UploadResidence_Proofs.Hobli +  "=" + itemToDelete.getHobliCode() +" and "
                        + DataBaseHelperClass_UploadResidence_Proofs.Village +  "=" + itemToDelete.getHabitationCode() +" and "
                        + DataBaseHelperClass_UploadResidence_Proofs.StayingFrom +  "='" + itemToDelete.getResidingFrom() +"' and "
                        + DataBaseHelperClass_UploadResidence_Proofs.StayingTo +  "='" + itemToDelete.getResidingTo() +"' and "
                        + DataBaseHelperClass_UploadResidence_Proofs.Address1 +  "='" + itemToDelete.getAddr1() +"' and "
                        + DataBaseHelperClass_UploadResidence_Proofs.Address2 +  "='" + itemToDelete.getAddr2() +"' and "
                        + DataBaseHelperClass_UploadResidence_Proofs.Address3 +  "='" + itemToDelete.getAddr3() +"' and "
                        + DataBaseHelperClass_UploadResidence_Proofs.Pincode +  "='" + itemToDelete.getPincode() +"' and "
                        + DataBaseHelperClass_UploadResidence_Proofs.DocumentId +  "='" + itemToDelete.getAddrProofDoc() +"' and "
                        + DataBaseHelperClass_UploadResidence_Proofs.Document +  "='" + itemToDelete.getProofFile() +"'" );
                residenceList.remove(itemToDelete);
               // if(residenceList.size() ==0 )previousDate = null;
                myAdapter.notifyDataSetChanged();
            }
        });
        recyclerView.setAdapter(myAdapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void check_Kannada_Key_lang(){
        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        assert imm != null;
        ims = imm.getCurrentInputMethodSubtype();
        String locale = ims.getLocale();
        Locale locale2 = new Locale(locale);
        String currentLanguage = locale2.getDisplayLanguage();
        Log.d("lang:", "" + currentLanguage);
        if (!Objects.equals(currentLanguage, "kn_in")) {
            Toast.makeText(getApplicationContext(), getString(R.string.switch_kannada), Toast.LENGTH_SHORT).show();
            return_Value = searchPackage();
            Log.d("return_Value", "" +return_Value);
            if(!return_Value){
                Log.d("Enter", "!return_value");
                buildAlertMessage();
            }else {
                imm.showInputMethodPicker();
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void check_English_Key_lang(){
        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        assert imm != null;
        ims = imm.getCurrentInputMethodSubtype();
        String locale = ims.getLocale();
        Locale locale2 = new Locale(locale);
        String currentLanguage = locale2.getDisplayLanguage();
        String[] split_curr = currentLanguage.split("_");
        String cur_value = split_curr[0];
        Log.d("cur_value", cur_value);
        Log.d("lang:", "" + currentLanguage);
        if (TextUtils.isEmpty(cur_value)){
            cur_value = Locale.getDefault().getLanguage();
        }
        if (!Objects.equals(cur_value, "en")) {
            Toast.makeText(getApplicationContext(), getString(R.string.switch_english), Toast.LENGTH_SHORT).show();
            imm.showInputMethodPicker();
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private boolean searchPackage(){

        InputMethodInfo inputMethodInfo;
        PackageManager packageManager = getPackageManager();
        List<InputMethodInfo> str;
        str = imm.getEnabledInputMethodList();
        System.out.println(str);
        List<String> list = new ArrayList<>();

        for (int i = 0; i < str.size(); i++) {
            System.out.println(str.get(i));
            inputMethodInfo = imm.getEnabledInputMethodList().get(i);
            String str2 = inputMethodInfo.loadLabel(packageManager).toString();
            Log.d("Package_List", str2);
            list.add(str2);
        }
        Log.d("Print_List", String.valueOf(list));

        boolean get = false;

        for(String s1 : list){
            if(s1.contains("Samyojane")){
                get=true;
            }
        }
        Log.d("search", String.valueOf(get));
        return get;

    }

    private  void buildAlertMessage() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.keyboard_language))
                .setCancelable(false)
                .setPositiveButton(getString(R.string.yes), (dialog, id) -> {
                    startActivity(new Intent(Settings.ACTION_INPUT_METHOD_SETTINGS));
                    onBackPressed();
                })
                .setNegativeButton(getString(R.string.no), (dialog, id) -> buildAlert());
        final AlertDialog alert = builder.create();
        alert.show();
    }

    private  void buildAlert() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.must_change_keyboard))
                .setCancelable(false)
                .setPositiveButton(getString(R.string.ok), (dialog, id) -> {
                    startActivity(new Intent(Settings.ACTION_INPUT_METHOD_SETTINGS));
                    onBackPressed();
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }

    private  void buildAlertMessageGoingBack() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.discard_changes))
                .setCancelable(false)
                .setPositiveButton(getString(R.string.yes), (dialog, id) -> {
                    super.onBackPressed();
                    Intent i = new Intent(RI_Field_Report_HK_Certificate.this, RI_Field_Report_FirstScreen.class);
                    i.putExtra("applicant_Id", applicant_Id);
                    i.putExtra("district_Code", district_Code);
                    i.putExtra("taluk_Code", taluk_Code);
                    i.putExtra("hobli_Code", hobli_Code);
                    i.putExtra("district", district);
                    i.putExtra("taluk", taluk);
                    i.putExtra("RI_Name", RI_Name);
                    i.putExtra("VA_Name", VA_Name);
                    i.putExtra("hobli", hobli);
                    i.putExtra("va_Circle_Code", va_Circle_Code);
                    i.putExtra("VA_Circle_Name", VA_Circle_Name);
                    i.putExtra("strSearchServiceName", service_name);
                    i.putExtra("strSearchVillageName", village_name);
                    i.putExtra("serviceCode", serviceCode);
                    i.putExtra("villageCode", villageCode);
                    i.putExtra("habitationCode", habitationCode);
                    i.putExtra("option_Flag", option_Flag);
                    i.putExtra("town_Name", town_Name);
                    i.putExtra("town_code", town_code);
                    i.putExtra("ward_Name", ward_Name);
                    i.putExtra("ward_code", ward_code);
                    startActivity(i);
                    finish();
                })
                .setNegativeButton(getString(R.string.no), (dialog, id) -> dialog.cancel());
        final AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public void onBackPressed() {
        buildAlertMessageGoingBack();
    }


}
