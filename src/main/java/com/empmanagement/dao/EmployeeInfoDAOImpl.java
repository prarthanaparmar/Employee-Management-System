package com.empmanagement.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.empmanagement.domain.EmployeeInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeInfoDAOImpl implements IEmployeeInfoDAO {

    private static final String TABLE_EMP = "employee";
    private static final String QUERY_WILDCARD = "%";
    private static final String TABLE_DEPT = "dept";
    private static final String QUERY_GET_ALL_ROLES = "SELECT distinct role FROM " + TABLE_EMP + ";";
    private static final String QUERY_GET_EMP_ROLES = "SELECT role FROM " + TABLE_EMP + " WHERE empId = ? ;";
    private static final String QUERY_GET_ALL_DEPT = "SELECT distinct deptname FROM " + TABLE_DEPT + ";";
    private static final String QUERY_GET_ALL = "SELECT empId, empName, empEmail, role, deptname FROM " + TABLE_EMP
            + " e Inner Join dept d On e.deptId=d.iddept where empName like ? and role like ? and deptname like ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Logger logger = LoggerFactory.getLogger(EmployeeInfoDAOImpl.class);

    /**
     * Return filtered list of employees
     * 
     * @param name name of the employee to be matched or null for wildcard
     * @param role employee role or null for wildcard
     * @return List<EmployeeInfo> object
     */
    @Override
    public List<EmployeeInfo> getEmployeeInfos(String name, String role, String dept) {
        try {
            List<EmployeeInfo> bl = jdbcTemplate.query(QUERY_GET_ALL, new PreparedStatementSetter() {

                @Override
                public void setValues(PreparedStatement ps) throws SQLException {
                    if (name != null && (!name.isEmpty())) {
                        ps.setString(1, name);
                    } else {
                        ps.setString(1, QUERY_WILDCARD);
                    }

                    if (role != null && (!role.isEmpty())) {
                        ps.setString(2, role);
                    } else {
                        ps.setString(2, QUERY_WILDCARD);
                    }

                    if (dept != null && (!dept.isEmpty())) {
                        ps.setString(3, dept);
                    } else {
                        ps.setString(3, QUERY_WILDCARD);
                    }
                }

            }, new RowMapper<EmployeeInfo>() {

                @Override
                public EmployeeInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
                    EmployeeInfo lb = new EmployeeInfo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                            rs.getString(5));
                    return lb;
                }

            });
            logger.debug("Number of Leaves found: " + bl.size());
            return bl;
        } catch (Exception ex) {
            logger.error("Error occurred while getting leaves. ex: " + ex);
            return null;
        }
    };

    /**
     * @return list of all the roles in the system
     */
    @Override
    public List<String> getAllRoles() {
        try {
            List<String> bl = jdbcTemplate.query(QUERY_GET_ALL_ROLES, new RowMapper<String>() {

                @Override
                public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return rs.getString(1);
                }

            });
            logger.debug("Number of Roles found: " + bl.size());
            return bl;
        } catch (Exception ex) {
            logger.error("Error occurred while getting Roles. ex: " + ex);
            return null;
        }
    };

    /**
     * @return list of all the dept in the system
     */
    @Override
    public List<String> getAllDept() {
        try {
            List<String> bl = jdbcTemplate.query(QUERY_GET_ALL_DEPT, new RowMapper<String>() {

                @Override
                public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return rs.getString(1);
                }

            });
            logger.debug("Number of Departments found: " + bl.size());
            return bl;
        } catch (Exception ex) {
            logger.error("Error occurred while getting departments. ex: " + ex);
            return null;
        }
    }

	@Override
	public String getEmployeeRole(Long empId) {
		
		String role = null;
		try {
			
			role = jdbcTemplate.queryForObject(QUERY_GET_EMP_ROLES,
					String.class, empId);
		     System.out.println("ID : " + empId);
			}
			catch (Exception e){
				System.out.println(e);
			}
			return role;
	};

}