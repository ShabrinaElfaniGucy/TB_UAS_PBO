package uas_pbo;

import java.util.LinkedList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Date;

import com.mysql.cj.protocol.Resultset;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;

//class
public class compile {

    static Connection conn;
	
    public static void main(String[] args) {
    	// Pemanggilan Constructor
    	data_diri shabrina = new data_diri();
        System.out.println("Nama \t: " + shabrina.nama);
        System.out.println("NIM \t: " + shabrina.nim);
        System.out.println("Tugas \t: " + shabrina.tugas);
    	
        // Collection Framework (LinkedList)
        LinkedList<String> List = new LinkedList<String>();
        List.add("Teknologi Informasi");
        List.add("Sistem Informasi");
        System.out.println("\nFakultas dan Jurusan : " + List);
        
    	Scanner terimaInput = new Scanner (System.in);
    	String pilihanUser;
    	boolean isLanjutkan = true;
    	
    	// Pengolahan Database (CRUD)
    	String url = "jdbc:mysql://localhost:3306/db_nilaiii";
		try {
			Class.forName( "com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,"root","");
			System.out.println("\nClass Driver ditemukan");
			mahasiswa Mahasiswa = new mahasiswa();
			
			// Label keluar
			keluar:
			// Perulangan
			while (isLanjutkan) {
				System.out.println("------------------------");
				System.out.println("Database Data Mahasiswa");
				System.out.println("------------------------");
				System.out.println("1. Lihat Data Mahasiswa");
				System.out.println("2. Tambah Data Mahasiswa");
				System.out.println("3. Ubah Data Mahasiswa");
				System.out.println("4. Hapus Data Mahasiswa");
				System.out.println("5. Cari Data Mahasiswa");
				System.out.println("6. Keluar Program");
				
				System.out.print("\nPilihan anda (1/2/3/4/5/6): ");
				pilihanUser = terimaInput.next();
				
				// Percabangan
				switch (pilihanUser) {
				case "1":
					Mahasiswa.lihatData();
					break;
				case "2":
					Mahasiswa.tambahData();
					break;
				case "3":
					Mahasiswa.ubahData();
					break;
				case "4":
					Mahasiswa.hapusData();
					break;
				case "5":
					Mahasiswa.cariData();
					break;
				case "6":
					// Pergi ke label keluar
					break keluar;
				default:
					System.err.println("\nInput anda tidak ditemukan\nSilakan pilih [1-6]");
				}
				
				System.out.print("\nApakah Anda ingin melanjutkan [y/n]? ");
				pilihanUser = terimaInput.next();
				isLanjutkan = pilihanUser.equalsIgnoreCase("y");

			}
			// Method Date
	        Date date = new Date();
	        String str = String.format("\nTanggal/Waktu sekarang: %tc", date);
	        System.out.println(str);
			System.out.println("Program selesai...");
			
		}
		// Exception
		catch(ClassNotFoundException ex) {
			System.err.println("Driver Error");
			System.exit(0);
		}
		// Exception
		catch(SQLException e){
			System.err.println("Tidak berhasil koneksi");
		}
    }
    
}
