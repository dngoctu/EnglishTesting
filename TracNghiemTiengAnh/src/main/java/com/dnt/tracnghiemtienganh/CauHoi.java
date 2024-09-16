/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.dnt.tracnghiemtienganh;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author DikamonTu
 */
public abstract class CauHoi {

    private String noiDung;
    private PhuongAn[] phuongAn;
    private MucDo mucDo;
    private PhuongAn dapAn;
    private String cauTraLoi;
    private String loaiCauHoi;
    
    
    public void nhapPhuongAnTraLoi(){
        System.out.print("Nhap phuong an tra loi: ");
        this.setCauTraLoi(CauHinh.sc.nextLine());
    }
    
    public boolean checkDapAn(){
        return this.getCauTraLoi().toLowerCase().equals(this.dapAn.getNoiDung().toLowerCase());       
    }
        
    public abstract void hienThiCauHoi();
    
    public abstract void hienThi();
    /**
     * @return the noiDung
     */
    
    public String getNoiDung() {
        return noiDung;
    }

    /**
     * @param noiDung the noiDung to set
     */
    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    /**
     * @return the phuongAn
     */
    public PhuongAn[] getPhuongAn() {
        return phuongAn;
    }

    /**
     * @param phuongAn the phuongAn to set
     */
    public void setPhuongAn(PhuongAn[] phuongAn) {
        this.phuongAn = phuongAn;
    }

    /**
     * @return the dapAn
     */
    public PhuongAn getDapAn() {
        return dapAn;
    }

    /**
     * @param dapAn the dapAn to set
     */
    public void setDapAn(PhuongAn dapAn) {
        this.dapAn = dapAn;
    }

    /**
     * @return the cauTraLoi
     */
    public String getCauTraLoi() {
        return cauTraLoi;
    }

    /**
     * @param cauTraLoi the cauTraLoi to set
     */
    public void setCauTraLoi(String cauTraLoi) {
        this.cauTraLoi = cauTraLoi;
    }

    /**
     * @return the mucDo
     */
    public MucDo getMucDo() {
        return mucDo;
    }

    /**
     * @param mucDo the mucDo to set
     */
    public void setMucDo(MucDo mucDo) {
        this.mucDo = mucDo;
    }

    /**
     * @return the loaiCauHoi
     */
    public String getLoaiCauHoi() {
        return loaiCauHoi;
    }

    /**
     * @param loaiCauHoi the loaiCauHoi to set
     */
    public void setLoaiCauHoi(String loaiCauHoi) {
        this.loaiCauHoi = loaiCauHoi;
    }
   
    
   
}
