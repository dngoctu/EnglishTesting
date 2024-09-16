/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.dnt.tracnghiemtienganh;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DikamonTu
 */
public class MultipleChoice extends CauHoi {
    private DanhMuc danhMuc;


    
    @Override
    public void hienThi(){    
        System.out.println(this.getNoiDung());
        String t = this.checkDapAn() ? "Dung" : "Sai";
        System.out.println(t);
    }

    @Override
    public void hienThiCauHoi() {
        System.out.println(this.getNoiDung());
        System.out.println("Muc do: " + this.getMucDo().getTenMucDo());
        System.out.println("Danh muc: " + this.getDanhMuc().getTenDanhMuc());
        System.out.println("Cac phuong an: ");
        for(PhuongAn pa: this.getPhuongAn()){
            System.out.println(pa.getNoiDung() + " - " + pa.getGiaiThich());
        }
        
    }
    
    
    
    

    /**
     * @return the danhMuc
     */
    public DanhMuc getDanhMuc() {
        return danhMuc;
    }

    /**
     * @param danhMuc the danhMuc to set
     */
    public void setDanhMuc(DanhMuc danhMuc) {
        this.danhMuc = danhMuc;
    }

    
    
    
    
}
