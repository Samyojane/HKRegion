package com.nadakacheri.samyojane_app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.nadakacheri.samyojane_app.model.ResidenceDetails;

import java.util.ArrayList;

public class hk_residence_adapter extends RecyclerView.Adapter<hk_residence_adapter.MyViewHolder> {

    Context context;
    ArrayList<ResidenceDetails> list;
    private OnItemCheckListener onItemClick;

    // constructor with Record's data model list and view context
    public hk_residence_adapter(Context context, ArrayList<ResidenceDetails> list, OnItemCheckListener onItemCheckListener) {
        this.context = context;
        this.list = list;
        this.onItemClick = onItemCheckListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        // inflate the recycler view
        // layout in its view component
        View v = LayoutInflater.from(context).inflate(R.layout.list_residence_history,parent,false);
        return new MyViewHolder(v);
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder( MyViewHolder holder, int position) {
        holder.checkBox.setChecked(false);
        holder.ivDelete.setVisibility(View.INVISIBLE);
        ResidenceDetails residenceDetails = list.get(position);
        holder.district.setText(getHKDistKanNameByCode(residenceDetails.getDistrictCode()));
        holder.taluk.setText(getHKTalukKanNameByCode(residenceDetails.getTalukCode()));
        holder.hobli.setText(getHKHobliKanNameByCode(residenceDetails.getHobliCode()));
        holder.village.setText(residenceDetails.getVillageName());
        holder.stayingFrom.setText(residenceDetails.getResidingFrom());
        holder.stayingTo.setText(residenceDetails.getResidingTo());
        holder.address1.setText(residenceDetails.getAddr1());
        holder.address2.setText(residenceDetails.getAddr2());
        holder.address3.setText(residenceDetails.getAddr3());
        holder.pincode.setText(residenceDetails.getPincode());
        holder.documentName.setText(Integer.toString(residenceDetails.getAddrProofDoc()));
       // holder.document.setText(residenceDetails.getDocument());

        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((MyViewHolder) holder).checkBox.isChecked()) {
                    holder.ivDelete.setVisibility(View.VISIBLE);
                } else {
                    holder.ivDelete.setVisibility(View.INVISIBLE);
                }
            }
        });

        holder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClick.onItemClick(residenceDetails);
            }
        });

    }

    public String getHKDistKanNameByCode(int distCode)
    {
        SqlLiteOpenHelper_Class_Kan sqlLiteOpenHelper_class_kan = new SqlLiteOpenHelper_Class_Kan(context,1);
        sqlLiteOpenHelper_class_kan.open_HKDistrict_Tbl();
        return sqlLiteOpenHelper_class_kan.Get_HKDistrictByCode(distCode);
    }
    public String getHKTalukKanNameByCode(int talukCode)
    {
        SqlLiteOpenHelper_Class_Kan sqlLiteOpenHelper_class_kan = new SqlLiteOpenHelper_Class_Kan(context,1,1);
        sqlLiteOpenHelper_class_kan.open_HK_Taluk_Tbl();
        return sqlLiteOpenHelper_class_kan.Get_HKTalukByCode(talukCode);
    }
    public String getHKHobliKanNameByCode(int hobliCode)
    {
        SqlLiteOpenHelper_Class_Kan sqlLiteOpenHelper_class_kan = new SqlLiteOpenHelper_Class_Kan(context,1,1,1);
        sqlLiteOpenHelper_class_kan.open_HK_hobli_Tbl();
        return sqlLiteOpenHelper_class_kan.Get_HKHobliByCode(hobliCode);
    }

    @Override
    public int getItemCount() {
        Log.e("inside", "size::"+list.size());
        return list.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        // data variables to link with
        // the respective id from the view
        public TextView district, taluk, hobli, village, stayingFrom, stayingTo,address1, address2;
        public TextView address3, pincode, documentName, document;
        public CheckBox checkBox;
        public ImageView ivDelete;

        public MyViewHolder(View itemView) {
            super(itemView);

            district = itemView.findViewById(R.id.td_resi_dist);
            taluk = itemView.findViewById(R.id.td_resi_taluk);
            hobli = itemView.findViewById(R.id.td_resi_Hobli);
            village = itemView.findViewById(R.id.td_resi_village);
            stayingFrom = itemView.findViewById(R.id.td_resi_stayFrom);
            stayingTo = itemView.findViewById(R.id.td_resi_stayTo);
            address1 = itemView.findViewById(R.id.td_resi_Address1);
            address2 = itemView.findViewById(R.id.td_resi_Address2);
            address3 = itemView.findViewById(R.id.td_resi_Address3);
            pincode = itemView.findViewById(R.id.td_resi_Pincode);
            documentName = itemView.findViewById(R.id.td_resi_DocName);
            document = itemView.findViewById(R.id.td_resi_Doc);
            checkBox = itemView.findViewById(R.id.td_checkbox);
            ivDelete = itemView.findViewById(R.id.iv_delete);
            checkBox.setClickable(false);


        }
        public void setOnClickListener(View.OnClickListener onClickListener) {
            itemView.setOnClickListener(onClickListener);
        }
    }
    interface OnItemCheckListener {
        void onItemClick(ResidenceDetails item);
    }
}
