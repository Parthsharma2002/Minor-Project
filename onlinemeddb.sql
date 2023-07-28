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
INSERT INTO `donatemedicine` VALUES (1,'Calpol','Paracetamol','2022-07-20','2023-10-05',12,2,4,_binary '�\��\�\0JFIF\0\0\0\0\0\0�\�\0�\0\n\Z\Z\Z\Z\Z\Z\Z\Z \Z!+#\Z)!$5%(,.222\Z!7<71;+12.1(#(13111341111.11111111111113111111111111311121111111��\0\0\�\0\�\"\0�\�\0\0\0\0\0\0\0\0\0\0\0\0\0\0�\�\0J\0	\0\0!1AQ\"aq2��#BR����3Tbr�\�\�S���$Ccs�\�D��4�\�\0\Z\0\0\0\0\0\0\0\0\0\0\0\0�\�\02\0\0\0\0\0\0\0!1AQ��\"2R�Bq�#3a���b�\�\0\0\0?\0�j(�P��(�+�h�Wh�(�\n+�\�\0��(�(�\n(��(��\0��(�(�\n(��(��\0��(wn;d0�\'mE\�\�L1�@v-\Z�A�V-�g�rO}�\�RޚL	RKyN\�E\�\�\�&\�ծ1�@�@���\����ݹ�36�6^�g�}6�C�$\�u\�g��Q9�\"\���\�~O�-r\�r}t�\�\�w�\��v�\�\�|j�	\�\��ι\�5-��mR.p�\r���\�\�9鯌k\�^\\����G�\�F0\�}�\�k\�\���wj��پF\�2\�\�Cn��/�pSlg�%u�=uߗ�*�Ǹ\"}�L9t��u\���\�Ez#�˙O�?R\�\�k�\�k|��[\�\�����7k������4��]\�Y\��\�\����\�:Q�kxe��N�r\�	5\"\'Nu9q鱫�W�;��/\�~�/�����\�ٓ~���\��\0~w�\�\�i\�|N´��aƝ\��>�U�O�h\�M�	\�>Dt\��)\�\�	}�^\�\'���*q�\�\"�\�}�|�i+���T/m8�\�\�Q�whnc\�mҢ\�\�̮ �g�\0zi\�\n�\� R|RA����hzV�\�WȽ\��mw\'\�i_���c�\'�h��K{�\�J�\�km}�ѧ0\�\��\�\��7\�x���<Z\�\0dGA\�w5����\����\�ֳO�A\�؛�W�u�?R�v������|\��w�\�\�Xo�Z\����;U\�\'�\�q\�\\�ȍ7����\��i@ >�:�->N�9���\'\�!�c\�C\�\�$��\�\�F\�ud��\�Ʒ\�?�v����u�˨.u�\�^�\�\��KouŻ`�>#��9y��Z|V\�y\�\�*��Yn��\��\�o˞O��{]�������;�®0}��ls\�\�{ *S�;\�\�z�+#��\�\ZdS�Ⱥ\���\����\��\�3���\ZE\�\�\�bOOb\�\�\�\�\�G*��x\�R�\�e\�D\�$\�\�}~#�g]g�\�\��\0\�\���\��+��,�d]d�M&�\�$\�/�o�\�o:]\�\�c@���\0�\�O\����\�:@\�\�yyr޴\�#�`�{�\��{\�o�ڣ.=>?�\�\�Lҗ\��Y�]��\�d��L{;\�Ok����ͮQ�\�SZt�\�Q\�G\��\�-ٻWk&\�l�U؊⧧o�i}�u�S�*�\�j\�\�\�rd����M<�浽�\�İ�x*]>\�Y\��\��\�m\'\�4\�a�\�28 �\�~\�8��\�\��.#��S�G�A�\�޺\�\�\�ɍ\�I?�u3��\�_\��\nh����W\��R=N��\�\�/\\<÷\�\��A\�[\�\�\�;�>c\���j���|iO{t��\0��Ǖzdq\�C���}6���<I>W\�r�[��%*:�e�Q\�e���W͡\�\�k\�+}\�\�O2��~\�F������睲~���:\"yt\�\�\�k�����Q�\r���\�5\�$��\�e��Gūs��\�m�b�%�y\'�A�\�P�2\rl1驮z��\�~DJR\�*�� �\�jN\�	��aZ�\�\�c\�9\�)?(XPn�3\� �\��n\r�S9Y���5#\�M<\��\�mu�7\���5\�9�}�o[t���zjT����An\� ��}@�wZ�.���\�G\�U����K�f-T����]֎\�a\�\�;5]}ӭ7a)\�;x&\��\�z���U8\��\Zi7~G�����#ב?�:\�~O��l��3�M�}\�\�X[�F1\�\�\�\�\��\�a�!�8�s\nݮO�6[\���,��\"�-ڕ�J���bƖ\�\�\�\�Y\�7�\���ﴸ2��1\�:D\�?��\��ע`QX\�\\z\�i�S\�A>�k?괺Q�{U��#-\�M�V�\'\�������\�>$-�Ru�X�\�FބV\��]Z�r�\"\�ok+\�\�#\rr��kR0�\�Ki������`�D�4#C\�t3���#�\Z�\0�\�u�^}+i�A��Ng_�\n\�\�\�]\�\�s\�\�kn��Ǔ\�k�{T\�\\�mEx�\�Ǹ�\�\����\0��w^�cپ(\�v\�h1�\�/�1U\�S��?\�7�\�?_\�JQ#\�\�H�MϞ\��j1�5t�FzVj�̌Q�����t�5\�\�PH�����\�\�\\m�\�X���,�9:�-\Z�?\�۴��\�H\�gϙ�Ā\'�\�i\�%�p)X�A���\�\�δc\�Kj�)\�\\�\"X|�0<�t�t�\�\�\�\�IyB\\`����~U�KzD}D�\"c��*I�t�\��4͂9�>�gK\�ӛ\rLcq��.ga<�jI�\�K���rs�t\�rI$�\�L��\�\�\�\\�_�\\\n�\�\"wƵ��\�A\�k�\r?MV\"6���A��\�\�_NSS4\�\���\�ʛE\�\�\Z�\�s\�\�\�[TU.�\�th�+ǕW����\�)?�g�*\�A�R<��6u\�=:\�\�9�\�ĺ{.\�\�\�k\�ҳdѩ\�tqMU��-�\��@ܓY.\����Oav��\�>1T�}\�\�37\�~N\�C3\��򞼪ش�\�\'l�QB\Z\�\�\�N\�\�?-&*_\�6\Z\�\�u:0&r�b�0\�\�ݿ�iվ�z\�:��_��+����^!ͪ7�,u�\��t ��|X\�\�\�`dr�������\�waб�oX\�\�\��p^\�.Z6��\�[FKl\�\�6Q��\�\�M\�-�\�i\�R7\�\��@\�\�\�����:\��o�ZӋp�A��!����\r� �C\�\�V��Ժ�]�\\�z�S�V>\�\�=\�\�nG˕0����\0��6\�T���Yy\���\�\�Zc��`K4�$\Z���k\�F\"\�\�y`>ݩ�\�]N�rv���:οw�K�\�\�sK\��\�p�<�r\�X\�\�Z��__��kʺS\�\�vӜh<�S�T�{�#�˞���a�.[\�h�=h��=<s����\0q�\0�o���S��	$\�hL�F\�|�oL�\�\��\0��\0�\0C��5�\�\r;\��\�@�\�z\�_A<�\'\�b��F��f\�\��(;N\�@7;�:z\�d�e��m\���^+L[\�V��q�\�Vcna\�\���O.s��4N�~\�_\��W�c��}\n6�\04�?ʼ献RP�F�\r5����i�v�����)&�\�Xej?�\�N�\�\�T\�\�n\�>��\�@��\�O��\�x#v\��A4ԓ�>����U��WN����Qٺ�Vtj6\�2K\�+�&\�ϧ=�����hIPVwRv�ܝ�\�f��~\��\�A\�k2\�f�/��rBN�<\�.��Q���\�j=�\���\0,\�\0\��C�\�*���8Zp\�췈m�\�}�ҳ����0�^�\��1[�\�N;��hƮ\�8{Mq�\���<\�c�5y�\�\�%\�W\�\�\�Z\����h0&\����\�i���\�=\\ܜq�p��̞3�\�J\�}�3�U\�\�J��s\�gn�נ\�\�kU]�\����� �\Z<�5lz�\�ۓį\�5h\�\\#?�I\�Iߦ�e>_@9��G�\�z�\�����?3ʵ�\�a\�x�\�0y\�\�k^\\�72\\.�8.z\�\�؟O�Φ?d^4u>Q\ZDG�:\�b�Q\�X{\�ir�\"S�]Y�\������\�\�5\�S\�Qn�ì���\0�ח��+�[�\�0ב\�kθ��n\�!\�	�\�\r}\�A\�V�?k\�\�W��x\Z�\�\�~�\�֤\�0x���S\��m�T~�\�\���F��\�x�E[kmB(�>�\��\�u\Z�\�\�]Bƺ�-o��\�\��G�\�P��\0�hLf^���ly�Z\�6\'Z��\�N�QY�\�h��+\�N�\�\�k��\�s�}�\�+���\0X\�\�����\��\�m���\�\�\��V�wN�{�}u\�Bk$7\"\�4�\���򢛏3Ex�\�\�!\�\�\�\��\0ܹ�\0��\Z�^˷�>�_\�|a&�\��\0R\�O�\�X�+U\�N$�NF\���\�j \�5\�Fl�}}˼E0�Ֆ\"\�2�+f��{���j���)�\0|�\�&�x\�Jٶ]�l:�@W�b%ػn\�}\��\�z`W}�\��:\Z�\��k\���\��\0\�\�\�Z�y2k\�0��\�\�<�\���~{yW�ٺ��:�CQ��܊~e(��\�ޤ\�	��=H�b<��\�ˏ���?\'o�f�EdpO�\������~\�qv\�T2� �O�*��\"\n\�5\��#\�:�ס���$���\�=5\�m�m�}�[t\�;/\�����\0\�?�ڦ]\�\Z��\'�㔹D{\�H\��\0\rv~�*\�\�Gl1\���2\���1\�\�K~D��81\�	�b���>}y��\�\�\�\�\��Y�R?�\�W]�\�\�m�9\��X�#@\�q�CW�\�\�\�h^\�\�cw��3V��3Q�\r^|&���ᓝ���_j`\�.G\��\�t�\'�-�o��d����ܱԓ\'�Lw����h\�\�\��:\ZZq��\'v��6Է\�+g�:W�`n7C�\�z�^���\�8k\�u��~�\�\Zk#Y�	�ɤW��#io�֟\�خ2��.<\�Tv܏\�\�wͥb,�����r�mx�\�l�|+���O�\�k=eu�\0^��zs��X�a\�\�鞯]�d�M\�ٰ�.\�\���U\�c�xXr�_��{\�%���\�>�Rzl+\��W\�[X��K�!]w��>p�\�\"+4�������\0�w\�����oİ�idt\��-�G�sڭ�\�\\@�q\�g\�?Τ\\\�sG�ڃԱ?TU���܏�\0П\�<�ŵ�ss�����[\�\�4-\�~\�ച�\���F)\�6k��\r���Nڏ���:\�\�\���\�����\������\�$m\�f\�yUֿL�O�\�\��Z�.c\�`1\0��|��_}=ø�\�&Q�\�A\�Q\�˟�k�\0\�\�\�\�S�M믏S\������/�\�_\�\��5w���J�\��;-e\�\�S\�\�\�\�\�\�1T��q>\�]�2\�U?5tՎ�\�!��\��a?���?&�?Y_\�C���GS�����=\�7\��{s�z�\�m�R�<���欄�ߕn?\�\�\�X��NѾm�\���\��\0ġ\�#� GOknu\��#����Z<\�h\�Z�P\�RT\�1�?\�j�\0\r\�۪!\�_\�ʟ|i5xߓ���/�\��ɻ���\�?տ�Rz\�O���ο)E�\�]\��m��\'\�v�U5\�$ɓ̓��\�^������\'�\��S��<�?�	�3�T��G�\�~\�=&w�LB�\"=v����ZЙ���\���\�~N�\��r��ɝ:�\�t\���<A\�\'�ϻ\��t�#����\�Y\�H��n\�\�ZA��\�\n����@z�\�\�W\'�us������JI��\��a?�\��\0��\�Z����e�\���\�;�q+�L�$\�6\0i����sϮ�k�\�ҶC�os���t\�\�ڗ�\�\�L�r�&u:k\�i���\�\�T_�G��S+qi8<m\�-�\�\��}G?�u���\����\0!��j\�`�\0\�_�\�ګ\��\�T��\�\Z-D_\�\�R\�\�s��1yA�K�wn)\Z*���hz�\�9t�+�N��\0��g����\�\����\�>�\0�ΩF�;Oٝ����c�6$\�3�=9��\\\�N\nn\\[k\�3e&	���\�![A�9\�W׻3\�ǿ�J\��_�6p��&\�\�#;\02��E\���:��\0�aPj߇_�_�$�ĩ\�㩢���_?\�H�;�Fn݊a�����$\�n�\\�$L?r_�\�d9��̪L���v\�q���z\�^�I\�f`��:�#\�Efn\�\r\�D\�\\5�eP�B�.\�ˁq�Z{ZN�em\�UV\�\�;�\�\�b#7.��\�Y_� S\�,4�\� \�c�gҘ\�qPȭ\��\�8\�0�u�:\�\�U\\C�p�ih[\\�\� �r\�\�\"[��;\Zep��Z\\��1\��m\�!�\'\�΋hY�\\p߼\�_h{F o��M\�\�{�J\�kz(�\�\�q\�\�R���`̂e�\�&Ű���DҰH`>���\�f�7�a�4���\�q=e�z\�dS�\�2p�Y@ps\0$�\�Q>u\�\�i�o,e$�ݩf�w\'�\�{\rbس�\�RM\��\�\0��O�r\�-��Y%m�sb�\��3	%ԀOB*ݜE��S�\�F�\\��\�)�Y�\�!`w\�/��\� ��ؒ\�T\0��-O��Ub0������\\e\�Y\n\�9A\'\�2D\��\��c�	[`Nkm%\�2�r�Pu\�th \�vǄ�3	\�{\�ȗT�3{76V\�L�\Z�c�\�H֤�K�\0x�vю�\�֨0�.�:��o)�Fl�T�D\�!מx\�*	\��\�.қI\0w��\�\�9F˖]�$U0gIx\�\�k0�\�e\r�\�&$��\�\�\�_\��C�~�\�\�T��x/��IS,<q�\�\��c�3),���\0� N�	�b�\rE\����\�b\��4qD\�\�\�H�\���YP.:۹\r�;\��b��)#x��\����!\�Ǆ��_	9��C�f�x;d���q��l�K��\�rRo|�w�s\�g��t�՘]s�s>;�\�\�\�4��*��x���.�<\�$��]n*�=�G�~�w@Ks\�A��k8m���=;\�2\�. ]e7|\�6\� \��\0�\�7\�E��h\rh��<�F�;8�.o�4-\�\�6�]��\�\�)�\'��\�\�d��\�%\�f\�2��u\�Z���;��T\���[H�\�\�V\�<J��pE�\�}{�?�E�ݞ0�U��R\\\��r\�c�#0\�)�7\�\�el�\�\'�a5�\�`\�\�(�AW$!\�k>�A�#m�<��\�\�$)!�\0��-\�����G�5���q7�s)XB��g$�\nX�\� �v;s~\�U��Ca�$�LG\��Uݟú��\�	[j ɟ%H\ZT{�>\�d\r�Y\�\�2\�ɲ�\�\�M[8�5b\�@\�\���\0��]���ιQٯ0^\\ޣ\�EI}\�5\�yjcJ\�ISf�\�f\�,2���D4GS��\�^}�P\�\�!$�P�$jylj��\�wV�-��w�X�KdQ�6�:�֤7�\�R#�η/\�\��6����^\\\�O�\�b0�g�\�[So\�!�\ne\"d\�\�z�\�\�\�Z\"\�(\�.\�R�Y\�A�\Z��h*7�]����J�X\�.���]�bz\�|\'��l](�\nY\�Y;�2�\�[Pe@���x\�\�\\�b{c�ǈ3!�\�ܶ`}�����Vl\�U�NGB��*@m\�@ ����&ⓖ\�qi\�$\0�HX�\�\�I-����\�Km2۹q�Ss0f�\Z \�U\�`\n�\�e�<�]8���@�e�\��l�v�1[d�`	_��ⱘ5n\�\���\�wA\���sm�\rTS�O�]�qV\0��9�L�(<,\�X \rꗉ�lE\�\�\�E	޲�i7�\0H\�\�Q\�˹\�x/�O�{1Eem�B�������_!R��E�`��I\0\�?�*\�\\Sr\�\�TfȪ�\�򥵁-I$��x�m\��x�RD,fSl\�#$ZA��6\�C�\0F�nN?QV��\�RF����1��&15\'��ߟ�j�ٛR�|�t\0A\nR$�k�s#-��r\Z�\0\�;�f.��\�]��6\\�y\�A#�1\�j크UU������`j��s��\�έ0\�&g\�ߵRi.���\���m�\\�Pg:I�\� s3OU���5\�Ґ\�@䜾\��?KH�D\�Quԋ�\��51l��Dl�\�\�:�g}��b��V��~]��A�!�J�\'7��|C�\�ݢ�\�\�n�;�;\�/&=��D\���koq�\�f\�\������\�\0@\���n�2�檣Mc�K�\�*\�M�\n5�Fg�+�\'}EA\�<O��Q-4[9�d�[\�3�\��\�\�\�V�5\�ˈ7�\�U�\�۶Hʭ!\'�\�Nt�q6٭\�\�{��f%��f`քK�\�0R\�J�F�T)��\�3-�͝m\�]��˖5hCSSxj\�\�*^TV6V*$fbXk��3Tǀ;�7X*��9K�Z_(�3\"j|\�\�\�\n�wn[T\0-�a\��f3,I��\�Z\\����7mp	�\�\�\�\�ݢIn\�\�[i�a�l\�\�3I\�q,6�ݿxf\�N\���4\�# \�)�\�֪\�p\�3d��\n\n#�[�n-\�\�X�\�����{�bC�ʨ\�����l�TR\Z<yUuڣt�}�o/b\�	}ڽ�a�Jb7\�\�~\�u��,	$�\�}�\�e\�ʸqa�K\��m\�2\�?\Zf\�gm@�nd�]d�\�\0~�\�\�HUr\�q�VY\��_�W��_�j�?��)�\'-\\2D@I`O�r��\\�a\�1`��˻CP\���\�\�9D\�V\�F�Ѧ\�\"t\0k�N��,M�$�6\'^�l5\�O\�M��,|(sd�wVΣ.���\�\�DH\�x�����(&\�fP#\�w���sһ�@\���m\"б�\�v\�#��z̻�Ý\��\�\�\�^�*�\�\�P��\��V�]BIh\�a�sM�$�ʬ@��\�N�$\rH=u\�Sϙ��k}\�[v�\�0�\Z�\��X\��F��U��-\'@.�\0\�\'��`.R*\r��;����\�0\0ޜ[hA���=ՙ#\�y�u��Q*���ʌ��[\�:\0N�\�s\�U]�E,3-�#\�\�6Γ��u\�\�Oa\�B\�*����m��(u�\'�S�J\r�3\�W@�\�\�N�\�\�qT\�J\�)pv�C�[D����,2��cY�Cx��8Kvǈ-�\�J�\�\0�\�\\��\�N^߅�ʷ1ܘ:�_g��Lt\r���\r\�\n\�\"\�̲T�B��\��\�\��ǲ��2YPL~��2�6\�@?X�l�@,@b�\�n�k9\Z\�\�v�J���\0\�\�\�5\�I\�T�\�[��Q�\�~\'�sy�0B\�0�\�\�i\"X\�I�%N\�<<�*\�\��{�3	�V\�C\�[\�#δ]\�sE\��|ϗ���\Z\�\�N�\�\�\�ȟ���\�\�$�Cd9�\�~\�h�\�\�V``Ρu\�*���\0@��\�\����4a\�M\�}*���)p\�a,�t\��N�S��|\�:M�`�b��\��ݎ�\�_dI�\��Aˆ�L\�Hlu5\�6�\�A?<.I�o�A$�\�@\�-���*s[�\�\�@�S��ZZap��`��\�\0�`Q\�\\+�·.\���w��\��帑\�\�&S	;H�4�\�P\�=A\�$���Kdo\�[�	͛M��C\�ivm\�[��ݰ3h@�*\0��u\�M6\�G1��\�v�w�ԅ�6��\��8m��Q��\0��F�cs\Z\�Ҡh��A0\'i\�H\�\�F��\�\�\�Y\Z�&�)\�j�t:|j\�\�\�C\�`@P\0�\0`@��n\�mV\�%�Н\�\�\Z�\��\�\Z�E�2\�$��Q �\�I2u���_/!2��\�\"\Z\�}��\�@�\Z\�\�����M�:o��\�>�\'�ٸm7 \��@o�ͽY�e��\��tT��M\����1]K����\�|i�I�RL��\�]`�F^\�(�p5����\�\�/��يs\�{��ql�� \�;�\�@�	��N%`\�\�S\����\�m��2ң\���\�B\�Ͱ\�U\�P&4��ci�\�}%~\�\�F\�p��;����\�THr�T��\�r\�#Y3j	�\0�\�\�02\�@��\�!��q-\�7\�U�u6\�l\�\nse\�\�(�s@6���d(��\�\�0U\"4>\0:�\0K��͢yQ5\\ F�uVX\\R&I�\�M�H\�\0A>GC��%8���A�P^�o:�_ t�b[XCrꗒ\�\�nL)\n�0\��\�Zk�q:�\�l\�D�6ib�[�!t9·8\�Z�\�t�E�\0h�\\\r�&\n\�l�v���\Z\�\�޸�P�&m��K6\'\�|Bxf�\�0��\�qt�呮�\0�W5(\�$C�%G�3f\�\"Ӟ@��o\�H��!�\')�/3�\�#��Z\�\�[�\�\�\�>bP��\�e!�w\�`\�:�3I\��;*�n\���m\�S\��\���ŲNBI:{Y`IҺ��\�e�\�\"ꅳ�\0-��\�\0��N��ԯ\�$��葨F\�2?T\�8��bn=\�Fa%/0$Iq\�*\�G!\Z\�W�3�ۻ*�\�\0NkW5uH \�J\�(W�L,]%I܍t:�sT\�sQ��\�iqm�̥�� *ĳ!F��\�Ң\�\�6[@\�9��m\�Kd˜�\�$�\�)�O�$���\�U\�v\��d�7\n�`ŵ\�ʬ��\�SV��\�-�7�4��\n\0\0I$� TEԗ�#���a%\Z\�|���nڒ\�w^\�U�6T\�\�P\rw��ƨv8W;R�_��\�%�K��\�\00t�\�|j�\�֚�X�\�X�D��ޞ\�qkM�\�T�\�\�+++w�0T�\Z�ڎ��n_A_�[\�n*\�|̫ 7o/\�\�}�\�խ�e�+t\��+!���\�O�+�K�7/���d\�2o\�\n�r�Dy��]�r\�\�̩r\�kk\�\�\"D7�J�\Z�\�$�\�\�\�\�7.�:\"\�t#�35,q��=\�R�1�\Z��]\��<Ln^!��q����\\�Xh6;��k�[�\�I+�,���D0�\�Q\'\�@+�\�\�\�\�(\�@\n�\�f\ZhA\�\�Q\�&\�K�\�Za\0��L\�f��ϭD\��kVӼ{�UT�e�4f l�bj�i���lS>-�\��#\�7�����%�Ak`��\��\�	�kx�D�͈Hl�r\�$�\�\�^\�p9CP\"�N-o7�\�yQ�7}\�\�I\n-��09\�M�ȋ5Y�\�\Z)9z�\�D��ֲ I�\�\�\�O\�\�y�\�L*�\�(GfT�Sq�>!�\�9�d10���\0\�\�\�K\�vw1�Z\�p�\��vb�K�\�$�w�Z^.�;WN\�~dR)8o�iIK\�B\�%��9\�u\�KB�\�A$004җ�\��;w�X��2���gC3 \�݂<�1�K\r�䗘�����(�*���`ڭ\�%�9�S �A2\��C��p�\�\r�\0\�\�!@����h�H���z\�ޔ\�eUd\�;��j-=~\�L!�\����xK�K�P17r\�`>k�N�\�\ZH\�\��]v6t\0�\0%\0�1\�jǼ�@j��y�*m�~\�0 	q2� �\�\�;��O<\�d\�S�<.ݵ����\�ĈUP\�h�|\�-*@��\�\'Պ)x\�\0�y�N�\�\0J�]d\\e/��� yʰ|	{\�q�;*\�\n��·A\�\nr\�7ȳ\�l���I\ZӴ�U�M3\�0)y���ufK�`�)\�O\ZUD\�\�$��ٛ:\�\�ux0\r��F@�ʨTE@0�I�>\�ڄ�\���g4e\�p]��K*\�i\' ;\�V:U���k/2)\���L�\�\�\�0!! p\\\�9e��u>\�<��a�=�h�Wb���\�V3$�\�Z�w\�)� EF�y�)��q?�rH*�\�:0\nA\n�@Ն�&�>\Z�����K0\Z:�w54<\Z.�ty$\�6(f܆��v\�\�B�$v\�Aj F\�Tiڤ#\�	*��[P�\� އ\'3E�Kj\��\"Ɂ\�\��ƴbd�B�b;�ȠDl	#�3\�T\�d�S�jݤ�ȤM\�\��\�EF\�\n\�G����i�ߏ�U�#���EC�ɇ:�\�\�\�;��W	�\�� Se��Φ~b\�i\'�7Z5��5>8q\�K�Ũn�\�X��\�k��7\�T!4#��\�\�ָ8su��0�?�?_��\��\�R\�\�\\��?�?_�����\0K\�7zR�H<9��U\�ÏZ8�\�AҤg�ZW\�\r���@GQ\\sR��\���\�\�\�\�Ad,\��\�\�\�\�\��ʥ�\�i_\�\�\�AdE�.�~`z�����?U	�(4�e���Ԛ�f\�Q��c�Wh�EPQ@QE\0QEEPQ@QE\0QEEPQ@QE\0QEEPQ@QE\0QEEPQ@QE\0QEEPQ@QE\0QEEPQ@QE\0QEEPQ@�\�','test@test.com','test@test.com','2022-06-12 17:49:05','2022-06-12 17:49:05');
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
