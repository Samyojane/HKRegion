package com.nadakacheri.samyojane_app.model;

public class ResidenceDetails {
    private int DistrictCode;
    private int TalukCode;
    private String RuralOrUrban;
    private int HobliCode;
    private int HabitationCode;
    private String VillageName;
    private int TownCode;
    private int WardCode;
    private String ResidingFrom;
    private String ResidingTo;
    private String Addr1;
    private String Addr2;
    private String Addr3;
    private String Pincode;
    private int AddrProofDoc;
    private String ProofFile;
    private String GSCno;

    public String getVillageName() {
        return VillageName;
    }

    public void setVillageName(String villageName) {
        VillageName = villageName;
    }

    public int getDistrictCode() {
        return DistrictCode;
    }

    public void setDistrictCode(int districtCode) {
        DistrictCode = districtCode;
    }

    public int getTalukCode() {
        return TalukCode;
    }

    public void setTalukCode(int talukCode) {
        this.TalukCode = talukCode;
    }

    public String getRuralOrUrban() {
        return RuralOrUrban;
    }

    public void setRuralOrUrban(String ruralOrUrban) {
        RuralOrUrban = ruralOrUrban;
    }

    public int getHobliCode() {
        return HobliCode;
    }

    public void setHobliCode(int hobliCode) {
        HobliCode = hobliCode;
    }

    public int getHabitationCode() {
        return HabitationCode;
    }

    public void setHabitationCode(int habitationCode) {
        HabitationCode = habitationCode;
    }

    public int getTownCode() {
        return TownCode;
    }

    public void setTownCode(int townCode) {
        TownCode = townCode;
    }

    public int getWardCode() {
        return WardCode;
    }

    public void setWardCode(int wardCode) {
        WardCode = wardCode;
    }

    public String getResidingFrom() {
        return ResidingFrom;
    }

    public void setResidingFrom(String residingFrom) {
        ResidingFrom = residingFrom;
    }

    public String getResidingTo() {
        return ResidingTo;
    }

    public void setResidingTo(String residingTo) {
        ResidingTo = residingTo;
    }

    public String getAddr1() {
        return Addr1;
    }

    public void setAddr1(String addr1) {
        Addr1 = addr1;
    }

    public String getAddr2() {
        return Addr2;
    }

    public void setAddr2(String addr2) {
        Addr2 = addr2;
    }

    public String getAddr3() {
        return Addr3;
    }

    public void setAddr3(String addr3) {
        Addr3 = addr3;
    }

    public String getPincode() {
        return Pincode;
    }

    public void setPincode(String pincode) {
        this.Pincode = pincode;
    }

    public int getAddrProofDoc() {
        return AddrProofDoc;
    }

    public void setAddrProofDoc(int addrProofDoc) {
        this.AddrProofDoc = addrProofDoc;
    }

    public String getProofFile() {
        return ProofFile;
    }

    public void setProofFile(String proofFile) {
        this.ProofFile = proofFile;
    }

    public String getGSCno() {
        return GSCno;
    }

    public void setGSCno(String GSCno) {
        this.GSCno = GSCno;
    }
}
