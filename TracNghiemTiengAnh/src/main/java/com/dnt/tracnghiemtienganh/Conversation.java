/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.dnt.tracnghiemtienganh;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author DikamonTu
 */
public class Conversation extends CauHoi{
    private List<CauHoi> cauHoi = new ArrayList<>();   
    
    
    
    @Override
    public void hienThi() {
        System.out.println(this.getNoiDung());
        String t;
        for(CauHoi c :this.cauHoi){
            t = c.checkDapAn() ? "Dung" : "Sai";
            System.out.println(c.getNoiDung() + " " + t);
        }
      
    }

    @Override
    public void hienThiCauHoi() {
        System.out.println(this.getNoiDung());
        System.out.println("Muc do: " + this.getMucDo().getTenMucDo());
        for(CauHoi c: this.cauHoi){
            System.out.print(c.getNoiDung());
            System.out.print("\nCac phuong an: ");
            for(PhuongAn pa: c.getPhuongAn())
                System.out.print(pa.getNoiDung() + " ");
            System.out.println();
        }
    }
    
    
    
    /**
     * @return the cauHoi
     */
    public List<CauHoi> getCauHoi() {
        return cauHoi;
    }

    /**
     * @param cauHoi the cauHoi to set
     */
    public void setCauHoi(List<CauHoi> cauHoi) {
        this.cauHoi = cauHoi;
    }
    
}
