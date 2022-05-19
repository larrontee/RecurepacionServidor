package dao;

import java.util.ArrayList;

import models.Office;

public interface OfficeDAO {

	 public Office getOffice(String officeCode);
	 public ArrayList<Office> getAllOffice();
	 public boolean deleteOffice(String officeCode);
	 public boolean updateOffice(Office office, String officeCode);
	 public boolean insertOffice(Office office);
}
