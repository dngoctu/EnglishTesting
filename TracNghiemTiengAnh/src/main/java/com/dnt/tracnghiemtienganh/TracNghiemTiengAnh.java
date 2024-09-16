/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.dnt.tracnghiemtienganh;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * 
 */
public class TracNghiemTiengAnh {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws FileNotFoundException, ParseException, Exception {
       QLNguoiHoc qlnh = new QLNguoiHoc();
       QLCauHoi qlch = new QLCauHoi();
       List<Diem> dsCacDiemKT = new ArrayList<>();
       List<Diem> dsQLCauHoi = new ArrayList<>();
       
       NguoiHoc n1 = new NguoiHoc("Nguyen Van A","HCM", "Nam", "1/1/2021");
       NguoiHoc n2 = new NguoiHoc("Nguyen Van C","Vung Tau", "Nu", "22/12/2002");
       NguoiHoc n3 = new NguoiHoc("Nguyen Van B","Binh Duong", "Nu", "2/7/1998");
       NguoiHoc n4 = new NguoiHoc("Nguyen Van E","Lam Dong", "Nam", "22/2/2002");
       qlnh.themNguoiHoc(n1, n2, n3, n4);
       

       QLCauHoi qlchMultipleChoice = new QLCauHoi();
       qlchMultipleChoice.setDs(CauHinh.docMultipleChoice());
       qlchMultipleChoice.getDs().forEach(c ->qlch.themCauHoi(c));
       
       QLCauHoi qlchIncomplete = new QLCauHoi();
       qlchIncomplete.setDs(CauHinh.docIncomplete());
       qlchIncomplete.getDs().forEach(c ->qlch.themCauHoi(c));       
       
       QLCauHoi qlchConversation = new QLCauHoi();
       qlchConversation.setDs(CauHinh.docConversation());
       qlchConversation.getDs().forEach(c ->qlch.themCauHoi(c));
       
       String choose = "";
       while(!choose.equals("5")){
           System.out.println("===========");
           System.out.println("1.Quan li nguoi hoc");
           System.out.println("2.Quan li cau hoi");
           System.out.println("3.Luyen tap");
           System.out.println("4.Thong ke ket qua");
           System.out.println("5.Thoat");
           System.out.print("Nhap: ");
           choose = CauHinh.sc.nextLine();
           switch (choose) {
               case "1" -> quanLiNguoiHoc(qlnh);
               case "2" -> quanLiCauHoi(qlch);
               case "3" -> luyenTap(qlch, qlnh, dsCacDiemKT, dsQLCauHoi);
               case "4" -> thongKe(dsCacDiemKT);
           } 
       }
    }   
    
    //Ham QL nguoi hoc
    
    static void quanLiNguoiHoc(QLNguoiHoc qlnh) throws ParseException{
        System.out.println("1.Xem danh sach nguoi hoc");
        System.out.println("2.Tra cuu theo ho ten");
        System.out.println("3.Tra cuu theo gioi tinh");
        System.out.println("4.Tra cuu theo que quan");
        System.out.println("5.Tra cuu theo ngay sinh");
        System.out.println("6.Them nguoi hoc");
        System.out.println("7.Cap nhat nguoi hoc");
        System.out.println("8.Xoa nguoi hoc");
        System.out.print("Nhap: ");
        String choice = CauHinh.sc.nextLine();
        
        String temp;
        switch (choice) {
            case "1" -> qlnh.hienThi();
            case "2" -> {
                System.out.print("Nhap ho ten: ");
                String t = CauHinh.sc.nextLine();
                qlnh.traCuuHoTen(t).forEach(n ->n.hienThi());
            }
            case "3" -> {    
                System.out.print("Nhap gioi tinh: ");
                String gt = CauHinh.sc.nextLine();
                qlnh.traCuuGioiTinh(gt).forEach(n ->n.hienThi());
            }
            case "4" -> {    
                System.out.print("Nhap que quan: ");
                String qq = CauHinh.sc.nextLine();
                qlnh.traCuuQueQuan(qq).forEach(n ->n.hienThi());
            }
            case "5" -> { 
                System.out.print("Nhap ngay sinh: ");
                String ns = CauHinh.sc.nextLine();
                qlnh.traCuuNgaySinh(ns).forEach(n ->n.hienThi());
            }
            case "6" -> {   
                NguoiHoc nh = new NguoiHoc();
                qlnh.themNguoiHoc(nh);
            }
            case "7" -> {
                System.out.print("Nhap id nguoi hoc cap nhat: ");
                int idCapNhat = CauHinh.sc.nextInt();
                temp = CauHinh.sc.nextLine();
                qlnh.capNhatNguoiHoc(idCapNhat);
            }
            case "8" -> {
                System.out.print("Nhap id nguoi hoc xoa: ");
                int idXoa = CauHinh.sc.nextInt();
                temp = CauHinh.sc.nextLine();
                qlnh.xoaNguoiHoc(idXoa);
            }
        }
    }
    
    static void quanLiCauHoi(QLCauHoi qlch){
        System.out.println("1.Xem danh sach cau hoi");
        System.out.println("2.Tim cau hoi theo noi dung");
        System.out.println("3.Tim cau hoi theo danh muc");
        System.out.println("4.Tim cau hoi theo muc do");
        System.out.print("Nhap: ");
        String choice = CauHinh.sc.nextLine();
        switch (choice) {
            case "1" -> CauHinh.layTenCauHoi();
            case "2" -> {
                System.out.print("Nhap noi dung: ");
                String nd = CauHinh.sc.nextLine();
                qlch.traCuuND(nd).forEach(c -> c.hienThiCauHoi());
            }
            case "3" -> {
                System.out.print("Nhap danh muc: ");
                String dm = CauHinh.sc.nextLine();
                qlch.traCuuDanhMuc(dm).forEach(c -> c.hienThiCauHoi());
            }
            case "4" -> {
                System.out.print("Nhap muc do: ");
                String md = CauHinh.sc.nextLine();
                qlch.traCuuMucDo(md).forEach(c -> c.hienThiCauHoi());
            }
        }
        
    }
    
    static void luyenTap(QLCauHoi qlch,QLNguoiHoc qlnh, List<Diem> dsCacDiemKT, List<Diem> dsQLCauHoi) throws ParseException, Exception{
        System.out.print("Nhap id nguoi hoc muon lam BT: ");
        int id = CauHinh.sc.nextInt();
        String temp = CauHinh.sc.nextLine();
        
        NguoiHoc nguoiLam = qlnh.timBangId(id);
        if(nguoiLam == null) throw new Exception("Khong tim thay id");
        
        QLDiem qld = new QLDiem();   
        Diem diemTemp;//diem tam de luu vao danh sach diem moi lan kt
        
        System.out.println("Chon dang cau hoi ");
        System.out.println("1.Mutiple Choice");
        System.out.println("2.Incomplete");
        System.out.println("3.Conversation");
        System.out.print("Nhap: ");
        String d = CauHinh.sc.nextLine(); 
        List<CauHoi> dsCacCauHoi = new ArrayList<>();
        List<CauHoi> dsCacCauHoiHienThi = new ArrayList<>();
        switch (d) {
            case "1" -> {
                System.out.print("Nhap so cau hoi: ");
                int soCauHoi = CauHinh.sc.nextInt();
                temp = CauHinh.sc.nextLine();
                
                if(dsQLCauHoi.isEmpty()){
                    dsCacCauHoi = qlch.getDs().stream().filter(c -> 
                            c.getLoaiCauHoi().equals("Multiple Choice")).collect(Collectors.toList());
                    for(int i = 0; i < qlnh.getDs().size(); i++){
                        NguoiHoc n;
                        n = qlnh.getDs().get(i);
                        for(int j = 0; j < dsCacCauHoi.size(); j++){
                            Diem dTemp = new Diem(n, dsCacCauHoi.get(j));
                            dsQLCauHoi.add(dTemp);
                        }
                    }
                }                
                
                
                List<Diem> cauHoiConLai = dsQLCauHoi.stream().filter(chcl ->
                        chcl.getNguoiHoc().getMaSo() == nguoiLam.getMaSo()).collect(Collectors.toList());
                
                int demSoCauHoiConLai = 0;
                for(int i = 0; i < cauHoiConLai.size(); i++){
                    if(cauHoiConLai.get(i).getNguoiHoc().getMaSo() == nguoiLam.getMaSo())
                        demSoCauHoiConLai++;
                }
                if(demSoCauHoiConLai < soCauHoi) break;
                
                //Thoat neu so cau hoi khong hop le
                
                for(int i = 0; i < soCauHoi; i++){
                    int randomNum = (int) (Math.random() * cauHoiConLai.size());
                    Diem diem = new Diem(nguoiLam, cauHoiConLai.get(randomNum).getCauHoi());
                    diem.getCauHoi().hienThiCauHoi();
                    diem.getCauHoi().nhapPhuongAnTraLoi();
                    diem.kiemTra();
                    qld.themDiem(diem);
                    dsCacCauHoiHienThi.add(cauHoiConLai.get(randomNum).getCauHoi());
                    Diem diemXoa = new Diem();
                    for(int k = 0; k < cauHoiConLai.size(); k++)
                        if(cauHoiConLai.get(k).getNguoiHoc().getMaSo() == diem.getNguoiHoc().getMaSo()
                                && cauHoiConLai.get(k).getCauHoi().getNoiDung().equals(diem.getCauHoi().getNoiDung()))
                            diemXoa = cauHoiConLai.get(k);
                    cauHoiConLai.remove(diemXoa);
                    dsQLCauHoi.remove(diemXoa);           
                }
                
                for(CauHoi ch:dsCacCauHoiHienThi){
                    ch.hienThi();
                }
                
                diemTemp = new Diem();
                diemTemp.setNguoiHoc(nguoiLam);
                diemTemp.setDiem(qld.diemMotLanKT());
                dsCacDiemKT.add(diemTemp);
            }
            case "2" -> {
                System.out.print("Nhap muc do muon luyen tap: ");
                String mucDoLuyenTap = CauHinh.sc.nextLine();
                dsCacCauHoi =  qlch.getDs().stream().filter(c ->
                        c.getLoaiCauHoi().equals("Incomplete")).collect(Collectors.toList());  
                dsCacCauHoi = dsCacCauHoi.stream().filter(c ->
                        c.getMucDo().getTenMucDo().toLowerCase().equals(mucDoLuyenTap.toLowerCase())).collect(Collectors.toList());
                int randomNum = (int) (Math.random() * dsCacCauHoi.size());
                CauHoi chIncomplete = dsCacCauHoi.get(randomNum);
                double diemCauHoiPhu = 0;//la diem cua tung cau hoi trong cau Incomplete
                Diem diem = new Diem(nguoiLam, chIncomplete);
                diem.getCauHoi().hienThiCauHoi();
                for(int i = 0; i < ((Incomplete)(diem.getCauHoi())).getCauHoi().size(); i++){
                    System.out.println(((Incomplete)(diem.getCauHoi())).getCauHoi().get(i).getNoiDung());
                    //Lay noi dung cua cau hoi phu
                    ((Incomplete)(diem.getCauHoi())).getCauHoi().get(i).nhapPhuongAnTraLoi();
                    //Nhap phuong an tra loi cho cau hoi phu
                    if(((Incomplete)(diem.getCauHoi())).getCauHoi().get(i).checkDapAn()) diemCauHoiPhu++;
                    //diem cua tung cau hoi phu
                }
                diemCauHoiPhu = diemCauHoiPhu / ((Incomplete)(diem.getCauHoi())).getCauHoi().size() * 10;
                //Diem trung binh cua cau hoi phu
                diem.setDiem(diemCauHoiPhu);
                qld.themDiem(diem);
                System.out.println("*              *");
                System.out.println(chIncomplete.getNoiDung());
                ((Incomplete)chIncomplete).getCauHoi().forEach(c ->{
                    System.out.print(c.getNoiDung() + " ");
                    String check = (c.checkDapAn()) ? "Dung" : "Sai";
                    System.out.println(check);
                    
                });            
                diemTemp = new Diem();
                diemTemp.setNguoiHoc(nguoiLam);
                diemTemp.setDiem(qld.diemMotLanKT() / 10);
                dsCacDiemKT.add(diemTemp);
            }
            case "3" -> {
                System.out.print("Nhap muc do muon luyen tap: ");
                String mucDoLuyenTapConversation = CauHinh.sc.nextLine();
                
                dsCacCauHoi = qlch.getDs().stream().filter(c ->
                        c.getLoaiCauHoi().equals("Conversation")).collect(Collectors.toList());   
                dsCacCauHoi = dsCacCauHoi.stream().filter(c ->
                        c.getMucDo().getTenMucDo().toLowerCase().equals(mucDoLuyenTapConversation.toLowerCase())).collect(Collectors.toList());
                
                int randomNumConversation = (int) (Math.random() * dsCacCauHoi.size());
                CauHoi chConversation = dsCacCauHoi.get(randomNumConversation);
                
                double diemCauHoiPhuConversation = 0;//la diem cua tung cau hoi trong cau Converstation
                Diem diemConver = new Diem(nguoiLam, chConversation);
                diemConver.getCauHoi().hienThiCauHoi();
                for(int i = 0; i < ((Conversation)(diemConver.getCauHoi())).getCauHoi().size(); i++){
                    System.out.println(((Conversation)(diemConver.getCauHoi())).getCauHoi().get(i).getNoiDung());
                    //Lay noi dung cua cau hoi phu
                    ((Conversation)(diemConver.getCauHoi())).getCauHoi().get(i).nhapPhuongAnTraLoi();
                    //Nhap phuong an tra loi cho cau hoi phu
                    if(((Conversation)(diemConver.getCauHoi())).getCauHoi().get(i).checkDapAn()) diemCauHoiPhuConversation++;
                    //diem cua tung cau hoi phu
                }
                diemCauHoiPhuConversation = diemCauHoiPhuConversation / ((Conversation)(diemConver.getCauHoi())).getCauHoi().size() * 10;
                //Diem trung binh cua cac cau hoi phu
                diemConver.setDiem(diemCauHoiPhuConversation);
                qld.themDiem(diemConver);
                
                System.out.println("*              *");
                System.out.println(chConversation.getNoiDung());
                ((Conversation)chConversation).getCauHoi().forEach(c ->{
                    System.out.print(c.getNoiDung() + " ");
                    String check = (c.checkDapAn()) ? "Dung" : "Sai";
                    System.out.println(check);
                    
                });
                diemTemp = new Diem();
                diemTemp.setNguoiHoc(nguoiLam);
                diemTemp.setDiem(qld.diemMotLanKT() / 10);
                dsCacDiemKT.add(diemTemp);
            }
        }  
    }
    
    static void thongKe(List<Diem> dsCacDiemKT) throws Exception{
        System.out.print("Nhap id nguoi lam can thong ke: ");
        int id = CauHinh.sc.nextInt();
        String temp = CauHinh.sc.nextLine();
        boolean check = false;
        for(int i = 0; i < dsCacDiemKT.size(); i++)
            if(dsCacDiemKT.get(i).getNguoiHoc().getMaSo() == id) check = true;
        if(check == false) throw new Exception("Khong tim thay id");
        System.out.println("1.In so lan KT");
        System.out.println("2.In diem KT moi lan");
        System.out.println("3.Diem TB dat duoc trong thang");
        System.out.print("Nhap: ");
        String choice = CauHinh.sc.nextLine();
        
        switch (choice) {
            case "1" -> {
                int soLan = dsCacDiemKT.stream().filter(d ->d.getNguoiHoc().getMaSo() == id)
                        .collect(Collectors.toList()).size();
                System.out.println("So lan KT trong thang la: " + soLan);
            }
            case "2" -> {
                List<Diem> dkt = dsCacDiemKT.stream().filter(d ->d.getNguoiHoc().getMaSo() == id)
                        .collect(Collectors.toList());
                for(int i = 0; i < dkt.size(); i++)
                    System.out.printf("Lan " + (i + 1) + " diem dat duoc: %.2f \n", dkt.get(i).getDiem());
            }
            case "3" -> {
                System.out.print("Nhap thang thong ke: ");
                int thang = CauHinh.sc.nextInt();
                temp = CauHinh.sc.nextLine();
                double dtb = 0;
                List<Diem> dktTb = dsCacDiemKT.stream().filter(d ->d.getNguoiHoc().getMaSo() == id)
                        .collect(Collectors.toList());
                dktTb = dktTb.stream().filter(d->(d.getMonth() + 1)== thang).collect(Collectors.toList());
                for(int i = 0; i < dktTb.size(); i++)
                    dtb += dktTb.get(i).getDiem();
                dtb /= dktTb.size();
                System.out.printf("Diem trung binh trong thang la: %.2f\n" , dtb);
            }
        }
        
        
        
    }
    
}
