create database figure
go
use figure
go
create table ProductType
(
	IDType varchar(10) primary key,
	TypeName nvarchar(50),
	Size nvarchar(10)
)
go
create table Product
(
	IDProduct varchar(20) primary key,
	ProductName nvarchar(100),
	IDType varchar(10) FOREIGN KEY REFERENCES ProductType(IDType),
	Price int
)
go
create table Administrator(
	Username varchar(50) Primary key,
	[Password] varchar(20)
)
go
create table Employee(
	UsernameEmp varchar(50) Primary key,
	[Password] varchar(20),
	NameEmp nvarchar(50),
	Gender nvarchar(10),
	Birthday varchar(20),
	Phone varchar(20),
	Email varchar(50),
	[Address] nvarchar(Max),
	Hinh varchar(50)
)
go

create table Customer(
	IDCus int Identity(100000,1) Primary key,
	IdentityCard varchar(20) not null UNIQUE,
	CusName nvarchar(50),
	[DateAdd] varchar(20),
	Phone varchar(20),
	Email varchar(50),
	Quantity int,
	Discount int
)
go

go
--Insert 1 Administrators
Insert into Administrator values('admin','admin')

--Insert 4 Employees information
Insert into Employee values('phungnguyen','123456',N'Nguyễn Trung Phụng',N'Nam','07/03/1998','0345655350','phung0703@gmail.com',N'Dĩ an','2.jpg')
Insert into Employee values('phungnguyen1','123456',N'Nguyễn Trung Phụng',N'Nam','07/03/1998','0345655350','phung0703@gmail.com',N'Dĩ an','2.jpg')
Insert into Employee values('phungnguyen2','123456',N'Nguyễn Trung Phụng',N'Nam','07/03/1998','0345655350','phung0703@gmail.com',N'Dĩ an','2.jpg')
Insert into Employee values('phungnguyen3','123456',N'Nguyễn Trung Phụng',N'Nam','07/03/1998','0345655350','phung0703@gmail.com',N'Dĩ an','2.jpg')

--Inser 7 ProductTypes
Insert into ProductType values('T01',N'Chibi Figure',N'Nhỏ')
Insert into ProductType values('T02',N'Scale Figure',N'Vừa')
Insert into ProductType values('T03',N'Action Figure',N'Lớn')
Insert into ProductType values('T04',N'Tamagochi',N'Nhỏ')
Insert into ProductType values('T05',N'Artbook',N'Vừa')
Insert into ProductType values('T06',N'Fidget Spinner',N'Lớn')

--Insert 20 Products
Insert into Product values('CF01', N'Naruto', 'T01', 20000)
Insert into Product values('CF02', N'Songoku', 'T02', 25000)
Insert into Product values('CF03', N'Luffy', 'T03', 30000)
Insert into Product values('CF04', N'Zoro', 'T01', 25000)
Insert into Product values('CF05', N'Conan', 'T02', 30000)
Insert into Product values('CF06', N'Sakura', 'T03', 35000)
Insert into Product values('ES01', N'KaKalot', 'T01', 30000)
Insert into Product values('ES02', N'Kadic', 'T02', 40000)
Insert into Product values('ES03', N'Shizuka', 'T03', 50000)
Insert into Product values('CA01', N'Chaien', 'T01', 42000)
Insert into Product values('CA02', N'Xeko', 'T02', 52000)
Insert into Product values('CA03', N'Lee', 'T03', 62000)
Insert into Product values('TD01', N'Gray', 'T04', 40000)
Insert into Product values('TD02', N'Sasuke', 'T05', 50000)
Insert into Product values('TD03', N'Kakashi', 'T06', 60000)
Insert into Product values('CE01', N'Kirito', 'T04', 35000)
Insert into Product values('CE02', N'Ashuha', 'T05', 40000)
Insert into Product values('ST01', N'Gohan', 'T04', 50000)
Insert into Product values('ST02', N'Spiderman', 'T05', 60000)



--Insert 4 Customers
Insert into Customer values('122261551',N'Nguyễn Trung Phụng','07/03/1998','01212692802','phung070374@gmail.com',20,10)
Insert into Customer values('122261552',N'Nguyễn Trung Phụng','07/03/1998','01212692802','phung070374@gmail.com',25,10)
Insert into Customer values('122261553',N'Nguyễn Trung Phụng','07/03/1998','01212692802','phung070374@gmail.com',19,5)
Insert into Customer values('122261554',N'Nguyễn Trung Phụng','07/03/1998','01212692802','phung070374@gmail.com',10,5)

