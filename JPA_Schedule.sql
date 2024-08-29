-- 데이터베이스 생성
create database calendar_dev;
-- 일정 테이블 생성
create table schedule (
                          id bigint not null auto_increment,
                          creation_date datetime(6),
                          modified_date datetime(6),
                          content varchar(255),
                          title varchar(255),
                          user_id bigint,
                          primary key (id)
)
-- 일정 테이블 fk키 설정
alter table schedule
    add constraint FKa50n59y1j4a6qwa42p8jiguds
        foreign key (user_id)
            references user (id)

-- 댓글 테이블 생성
create table comment (
                         id bigint not null auto_increment,
                         creation_date datetime(6),
                         modified_date datetime(6),
                         comments varchar(255),
                         username varchar(255),
                         schedule bigint,
                         primary key (id)
)
-- 댓글 테이블 fk키 설정
alter table comment
    add constraint FKasvao2jpqgaxwigf5t719p7tw
        foreign key (schedule_id)
            references schedule (id)

-- 유저 테이블 생성
create table user (
                      id bigint not null auto_increment,
                      created_at datetime(6),
                      modified_at datetime(6),
                      email varchar(255),
                      user_id varchar(255),
                      primary key (id)
)

-- 일정, 유저 중간 테이블 생성
create table register (
                                     id bigint not null auto_increment,
                                     creation_date datetime(6),
                                     modified_date datetime(6),
                                     schedule_id bigint,
                                     user_id bigint,
                                     primary key (id)
)
-- 일정 fk키 설정
alter table schedule_assignment
    add constraint FKedfd5tadi0qcbn1htmqj0vrkn
        foreign key (schedule_id)
            references schedule (id)
-- 유저 fk키 설정
alter table schedule_assignment
    add constraint FKlge7j322nfrl4e848e04511y3
        foreign key (user_id)
            references user (id)
