### 整数类型常量

#### 十进制整数：如：99，-500，0

#### 八进制整数：要求以0开头，如：015

#### 十六进制数，要求0x或0X开头，如0x15

### 整型变量

#### byte：占用1个字节，表数范围：2的负7次方到2的7次方减1，范围为：-128到127

#### short：占用2个字节，表数范围：负2的15次方到2的15次方减1，范围为：-32768到32767

#### int：占用4个字节，表数范围：负2的31次方到2的31次方减1，范围为：-2147483648到2147483647

#### long：占用8个字节，表数范围：负2的63次方到2的63次方减1。

默认的整数类型是int，如果超过了范围，添加l或者L后缀，建议使用大写L。

### 浮点类型常量

#### 十进制数形式，例如：3.14、314.0、0.314

#### 科学记数法：例如：314e2或314E2，表示314乘以10的2次方，314E-2，表示314乘以10的负2次方。

### 浮点型变量

#### float：占用4个字节，单精度类型，尾数可以精确到7位有效数字。范围为：-3.403E38到3.403E38

#### double：占用8个字节，双精度类型，精度是float的两倍。范围为：-1.798E308到1.798E308

浮点类型默认为为double。要变为float，需要添加f或者F。

### 布尔类型

#### boolean：占用1个bit位，比byte字节还小的单位。

### 字符类型

#### char：占用2个字节。

使用的是Unicode编码，Unicode编码就是占用2个字节。可允许有65536个字符。 ASCII码占1个字节，可允许有128个字符（最高位是0），是Unicode编码表中前128个字符。

Java 语言中还允许使用转义字符 ‘\’ 来将其后的字符转变为其它的含义， char c2 = '\n'; //代表换行符 char类型在内存中存储的是该字符的Unicode编码值，所以char类型可以当做int类型来处理。

### 运算符

#### 算数运算符

算数运算符：+ - * / % ++ --

#### 赋值运算符

赋值运算符：=

#### 扩展赋值运算符

扩展赋值运算符：+= -=  *= /=

#### 关系运算符

关系运算符：>  <  >=  <= ==  !=

#### 逻辑运算符

逻辑运算符：& | && ||  !  ^

#### 位运算符

位运算符：& | ^  ~  >>  <<  >>>

#### 条件运算符

条件运算符： ?  :










































