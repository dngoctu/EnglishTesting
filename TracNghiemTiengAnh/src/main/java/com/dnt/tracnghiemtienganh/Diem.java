/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.dnt.tracnghiemtienganh;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author DikamonTu
 */
public class Diem {
    Date d = java.util.Calendar.getInstance().getTime();   
    private NguoiHoc nguoiHoc;
    private CauHoi cauHoi;
    private double diem;
    private Date ngayLam;

    public Diem() {
        this.nguoiHoc = null;
        this.cauHoi = null;
        this.diem = 0;
        this.ngayLam = d;
    }

    public Diem(NguoiHoc nguoiHoc, CauHoi cauHoi) {
        this.nguoiHoc = nguoiHoc;
        this.cauHoi = cauHoi;
        this.ngayLam = d;

    }

    public void kiemTra() {
        if (this.cauHoi.checkDapAn()) {
            diem++;
        }
    }

    
    public int getMonth(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.ngayLam);
        return cal.get(Calendar.MONTH);
    }

    /**
     * @return the nguoiHoc
     */
    public NguoiHoc getNguoiHoc() {
        return nguoiHoc;
    }

    /**
     * @param nguoiHoc the nguoiHoc to set
     */
    public void setNguoiHoc(NguoiHoc nguoiHoc) {
        this.nguoiHoc = nguoiHoc;
    }

    /**
     * @return the cauHoi
     */
    public CauHoi getCauHoi() {
        return cauHoi;
    }

    /**
     * @param cauHoi the cauHoi to set
     */
    public void setCauHoi(CauHoi cauHoi) {
        this.cauHoi = cauHoi;
    }

    /**
     * @return the diem
     */
    public double getDiem() {
        return diem;
    }

    /**
     * @param diem the diem to set
     */
    public void setDiem(double diem) {
        this.diem = diem;
    }

    /**
     * @return the ngayLam
     */
    public Date getNgayLam() {
        return ngayLam;
    }

    /**
     * @param ngayLam the ngayLam to set
     */
    public void setNgayLam(Date ngayLam) {
        this.ngayLam = ngayLam;
    }

}
