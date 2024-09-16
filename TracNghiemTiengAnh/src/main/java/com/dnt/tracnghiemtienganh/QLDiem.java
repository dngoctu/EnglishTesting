/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.dnt.tracnghiemtienganh;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DikamonTu
 */
public class QLDiem {
    private List<Diem> dsDiem = new ArrayList<>();
    
    public void themDiem(Diem d){
        this.getDsDiem().add(d);
    }
    
    public double diemMotLanKT(){
        double t = 0;
        for(int i = 0; i < this.dsDiem.size(); i++)
            t += this.dsDiem.get(i).getDiem();
        double tongDiem = (double)t / this.dsDiem.size() * 10;
        return tongDiem;
    }
    
    
    
    /**
     * @return the dsDiem
     */
    public List<Diem> getDsDiem() {
        return dsDiem;
    }

    /**
     * @param dsDiem the dsDiem to set
     */
    public void setDsDiem(List<Diem> dsDiem) {
        this.dsDiem = dsDiem;
    }
    
    
}
