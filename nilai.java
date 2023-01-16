package uas_pbo;

import java.sql.*;

// Interface
public interface nilai {
    void lihatData() throws SQLException;
	void tambahData() throws SQLException;
	void ubahData() throws SQLException;
	void hapusData();
	void cariData() throws SQLException;
}
