/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.dnt.tracnghiemtienganh;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author DikamonTu
 */
public class QLNguoiHoc {

    /**
     * @return the ds
     */
    public List<NguoiHoc> getDs() {
        return ds;
    }

    /**
     * @param ds the ds to set
     */
    public void setDs(List<NguoiHoc> ds) {
        this.ds = ds;
    }
    private List<NguoiHoc> ds = new ArrayList<>();
    
    public void themNguoiHoc(NguoiHoc ... ng){
        this.getDs().addAll(Arrays.asList(ng));
    }
    
    public void capNhatNguoiHoc(int id){
        this.getDs().forEach(c -> {
            if(c.getMaSo() == id){
                try {
                    System.out.print("Nhap ten nguoi hoc: ");
                    c.setHoTen(CauHinh.sc.nextLine());
                    System.out.print("Nhap que quan: ");
                    c.setQueQuan(CauHinh.sc.nextLine());
                    System.out.print("Nhap ten gioi tinh: ");
                    c.setGioiTinh(CauHinh.sc.nextLine());
                    System.out.print("Nhap ten ngay sinh: ");
                    c.setNgaySinh(CauHinh.f.parse(CauHinh.sc.nextLine()));
                } catch (ParseException ex) {
                    Logger.getLogger(QLNguoiHoc.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    public NguoiHoc timBangId(int id){
        for(NguoiHoc ng: this.getDs())
            if(ng.getMaSo() == id)
                return ng;
        return null;
    }
    
    
    public void xoaNguoiHoc(int id){
        NguoiHoc xoaId = this.timBangId(id);
        this.getDs().remove(xoaId);
    }
    
    public void hienThi(){
        this.getDs().forEach(ng -> ng.hienThi());
    }
    
    
    public List<NguoiHoc> traCuuHoTen(String kw){
       return this.getDs().stream().filter(ng -> ng.getHoTen().toLowerCase().contains(kw.toLowerCase())).collect(Collectors.toList());
    }   
    public List<NguoiHoc> traCuuGioiTinh(String kw){
       return this.getDs().stream().filter(ng -> ng.getGioiTinh().toLowerCase().contains(kw.toLowerCase())).collect(Collectors.toList());
    }
    public List<NguoiHoc> traCuuNgaySinh(String kw) throws ParseException{
       Date dkw = CauHinh.f.parse(kw);
       return this.getDs().stream().filter(ng -> ng.getNgaySinh().equals(dkw)).collect(Collectors.toList());
    }
    public List<NguoiHoc> traCuuQueQuan(String kw){
       return this.getDs().stream().filter(ng -> ng.getQueQuan().toLowerCase().contains(kw.toLowerCase())).collect(Collectors.toList());
    }
    
}
