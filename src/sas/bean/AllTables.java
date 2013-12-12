// This file is generated by genbeans tool. Do NOT edit it! @formatter:off
package sas.bean;

import java.util.HashMap;
import sas.core.Bean;
import sas.core.DBManager;
import sas.core.Octets;
import sas.core.Table;
import sas.core.TableLong;

/** 全部的数据库表的注册和使用类(自动生成的静态类) */
public final class AllTables
{
	private AllTables() {}
	private static final DBManager _dbm = DBManager.instance();
	/**
	 * 注册全部的数据库表<p>
	 * 用于初始化和注册下面的全部静态成员(保持和AllBeans.register一致的用法), 并启动提交线程<br>
	 * 调用前要先初始化数据库管理器: DBManager.instance().startup(...)
	 */
	public static void register() { _dbm.startCommitThread(); }

	/**
	 * 数据库表定义. key类型只能是32/64位整数/浮点数或字符串/binary类型或bean类型, id类型表示优化的非负数long类型
	 */
	public static final TableLong<TestType> TestTable = _dbm.openTable("TestTable", "test", 200000, new TestType());
	/**
	 * value类型必须是bean定义的类型
	 */
	public static final Table<TestBean, TestBean> BeanTable = _dbm.openTable("BeanTable", "bean", 65536, new TestBean(), new TestBean());
	/**
	 * 注意表名和key类型的对应关系是不能改变的
	 */
	public static final Table<Octets, TestEmpty> OctetsTable = _dbm.openTable("OctetsTable", "bean", 1000, null, null);

	/**
	 * 以下内部类可以单独使用,避免初始化前面的表对象,主要用于获取表的键值类型
	 */
	public static final class Types
	{
		public static HashMap<String, Bean<?>> getKeyTypes()
		{
			HashMap<String, Bean<?>> r = new HashMap<String, Bean<?>>(3 * 2);
			r.put("TestTable", null);
			r.put("BeanTable", new TestBean());
			r.put("OctetsTable", null);
			return r;
		}

		public static HashMap<String, Bean<?>> getValueTypes()
		{
			HashMap<String, Bean<?>> r = new HashMap<String, Bean<?>>(3 * 2);
			r.put("TestTable", new TestType());
			r.put("BeanTable", new TestBean());
			r.put("OctetsTable", null);
			return r;
		}
	}
}
