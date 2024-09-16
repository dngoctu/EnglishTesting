/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.dnt.tracnghiemtienganh;

import java.io.File;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author DikamonTu
 */
public class QLCauHoi {
    private List<CauHoi> ds = new ArrayList<>(); 
    
    
    public void xemDs(){
        this.ds.forEach(c -> System.out.println(c.getNoiDung()));          
    }
    
    public void hienThiCauHoi(){
        this.ds.forEach(c -> c.hienThiCauHoi());
    }
    
    
    public List<CauHoi> traCuuND(String kw){
       return this.getDs().stream().filter(c -> c.getNoiDung().contains(kw)).collect(Collectors.toList());
    }
    
    public List<CauHoi> traCuuDanhMuc(String kw){
       List<CauHoi> ql = new ArrayList<>();
       this.ds.forEach(c ->{
           if(c instanceof MultipleChoice)
               ql.add(c);
       });
       return ql.stream().filter(c -> ((MultipleChoice)c).getDanhMuc().getTenDanhMuc().toLowerCase().equals(kw.toLowerCase())).collect(Collectors.toList());
}
    
    public List<CauHoi> traCuuMucDo(String kw){
       return this.ds.stream().filter(c -> c.getMucDo().getTenMucDo().toLowerCase().equals(kw.toLowerCase())).collect(Collectors.toList());
    }
    
    public void themCauHoi(CauHoi c){
        this.getDs().add(c);
    }

    /**
     * @return the ds
     */
    public List<CauHoi> getDs() {
        return ds;
    }

    /**
     * @param ds the ds to set
     */
    public void setDs(List<CauHoi> ds) {
        this.ds = ds;
    }
 
}
