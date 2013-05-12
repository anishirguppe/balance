-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.41-3ubuntu12.7


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema balance
--

CREATE DATABASE IF NOT EXISTS balance;
USE balance;

--
-- Definition of table `balance`.`BS_Group`
--

DROP TABLE IF EXISTS `balance`.`BS_Group`;
CREATE TABLE  `balance`.`BS_Group` (
  `BS_Id` int(11) NOT NULL AUTO_INCREMENT,
  `BS_Name` varchar(50) NOT NULL,
  `BS_Initial` varchar(20) NOT NULL,
  PRIMARY KEY (`BS_Id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `balance`.`BS_Group`
--

/*!40000 ALTER TABLE `BS_Group` DISABLE KEYS */;
LOCK TABLES `BS_Group` WRITE;
INSERT INTO `balance`.`BS_Group` VALUES  (1,'Current Asset','CA'),
 (2,'Current Liability ','CL'),
 (3,'Liabilites','LI'),
 (4,'Asset ','AS'),
 (5,'Capital Account','CPA'),
 (6,'Expenditure','EX');
UNLOCK TABLES;
/*!40000 ALTER TABLE `BS_Group` ENABLE KEYS */;


--
-- Definition of table `balance`.`BS_Head`
--

DROP TABLE IF EXISTS `balance`.`BS_Head`;
CREATE TABLE  `balance`.`BS_Head` (
  `BS_Head_Id` int(11) NOT NULL AUTO_INCREMENT,
  `BS_Id` int(11) NOT NULL,
  `BS_Head_Name` varchar(50) NOT NULL,
  `BS_Head_Initial` varchar(20) NOT NULL,
  PRIMARY KEY (`BS_Head_Id`) USING BTREE,
  KEY `BS_Id` (`BS_Id`),
  CONSTRAINT `BS_Head_ibfk_1` FOREIGN KEY (`BS_Id`) REFERENCES `BS_Group` (`BS_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `balance`.`BS_Head`
--

/*!40000 ALTER TABLE `BS_Head` DISABLE KEYS */;
LOCK TABLES `BS_Head` WRITE;
INSERT INTO `balance`.`BS_Head` VALUES  (1,1,'Saving Account','CA_SA'),
 (2,1,'Current Account','CA_CA'),
 (3,1,'Cash','CA_CS'),
 (4,1,'Receivable','CA_RC'),
 (5,2,'Credit Card ','CL_CC'),
 (6,2,'Payable','CL_PB'),
 (7,2,'Reimbursement Expenditure','CL_RE'),
 (8,3,'Loan','LI_LN'),
 (9,4,'Stocks','AS_ST'),
 (10,4,'Fixed Deposits','AS_FD'),
 (11,4,'Statutory Providend Fund','AS_SPF'),
 (12,4,'Unit Linked Insurance Policies ','AS_ULIP'),
 (13,4,'Systematic Investment Plan','AS_SIP'),
 (14,4,'House Property','AS_HP'),
 (15,4,'PPF','AS_PPF'),
 (16,4,'Infrastructure Bond','AS_IB'),
 (17,5,'Salary','CAR_SA'),
 (18,5,'value change','CAR_VC'),
 (19,5,'Dividend','CAR_DIV'),
 (20,5,'Trading Profit','CAR_TP'),
 (21,5,'Income from Profession','CAR_IFP'),
 (22,5,'Gifts','CAR_GI'),
 (23,5,'Other Income','CAR_OI'),
 (24,5,'Misc','CAR_MIS'),
 (25,5,'Interest','CAR_INT'),
 (26,6,'Utilities','EXP_UTIL'),
 (27,6,'Education','EXP_EDU'),
 (28,6,'Household','EXP_HH'),
 (29,6,'Medical','EXP_MED'),
 (30,6,'Vehicle','EXP_VEH'),
 (31,6,'House','EXP_HOU'),
 (32,6,'Wages','EXP_WAG'),
 (33,6,'Insurance','EXP_INS'),
 (34,6,'Social','EXP_SOC'),
 (35,6,'Business Travel','EXP_BT'),
 (36,6,'Personal Care','EXP_PC'),
 (37,6,'Shopping','EXP_SHOP'),
 (38,6,'Tax','EXP_TAX'),
 (39,6,'Interest Payment','EXP_IP'),
 (40,6,'Share Purchase/sale','EXP_SHA'),
 (41,6,'Deductions from salary','EXP_DED'),
 (42,6,'Holiday Vacation','EXP_HOL'),
 (43,6,'Recreation','EXP_REC');
UNLOCK TABLES;
/*!40000 ALTER TABLE `BS_Head` ENABLE KEYS */;


--
-- Definition of table `balance`.`BS_Sub_Head`
--

DROP TABLE IF EXISTS `balance`.`BS_Sub_Head`;
CREATE TABLE  `balance`.`BS_Sub_Head` (
  `BS_Sub_Head_Id` int(11) NOT NULL AUTO_INCREMENT,
  `BS_Head_ID` int(11) NOT NULL,
  `BS_Sub_Head_Name` varchar(50) CHARACTER SET latin1 NOT NULL,
  `BS_Sub_Head_Initial` varchar(20) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`BS_Sub_Head_Id`),
  KEY `BS_Head_ID` (`BS_Head_ID`),
  CONSTRAINT `BS_Sub_Head_ibfk_1` FOREIGN KEY (`BS_Head_ID`) REFERENCES `BS_Head` (`BS_Head_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

--
-- Dumping data for table `balance`.`BS_Sub_Head`
--

/*!40000 ALTER TABLE `BS_Sub_Head` DISABLE KEYS */;
LOCK TABLES `BS_Sub_Head` WRITE;
INSERT INTO `balance`.`BS_Sub_Head` VALUES  (1,24,'Account reconciliation','CAR_MIS_ACC'),
 (2,4,'Company','CA_RC_CP'),
 (3,4,'Conveyance','CA_RC_CV'),
 (4,4,'Medical','CA_RC_MD'),
 (5,4,'Phone Bill','CA_RC_PB'),
 (6,4,'Travel Bill ','CA_RC_TB'),
 (7,4,'Leave Travel Allowance(LTA)','CA_RC_LTA'),
 (8,8,'Home Loan','LI_LN_HL'),
 (9,8,'Educational Loan','LI_LN_EL'),
 (10,8,'Personal Loan','LI_LN_PER'),
 (11,8,'Vehicle Loan','LI_LN_VEH'),
 (12,17,'Salary take home','CAR_SA_SAL'),
 (13,17,'EPF','CAR_SA_EPF'),
 (14,17,'Upgradation Allowance','CAR_SA_UPG'),
 (15,17,'Exgratia','CAR_SA_EXG'),
 (16,17,'LTA Others','CAR_SA_LTA'),
 (17,17,'Coupons','CAR_SA_COU'),
 (18,19,'Stock','CAR_DIV_STO'),
 (19,19,'Mutual fund','CAR_DIV_MUT'),
 (20,18,'ULIP NAV','CAR_VC_ULI'),
 (21,18,'SIP NAV','CAR_VC_SIP'),
 (22,18,'Stock value Change from month','CAR_VC_STO'),
 (23,18,'Profit from sale of shares','CAR_VC_PRS'),
 (24,18,'Profit from Sale of asset','CAR_VC_PRA'),
 (25,18,'ESOP Appreciation','CAR_VC_ESO'),
 (26,25,'Savings Account','CAR_INT_SAV'),
 (27,25,'Fixed Deposit','CAR_INT_FIX'),
 (28,25,'sale of debentures','CAR_INT_SAL'),
 (29,25,'bonds','CAR_INT_BON'),
 (30,25,'PF','CAR_INT_PF'),
 (31,25,'PPF','CAR_INT_PPF'),
 (32,25,'NSC','CAR_INT_NSC'),
 (33,25,'NSS','CAR_INT_NSS'),
 (34,25,'Others','CAR_INT_OTH'),
 (35,20,'Stocks','CAR_TP_STO'),
 (36,20,'business','CAR_TP_BUS'),
 (37,20,'scrap sale','CAR_TP_SCR'),
 (38,21,'Evaluation','CAR_IFP_EVA'),
 (39,21,'Visiting Faculty','CAR_IFP_VIS'),
 (40,21,'Tutions','CAR_IFP_TUT'),
 (41,21,'License Fee','CAR_IFP_LIC'),
 (42,22,'Relations','CAR_GI_RE'),
 (43,22,'Company','CAR_GI_COM'),
 (44,22,'Free gift with Purchase','CAR_GI_FRE'),
 (45,22,'Scholarship','CAR_GI_SCH'),
 (46,23,'Agricultural','CAR_OI_AGR'),
 (47,23,'rental property','CAR_OI_REN'),
 (48,23,'maturity proceeds','CAR_OI_MAT'),
 (49,23,'Tax refund','CAR_OI_TAX'),
 (50,23,'Cash Back','CAR_OI_CAS'),
 (51,26,'TV Cable','EXP_UTIL_TV'),
 (52,26,'Electricity','EXP_UTIL_ELE'),
 (53,26,'Internet','EXP_UTIL_INT'),
 (54,26,'Society Maintenance','EXP_UTIL_SOC'),
 (55,26,'Telephone','EXP_UTIL_TEL'),
 (56,26,'Subscription','EXP_UTIL_SUB'),
 (57,26,'Gas','EXP_UTIL_GAS'),
 (58,27,'School','EXP_EDU_SCH'),
 (59,27,'Phd','EXP_EDU_PHD'),
 (60,27,'Coaching','EXP_EDU_COA'),
 (61,27,'stationary','EXP_EDU_STA'),
 (62,28,'Groceries','EXP_HH_GRO'),
 (63,28,'Laundry','EXP_HH_LAU'),
 (64,28,'milk','EXP_HH_MIL'),
 (65,28,'fruits & Veg','EXP_HH_FRI'),
 (66,28,'Maintenance','EXP_HH_MAI'),
 (67,29,'Doctor','EXP_MED_DOC'),
 (68,29,'Medicine','EXP_MED_MED'),
 (69,29,'Insurance','EXP_MED_INS'),
 (70,29,'Lab Test','EXP_MED_LAB'),
 (71,29,'health products','EXP_MED_HEA'),
 (72,30,'Fuel','EXP_VEH_FUE'),
 (73,30,'Service','EXP_VEH_SER'),
 (74,30,' Loan Interest','EXP_VEH_ LO'),
 (75,30,' Insurance','EXP_VEH_ INS'),
 (76,30,'Registration','EXP_VEH_REG'),
 (77,30,'Conveyance','EXP_VEH_CON'),
 (78,31,'Repair','EXP_MED_INS'),
 (79,31,'House Rent','EXP_MED_LAB'),
 (80,31,' EMI on Loan','EXP_MED_DOC'),
 (81,32,'Maid','EXP_WAG_MAI'),
 (82,32,'Driver','EXP_WAG_DRI'),
 (83,32,'Caretaker','EXP_WAG_ CA'),
 (84,33,'Home Insurance','EXP_INS_HOM'),
 (85,33,'Life Insurance','EXP_INS_LIF'),
 (86,43,'Club Fee','EXP_REC_CLU'),
 (87,43,'Movie','EXP_REC_MOV'),
 (88,43,'Restaurant','EXP_REC_RES'),
 (89,34,'Donation','EXP_SOC_DON'),
 (90,34,'Occasion Celebration','EXP_SOC_OCC'),
 (91,35,'Food','EXP_HOL_FOO'),
 (92,35,'Lodging','EXP_HOL_LOD'),
 (93,35,'Transport','EXP_HOL_TRA'),
 (94,36,'Food','EXP_BT_FOO'),
 (95,36,'Lodging','EXP_BT_LOD'),
 (96,36,'Transport','EXP_BT_TRA'),
 (97,37,'Saloon','EXP_PC_SAL'),
 (98,37,'Gymnasium','EXP_PC_GYM'),
 (99,38,'Personal Accessories','EXP_SHOP_PER'),
 (100,38,'Home Accessories','EXP_SHOP_HOM'),
 (101,38,'Other','EXP_SHOP_OTH'),
 (102,39,'Advance','EXP_TAX_ADV'),
 (103,39,'Education Cess','EXP_TAX_EDU'),
 (104,39,'Property','EXP_TAX_PRO'),
 (105,39,'Service Tax','EXP_TAX_SER'),
 (106,39,'TDS','EXP_TAX_TDS'),
 (107,39,'Professional Tax','EXP_TAX_PRO'),
 (108,40,'Personal Loan','EXP_IP_PER'),
 (109,40,'Education Loan','EXP_IP_EDU'),
 (110,41,'Brokerage ','EXP_SHA_BRO'),
 (111,41,'STT','EXP_SHA_STT'),
 (112,42,'Food/Tea/Gift Coupons','EXP_DED_FOO');
UNLOCK TABLES;
/*!40000 ALTER TABLE `BS_Sub_Head` ENABLE KEYS */;


--
-- Definition of table `balance`.`ExpenseEntry`
--

DROP TABLE IF EXISTS `balance`.`ExpenseEntry`;
CREATE TABLE  `balance`.`ExpenseEntry` (
  `Expense_Id` int(11) NOT NULL,
  `Expense_Category` int(11) NOT NULL,
  `Expense_Account` int(11) DEFAULT NULL,
  `Expense_Date` date DEFAULT NULL,
  `Expense_Amount` double NOT NULL,
  `Expense_Remarks` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  `User_Id` int(11) DEFAULT NULL,
  PRIMARY KEY (`Expense_Id`),
  KEY `ExpenseEntry_ibfk_3` (`Expense_Account`),
  KEY `ExpenseEntry_ibfk_2` (`Expense_Category`),
  KEY `User_Id` (`User_Id`),
  CONSTRAINT `ExpenseEntry_ibfk_4` FOREIGN KEY (`User_Id`) REFERENCES `UserDetails` (`UserId`),
  CONSTRAINT `ExpenseEntry_ibfk_2` FOREIGN KEY (`Expense_Category`) REFERENCES `BS_Head` (`BS_Head_Id`),
  CONSTRAINT `ExpenseEntry_ibfk_3` FOREIGN KEY (`Expense_Account`) REFERENCES `UserAccountDetails` (`UserAccountId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `balance`.`ExpenseEntry`
--

/*!40000 ALTER TABLE `ExpenseEntry` DISABLE KEYS */;
LOCK TABLES `ExpenseEntry` WRITE;
INSERT INTO `balance`.`ExpenseEntry` VALUES  (0,27,2,NULL,302252,'sdfsd',NULL),
 (1,32,4,'2012-07-18',435345,'gfsdfg',NULL),
 (2,37,2,'2012-07-19',345235,'hi this ',1),
 (3,37,5,'2012-07-20',345345,'ghfdghdfghdf',2),
 (4,31,6,'2012-07-19',455566,'sdfsdf',2);
UNLOCK TABLES;
/*!40000 ALTER TABLE `ExpenseEntry` ENABLE KEYS */;


--
-- Definition of table `balance`.`IncomeEntry`
--

DROP TABLE IF EXISTS `balance`.`IncomeEntry`;
CREATE TABLE  `balance`.`IncomeEntry` (
  `Income_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Income_Category` int(11) NOT NULL,
  `Income_Account` int(11) DEFAULT NULL,
  `Income_Date` date DEFAULT NULL,
  `Income_Amount` double NOT NULL,
  `Income_Remarks` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  `User_Id` int(11) DEFAULT NULL,
  PRIMARY KEY (`Income_Id`),
  KEY `Income_Category` (`Income_Category`),
  KEY `Income_Account` (`Income_Account`),
  KEY `User_Id` (`User_Id`),
  CONSTRAINT `IncomeEntry_ibfk_4` FOREIGN KEY (`User_Id`) REFERENCES `UserDetails` (`UserId`),
  CONSTRAINT `IncomeEntry_ibfk_2` FOREIGN KEY (`Income_Category`) REFERENCES `BS_Head` (`BS_Head_Id`),
  CONSTRAINT `IncomeEntry_ibfk_3` FOREIGN KEY (`Income_Account`) REFERENCES `UserAccountDetails` (`UserAccountId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

--
-- Dumping data for table `balance`.`IncomeEntry`
--

/*!40000 ALTER TABLE `IncomeEntry` DISABLE KEYS */;
LOCK TABLES `IncomeEntry` WRITE;
INSERT INTO `balance`.`IncomeEntry` VALUES  (1,17,2,'2012-07-12',11112.25,'ddddsda',NULL),
 (2,23,1,'2012-07-12',123,'hhh',NULL),
 (3,17,4,'2012-07-13',0,'',NULL),
 (4,25,5,'2012-07-19',0,'',NULL),
 (5,26,3,'0000-00-00',0,'',NULL),
 (6,26,3,'0000-00-00',0,'',NULL),
 (7,26,3,'0000-00-00',0,'',NULL);
UNLOCK TABLES;
/*!40000 ALTER TABLE `IncomeEntry` ENABLE KEYS */;


--
-- Definition of table `balance`.`UserAccountDetails`
--

DROP TABLE IF EXISTS `balance`.`UserAccountDetails`;
CREATE TABLE  `balance`.`UserAccountDetails` (
  `UserAccountId` int(11) NOT NULL,
  `User_BS_Head_Id` int(11) DEFAULT NULL,
  `UserAccountName` varchar(50) CHARACTER SET latin1 NOT NULL,
  `UserAccountBankName` varchar(50) CHARACTER SET latin1 NOT NULL,
  `UserAccountBankBranch` varchar(50) CHARACTER SET latin1 NOT NULL,
  `UserAccountNo` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  `OpeningBalance` bigint(20) DEFAULT NULL,
  `UserId` int(11) NOT NULL,
  PRIMARY KEY (`UserAccountId`),
  KEY `User_BS_Head_Id` (`User_BS_Head_Id`),
  KEY `UserId` (`UserId`),
  CONSTRAINT `UserAccountDetails_ibfk_1` FOREIGN KEY (`User_BS_Head_Id`) REFERENCES `BS_Head` (`BS_Head_Id`),
  CONSTRAINT `UserAccountDetails_ibfk_2` FOREIGN KEY (`UserId`) REFERENCES `UserDetails` (`UserId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `balance`.`UserAccountDetails`
--

/*!40000 ALTER TABLE `UserAccountDetails` DISABLE KEYS */;
LOCK TABLES `UserAccountDetails` WRITE;
INSERT INTO `balance`.`UserAccountDetails` VALUES  (1,1,'Aniruddh salary A/C ','Axis Bank','Belapur','15717171717',21860,1),
 (2,2,'Aniruddh`s current a/c ','SBI','KOP','1542',25633,1),
 (3,2,'Aniruddha Current a/c','ICICI bank','Kop','154525',123,2),
 (4,10,'FIXED DEPOSITS A/C','AXISBANK','Belapur','0122222',2353566,1),
 (5,1,'AbhiSaving A/C','BOB','NAGAON','145256',23333,2),
 (6,10,'IDBIFIX','IDBI','belapur','152452',1236,2);
UNLOCK TABLES;
/*!40000 ALTER TABLE `UserAccountDetails` ENABLE KEYS */;


--
-- Definition of table `balance`.`UserDetails`
--

DROP TABLE IF EXISTS `balance`.`UserDetails`;
CREATE TABLE  `balance`.`UserDetails` (
  `UserId` int(11) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(50) NOT NULL,
  `UserProfileName` varchar(50) DEFAULT NULL,
  `UserDOB` date DEFAULT NULL,
  `UserGender` varchar(10) DEFAULT NULL,
  `UserRelevantId` int(11) DEFAULT NULL,
  `UserAddress` varchar(100) DEFAULT NULL,
  `MarriedStatus` varchar(10) DEFAULT NULL,
  `NoOfChild` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`UserId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `balance`.`UserDetails`
--

/*!40000 ALTER TABLE `UserDetails` DISABLE KEYS */;
LOCK TABLES `UserDetails` WRITE;
INSERT INTO `balance`.`UserDetails` VALUES  (1,'Aniruddha P Shirguppe','Aniruddha','1987-11-17','male',1,'Kolhapur','no','no'),
 (2,'Abhijeet Shirguppe','Abhjeet','2012-06-18','male',2,'kop','no','no');
UNLOCK TABLES;
/*!40000 ALTER TABLE `UserDetails` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
