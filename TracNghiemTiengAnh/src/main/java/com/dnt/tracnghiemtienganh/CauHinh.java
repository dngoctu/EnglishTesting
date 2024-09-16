/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.dnt.tracnghiemtienganh;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author DikamonTu
 */
public class CauHinh {
    public static final Scanner sc = new Scanner(System.in);
    public static final SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
    
    public static void layTenCauHoi(){
        File folder = new File("src/main/resources/");
        File[] listFolder = folder.listFiles();
        for(int i = 0; i < listFolder.length; i++){
            File file = new File("src/main/resources/" + listFolder[i].getName() + "/");
            File[] listFile = file.listFiles();
            for(int j = 0; j < listFile.length; j++){
                System.out.println(listFolder[i].getName() + " " 
                        + listFile[j].getName().substring(0, listFile[j].getName().lastIndexOf('.')));
            }
    }
    }
    
    
    
    public static List<CauHoi> docMultipleChoice() throws FileNotFoundException{
        List<CauHoi> ds = new ArrayList<>();
        PhuongAn pa = new PhuongAn();
        DanhMuc dm = new DanhMuc();
        MucDo md = new MucDo();
        MultipleChoice t = new MultipleChoice();
        File file = new File("src/main/resources/MultipleChoice/");
        File[] listFile = file.listFiles();
        for(int i = 0; i < listFile.length; i++){
            File f = new File("src/main/resources/MultipleChoice/" + listFile[i].getName());
            try(Scanner sc = new Scanner(f)){
            pa = new PhuongAn();
            dm = new DanhMuc();
            md = new MucDo();
            t = new MultipleChoice();
            t.setLoaiCauHoi("Multiple Choice");
            t.setNoiDung(sc.nextLine());
            String[] dsCacPa = sc.nextLine().split(",");
            PhuongAn[] tPa = new PhuongAn[dsCacPa.length];
            for(int j = 0; j < dsCacPa.length; j++){  
                tPa[j] = new PhuongAn();
                tPa[j].setNoiDung(dsCacPa[j]);
            }
            pa.setNoiDung(sc.nextLine());
            t.setDapAn(pa);
            dm.setTenDanhMuc(sc.nextLine());
            t.setDanhMuc(dm);
            md.setTenMucDo(sc.nextLine());
            t.setMucDo(md);
            for(int j = 0; j < dsCacPa.length; j++)
                tPa[j].setGiaiThich(sc.nextLine());
            t.setPhuongAn(tPa);
            ds.add(t);
            }
        }
    return ds;
    }
    
    public static List<CauHoi> docIncomplete() throws FileNotFoundException{
        List<CauHoi> ds = new ArrayList<>();
        CauHoi t = new Incomplete();
        MucDo md = new MucDo();
        PhuongAn pa = new PhuongAn();
        List<CauHoi> cauHoiPhu = new ArrayList<>();
        File file = new File("src/main/resources/Incomplete/");
        File[] listFile = file.listFiles();
        for(int i = 0; i < listFile.length; i++){
            cauHoiPhu = new ArrayList<>();
            File f = new File("src/main/resources/Incomplete/" + listFile[i].getName());
            try(Scanner sc = new Scanner(f)){
                md = new MucDo();
                t = new Incomplete();
                // t la mot cau hoi Incomplete
                //cauHoiPhu la cac cau hoi nho ben trong t
                t.setLoaiCauHoi("Incomplete");
                md.setTenMucDo(sc.nextLine());
                t.setMucDo(md);
                t.setNoiDung(sc.nextLine());
                while(sc.hasNext()){
                    pa = new PhuongAn();
                    CauHoi c = new Incomplete();
                    //c la cau hoi phu de add vao cauHoiPhu
                    //c tuong duong voi tung cau MultipleChoice(khong co danh muc)
                    c.setNoiDung(sc.nextLine());
                    String[] dsCacPa = sc.nextLine().split(",");
                    PhuongAn[] tPa = new PhuongAn[dsCacPa.length];
                    for(int j = 0; j < dsCacPa.length; j++){  
                        tPa[j] = new PhuongAn();
                        tPa[j].setNoiDung(dsCacPa[j]);
                    } // doc cac phuong an cua c
                    c.setPhuongAn(tPa);
                    pa.setNoiDung(sc.nextLine());
                    c.setDapAn(pa);
                    cauHoiPhu.add(c);
                }
                ((Incomplete)t).setCauHoi(cauHoiPhu);
            }
            ds.add(t);
            // mang ds la cac cau hoi t
        }
        return ds;
}
    
     
    public static List<CauHoi> docConversation() throws FileNotFoundException{
        List<CauHoi> ds = new ArrayList<>();
        Conversation t;
        MucDo md ;
        PhuongAn pa = new PhuongAn();
        List<CauHoi> cauHoiPhu = new ArrayList<>();
        File file = new File("src/main/resources/Conversation/");
        File[] listFile = file.listFiles();
        for(int i = 0; i < listFile.length; i++){
            cauHoiPhu = new ArrayList<>();
            File f = new File("src/main/resources/Conversation/" + listFile[i].getName());
            try(Scanner sc = new Scanner(f)){
                md = new MucDo();
                t = new Conversation();
                // t la mot cau hoi conversation
                //cauHoiPhu la cac cau hoi nho ben trong t
                t.setLoaiCauHoi("Conversation");
                md.setTenMucDo(sc.nextLine());
                t.setMucDo(md);
                t.setNoiDung(sc.nextLine());
                while(sc.hasNext()){
                    pa = new PhuongAn();
                    Conversation c = new Conversation();
                    //c la cau hoi phu de add vao cauHoiPhu
                    //c tuong duong voi 1 cau MultipleChoice(khong co danh muc)
                    c.setNoiDung(sc.nextLine());
                    String[] dsCacPa = sc.nextLine().split(",");
                    PhuongAn[] tPa = new PhuongAn[dsCacPa.length];
                    for(int j = 0; j < dsCacPa.length; j++){  
                        tPa[j] = new PhuongAn();
                        tPa[j].setNoiDung(dsCacPa[j]);
                    } // doc cac phuong an cua c
                    c.setPhuongAn(tPa);
                    pa.setNoiDung(sc.nextLine());
                    c.setDapAn(pa);
                    cauHoiPhu.add(c);
                }
            t.setCauHoi(cauHoiPhu);             
            }
            ds.add(t);
            // mang ds la cac cau hoi t
        }
        return ds;
    }
    
}
