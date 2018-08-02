package com.dadong.test;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Random;

/**
 * Created by dadong on 2018/8/1.
 *
 */
public class MassiveInsertDB {
	private static class User implements Serializable{
		private Long id ;
		private String name ; //1
		private Integer gender ; //2
		private Integer age ; //3
		private String province ; //4
		private String city ; //5
		private String district ; //6
		private String mobile ; //7
		private String password ; //8
		private String linkMobile ;  //9
		private String tel ;  //10
		private String hobbit ; //11
		private Double latitude ; //12
		private Double longitude ; //13
		private String salt ; //14
		private String lastLoginIp ; //15
		private Date lastLoginTime ; //16
		private Date createTime ; //17

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Date getLastLoginTime() {
			return lastLoginTime;
		}

		public void setLastLoginTime(Date lastLoginTime) {
			this.lastLoginTime = lastLoginTime;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getGender() {
			return gender;
		}

		public void setGender(Integer gender) {
			this.gender = gender;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public String getProvince() {
			return province;
		}

		public void setProvince(String province) {
			this.province = province;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getDistrict() {
			return district;
		}

		public void setDistrict(String district) {
			this.district = district;
		}

		public String getMobile() {
			return mobile;
		}

		public void setMobile(String mobile) {
			this.mobile = mobile;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getLinkMobile() {
			return linkMobile;
		}

		public void setLinkMobile(String linkMobile) {
			this.linkMobile = linkMobile;
		}

		public String getTel() {
			return tel;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}

		public String getHobbit() {
			return hobbit;
		}

		public void setHobbit(String hobbit) {
			this.hobbit = hobbit;
		}

		public Double getLatitude() {
			return latitude;
		}

		public void setLatitude(Double latitude) {
			this.latitude = latitude;
		}

		public Double getLongitude() {
			return longitude;
		}

		public void setLongitude(Double longitude) {
			this.longitude = longitude;
		}

		public String getSalt() {
			return salt;
		}

		public void setSalt(String salt) {
			this.salt = salt;
		}

		public String getLastLoginIp() {
			return lastLoginIp;
		}

		public void setLastLoginIp(String lastLoginIp) {
			this.lastLoginIp = lastLoginIp;
		}

		public Date getCreateTime() {
			return createTime;
		}

		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}

		@Override
		public String toString() {
			return "User{" +
					"id=" + id +
					", name='" + name + '\'' +
					", gender=" + gender +
					", age=" + age +
					", province='" + province + '\'' +
					", city='" + city + '\'' +
					", district='" + district + '\'' +
					", mobile='" + mobile + '\'' +
					", password='" + password + '\'' +
					", linkMobile='" + linkMobile + '\'' +
					", tel='" + tel + '\'' +
					", hobbit='" + hobbit + '\'' +
					", latitude=" + latitude +
					", longitude=" + longitude +
					", salt='" + salt + '\'' +
					", lastLoginIp='" + lastLoginIp + '\'' +
					", lastLoginTime=" + lastLoginTime +
					", createTime=" + createTime +
					'}';
		}
	}
	public static void main(String args[]){
		long start = System.currentTimeMillis() ;
		execute();
		long end = System.currentTimeMillis() ;
		System.out.println("耗时: "+ (end - start) + "毫秒");
	}
	public static void execute() {
		batchInsert();
	}
	public static void jdbc(){
		// 实际执行的代码
		Connection connection = null ;
		try {
			Class.forName("com.mysql.jdbc.Driver") ;
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456789") ;
			connection.setAutoCommit(false); //关闭自动提交
			String sql = "INSERT INTO m_user VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)" ;
			PreparedStatement pstm = connection.prepareStatement(sql) ;

			int begin = 0, end = 0 ;
			int total = 100000 ;
			int step = 10000 ;
			end = begin + step ;

			while (end <= total){

				long t1 = System.currentTimeMillis() ;
				while (begin < end){
					int i = begin ;
					Random random = new Random() ;
					User user = new User() ;
					user.setAge(i) ;
					user.setName("people" + i) ;
					user.setCity("City" + i) ;
					user.setProvince("Province" + i ) ;
					user.setCreateTime(new Date());
					user.setDistrict("District" + i) ;
					user.setTel("125456"+i) ;
					String mobile = random.nextInt() + "" ;
					user.setMobile(mobile.length() > 11 ? mobile.substring(0,11): mobile);
					user.setGender(random.nextBoolean()? 1 : 0);
					user.setLastLoginTime(new Date());
					user.setLastLoginIp(random.nextInt(255)+"."+random.nextInt(255)+"."+random.nextInt(255)+"."+random.nextInt(255)) ;
					user.setPassword(random.nextLong()+".");
					user.setSalt(random.nextInt()+"");
					user.setHobbit("hobbit"+i);
					user.setLinkMobile(user.getMobile());
					user.setLatitude(random.nextDouble());
					user.setLongitude(random.nextDouble()) ;

					pstm.setInt(1, i + 1); ;
					pstm.setString(2, user.getName()) ;
					pstm.setInt(3, user.getGender());
					pstm.setInt(4,user.getAge());
					pstm.setString(5,user.getProvince());
					pstm.setString(6,user.getCity());
					pstm.setString(7,user.getDistrict());
					pstm.setString(8,user.getMobile());
					pstm.setString(9,user.getPassword());
					pstm.setString(10,user.getTel());
					pstm.setString(11,user.getHobbit());
					pstm.setString(12,user.getLinkMobile());
					pstm.setDouble(13,user.getLatitude());
					pstm.setDouble(14,user.getLongitude());
					pstm.setString(15,user.getSalt());
					pstm.setString(16,user.getLastLoginIp());
					pstm.setDate(17,new java.sql.Date(user.getLastLoginTime().getTime()));
					pstm.setDate(18,new java.sql.Date(user.getCreateTime().getTime()));
					pstm.execute() ;
					begin ++ ;
				}
				connection.commit();
				long t2 = System.currentTimeMillis() ;
				System.out.println(step + "条耗时" + (t2 - t1));
				end += step ;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

	/**
	 * 批量插入的方法
	 */
	public static void batchInsert(){
		// 实际执行的代码
		Connection connection = null ;
		try {
			Class.forName("com.mysql.jdbc.Driver") ;
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456789") ;
			connection.setAutoCommit(false); //关闭自动提交
			String sql = "INSERT INTO m_user_2 VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)" ;
			// 预编译
			PreparedStatement pstm = connection.prepareStatement(sql) ;

			int begin = 0, end = 0 ;
			int total = 10000000 ;
			int step = 100000 ;
			end = begin + step ;

			while (end <= total){
				long t1 = System.currentTimeMillis() ;

				while (begin < end){
					long i = begin ;

					Random random = new Random() ;
					User user = new User() ;
					user.setId(i + 1l);
					user.setAge((int)i%100) ;
					user.setName("people" + i) ;
					user.setCity("City" + i) ;
					user.setProvince("Province" + i ) ;
					user.setCreateTime(new Date());
					user.setDistrict("District" + i) ;
					user.setTel("125456"+i) ;
					String mobile = random.nextInt() + "" ;
					user.setMobile(mobile.length() > 11 ? mobile.substring(0,11): mobile);
					user.setGender(random.nextBoolean()? 1 : 0);
					user.setLastLoginTime(new Date());
					user.setLastLoginIp(random.nextInt(255)+"."+random.nextInt(255)+"."+random.nextInt(255)+"."+random.nextInt(255)) ;
					user.setPassword(random.nextLong()+".");
					user.setSalt(random.nextInt()+"");
					user.setHobbit("hobbit"+i);
					user.setLinkMobile(user.getMobile());
					user.setLatitude(random.nextDouble());
					user.setLongitude(random.nextDouble()) ;
//					System.out.println(user);

					pstm.setLong(1, user.getId()); ;
					pstm.setString(2, user.getName()) ;
					pstm.setInt(3, user.getGender());
					pstm.setInt(4,user.getAge());
					pstm.setString(5,user.getProvince());
					pstm.setString(6,user.getCity());
					pstm.setString(7,user.getDistrict());
					pstm.setString(8,user.getMobile());
					pstm.setString(9,user.getPassword());
					pstm.setString(10,user.getTel());
					pstm.setString(11,user.getHobbit());
					pstm.setString(12,user.getLinkMobile());
					pstm.setDouble(13,user.getLatitude());
					pstm.setDouble(14,user.getLongitude());
					pstm.setString(15,user.getSalt());
					pstm.setString(16,user.getLastLoginIp());
					pstm.setDate(17,new java.sql.Date(user.getLastLoginTime().getTime()));
					pstm.setDate(18,new java.sql.Date(user.getCreateTime().getTime()));
//					System.out.println(pstm);
					pstm.addBatch();
//					pstm.clearParameters();
					begin ++ ;
				}
				//执行批处理
				pstm.executeBatch();
//				pstm.clearBatch();
				connection.commit();

				long t2 = System.currentTimeMillis() ;
				System.out.println(step + "条耗时" + (t2 - t1));
				end += step ;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
