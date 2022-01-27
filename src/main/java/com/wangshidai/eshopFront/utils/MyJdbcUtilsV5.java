package com.wangshidai.eshopFront.utils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;

import org.apache.log4j.Logger;

/**
 * @author brant
 * @version V1.0
 * @Package cn.myselef.JdbcOperateMysql
 * @date 2021/7/10 21:11
 * @Copyright ? 暂无
 */
public class MyJdbcUtilsV5 {
	
	private static Logger logger = Logger.getLogger(MyJdbcUtilsV5.class);
	
    private static String driver=null;

    private static String url=null;
    private static String user=null;
    private static String password=null;
    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    private static List<Map<String,Object>> lis;
    private static Map<String,Object> map;
    
    static {
       try {
           Properties a1 = new Properties();
           /*a1.load(new FileInputStream("D:\\data\\JavaCase\\" +
                   "basicwork\\JdbcAndDatabase\\src\\cn\\myselef\\" +
                   "JdbcOperateMysql\\db.properties"));*/
           //返回输入流路径默认src
           InputStream is =
                MyJdbcUtilsV5.class.getResourceAsStream("/db.properties");
           a1.load(is);
            driver = a1.getProperty("driver");
            url = a1.getProperty("url");
            user = a1.getProperty("user");
            password = a1.getProperty("password");
            //加载驱动
            Class.forName(driver);

        } catch (IOException e) {
            logger.error("-1",e);
        } catch (ClassNotFoundException e) {
        	logger.error("-1",e);
        }
    }
    public static void main(String[] args) {
		//连接数据库,执行DQL语句,输出结果
		MyJdbcUtilsV5.acquireSqlQuary("select * from sarlary" );
	}
    /**
     * 获取外部连接
     */
    public static Connection acquireConnection(Connection a){

        connection = a;

        return connection;
    }
    /**
     * 获取连接
     */
    public static Connection acquireConnection(){
        try {
            connection = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
        	logger.error("-1",e);
        }
        return connection;
    }


    /**
     * 创建sql语句对象,执行增删改（DML）
     *
     * @param a
     * @param params
     * @return
     */
    public static int acquireSql(String a,Object... params){
        int rows=0;
        try {
        	logger.debug("SQL>>>>>>>>"+a);
            acquireConnection();
            preparedStatement = connection.prepareStatement(a);
            for (int i = 0; i < params.length; i++) {
                if(params!=null){
                	logger.debug("参数列表:>>>>>>>>"+params[i]+"\t");
                    preparedStatement.setObject(i+1,params[i]);
                }
            }
            rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
        	logger.error("-1",e);
        }finally{
            close();
        }
        return rows;
    }
    
    /**
     * 
     * 创建sql语句对象,执行增删改（DML）
     * 事务操作
     * 查询自增长Id
     * @param a
     * @param params
     * @return
     */
    public static int acquireSql(String[] a,Object[][] params){
    	int rows=0;
    	acquireConnection();
    	try {
    		logger.debug("SQL>>>>>>>>"+a);
			connection.setAutoCommit(false);
			for (int i = 0; i < a.length; i++) {
				preparedStatement = connection.prepareStatement(a[i]);
				for (int j = 0; j < params[i].length; j++) {
	                if(params[i] !=null){
	                	logger.debug("参数列表:>>>>>>>>"+params[i]+"\t");
	                    preparedStatement.setObject(j+1,params[i][j]);
	                }
	            }
				rows += preparedStatement.executeUpdate(); 
				//int num = 10/0;
			}
			connection.commit();
			
		} catch (Exception e) {
			logger.error("-1",e);
			try {
				connection.rollback();
			} catch (SQLException e1) {
				//logger.error("-1",e1);
			}
		}finally{
            close();
        }
    	return rows;
    }

    public static int acquireSqlPrimaryKey(String a,Object... params){
        int insertId = 0;
        acquireConnection();
        try {
            logger.debug("SQL>>>>>>>>"+a);
            connection.setAutoCommit(false);

                preparedStatement = connection.prepareStatement(a);
                for (int j = 0; j < params.length; j++) {
                    if(params[j] !=null){
                        logger.debug("参数列表:>>>>>>>>"+params[j]+"\t");
                        preparedStatement.setObject(j+1,params[j]);
                    }
                }
                //int num = 10/0;
                preparedStatement.executeUpdate();
                //查询自增长ID
                String sqlSelect = "select LAST_INSERT_ID()";
                resultSet = preparedStatement.executeQuery(sqlSelect);
                resultSet.next();
                insertId = resultSet.getInt(1);
            connection.commit();

        } catch (Exception e) {
            logger.error("-1",e);
            try {
                connection.rollback();
            } catch (SQLException e1) {
                //logger.error("-1",e1);
            }
        }finally{
            close();
        }
        return insertId;
    }
    /**
     * 通过外部连接,创建sql语句对象,执行增删改（DML）
     *
     * @param m
     * @param a
     * @param params
     * @return
     */
    public static int acquireSql(Connection m,String a,Object... params){
        int rows=0;
        try {
        	logger.debug("SQL>>>>>>>>"+a);
            preparedStatement = m.prepareStatement(a);
            for (int i = 0; i < params.length; i++) {
                if(params!=null){
                	//logger.debug("参数列表:>>>>>>>>"+params[i]+"\t");
                    preparedStatement.setObject(i+1,params[i]);
                }
            }
            rows = preparedStatement.executeUpdate();
            //System.out.println("受影响的行数:"+rows);
        } catch (SQLException e) {
        	logger.error("-1",e);
        }
        return rows;
    }
    
    /**
     * 通过外部连接,创建sql语句对象,执行增删改（DML）
     * 多条DML语句(包含事务操作)
     * 
     * @param connection
     * @param a
     * @param params
     * @return
     */
    public static int acquireSql(Connection connection,String[] a,Object[][] params){
    	int rows=0;
    	acquireConnection(connection);
    	try {
    		logger.debug("SQL>>>>>>>>"+a);
			connection.setAutoCommit(false);
			for (int i = 0; i < a.length; i++) {
				preparedStatement = connection.prepareStatement(a[i]);
				for (int j = 0; j < params[i].length; j++) {
	                if(params[i]!=null){
	                	logger.debug("参数列表:>>>>>>>>"+params[i]+"\t");
	                    preparedStatement.setObject(j+1,params[i][j]);
	                }
	            }
				rows += preparedStatement.executeUpdate(); 
			}
			//int num = 10/0;
			connection.commit();
			
		} catch (Exception e) {
			logger.error("-1",e);
			try {
				connection.rollback();
			} catch (SQLException e1) {
				//logger.error("-1",e1);
			}
		}
    	
    	
    	return rows;
    }

    /**
     * 创建sql语句对象,执行查询（DQL）,查询多行数据
     *
     * @param a
     * @param params
     * @return
     */
    public static List<Map<String,Object>> acquireSqlQuary(String a,Object... params){
    	lis = new ArrayList<Map<String,Object>>();
        try {
        	logger.debug("SQL>>>>>>>>"+a);
            acquireConnection();
            preparedStatement = connection.prepareStatement(a);
            for (int i = 0; i < params.length; i++) {
                if(params!=null){
                	logger.debug("参数列表:>>>>>>>>"+params[i]+"\t");
                    preparedStatement.setObject(i+1,params[i]);
                }
            }
            resultSet = preparedStatement.executeQuery();
            //封装结果集到List<Map<String,Object>>中
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            while(resultSet.next()){ //每次循环获取一次记录
                Map<String,Object> map = new HashMap<String, Object>();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    Object object = resultSet.getObject(i);
                    map.put(columnName,object);
                }
                lis.add(map); 
            }

        } catch (SQLException e) {
        	logger.error("-1",e);
        }finally{
            close();
        }
        return lis;

    }
    
	/**
	 * 创建sql语句对象,执行查询（DQL）,查询一行数据
	 * 
	 * @param a
	 * @param params
	 * @return
	 */
	public static Map<String, Object> acquireSqlQuaryBean(String a,
			Object... params) {
		map = new HashMap<String, Object>();
		try {
			logger.debug("SQL>>>>>>>>"+a);
			acquireConnection();
			preparedStatement = connection.prepareStatement(a);
			for (int i = 0; i < params.length; i++) {
				if (params != null) {
					logger.debug("参数列表:>>>>>>>>"+params[i]+"\t");
					preparedStatement.setObject(i + 1, params[i]);
				}
			}
			resultSet = preparedStatement.executeQuery();
			
			//封装结果集到MapMap<String, Object>
			ResultSetMetaData metaData = resultSet.getMetaData();
			int columnCount = metaData.getColumnCount();
			// 只查询第一行
			if (resultSet.next()) {
				for (int i = 1; i <= columnCount; i++) {
					String columnName = metaData.getColumnName(i);
					Object object = resultSet.getObject(i);
					map.put(columnName, object);
				}
			}
		} catch (SQLException e) {
			logger.error("-1",e);
		}

		return map;

	}
    
    /**
     * 创建sql语句对象,执行查询（DQL）,查询一个数据
     * 
     * @param a
     * @param params
     * @return
     */
    public static Object acquireSqlQuaryOne(String a,Object...params){
    	Object val1=null;
    	try {
    		logger.debug("SQL>>>>>>>>"+a);
			acquireConnection();
			preparedStatement = connection.prepareStatement(a);
			for (int i = 0; i < params.length; i++) {
			    if(params!=null){
			    	logger.debug("参数列表:>>>>>>>>"+params[i]+"\t");
			        preparedStatement.setObject(i+1,params[i]);
			    }
			}
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
			  val1 = resultSet.getObject(1);
			}
		} catch (SQLException e) {
			logger.error("-1",e);
		}
    	return val1;
    }

    /**
     * 通过外部连接,创建sql语句对象,执行查询（DQL）,查询多行数据
     *
     * @param m
     * @param a
     * @param params
     * @return
     */
    public static List<Map<String,Object>> acquireSqlQuary(Connection m,String a,Object... params){
    	lis = new ArrayList<Map<String,Object>>();
        try {
        	logger.debug("SQL>>>>>>>>"+a);
            connection = m;
            preparedStatement = m.prepareStatement(a);
            for (int i = 0; i < params.length; i++) {
                if(params!=null){
                	logger.debug("参数列表:>>>>>>>>"+params[i]+"\t");
                    preparedStatement.setObject(i+1,params[i]);
                }
            }
            resultSet = preparedStatement.executeQuery();
            
            //封装结果集到List<Map<String,Object>>中
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            while(resultSet.next()){ //每次循环获取一次记录
                Map<String,Object> map = new HashMap<String, Object>();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    Object object = resultSet.getObject(i);
                    map.put(columnName,object);
                }
                lis.add(map); 
            }
        } catch (SQLException e) {
        	logger.error("-1",e);
        }
        return lis;
    }

    /**
     * 创建sql语句对象,执行查询（DQL）,将多行数据封装在Class<E>的集合中
     * 
     * @param class1
     * @param a
     * @param params
     * @return
     */
    public static <E> List<E> acquareFileldToBean(Class<E> class1,String a,Object... params){
    	
    	List<E> list1 = new ArrayList<E>();
    	//获取sql查询结果
    	List<Map<String,Object>> lis = acquireSqlQuary(a, params);
    	try {
    		logger.debug("SQL>>>>>>>>"+a);
    		for (int j = 0; j < params.length; j++) {
    			logger.debug("参数列表:>>>>>>>>"+params[j]+"\t");
			}
    		
    		
    	//遍历lis集合
    	for (Map<String,Object> map : lis) {
    			//将class1实例化
				Object obj = class1.newInstance();
				//获取class1的所有成员变量
	        	Field[] fields = class1.getDeclaredFields();
	        	//获取map所有的键
	        	Set<String> allKeys = map.keySet();
	        	for (String key : allKeys) {
	        	//将key存放在class1中的成员变量中
	        		for (Field field : fields) {
	        			//暴力反射
	        			field.setAccessible(true);
	        			if(key.equalsIgnoreCase(field.getName())){
	        				field.set(obj, map.get(key));
	        			}
	        		}
	        	}
	        	//存储obj对象到集合
	        	list1.add((E)obj);
    		}
				
			} catch (InstantiationException e) {
				logger.error("-1",e);
			} catch (IllegalAccessException e) {
				logger.error("-1",e);
			}
    	return list1;
	
    }
//    public static <E> E acquareFileldToBeanOneLine(Class<E> class1,String a,Object... params){
//    	List<E> list1 = new ArrayList<E>();
//    	//获取sql查询结果
//    	Map<String,Object> map = acquireSqlQuaryBean(a, params);
//    	//将class1实例化
//		try {
//			Object obj = class1.newInstance();
//			//获取class1的所有成员变量
//	    	Field[] fields = class1.getDeclaredFields();
//	    	//获取map所有的键
//        	Set<String> allKeys = map.keySet();
//        	for (String key : allKeys) {
//        	//将key存放在class1中的成员变量中
//        		for (Field field : fields) {
//        			//暴力反射
//        			field.setAccessible(true);
//        			if(key.equalsIgnoreCase(field.getName())){
//        				field.set(obj, map.get(key));
//        			}
//        		}
//        		//存储obj对象到集合
//	        	list1.add((E)obj);
//        	}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//    	return list1.get(0);
//    	
//    }
    public static <E> E acquareFileldToBeanOneLine(Class<E> class1,String a,Object... params){
    	//List<E> list1 = new ArrayList<E>();
    	//获取sql查询结果
    	Map<String,Object> map = acquireSqlQuaryBean(a, params);
    	Object obj = null;
    	//将class1实例化
		try {
			logger.debug("SQL>>>>>>>>"+a);
			for (int j = 0; j < params.length; j++) {
    			logger.debug("参数列表:>>>>>>>>"+params[j]+"\t");
			}
			
			obj = class1.newInstance();
			//获取class1的所有成员变量
	    	Field[] fields = class1.getDeclaredFields();
	    	//获取map所有的键
        	Set<String> allKeys = map.keySet();
        	for (String key : allKeys) {
        	//将key存放在class1中的成员变量中
        		for (Field field : fields) {
        			//暴力反射
        			field.setAccessible(true);
        			if(key.equalsIgnoreCase(field.getName())){
        				field.set(obj, map.get(key));
        			}
        		}

        	}
		} catch (Exception e) {
			logger.error("-1",e);
		}
    	return (E)obj;
    }
    /**
     * 关闭资源
     */
    public static void close(){
        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
            	logger.error("-1",e);
            }
        }
        if(preparedStatement != null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
            	logger.error("-1",e);
            }
        }
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
            	logger.error("-1",e);
            }
        }
    }
    /**
     * set和get
     */
    public static String getDriver() {
        return driver;
    }

    public static void setDriver(String driver) {
        MyJdbcUtilsV5.driver = driver;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        MyJdbcUtilsV5.url = url;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        MyJdbcUtilsV5.user = user;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        MyJdbcUtilsV5.password = password;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        MyJdbcUtilsV5.connection = connection;
    }

    public static PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }

    public static void setPreparedStatement(PreparedStatement preparedStatement) {
        MyJdbcUtilsV5.preparedStatement = preparedStatement;
    }

    public static ResultSet getResultSet() {
        return resultSet;
    }

    public static void setResultSet(ResultSet resultSet) {
        MyJdbcUtilsV5.resultSet = resultSet;
    }

}
