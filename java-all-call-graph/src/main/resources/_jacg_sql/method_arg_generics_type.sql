CREATE TABLE if not exists jacg_method_arg_generics_type_{appName} (
  record_id int NOT NULL COMMENT '记录id，从1开始',
  method_hash varchar(30) NOT NULL COMMENT '方法hash+字节数',
  simple_class_name varchar(255) NOT NULL COMMENT '唯一类名',
  seq int NOT NULL COMMENT '参数序号，从0开始',
  type varchar(5)  NOT NULL COMMENT '类型，t:参数类型，gt:参数中的泛型类型',
  type_seq tinyint NOT NULL COMMENT '类型序号，参数类型固定为0，参数中的泛型类型从0开始',
  simple_generics_type varchar(255) NOT NULL COMMENT '方法参数类型或其中的泛型类型唯一类名',
  generics_array_dimensions tinyint DEFAULT NULL COMMENT '方法参数中的泛型数组类型的维度，为0代表不是数组类型',
  type_variables_name varchar(255) NOT NULL COMMENT '方法参数中的泛型类型变量名称',
  wildcard varchar(8) NOT NULL COMMENT '方法参数中的泛型通配符',
  reference_type varchar(255) NOT NULL COMMENT '方法参数中的泛型通配符引用的类型',
  generics_category varchar(5) NOT NULL COMMENT '方法参数中的泛型类型分类，J:JDK中的类型，C:自定义类型',
  generics_type varchar(255) NOT NULL COMMENT '方法参数类型或其中的泛型类型类名',
  full_method text NOT NULL COMMENT '完整方法（类名+方法名+参数）',
  PRIMARY KEY (record_id),
  INDEX idx_magt_matt_{appName}(method_hash, seq, type, type_seq),
  INDEX idx_magt_scn_{appName}(simple_class_name),
  INDEX idx_magt_sgt_{appName}(simple_generics_type)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='方法参数泛型类型';