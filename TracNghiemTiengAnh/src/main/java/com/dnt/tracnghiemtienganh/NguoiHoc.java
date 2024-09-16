/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.dnt.tracnghiemtienganh;

import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author DikamonTu
 */
public class NguoiHoc {
    Date d = java.util.Calendar.getInstance().getTime();   
    private static int dem = 0;
    private int maSo = ++dem;
    private String hoTen, queQuan, gioiTinh;
    private Date ngaySinh, ngayThamGia;
    
    
    public NguoiHoc() throws ParseException{
        System.out.print("Nhap ten nguoi hoc: ");
        this.hoTen = CauHinh.sc.nextLine();
        System.out.print("Nhap que quan: ");
        this.queQuan = CauHinh.sc.nextLine();
        System.out.print("Nhap gioi tinh: ");
        this.gioiTinh = CauHinh.sc.nextLine();
        System.out.print("Nhap ngay sinh: ");
        this.ngaySinh = CauHinh.f.parse(CauHinh.sc.nextLine());
        this.ngayThamGia = d;
    }

    public NguoiHoc(String hoTen, String queQuan, String gioiTinh, String ngaySinh) throws ParseException {
        this.hoTen = hoTen;
        this.queQuan = queQuan;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = CauHinh.f.parse(ngaySinh);        
        this.ngayThamGia = d;
    }   
    

   public void hienThi(){
       System.out.printf("%d - %s - %s - %s - %s - %s \n"
               ,this.maSo, this.hoTen, this.queQuan, this.gioiTinh, CauHinh.f.format(this.getNgaySinh()), CauHinh.f.format(this.getNgayThamGia()));
   }
    
    /**
     * @return the maSo
     */
    public int getMaSo() {
        return maSo;
    }
    
    
    
    
    /**
     * @return the hoTen
     */
    public String getHoTen() {
        return hoTen;
    }

    /**
     * @return the queQuan
     */
    public String getQueQuan() {
        return queQuan;
    }

    /**
     * @param queQuan the queQuan to set
     */
    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    /**
     * @return the gioiTinh
     */
    public String getGioiTinh() {
        return gioiTinh;
    }


    /**
     * @param aDem the dem to set
     */
    public static void setDem(int aDem) {
        dem = aDem;
    }

    /**
     * @param maSo the maSo to set
     */
    public void setMaSo(int maSo) {
        this.maSo = maSo;
    }

    /**
     * @param hoTen the hoTen to set
     */
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    /**
     * @param gioiTinh the gioiTinh to set
     */
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    /**
     * @return the ngaySinh
     */
    public Date getNgaySinh() {
        return ngaySinh;
    }

    /**
     * @param ngaySinh the ngaySinh to set
     */
    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    /**
     * @return the ngayThamGia
     */
    public Date getNgayThamGia() {
        return ngayThamGia;
    }

    /**
     * @param ngayThamGia the ngayThamGia to set
     */
    public void setNgayThamGia(Date ngayThamGia) {
        this.ngayThamGia = ngayThamGia;
    }

}
