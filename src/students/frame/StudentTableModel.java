package students.frame;

import java.text.DateFormat;
import java.util.Vector;
 
import javax.swing.table.AbstractTableModel;
 
import student.logic.Student;

public class StudentTableModel extends AbstractTableModel {

	private Vector students;
	
	 public StudentTableModel(Vector students) {
	        this.students = students;
	 }
	 public String getColumnName(int column) {
	        String[] colNames = {"Фамилия", "Имя", "Отчество", "Дата"};
	        return colNames[column];
	    }
	
	@Override
	public int getColumnCount() {
		   return 4;
	}

	@Override
	public int getRowCount() {
		 if (students != null) {
	            return students.size();
	        }
	        return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		  if (students != null) {
	            // Получаем из вектора студента
	            Student st = (Student) students.get(rowIndex);
	            // В зависимости от колонки возвращаем имя, фамилия и т.д.
	            switch (columnIndex) {
	                case 0:
	                    return st.getSurName();
	                case 1:
	                    return st.getFirstName();
	                case 2:
	                    return st.getPatronymic();
	                case 3:
	                    return DateFormat.getDateInstance(DateFormat.SHORT).format(
	                            st.getDateOfBirth());
	            }
	        }
	        return null;
	}
	
	  public Student getStudent(int rowIndex) {
	        if (students != null) {
	            if (rowIndex < students.size() && rowIndex >= 0) {
	                return (Student) students.get(rowIndex);
	            }
	        }
	        return null;
	    }
	
}
