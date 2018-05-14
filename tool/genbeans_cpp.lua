-- UTF-8 without BOM
local type = type
local string = string
local char = string.char
local format = string.format
local error = error
local pairs = pairs
local table = table
local concat = table.concat
local sort = table.sort
local ipairs = ipairs
local print = print
local open = io.open
local tostring = tostring
local arg = {...}

local namespace = arg[1] -- for bean namespace
if not namespace then error("ERROR: arg[1] must be namespace") end

local template_bean = [=[
#pragma once

#include "marshal_bean.h"
#(bean.includes)
namespace ]=] .. namespace .. [=[

{
	class #(bean.name) : public BeanMarshal
	{
	public:
		virtual void OnProcess(void* context) override
		{
		}

		// THE CODE BELOW CAN BE REGENERATED BY GENBEANS TOOL. DO NOT EDIT!#(bean.comment)
		enum { BEAN_TYPE = #(bean.type) };
#{#		static const #(var.type_c) #(var.name)#(var.value);#(var.comment)
#}#
#(#		/*#(var.id3)*/ #(var.type) #(var.name);#(var.comment)
#)##<#
		#(bean.name)() : BeanMarshal()#(#
			, #(var.name)(#(var.new))#)# {}

		#(bean.name)(#(##(var.type_i) _#(var.name)_, #)#) : BeanMarshal()#(#
			, #(var.name)(_#(var.name)_)#)# {}

		template<typename T>
		#(bean.name)(const T& _b_)
		{
#(#			#(var.assign);
#)#		}

		template<typename T>
		#(bean.name)& operator=(const T& _b_)
		{
#(#			#(var.assign);
#)#		}

#>#		virtual void Reset() override
		{
#(#			#(var.reset);
#)#		}

		virtual unsigned int GetType() const override
		{
			return BEAN_TYPE;
		}

		virtual const char* GetTypeName() const override
		{
			return "#(bean.name)";
		}

		virtual size_t GetMaxSize() const override
		{
			return #(bean.maxsize);
		}

		virtual #(bean.name)* Create() const override
		{
			return new #(bean.name)();
		}

		virtual #(bean.name)* Clone() const override
		{
			return new #(bean.name)(*this);
		}

		virtual BeanOctetsStream& Marshal(BeanOctetsStream& _s_) const override
		{
#(#			#(var.marshal)
#)#			return _s_.push_byte((char)0);
		}

		virtual BeanOctetsStream& Unmarshal(BeanOctetsStream& _s_) override
		{
			for(;;) { int _i_ = _s_.pop_byte(), _t_ = _i_ & 3; if((_i_ >>= 2) == 63) _i_ += _s_.pop_byte(); switch(_i_)
			{
				case 0: return _s_;
#(#				#(var.unmarshal) break;
#)#				default: _s_.UnmarshalSkipVar(_t_); break;
			}}
		}

		virtual void ToString(std::stringstream& _s_) const override
		{
			_s_ << '{';#<#
#(#			#(var.tostring);
#)#			_s_.seekp(-1, std::ios::cur);#>#
			_s_ << '}';
		}
	};
#(bean.attach_cpp)}
]=]

local template_allbeans = [=[
// This file is generated by genbeans tool. Do NOT edit it!
#pragma once

#(##include "#(bean.name).h"
#)#
namespace ]=] .. namespace .. [=[

{#[#
	inline void InitAllBeans()
	{
#(#		BeanMarshal::Register(new #(bean.name));
#)#	}
#]#}
]=]

local typedef = {}
local function merge(ta, tb)
	local r = {}
	for k, v in pairs(ta) do r[k] = v end
	for k, v in pairs(tb) do r[k] = v end
	return r
end
local function typename(var, t)
	local def = typedef[t]
	if not def then return t end
	if type(def) == "function" then
		local t = { id = 0 } def(t, 0) def = t
	end
	if type(def) == "table" then return type(def.type) == "string" and def.type or def.type(var) end
	error("ERROR: unknown typename(" .. var .. ", " .. t .. ")")
end
local function subtypename(var, t)
	local def = typedef[t]
	if not def then return t end
	if type(def) == "function" then
		local t = { id = 0 } def(t, 0) def = t
	end
	if type(def) == "table" then return type(def.type_o) == "string" and def.type_o or def.type_o(var) end
	error("ERROR: unknown subtypename(" .. var .. ", " .. t .. ")")
end
local function subtypename_new(var, t)
	if not var then return ", " end
	return subtypename(var, t)
end
local function subtypeid(t)
	local def = typedef[t]
	if not def then def = typedef.bean end
	if type(def) == "function" then local t = { id = 0 } def(t, 0) return t.subtypeid end
	if type(def) == "table" then return def.subtypeid end
	error("ERROR: unknown subtypeid(" .. t .. ")")
end
local function get_unmarshal_kv(var, kv, t)
	local s = (typedef[var[kv]] or typedef.bean).unmarshal_kv
	return type(s) == "string" and s or s(var, kv, t)
end
typedef.byte =
{
	type = "char", type_i = "char", type_o = "char", type_c = "char",
	subtypeid = 0,
	new = "0",
	assign = "#(var.name) = (#(var.type))_b_.#(var.name)",
	reset = "#(var.name) = 0",
	marshal = function(var)
		return var.id < 63 and
			format("if(#(var.name) != 0) _s_.push_byte((char)0x%02x) << #(var.name);", var.id * 4) or
			format("if(#(var.name) != 0) _s_.push_int16(0x%04x) << #(var.name);", 0xfc00 + var.id - 63)
	end,
	unmarshal = "case #(var.id): #(var.name) = (#(var.type))_s_.UnmarshalInt(_t_);",
	unmarshal_kv = function(var, kv, t) if kv then return "(" .. typename(var, var[kv]) .. ")_s_.UnmarshalIntKV(" .. t .. ")" end end,
	tostring = "_s_ << #(var.name) << ','",
}
typedef.char = typedef.byte
typedef.short = merge(typedef.byte, { type = "short", type_i = "short", type_o = "short", type_c = "short" })
typedef.int = merge(typedef.byte,
{
	type = "int", type_i = "int", type_o = "int", type_c = "int",
	unmarshal = "case #(var.id): #(var.name) = _s_.UnmarshalInt(_t_);",
	unmarshal_kv = function(var, kv, t) if kv then return "_s_.UnmarshalIntKV(" .. t .. ")" end end,
})
typedef.long = merge(typedef.byte,
{
	type = "int64_t", type_i = "int64_t", type_o = "int64_t", type_c = "int64_t",
	unmarshal = "case #(var.id): #(var.name) = _s_.UnmarshalLong(_t_);",
	unmarshal_kv = function(var, kv, t) if kv then return "_s_.UnmarshalLongKV(" .. t .. ")" end end,
})
typedef.bool = merge(typedef.byte,
{
	type = "bool", type_i = "bool", type_o = "bool", type_c = "bool",
	new = "false",
	reset = "#(var.name) = false",
	marshal = function(var)
		return var.id < 63 and
			format("if(#(var.name)) _s_.push_int16(0x%04x);", var.id * 0x400 + 1) or
			format("if(#(var.name)) _s_.push_int24(0x%06x);", 0xfc0001 + (var.id - 63) * 0x100)
	end,
	unmarshal = "case #(var.id): #(var.name) = (_s_.UnmarshalLong(_t_) != 0);",
	unmarshal_kv = function(var, kv, t) if kv then return "(_s_.UnmarshalLongKV(" .. t .. ") != 0)" end end,
})
typedef.float = merge(typedef.byte,
{
	type = "float", type_i = "float", type_o = "float", type_c = "float",
	subtypeid = 4,
	marshal = function(var)
		return var.id < 63 and
			format("if(#(var.name) != 0) _s_.push_int16(0x%04x) << #(var.name);", var.id * 0x400 + 0x308) or
			format("if(#(var.name) != 0) _s_.push_int24(0x%06x) << #(var.name);", 0xff0008 + (var.id - 63) * 0x100)
	end,
	unmarshal = "case #(var.id): #(var.name) = _s_.UnmarshalFloat(_t_);",
	unmarshal_kv = function(var, kv, t) if kv then return "_s_.UnmarshalFloatKV(" .. t .. ")" end end,
})
typedef.double = merge(typedef.float,
{
	type = "double", type_i = "double", type_o = "double", type_c = "double",
	subtypeid = 5,
	marshal = function(var)
		return var.id < 63 and
			format("if(#(var.name) != 0) _s_.push_int16(0x%04x) << #(var.name);", var.id * 0x400 + 0x309) or
			format("if(#(var.name) != 0) _s_.push_int24(0x%06x) << #(var.name);", 0xff0009 + (var.id - 63) * 0x100)
	end,
	unmarshal = "case #(var.id): #(var.name) = _s_.UnmarshalDouble(_t_);",
	unmarshal_kv = function(var, kv, t) if kv then return "_s_.UnmarshalDoubleKV(" .. t .. ")" end end,
})
typedef.string = merge(typedef.byte,
{
	type = "std::string", type_i = "const std::string&", type_o = "std::string", type_c = "char* const",
	subtypeid = 1,
	new = "",
	assign = "#(var.name) = std::string(_b_.#(var.name))",
	reset = "#(var.name).clear()",
	marshal = function(var)
		return var.id < 63 and
			format("if(!#(var.name).empty()) _s_.push_byte((char)0x%02x) << #(var.name);", var.id * 4 + 1) or
			format("if(!#(var.name).empty()) _s_.push_int16(0x%04x) << #(var.name);", 0xfd00 + var.id - 63)
	end,
	unmarshal = "case #(var.id): _s_.UnmarshalString(#(var.name), _t_);",
	unmarshal_kv = function(var, kv, t) if kv then return "_s_.UnmarshalStringKV(" .. t .. ")" end end,
})
typedef.octets = merge(typedef.string,
{
	type = "Octets", type_i = "const Octets&", type_o = "Octets",
	new = "#(var.cap)",
	assign = "#(var.name) = Octets(_b_.#(var.name))",
	unmarshal = "case #(var.id): _s_.Unmarshal(#(var.name), _t_);",
	unmarshal_kv = function(var, kv, t) if kv then return "_s_.UnmarshalOctetsKV(" .. t .. ")" end end,
	tostring = "_s_ << '[' << #(var.name).size() << \"],\"",
})
typedef.vector = merge(typedef.octets,
{
	include = { "<vector>" },
	type = function(var) return "std::vector<" .. subtypename(var, var.k) .. ">" end,
	type_i = function(var) return "const std::vector<" .. subtypename(var, var.k) .. ">&" end,
	assign = "#(var.name).assign(_b_.#(var.name).begin(), _b_.#(var.name).end())",
	marshal = function(var)
		return var.id < 63 and
			format([[if(!#(var.name).empty())
			{
				_s_.push_int16(0x%04x).compact_uint32(#(var.name).size());
				for(const auto& _e_ : #(var.name))
					_s_ << _e_;
			}]], var.id * 0x400 + 0x300 + subtypeid(var.k)) or
			format([[if(!#(var.name).empty())
			{
				_s_.push_int24(0x%06x).compact_uint32(#(var.name).size());
				for(const auto& _e_ : #(var.name))
					_s_ << _e_;
			}]], 0xff0000 + (var.id - 63) * 0x100 + subtypeid(var.k))
	end,
	unmarshal = function(var) return format([[case #(var.id):
				{
					#(var.name).clear();
					if(_t_ != 3) { _s_.UnmarshalSkipVar(_t_); break; }
					_t_ = _s_.pop_byte();
					if(_t_ >= 8) { _s_.UnmarshalSkipVarSub(_t_); break; }
					unsigned int n = 0;
					_s_.uncompact_uint32(n);
					#(var.name).reserve(n < 0x10000 ? n : 0x10000);
					for(; n > 0; --n)
						#(var.name).emplace_back(%s);
				}]], get_unmarshal_kv(var, "k", "_t_")) end,
	tostring = [[_s_ << '{';
			for(const auto& _e_ : #(var.name))
				_s_ << _e_ << ',';
			if(!#(var.name).empty())
				_s_.seekp(-1, std::ios::cur);
			_s_ << "},"]]
})
typedef.list = merge(typedef.vector,
{
	include = { "<list>" },
	type = function(var) return "std::list<" .. subtypename(var, var.k) .. ">" end,
	type_i = function(var) return "const std::list<" .. subtypename(var, var.k) .. ">&" end,
	new = "",
	unmarshal = function(var) return format([[case #(var.id):
				{
					#(var.name).clear();
					if(_t_ != 3) { _s_.UnmarshalSkipVar(_t_); break; }
					_t_ = _s_.pop_byte();
					if(_t_ >= 8) { _s_.UnmarshalSkipVarSub(_t_); break; }
					unsigned int n = 0;
					_s_.uncompact_uint32(n);
					for(; n > 0; --n)
						#(var.name).emplace_back(%s);
				}]], get_unmarshal_kv(var, "k", "_t_")) end,
})
typedef.deque = merge(typedef.list,
{
})
typedef.hashset = merge(typedef.vector,
{
	include = { "<unordered_set>" },
	type = function(var) return "std::unordered_set<" .. subtypename(var, var.k) .. ">" end,
	type_i = function(var) return "const std::unordered_set<" .. subtypename(var, var.k) .. ">&" end,
	unmarshal = function(var) return format([[case #(var.id):
				{
					#(var.name).clear();
					if(_t_ != 3) { _s_.UnmarshalSkipVar(_t_); break; }
					_t_ = _s_.pop_byte();
					if(_t_ >= 8) { _s_.UnmarshalSkipVarSub(_t_); break; }
					unsigned int n = 0;
					_s_.uncompact_uint32(n);
					for(; n > 0; --n)
						#(var.name).emplace(%s);
				}]], get_unmarshal_kv(var, "k", "_t_")) end,
})
typedef.treeset = merge(typedef.hashset,
{
	include = { "<set>" },
	type = function(var) return "std::set<" .. subtypename(var, var.k) .. ">" end,
	type_i = function(var) return "const std::set<" .. subtypename(var, var.k) .. ">&" end,
	new = "",
})
typedef.hashmap = merge(typedef.hashset,
{
	include = { "<unordered_map>" },
	type = function(var) return "std::unordered_map<" .. subtypename(var, var.k) .. ", " .. subtypename(var, var.v) .. ">" end,
	type_i = function(var) return "const std::unordered_map<" .. subtypename(var, var.k) .. ", " .. subtypename(var, var.v) .. ">&" end,
	assign = "#(var.name).clear(); #(var.name).insert(_b_.#(var.name).begin(), _b_.#(var.name).end())",
	marshal = function(var)
		return var.id < 63 and
			format([[if(!#(var.name).empty())
			{
				_s_.push_int16(0x%04x).compact_uint32(#(var.name).size());
				for(const auto& _p_ : #(var.name))
					_s_ << _p_.first << _p_.second;
			}]], var.id * 0x400 + 0x340 + subtypeid(var.k) * 8 + subtypeid(var.v), subtypename(var, var.k), subtypename(var, var.v)) or
			format([[if(!#(var.name).empty())
			{
				_s_.push_int16(0x%04x).compact_uint32(#(var.name).size());
				for(const auto& _p_ : #(var.name))
					_s_ << _p_.first << _p_.second;
			}]], 0xff0040 + (var.id - 63) * 0x100 + subtypeid(var.k) * 8 + subtypeid(var.v), subtypename(var, var.k), subtypename(var, var.v))
	end,
	unmarshal = function(var) return format([[case #(var.id):
				{
					#(var.name).clear();
					if(_t_ != 3) { _s_.UnmarshalSkipVar(_t_); break; }
					_t_ = _s_.pop_byte();
					if((_t_ >> 6) != 1) { _s_.UnmarshalSkipVarSub(_t_); break; }
					int _k_ = (_t_ >> 3) & 7; _t_ &= 7;
					unsigned int n = 0;
					_s_.uncompact_uint32(n);
					for(; n > 0; --n)
						#(var.name).emplace(%s, %s);
				}]], get_unmarshal_kv(var, "k", "_k_"), get_unmarshal_kv(var, "v", "_t_")) end,
	tostring = [[_s_ << '{';
			for(const auto& _p_ : #(var.name))
			{
				_s_ << _p_.first << '=';
				_s_ << _p_.second << ',';
			}
			if(!#(var.name).empty())
				_s_.seekp(-1, std::ios::cur);
			_s_ << "},"]]
})
typedef.treemap = merge(typedef.hashmap,
{
	include = { "<map>" },
	type = function(var) return "std::map<" .. subtypename(var, var.k) .. ", " .. subtypename(var, var.v) .. ">" end,
	type_i = function(var) return "const std::map<" .. subtypename(var, var.k) .. ", " .. subtypename(var, var.v) .. ">&" end,
	new = "",
})
typedef.bean = merge(typedef.octets,
{
	type = function(var) return var.type end,
	type_i = function(var) return "const " .. var.type .. "&" end,
	type_o = function(var) return var.type end,
	assign = "#(var.name) = _b_.#(var.name)",
	subtypeid = 2,
	new = "",
	reset = "#(var.name).Reset()",
	marshal = function(var)
		return var.id < 63 and
			format([[{
				auto _n_ = _s_.size();
				_s_.push_byte((char)0x%02x) << #(var.name);
				if(_s_.size() - _n_ < 3) _s_.resize(_n_);
			}]], var.id * 4 + 2) or
			format([[{
				auto _n_ = _s_.size();
				_s_.push_byte((char)0x%02x) << #(var.name);
				if(_s_.size() - _n_ < 3) _s_.resize(_n_);
			}]], 0xfe00 + var.id - 63)
	end,
	unmarshal = "case #(var.id): _s_.UnmarshalBean(#(var.name), _t_);",
	unmarshal_kv = function(var, kv, t) if kv then return "_s_.UnmarshalBeanKV<" .. typename(var, var[kv]) .. ">(" .. t .. ")" end end,
	tostring = [[#(var.name).ToString(_s_);
			_s_ << ',']],
})
typedef.boolean = typedef.bool
typedef.integer = typedef.int
typedef.binary = typedef.octets
typedef.bytes = typedef.octets
typedef.data = typedef.octets
typedef.array = typedef.vector
typedef.arraydeque = typedef.deque
typedef.arraylist = typedef.vector
typedef.linkedlist = typedef.list
typedef.set = typedef.hashset
typedef.linkedset = typedef.hashset
typedef.linkedhashset = typedef.hashset
typedef.map = typedef.hashmap
typedef.linkedmap = typedef.hashmap
typedef.linkedhashmap = typedef.hashmap

local function trim(s)
	return s:gsub("[%c%s]+", "")
end
local function do_var(var)
	if type(var.id) ~= "number" then var.id = -1 end
	if var.id < -1 or var.id > 190 then error("ERROR: normal id=" .. var.id .. " must be in [1, 190]") end
	var.id3 = format("%3d", var.id)
	var.name = trim(var.name)
	var.type = trim(var.type)
	var.include = {}
	if var.comment and #var.comment > 0 then var.comment = " // " .. var.comment:gsub("%c", " ") .. ";" else var.comment = ""  end
	if type(var.value) == "string" then var.value = "\"" .. var.value .. "\"" end
	var.value = var.value and " = " .. var.value or ""
	local basetype
	basetype, var.k, var.v, var.cap = var.type:match "^%s*([%w_%.]+)%s*<?%s*([%w_%.]*)%s*,?%s*([%w_%.]*)%s*>?%s*%(?%s*([%w%._%.]*)%s*%)?%s*$"
	if not var.cap then var.cap = "" end
	var.basetype = basetype
	local def = typedef[basetype]
	if not def and basetype == var.type then
		def = typedef.bean
		var.include[#var.include + 1] = '"' .. basetype .. '.h"'
	end
	if var.v and var.v ~= "" and not typedef[var.v] then
		var.include[#var.include + 1] = '"' .. var.v .. '.h"'
	end
	if type(def) == "table" then
		for k, v in pairs(def) do
			if type(v) == "function" then v = v(var) end
			var[k] = v
		end
	else
		error("ERROR: unknown type: " .. var.type .. " => " .. basetype)
	end
end
local function code_conv(code, prefix, t)
	return code:gsub("#%(" .. prefix .. "%.([%w_]+)%)", function(name) return t[name] end)
end

local name_code = {} -- bean name => bean code
local name_bean = {} -- bean name => bean
local handlers = {} -- selected handler name => handler path
local has_handler -- any selected handler?
local all_handlers = {} -- all handlers name => true
local hdl_names = {} -- handler name => {bean names}
local bean_order = {} -- defined order => bean name
function handler(hdls)
	if not arg[2] then error("ERROR: arg[2] must be handler name(s)") end
	for hdlname in arg[2]:gmatch("([%w_%.]+)") do
		local hdl = hdls[hdlname]
		if not hdl then error("ERROR: not found or unknown handler name: " .. hdlname) end
		for hdlname, hdlpath in pairs(hdl) do
			if type(handlers[hdlname]) ~= "string" then
				handlers[hdlname] = hdlpath
				has_handler = true
			end
		end
	end
	for _, v in pairs(hdls) do
		for k in pairs(v) do
			all_handlers[k] = true
		end
	end
end
local function bean_common(bean)
	bean.name = trim(bean.name)
	if bean.name:find("[^%w_]") or typedef[bean.name] or bean.name == "AllBeans" or bean.name == "AllTables" then error("ERROR: invalid bean.name: " .. bean.name) end
	if name_code[bean.name] then error("ERROR: duplicated bean.name: " .. bean.name) end
	if type(bean.type) ~= "number" then bean.type = 0 end
	for name in (bean.handlers or ""):gmatch("([%w_%.]+)") do
		if not all_handlers[name] then error("ERROR: not defined handler: " .. name) end
		hdl_names[name] = hdl_names[name] or {}
		hdl_names[name][#hdl_names[name] + 1] = bean.name
	end
	name_bean[bean.name] = bean
	bean.comment = bean.comment and #bean.comment > 0 and "\n\t\t/**\n\t\t * " .. bean.comment:gsub("\n", "<br>\n\t\t * ") .. "\n\t\t */" or ""
	if not bean.attach_cpp then bean.attach_cpp = "" end
end
local function get_includes(include)
	local includes = {}
	for k in pairs(include) do
		includes[#includes + 1] = k
	end
	sort(includes)
	return #includes > 0 and "#include " .. concat(includes, "\n#include ") .. "\n" or ""
end
function bean(bean)
	bean_common(bean)

	bean.includes = {}
	local vartypes = { bean.name }
	for _, var in ipairs(bean) do
		do_var(var)
		if var.id > 0 then
			vartypes[#vartypes + 1] = var.type
			for _, v in ipairs(var.include) do
				bean.includes[v] = true
			end
		end
	end
	bean.includes = get_includes(bean.includes)

	local code = template_bean:gsub("#{#(.-)#}#", function(body)
		local subcode = {}
		for _, var in ipairs(bean) do
			if var.id == -1 then subcode[#subcode + 1] = code_conv(body, "var", var) end
		end
		return concat(subcode)
	end):gsub("#%(#(.-)#%)#", function(body)
		local subcode = {}
		for _, var in ipairs(bean) do
			if var.id > 0 then subcode[#subcode + 1] = code_conv(code_conv(body, "var", var), "var", var) end
		end
		local code = concat(subcode)
		return code:sub(-2, -1) ~= ", " and code or code:sub(1, -3)
	end)

	if not bean.maxsize then bean.maxsize = 0x7fffffff end
	if not bean.initsize then bean.initsize = 0 end
	name_code[bean.name] = code_conv(code, "bean", bean)
		:gsub(#vartypes > 1 and "#[<>]#" or "#<#(.-)#>#", "")
		:gsub("static const char%* const", "// static const char* const")
		:gsub("\r", "")
	if bean.type > 0 then
		bean_order[#bean_order + 1] = bean.name
	else
		name_code[bean.name] = name_code[bean.name]:gsub("\t\tvirtual void OnProcess.-DO NOT EDIT!\n", "")
	end
end

if not arg[3] then error("ERROR: arg[3] must be input allbeans.lua") end
dofile(arg[3])

local genPattern = "// THE CODE BELOW CAN BE REGENERATED BY GENBEANS TOOL%. DO NOT EDIT!.*"

local outpath = (arg[4] or "."):gsub("\\", "/")
if outpath:sub(-1, -1) ~= "/" then outpath = outpath .. "/" end
local function checksave(fn, d, change_count)
	local f = open(fn, "rb")
	if f then
		local s = f:read "*a"
		f:close()
		if change_count > 0 then
			local genpart = d:match(genPattern)
			if genpart then
				local t, n = s:gsub(genPattern, genpart)
				if n > 0 then d = t end
			end
		end
		if s == d then d = nil else print(" * " .. fn) end
	else
		print("+  " .. fn)
	end
	if d then
		f = open(fn, "wb")
		if not f then error("ERROR: can not create file: " .. fn) end
		f:write(d)
		f:close()
	end
end

local namespace_path = namespace:gsub("%.", "/")
local saved = {}
local function savebean(beanname)
	if saved[beanname] then return end
	saved[beanname] = true
	if not name_code[beanname] then error("ERROR: unknown bean: " .. beanname) end
	checksave(outpath .. beanname .. ".h", name_code[beanname], 1)
	bean_order[beanname] = true
	for _, var in ipairs(name_bean[beanname]) do
		if name_bean[var.type] then savebean(var.type) end
		if name_bean[var.k] then savebean(var.k) end
		if name_bean[var.v] then savebean(var.v) end
	end
end

local bean_count = 0
checksave(outpath .. "allbeans.h", (template_allbeans:gsub("#%[#(.-)#%]#", function(body)
	local subcode = {}
	for hdlname, hdlpath in pairs(handlers) do
		local names = hdl_names[hdlname] or {}
		local hdl = { name = hdlname, path = tostring(hdlpath), count = #names }
		subcode[#subcode + 1] = code_conv(body:gsub("#%(#(.-)#%)#", function(body)
			local subcode2 = {}
			local typed = {}
			for _, name in ipairs(names) do
				local bean = name_bean[name]
				savebean(bean.name)
				subcode2[#subcode2 + 1] = code_conv(body, "bean", bean)
				if type(hdlpath) == "string" then
					if bean.type <= 0 or bean.type > 0x7fffffff then error("ERROR: invalid bean.type: " .. tostring(bean.type) .. " (bean.name: " .. bean.name .. ")") end
					if typed[bean.type] then error("ERROR: duplicated bean.type: " .. bean.type .. " (" .. typed[bean.type] .. ", " .. bean.name .. ") for " .. hdlname) end
					typed[bean.type] = name
				end
			end
			return concat(subcode2)
		end), "hdl", hdl)
		if type(hdlpath) ~= "string" then subcode[#subcode] = "" end
	end
	return concat(subcode)
end):gsub("#%(#(.-)#%)#", function(body)
	local subcode = {}
	for _, beanname in ipairs(bean_order) do
		if bean_order[beanname] then
			local bean = name_bean[beanname]
			if bean.type > 0 then
				subcode[#subcode + 1] = code_conv(body, "bean", bean)
				bean_count = bean_count + 1
			end
		end
	end
	return concat(subcode)
end)):gsub(has_handler and "#[<>]#" or "#%<#(.-)#%>#", ""):gsub("#%(bean.count%)", bean_count):gsub("\r", ""), 0)

print((arg[2] or "") .. " ... done!")
