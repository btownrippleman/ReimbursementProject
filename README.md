Skip to content
 
 
Search…
All gists
GitHub
New gist @btownrippleman
 Edit
  Delete
  Star 0
  @btownripplemanbtownrippleman/tables for project 1
Created 19 minutes ago
Embed  
<script src="https://gist.github.com/btownrippleman/e383e89a2481264482427d0fbf6f9212.js"></script>
  Download ZIP
 Code  Revisions 1
wow, what a waste of time making these tables, good practice for proc programming though!!!
Raw  tables for project 1
create table ers_reimbursement_status(
  reimb_status_id number,
  reimb_status varchar2(10),
  constraint reimb_status_pk primary key (reimb_status_id)
  )
  //
    
  create table ers_reimbursement_type(
  reimb_type_id number,
  reimb_type varchar2(10),
  constraint reimb_type_pk primary key (reimb_type_id)
  )

  create table ers_user_roles (
  ers_user_role_id number,
  user_role varchar2(10),
  constraint ers_user_roles_pk primary key (ers_user_role_id)
  )
  
  
  create table ers_employees (
  emp_id number,
  emp_username varchar2(50),
  emp_password varchar2(50),
  emp_first_name varchar2(100),
  emp_last_name varchar2(100),
  emp_email varchar2(150),
  emp_role_id number,
  constraint ers_employees_pk primary key (emp_id),
  constraint ers_employees_unv1 unique (emp_username, emp_email),
  constraint emp_roles_fk foreign key (emp_id) references ers_user_roles (ers_user_role_id)
  )
  
    
    

 
  create table ers_reimbursement(
  reimb_id number,
  reimb_amount number,
  reimb_submitted date,
  reimb_resolved date,
  reimb_description varchar2(250),
  reimb_receipt blob,
  reimb_author number,
  reimb_resolver number,
  reimb_status_id number,
  reimb_type_id number,
  constraint ers_reimbursement_pk primary key (reimb_id),
  constraint ers_users_fk_auth foreign key (reimb_id) references ers_employees (emp_id),
  constraint ers_reimbursement_status_fk foreign key (reimb_status_id) references ers_reimbursement_status(  reimb_status_id),
  constraint ers_reimbursement_type_fk foreign key (reimb_type_id) references ers_reimbursement_type(reimb_type_id)
  )
create sequence ers_reimbursement_seq
  start with 1 increment by 1;
create or replace trigger ers_rmbrsmnt_sts_trigger
  before insert on ers_reimbursement
  for each row
  begin
    select ers_reimbursement_seq.nextval into :new.reimb_id from dual;
  end;
  
 create     sequence ers_reimbursement_seq
  start with 1 increment by 1;
create or replace trigger ers_reimbursement_trigger
  before insert on ers_reimbursement
  for each row
  begin
    select ers_reimbursement_seq.nextval into :new.reimb_id from dual;
  end;

create sequence  ers_reimbursement_status_seq
  start with 1 increment by 1;
create or replace trigger ers_reimbursement_status_trigger
before insert on ers_reimbursement_status
for each row
begin 
select ers_reimbursement_status_seq.nextval into :new.reimb_status_id from dual;
end;

create sequence  ers_reimbursement_type_seq
  start with 1 increment by 1;
create or replace trigger  ers_reimbursement_type_trigger
 before insert on ers_reimbursement_type
for each row 
begin
select ers_reimbursement_type_seq.nextval into :new.reimb_type_id from dual ;
end;

create sequence ers_user_roles_seq
  start with 1 increment by 1;
  
create or replace trigger ers_user_roles_trigger
before insert on ers_user_roles
for each row
begin
select ers_user_roles_seq.nextval into :new.ers_user_role_id from dual;
end;


create sequence  ers_employees_seq
  start with 1 increment by 1;
create or replace trigger   ers_employees_trigger
  before insert on ers_employees 
  for each row
  begin
    select ers_employees_seq.nextval into :new.emp_id from dual;
  end;
--
--      ers_employees
--  
--ers_reimbursement_type
--ers_user_roles
-- ers_reimbursement
 @btownrippleman
           
Write  Preview

Leave a comment
Attach files by dragging & dropping,  Choose Files selecting them, or pasting from the clipboard.
 Styling with Markdown is supported
Comment
Status API Training Shop Blog About
© 2016 GitHub, Inc. Terms Privacy Security Contact Help
