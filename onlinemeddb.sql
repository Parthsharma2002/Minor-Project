-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: onlinemedicinedonationdb
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `donatemedicine`
--

DROP TABLE IF EXISTS `donatemedicine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `donatemedicine` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `medicinebrand` varchar(245) DEFAULT NULL,
  `medicinegeneric` varchar(245) DEFAULT NULL,
  `manufacturerdate` date DEFAULT NULL,
  `expirydate` date DEFAULT NULL,
  `quantity` bigint DEFAULT NULL,
  `userid` bigint DEFAULT NULL,
  `ngoid` bigint DEFAULT NULL,
  `medicinepacket` longblob,
  `createdby` varchar(245) DEFAULT NULL,
  `modifiedby` varchar(245) DEFAULT NULL,
  `createddatetime` timestamp NULL DEFAULT NULL,
  `modifieddatetime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `donatemedicine_ibfk_1` (`userid`),
  KEY `donatemedicine_ibfk_3` (`ngoid`),
  CONSTRAINT `donatemedicine_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `donatemedicine_ibfk_2` FOREIGN KEY (`ngoid`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `donatemedicine_ibfk_3` FOREIGN KEY (`ngoid`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donatemedicine`
--

LOCK TABLES `donatemedicine` WRITE;
/*!40000 ALTER TABLE `donatemedicine` DISABLE KEYS */;
INSERT INTO `donatemedicine` VALUES (1,'Calpol','Paracetamol','2022-07-20','2023-10-05',12,2,4,_binary 'ÿ\Øÿ\à\0JFIF\0\0\0\0\0\0ÿ\Û\0„\0\n\Z\Z\Z\Z\Z\Z\Z\Z \Z!+#\Z)!$5%(,.222\Z!7<71;+12.1(#(13111341111.11111111111113111111111111311121111111ÿÀ\0\0\á\0\á\"\0ÿ\Ä\0\0\0\0\0\0\0\0\0\0\0\0\0\0ÿ\Ä\0J\0	\0\0!1AQ\"aq2‘#BR¡±Áğ3Tbr“\Ñ\ÒS‚’ñ$Ccs²\áDÂƒ¢³4ÿ\Ä\0\Z\0\0\0\0\0\0\0\0\0\0\0\0ÿ\Ä\02\0\0\0\0\0\0\0!1AQ‘¡\"2RBq±#3aÁğñbÿ\Ú\0\0\0?\0öj(®P¢Š(Š+”h®WhŠ( \n+•\Ú\0¢Š(Š( \n(¢€(¢Š\0¢Š(Š( \n(¢€(¢Š\0¢Š(wn;d0Ÿ\'mE\Ë\ÄL1…@v-\ZŸAõV-»grO}“\ÉRŞšL	RKyN\ÕE\Ú\æ\æ&\ë±Õ®1ô‚@ @‚œ\àø¾ıİ¹36º6^½g¥}6ŸC‡$\æ“u\ËgŸQ9¾\"\çı¯\Ç~Oø-r\èr}t¡\Ú\Üw÷\çøvù\İ\Ø|j÷	\Ù\ëÀÎ¹\Ş5-¯ÀmR.pû\r¡¶¾\å\ìª9é¯Œk\Ñ^\\‹¬Ÿ©G†\íF0\ï}¿\Ék\ì\Ëğœwj±ƒÙ¾F\ß2\Ù\çCn§•/‹pSlg·%u‘=uß—¯*¢Ç¸\"}ûL9tıu\Ú´ó\åEz#’Ë™O™?R\Â\Çk±\Äk|Ÿğ[\é´\äòö¶¥7k±¿¬¿£¶4õ]\×Y\ä’\É\Ğ‰™˜\ê:Q­kxe¤¼N°r\Ì	5\"\'Nu9qé±«”W¢;¼¹/\æ~¤/ö¿ıû’\×Ù“~‚œ­\Æÿ\0~wú\Î\Äi\ì|NÂ´ƒ…aÆ\Úü>óUüO³h\ÊM¯	\é¸>Dt\ç¸)\é›\æ	}‘^\Ó\'„Ÿ«*q­\Ç\"ù\æ}‹|Œi+°úùT/m8\ß\ÇQ§whnc\èmÒ¢\ã\íÌ® ıgÿ\0zi\È\n®\Â R|RAüúúhzV¸\é°WÈ½\Ò²mw\'\êi_¶¸°có–\'Áh‘¿K{õ\éJ³\Ûkm}¹Ñ§0\é\í¦ü\é®\Îğ7\Äx¤¥½<Z\Ë\0dGA\Êw5¨·À°\Éó¥µ\ÛÖ³O»A\íØ›ıW–uó?R€v³ıû§ü»|\çöwò¥\Ô\ãXoòZ\éû»õ;U\Î\'€\Øq\á\\­È7ò¬¿À½†\Êûi@ >‡:˜->N¢9¼¹µ\'\ê!ûc\ÄC\Ç\ç$ƒ¯\è\íF\Şud½ª\ÆÆ·\Ï?ùvşÀšùu¬Ë¨.uò\Ó^¿\å\î©øKouÅ»`“>#®’9yó¢Z|V\â½y\æ\Ë*¦ıYnı¬\Æò¾\ÉoËO®{]şüóù–¹;®Â®0}šµls\Æ\Ş{ *Sğ¬;\î\Ôzû+#›\Ã\ZdSµÈº\Éú™\Ïö»ú\Ã’\×3û›ô\ZE\Ş\Ö\ã¹bOOb\Ñ\æ\é\ê\İG*öx\ÛRö\Ée\ÖD\ê$\É\×}~#•g]g¯\×\×ÿ\0\×\ï®øğ\éò+Œ¢,³d]dıM&µ\Ò$\â/™o˜\ë“o:]\Î\Ôc@üÿ\0’\ßO\İúª‚\É:@\Ò\ØyyrŞ´\Ü#³`¨{ú\Ì»{\ÌoøÚ£.=>?š\Ñ\ÖLÒ—\ÌıY»]ô\ç¤dµ¼L{;\ÒOk±Ÿ¬¾Í®Qû\ÏSZtÀ\ØQ\ÚG\î¯òª\î-Ù»Wk&\ãl»UØŠâ§§oœi}‘u–Sõ*¿\Ûj\ë\ß\Ìrd·®¼ÀM<†æµ½\í˜Ä°µx*]>\ÉY\Êñ\Ê²\Úm\'\î¯4\Çaš\Û28 ‰\æ~\ß8ö\Ô\Ş™.#©†S˜G²Aƒ\íŞº\æ\Ğ\áÉ\íI?u3‹¶\Û_\Üú\nh¨”W\ÍöR=Nğ\â\Æ/\\<Ã·\Ô\ÇıA\ç[\Î\Ã\á;¼>c\í¯«j—º°|iO{t¦ÿ\0ùŸÇ•zdq\ìCñ…}6®ûö<I>W\Ür˜[´ö%*:¥eQ\åe”÷–WÍ¡\Ø\èk\Ú+}\İ\çO2®›~\ÔF¾µ¾Á®µç²~òû°:\"yt\×\Ë\Âk®“úºQ»\r´¬²\ì5\Ô$©¦\Òeˆ÷GÅ«s»\Èmµbû%‰y\'“AŸ\ÚPô2\rl1é©®z¥ü\Õ~DJR\Û*óö µ\íjN\îµ	’¤aZ¬\Ò\Úc\Ç9\ï)?(XPn¸3\ç ú\éğ¬n\r¸S9Yµ¢5#\ËM<\æ·”\Ñmuñ7\Õ‹Á5\ê9ı}ûo[t–ğòzjT¼­‡An\Ê ¤Ÿ}@½wZš.–‘†\ÅG\ÙU·’¼üK—f-T¤ª‡¬]Ö\Ğa\Å\Ì;5]}Ó­7a)\î;x&\äü\á”z±Š³U8\íó\Zi7~Gš¿„±‰#×‘?:\İ~O°¡l–3ûM«}\Ã\İX[§F1\Ô\í\Ğ\Ï\àò­\ïañ!­8˜s\nİ®O²6[\ãığ,±·\"¢-Ú•J„©­bÆ–\Ó\Î\Ì\æ¦Y\á7„\ê†¼ï´¸2—®1\â:D\ê?‡\Èú×¢`QX\Ô\\z\ãi›S\ÓA>škî®º?ê´ºQ·{Uö#-\âƒM£Võ\'\Â¾·˜»•ƒ\ì>$-õRu—Xù\âFŞ„V\ãµ]Zşr¿\"\Òok+\Ş\îµ#\rr¢ºkR0¶\ê“Kiƒ¥¼¤ü¡`ÁDº4#C\èt3öû«#…\Zÿ\0¤\Ìuú^}+iùAº•Ng_¬\n\Â\à\Ó]\Î\Ãs\ë\îkn‘¾Ç“\Òk†{T\Ñ\\ümEx†\ãÇ¸·\é\îúÿ\0‘Ÿw^µcÙ¾(\Øv\×h1±\×/¯1U\ÜSô÷?\î7¬\æ?_\İJQ#\İ\×HMÏ\Õôj1–5t£FzVjğÌŒQ±¢—ù´t¯5\Î\ÃPH·õ•\×\Å\\m¹\çXû„¿,¸9:—-\Zş?\ÇÛ´Áœ\èH\ÙgÏ™ò¬•Ä€\'õ\êi\Ì%¾p)XõAŸÁò\ç\åÎ´c\ÅKjõ)\Ú\\’\"X|¤0<¹t€tô\ë\î­\ç\ãIyB\\`¯¶ºó~U…KzD}Dò\"cŸ§*Iütõ\Ôõ4Í‚9•>¾gK\çƒÓ›\rLcq–¬.ga<”jIò\çKºrsút\ÖrI$™\æL“§\×\î\ç\\‚_š\\\nŠ\å\"wÆµû…\ÛA\Èk \r?MV\"6ºÁA \é\Ï_NSS4\Û\íú\ßÊ›E\Ô\í\Z™\Ğs\Ô\ë°\ë[TU.„\Æthû+Ç•W»»¢õ\ß)?ıgŸ*\ÓAµR<Á¯6u\æ=:\é·\Ô9ó®\ÚÄº{.\ë\è\Äk\îÒ³dÑ©\ËtqMUŒù-‚\ÎÁ@Ü“Y.\Ññø…Oavı£\Ö>1T}\Ü\Ë37\ï~N\ØC3\éöò¼ªØ´‹\İ\'lŠQB\Z\Ø\é\ÊN\Ü\Ç?-&*_\Ç6\Z\â•\Õu:0&rùb£0\×\Ëİ¿ˆiÕ¾úz\ê‚:«_»ı+´¢¤ª^!Íª7ø,u»\ë™ªt ùŠ|X\ë\Ë\È`drŸººø›‡\ÚwaĞ±øoX\ß\á\îşp^\ã.Z6½¢\í[FKl\ì\Ì6Q¶ü\Û\ì¬M\Æ-¯\Ãi\í¿ˆR7\Ü\é¤@\ß\İ\Èô§À‚:\èšo§ZÓ‹pªA¿»!•ƒ®š\r¾ C\Ï\ÔVóñÔº¡]‚\\zóS÷V>\Ú\è=\ß\ËnGË•0ö¼¿ÿ\0¶£6\æTúù”Yy\äô¿\Í\çZc·`K4·$\Z“ü½k\ÎF\"\âˆ\ïy`>İ©²\ç]N¾rvŸ—:Î¿wñK‚\é\ÅsK\ãø\æ¿p±<ùr\èX\å\×Z‡„__õükÊºS\ï\ævÓœh<ùSøTñ{#øËõ²”aµ.[\Èh¢=h¯›=<sŒ—»ÿ\0qÿ\0óo«¡÷S¶€	$\ÄhLF\İ|¹oLñ\Ó\İÿ\0¸ÿ\0ÿ\0Cøò5ª\ì\r;\ç¤\È@÷\îz\é_A<‹\'\äbš¶FÀöf\í\ÅÀ(;N\ã@7;Ÿ:z\ïd®e”ùm\îô­^+L[\ÄVóòq”\áVcna\Ş\Û¸¥O.sğŠ4N½~\ã¿_\Ú÷W c°‹}\n6ÿ\04ô?Ê¼çŒ®RPFŸ\r5ò—¾µióv¯¨…)&„\áXej?‘\êN›\ë\ÔT\Ş\Ãn\Ş>ğÀ\×@¶\ÇO¾˜\àx#v\â¡öA4Ô“ >ššô¥U´WN§©¦§QÙºVtj6\Û2K\Ù+&\âÏ§=¦«ø‡»hIPVwRvˆÜü\ëføª~\Åğ\ÚA\äk2\Õf/“œrBN“<\ë.›‡Q§ ò\Şj=§\Ôóÿ\0,\È\0\ëûC\Ú*÷µœ8Zp\Éì·ˆm¶\Ä}ƒÒ³ö¶€Á0£^£\ìõ1[ñ\ÍN;—‰hÆ®\É8{Mq²\Û‘<\ãcş5y†\ì¥\Â%\ÙW\ã´\Î\ÓZ\Íğô³h0&\Ô¾»“\æiûøª\Ã=\\ÜœqôpŠ¶Ì3²\×J\Ã}±3µU\å\ÊJ¸s\Ögn„× \Ù\ÄkU]®\áÁ­÷¨ \Z<ö5lz©\îÛ“Ä¯\Ã5h\Ç\\#?ŸI\äIß¦Ÿe>_@9˜üG§\Ãz„\ï©òû£Ÿ?3Êµ‹\áa\Ïxú\é0y\ì¯\Şk^\\‹72\\.ˆ8.z\à\ÍØŸO·Î¦?d^4u>Q\ZDG§:\Õb±Q\×X{\Îir¸\"S„]Y„\Çğû–‰§\×\Ü5\ÛS\åQn·Ã¬’ ÿ\0‹×—º½+‡[ö\Ê0×‘\èkÎ¸•ƒn\ã!\Ğ	ó\Ğ\r}\ÚA\ëVŸ?k\Ã\ê‹Wˆµx\Zò™\Ü\ì~¸\çÖ¤\à0xœ‰§S\ëöm»T~„\ï\ïùªF‘óŒ\ë—x¯E[kmB(€>³\Ôù\Õu\Z\Í\í]BÆº³-o²—\Ö\à÷Gó\çP¸‡\0»hLf^ ‘¤lyZ\Ö6\'Z‘‡\ÄN‡QY»\Îhòù+\ÂN‘\æ¬\Úkõƒ\Ìsı}õ\Ì+ø¶ÿ\0X\ë\Ìùô«¾\Ûğ\Ñmƒ ğ·\Õ\×\î÷V£wNš{º}u\èBk$7\"\î4™\ëıñò¢›3Ex\Ö\Ï!\ã\Ç\å\ïÿ\0Ü¹ÿ\0™ü\Zô^Ë·ü>_\ç|a&ı\áÿ\0R\çO¦\ßXû+U\ØN$÷NF\Âü¡\ìj \å5\áFl}}Ë¼E0›Õ–\"\Å2–+f¨ó§†{‡°‡jÀö¶)ÿ\0|ô\è&·x\ÜJÙ¶]ùl:@Wb%Ø»n\Æ}\äò\êz`W}ø\Üü:\Z—\Ã™k\Ø÷ò\Úÿ\0\è±\î\éZüy2k\Ï0˜\ê\â<ó\äÀ~{yW¡Ùº—:÷CQ¬ÜŠ~e(´Š\ÖŞ¤\á	¥œ=H±b<«Œ\æ¨Ë÷¼?\'o®føEdpO‡\Ìóı“øò«~\×qv\îT2¨ ½O§*¤º\"\n\î5\Øò#\ê:ú×¡¥ƒ$™µò\Ú=5\Úm¤m”}•[t\×;/\Äõ “¢\0\ê?˜Ú¦]\Ã\Zó—Á\'óã”¹D{\ÍH\â¯ÿ\0\rv~…*\Î\ÕGl1\ê¶û•2\Æù°1\×\ì©K~D—™81\Ê	¶b¯·µ>}yŠô\Æ\Ü\Ó\Ç\Ò¬YŸR?˜\çW]Š\â\ëmŠ9\ĞøXô#@\ßq¯CW\Ï\Û\àh^\È\Õcw¨«3V˜›3Q—\r^|&¶˜òá“ğó¨¬_j`\â.G\Óú\âtó­\'–-—oğdò°›™Ü±Ô“\'üLwıŸ¾»h\â\Ü\Üü:\ZZq‚‹\'vÀ¾6Ô·\Ø+gŠ:W`n7C‰\Üz^±¡•\è8k\ëu¡~£\Ì\Zk#Yü	­É¤W¶õ#io‡ÖŸ\ÃØ®2š£.<\ŞTvÜ\Í\ÖwÍ¥b,¸‘øõür­mx’\Ülˆ|+§©O¦\Âk=euÿ\0^¼úzs­úX¸a\ä\Úé¯]¥düM\ãÙ°ó.\Ô\à¬U\åc¯xXrğ»_ü„{\ê%¦‚™\ê>¿Rzl+\×ûW\Ù[XÀ‰KŠ!]wŒ>pú\Ç\"+4¿“›Ÿ¬¡ÿ\0ñŸw\Ïøõ­ºoÄ°¼idt\×ö-ŸG“sÚ­¸\Ó\\@€q\Êg\ê?Î¤\\\ísG‚ÚƒÔ±?TU‘üœÜÿ\0ĞŸ\Ã<¿Åµòssõ„şøû[\Ñ\ê4-\Û~\Ìà´š…\áûŒF)\ï6k„±\r€ôŒNÚ»¡÷:\Ù\Ú\ìù\èÀª¹Š\ì²À¾ ù\Û$m\Ìf\ÔyUÖ¿L¸O\Ğ\äôZ‡.c\î`1\0¨|úı_}=Ã¸•\Ë&Qˆ\ÚA\ÔQ\ÏËŸkÿ\0\İ\Í\ß\ÖSøMë¯S\Ğò¥»›Ÿ¬/ğ\Ï_\Ş\Üó5wø†–J›\ãô;-e\á\îS\Û\í\È\Ö\Ú\×1T¶ q>\Ñ]º2\ÎU?5tÕ§\ì­!üš\Üıa?†ªº?&÷?Y_\áŸCó¹ôªGS ‹´ı™=\×7\Óû{s¼zû\Äm÷R®<˜û¹ï¤ôß•n?\İ\Õ\ÎX„şNÑ¾mü\é´ü›\Üÿ\0Ä¡\Ò#» GOknu\Ñş#¦ú½ˆZ<\İh\ÅZºP\æRT\î1·?\æjÿ\0\r\ÚÛª!\Õ_\ÌÊŸ|i5xß“»Ÿ¬/ğ\Ïó¤ŸÉ»ş°¿\Ã?Õ¿Rz\ÍO™û¤Î¿)E\í]\æmù‰\'\âvøU5\Æ$É“Ì“©÷\ë¿^µµ“‹Ÿ¬\'ğ\ÏõS‹ù<¸?ù	ü3ıT†³G\å~\Ä=&wùLB·\"=vúüµ¦ZĞ™šô\Ôõ­\Ã~N®\Ìşrƒ§É:ü\ît\èüŸ<A\Ä\'ğÏ»\ç­tş#¦ú½ˆ\îY\×Hû™n\Ç\ïZA½¡\Ü\nœı°¹@z’\Ç\êW\'òusõ…şş¯‡JIüœ\Üıa?†\Óÿ\0–õ\ÆZ¶½e¥\Ïôş\Æ;ˆq+—L¹$\ì6\0i°¾“†sÏ®›k—\ßÒ¶Còosõ„şt\Û\ÚÚ—ş\î\îLşr¾&u:k\íi·¾º\Ò\ÅT_±G™şS+qi8<m\Ë-š\Û\ê}G?´u­²ö\Çüõÿ\0!şªj\ç`ÿ\0\Ï_ò\êÚ«\ßô\ÍTŸ¡\Æ\Z-D_\Ë\îR\Û\ísó¶„ù1yA¨K´wn)\Z*Ÿšºhz±\Ö9t­+şNœÿ\0òøgú´¤\É\Ãş°¿\Ã>ÿ\0Î©F…;OÙû®¡®cû6$\É3ğ=9¾\\\êN\nn\\[k\í3e&	š\Ï![Aù9\ÖW×»3\ËÇ¿ŸJ\Ğö_²6p¤¸&\å\Â#;\02ƒ¸E\ÈøŸ:œÿ\0ŠaPjß‡_ò_‡$ŸÄ©\Ùã©¢¬¢»_?\ÛHõ;¼FnİŠa®´›­$\Ónñ\\$L?r_¼\Ød9Á¬ÌªL•¥v\×q©¥œz\È^ğI\Øf`‰:‘#\ÒEfn\á\r\ËD\â\\5—eP¹B¨.\äËq¼Z{ZNem\ÎUV\Ï\á;š\Û\İb#7.òò®\ïY_ S\Ş,4Á\Î \å’c¨gÒ˜\ÃqPÈ­\Ş™\ã8\Ğ0uò:\í¡\éU\\C«p‹ih[\\¤\É £r\Â\Ú\"[ƒ¨;\Zep¶óZ\\«›1\Ò±m\í!»\'\×Î‹hY£\\pß¼\Ğ_h{F o¾£M\Ì\Ô{œJ\àkz(´\Ê\íq\Ú\áRŠ‘¨`Ì‚e–\Õ&Å°‘”´DÒ°H`>”º\Ìf©7a‡4 ›\Ûq=e”z\ÓdS\Î2pªY@ps\0$£\âQ>u\Ë\Üi€o,e$¸İ©fw\'¤\Ö{\rbØ³\ØRM\á±\İ\0ı˜Or\î-³˜Y%m–sb‚\Éñ3	%Ô€OB*İœE—œS‹\İF„\\ğ¼\Ü)üYŠÂœ\Ì!`w\î/ˆ²\â ºøØ’\ìT\0«¯-OŸ•Ub0¬ø‚¡² \\e\ÌY\n\Ù9A\'\Ã2D\ë¤ú\Óüc÷	[`Nkm%\Ù2rûPu\Êth \ÕvÇ„Á3	\Æ{\ÆÈ—T´3{76V\ÈL˜\Zc¨\ÔHÖ¤œKÿ\0x’vÑ¿\çÖ¨0¼.ô:º o)‹Fl¨TøD\Â!×x\Ò*	\àı\Ş.Ò›I\0w²¢\Ñ\Ê9FË–]²$U0gIx\â\î™k0ø\æe\r˜\ê&$ı¼\é\ß\Î_\éCÀ~Š\Ù\äTˆšx/º¸IS,<qô\Ä\Ó¼c¢3),À ±\0· N°	bº\rE\âÁ¢\åb\È£4qD\å\ç\éHò\ĞÁñYP.:Û¹\r™;\Éıb¤Á)#xò§‹\Û‰¼£!\åÇ„°›_	9–úC­fñx;d¥»‘q»ølÀKµ•\ärRo|¥w–s\Ûgú¹tÀÕ˜]s˜s>;­\Ù\ã‹\ä‹4˜*©§x¹³¢.„<\æ$±]n*‘=òGˆ~‘w@Ks\ÜAk8m´–ù=;\Â2\æ. ]e7|\å6\È \Óÿ\0™\Ú7\î E…»h\rh¶¦<¾F¥;8‹.oñ4-\á\Ğ6¹]Â†‰˜\ß\Ö)œ\'¹\â\İd¶Â–¢\é%\Äf\Ô2¬¤u\ÓZœµù;›¨T\îÀú[Hı\Ú\çV\ë<J²”pEö\Õ}{¡?¹Eôİ0¥UÀR\\\ç…r\Èc°#0\Ş)ü7\ì\Æel°\ì«\'–a5\Å`\Ê\Ú(¡AW$!\Ëk>¹A’#mó<«¸\İ\Å$)!±\0†Š-\æóÁ‹G5À²ó‡q7¹s)XB «g$“\nX\Æ ‚v;s~\ÏUñ•Ca©$†LG\àòUİŸÃºø\ä	[j ÉŸ%H\ZT{œ>\ë•d\r´Y\ï\İ2\æÉ²•\Ì\ÃM[8ú5b\Û@\Ù\Í•ÿ\0ˆı]¿ŒŸÎ¹QÙ¯0^\\Ş£\İEI}\ê5\âyjcJ\äISfş\ë‹f\Û,2°š¬D4GS´ò§\î^Â›}şP\Ë\Ğ!$¦P±$jylj£À\îwVÁ-ówŒX´KdQ»6‹:óÖ¤7¾\ÚR#½Î·/\Ì\ÓÀ6ñ õ¦ù^\\\ßOı\Äb0‹g½\Ê[So\Ø!”\ne\"d\Ï\Özš\ã\Ü\ÃZ\"\ë(\ï.\ÆRªY\ßA°\Zùh*7ƒ]¸ªòJªX\ê.ºò›]£bz\Ó|\'‰¶l](·\nY\îY;À2\Ò[Pe@š›‘x\ä\É\\¯b{cğ®Çˆ3!‘\ÒÜ¶`}’€®ğüVl\ÛUNGB²“*@m\Ö@ ‚£ñ¬&â“–\Şqi\Ô$\0÷HX–\Ô\ÂI-¤š—\àKm2Û¹q…Ss0f„\Z \ÎU\Ö`\n„\åe£<]8ô±ü@±e—\äülºvó1[d—`	_ª â±˜5n\à\Ûˆ\ìwA\Ô÷¥sm˜\rTSœO…]¹qV\0¨ó9™L±(<,\ÇX \rê—‰ğlE\Ğ\Ö\ÈE	Ş²¶i7î€€\0H\ç½\äQ\äË¹\Ôx/øOµ{1Eem—B…•½–º£_!R®‹E€`¥£I\0\é?*\Â\\Sr\í\ÕTfÈªŠ\Ùò¥µ-I$©xm\î„x‰RD,fSl\Ï#$ZA©6\ÜCÿ\0FŒnN?QVû‚\ì¹RF‡Á¤À1˜ˆ&15\'„µßŸ…j»Ù›R§|t\0A\nR$ûkğs#Â‘-½µr\Z…\0\æ;¹f.‘ \ë­]¨ø6\\y\×A#—1\Ïjí¬UU€«÷Œù`j¬s»ô\ÓÎ­0\Î&g\ËßµRi.„‰š\â”·m®\\öPg:Iğ\ê s3OU½§Á5\ëÒ\Ü@äœ¾\à˜?KHªD\ÛQuÔ‹Š\âø51l£¡Dlö\â\äŸ:g}„ò£‹b°–V±š~]»»AÀ!¿Jñ±–\'7™¨|C³\ã¸İ¢©\î\Ænñ®;¬;\İ/&=•¨D\Óø÷koq\å·f\Ó\Ûˆ€÷ˆ\ç\0@\ØÁšnš2¹æª£Mc‡K–\Ğ*\ç¼MÁ\n5ğFgó+ \'}EA\â<O‡¸Q-4[9µd²[\Ş3²\èˆ\é©\Ô\ÓVø5\ÂËˆ7¼\ïUŠ\ÚÛ¶HÊ­!\' \ßNt«q6Ù­\Û\î{¾ñŸ½f%‚»f`Ö„KÁ\ß0R\æJFùT)ø¦\Û3-²Ím\Û]»²Ë–5hCSSxj\Ø\Ä*^TV6V*$fbXk´°3TÇ€;¸7X*—¯9K…Z_(¶3\"j|\ê\×\Ã\n÷wn[T\0-¥a\İøf3,I“©\×Z\\º–Œ²7mp	‹\Â\Ã\Ú\î¢İ¢In\ë\äƒ[i…a¡l\Ä\é¹3I\Äq,6¯İ¿xf\ÑN\è÷„4\Ü# \×)’\ÇÖª\ìp\Ä3d´\n\n#¶[¥n-\Â\ÌX\Ì®úš—{†bC›Ê¨\×¼‘œl¸TR\Z<yUuÚ£t}¦o/b\ß	}Ú½¿a¼Jb7\×\íš~\ßu”¼,	$\Ó}¹\Ôe\áÊ¸qa¼K\İ÷m\æ2\å?\Zf\Ïgm@˜nd”]d¼\í\0~\ì\ØHUr\ÍqºVY\æ·ô_øW¦Š_öjõ?şš)Á\'-\\2D@I`O¼rõ¥\\ a\Ô1` µË»CP\êÁŸ\Ã\Ù9D\ÚV\ÑFÑ¦\Ñ\"t\0kğ‘Nº–,M©$ı6\'^ l5\ØO\ßM½´,|(sdñwVÎ£.¥³Œ\Ş\ÌDH\Óx¤»ƒ”—(&\ÒfP#\çw“¤sÒ»ğ@\Íş˜m\"Ğ±º\Òv\å#—œzÌ»†Ã\í´\Ä\Â\Ç^ƒ*Š\ï\ã–PÀŒ\Ä÷V§]BIh\×a—sMº$©Ê¬@ƒ¬\í”N÷$\rH=u\éSÏ™»øk}\Ø[vù\Ì0¹\Z€\ÜôX\ëöF·„U”-\'@.\0\ê\'ª¹`.R*\r¥«;·„Œ\Ú0\0Şœ[hA³±=Õ™#\Ây´uõ÷Q*ñ®‚ÊŒ¬º[\Ã:\0N£\Ës\ëU]¢E,3-³#\ç\İ6Î“´¢u\å\çOa\ÑB\È*¹Š‚™m«‰(u‰\'œSüJ\rÀ3\ÛW@ö\Ã\îN£\á·\ÇqT\áJ\É)pv•C¶[D·„ˆ,2±†cYCx˜©8KvÇˆ-œ\áJ“\ß\0¶\ã¨\\ù˜\çN^ß…Ê·1Ü˜:·_g¹Lt\r»ªŸ\r\Ë\n\ç\"\ÖÌ²T€B»\Ôù\Å\îÁÇ²Š¬2YPL~™§2¯6\ä@?X®l†@,@b¦\ënºk9\Z\Õ\í‹vœJ¢“ó\0\Ô\Ä\î5\ØI\çT·\Ã[úşQø\æ~\'­sy£0B\å0ù\Ö\İi\"X\èIƒ%N\æ<<¹*\Å\Õ¥{€3	ùV\ÍC\ä[\Î#Î´]\ÂsE\çó|Ï—™øš\Z\ß\ĞN\È\å\î£ÈŸ€¡¼\Ü\é$£Cd9”\Ê~\ßh\ã\ÛV``Î¡u\å¿*’¨²\0@²˜\â\Êş÷—4a\ÏM\ã}*‘ù‰)p\äa,™t\ï‰ñN£S¼’|\Ï:M‹`bÁ‚\èıİš\×_dI\é£†AË†’L\íHlu5\Û6\ÄA?<.I”o¡A$òˆ\î@\æ-‡¥±*s[’\Ä\æ@–SõŸZZap›÷`ø§\çŸ\0ü`Q\Î\\+”Î‡.\Âù’w½\Úòå¸‘\İ\ç&S	;H4ò\ßP\×=A\Î$œ•Kdo\â[’	Í›M¹ŸC\êivm\Û[‰–İ°3h@¹*\0œu\ÓM6\ĞG1„\Âv‡w†Ô…‚6»€\Ûóµ8m¨ˆQ“\0‘¼F°cs\Z\ÔÒ h°·A0\'i\ÕH\Ó\ÊFµ\Å\Î\ÚY\Z‘&ó)\å¬j¹t:|j\ã‡\è\ÙC\ç`@P\0\0`@Š‹n\ŞmV\å¦%¦Ğ\ä\í\Z‰\Şú\É\ZòE°2\è‡$­¸Q ›\ÇI2uŸ¤£_/!2„\È\"\Z\Ç}˜õ\è@\Z\Ü\êöŠ¨ñM¡:o÷˜\ç>µ\'—Ù¸m7 \Şğ@oôÍ½Y¾eù·\ìıtT¹üM\ÎÁ©¶1]K„©ˆ\Ô|iŒI˜RL\Ô]`‹F^\Ø(«p5®ñòº\Í\á/¾ºÙŠs\Ú{‰qlœ¤ \Ò;¬\ê@‚	„¡N%`\È\ïS\ÂÁŸœ\Ìm¯2Ò£\Ì”»\ÜB\ÒÍ°\êU\ØP&4ˆ–ci¥\É}%~\å\âF\í‘pü”;¦—Š†\ÊTHr¢Tõ‰\é½r\Ş#Y3j	ÿ\0ˆ\Í\Ã02\ë@ú©\Ş!‹·q-\Ü7\ÙUu6\Æl\Ë\nse\Ê\Ç(s@6´´¹d(·ù\Ã\Ë0U\"4>\0:¤\0K “Í¢yQ5\\ F³uVX\\R&Iü\ãM H\Ë\0A>GC®•%8‰´¡AµP^ôo:—_ t¼b[XCrê—’\É\ĞnL)\nƒ0\ÔÀ\ÛZk…q:¨\ál\ÌD²6ib¦[À!t9Î‡8\×Z†\ít²Eÿ\0h»\\\r¹&\n\çlÀv•ñò\Z\è\ÇŞ¸·P°&m—’K6\'\î«|Bxf \ã0¹õ\Ïqtå‘®ÿ\0¨W5(\Ù$C%G3f\Ë\"Ó@ o\åH¶…!’\')›/3¡\Ğ#¶¡Z\Å\Û[‚\Ú\Ü\Ä>bPş\åe!šw\â`\é:°3I\Åñ;*“n\åû†m\åS\ß–\íÀŠÅ²NBI:{Y`IÒº¨·\Ñe\Î\"ê…³©\0-«»\î\0®ƒN¤ùÔ¯\í$‚şè‘¨F\ç2?T\Ö8­¤bn=\ÒFa%/0$Iq\Ø*\ËG!\Z\ïWœ3ˆÛ»*™\ä\0NkW5uH \ÇJ\ç(W€L,]%IÜt:øsT\èsQ±˜\ëiqm³Ì¥½– *Ä³!F»˜\çÒ¢\Û\ã6[@\Í9‚m\ÜKdËœğ\Ş$›\Ö)²O¢$´š\ÚU\Ûv\Ú¶d„7\n¡`Åµ\ÕÊ¬˜ù\íSV‘‹\Ä-´7˜4Œ±\n\0\0I$ TEÔ—¶#´¸‹a%\Z\à|ª®önÚ’\Ïw^\éUŸ6T\à\ÎP\rwı¢Æ¨v8W;R·_´\å%’K»Œ\Ì\00t«\Û|jÁ\ŞÖšñXˆ\ÙXD‚ˆŞ\ÂqkM—\ÄTµ\Î\è+++w‘0T‰\Z®Ú¢´n_A_¹[\Ån*\Ş|Ì« 7o/\Ì\ÓÂš}œ\ë¹Õ­™e‚+t\Éƒ+! Ÿ§\áOñ+öK¹7/€¹‰d\ï2o\Ú\nÁr–Dy†ó]±r\Õ\ÛÌ©r\îkk\ê\é\"D7‰Jı\Z‹\ã£$„\ä\ä\äœ\Ë7.‘:\"\åt#Ÿ35,q—˜=\×R®1‰\Z“]\é±<Ln^!©q„¤³¨\\¦Xh6;Škˆ[¸\ìˆI+û,Š’¬D0¤\éQ\'\Ç@+ƒ\â\Ú\â\É(\Ã@\nƒ\Ïf\ZhA\ç\ëQ\Æ&\â’Kù\ÃZa\0õL\èf¬°Ï­D\âøkVÓ¼{—UTe®4f l²bj‘i¾„lS>-ş\èÁ#\Ä7õúµ§%–Ak`ƒı\Ûú\î	óªkxûD€ÍˆHlŠr\Ş$¸\Ì\Ç^\ïp9CP\"N-o7\î›yQ³7}\â\ïI\n-˜¹09\×MÈ‹5Y\à\Z)9zŠ\åD‘ğÖ² I˜\ç\Ô\îO\Ä\×y§\ÓL*\Ø(GfT Sqƒ>!¬\İ9¼d10 ³‚\0\Î\Ú\ëK\Ävw1¸Z\ãp’\âÁvb¨KŠ\ß$¯wûZ^.”;WN\Ö~dR)8o¹iIK\ÄB\ä%­†9\Çu\ÊKB°\ÎA$004Ò—€\à¨®;w†X¬‚2–º÷gC3 \íİ‚<§1“K\r¡ä—˜¢“Šğ»(À*•Œ÷`Ú­\×%€9µS …A2\î€C÷p’\Ù\rÀ\0\Æ\Û!@ºœ‹òhñHŠµšz\ÖŞ”\íeUd\Ò;‰öj-=~\æ‘L!ª\à–š÷xKÁKŠP17r\æ`>køN£\é\ZH\à\ÖÁ]v6t\0ÿ\0%\0—1\ÍjÇ¼ƒ@j¾ùyŠ*mö~\Ê0 	q2“ ‹\Ä\Í;¶„O<\Æd\ëS°<.İµ¸ »Œ\æ¸ÄˆUP\Îhğ|\Ï-*@¹£\É\'ÕŠ)x\Ï\0·y¼NÀ\È\0Jø]d\\e/³™Á yÊ°|	{\Óq®;*\×\nµ¦Î‡A\á\nr\è7È³\Îlõ¡I\ZÓ´•UŠM3\Ä0)y»š¦ufK»`À)\áO\ZUD\é\Ú$¤»Ù›:\ê\à°ux0\r»™F@Ê¨TE@0‚I©>\ÎÚ„Ÿ\äò÷g4e\Ëp]’K*\Éi\' ;\ëV:U‡Š¿k/2)\ïğˆL\í\Î\ï0!! p\\\Ë9e†™u>\É<õ®a¸=«h¡Wb°ğ³¸ù\ÎV3$Á\ÓZ±w\Ì)° EFùyŠ)­öq?¼rH*ğ¶\×:0\nA\n€@Õ†¾&ò‰˜>\Z¶¦˜K0\Z:»w54<\Z.ty$\Õ6(fÜ†Š™v\Ú\ÜB$v\ÆAj F\ÄTiÚ¤#\Õ	*›[P°\Ï Ş‡\'3EòKj\ÜÁ\"É\Ì\ÉşÆ´bdÁB¢b;´È Dl	#¡3\ÈT\ÂdúSŠjİ¤¼È¤M\Ë\ëñ¢œ\ËEF\æ\n\ìG…ˆóûi¼ßıU#¯¾ıECüÉ‡:€\Õ\Ò\ã¥;ù£W	¨\Îı Seü¿Î¦~b\İi\'‡7Z5·¥5>8q\ëKüÅ¨nµ\ÅX©‡\İkŸ˜7\àT!4#õ©\Ù\íÖ¸8su ®0©?˜?_ª\Ì¯\ÕR\Ş\á\\ˆ©?˜?_ª»ıÿ\0K\ê¨7zR½H<9ºıU\ÑÃZ8Š\èAÒ¤g·ZW\æ\rô¾¡@GQ\\sR¾‘\á÷Š\é\á\ç¯\ÙAd,\Ãñ\é\Ó\î®\Ï\ãñÊ¥\æi_\Ù\ç¯\ÙAdE¥.¥~`zı”¡€ó?U	²(4öe€§—Ôš•f\ĞQ Šc”Wh¡EPQ@QE\0QEEPQ@QE\0QEEPQ@QE\0QEEPQ@QE\0QEEPQ@QE\0QEEPQ@QE\0QEEPQ@QE\0QEEPQ@ÿ\Ù','test@test.com','test@test.com','2022-06-12 17:49:05','2022-06-12 17:49:05');
/*!40000 ALTER TABLE `donatemedicine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ngo`
--

DROP TABLE IF EXISTS `ngo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ngo` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `ngoname` varchar(245) DEFAULT NULL,
  `userid` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ngo_ibfk_1` (`userid`),
  CONSTRAINT `ngo_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ngo`
--

LOCK TABLES `ngo` WRITE;
/*!40000 ALTER TABLE `ngo` DISABLE KEYS */;
INSERT INTO `ngo` VALUES (1,'Life Foundation',3),(2,'My Medicine NGO',4);
/*!40000 ALTER TABLE `ngo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requestmed`
--

DROP TABLE IF EXISTS `requestmed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `requestmed` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `ngoname` varchar(245) DEFAULT NULL,
  `brandname` varchar(245) DEFAULT NULL,
  `genericname` varchar(245) DEFAULT NULL,
  `deliveryaddress` varchar(245) DEFAULT NULL,
  `createdby` varchar(245) DEFAULT NULL,
  `modifiedby` varchar(245) DEFAULT NULL,
  `createddatetime` timestamp NULL DEFAULT NULL,
  `modifieddatetime` timestamp NULL DEFAULT NULL,
  `quan` bigint DEFAULT NULL,
  `senderno` varchar(245) DEFAULT NULL,
  `sendername` varchar(45) DEFAULT NULL,
  `ngoid` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ngoid` (`ngoid`),
  CONSTRAINT `requestmed_ibfk_1` FOREIGN KEY (`ngoid`) REFERENCES `user` (`id`),
  CONSTRAINT `requestmed_ibfk_2` FOREIGN KEY (`ngoid`) REFERENCES `user` (`id`),
  CONSTRAINT `requestmed_ibfk_3` FOREIGN KEY (`ngoid`) REFERENCES `user` (`id`),
  CONSTRAINT `requestmed_ibfk_4` FOREIGN KEY (`ngoid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requestmed`
--

LOCK TABLES `requestmed` WRITE;
/*!40000 ALTER TABLE `requestmed` DISABLE KEYS */;
INSERT INTO `requestmed` VALUES (1,'Life Foundation','Absorica','isotretinoin capsule','Near R K, Delhi, India','life@gmail.com','test@test.com','2022-06-12 17:44:44','2022-06-12 17:46:03',50,'9999999999','Test Test',3);
/*!40000 ALTER TABLE `requestmed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `firstname` varchar(245) DEFAULT NULL,
  `lastname` varchar(245) DEFAULT NULL,
  `loginid` varchar(245) DEFAULT NULL,
  `password` varchar(245) DEFAULT NULL,
  `roleid` int DEFAULT NULL,
  `rolename` varchar(45) DEFAULT NULL,
  `mobileno` varchar(245) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `uniqueproof` varchar(245) DEFAULT NULL,
  `createdby` varchar(245) DEFAULT NULL,
  `createddatetime` timestamp NULL DEFAULT NULL,
  `modifiedby` varchar(245) DEFAULT NULL,
  `modifieddatetime` timestamp NULL DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Admin','Admin','admin@admin.com','Admin#123',1,'Admin','9999999999','Female','ID123786',NULL,NULL,NULL,NULL,'1'),(2,'Test','Test','test@test.com','Test@123',2,'User','9999999999','Female','ID654523','root','2022-06-12 17:35:00','root','2022-06-12 17:35:00','1'),(3,'John','Wright','life@gmail.com','Life@123',3,'NGO','8888888888','Male','ID786','root','2022-06-12 17:38:27','root','2022-06-12 17:38:27','1'),(4,'Data','Data','med@gmail.com','Data@123',3,'NGO','9999999999','Male','ID1111','root','2022-06-12 17:42:28','root','2022-06-12 17:42:28','1');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-13 10:13:04
