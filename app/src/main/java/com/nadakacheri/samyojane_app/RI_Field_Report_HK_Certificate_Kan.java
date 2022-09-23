package com.nadakacheri.samyojane_app;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.nadakacheri.samyojane_app.api.APIInterface_NIC;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;


public class RI_Field_Report_HK_Certificate_Kan  extends AppCompatActivity {

    TextView tvHobli, tvTaluk, tvRI_Name, tvServiceName, tv_V_T_Name, txt_ReportNo;
    String RI_Name, district, taluk, hobli, VA_Circle_Name, VA_Name, applicant_Id, applicant_name;
    int district_Code, taluk_Code, hobli_Code, va_Circle_Code, villageCode, town_code, ward_code;
    String village_name, service_name;
    String serviceCode, habitationCode, town_Name, ward_Name, option_Flag;
    TextView txt_raiseLoc, title, RI_Recommendation, ApplicantID, ApplicantName, txt_add1, txt_add2, txt_add3, txt_add_Pin, AnnualIncome, ReservationGiven, Remarks;
    String appID, appName, address1, address2, address3, add_pin, appAnnualIncome, appReservationGiven, remarks;
    int appTitle_Code, binCom_Code, fatTitle_Code;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase database;
    SqlLiteOpenHelper_Class_Kan sqlLiteOpenHelper_class_kan;
    String categoryName, casteName;
    RadioGroup radioGroup2, radioGroup3;
    RadioButton radioButton2, radioButton22, radioButton3, radioButton33;
    String option2, option3;
    Spinner spCategory;
    AutoCompleteTextView autoSearchCaste;
    TableRow TableApplicantCaste, TableCasteReservation, TableApplicantCategory, TableApplicantCategory_va;
    EditText tvIncome, tvRemarks;
    int income_len, income_Value;
    String strCategory, strSearchCaste;
    int getCatCode = 0, getCasteCode = 0;
    Button btnSave, btnBack, btnDownDocs, btnViewDocs;
    String strIncome;
    GPSTracker gpsTracker;
    double latitude, longitude;
    ProgressDialog dialog;
    TextView tvVillageName, tvAppCategory, tvAppCaste, tvAnnualIncome, tvRemarksColor,txt_appFatherName;
    ;
    String strRemarks;
    int Total_No_Years_10, NO_Months_10;
    boolean return_Value;
    InputMethodManager imm;
    InputMethodSubtype ims;
    String raisedLoc, eng_certi;

    final int min = 1111;
    final int max = 9999;
    int random;
    String report_no;
    APIInterface_NIC apiInterface_nic;
    String uName_get;
    int DesiCode;
    SharedPreferences sharedPreferences;

    InputFilter filter_Eng = (source, start, end, dest, dstart, dend) -> {
        Log.d("Source", "" + source);
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

        String blockCharacterSet = num + op1 + l1 + l2 + l3 + l4 + l5 + l6 + l7 + l8 + l9 + l10 + l11 + l12 + l13 + l14 + l15 + l16 + l17 + l18 + l19 + l20
                + l21 + l22 + l23 + l24 + l25 + l26 + l27 + l28 + l29 + l30 + l31 + l32 + l33 + l34 + l35 + l36;

        for (int i = start; i < end; i++) {
            Log.d("source.charAt(i)", "" + i + " : " + source.charAt(i));
            if (blockCharacterSet.contains(("" + source.charAt(i)))) {
                Log.d("Blocked", "" + source);
                return "";
            }
        }
        Log.d("Filter_valid", "Not blocked");

        return null;
    };

    InputFilter filter_Kan = (source, start, end, dest, dstart, dend) -> {
        Log.d("Source", "" + source);
        String l1 = "abcdefghijklmnopqrstuvwxyz";
        String l2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String op1 = "~`!@#$%^&*()_-''+={}[]:/?><,.\\\"\";£€¢¥₩§|×÷¿■□♤♡◇♧°•○●☆▪¤《》¡₹Π℅®©™∆√¶1234567890೧೨೩೪೫೬೭೮೯೦";
        String blockCharacterSet = l1 + l2 + op1;

        for (int i = start; i < end; i++) {
            Log.d("source.charAt(i)", "" + i + " : " + source.charAt(i));
            if (blockCharacterSet.contains("" + source.charAt(i))) {
                Log.d("Blocked", "" + source);
                return "";
            }
        }
        Log.d("Filter_valid", "Not blocked");
        return null;
    };

    @SuppressLint("Range")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ri_field_report_hk_certificate);

        option2 = "Y";
        option3 = "Y";
        strSearchCaste = getString(R.string.select_caste_spinner);

        tvTaluk = findViewById(R.id.taluk);
        tvHobli = findViewById(R.id.hobli);
        tvRI_Name = findViewById(R.id.VA_name);
        txt_ReportNo = findViewById(R.id.txt_ReportNo);

        btnBack = findViewById(R.id.btnBack);
        txt_raiseLoc = findViewById(R.id.txt_raiseLoc);
        tvServiceName = findViewById(R.id.tvServiceName);
        title = findViewById(R.id.title);
        RI_Recommendation = findViewById(R.id.RI_Recommendation);
        tvVillageName = findViewById(R.id.tvVillageName);
        ApplicantID = findViewById(R.id.ApplicantID);
        ApplicantName = findViewById(R.id.ApplicantName);
        txt_add1 = findViewById(R.id.txt_add1);
        txt_add2 = findViewById(R.id.txt_add2);
        txt_add3 = findViewById(R.id.txt_add3);
        txt_add_Pin = findViewById(R.id.txt_add_Pin);
        AnnualIncome = findViewById(R.id.AnnualIncome);
        ReservationGiven = findViewById(R.id.ReservationGiven);
        radioGroup2 = findViewById(R.id.radioGroup2);
        radioGroup3 = findViewById(R.id.radioGroup3);
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton22 = findViewById(R.id.radioButton22);
        radioButton3 = findViewById(R.id.radioButton3);
        radioButton33 = findViewById(R.id.radioButton33);
        autoSearchCaste = findViewById(R.id.autoSearchCaste);
        spCategory = findViewById(R.id.spCategory);
        TableApplicantCaste = findViewById(R.id.TableApplicantCaste);
        TableCasteReservation = findViewById(R.id.TableCasteReservation);
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
        TableApplicantCategory = findViewById(R.id.TableApplicantCategory);
        txt_appFatherName = findViewById(R.id.txt_appFatherName);

        btnViewDocs.setVisibility(View.GONE);
        ReservationGiven.setVisibility(View.VISIBLE);
        AnnualIncome.setVisibility(View.VISIBLE);
        TableCasteReservation.setVisibility(View.VISIBLE);
        TableApplicantCaste.setVisibility(View.GONE);
        Remarks.setVisibility(View.VISIBLE);
        tvIncome.setVisibility(View.GONE);
        tvRemarks.setVisibility(View.GONE);

        Date c = Calendar.getInstance().getTime();

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy", Locale.ENGLISH);
        String formattedDate = df.format(c);

        Log.d("formattedDate", "" + formattedDate);

        random = new Random().nextInt((max - min) + 1) + min;
        Log.d("Random_Num", String.valueOf(+random));

        report_no = formattedDate + "\\" + random;
        Log.d("report_no", "" + report_no);

        Intent i = getIntent();
        district_Code = i.getIntExtra("district_Code", 0);
        district = i.getStringExtra("district");
        taluk_Code = i.getIntExtra("taluk_Code", 0);
        taluk = i.getStringExtra("taluk");
        hobli_Code = i.getIntExtra("hobli_Code", 0);
        hobli = i.getStringExtra("hobli");
        va_Circle_Code = i.getIntExtra("va_Circle_Code", 0);
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

        String strVAName = getString(R.string.shri_smt) + " " + VA_Name + ", " + getString(R.string.village_accountant);
        title.setText(strVAName);
        title.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);

        RI_Recommendation.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);

        if (eng_certi.equals("K")) {
            tvRemarks.setFilters(new InputFilter[]{filter_Kan});
        } else if (eng_certi.equals("E")) {
            tvRemarks.setFilters(new InputFilter[]{filter_Eng});
        }

        tvRemarks.setOnTouchListener((v, event) -> {
            if (Objects.equals(eng_certi, "K")) {
              //  check_Kannada_Key_lang();
            } else if (Objects.equals(eng_certi, "E")) {
              //  check_English_Key_lang();
            }
            return false;
        });

        tvTaluk.setText(taluk);
        tvHobli.setText(hobli);
        tvRI_Name.setText(RI_Name);
        tvServiceName.setText(service_name);
        txt_ReportNo.setText(report_no);

        String villageTownName;

        if (!Objects.equals(villageCode, "99999")) {
            Log.d("Data", "Rural");
            villageTownName = getString(R.string.village_name) + " : ";
            tv_V_T_Name.setText(villageTownName);
            tvVillageName.setText(village_name);
        } else if (!Objects.equals(town_code, "9999")) {
            Log.d("Data", "Urban");
            villageTownName = getString(R.string.ward_name_num) + " : ";
            tv_V_T_Name.setText(villageTownName);
            tvVillageName.setText(ward_Name);
        }

        sqlLiteOpenHelper_class_kan = new

                SqlLiteOpenHelper_Class_Kan(this);
        sqlLiteOpenHelper_class_kan.open_Cat_Caste_Tbl();

        openHelper = new

                DataBaseHelperClass_btnDownload_ServiceParameter_Tbl_RI(this);

        database = openHelper.getWritableDatabase();

        Cursor cursor = database.rawQuery("select * from " + DataBaseHelperClass_btnDownload_ServiceParameter_Tbl_RI.TABLE_NAME + " where "
                + DataBaseHelperClass_btnDownload_ServiceParameter_Tbl_RI.GSCNo + "='" + applicant_Id + "'", null);
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
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
                getCatCode = cursor.getInt(cursor.getColumnIndexOrThrow(DataBaseHelperClass_btnDownload_ServiceParameter_Tbl_RI.ReservationCategory));
                getCasteCode = cursor.getInt(cursor.getColumnIndexOrThrow(DataBaseHelperClass_btnDownload_ServiceParameter_Tbl_RI.Caste));
                appAnnualIncome = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseHelperClass_btnDownload_ServiceParameter_Tbl_RI.AnnualIncome));


                if (appAnnualIncome == null || appAnnualIncome.equals("0")) {
                    appAnnualIncome = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseHelperClass_btnDownload_ServiceParameter_Tbl_RI.Income));

                }
                appReservationGiven = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseHelperClass_btnDownload_ServiceParameter_Tbl_RI.Can_Certificate_Given));
                remarks = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseHelperClass_btnDownload_ServiceParameter_Tbl_RI.VA_Remarks));
            }
        } else {
            cursor.close();
        }

        Log.d("Eng_Certi", eng_certi);
        Log.d("Raised_Location: ", "" + raisedLoc);

        if (Objects.equals(raisedLoc, "N") || Objects.equals(raisedLoc, "S")) {
            txt_raiseLoc.setText(getString(R.string.nadakacheri_raised));
        } else if (Objects.equals(raisedLoc, "P") || Objects.equals(raisedLoc, "B") || Objects.equals(raisedLoc, "K") || Objects.equals(raisedLoc, "G") || Objects.equals(raisedLoc, "I")) {
            txt_raiseLoc.setText(getString(R.string.online));
        } else if (Objects.equals(raisedLoc, "E")) {
            txt_raiseLoc.setText(getString(R.string.seva_sindhu));
        } else if (Objects.equals(raisedLoc, "W")) {
            txt_raiseLoc.setText(getString(R.string.wallet));
        } else {
            txt_raiseLoc.setText(getString(R.string.not_specified));
        }

    }
}
