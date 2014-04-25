--select table
select * from tec_basic_info;   --教师基本信息表
select * from purview_info;     --权限信息表
select * from role_info;        --角色信息表
select * from teacher_purview;  --教师权限表（暂不用）
select * from teacher_role;     --教师角色表
select * from role_purview;     --角色权限表
select * from dep_info;         --部门信息表
select * from dep_teacher;      --部门教师表

--drop table
drop table if exists teacher_role;
drop table if exists teacher_purview;
drop table if exists role_purview;
drop table if exists purview_info;
drop table if exists role_info;
drop table if exists dep_teacher;

--init table

--init purview





