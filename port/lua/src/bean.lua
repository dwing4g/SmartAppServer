-- UTF-8 without BOM
-- This file is generated by genbeans tool. Do NOT edit it!

local num, str, bool, vec, map = 0, 1, 2, 3, 4
return require "util".initBeans {
	TestBean = { __type = 1, __base = {
		TEST_CONST1 = 5,
		TEST_CONST2 = "test_const2",
		[  1] = { name = "value1", type = num },
		[  2] = { name = "value2", type = num },
	}},
	TestType = { __type = 2, __base = {
		[  1] = { name = "v1", type = bool },
		[  2] = { name = "v2", type = num },
		[  3] = { name = "v3", type = num },
		[  4] = { name = "v4", type = num },
		[  5] = { name = "v5", type = num },
		[  6] = { name = "v6", type = num },
		[  7] = { name = "v7", type = num },
		[  8] = { name = "v8", type = str },
		[  9] = { name = "v9", type = str },
		[ 10] = { name = "v10", type = vec, value = bool },
		[ 11] = { name = "v11", type = vec, value = num },
		[ 12] = { name = "v12", type = vec, value = num },
		[ 13] = { name = "v13", type = vec, value = num },
		[ 14] = { name = "v14", type = vec, value = num },
		[ 15] = { name = "v15", type = vec, value = num },
		[ 16] = { name = "v16", type = map, key = num, value = str },
		[ 17] = { name = "v17", type = map, key = "TestBean", value = bool },
		[ 18] = { name = "v18", type = map, key = str, value = "TestBean" },
		[ 19] = { name = "v19", type = "TestBean" },
	}},
	TestEmpty = { __type = 3, __base = {
	}},
}

---@module bean

---bean的注释
-- @field [parent=#bean] #TestBean TestBean

---@callof #TestBean
-- @return #TestBean

---字段的注释
-- @field [parent=#TestBean] #number value1

---
-- @field [parent=#TestBean] #number value2

---测试生成所有支持的类型
-- @field [parent=#bean] #TestType TestType

---@callof #TestType
-- @return #TestType

---1字节布尔,0表示假,1表示真,其它默认表示真
-- @field [parent=#TestType] #boolean v1

---1字节整数
-- @field [parent=#TestType] #number v2

---2字节整数
-- @field [parent=#TestType] #number v3

---4字节整数
-- @field [parent=#TestType] #number v4

---8字节整数
-- @field [parent=#TestType] #number v5

---4字节浮点数
-- @field [parent=#TestType] #number v6

---8字节浮点数
-- @field [parent=#TestType] #number v7

---二进制数据(Octets)
-- @field [parent=#TestType] #string v8

---字符串(String)
-- @field [parent=#TestType] #string v9

---数组容器(ArrayList)
-- @field [parent=#TestType] #list<#boolean> v10

---链表容器(LinkedList)
-- @field [parent=#TestType] #list<#number> v11

---队列容器(ArrayDeque)
-- @field [parent=#TestType] #list<#number> v12

---无序集合容器(HashSet)
-- @field [parent=#TestType] #list<#number> v13

---排序集合容器(TreeSet)
-- @field [parent=#TestType] #list<#number> v14

---有序集合容器(LinkedHashSet)
-- @field [parent=#TestType] #list<#number> v15

---无序映射容器(HashMap)
-- @field [parent=#TestType] #map<#number,#string> v16

---排序映射容器(TreeMap)
-- @field [parent=#TestType] #map<#TestBean,#boolean> v17

---有序映射容器(LinkedHashMap)
-- @field [parent=#TestType] #map<#string,#TestBean> v18

---嵌入其它bean
-- @field [parent=#TestType] #TestBean v19

---测试空bean
-- @field [parent=#bean] #TestEmpty TestEmpty

---@callof #TestEmpty
-- @return #TestEmpty
