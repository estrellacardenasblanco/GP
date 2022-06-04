PGDMP                         y           pweb_ias    9.5.15    12.0 �    	           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            	           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            	           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            	           1262    94757    pweb_ias    DATABASE     �   CREATE DATABASE pweb_ias WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Spain.1252' LC_CTYPE = 'Spanish_Spain.1252';
    DROP DATABASE pweb_ias;
                postgres    false            	           0    0    SCHEMA public    ACL     �   REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;
                   postgres    false    7            �            1255    94758    authentication_delete(integer)    FUNCTION     �   CREATE FUNCTION public.authentication_delete(auth_id_0 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 delete  from "authentication"
   where "auth_id"= $1; 
 END;$_$;
 ?   DROP FUNCTION public.authentication_delete(auth_id_0 integer);
       public          postgres    false            �            1255    94759 �   authentication_insert(integer, integer, integer, integer, integer, integer, integer, integer, integer, integer, integer, integer, integer, integer, double precision)    FUNCTION     9  CREATE FUNCTION public.authentication_insert(userid_0 integer, passid_1 integer, dateid_2 integer, typeid_3 integer, x1_5 integer, y1_6 integer, x2_7 integer, y2_8 integer, x3_9 integer, y3_10 integer, x4_11 integer, y4_12 integer, x5_13 integer, y5_14 integer, l_15 double precision) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN 
 insert into authentication(userid,passid,dateid,typeid,x1,y1,x2,y2,x3,y3,x4,y4,x5,y5,l)values("userid_0","passid_1","dateid_2","typeid_3","x1_5","y1_6","x2_7","y2_8","x3_9","y3_10","x4_11","y4_12","x5_13","y5_14","l_15"); 
  END;$$;
   DROP FUNCTION public.authentication_insert(userid_0 integer, passid_1 integer, dateid_2 integer, typeid_3 integer, x1_5 integer, y1_6 integer, x2_7 integer, y2_8 integer, x3_9 integer, y3_10 integer, x4_11 integer, y4_12 integer, x5_13 integer, y5_14 integer, l_15 double precision);
       public          postgres    false            �            1255    94760 �   authentication_update(integer, integer, integer, integer, integer, integer, integer, integer, integer, integer, integer, integer, integer, integer, integer)    FUNCTION     �  CREATE FUNCTION public.authentication_update(userid_0 integer, passid_1 integer, dateid_2 integer, typeid_3 integer, auth_id_4 integer, x1_5 integer, y1_6 integer, x2_7 integer, y2_8 integer, x3_9 integer, y3_10 integer, x4_11 integer, y4_12 integer, x5_13 integer, y5_14 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 update "authentication"
 SET userid=$1,passid=$2,dateid=$3,typeid=$4,x1=$6,y1=$7,x2=$8,y2=$9,x3=$10,y3=$11,x4=$12,y4=$13,x5=$14,y5=$15 where "auth_id"= $5; 
 END;$_$;
   DROP FUNCTION public.authentication_update(userid_0 integer, passid_1 integer, dateid_2 integer, typeid_3 integer, auth_id_4 integer, x1_5 integer, y1_6 integer, x2_7 integer, y2_8 integer, x3_9 integer, y3_10 integer, x4_11 integer, y4_12 integer, x5_13 integer, y5_14 integer);
       public          postgres    false            �            1255    94761 �   authentication_update(integer, integer, integer, integer, integer, integer, integer, integer, integer, integer, integer, integer, integer, integer, integer, double precision)    FUNCTION       CREATE FUNCTION public.authentication_update(userid_0 integer, passid_1 integer, dateid_2 integer, typeid_3 integer, auth_id_4 integer, x1_5 integer, y1_6 integer, x2_7 integer, y2_8 integer, x3_9 integer, y3_10 integer, x4_11 integer, y4_12 integer, x5_13 integer, y5_14 integer, l_15 double precision) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 update "authentication"
 SET userid=$1,passid=$2,dateid=$3,typeid=$4,x1=$6,y1=$7,x2=$8,y2=$9,x3=$10,y3=$11,x4=$12,y4=$13,x5=$14,y5=$15,l=$16 where "auth_id"= $5; 
 END;$_$;
 /  DROP FUNCTION public.authentication_update(userid_0 integer, passid_1 integer, dateid_2 integer, typeid_3 integer, auth_id_4 integer, x1_5 integer, y1_6 integer, x2_7 integer, y2_8 integer, x3_9 integer, y3_10 integer, x4_11 integer, y4_12 integer, x5_13 integer, y5_14 integer, l_15 double precision);
       public          postgres    false            �            1255    94762    date_delete(integer)    FUNCTION     �   CREATE FUNCTION public.date_delete(dateid_0 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 delete  from "date"
   where "dateid"= $1; 
 END;$_$;
 4   DROP FUNCTION public.date_delete(dateid_0 integer);
       public          postgres    false            �            1255    94763    date_insert(date)    FUNCTION     �   CREATE FUNCTION public.date_insert(date_0 date) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN 
 insert into date(date)values("date_0"); 
  END;$$;
 /   DROP FUNCTION public.date_insert(date_0 date);
       public          postgres    false            �            1255    94764    date_update(date, integer)    FUNCTION     �   CREATE FUNCTION public.date_update(date_0 date, dateid_1 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 update "date"
 SET date=$1 where "dateid"= $2; 
 END;$_$;
 A   DROP FUNCTION public.date_update(date_0 date, dateid_1 integer);
       public          postgres    false            �            1255    94765    date_update(integer, date)    FUNCTION     �   CREATE FUNCTION public.date_update(dateid_0 integer, date_1 date) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 update "date"
 SET date=$2 where "dateid"= $1; 
 END;$_$;
 A   DROP FUNCTION public.date_update(dateid_0 integer, date_1 date);
       public          postgres    false            �            1255    94766    find_authentication(integer)    FUNCTION     �   CREATE FUNCTION public.find_authentication(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from authentication
where auth_id= $1; ;

       $_$;
 3   DROP FUNCTION public.find_authentication(integer);
       public          postgres    false            �            1255    94767 %   find_authenticationbyauth_id(integer)    FUNCTION     �   CREATE FUNCTION public.find_authenticationbyauth_id(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from authentication
where auth_id=$1 ;

       $_$;
 <   DROP FUNCTION public.find_authenticationbyauth_id(integer);
       public          postgres    false            �            1255    94768    find_date(integer)    FUNCTION     �   CREATE FUNCTION public.find_date(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from date
where dateid= $1; ;

       $_$;
 )   DROP FUNCTION public.find_date(integer);
       public          postgres    false            �            1255    94769    find_datebydateid(integer)    FUNCTION     �   CREATE FUNCTION public.find_datebydateid(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from date
where dateid=$1 ;

       $_$;
 1   DROP FUNCTION public.find_datebydateid(integer);
       public          postgres    false            �            1255    94770    find_pass_given_user(integer)    FUNCTION       CREATE FUNCTION public.find_pass_given_user(integer) RETURNS refcursor
    LANGUAGE plpgsql
    AS $_$declare 
pass_list refcursor;
begin
open pass_list for 
select picture.name, (password.x1, password.y1) as pto1,
(password.x2, password.y2) as pto2, (password.x3, password.y3) as pto3,
(password.x4, password.y4) as pto4, (password.x5, password.y5) as pto5,
userid
from user_password
join password on user_password.passid= password.passid
join picture on password.pictureid= picture.pictureid
where userid=$1;
return pass_list;
end;$_$;
 4   DROP FUNCTION public.find_pass_given_user(integer);
       public          postgres    false            �            1255    94771    find_password(integer)    FUNCTION     �   CREATE FUNCTION public.find_password(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from password
where passid= $1; ;

       $_$;
 -   DROP FUNCTION public.find_password(integer);
       public          postgres    false            �            1255    94772 '   find_password_x_user(character varying)    FUNCTION     5  CREATE FUNCTION public.find_password_x_user(character varying) RETURNS refcursor
    LANGUAGE plpgsql
    AS $_$declare 
pass_list refcursor;
begin 
open pass_list for
select password.*,picture.name, securityquestion.question, securityquestion.answer
from user_password
join  password on user_password.passid= password.passid
join picture on password.pictureid= picture.pictureid
join securityquestion on password.questionid = securityquestion.questionid
join public.user on user_password.userid = public.user.userid
where username= $1;
return pass_list;
end;
$_$;
 >   DROP FUNCTION public.find_password_x_user(character varying);
       public          postgres    false            �            1255    94773    find_passwordbypassid(integer)    FUNCTION     �   CREATE FUNCTION public.find_passwordbypassid(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from password
where passid=$1 ;

       $_$;
 5   DROP FUNCTION public.find_passwordbypassid(integer);
       public          postgres    false            �            1255    94774    find_picture(integer)    FUNCTION     �   CREATE FUNCTION public.find_picture(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from picture
where pictureid= $1; ;

       $_$;
 ,   DROP FUNCTION public.find_picture(integer);
       public          postgres    false            �            1255    94775 %   find_picturebyname(character varying)    FUNCTION     �   CREATE FUNCTION public.find_picturebyname(character varying) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from picture
where name=$1 ;

       $_$;
 <   DROP FUNCTION public.find_picturebyname(character varying);
       public          postgres    false            �            1255    94776     find_picturebypictureid(integer)    FUNCTION     �   CREATE FUNCTION public.find_picturebypictureid(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from picture
where pictureid=$1 ;

       $_$;
 7   DROP FUNCTION public.find_picturebypictureid(integer);
       public          postgres    false            �            1255    94777    find_profession(integer)    FUNCTION     �   CREATE FUNCTION public.find_profession(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from profession
where profid= $1; ;

       $_$;
 /   DROP FUNCTION public.find_profession(integer);
       public          postgres    false            �            1255    94778     find_professionbyprofid(integer)    FUNCTION     �   CREATE FUNCTION public.find_professionbyprofid(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from profession
where profid=$1 ;

       $_$;
 7   DROP FUNCTION public.find_professionbyprofid(integer);
       public          postgres    false            �            1255    94779    find_rolbyroleid(integer)    FUNCTION     �   CREATE FUNCTION public.find_rolbyroleid(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from role
where roleid=$1 ;

       $_$;
 0   DROP FUNCTION public.find_rolbyroleid(integer);
       public          postgres    false            �            1255    94780    find_role(integer)    FUNCTION     �   CREATE FUNCTION public.find_role(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from role
where roleid= $1; ;

       $_$;
 )   DROP FUNCTION public.find_role(integer);
       public          postgres    false            �            1255    94781    find_securityquestion(integer)    FUNCTION     �   CREATE FUNCTION public.find_securityquestion(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from securityquestion
where questionid= $1; ;

       $_$;
 5   DROP FUNCTION public.find_securityquestion(integer);
       public          postgres    false            �            1255    94782 *   find_securityquestionbyquestionid(integer)    FUNCTION     �   CREATE FUNCTION public.find_securityquestionbyquestionid(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from securityquestion
where questionid=$1 ;

       $_$;
 A   DROP FUNCTION public.find_securityquestionbyquestionid(integer);
       public          postgres    false            �            1255    94783    find_type(integer)    FUNCTION     �   CREATE FUNCTION public.find_type(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from type
where typeid= $1; ;

       $_$;
 )   DROP FUNCTION public.find_type(integer);
       public          postgres    false            �            1255    94784    find_typebytypeid(integer)    FUNCTION     �   CREATE FUNCTION public.find_typebytypeid(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from type
where typeid=$1 ;

       $_$;
 1   DROP FUNCTION public.find_typebytypeid(integer);
       public          postgres    false            �            1255    94785    find_user(integer)    FUNCTION     �   CREATE FUNCTION public.find_user(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from public.user
where userid= $1; ;

       $_$;
 )   DROP FUNCTION public.find_user(integer);
       public          postgres    false            �            1255    94786 $   find_user_by_name(character varying)    FUNCTION     �   CREATE FUNCTION public.find_user_by_name(character varying) RETURNS record
    LANGUAGE sql
    AS $_$select * from public.user 
where username= $1;  $_$;
 ;   DROP FUNCTION public.find_user_by_name(character varying);
       public          postgres    false            �            1255    94787    find_user_by_userid(integer)    FUNCTION     �   CREATE FUNCTION public.find_user_by_userid(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from public.user
where userid= $1; ;

       $_$;
 3   DROP FUNCTION public.find_user_by_userid(integer);
       public          postgres    false            �            1255    94788    find_user_password(integer)    FUNCTION     �   CREATE FUNCTION public.find_user_password(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from public.user_password
where user_passid= $1; ;

       $_$;
 2   DROP FUNCTION public.find_user_password(integer);
       public          postgres    false            �            1255    94789 #   find_user_passwordbypassid(integer)    FUNCTION     �   CREATE FUNCTION public.find_user_passwordbypassid(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from public.user_password
where passid=$1 ;

       $_$;
 :   DROP FUNCTION public.find_user_passwordbypassid(integer);
       public          postgres    false            �            1255    94790 (   find_user_passwordbyuser_passid(integer)    FUNCTION     �   CREATE FUNCTION public.find_user_passwordbyuser_passid(integer) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from public.user_password
where user_passid=$1 ;

       $_$;
 ?   DROP FUNCTION public.find_user_passwordbyuser_passid(integer);
       public          postgres    false            �            1255    94791 &   find_userbyfullname(character varying)    FUNCTION     �   CREATE FUNCTION public.find_userbyfullname(character varying) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from public.user
where fullname=$1 ;

       $_$;
 =   DROP FUNCTION public.find_userbyfullname(character varying);
       public          postgres    false            �            1255    94792 ,   find_userbyidentitynumber(character varying)    FUNCTION     �   CREATE FUNCTION public.find_userbyidentitynumber(character varying) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from public.user
where identitynumber=$1 ;

       $_$;
 C   DROP FUNCTION public.find_userbyidentitynumber(character varying);
       public          postgres    false            �            1255    94793 &   find_userbyusername(character varying)    FUNCTION     �   CREATE FUNCTION public.find_userbyusername(character varying) RETURNS record
    LANGUAGE sql
    AS $_$
		select * from public.user
where username=$1 ;

       $_$;
 =   DROP FUNCTION public.find_userbyusername(character varying);
       public          postgres    false            �            1255    94794    get_month(double precision)    FUNCTION     �  CREATE FUNCTION public.get_month(double precision) RETURNS character varying
    LANGUAGE plpgsql
    AS $_$declare 
date_month character varying(20);
begin
if ($1=1) then 
date_month = 'enero';
elsif ($1=2) then 
date_month = 'febrero';
elsif ($1=3) then 
date_month = 'marzo';
elsif ($1=4) then 
date_month = 'abril';
elsif ($1=5) then 
date_month = 'mayo';
elsif ($1=6) then 
date_month = 'junio';
elsif ($1=7) then 
date_month = 'julio';
elsif ($1=8) then 
date_month = 'agosto';
elsif ($1=9) then 
date_month = 'septiembre';
elsif ($1=10) then 
date_month = 'octubre';
elsif ($1=11) then 
date_month = 'noviembre';
elsif ($1=12) then 
date_month = 'diciembre';
end if;
return date_month;
end;$_$;
 2   DROP FUNCTION public.get_month(double precision);
       public          postgres    false            �            1255    94795    password_delete(integer)    FUNCTION     �   CREATE FUNCTION public.password_delete(passid_0 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 delete  from "password"
   where "passid"= $1; 
 END;$_$;
 8   DROP FUNCTION public.password_delete(passid_0 integer);
       public          postgres    false            �            1255    94796 �   password_insert(integer, integer, integer, character varying, integer, integer, integer, integer, integer, integer, integer, integer, integer, integer)    FUNCTION     )  CREATE FUNCTION public.password_insert(pictureid_1 integer, radius_2 integer, questionid_3 integer, ihash_4 character varying, x1_5 integer, y1_6 integer, x2_7 integer, y2_8 integer, x3_9 integer, y3_10 integer, x4_11 integer, y4_12 integer, x5_13 integer, y5_14 integer) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN 
 insert into password(pictureid,radius,questionid,ihash,x1,y1,x2,y2,x3,y3,x4,y4,x5,y5)values("pictureid_1","radius_2","questionid_3","ihash_4","x1_5","y1_6","x2_7","y2_8","x3_9","y3_10","x4_11","y4_12","x5_13","y5_14"); 
  END;$$;
   DROP FUNCTION public.password_insert(pictureid_1 integer, radius_2 integer, questionid_3 integer, ihash_4 character varying, x1_5 integer, y1_6 integer, x2_7 integer, y2_8 integer, x3_9 integer, y3_10 integer, x4_11 integer, y4_12 integer, x5_13 integer, y5_14 integer);
       public          postgres    false            �            1255    94797 �   password_update(integer, integer, integer, integer, character varying, integer, integer, integer, integer, integer, integer, integer, integer, integer, integer)    FUNCTION     �  CREATE FUNCTION public.password_update(passid_0 integer, pictureid_1 integer, radius_2 integer, questionid_3 integer, ihash_4 character varying, x1_5 integer, y1_6 integer, x2_7 integer, y2_8 integer, x3_9 integer, y3_10 integer, x4_11 integer, y4_12 integer, x5_13 integer, y5_14 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 update "password"
 SET pictureid=$2,radius=$3,questionid=$4,ihash=$5,x1=$6,y1=$7,x2=$8,y2=$9,x3=$10,y3=$11,x4=$12,y4=$13,x5=$14,y5=$15 where "passid"= $1; 
 END;$_$;
 !  DROP FUNCTION public.password_update(passid_0 integer, pictureid_1 integer, radius_2 integer, questionid_3 integer, ihash_4 character varying, x1_5 integer, y1_6 integer, x2_7 integer, y2_8 integer, x3_9 integer, y3_10 integer, x4_11 integer, y4_12 integer, x5_13 integer, y5_14 integer);
       public          postgres    false            �            1255    94798 	   picture()    FUNCTION     �   CREATE FUNCTION public.picture() RETURNS trigger
    LANGUAGE plpgsql
    AS $$begin
if (new.quality = '') then 
raise exception 'No se puede insertar una imagen con calidad mala';
end if ;
return new;
end;
$$;
     DROP FUNCTION public.picture();
       public          postgres    false            �            1255    94799    picture_delete(integer)    FUNCTION     �   CREATE FUNCTION public.picture_delete(pictureid_0 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 delete  from "picture"
   where "pictureid"= $1; 
 END;$_$;
 :   DROP FUNCTION public.picture_delete(pictureid_0 integer);
       public          postgres    false            �            1255    94800 M   picture_insert(character varying, date, character varying, character varying)    FUNCTION       CREATE FUNCTION public.picture_insert(name_1 character varying, date_2 date, quality_3 character varying, url_4 character varying) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN 
 insert into picture(name,date,quality,url)values("name_1","date_2","quality_3","url_4"); 
  END;$$;
 �   DROP FUNCTION public.picture_insert(name_1 character varying, date_2 date, quality_3 character varying, url_4 character varying);
       public          postgres    false                        1255    94801 V   picture_update(integer, character varying, date, character varying, character varying)    FUNCTION       CREATE FUNCTION public.picture_update(pictureid_0 integer, name character varying, date date, quality character varying, url character varying) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 update "picture"
 SET name=$2,date=$3,quality=$4,url=$5 where "pictureid"= $1; 
 END;$_$;
 �   DROP FUNCTION public.picture_update(pictureid_0 integer, name character varying, date date, quality character varying, url character varying);
       public          postgres    false                       1255    94802    profession_delete(integer)    FUNCTION     �   CREATE FUNCTION public.profession_delete(profid_0 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 delete  from "profession"
   where "profid"= $1; 
 END;$_$;
 :   DROP FUNCTION public.profession_delete(profid_0 integer);
       public          postgres    false                       1255    94803 $   profession_insert(character varying)    FUNCTION     �   CREATE FUNCTION public.profession_insert(description_1 character varying) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN 
 insert into profession(description)values("description_1"); 
  END;$$;
 I   DROP FUNCTION public.profession_insert(description_1 character varying);
       public          postgres    false                       1255    94804 -   profession_update(integer, character varying)    FUNCTION     �   CREATE FUNCTION public.profession_update(profid_0 integer, description_1 character varying) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 update "profession"
 SET description=$2 where "profid"= $1; 
 END;$_$;
 [   DROP FUNCTION public.profession_update(profid_0 integer, description_1 character varying);
       public          postgres    false                       1255    94805    report1(date)    FUNCTION     �  CREATE FUNCTION public.report1(date) RETURNS refcursor
    LANGUAGE plpgsql
    AS $_$Declare 
auth_list  refcursor;
Begin
open auth_list for
select public.type.description , count(authentication.auth_id) as cant
from authentication
join date on authentication.dateid= date.dateid
join public.type on authentication.typeid = public.type.typeid
where date.date =  $1
group by public.type.description;

return auth_list;
end;$_$;
 $   DROP FUNCTION public.report1(date);
       public          postgres    false                       1255    94806    report2(character varying)    FUNCTION     n  CREATE FUNCTION public.report2(character varying) RETURNS refcursor
    LANGUAGE plpgsql
    AS $_$declare 
auth_list refcursor;
begin 
open auth_list for
select count(authentication.userid), public.type.description, 
date_part('month',date.date) AS date_month,  get_month(date_part('month',date.date))
from authentication
join date on authentication.dateid= date.dateid
join public.type on authentication.typeid = public.type.typeid
join public.user on authentication.userid= public.user.userid
where public.user.username= $1
group by  date_month, public.type.description
order by  date_month;
return auth_list;
end;$_$;
 1   DROP FUNCTION public.report2(character varying);
       public          postgres    false            #           1255    94807 	   report3()    FUNCTION     �  CREATE FUNCTION public.report3() RETURNS refcursor
    LANGUAGE plpgsql
    AS $$declare 
picture_list refcursor;
begin 
open picture_list for
select picture.name,count(picture.pictureid) as i, public.user.username
from picture 
join password on picture.pictureid = password.pictureid 
join authentication on password.passid= authentication.passid
join date on authentication.dateid= date.dateid
join public.user on authentication.userid = public.user.userid
join public.type on authentication.typeid = public.type.typeid
where description='dudoso_legitimo'
group by picture.name , public.user.username
order by i desc;
return picture_list;
end;$$;
     DROP FUNCTION public.report3();
       public          postgres    false                       1255    94808    report4(character varying)    FUNCTION     �  CREATE FUNCTION public.report4(character varying) RETURNS refcursor
    LANGUAGE plpgsql
    AS $$declare 
user_auth_list  refcursor;
begin 
open user_auth_list for
select authentication.auth_id,
picture.name, public.date.date, public.type.description
from authentication
join public.date on authentication.dateid= public.date.dateid
join public.type on authentication.typeid = public.type.typeid
join password on authentication.passid = password.passid
join picture on password.pictureid = picture.pictureid
join public.user on authentication.userid = public.user.userid
where  public.user.username='star' and public.type.description='ilegitimo'
order by public.date.date;
return user_auth_list;
end;$$;
 1   DROP FUNCTION public.report4(character varying);
       public          postgres    false            	           1255    94809    report5(character varying)    FUNCTION     �  CREATE FUNCTION public.report5(character varying) RETURNS refcursor
    LANGUAGE plpgsql
    AS $_$declare 
picture_list refcursor;
begin 
open picture_list for
select picture.name, count(picture.name) as i
from picture 
join password on picture.pictureid = password.pictureid 
join authentication on password.passid= authentication.passid
join public.date on authentication.dateid= public.date.dateid
join public.type on authentication.typeid = public.type.typeid
join public.user on authentication.userid = public.user.userid
where description='dudoso_legitimo' and public.user.username=$1
group by picture.name
order by i desc;
return picture_list;
end;$_$;
 1   DROP FUNCTION public.report5(character varying);
       public          postgres    false                       1255    94810    role_delete(integer)    FUNCTION     �   CREATE FUNCTION public.role_delete(roleid_0 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 delete  from "role"
   where "roleid"= $1; 
 END;$_$;
 4   DROP FUNCTION public.role_delete(roleid_0 integer);
       public          postgres    false                       1255    94811    role_insert(character varying)    FUNCTION     �   CREATE FUNCTION public.role_insert(description_1 character varying) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN 
 insert into role(description)values("description_1"); 
  END;$$;
 C   DROP FUNCTION public.role_insert(description_1 character varying);
       public          postgres    false            
           1255    94812 '   role_update(integer, character varying)    FUNCTION     �   CREATE FUNCTION public.role_update(roleid_0 integer, description_1 character varying) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 update "role"
 SET description=$2 where "roleid"= $1; 
 END;$_$;
 U   DROP FUNCTION public.role_update(roleid_0 integer, description_1 character varying);
       public          postgres    false                       1255    94813     securityquestion_delete(integer)    FUNCTION     �   CREATE FUNCTION public.securityquestion_delete(questionid_0 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 delete  from "securityquestion"
   where "questionid"= $1; 
 END;$_$;
 D   DROP FUNCTION public.securityquestion_delete(questionid_0 integer);
       public          postgres    false                       1255    94814 =   securityquestion_insert(character varying, character varying)    FUNCTION     �   CREATE FUNCTION public.securityquestion_insert(question_1 character varying, answer_2 character varying) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN 
 insert into securityquestion(question,answer)values("question_1","answer_2"); 
  END;$$;
 h   DROP FUNCTION public.securityquestion_insert(question_1 character varying, answer_2 character varying);
       public          postgres    false                       1255    94815 F   securityquestion_update(integer, character varying, character varying)    FUNCTION       CREATE FUNCTION public.securityquestion_update(questionid_0 integer, question_1 character varying, answer_2 character varying) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 update "securityquestion"
 SET question=$2,answer=$3 where "questionid"= $1; 
 END;$_$;
 ~   DROP FUNCTION public.securityquestion_update(questionid_0 integer, question_1 character varying, answer_2 character varying);
       public          postgres    false                       1255    94816    select_all_authentication()    FUNCTION     /  CREATE FUNCTION public.select_all_authentication() RETURNS refcursor
    LANGUAGE plpgsql
    AS $$
DECLARE
       listauthentication refcursor;
BEGIN
       OPEN listauthentication FOR 
		 Select * from authentication order by authentication.auth_id ;
	    RETURN listauthentication;
		END;
       $$;
 2   DROP FUNCTION public.select_all_authentication();
       public          postgres    false                       1255    94817    select_all_date()    FUNCTION     �   CREATE FUNCTION public.select_all_date() RETURNS refcursor
    LANGUAGE plpgsql
    AS $$
DECLARE
       listdate refcursor;
BEGIN
       OPEN listdate FOR 
		 Select * from date order by date.dateid ;
	    RETURN listdate;
		END;
       $$;
 (   DROP FUNCTION public.select_all_date();
       public          postgres    false                       1255    94818    select_all_password()    FUNCTION     
  CREATE FUNCTION public.select_all_password() RETURNS refcursor
    LANGUAGE plpgsql
    AS $$
DECLARE
       listpassword refcursor;
BEGIN
       OPEN listpassword FOR 
		 Select * from password order by password.passid ;
	    RETURN listpassword;
		END;
       $$;
 ,   DROP FUNCTION public.select_all_password();
       public          postgres    false                       1255    94819    select_all_picture()    FUNCTION       CREATE FUNCTION public.select_all_picture() RETURNS refcursor
    LANGUAGE plpgsql
    AS $$
DECLARE
       listpicture refcursor;
BEGIN
       OPEN listpicture FOR 
		 Select * from picture order by picture.pictureid ;
	    RETURN listpicture;
		END;
       $$;
 +   DROP FUNCTION public.select_all_picture();
       public          postgres    false                       1255    94820    select_all_profession()    FUNCTION       CREATE FUNCTION public.select_all_profession() RETURNS refcursor
    LANGUAGE plpgsql
    AS $$
DECLARE
       listprofession refcursor;
BEGIN
       OPEN listprofession FOR 
		 Select * from profession order by profession.profid ;
	    RETURN listprofession;
		END;
       $$;
 .   DROP FUNCTION public.select_all_profession();
       public          postgres    false                       1255    94821    select_all_rol()    FUNCTION     �   CREATE FUNCTION public.select_all_rol() RETURNS refcursor
    LANGUAGE plpgsql
    AS $$
DECLARE
       listrol refcursor;
BEGIN
       OPEN listrol FOR 
		 Select * from role order by role.roleid ;
	    RETURN listrol;
		END;
       $$;
 '   DROP FUNCTION public.select_all_rol();
       public          postgres    false                       1255    94822    select_all_securityquestion()    FUNCTION     >  CREATE FUNCTION public.select_all_securityquestion() RETURNS refcursor
    LANGUAGE plpgsql
    AS $$
DECLARE
       listsecurityquestion refcursor;
BEGIN
       OPEN listsecurityquestion FOR 
		 Select * from securityquestion order by securityquestion.questionid ;
	    RETURN listsecurityquestion;
		END;
       $$;
 4   DROP FUNCTION public.select_all_securityquestion();
       public          postgres    false                       1255    94823    select_all_type()    FUNCTION     �   CREATE FUNCTION public.select_all_type() RETURNS refcursor
    LANGUAGE plpgsql
    AS $$
DECLARE
       listtype refcursor;
BEGIN
       OPEN listtype FOR 
		 Select * from type order by type.typeid ;
	    RETURN listtype;
		END;
       $$;
 (   DROP FUNCTION public.select_all_type();
       public          postgres    false                       1255    94824    select_all_user()    FUNCTION        CREATE FUNCTION public.select_all_user() RETURNS refcursor
    LANGUAGE plpgsql
    AS $$
DECLARE
       listuser refcursor;
BEGIN
       OPEN listuser FOR 
		 Select * from public.user order by public.user.userid ;
	    RETURN listuser;
		END;
       $$;
 (   DROP FUNCTION public.select_all_user();
       public          postgres    false                       1255    94825    select_all_user_password()    FUNCTION     -  CREATE FUNCTION public.select_all_user_password() RETURNS refcursor
    LANGUAGE plpgsql
    AS $$
DECLARE
       listuser_password refcursor;
BEGIN
       OPEN listuser_password FOR 
		 Select * from user_password order by user_password.user_passid ;
	    RETURN listuser_password;
		END;
       $$;
 1   DROP FUNCTION public.select_all_user_password();
       public          postgres    false                       1255    94826    type_delete(integer)    FUNCTION     �   CREATE FUNCTION public.type_delete(typeid_0 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 delete  from "type"
   where "typeid"= $1; 
 END;$_$;
 4   DROP FUNCTION public.type_delete(typeid_0 integer);
       public          postgres    false                       1255    94827    type_insert(character varying)    FUNCTION     �   CREATE FUNCTION public.type_insert(description_1 character varying) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN 
 insert into type(description)values("description_1"); 
  END;$$;
 C   DROP FUNCTION public.type_insert(description_1 character varying);
       public          postgres    false                       1255    94828 '   type_update(integer, character varying)    FUNCTION     �   CREATE FUNCTION public.type_update(typeid_0 integer, description_1 character varying) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 update "type"
 SET description=$2 where "typeid"= $1; 
 END;$_$;
 U   DROP FUNCTION public.type_update(typeid_0 integer, description_1 character varying);
       public          postgres    false                       1255    94829    user_count()    FUNCTION     ?  CREATE FUNCTION public.user_count() RETURNS trigger
    LANGUAGE plpgsql
    AS $$declare
i integer;
begin 
select into i count(user_password.passid)
from user_password
where user_password.userid = new.userid;

if (i=5) then 
raise exception 'No se puede insertar mas de 5 contraseñas';
end if ;

return new;
end;
$$;
 #   DROP FUNCTION public.user_count();
       public          postgres    false                       1255    94830    user_delete(integer)    FUNCTION     �   CREATE FUNCTION public.user_delete(userid_0 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 delete  from public.user
   where "userid"= $1; 
 END;$_$;
 4   DROP FUNCTION public.user_delete(userid_0 integer);
       public          postgres    false                       1255    94831 �   user_insert(character varying, character varying, integer, character varying, character varying, integer, integer, character varying)    FUNCTION       CREATE FUNCTION public.user_insert(identitynumber_0 character varying, gender_1 character varying, profid_2 integer, username_3 character varying, fullname_4 character varying, registered_5 integer, roleid_6 integer, email_7 character varying) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN 
 insert into public.user(identitynumber,gender,profid,username,fullname,registered,roleid,email)values("identitynumber_0","gender_1","profid_2","username_3","fullname_4","registered_5","roleid_6","email_7"); 
  END;$$;
 �   DROP FUNCTION public.user_insert(identitynumber_0 character varying, gender_1 character varying, profid_2 integer, username_3 character varying, fullname_4 character varying, registered_5 integer, roleid_6 integer, email_7 character varying);
       public          postgres    false                       1255    94832    user_password_delete(integer)    FUNCTION     �   CREATE FUNCTION public.user_password_delete(user_passid_0 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 delete  from "user_password"
   where "user_passid"= $1; 
 END;$_$;
 B   DROP FUNCTION public.user_password_delete(user_passid_0 integer);
       public          postgres    false                       1255    94833 &   user_password_insert(integer, integer)    FUNCTION     �   CREATE FUNCTION public.user_password_insert(passid_1 integer, userid_2 integer) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN 
 insert into user_password(passid,userid)values("passid_1","userid_2"); 
  END;$$;
 O   DROP FUNCTION public.user_password_insert(passid_1 integer, userid_2 integer);
       public          postgres    false                        1255    94834 /   user_password_update(integer, integer, integer)    FUNCTION     �   CREATE FUNCTION public.user_password_update(user_passid_0 integer, passid_1 integer, userid_2 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 update "user_password"
 SET passid=$2,userid=$3 where "user_passid"= $1; 
 END;$_$;
 f   DROP FUNCTION public.user_password_update(user_passid_0 integer, passid_1 integer, userid_2 integer);
       public          postgres    false            !           1255    94835 �   user_update(character varying, character varying, integer, character varying, character varying, integer, integer, character varying, integer)    FUNCTION     �  CREATE FUNCTION public.user_update(identitynumber_0 character varying, gender_1 character varying, profid_2 integer, username_3 character varying, fullname_4 character varying, registered_5 integer, roleid_6 integer, email_7 character varying, userid_8 integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$BEGIN 
 update "user"
 SET identitynumber= $1, gender=$2,profid=$3,username=$4,fullname=$5,registered=$6,roleid=$7,email=$8 where "userid"= $9; 
 END;$_$;
   DROP FUNCTION public.user_update(identitynumber_0 character varying, gender_1 character varying, profid_2 integer, username_3 character varying, fullname_4 character varying, registered_5 integer, roleid_6 integer, email_7 character varying, userid_8 integer);
       public          postgres    false            "           1255    94836    user_update_registered(integer)    FUNCTION     �   CREATE FUNCTION public.user_update_registered(integer) RETURNS void
    LANGUAGE plpgsql
    AS $_$begin
update public.user set registered = 1 where userid= $1;
end;$_$;
 6   DROP FUNCTION public.user_update_registered(integer);
       public          postgres    false            �            1259    94837    authentication    TABLE     �  CREATE TABLE public.authentication (
    userid integer NOT NULL,
    passid integer NOT NULL,
    dateid integer NOT NULL,
    typeid integer NOT NULL,
    auth_id integer NOT NULL,
    x1 integer NOT NULL,
    y1 integer NOT NULL,
    x2 integer NOT NULL,
    y2 integer NOT NULL,
    x3 integer NOT NULL,
    y3 integer NOT NULL,
    x4 integer NOT NULL,
    y4 integer NOT NULL,
    x5 integer NOT NULL,
    y5 integer NOT NULL,
    l double precision NOT NULL
);
 "   DROP TABLE public.authentication;
       public            postgres    false            �            1259    94840    authentication_auth_id_seq    SEQUENCE     �   CREATE SEQUENCE public.authentication_auth_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.authentication_auth_id_seq;
       public          postgres    false    181            	           0    0    authentication_auth_id_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.authentication_auth_id_seq OWNED BY public.authentication.auth_id;
          public          postgres    false    182            �            1259    94842    date    TABLE     R   CREATE TABLE public.date (
    dateid integer NOT NULL,
    date date NOT NULL
);
    DROP TABLE public.date;
       public            postgres    false            �            1259    94845    date_dateid_seq    SEQUENCE     x   CREATE SEQUENCE public.date_dateid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.date_dateid_seq;
       public          postgres    false    183            	           0    0    date_dateid_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.date_dateid_seq OWNED BY public.date.dateid;
          public          postgres    false    184            �            1259    94847    password    TABLE     c  CREATE TABLE public.password (
    passid integer NOT NULL,
    pictureid integer NOT NULL,
    radius integer DEFAULT 5 NOT NULL,
    questionid integer NOT NULL,
    ihash character varying,
    x1 integer,
    y1 integer,
    x2 integer,
    y2 integer,
    x3 integer,
    y3 integer,
    x4 integer,
    y4 integer,
    x5 integer,
    y5 integer
);
    DROP TABLE public.password;
       public            postgres    false            �            1259    94854    password_passid_seq    SEQUENCE     |   CREATE SEQUENCE public.password_passid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.password_passid_seq;
       public          postgres    false    185            		           0    0    password_passid_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.password_passid_seq OWNED BY public.password.passid;
          public          postgres    false    186            �            1259    94856    picture    TABLE     �   CREATE TABLE public.picture (
    pictureid integer NOT NULL,
    name character varying NOT NULL,
    date date NOT NULL,
    quality character varying NOT NULL,
    url character varying
);
    DROP TABLE public.picture;
       public            postgres    false            �            1259    94862    picture_pictureid_seq    SEQUENCE     ~   CREATE SEQUENCE public.picture_pictureid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.picture_pictureid_seq;
       public          postgres    false    187            
	           0    0    picture_pictureid_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.picture_pictureid_seq OWNED BY public.picture.pictureid;
          public          postgres    false    188            �            1259    94864 
   profession    TABLE     l   CREATE TABLE public.profession (
    profid integer NOT NULL,
    description character varying NOT NULL
);
    DROP TABLE public.profession;
       public            postgres    false            �            1259    94870    profession_profid_seq    SEQUENCE     ~   CREATE SEQUENCE public.profession_profid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.profession_profid_seq;
       public          postgres    false    189            	           0    0    profession_profid_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.profession_profid_seq OWNED BY public.profession.profid;
          public          postgres    false    190            �            1259    94872    role    TABLE     f   CREATE TABLE public.role (
    roleid integer NOT NULL,
    description character varying NOT NULL
);
    DROP TABLE public.role;
       public            postgres    false            �            1259    94878    role_roleid_seq    SEQUENCE     x   CREATE SEQUENCE public.role_roleid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.role_roleid_seq;
       public          postgres    false    191            	           0    0    role_roleid_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.role_roleid_seq OWNED BY public.role.roleid;
          public          postgres    false    192            �            1259    94880    securityquestion    TABLE     �   CREATE TABLE public.securityquestion (
    questionid integer NOT NULL,
    question character varying NOT NULL,
    answer character varying
);
 $   DROP TABLE public.securityquestion;
       public            postgres    false            �            1259    94886    securityquestion_questionid_seq    SEQUENCE     �   CREATE SEQUENCE public.securityquestion_questionid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 6   DROP SEQUENCE public.securityquestion_questionid_seq;
       public          postgres    false    193            	           0    0    securityquestion_questionid_seq    SEQUENCE OWNED BY     c   ALTER SEQUENCE public.securityquestion_questionid_seq OWNED BY public.securityquestion.questionid;
          public          postgres    false    194            �            1259    94888    type    TABLE     f   CREATE TABLE public.type (
    typeid integer NOT NULL,
    description character varying NOT NULL
);
    DROP TABLE public.type;
       public            postgres    false            �            1259    94894    type_typeid_seq    SEQUENCE     x   CREATE SEQUENCE public.type_typeid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.type_typeid_seq;
       public          postgres    false    195            	           0    0    type_typeid_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.type_typeid_seq OWNED BY public.type.typeid;
          public          postgres    false    196            �            1259    94896    user    TABLE     e  CREATE TABLE public."user" (
    userid integer NOT NULL,
    identitynumber character varying NOT NULL,
    gender character varying NOT NULL,
    profid integer NOT NULL,
    username character varying NOT NULL,
    fullname character varying NOT NULL,
    registered integer NOT NULL,
    roleid integer NOT NULL,
    email character varying NOT NULL
);
    DROP TABLE public."user";
       public            postgres    false            	           0    0    TABLE "user"    COMMENT     d   COMMENT ON TABLE public."user" IS 'registered es si ya tiene contrasena o no 
0 no tiene 
1 tiene';
          public          postgres    false    197            �            1259    94902    user_password    TABLE     �   CREATE TABLE public.user_password (
    user_passid integer NOT NULL,
    passid integer NOT NULL,
    userid integer NOT NULL
);
 !   DROP TABLE public.user_password;
       public            postgres    false            �            1259    94905    user_password_user_passid_seq    SEQUENCE     �   CREATE SEQUENCE public.user_password_user_passid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE public.user_password_user_passid_seq;
       public          postgres    false    198            	           0    0    user_password_user_passid_seq    SEQUENCE OWNED BY     _   ALTER SEQUENCE public.user_password_user_passid_seq OWNED BY public.user_password.user_passid;
          public          postgres    false    199            �            1259    94907    user_userid_seq    SEQUENCE     x   CREATE SEQUENCE public.user_userid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.user_userid_seq;
       public          postgres    false    197            	           0    0    user_userid_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.user_userid_seq OWNED BY public."user".userid;
          public          postgres    false    200            I           2604    94909    authentication auth_id    DEFAULT     �   ALTER TABLE ONLY public.authentication ALTER COLUMN auth_id SET DEFAULT nextval('public.authentication_auth_id_seq'::regclass);
 E   ALTER TABLE public.authentication ALTER COLUMN auth_id DROP DEFAULT;
       public          postgres    false    182    181            J           2604    94910    date dateid    DEFAULT     j   ALTER TABLE ONLY public.date ALTER COLUMN dateid SET DEFAULT nextval('public.date_dateid_seq'::regclass);
 :   ALTER TABLE public.date ALTER COLUMN dateid DROP DEFAULT;
       public          postgres    false    184    183            L           2604    94911    password passid    DEFAULT     r   ALTER TABLE ONLY public.password ALTER COLUMN passid SET DEFAULT nextval('public.password_passid_seq'::regclass);
 >   ALTER TABLE public.password ALTER COLUMN passid DROP DEFAULT;
       public          postgres    false    186    185            M           2604    94912    picture pictureid    DEFAULT     v   ALTER TABLE ONLY public.picture ALTER COLUMN pictureid SET DEFAULT nextval('public.picture_pictureid_seq'::regclass);
 @   ALTER TABLE public.picture ALTER COLUMN pictureid DROP DEFAULT;
       public          postgres    false    188    187            N           2604    94913    profession profid    DEFAULT     v   ALTER TABLE ONLY public.profession ALTER COLUMN profid SET DEFAULT nextval('public.profession_profid_seq'::regclass);
 @   ALTER TABLE public.profession ALTER COLUMN profid DROP DEFAULT;
       public          postgres    false    190    189            O           2604    94914    role roleid    DEFAULT     j   ALTER TABLE ONLY public.role ALTER COLUMN roleid SET DEFAULT nextval('public.role_roleid_seq'::regclass);
 :   ALTER TABLE public.role ALTER COLUMN roleid DROP DEFAULT;
       public          postgres    false    192    191            P           2604    94915    securityquestion questionid    DEFAULT     �   ALTER TABLE ONLY public.securityquestion ALTER COLUMN questionid SET DEFAULT nextval('public.securityquestion_questionid_seq'::regclass);
 J   ALTER TABLE public.securityquestion ALTER COLUMN questionid DROP DEFAULT;
       public          postgres    false    194    193            Q           2604    94916    type typeid    DEFAULT     j   ALTER TABLE ONLY public.type ALTER COLUMN typeid SET DEFAULT nextval('public.type_typeid_seq'::regclass);
 :   ALTER TABLE public.type ALTER COLUMN typeid DROP DEFAULT;
       public          postgres    false    196    195            R           2604    94917    user userid    DEFAULT     l   ALTER TABLE ONLY public."user" ALTER COLUMN userid SET DEFAULT nextval('public.user_userid_seq'::regclass);
 <   ALTER TABLE public."user" ALTER COLUMN userid DROP DEFAULT;
       public          postgres    false    200    197            S           2604    94918    user_password user_passid    DEFAULT     �   ALTER TABLE ONLY public.user_password ALTER COLUMN user_passid SET DEFAULT nextval('public.user_password_user_passid_seq'::regclass);
 H   ALTER TABLE public.user_password ALTER COLUMN user_passid DROP DEFAULT;
       public          postgres    false    199    198            �          0    94837    authentication 
   TABLE DATA           |   COPY public.authentication (userid, passid, dateid, typeid, auth_id, x1, y1, x2, y2, x3, y3, x4, y4, x5, y5, l) FROM stdin;
    public          postgres    false    181   �      �          0    94842    date 
   TABLE DATA           ,   COPY public.date (dateid, date) FROM stdin;
    public          postgres    false    183   \      �          0    94847    password 
   TABLE DATA           x   COPY public.password (passid, pictureid, radius, questionid, ihash, x1, y1, x2, y2, x3, y3, x4, y4, x5, y5) FROM stdin;
    public          postgres    false    185   C      �          0    94856    picture 
   TABLE DATA           F   COPY public.picture (pictureid, name, date, quality, url) FROM stdin;
    public          postgres    false    187   �      �          0    94864 
   profession 
   TABLE DATA           9   COPY public.profession (profid, description) FROM stdin;
    public          postgres    false    189   �      �          0    94872    role 
   TABLE DATA           3   COPY public.role (roleid, description) FROM stdin;
    public          postgres    false    191         �          0    94880    securityquestion 
   TABLE DATA           H   COPY public.securityquestion (questionid, question, answer) FROM stdin;
    public          postgres    false    193   P      �          0    94888    type 
   TABLE DATA           3   COPY public.type (typeid, description) FROM stdin;
    public          postgres    false    195   �      �          0    94896    user 
   TABLE DATA           w   COPY public."user" (userid, identitynumber, gender, profid, username, fullname, registered, roleid, email) FROM stdin;
    public          postgres    false    197         �          0    94902    user_password 
   TABLE DATA           D   COPY public.user_password (user_passid, passid, userid) FROM stdin;
    public          postgres    false    198   �      	           0    0    authentication_auth_id_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.authentication_auth_id_seq', 638, true);
          public          postgres    false    182            	           0    0    date_dateid_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.date_dateid_seq', 446, true);
          public          postgres    false    184            	           0    0    password_passid_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.password_passid_seq', 140, true);
          public          postgres    false    186            	           0    0    picture_pictureid_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.picture_pictureid_seq', 103, true);
          public          postgres    false    188            	           0    0    profession_profid_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.profession_profid_seq', 10, true);
          public          postgres    false    190            	           0    0    role_roleid_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.role_roleid_seq', 2, true);
          public          postgres    false    192            	           0    0    securityquestion_questionid_seq    SEQUENCE SET     O   SELECT pg_catalog.setval('public.securityquestion_questionid_seq', 168, true);
          public          postgres    false    194            	           0    0    type_typeid_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.type_typeid_seq', 14, true);
          public          postgres    false    196            	           0    0    user_password_user_passid_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('public.user_password_user_passid_seq', 139, true);
          public          postgres    false    199            	           0    0    user_userid_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.user_userid_seq', 15, true);
          public          postgres    false    200            U           2606    94920 "   authentication authentication_pkey 
   CONSTRAINT     e   ALTER TABLE ONLY public.authentication
    ADD CONSTRAINT authentication_pkey PRIMARY KEY (auth_id);
 L   ALTER TABLE ONLY public.authentication DROP CONSTRAINT authentication_pkey;
       public            postgres    false    181            W           2606    94922    date date_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.date
    ADD CONSTRAINT date_pkey PRIMARY KEY (dateid);
 8   ALTER TABLE ONLY public.date DROP CONSTRAINT date_pkey;
       public            postgres    false    183            Y           2606    94924    password password_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.password
    ADD CONSTRAINT password_pkey PRIMARY KEY (passid);
 @   ALTER TABLE ONLY public.password DROP CONSTRAINT password_pkey;
       public            postgres    false    185            [           2606    94926    picture picture_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.picture
    ADD CONSTRAINT picture_pkey PRIMARY KEY (pictureid);
 >   ALTER TABLE ONLY public.picture DROP CONSTRAINT picture_pkey;
       public            postgres    false    187            ]           2606    94928    profession profession_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.profession
    ADD CONSTRAINT profession_pkey PRIMARY KEY (profid);
 D   ALTER TABLE ONLY public.profession DROP CONSTRAINT profession_pkey;
       public            postgres    false    189            _           2606    94930    role role_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (roleid);
 8   ALTER TABLE ONLY public.role DROP CONSTRAINT role_pkey;
       public            postgres    false    191            a           2606    94932 &   securityquestion securityquestion_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public.securityquestion
    ADD CONSTRAINT securityquestion_pkey PRIMARY KEY (questionid);
 P   ALTER TABLE ONLY public.securityquestion DROP CONSTRAINT securityquestion_pkey;
       public            postgres    false    193            c           2606    94934    type type_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.type
    ADD CONSTRAINT type_pkey PRIMARY KEY (typeid);
 8   ALTER TABLE ONLY public.type DROP CONSTRAINT type_pkey;
       public            postgres    false    195            e           2606    94936    user user_fullname_key 
   CONSTRAINT     W   ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_fullname_key UNIQUE (fullname);
 B   ALTER TABLE ONLY public."user" DROP CONSTRAINT user_fullname_key;
       public            postgres    false    197            k           2606    94938 &   user_password user_password_passid_key 
   CONSTRAINT     c   ALTER TABLE ONLY public.user_password
    ADD CONSTRAINT user_password_passid_key UNIQUE (passid);
 P   ALTER TABLE ONLY public.user_password DROP CONSTRAINT user_password_passid_key;
       public            postgres    false    198            m           2606    94940     user_password user_password_pkey 
   CONSTRAINT     g   ALTER TABLE ONLY public.user_password
    ADD CONSTRAINT user_password_pkey PRIMARY KEY (user_passid);
 J   ALTER TABLE ONLY public.user_password DROP CONSTRAINT user_password_pkey;
       public            postgres    false    198            g           2606    94942    user user_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (userid);
 :   ALTER TABLE ONLY public."user" DROP CONSTRAINT user_pkey;
       public            postgres    false    197            i           2606    94944    user user_username_key 
   CONSTRAINT     W   ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_username_key UNIQUE (username);
 B   ALTER TABLE ONLY public."user" DROP CONSTRAINT user_username_key;
       public            postgres    false    197            x           2620    94945    picture check_picture    TRIGGER     n   CREATE TRIGGER check_picture BEFORE INSERT ON public.picture FOR EACH ROW EXECUTE PROCEDURE public.picture();
 .   DROP TRIGGER check_picture ON public.picture;
       public          postgres    false    187    253            y           2620    94946    user_password check_user_count    TRIGGER     z   CREATE TRIGGER check_user_count BEFORE INSERT ON public.user_password FOR EACH ROW EXECUTE PROCEDURE public.user_count();
 7   DROP TRIGGER check_user_count ON public.user_password;
       public          postgres    false    198    283            n           2606    94947 )   authentication authentication_dateid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.authentication
    ADD CONSTRAINT authentication_dateid_fkey FOREIGN KEY (dateid) REFERENCES public.date(dateid) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;
 S   ALTER TABLE ONLY public.authentication DROP CONSTRAINT authentication_dateid_fkey;
       public          postgres    false    181    183    2135            o           2606    94952 )   authentication authentication_passid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.authentication
    ADD CONSTRAINT authentication_passid_fkey FOREIGN KEY (passid) REFERENCES public.password(passid) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;
 S   ALTER TABLE ONLY public.authentication DROP CONSTRAINT authentication_passid_fkey;
       public          postgres    false    181    185    2137            p           2606    94957 )   authentication authentication_typeid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.authentication
    ADD CONSTRAINT authentication_typeid_fkey FOREIGN KEY (typeid) REFERENCES public.type(typeid) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;
 S   ALTER TABLE ONLY public.authentication DROP CONSTRAINT authentication_typeid_fkey;
       public          postgres    false    2147    195    181            q           2606    94962 )   authentication authentication_userid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.authentication
    ADD CONSTRAINT authentication_userid_fkey FOREIGN KEY (userid) REFERENCES public."user"(userid) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;
 S   ALTER TABLE ONLY public.authentication DROP CONSTRAINT authentication_userid_fkey;
       public          postgres    false    197    181    2151            r           2606    94967     password password_pictureid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.password
    ADD CONSTRAINT password_pictureid_fkey FOREIGN KEY (pictureid) REFERENCES public.picture(pictureid) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;
 J   ALTER TABLE ONLY public.password DROP CONSTRAINT password_pictureid_fkey;
       public          postgres    false    2139    185    187            s           2606    94972 !   password password_questionid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.password
    ADD CONSTRAINT password_questionid_fkey FOREIGN KEY (questionid) REFERENCES public.securityquestion(questionid) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;
 K   ALTER TABLE ONLY public.password DROP CONSTRAINT password_questionid_fkey;
       public          postgres    false    2145    193    185            v           2606    94977 '   user_password user_password_passid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_password
    ADD CONSTRAINT user_password_passid_fkey FOREIGN KEY (passid) REFERENCES public.password(passid) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;
 Q   ALTER TABLE ONLY public.user_password DROP CONSTRAINT user_password_passid_fkey;
       public          postgres    false    2137    198    185            w           2606    94982 '   user_password user_password_userid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_password
    ADD CONSTRAINT user_password_userid_fkey FOREIGN KEY (userid) REFERENCES public."user"(userid) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;
 Q   ALTER TABLE ONLY public.user_password DROP CONSTRAINT user_password_userid_fkey;
       public          postgres    false    197    2151    198            t           2606    94987    user user_profid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_profid_fkey FOREIGN KEY (profid) REFERENCES public.profession(profid) NOT VALID;
 A   ALTER TABLE ONLY public."user" DROP CONSTRAINT user_profid_fkey;
       public          postgres    false    2141    189    197            u           2606    94992    user user_roleid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_roleid_fkey FOREIGN KEY (roleid) REFERENCES public.role(roleid) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;
 A   ALTER TABLE ONLY public."user" DROP CONSTRAINT user_roleid_fkey;
       public          postgres    false    2143    191    197            �   �  x��Y[r��v3%QJ{��_�%@J�;��3��I�_ (;��y^2畯:�U.�ZV;櫴i?W;�Kz���+�d"JJD���;���!�%5�L���-�ϵ݆�A؝� ��U�6:e���<��)Xܜ+D�0�1=��D#k�p����p���V'�`a-�x��]ˁD�]�^i#z5�� Q�,f7M�m���.���0��0�[q�y��E����?Y���uP��;�Z�Zc�Ji%������u�cy�V�n$�N�m-)�i�e��uGBE�f*�>Y�)VM�W?��DMX�H��E\��X���F^�g��Z����>Q�k~\�'"�����=?�D���t�
�v��ϰ�Jׯuר�1n8�s�gF\5����3z$���-��(��<�����g�Y"���d��O��D�F'7j z���'����%����|h����R4�/S����}Y}�W�����Y�������k��"X��.�n�ǂ>�H2��$���`62��_b��MXŢnj����\Ke������_gU�M���̊���^���[i`:���^	�6L^�V�c���0��p�q�Xt�h�[Ђ{�ٷ��$����҅EML��@Fm��k>�;m�d�y�d�s˄5�w�<���f��LK��q3��O������}&����8~��U
��+Pϭ<֦6�����D���(�i(��]�J�˧�OV�ڨx��:~Z�,+��f���x��J�,|�Mm�:#�v��gUm�AE�������r=wbt�I��eT�_�ᛸo�Áiԩ*�A<V�j�.�tt����ɐ��3��Xocב����Ub�!G,G&��u�AQ��9W��i���[�f����@F^�ŪZ�̀����3��3g+�҉Q�}��:]&��?#ʁq��p_#�Y�"j9��q��pg��yY��7f�v4�mL�F4���PD�	D;�+Tq��pw���`²ӏ��t��Q�����$���[�0:w���;���~��0��5�̼��[�x��p��ig�vj����vf�zcX�6c��;��k*���S��ʃ��İ��`��˷z�FA<k���t	N��9�`X�^V}�ww;mc�(k�k|�����keM-�V�դ�S�a�zKw��5����]�
��5̑7eM��ӹ#��`���#�ʚ���x���[��0�NJ٧����
�%=�T9��UY�������>'�`���&[��O��|9�A"N�T_��[�	�ʓ��o��^���V�w<��y���nP[��\ϘkB����0�T� v"꺃�4����A�ƴ_�A���s:>E�/�����9�m���<��{C�����_5��H1�I㩿0��h����Z#y��L�`����xj������.m���7ִ��m��X����x�/�������o�����$�J��v���O����!�k|#GC�Ϛ��o�o���ùc:��/y0���SƁ��腇o��L�O�Z�a�衣|��f���wI�u����ۣ��/�ڔ�Q�͈>��7����ٚU	�U���73�Y�.�N��0��\�]�>�,��}�nl��S��r�O��`z/�mg͒�q�]�������xM�a�<�*G���sg���Y���yϵ���m�����<y}$0i�9t��I���n�c��k�v��h����r����Ӎ�\��5ݺ��2$��1B;'���[�μ�!�0-������,yة�P��s�rhH�k7�1��m�]�)B|��İG\��;��F��\|�Y��:��)^L��z�0��9���I��y!%�k�R�ϒ6	���r�o��7���+g�M�f�=G���1��,/�p���|#ɒ�S�nk-*^��c�V�,���W���$�=� ��g�����DZ��Za;o$�CҒ�C
gH��J��,�C���>�0l�:�G�Z("k���R%[���/�x2LY2X�Gŵ�ʼvb�~�5��\.��PmVH�P����6_�z�#��:o$i!}mt�n�|�G{z؈�c#���7����]F���`T��O����.s��?�������`��MK0A�W_-2{c8DJ>¹AD����E���t %A�zL�C��+�P6ƽ�]ϝ������F�ϖ����1RZTn�{,����H_����݋{��7�2с������"!�\����� ���9���������7�8      �   �  x�U�ˑ�6@��o.r �O.�?��wk��.aqJ$��e����d|2�XO[�%�\r�{�!SviU��[խ�Vu��UêaհjX5�V��Uê���*�ʪ���*�ʪ����VM��j=y.���Kny�j2�U�[u�������~���~Yr�%�<p72e�Vm��U۪���'�偧ɐ)���KZu����*�v9/C��rȒS.��aUXV�UaUXV�UaUX�V�j<-/���[U?�9�U���S.�偽ɐ)���[խ�Vu��Uê��)���Kny`5iUYUVի�o��r�-�M�L٥UӪiմjZ5�ZV-��U˪���/e��r�-_U��w�!Sv9d�)��Ҫcձ�Xu�:V��UǪcաj�&C��rȒS.��UaUXV�UaUXV�UaUX�V�UiUZ�V�UiUZ�V�w����n��!Sv9d�)����v�[���w������!K�7������3Ky      �   {  x����R#9���s�u�2�ڎ�c� b.ZJ�nl�`�<������A��r)�/wJ�� )��02��4�їdTŚ�uJ1k�ZB%1%�|�H���-H�
�-?;�� �����3yA�*���:'�N*�Ҕ[OD�),)��rr�˔$a��jdu뫲@M����T+��TO2^K�3Ѹ��t�$O#�z��%)�l�6��0��U��$�	P�e����Җ)fEfǤ�Z[0��Z�{$��c��:
���S�mL�K����vR �K��: ��A�2��\Bb�bl�5��6�:Q�69���%iʘ��-2�(�W��3�Bi���3�_P2�w�e��Sg��߬(�#ٯ&��侚�;��j��U��bJҿY\(�67��sEy�#)n4�KP2�\�1I�CL� �V:�z�)���ɜp��A�p�����b�]9���J�:�H|�����W�}\RjΧg~o�ؿ�-^�¡~r����btr�v�8�׋Ӯg@ԩ㻆E��C��v��@Z})H�l����z�*�O3����]�/��,On׫ǫף��jF�v5X���`r�xӴ]i�:�����V��AvφAV����;P#o����h���į7����]����|8x�+��.�i>Y-gN�[!��ؙj|���,�Q̎r,׃�8n������>��}�w�����r{2<��z�r�h��\6�����$�+S��#�K�IP�
<�1��Ѽ�g9���t1�-�a��������嬿}=|o�w�(��0,�CU���9�y1�ǵ�ˁs­�1܎���n:M_Wo��qS��p�]����o&��}�p}�4��|�ֺPY�ה����������z��_��      �   �   x�}�;1��z|�]�<��.4)�
h%��@k���O�2v�z�7$M�hY�a�����.��%g$�R(Ga��j�L�P���(S-��3�Ce�F�S:�Q�6�u��i������pF�U�a�Q��"�x��SD��B�U��~7~k�1��?2�R=iͽ%�h3���伊�U�2      �   t   x�U�;1Dk�0h,��И�KI,�6�'A4t�I3�I ����%�+g���)ڢ͢�7<B��T\G��6�T�d��0�3P��/pm\&_�)�(ꔴ@�L�����m����2�      �   '   x�3�LL����,.)JL�/�2�,-.M,������� �P	�      �   {  x���I��H���U���@&¨�T@�ΨI"}�4��yۨIE��XyU#n������s������_?��x����5�>4��|l���I�O|�)�eH�a����{��is���IP6�x�F4�fkn�R�F�
�M�dNb�ǻqLN�پ��!=�U��,����p�8�}�
nsN���z���̛|޻���M�'�4^�׹���!�ZP��YEN����	�~��͛|����������s/�"QM��i���^���;�&Okx��'��w�T��1���bm�!Ֆ55 �Մ�p���v9Ew���>F���|�����σzBL�D�x�x$VЦ9�A���d3:�M��}�����i�OԓO���_��'@��!��%<SO&� 
����A{�Q�]r��"c�]fp�pL7i�N��5��
��26���A�����j�D>:J����㲮8��-?���I��p2�2crۜOm�t�mu�z$[�;���0��ÿ���
��j8 ���3���4��aJ��:�s��'dr;53n��z�S�v���B�S�Y^(y2dEY�c��w�=UeD�糼pɮqL5�O�kF��Z�T�
	<~.����Z+<+g��/�r��"!b��<�\<g_�wCj�!}�<���0�RA��Ye���c��k	���2-���|{|-��#j�$�d��~$��:�A���t�iƖ���n[Hrj,O�k	�㓐,7��)Jb�S��&4�FZ�S�����`���*Q��G��p{i��#�1���OE3w�
���U�2'���l�͛�YW'��n�����c3���Ths|��s���2a��>@	�|�n�
u�� �)�R��\�V���ir      �   ,   x�3��IM�,����2�̄�M8SJS����"�p!��=... �f      �   �   x�U�ˎ� E��c"CB���0�X#�$HFm���V󐥫s7G�qD;�����G�	4��2pY3�@���)���E�_I�|Z� ΢1=Z�#���-�d��BJm捳�c� ��Y�����?˅��g����R:�]�;��JJ�}�þ�r��p-���g�t)���)���:W�      �   +   x�34��4a.C#sN6�24��44��r�)3F��� ��     