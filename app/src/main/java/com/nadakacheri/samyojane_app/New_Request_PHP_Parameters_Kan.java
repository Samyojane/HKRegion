package com.nadakacheri.samyojane_app;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.nadakacheri.samyojane_app.api.APIClient;
import com.nadakacheri.samyojane_app.api.APIInterface_NIC;
import com.nadakacheri.samyojane_app.model.GenLogin.LoginRequest;
import com.nadakacheri.samyojane_app.model.GenLogin.LoginResponse;
import com.nadakacheri.samyojane_app.model.GenResult.genderRequest;
import com.nadakacheri.samyojane_app.model.GenResult.genderResponse;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class New_Request_PHP_Parameters_Kan extends AppCompatActivity {

    TextView applicant_infor;
    TextView tvHobli, tvTaluk, tvVA_Name, tvServiceName;
    String district, taluk, hobli, VA_Name,VA_Circle_Name, applicant_Id, rationCardNo, aadharNo, mobileNo, address1, item_position;
    int district_Code, taluk_Code, hobli_Code, va_Circle_Code, town_code, ward_code;
    String strSearchServiceName, strSearchVillageName, strAppCategory_VA;
    String villageCode, serviceCode;
    Spinner spDistype;
    TextView tvUDID;
    ArrayAdapter<CharSequence> adapter_Distype;
    Button btnCamera, btnSave, btnBack;
    String strDis;
    EditText etDate, etUDIDNum,etCertiNum,etPercent,etRemarks;
    RadioGroup radioGroup;
    RadioButton radioButton1;
    RadioButton radioButton2;

    String option;
    SqlLiteOpenHelper_Class sqlLiteOpenHelper_class;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase database;

    private static final int CAMERA_REQUEST = 1;
    byte[] imageInByte;
    static String store;
    static String getString=null;
    ImageView imageView;

    GPSTracker gpsTracker;
    double latitude, longitude;
    AppCompatActivity activity;
    String strPercent, strUDIDNum, strCertiNum, strDate, strRemarks;
    ProgressDialog dialog;
    String str, returnStr;
    String service_name, village_name, town_Name, ward_Name, option_Flag;
    String eng_certi,gender;
    String appImage=null;
    boolean return_Value;
    InputMethodManager imm;
    InputMethodSubtype ims;
    private APIInterface_NIC apiInterface_nic;


    InputFilter filter_Eng = (source, start, end, dest, dstart, dend) -> {
        Log.d("Source",""+source);
        String l1 = "???????????????????????????????????????????????????";
        String l2 = "?????????????????????????????????????????????????????????????????????????????????????????????";
        String l3 = "?????????????????????????????????????????????????????????????????????????????????????????????";
        String l4 = "?????????????????????????????????????????????????????????????????????????????????????????????";
        String l5 = "?????????????????????????????????????????????????????????????????????????????????????????????";
        String l6 = "?????????????????????????????????????????????????????????????????????????????????????????????";
        String l7 = "?????????????????????????????????????????????????????????????????????????????????????????????";
        String l8 = "?????????????????????????????????????????????????????????????????????????????????????????????";
        String l9 = "?????????????????????????????????????????????????????????????????????????????????????????????";
        String l10 = "?????????????????????????????????????????????????????????????????????????????????????????????";
        String l11 = "?????????????????????????????????????????????????????????????????????????????????????????????";
        String l12 = "?????????????????????????????????????????????????????????????????????????????????????????????";
        String l13 = "?????????????????????????????????????????????????????????????????????????????????????????????";
        String l14 = "?????????????????????????????????????????????????????????????????????????????????????????????";
        String l15 = "?????????????????????????????????????????????????????????????????????????????????????????????";
        String l16 = "?????????????????????????????????????????????????????????????????????????????????????????????";
        String l17 = "?????????????????????????????????????????????????????????????????????????????????????????????";
        String l18 = "?????????????????????????????????????????????????????????????????????????????????????????????";
        String l19 = "?????????????????????????????????????????????????????????????????????????????????????????????";
        String l20 = "?????????????????????????????????????????????????????????????????????????????????????????????";
        String l21 = "?????????????????????????????????????????????????????????????????????????????????????????????";
        String l22 = "?????????????????????????????????????????????????????????????????????????????????????????????";
        String l23 = "?????????????????????????????????????????????????????????????????????????????????????????????";
        String l24 = "?????????????????????????????????????????????????????????????????????????????????????????????";
        String l25 = "?????????????????????????????????????????????????????????????????????????????????????????????";
        String l26 = "?????????????????????????????????????????????????????????????????????????????????????????????";
        String l27 = "?????????????????????????????????????????????????????????????????????????????????????????????";
        String l28 = "?????????????????????????????????????????????????????????????????????????????????????????????";
        String l29 = "?????????????????????????????????????????????????????????????????????????????????????????????";
        String l30 = "?????????????????????????????????????????????????????????????????????????????????????????????";
        String l31 = "?????????????????????????????????????????????????????????????????????????????????????????????";
        String l32 = "?????????????????????????????????????????????????????????????????????????????????????????????";
        String l33 = "?????????????????????????????????????????????????????????????????????????????????????????????";
        String l34 = "?????????????????????????????????????????????????????????????????????????????????????????????";
        String l35 = "?????????????????????????????????????????????????????????????????????????????????????????????";
        String l36 = "?????????????????????????????????????????????????????????????????????????????????????????????";
        String l37 = "?????????????????????????????????????????????????????????????????????????????????????????????";
        String op1 = "~`!@#$%^&*()_-''+={}[]:/?><,.\\\"\";??????????????|??????????????????????????????????????????????????????????????????????????1234567890??????????????????????????????";

        String blockCharacterSet = l1+l2+l3+l4+l5+l6+l7+l8+l9+l10+l11+l12+l13+l14+l15+l16+l17+l18+l19+l20
                +l21+l22+l23+l24+l25+l26+l27+l28+l29+l30+l31+l32+l33+l34+l35+l36+l37+op1;
        if (source != null && blockCharacterSet.contains(("" + source))) {
            Log.d("Blocked",""+source);
            return "";
        }
//        for ( int i = start ; i < end ; i++) {
//            String checkMe = String. valueOf (source.charAt(i));
//            //Pattern pattern = Pattern.compile("[\\u0C80-\\u0CFF]");
//            Pattern pattern = Pattern.compile("a-zA-Z");
//            Matcher re = pattern.matcher(checkMe);
//            if (!re.matches()) {
//                Log.d("Filter_valid","blocked");
//                return "";
//            }
//        }
        Log.d("Filter_valid","Not blocked");
        return null;
    };

    InputFilter filter_Kan = (source, start, end, dest, dstart, dend) -> {
        Log.d("Source",""+source);
        String l1 = "abcdefghijklmnopqrstuvwxyz";
        String l2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String op1 = "~`!@#$%^&*()_-''+={}[]:/?><,.\\\"\";??????????????|??????????????????????????????????????????????????????????????????????????1234567890??????????????????????????????";
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

    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @SuppressLint({"ClickableViewAccessibility", "HardwareIds"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_request_php_parameters);

        option = "Y";

        tvTaluk = findViewById(R.id.taluk);
        tvHobli = findViewById(R.id.hobli);
        tvVA_Name = findViewById(R.id.VA_name);
        tvServiceName = findViewById(R.id.tvServiceName);

        etDate = findViewById(R.id.etDate);
        btnCamera = findViewById(R.id.btnCamera);
        btnSave = findViewById(R.id.btnSave);
        imageView = findViewById(R.id.store_image);
        btnBack = findViewById(R.id.btnBack);
        radioGroup = findViewById(R.id.radioGroup);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        etPercent= findViewById(R.id.etPercentage);
        etRemarks = findViewById(R.id.etRemarks);
        spDistype = findViewById(R.id.spDistype);
        tvUDID = findViewById(R.id.tvUDID);
        etUDIDNum = findViewById(R.id.etUDIDNum);
        etCertiNum = findViewById(R.id.etCertiNum);

        applicant_infor= findViewById(R.id.applicant_Information);
        applicant_infor.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);

        Intent i = getIntent();
        district = i.getStringExtra("district");
        taluk = i.getStringExtra("taluk");
        district_Code = i.getIntExtra("district_Code", 0);
        taluk_Code = i.getIntExtra("taluk_Code", 0);
        hobli_Code = i.getIntExtra("hobli_Code", 0);
        hobli = i.getStringExtra("hobli");
        va_Circle_Code = i.getIntExtra("va_Circle_Code", 0);
        VA_Circle_Name = i.getStringExtra("VA_Circle_Name");
        applicant_Id = i.getStringExtra("applicant_Id");
        VA_Name = i.getStringExtra("VA_Name");
        rationCardNo = i.getStringExtra("rationCardNo");
        aadharNo = i.getStringExtra("aadharNo");
        mobileNo = i.getStringExtra("mobileNo");
        address1 = i.getStringExtra("address1");
        item_position = i.getStringExtra("item_position");
        strSearchVillageName = i.getStringExtra("strSearchVillageName");
        strSearchServiceName =i.getStringExtra("strSearchServiceName");
        villageCode = i.getStringExtra("villageCode");
        serviceCode = i.getStringExtra("serviceCode");
        service_name = i.getStringExtra("strSearchServiceName");
        village_name = i.getStringExtra("strSearchVillageName");
        eng_certi = i.getStringExtra("eng_certi");
        town_code = i.getIntExtra("town_code", 0);
        town_Name = i.getStringExtra("town_Name");
        ward_code = i.getIntExtra("ward_code", 0);
        ward_Name = i.getStringExtra("ward_Name");
        option_Flag = i.getStringExtra("option_Flag");

        Log.d("New_Request_Sec_Con..", ""+district_Code);
        Log.d("New_Request_Sec_Con..", ""+taluk_Code);
        Log.d("New_Request_Sec_Con..", ""+hobli_Code);
        Log.d("New_Request_Sec_Con..", ""+va_Circle_Code);
        Log.d("Item_Position", ""+item_position);
        Log.d("Village_NameCasteIncome", ""+village_name);
        Log.d("Service_NameCasteIncome", ""+service_name);
        Log.d("villageCodeCasteIncome", ""+villageCode);
        Log.d("serviceCodeCasteIncome", ""+serviceCode);
        Log.d("eng_certi",""+ eng_certi);
        Log.d( "town_code: ",""+town_code);
        Log.d("town_Name: ",""+town_Name);
        Log.d( "ward_code: ",""+ward_code);
        Log.d( "ward_Name: ",""+ward_Name);
        Log.d("option_Flag: ",""+ option_Flag);

        dialog = new ProgressDialog(this, R.style.CustomDialog);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage(getString(R.string.loading));
        dialog.setIndeterminate(true);
        dialog.setProgress(1);

        if (eng_certi.equals("K")){
            etRemarks.setFilters(new InputFilter[] { filter_Kan });
        }else if (eng_certi.equals("E")){
            etRemarks.setFilters(new InputFilter[] { filter_Eng });
        }

        etDate.setFocusable(false);
        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog(etDate);
            }
        });

        tvTaluk.setText(taluk);
        tvHobli.setText(hobli);
        tvVA_Name.setText(VA_Name);
        tvServiceName.setText(strSearchServiceName);

        adapter_Distype = ArrayAdapter.createFromResource(this, R.array.spinnerDisability, R.layout.spinner_item_color);
        adapter_Distype.setDropDownViewResource(R.layout.spinner_item_dropdown);
        spDistype.setAdapter(adapter_Distype);

        spDistype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                strDis = String.valueOf(spDistype.getSelectedItem());
                Log.d("Spinner_Value", ""+ strDis);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            // find which radio button is selected
            if (checkedId == R.id.radioButton1) {
                //Toast.makeText(getApplicationContext(), "choice: male", Toast.LENGTH_SHORT).show();
                option = "Y";
            } else if (checkedId == R.id.radioButton2) {
                option = "N";
                //Toast.makeText(getApplicationContext(), "choice: Female", Toast.LENGTH_SHORT).show();
            }
            Log.d("option", ""+option);
        });

        gpsTracker = new GPSTracker(getApplicationContext(), this);

        if (gpsTracker.canGetLocation()) {
            latitude = gpsTracker.getLatitude();
            longitude = gpsTracker.getLongitude();
            Log.d("Location", ""+latitude+""+longitude);
        } else {
            //gpsTracker.showSettingsAlert();
            Toast.makeText(getApplicationContext(), getString(R.string.switch_on_gps), Toast.LENGTH_SHORT).show();
        }

        btnCamera.setOnClickListener(v -> {
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent, CAMERA_REQUEST);
        });

        btnSave.setOnClickListener(v -> {
            try {
                if (gpsTracker.canGetLocation()) {
                    latitude = gpsTracker.getLatitude();
                    longitude = gpsTracker.getLongitude();
                    Log.d("Location", "" + latitude + "" + longitude);
                } else {
                    //gpsTracker.showSettingsAlert();
                    Toast.makeText(getApplicationContext(), getString(R.string.switch_on_gps), Toast.LENGTH_SHORT).show();
                }

                strPercent = etPercent.getText().toString().trim();
                strUDIDNum = etUDIDNum.getText().toString().trim();
                strCertiNum = etCertiNum.getText().toString().trim();
                strDate = etDate.getText().toString().trim();
                strRemarks = etRemarks.getText().toString().trim();

                if (latitude != 0.0 && longitude != 0.0) {
                    if (!spDistype.equals(getString(R.string.select_spinner))){
                        if(!TextUtils.isEmpty(strPercent)){
                            if(!TextUtils.isEmpty(strUDIDNum)){
                                if(!TextUtils.isEmpty(strCertiNum)){
                                    if(!TextUtils.isEmpty(strDate)){
                                        if(TextUtils.isEmpty(strRemarks)){
                                            etRemarks.setError(getString(R.string.field_canno_null));
                                        }else{
                                            StoreData_in_DB();
                                        }
                                    }else{
                                        etDate.setError(getString(R.string.field_canno_null));
                                    }
                                }else{
                                    etCertiNum.setError(getString(R.string.field_canno_null));
                                }
                            }else{
                                etUDIDNum.setError(getString(R.string.field_canno_null));
                            }
                    }else{
                            etPercent.setError(getString(R.string.field_canno_null));
                        }
                    }else{
                        ((TextView) spDistype.getSelectedView()).setError(getString(R.string.select_spinner));
                        Toast.makeText(getApplicationContext(), getString(R.string.select_spinner), Toast.LENGTH_SHORT).show();
                    }
                }else {
                    runOnUiThread(() -> {

                        AlertDialog.Builder dialog = new AlertDialog.Builder(New_Request_PHP_Parameters_Kan.this);
                        dialog.setCancelable(false);
                        dialog.setTitle(getString(R.string.alert));
                        dialog.setMessage(getString(R.string.cannot_get_location));
                        dialog.setNegativeButton(getString(R.string.ok), (dialog1, which) -> {
                            //Action for "Cancel".
                            dialog1.cancel();
                        });

                        final AlertDialog alert = dialog.create();
                        alert.show();
                    });
                    //Toast.makeText(getApplicationContext(), "Please Switch on the GPS", Toast.LENGTH_SHORT).show();
                }
            }catch (Exception e){
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "Exception : "+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        btnBack.setOnClickListener(v -> onBackPressed());
    }


    private void showDateDialog(final EditText etDate) {
        final Calendar calendar=Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy", Locale.US);
                etDate.setText(simpleDateFormat.format(calendar.getTime()));

            }
        };

        new DatePickerDialog(New_Request_PHP_Parameters_Kan.this,dateSetListener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
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

    public void truncateDatabase_Docs(){
        //dialog1.setProgress(20);
        openHelper = new DataBaseHelperClass_btnDownload_Docs(New_Request_PHP_Parameters_Kan.this);
        database = openHelper.getWritableDatabase();

        Cursor cursor = database.rawQuery("select * from "+ DataBaseHelperClass_btnDownload_Docs.TABLE_NAME, null);
        if(cursor.getCount()>0) {
            database.execSQL("Delete from " + DataBaseHelperClass_btnDownload_Docs.TABLE_NAME);
            Log.d("Database", "Down_Docs Database Truncated");
        } else {
            cursor.close();
        }
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

    private void buildAlert() {
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


    public String StoreData_in_DB(){
        String str;
        dialog.show();
        btnCamera.setError(null);

        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.ENGLISH);
        String currDate = dateFormat.format(date);


        openHelper = new DataBaseHelperClass_btnDownload_ServiceTranTable(New_Request_PHP_Parameters_Kan.this);
        database = openHelper.getWritableDatabase();

        Cursor cursor = database.rawQuery("select * from " + DataBaseHelperClass_btnDownload_ServiceTranTable.TABLE_NAME_1 + " where "
                + DataBaseHelperClass_btnDownload_ServiceTranTable.UPD_GSCNo + "='" + applicant_Id + "'", null);
        if (cursor.getCount() > 0) {
            try {
                database.execSQL("update " + DataBaseHelperClass_btnDownload_ServiceTranTable.TABLE_NAME + " set "
                        + DataBaseHelperClass_btnDownload_ServiceTranTable.DataUpdateFlag + "=1 where "
                        + DataBaseHelperClass_btnDownload_ServiceTranTable.GSCNo + "='" + applicant_Id + "'");

                database.execSQL("update " + DataBaseHelperClass_btnDownload_ServiceTranTable.TABLE_NAME_1 + " set "

//                        + DataBaseHelperClass_btnDownload_ServiceTranTable.UPD_App_Reside_In_Karnataka + "=" + option1 + "',"
//                        + DataBaseHelperClass_btnDownload_ServiceTranTable.UPD_Attested_Address + "='" + option2 + "',"
                       + DataBaseHelperClass_btnDownload_ServiceTranTable.UPD_Photo + "='" + store + "',"
                        + DataBaseHelperClass_btnDownload_ServiceTranTable.UPD_vLat + "=" + latitude + ","
                        + DataBaseHelperClass_btnDownload_ServiceTranTable.UPD_vLong + "=" + longitude + ","
                        + DataBaseHelperClass_btnDownload_ServiceTranTable.UPD_Can_Certificate_Given + "='" + option + "',"
                        + DataBaseHelperClass_btnDownload_ServiceTranTable.UPD_Remarks + "='" + strRemarks + "',"
                        + DataBaseHelperClass_btnDownload_ServiceTranTable.UPD_ReportDate + "='" + currDate + "',"
                        + DataBaseHelperClass_btnDownload_ServiceTranTable.UPD_DataUpdateFlag + "=1" + " where "
                        + DataBaseHelperClass_btnDownload_ServiceTranTable.UPD_GSCNo + "='" + applicant_Id + "'");

                Log.d("Database", "ServiceParameters Database Updated");
                Toast.makeText(getApplicationContext(), getString(R.string.updated_successfully), Toast.LENGTH_SHORT).show();

                Intent i = new Intent(New_Request_PHP_Parameters_Kan.this, New_Request_FirstScreen.class);
                i.putExtra("applicant_Id", applicant_Id);
                i.putExtra("district_Code", district_Code);
                i.putExtra("taluk_Code", taluk_Code);
                i.putExtra("hobli_Code", hobli_Code);
                i.putExtra("district", district);
                i.putExtra("taluk", taluk);
                i.putExtra("VA_Name", VA_Name);
                i.putExtra("hobli", hobli);
                i.putExtra("va_Circle_Code", va_Circle_Code);
                i.putExtra("VA_Circle_Name", VA_Circle_Name);
                i.putExtra("strSearchServiceName", service_name);
                i.putExtra("strSearchVillageName", village_name);
                i.putExtra("serviceCode", serviceCode);
                i.putExtra("villageCode", String.valueOf(villageCode));
                i.putExtra("option_Flag", option_Flag);
                i.putExtra("town_Name", town_Name);
                i.putExtra("town_code", town_code);
                i.putExtra("ward_Name", ward_Name);
                i.putExtra("ward_code", ward_code);
                startActivity(i);
                finish();
                dialog.dismiss();
                truncateDatabase_Docs();
                str = "Success";
            } catch (Exception e){
                e.printStackTrace();
                str="Failure";
            }
        } else {
            cursor.close();
            dialog.dismiss();
            truncateDatabase_Docs();
            str="Failure";
            Toast.makeText(getApplicationContext(), getString(R.string.could_not_save_the_data_please_try_again), Toast.LENGTH_SHORT).show();
        }
        return str;
    }

    private  void buildAlertMessageGoingBack() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.discard_changes))
                .setCancelable(false)
                .setPositiveButton(getString(R.string.yes), (dialog, id) -> {
                    New_Request_PHP_Parameters_Kan.super.onBackPressed();
                    Intent i = new Intent(New_Request_PHP_Parameters_Kan.this, New_Request_FirstScreen.class);
                    i.putExtra("applicant_Id", applicant_Id);
                    i.putExtra("district_Code", district_Code);
                    i.putExtra("taluk_Code", taluk_Code);
                    i.putExtra("hobli_Code", hobli_Code);
                    i.putExtra("district", district);
                    i.putExtra("taluk", taluk);
                    i.putExtra("VA_Name", VA_Name);
                    i.putExtra("hobli", hobli);
                    i.putExtra("va_Circle_Code", va_Circle_Code);
                    i.putExtra("VA_Circle_Name", VA_Circle_Name);
                    i.putExtra("strSearchServiceName", service_name);
                    i.putExtra("strSearchVillageName", village_name);
                    i.putExtra("serviceCode", serviceCode);
                    i.putExtra("villageCode", String.valueOf(villageCode));
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


    @SuppressLint({"LongLogTag", "SetTextI18n"})
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK)
            return;

        if (requestCode == CAMERA_REQUEST) {
            Bundle extras = data.getExtras();

            if (extras != null) {
                Bitmap yourImage = extras.getParcelable("data");
                // convert bitmap to byte
                ByteArrayOutputStream stream = new ByteArrayOutputStream();//The ByteArrayOutputStream class stream creates a buffer in memory and all the data sent to the stream is stored in the buffer.
                assert yourImage != null;
                yourImage.compress(Bitmap.CompressFormat.PNG, 100, stream);//Specifies the known formats a bitmap can be compressed into 1.JPEG 2.PNG 3.WEBP
                imageInByte = stream.toByteArray();
                getString = Base64.encodeToString(imageInByte, Base64.DEFAULT);
                GetAuthGenderAPI(getString);

                //Log.e("output before conversion", Arrays.toString(imageInByte));
                store = getString;
                imageView.setVisibility(View.VISIBLE);
                imageView.setImageBitmap(yourImage);
                btnCamera.setError(null);
                Log.d("Image in bytes", "Image Captured");
            }
        }
    }
    public void GetAuthGenderAPI(String photo)
    {
        apiInterface_nic = APIClient.getClient("http://genage_api.kar.nic.in/api/").create(APIInterface_NIC.class);

        Call<LoginResponse> call = apiInterface_nic.getAuthentication(prepareLoginBody());
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    try{
                        GetGenderDetAPI("Bearer "+response.body().getAccess(), photo);
                    } catch (OutOfMemoryError e) {
                        e.printStackTrace();
                        Log.e("OutOfMemoryError", "" + e.toString());
                        runOnUiThread(() -> {
                            Toast.makeText(getApplicationContext(), getString(R.string.server_exception), Toast.LENGTH_SHORT).show();
                        });
                    } catch (NullPointerException e) {
                        Log.e("NullPointerException", "" + e.toString());
                        runOnUiThread(() -> {
                            Toast.makeText(getApplicationContext(), getString(R.string.server_exception), Toast.LENGTH_SHORT).show();
                        });
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "" + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.d("multipleResource",""+t.getMessage());
                call.cancel();
                t.printStackTrace();
                Toast.makeText(getApplicationContext(), ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public LoginRequest prepareLoginBody()
    {
        LoginRequest logReq = new LoginRequest(getString(R.string.gender_username),getString(R.string.gender_password));
        return logReq;
    }
    public void GetGenderDetAPI(String access_token, String photo)
    {
        apiInterface_nic = APIClient.getClient("http://genage_api.kar.nic.in/api/").create(APIInterface_NIC.class);

        Call<genderResponse> call = apiInterface_nic.getGender(access_token,prepareBody(photo));
        call.enqueue(new Callback<genderResponse>() {
            @Override
            public void onResponse(Call<genderResponse> call, Response<genderResponse> response) {
                if (response.isSuccessful()) {
                    try{
                        Log.e("isSucc::", "" + response.body().getResults());
                        gender = response.body().getResults().get(0).getGender();
                        runOnUiThread(() -> {
                            Toast.makeText(getApplicationContext(), "Gender:"+response.body().getResults().get(0).getGender(), Toast.LENGTH_SHORT).show();
                        });
                    } catch (OutOfMemoryError e) {
                        e.printStackTrace();
                        Log.e("OutOfMemoryError", "" + e.toString());
                        runOnUiThread(() -> {
                            Toast.makeText(getApplicationContext(), getString(R.string.server_exception), Toast.LENGTH_SHORT).show();
                        });
                    } catch (NullPointerException e) {
                        Log.e("NullPointerException", "" + e.toString());
                        runOnUiThread(() -> {
                            Toast.makeText(getApplicationContext(), getString(R.string.server_exception), Toast.LENGTH_SHORT).show();
                        });
                    }
                } else {
                    Log.e("isSucc::", "::" + response.body().getResults());
                    Toast.makeText(getApplicationContext(), "" + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<genderResponse> call, Throwable t) {
                Log.d("multipleResource",""+t.getMessage());
                call.cancel();
                t.printStackTrace();
                if(t.getMessage().contains("java.lang.IllegalStateException")){
                    Toast.makeText(getApplicationContext(), "Person not found", Toast.LENGTH_SHORT).show();
                }else Toast.makeText(getApplicationContext(), ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public genderRequest prepareBody(String bitmap)
    {
        genderRequest genReq = new  genderRequest(bitmap);
        return genReq;
    }

    @Override
    public void onBackPressed() { buildAlertMessageGoingBack();
    }
}