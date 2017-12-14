// This file is generated by genbeans tool. Do NOT edit it! @formatter:off
package jane.bean;

import java.lang.reflect.Field;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;
import jane.core.Bean;
import jane.core.DynBean;
import jane.core.MarshalException;
import jane.core.Octets;
import jane.core.OctetsStream;
import jane.core.SBase;
import jane.core.SContext;
import jane.core.SDeque;
import jane.core.SList;
import jane.core.SMap;
import jane.core.SMap.SMapListener;
import jane.core.SSMap;
import jane.core.SSSet;
import jane.core.SSet;
import jane.core.SSet.SSetListener;
import jane.core.Util;

/**
 * 测试生成所有支持的类型
 */
public final class TestType extends Bean<TestType>
{
	private static final long serialVersionUID = 0xbeacabe90777739dL;
	public  static final int BEAN_TYPE = 2;
	public  static final String BEAN_TYPENAME = TestType.class.getSimpleName();
	public  static final TestType BEAN_STUB = new TestType();
	private static final Field FIELD_v1;
	private static final Field FIELD_v2;
	private static final Field FIELD_v3;
	private static final Field FIELD_v4;
	private static final Field FIELD_v5;
	private static final Field FIELD_v6;
	private static final Field FIELD_v7;
	private static final Field FIELD_v8;
	private static final Field FIELD_v9;
	private static SSetListener<Long> LISTENER_v13;
	private static SSetListener<Float> LISTENER_v14;
	private static SSetListener<Double> LISTENER_v15;
	private static SMapListener<Long, String> LISTENER_v16;
	private static SMapListener<TestBean, Boolean> LISTENER_v17;
	private static SMapListener<Octets, TestBean> LISTENER_v18;
	private static final Field FIELD_v20;

	private /*  1*/ boolean v1; // 1字节布尔,0表示假,1表示真,其它默认表示真
	private /*  2*/ byte v2; // 1字节整数
	private /*  3*/ short v3; // 2字节整数
	private /*  4*/ int v4; // 4字节整数
	private /*  5*/ long v5; // 8字节整数
	private /*  6*/ float v6; // 4字节浮点数
	private /*  7*/ double v7; // 8字节浮点数
	private /*  8*/ Octets v8; // 二进制数据(Octets)
	private /*  9*/ String v9; // 字符串(String)
	private /* 10*/ final ArrayList<Boolean> v10; // 数组容器(ArrayList)
	private /* 11*/ final LinkedList<Byte> v11; // 链表容器(LinkedList)
	private /* 12*/ final ArrayDeque<Integer> v12; // 队列容器(ArrayDeque)
	private /* 13*/ final HashSet<Long> v13; // 无序集合容器(HashSet)
	private /* 14*/ final TreeSet<Float> v14; // 排序集合容器(TreeSet)
	private /* 15*/ final LinkedHashSet<Double> v15; // 有序集合容器(LinkedHashSet)
	private /* 16*/ final HashMap<Long, String> v16; // 无序映射容器(HashMap)
	private /* 17*/ final TreeMap<TestBean, Boolean> v17; // 排序映射容器(TreeMap)
	private /* 18*/ final LinkedHashMap<Octets, TestBean> v18; // 有序映射容器(LinkedHashMap)
	private /* 19*/ final TestBean v19; // 嵌入其它bean
	private /*  0*/ java.lang.String v20; // 非序列化字段

	static
	{
		try
		{
			Class<TestType> _c_ = TestType.class;
			FIELD_v1 = _c_.getDeclaredField("v1"); FIELD_v1.setAccessible(true);
			FIELD_v2 = _c_.getDeclaredField("v2"); FIELD_v2.setAccessible(true);
			FIELD_v3 = _c_.getDeclaredField("v3"); FIELD_v3.setAccessible(true);
			FIELD_v4 = _c_.getDeclaredField("v4"); FIELD_v4.setAccessible(true);
			FIELD_v5 = _c_.getDeclaredField("v5"); FIELD_v5.setAccessible(true);
			FIELD_v6 = _c_.getDeclaredField("v6"); FIELD_v6.setAccessible(true);
			FIELD_v7 = _c_.getDeclaredField("v7"); FIELD_v7.setAccessible(true);
			FIELD_v8 = _c_.getDeclaredField("v8"); FIELD_v8.setAccessible(true);
			FIELD_v9 = _c_.getDeclaredField("v9"); FIELD_v9.setAccessible(true);
			FIELD_v20 = _c_.getDeclaredField("v20"); FIELD_v20.setAccessible(true);
		}
		catch(Exception e)
		{
			throw new Error(e);
		}
	}

	public TestType()
	{
		v8 = new Octets(5);
		v9 = "";
		v10 = new ArrayList<>(10);
		v11 = new LinkedList<>();
		v12 = new ArrayDeque<>();
		v13 = new HashSet<>();
		v14 = new TreeSet<>();
		v15 = new LinkedHashSet<>();
		v16 = new HashMap<>(0);
		v17 = new TreeMap<>();
		v18 = new LinkedHashMap<>();
		v19 = new TestBean();
		v20 = null;
	}

	public TestType(boolean v1, byte v2, short v3, int v4, long v5, float v6, double v7, Octets v8, String v9, Collection<Boolean> v10, Collection<Byte> v11, Collection<Integer> v12, Collection<Long> v13, Collection<Float> v14, Collection<Double> v15, Map<Long, String> v16, Map<TestBean, Boolean> v17, Map<Octets, TestBean> v18, TestBean v19, java.lang.String v20)
	{
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
		this.v4 = v4;
		this.v5 = v5;
		this.v6 = v6;
		this.v7 = v7;
		this.v8 = (v8 != null ? v8 : new Octets(5));
		this.v9 = (v9 != null ? v9 : "");
		Util.appendDeep(v10, this.v10 = new ArrayList<>(10));
		Util.appendDeep(v11, this.v11 = new LinkedList<>());
		Util.appendDeep(v12, this.v12 = new ArrayDeque<>());
		Util.appendDeep(v13, this.v13 = new HashSet<>());
		Util.appendDeep(v14, this.v14 = new TreeSet<>());
		Util.appendDeep(v15, this.v15 = new LinkedHashSet<>());
		Util.appendDeep(v16, this.v16 = new HashMap<>(0));
		Util.appendDeep(v17, this.v17 = new TreeMap<>());
		Util.appendDeep(v18, this.v18 = new LinkedHashMap<>());
		this.v19 = (v19 != null ? v19.clone() : new TestBean());
		this.v20 = v20;
	}

	@Override
	public void reset()
	{
		v1 = false;
		v2 = 0;
		v3 = 0;
		v4 = 0;
		v5 = 0;
		v6 = 0;
		v7 = 0;
		v8.clear();
		v9 = "";
		v10.clear();
		v11.clear();
		v12.clear();
		v13.clear();
		v14.clear();
		v15.clear();
		v16.clear();
		v17.clear();
		v18.clear();
		v19.reset();
		v20 = null;
	}

	@Override
	public void assign(TestType _b_)
	{
		if(_b_ == this) return;
		if(_b_ == null) { reset(); return; }
		this.v1 = _b_.v1;
		this.v2 = _b_.v2;
		this.v3 = _b_.v3;
		this.v4 = _b_.v4;
		this.v5 = _b_.v5;
		this.v6 = _b_.v6;
		this.v7 = _b_.v7;
		if(_b_.v8 != null) this.v8.replace(_b_.v8); else this.v8.clear();
		this.v9 = (_b_.v9 != null ? _b_.v9 : "");
		this.v10.clear(); Util.appendDeep(_b_.v10, this.v10);
		this.v11.clear(); Util.appendDeep(_b_.v11, this.v11);
		this.v12.clear(); Util.appendDeep(_b_.v12, this.v12);
		this.v13.clear(); Util.appendDeep(_b_.v13, this.v13);
		this.v14.clear(); Util.appendDeep(_b_.v14, this.v14);
		this.v15.clear(); Util.appendDeep(_b_.v15, this.v15);
		this.v16.clear(); Util.appendDeep(_b_.v16, this.v16);
		this.v17.clear(); Util.appendDeep(_b_.v17, this.v17);
		this.v18.clear(); Util.appendDeep(_b_.v18, this.v18);
		this.v19.assign(_b_.v19);
		this.v20 = _b_.v20;
	}

	/** @return 1字节布尔,0表示假,1表示真,其它默认表示真 */
	public boolean getV1()
	{
		return v1;
	}

	/** @param v1 1字节布尔,0表示假,1表示真,其它默认表示真 */
	public void setV1(boolean v1)
	{
		this.v1 = v1;
	}

	/** @return 1字节整数 */
	public byte getV2()
	{
		return v2;
	}

	/** @param v2 1字节整数 */
	public void setV2(byte v2)
	{
		this.v2 = v2;
	}

	/** @return 2字节整数 */
	public short getV3()
	{
		return v3;
	}

	/** @param v3 2字节整数 */
	public void setV3(short v3)
	{
		this.v3 = v3;
	}

	/** @return 4字节整数 */
	public int getV4()
	{
		return v4;
	}

	/** @param v4 4字节整数 */
	public void setV4(int v4)
	{
		this.v4 = v4;
	}

	/** @return 8字节整数 */
	public long getV5()
	{
		return v5;
	}

	/** @param v5 8字节整数 */
	public void setV5(long v5)
	{
		this.v5 = v5;
	}

	/** @return 4字节浮点数 */
	public float getV6()
	{
		return v6;
	}

	/** @param v6 4字节浮点数 */
	public void setV6(float v6)
	{
		this.v6 = v6;
	}

	/** @return 8字节浮点数 */
	public double getV7()
	{
		return v7;
	}

	/** @param v7 8字节浮点数 */
	public void setV7(double v7)
	{
		this.v7 = v7;
	}

	/** @return 二进制数据(Octets) */
	public Octets getV8()
	{
		return v8;
	}

	/** @param v8 二进制数据(Octets) */
	public void setV8(Octets v8)
	{
		this.v8 = (v8 != null ? v8 : new Octets(5));
	}

	/** 二进制数据(Octets) */
	public void marshalV8(Bean<?> _b_)
	{
		OctetsStream _os_ = OctetsStream.wrap(this.v8);
		_os_.resize(0);
		_os_.reserve(_b_.initSize());
		this.v8 = _os_;
		_b_.marshal(_os_);
	}

	/** 二进制数据(Octets) */
	public <B extends Bean<B>> B unmarshalV8(B _b_) throws MarshalException
	{
		_b_.unmarshal(OctetsStream.wrap(this.v8));
		return _b_;
	}

	/** 二进制数据(Octets) */
	public DynBean unmarshalV8() throws MarshalException
	{
		DynBean _b_ = new DynBean();
		_b_.unmarshal(OctetsStream.wrap(this.v8));
		return _b_;
	}

	/** @return 字符串(String) */
	public String getV9()
	{
		return v9;
	}

	/** @param v9 字符串(String) */
	public void setV9(String v9)
	{
		this.v9 = (v9 != null ? v9 : "");
	}

	/** @return 数组容器(ArrayList) */
	public ArrayList<Boolean> getV10()
	{
		return v10;
	}

	/** @return 链表容器(LinkedList) */
	public LinkedList<Byte> getV11()
	{
		return v11;
	}

	/** @return 队列容器(ArrayDeque) */
	public ArrayDeque<Integer> getV12()
	{
		return v12;
	}

	/** @return 无序集合容器(HashSet) */
	public HashSet<Long> getV13()
	{
		return v13;
	}

	/** @return 排序集合容器(TreeSet) */
	public TreeSet<Float> getV14()
	{
		return v14;
	}

	/** @return 有序集合容器(LinkedHashSet) */
	public LinkedHashSet<Double> getV15()
	{
		return v15;
	}

	/** @return 无序映射容器(HashMap) */
	public HashMap<Long, String> getV16()
	{
		return v16;
	}

	/** @return 排序映射容器(TreeMap) */
	public TreeMap<TestBean, Boolean> getV17()
	{
		return v17;
	}

	/** @return 有序映射容器(LinkedHashMap) */
	public LinkedHashMap<Octets, TestBean> getV18()
	{
		return v18;
	}

	/** @return 嵌入其它bean */
	public TestBean getV19()
	{
		return v19;
	}

	/** @return 非序列化字段 */
	public java.lang.String getV20()
	{
		return v20;
	}

	/** @param v20 非序列化字段 */
	public void setV20(java.lang.String v20)
	{
		this.v20 = v20;
	}

	@Override
	public int type()
	{
		return BEAN_TYPE;
	}

	@Override
	public String typeName()
	{
		return BEAN_TYPENAME;
	}

	@Override
	public TestType stub()
	{
		return BEAN_STUB;
	}

	@Override
	public TestType create()
	{
		return new TestType();
	}

	@Override
	public int initSize()
	{
		return 256;
	}

	@Override
	public int maxSize()
	{
		return 65536;
	}

	@Override
	public OctetsStream marshal(OctetsStream _s_)
	{
		if(this.v1) _s_.marshal2(0x0401);
		if(this.v2 != 0) _s_.marshal1((byte)0x08).marshal(this.v2);
		if(this.v3 != 0) _s_.marshal1((byte)0x0c).marshal(this.v3);
		if(this.v4 != 0) _s_.marshal1((byte)0x10).marshal(this.v4);
		if(this.v5 != 0) _s_.marshal1((byte)0x14).marshal(this.v5);
		if(this.v6 != 0) _s_.marshal2(0x1b08).marshal(this.v6);
		if(this.v7 != 0) _s_.marshal2(0x1f09).marshal(this.v7);
		if(!this.v8.empty()) _s_.marshal1((byte)0x21).marshal(this.v8);
		if(!this.v9.isEmpty()) _s_.marshal1((byte)0x25).marshal(this.v9);
		if(!this.v10.isEmpty())
		{
			_s_.marshal2(0x2b00).marshalUInt(this.v10.size());
			for(Boolean v : this.v10)
				_s_.marshal(v);
		}
		if(!this.v11.isEmpty())
		{
			_s_.marshal2(0x2f00).marshalUInt(this.v11.size());
			for(Byte v : this.v11)
				_s_.marshal(v);
		}
		if(!this.v12.isEmpty())
		{
			_s_.marshal2(0x3300).marshalUInt(this.v12.size());
			for(Integer v : this.v12)
				_s_.marshal(v);
		}
		if(!this.v13.isEmpty())
		{
			_s_.marshal2(0x3700).marshalUInt(this.v13.size());
			for(Long v : this.v13)
				_s_.marshal(v);
		}
		if(!this.v14.isEmpty())
		{
			_s_.marshal2(0x3b04).marshalUInt(this.v14.size());
			for(Float v : this.v14)
				_s_.marshal(v);
		}
		if(!this.v15.isEmpty())
		{
			_s_.marshal2(0x3f05).marshalUInt(this.v15.size());
			for(Double v : this.v15)
				_s_.marshal(v);
		}
		if(!this.v16.isEmpty())
		{
			_s_.marshal2(0x4341).marshalUInt(this.v16.size());
			for(Entry<Long, String> e : this.v16.entrySet())
				_s_.marshal(e.getKey()).marshal(e.getValue());
		}
		if(!this.v17.isEmpty())
		{
			_s_.marshal2(0x4750).marshalUInt(this.v17.size());
			for(Entry<TestBean, Boolean> e : this.v17.entrySet())
				_s_.marshal(e.getKey()).marshal(e.getValue());
		}
		if(!this.v18.isEmpty())
		{
			_s_.marshal2(0x4b4a).marshalUInt(this.v18.size());
			for(Entry<Octets, TestBean> e : this.v18.entrySet())
				_s_.marshal(e.getKey()).marshal(e.getValue());
		}
		{
			int _n_ = _s_.size();
			this.v19.marshal(_s_.marshal1((byte)0x4e));
			if(_s_.size() - _n_ < 3) _s_.resize(_n_);
		}
		return _s_.marshalZero();
	}

	@Override
	public OctetsStream unmarshal(OctetsStream _s_) throws MarshalException
	{
		for(;;) { int _i_ = _s_.unmarshalInt1() & 0xff, _t_ = _i_ & 3; if((_i_ >>= 2) == 63) _i_ += _s_.unmarshalInt1(); switch(_i_)
		{
			case 0: return _s_;
			case 1: this.v1 = (_s_.unmarshalInt(_t_) != 0); break;
			case 2: this.v2 = (byte)_s_.unmarshalInt(_t_); break;
			case 3: this.v3 = (short)_s_.unmarshalInt(_t_); break;
			case 4: this.v4 = _s_.unmarshalInt(_t_); break;
			case 5: this.v5 = _s_.unmarshalLong(_t_); break;
			case 6: this.v6 = _s_.unmarshalFloat(_t_); break;
			case 7: this.v7 = _s_.unmarshalDouble(_t_); break;
			case 8: _s_.unmarshal(this.v8, _t_); break;
			case 9: this.v9 = _s_.unmarshalString(_t_); break;
			case 10:
			{
				this.v10.clear();
				if(_t_ != 3) { _s_.unmarshalSkipVar(_t_); break; }
				_t_ = _s_.unmarshalInt1();
				if((_t_ >> 3) != 0) { _s_.unmarshalSkipVarSub(_t_); break; }
				_t_ &= 7;
				int _n_ = _s_.unmarshalUInt();
				this.v10.ensureCapacity(_n_ < 1000 ? _n_ : 1000);
				for(; _n_ > 0; --_n_)
					this.v10.add((_s_.unmarshalIntKV(_t_) != 0));
			} break;
			case 11:
			{
				this.v11.clear();
				if(_t_ != 3) { _s_.unmarshalSkipVar(_t_); break; }
				_t_ = _s_.unmarshalInt1();
				if((_t_ >> 3) != 0) { _s_.unmarshalSkipVarSub(_t_); break; }
				_t_ &= 7;
				for(int _n_ = _s_.unmarshalUInt(); _n_ > 0; --_n_)
					this.v11.add((byte)_s_.unmarshalIntKV(_t_));
			} break;
			case 12:
			{
				this.v12.clear();
				if(_t_ != 3) { _s_.unmarshalSkipVar(_t_); break; }
				_t_ = _s_.unmarshalInt1();
				if((_t_ >> 3) != 0) { _s_.unmarshalSkipVarSub(_t_); break; }
				_t_ &= 7;
				for(int _n_ = _s_.unmarshalUInt(); _n_ > 0; --_n_)
					this.v12.add(_s_.unmarshalIntKV(_t_));
			} break;
			case 13:
			{
				this.v13.clear();
				if(_t_ != 3) { _s_.unmarshalSkipVar(_t_); break; }
				_t_ = _s_.unmarshalInt1();
				if((_t_ >> 3) != 0) { _s_.unmarshalSkipVarSub(_t_); break; }
				_t_ &= 7;
				for(int _n_ = _s_.unmarshalUInt(); _n_ > 0; --_n_)
					this.v13.add(_s_.unmarshalLongKV(_t_));
			} break;
			case 14:
			{
				this.v14.clear();
				if(_t_ != 3) { _s_.unmarshalSkipVar(_t_); break; }
				_t_ = _s_.unmarshalInt1();
				if((_t_ >> 3) != 0) { _s_.unmarshalSkipVarSub(_t_); break; }
				_t_ &= 7;
				for(int _n_ = _s_.unmarshalUInt(); _n_ > 0; --_n_)
					this.v14.add(_s_.unmarshalFloatKV(_t_));
			} break;
			case 15:
			{
				this.v15.clear();
				if(_t_ != 3) { _s_.unmarshalSkipVar(_t_); break; }
				_t_ = _s_.unmarshalInt1();
				if((_t_ >> 3) != 0) { _s_.unmarshalSkipVarSub(_t_); break; }
				_t_ &= 7;
				for(int _n_ = _s_.unmarshalUInt(); _n_ > 0; --_n_)
					this.v15.add(_s_.unmarshalDoubleKV(_t_));
			} break;
			case 16:
			{
				this.v16.clear();
				if(_t_ != 3) { _s_.unmarshalSkipVar(_t_); break; }
				_t_ = _s_.unmarshalInt1();
				if((_t_ >> 6) != 1) { _s_.unmarshalSkipVarSub(_t_); break; }
				int _k_ = (_t_ >> 3) & 7; _t_ &= 7;
				for(int _n_ = _s_.unmarshalUInt(); _n_ > 0; --_n_)
					this.v16.put(_s_.unmarshalLongKV(_k_), _s_.unmarshalStringKV(_t_));
			} break;
			case 17:
			{
				this.v17.clear();
				if(_t_ != 3) { _s_.unmarshalSkipVar(_t_); break; }
				_t_ = _s_.unmarshalInt1();
				if((_t_ >> 6) != 1) { _s_.unmarshalSkipVarSub(_t_); break; }
				int _k_ = (_t_ >> 3) & 7; _t_ &= 7;
				for(int _n_ = _s_.unmarshalUInt(); _n_ > 0; --_n_)
					this.v17.put(_s_.unmarshalBeanKV(new TestBean(), _k_), (_s_.unmarshalIntKV(_t_) != 0));
			} break;
			case 18:
			{
				this.v18.clear();
				if(_t_ != 3) { _s_.unmarshalSkipVar(_t_); break; }
				_t_ = _s_.unmarshalInt1();
				if((_t_ >> 6) != 1) { _s_.unmarshalSkipVarSub(_t_); break; }
				int _k_ = (_t_ >> 3) & 7; _t_ &= 7;
				for(int _n_ = _s_.unmarshalUInt(); _n_ > 0; --_n_)
					this.v18.put(_s_.unmarshalOctetsKV(_k_), _s_.unmarshalBeanKV(new TestBean(), _t_));
			} break;
			case 19: _s_.unmarshalBean(this.v19, _t_); break;
			default: _s_.unmarshalSkipVar(_t_);
		}}
	}

	@Override
	public TestType clone()
	{
		return new TestType(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18, v19, v20);
	}

	@Override
	public int hashCode()
	{
		int _h_ = (int)serialVersionUID;
		_h_ = _h_ * 31 + 1 + (this.v1 ? 0xcafebabe : 0xdeadbeef);
		_h_ = _h_ * 31 + 1 + this.v2;
		_h_ = _h_ * 31 + 1 + this.v3;
		_h_ = _h_ * 31 + 1 + this.v4;
		_h_ = _h_ * 31 + 1 + (int)this.v5;
		_h_ = _h_ * 31 + 1 + Float.floatToRawIntBits(this.v6);
		_h_ = _h_ * 31 + 1 + (int)((Double.doubleToRawLongBits(this.v7) * 0x100000001L) >> 32);
		_h_ = _h_ * 31 + 1 + this.v8.hashCode();
		_h_ = _h_ * 31 + 1 + this.v9.hashCode();
		_h_ = _h_ * 31 + 1 + this.v10.hashCode();
		_h_ = _h_ * 31 + 1 + this.v11.hashCode();
		_h_ = _h_ * 31 + 1 + this.v12.hashCode();
		_h_ = _h_ * 31 + 1 + this.v13.hashCode();
		_h_ = _h_ * 31 + 1 + this.v14.hashCode();
		_h_ = _h_ * 31 + 1 + this.v15.hashCode();
		_h_ = _h_ * 31 + 1 + this.v16.hashCode();
		_h_ = _h_ * 31 + 1 + this.v17.hashCode();
		_h_ = _h_ * 31 + 1 + this.v18.hashCode();
		_h_ = _h_ * 31 + 1 + this.v19.hashCode();
		return _h_;
	}

	@Override
	public boolean equals(Object o)
	{
		if(o == this) return true;
		if(!(o instanceof TestType)) return false;
		TestType _b_ = (TestType)o;
		if(this.v1 != _b_.v1) return false;
		if(this.v2 != _b_.v2) return false;
		if(this.v3 != _b_.v3) return false;
		if(this.v4 != _b_.v4) return false;
		if(this.v5 != _b_.v5) return false;
		if(this.v6 != _b_.v6) return false;
		if(this.v7 != _b_.v7) return false;
		if(!this.v8.equals(_b_.v8)) return false;
		if(!this.v9.equals(_b_.v9)) return false;
		if(!this.v10.equals(_b_.v10)) return false;
		if(!this.v11.equals(_b_.v11)) return false;
		if(!this.v12.equals(_b_.v12)) return false;
		if(!this.v13.equals(_b_.v13)) return false;
		if(!this.v14.equals(_b_.v14)) return false;
		if(!this.v15.equals(_b_.v15)) return false;
		if(!this.v16.equals(_b_.v16)) return false;
		if(!this.v17.equals(_b_.v17)) return false;
		if(!this.v18.equals(_b_.v18)) return false;
		if(!this.v19.equals(_b_.v19)) return false;
		return true;
	}

	@Override
	public int compareTo(TestType _b_)
	{
		if(_b_ == this) return 0;
		if(_b_ == null) return 1;
		int _c_;
		_c_ = (this.v1 == _b_.v1 ? 0 : (this.v1 ? 1 : -1)); if(_c_ != 0) return _c_;
		_c_ = this.v2 - _b_.v2; if(_c_ != 0) return _c_;
		_c_ = this.v3 - _b_.v3; if(_c_ != 0) return _c_;
		_c_ = this.v4 - _b_.v4; if(_c_ != 0) return _c_;
		_c_ = Long.signum(this.v5 - _b_.v5); if(_c_ != 0) return _c_;
		_c_ = Float.compare(this.v6, _b_.v6); if(_c_ != 0) return _c_;
		_c_ = Double.compare(this.v7, _b_.v7); if(_c_ != 0) return _c_;
		_c_ = this.v8.compareTo(_b_.v8); if(_c_ != 0) return _c_;
		_c_ = this.v9.compareTo(_b_.v9); if(_c_ != 0) return _c_;
		_c_ = Util.compareTo(this.v10, _b_.v10); if(_c_ != 0) return _c_;
		_c_ = Util.compareTo(this.v11, _b_.v11); if(_c_ != 0) return _c_;
		_c_ = Util.compareTo(this.v12, _b_.v12); if(_c_ != 0) return _c_;
		_c_ = Util.compareTo(this.v13, _b_.v13); if(_c_ != 0) return _c_;
		_c_ = Util.compareTo(this.v14, _b_.v14); if(_c_ != 0) return _c_;
		_c_ = Util.compareTo(this.v15, _b_.v15); if(_c_ != 0) return _c_;
		_c_ = Util.compareTo(this.v16, _b_.v16); if(_c_ != 0) return _c_;
		_c_ = Util.compareTo(this.v17, _b_.v17); if(_c_ != 0) return _c_;
		_c_ = Util.compareTo(this.v18, _b_.v18); if(_c_ != 0) return _c_;
		_c_ = this.v19.compareTo(_b_.v19); if(_c_ != 0) return _c_;
		return 0;
	}

	@Override
	public String toString()
	{
		StringBuilder _s_ = new StringBuilder(16 + 256 * 2).append('{');
		_s_.append(this.v1).append(',');
		_s_.append(this.v2).append(',');
		_s_.append(this.v3).append(',');
		_s_.append(this.v4).append(',');
		_s_.append(this.v5).append(',');
		_s_.append(this.v6).append(',');
		_s_.append(this.v7).append(',');
		_s_.append(this.v8).append(',');
		_s_.append(this.v9).append(',');
		Util.append(_s_, this.v10);
		Util.append(_s_, this.v11);
		Util.append(_s_, this.v12);
		Util.append(_s_, this.v13);
		Util.append(_s_, this.v14);
		Util.append(_s_, this.v15);
		Util.append(_s_, this.v16);
		Util.append(_s_, this.v17);
		Util.append(_s_, this.v18);
		_s_.append(this.v19).append(',');
		_s_.append(this.v20).append(',');
		_s_.setLength(_s_.length() - 1);
		return _s_.append('}').toString();
	}

	// attach java code here

	@Override
	public Safe safe(SContext.Safe<?> _parent_)
	{
		return new Safe(this, _parent_);
	}

	@Override
	public Safe safe()
	{
		return new Safe(this, null);
	}

	public static final class Safe extends SContext.Safe<TestType>
	{
		private SSet<Long, Long> CACHE_v13;
		private SSSet<Float, Float> CACHE_v14;
		private SSet<Double, Double> CACHE_v15;
		private SMap<Long, String, String> CACHE_v16;
		private SSMap<TestBean, Boolean, Boolean> CACHE_v17;
		private SMap<Octets, TestBean, TestBean.Safe> CACHE_v18;

		private Safe(TestType bean, SContext.Safe<?> _parent_)
		{
			super(bean, _parent_);
		}

		/** @return 1字节布尔,0表示假,1表示真,其它默认表示真 */
		public boolean getV1()
		{
			return _bean.v1;
		}

		/** @param v1 1字节布尔,0表示假,1表示真,其它默认表示真 */
		public void setV1(boolean v1)
		{
			if(initSContext()) _sctx.addOnRollback(new SBase.SBoolean(_bean, FIELD_v1, _bean.v1));
			_bean.v1 = v1;
		}

		/** @return 1字节整数 */
		public byte getV2()
		{
			return _bean.v2;
		}

		/** @param v2 1字节整数 */
		public void setV2(byte v2)
		{
			if(initSContext()) _sctx.addOnRollback(new SBase.SByte(_bean, FIELD_v2, _bean.v2));
			_bean.v2 = v2;
		}

		/** @return 2字节整数 */
		public short getV3()
		{
			return _bean.v3;
		}

		/** @param v3 2字节整数 */
		public void setV3(short v3)
		{
			if(initSContext()) _sctx.addOnRollback(new SBase.SShort(_bean, FIELD_v3, _bean.v3));
			_bean.v3 = v3;
		}

		/** @return 4字节整数 */
		public int getV4()
		{
			return _bean.v4;
		}

		/** @param v4 4字节整数 */
		public void setV4(int v4)
		{
			if(initSContext()) _sctx.addOnRollback(new SBase.SInteger(_bean, FIELD_v4, _bean.v4));
			_bean.v4 = v4;
		}

		/** @return 8字节整数 */
		public long getV5()
		{
			return _bean.v5;
		}

		/** @param v5 8字节整数 */
		public void setV5(long v5)
		{
			if(initSContext()) _sctx.addOnRollback(new SBase.SLong(_bean, FIELD_v5, _bean.v5));
			_bean.v5 = v5;
		}

		/** @return 4字节浮点数 */
		public float getV6()
		{
			return _bean.v6;
		}

		/** @param v6 4字节浮点数 */
		public void setV6(float v6)
		{
			if(initSContext()) _sctx.addOnRollback(new SBase.SFloat(_bean, FIELD_v6, _bean.v6));
			_bean.v6 = v6;
		}

		/** @return 8字节浮点数 */
		public double getV7()
		{
			return _bean.v7;
		}

		/** @param v7 8字节浮点数 */
		public void setV7(double v7)
		{
			if(initSContext()) _sctx.addOnRollback(new SBase.SDouble(_bean, FIELD_v7, _bean.v7));
			_bean.v7 = v7;
		}

		/** @return 二进制数据(Octets) */
		public Octets getV8()
		{
			return _bean.v8.clone();
		}

		/** @param v8 二进制数据(Octets) */
		public void setV8(Octets v8)
		{
			if(initSContext()) _sctx.addOnRollback(new SBase.SOctets(_bean, FIELD_v8, _bean.v8, false));
			_bean.v8 = (v8 != null ? v8.clone() : new Octets(5));
		}

		/** 二进制数据(Octets) */
		public byte[] copyOfV8()
		{
			return _bean.v8.getBytes();
		}

		/** 二进制数据(Octets) */
		public void marshalV8(Bean<?> _b_)
		{
			if(initSContext()) _sctx.addOnRollback(new SBase.SOctets(_bean, FIELD_v8, _bean.v8, false));
			_bean.v8 = _b_.marshal(new OctetsStream(_b_.initSize()));
		}

		/** 二进制数据(Octets) */
		public <B extends Bean<B>> B unmarshalV8(B _b_) throws MarshalException
		{
			return _bean.unmarshalV8(_b_);
		}

		/** 二进制数据(Octets) */
		public DynBean unmarshalV8() throws MarshalException
		{
			return _bean.unmarshalV8();
		}

		/** @return 二进制数据(Octets) */
		@Deprecated
		public Octets unsafeV8()
		{
			return _bean.v8;
		}

		/** @return 字符串(String) */
		public String getV9()
		{
			return _bean.v9;
		}

		/** @param v9 字符串(String) */
		public void setV9(String v9)
		{
			if(initSContext()) _sctx.addOnRollback(new SBase.SObject(_bean, FIELD_v9, _bean.v9));
			_bean.v9 = (v9 != null ? v9 : "");
		}

		/** @return 数组容器(ArrayList) */
		public SList<Boolean, Boolean> getV10()
		{
			return new SList<>(this, _bean.v10);
		}

		/** @return 数组容器(ArrayList) */
		@Deprecated
		public ArrayList<Boolean> unsafeV10()
		{
			return _bean.v10;
		}

		/** @return 链表容器(LinkedList) */
		public SList<Byte, Byte> getV11()
		{
			return new SList<>(this, _bean.v11);
		}

		/** @return 链表容器(LinkedList) */
		@Deprecated
		public LinkedList<Byte> unsafeV11()
		{
			return _bean.v11;
		}

		/** @return 队列容器(ArrayDeque) */
		public SDeque<Integer, Integer> getV12()
		{
			return new SDeque<>(this, _bean.v12);
		}

		/** @return 队列容器(ArrayDeque) */
		@Deprecated
		public ArrayDeque<Integer> unsafeV12()
		{
			return _bean.v12;
		}

		/** 无序集合容器(HashSet) */
		public static void onListenV13(SSetListener<Long> _listener_)
		{
			LISTENER_v13 = _listener_;
		}

		/** @return 无序集合容器(HashSet) */
		public SSet<Long, Long> getV13()
		{
			if(CACHE_v13 == null) CACHE_v13 = new SSet<>(this, _bean.v13, LISTENER_v13);
			return CACHE_v13;
		}

		/** @return 无序集合容器(HashSet) */
		@Deprecated
		public HashSet<Long> unsafeV13()
		{
			return _bean.v13;
		}

		/** 排序集合容器(TreeSet) */
		public static void onListenV14(SSetListener<Float> _listener_)
		{
			LISTENER_v14 = _listener_;
		}

		/** @return 排序集合容器(TreeSet) */
		public SSSet<Float, Float> getV14()
		{
			if(CACHE_v14 == null) CACHE_v14 = new SSSet<>(this, _bean.v14, LISTENER_v14);
			return CACHE_v14;
		}

		/** @return 排序集合容器(TreeSet) */
		@Deprecated
		public TreeSet<Float> unsafeV14()
		{
			return _bean.v14;
		}

		/** 有序集合容器(LinkedHashSet) */
		public static void onListenV15(SSetListener<Double> _listener_)
		{
			LISTENER_v15 = _listener_;
		}

		/** @return 有序集合容器(LinkedHashSet) */
		public SSet<Double, Double> getV15()
		{
			if(CACHE_v15 == null) CACHE_v15 = new SSet<>(this, _bean.v15, LISTENER_v15);
			return CACHE_v15;
		}

		/** @return 有序集合容器(LinkedHashSet) */
		@Deprecated
		public LinkedHashSet<Double> unsafeV15()
		{
			return _bean.v15;
		}

		/** 无序映射容器(HashMap) */
		public static void onListenV16(SMapListener<Long, String> _listener_)
		{
			LISTENER_v16 = _listener_;
		}

		/** @return 无序映射容器(HashMap) */
		public SMap<Long, String, String> getV16()
		{
			if(CACHE_v16 == null) CACHE_v16 = new SMap<>(this, _bean.v16, LISTENER_v16);
			return CACHE_v16;
		}

		/** @return 无序映射容器(HashMap) */
		@Deprecated
		public HashMap<Long, String> unsafeV16()
		{
			return _bean.v16;
		}

		/** 排序映射容器(TreeMap) */
		public static void onListenV17(SMapListener<TestBean, Boolean> _listener_)
		{
			LISTENER_v17 = _listener_;
		}

		/** @return 排序映射容器(TreeMap) */
		public SSMap<TestBean, Boolean, Boolean> getV17()
		{
			if(CACHE_v17 == null) CACHE_v17 = new SSMap<>(this, _bean.v17, LISTENER_v17);
			return CACHE_v17;
		}

		/** @return 排序映射容器(TreeMap) */
		@Deprecated
		public TreeMap<TestBean, Boolean> unsafeV17()
		{
			return _bean.v17;
		}

		/** 有序映射容器(LinkedHashMap) */
		public static void onListenV18(SMapListener<Octets, TestBean> _listener_)
		{
			LISTENER_v18 = _listener_;
		}

		/** @return 有序映射容器(LinkedHashMap) */
		public SMap<Octets, TestBean, TestBean.Safe> getV18()
		{
			if(CACHE_v18 == null) CACHE_v18 = new SMap<>(this, _bean.v18, LISTENER_v18);
			return CACHE_v18;
		}

		/** @return 有序映射容器(LinkedHashMap) */
		@Deprecated
		public LinkedHashMap<Octets, TestBean> unsafeV18()
		{
			return _bean.v18;
		}

		/** @return 嵌入其它bean */
		public TestBean.Safe getV19()
		{
			return _bean.v19.safe(this);
		}

		/** @return 嵌入其它bean */
		@Deprecated
		public TestBean unsafeV19()
		{
			return _bean.v19;
		}

		/** @return 非序列化字段 */
		public java.lang.String getV20()
		{
			return _bean.v20;
		}

		/** @param v20 非序列化字段 */
		public void setV20(java.lang.String v20)
		{
			if(initSContext()) _sctx.addOnRollback(new SBase.SObject(_bean, FIELD_v20, _bean.v20));
			_bean.v20 = v20;
		}
	}
}
