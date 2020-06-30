/*
** 经典SQL 50题练习
** 表结构说明
** 学生表（学生编号、姓名、出生年月、性别）
** 课程表（课程编号、名称、教师编号）
** 教师表（教师编号、教师名称）
** 成绩表（学生编号、课程编号、分数）
** online test：http://sqlfiddle.com/
 */

# 创建表
create table `student` (
    `s_id` varchar(20) comment '学生编号',
    `s_name` varchar(20) not null default '' comment '学生姓名',
    `s_birth` varchar(20) not null default ''comment '出生年月',
    `s_sex` varchar(10) not null default ''comment '学生性别',
    primary key(`s_id`)
)engine = innodb default charset = utf8 comment = '学生表';

create table `course` (
    `c_id` varchar(20) comment '课程编号',
    `c_name` varchar(20) not null default '' comment '课程名称',
    `t_id` varchar(20) not null comment '教师编号',
    primary key(`c_id`)
) engine = innodb default charset = utf8 comment '课程表';

create table `teacher` (
    `t_id` varchar(20) comment '教师编号',
    `t_name` varchar(20) comment '教师名称',
    primary key(`t_id`)
) engine = innodb default charset = utf8 comment '教师表';

create table `score` (
    `s_id` varchar(20) comment '学生编号',
    `c_id` varchar(20) comment '课程编号',
    `s_score` int(3) comment '课程分数',
    primary key(`s_id`, `c_id`)
) engine = innodb default charset = utf8 comment '成绩表';

# 测试数据插入
-- 插入学生表测试数据插入学生表测试数据
insert into student values('01', '赵雷' , '1990-01-01' , '男');
insert into student values('02', '钱电' , '1990-12-21' , '男');
insert into student values('03' , '孙风' , '1990-05-20' , '男');
insert into student values('04' , '李云' , '1990-08-06' , '男');
insert into student values('05' , '周梅' , '1991-12-01' , '女');
insert into student values('06' , '吴兰' , '1992-03-01' , '女');
insert into student values('07' , '郑竹' , '1989-07-01' , '女');
insert into student values('08' , '王菊' , '1990-01-20' , '女');
-- 课程表测试数据
insert into course values('01' , '语文' , '02');
insert into course values('02' , '数学' , '01');
insert into course values('03' , '英语' , '03');

-- 教师表测试数据
insert into teacher values('01' , '张三');
insert into teacher values('02' , '李四');
insert into teacher values('03' , '王五');

-- 成绩表测试数据
insert into score values('01' , '01' , 80);
insert into score values('01' , '02' , 90);
insert into score values('01' , '03' , 99);
insert into score values('02' , '01' , 70);
insert into score values('02' , '02' , 60);
insert into score values('02' , '03' , 80);
insert into score values('03' , '01' , 80);
insert into score values('03' , '02' , 80);
insert into score values('03' , '03' , 80);
insert into score values('04' , '01' , 50);
insert into score values('04' , '02' , 30);
insert into score values('04' , '03' , 20);
insert into score values('05' , '01' , 76);
insert into score values('05' , '02' , 87);
insert into score values('06' , '01' , 31);
insert into score values('06' , '03' , 34);
insert into score values('07' , '02' , 89);
insert into score values('07' , '03' , 98);

/*
** 常用的SQL基础知识
（1）查询关键字顺序：select --> from --> where --> group by --> having --> order by
　  from: 需要从哪个数据表检索数据 。
　　where: 过滤表中数据的条件。
　　group by: 如何将上面过滤出的数据分组。
　　having: 对上面已经分组的数据进行过滤的条件。
　　select: 查看结果集中的哪个列，或列的计算结果。
　　order by: 按照什么样的顺序来查看返回的数据。

（2） 可使用的JOIN 类型
    JOIN（inner join）: 如果表中有至少一个匹配，则返回行
    LEFT JOIN: 即使右表中没有匹配，也从左表返回所有的行
    RIGHT JOIN: 即使左表中没有匹配，也从右表返回所有的行
    FULL JOIN: 只要其中一个表中存在匹配，就返回行

（3）drop、truncate、delete区别
    1.drop将表结构和表数据直接删除，无法找回；truncate和delete删除表数据，保留表结构；
    2.truncate删除数据过程不记录日志，无法回滚，并且删除后会重建索引；delete删除过程会记录日志，用于回滚，但是不会删除索引；
    3.执行速度：drop > truncate > delete

（4）常用范式：1NF、2NF、3NF、BCNF
    1.第一范式：第一范式要求数据库中的表都是二维表
    2.第二范式：数据库表中不存在非关键字段对任一候选关键字段的部分函数依赖（所有单关键字段的表都符合第二范式）
    3.第三范式：在第二范式基础上定义，如果数据库表中不存在非关键字段对任意候选关键字段的传递函数依赖
    4.BC范式：在第三范式基础上，数据库表中如果不存在任何字段对任意候选关键字段的传递函数依赖则符合BC范式（复合关键字之间也不能存在函数依赖关系）

（五）数据库设计过程：尽量避免数据操作异常和数据冗余
    1.需求分析：数据定义，属性以及特点
    2.逻辑设计：使用ER图进行逻辑建模
    3.物理设计：根据数据库自身特点把逻辑设计转换为物理设计
    4.维护优化：索引优化和大表拆分（水平拆分和垂直拆分）
 */
# 练习题
-- 1、查询"01"课程比"02"课程成绩高的学生的信息及课程分数
select st.*, sc.01_score, sc.02_score
from student st, (
    select s1.s_id as s_id, s1.s_score as 01_score, s2.s_score as 02_score
    from score s1, score s2
    where s1.s_id = s2.s_id and s1.c_id = '01' and s2.c_id = '02' and s1.s_score > s2.s_score
    )
    sc
where st.s_id = sc.s_id;

select st.*, sc1.s_score as '01_score', sc2.s_score as '02_score'
from student st
left join score sc1 on sc1.s_id = st.s_id and sc1.c_id = '01'
left join score sc2 on sc2.s_id = st.s_id and sc2.c_id = '02'
where sc1.s_score > sc2.s_score;

select st.*, sc1.s_score as '01_score', sc2.s_score as '02_score'
from student st
join score sc1 on sc1.s_id = st.s_id and sc1.c_id = '01'
left join score sc2 on sc2.s_id = st.s_id and sc2.c_id = '02'
where sc1.s_score > sc2.s_score;

-- 2、查询"01"课程比"02"课程成绩低的学生的信息及课程分数
select st.*, sc1.s_score as '01_score', sc2.s_score as '02_score'
from student st
left join score sc1 on sc1.s_id = st.s_id and sc1.c_id = '01'
left join score sc2 on sc2.s_id = st.s_id and sc2.c_id = '02'
where sc1.s_score < sc2.s_score;

-- 3、查询平均成绩大于等于60分的同学的学生编号和学生姓名和平均成绩
--GROUP BY得配合聚合函数来用，分组之后使用聚合函数，常用的聚合函数：count(), sum(), avg(), max(), min()。
select st.s_id, st.s_name, round(avg(sc.s_score), 2) as '平均成绩'
from student st
join score sc on sc.s_id = sc.s_id
group by st.s_id
having avg(sc.s_score) >= 60;

-- 4、查询平均成绩小于60分的同学的学生编号和学生姓名和平均成绩,包括有成绩的和无成绩的
select st.s_id, st.s_name, round(avg(sc.s_score), 2) as '平均成绩'
from student st
left join score sc on sc.s_id = st.s_id
group by sc.s_id
having avg(sc.s_score) < 60
    union
select st.s_id, st.s_name, 0 as '平均成绩'
from student st
where st.s_id not in (select distinct s_id from score);

-- 5、查询所有同学的学生编号、学生姓名、选课总数、所有课程的总成绩
select st.s_id, st.s_name, count(sc.c_id) as '选课总数', sum(case when sc.s_score is null then 0 else sc.s_score end) as '课程总成绩'
from student st
left join score sc on sc.s_id = st.s_id
group by sc.s_id;

-- 6、查询"李"姓老师的数量
select count(te.t_id)
from teacher te
where te.t_name like '李%';

-- 7、查询学过"张三"老师授课的同学的信息
select st.*, te.t_name
from student st
left join score sc on sc.s_id = st.s_id
left join course co on sc.c_id = co.c_id
left join teacher te on co.t_id = te.t_id
where te.t_name = '张三';

-- 8、查询没学过"张三"老师授课的同学的信息
select st.*
from student st
where st.s_id not in (
    select sc.s_id
    from score sc
    where sc.c_id in (
        select co.c_id
        from course co
        left join teacher te on te.t_id = co.t_id
        where te.t_name = '张三'
    )
);

-- 9、查询学过编号为"01"并且也学过编号为"02"的课程的同学的信息
select st.*
from student st, score sc1, score sc2
where st.s_id = sc1.s_id and st.s_id = sc2.s_id and sc1.c_id = '01' and sc2.c_id = '02';

select st.*
from student st
join score sc on sc.s_id = st.s_id and sc.c_id = '01'
where st.s_id in (
    select sc2.s_id
    from student st2
    join score sc2 on sc2.s_id = st2.s_id and sc2.c_id = '02'
);

-- 10、查询学过编号为"01"但是没有学过编号为"02"的课程的同学的信息
select st.*
from student st
join score sc on sc.s_id = st.s_id and sc.c_id = '01'
where st.s_id not in (
    select sc2.s_id
    from student st2
    join score sc2 on sc2.s_id = st2.s_id and sc2.c_id = '02'
);

-- 11、查询没有学全所有课程的同学的信息
select st.*
from student st
left join score sc on st.s_id = sc.s_id
group by st.s_id
having count(sc.c_id) < (select count(*) from course);

select st.*
from student st
where st.s_id not in (
    select sc.s_id
    from score sc
    group by sc.s_id
    having count(sc.c_id) = (select count(distinct c_id) from course)
);

select st.*
from student st
where st.s_id not in (
    select st2.s_id
    from student st2
    join score sc1 on sc1.s_id = st2.s_id and sc1.c_id = '01'
    join score sc2 on sc2.s_id = st2.s_id and sc2.c_id = '02'
    join score sc3 on sc3.s_id = st2.s_id and sc3.c_id = '03'
);

-- 12、查询至少有一门课与学号为"01"的同学所学相同的同学的信息
select distinct st.*
from student st
left join score sc on st.s_id = sc.s_id
where sc.c_id in (
    select sc2.c_id
    from score sc2
    where sc2.s_id = '01'
);

-- 13、查询和"01"号的同学学习的课程完全相同的其他同学的信息
select st.*
from student st
join score sc on sc.s_id = st.s_id
group by st.s_id
having group_concat(sc.c_id) = (
    select group_concat(sc2.c_id)
    from score sc2
    where sc2.s_id = '01'
);

-- 14、查询没学过"张三"老师讲授的任一门课程的学生姓名
select st.s_name
from student st
where st.s_id not in(
    select sc.s_id
    from course co
    left join score sc on sc.c_id = co.c_id
    left join teacher te on te.t_id = co.t_id
    where te.t_name = '张三'
);

-- 15、查询两门及其以上不及格课程的同学的学号，姓名及其平均成绩
select st.s_id, st.s_name, round(avg(sc.s_score), 2) as 'avg_score'
from student st
left join score sc on sc.s_id = st.s_id
where st.s_id in (
    select sc2.s_id
    from score sc2
    where sc2.s_score < 60 or sc2.s_score is null
    group by sc2.s_id
    having count(*) >= 2
)
group by st.s_id;

-- 16、检索"01"课程分数小于60，按分数降序排列的学生信息
select st.*, sc.s_score
from student st
join score sc on sc.s_id = st.s_id and sc.c_id = '01'
where sc.s_score < 60
order by sc.s_score desc ;

-- 17、按平均成绩从高到低显示所有学生的所有课程的成绩以及平均成绩
select st.s_id, st.s_name,
    (case when avg(sc4.s_score) is null then 0 else avg(sc4.s_score) end) "平均分",
    (case when sc1.s_score is null then 0 else sc1.s_score end) "语文",
    (case when sc2.s_score is null then 0 else sc2.s_score end) "数学",
    (case when sc3.s_score is null then 0 else sc3.s_score end) "英语"
from student st
left join score sc1 on sc1.s_id = st.s_id and sc1.c_id = '01'
left join score sc2 on sc2.s_id = st.s_id and sc2.c_id = '02'
left join score sc3 on sc3.s_id = st.s_id and sc3.c_id = '03'
left join score sc4 on sc4.s_id = st.s_id
group by sc4.s_id
order by avg(sc4.s_score) desc ;

select st.s_id, st.s_name,
    (select sc1.s_score from score sc1 where sc4.s_id = sc1.s_id and sc1.c_id = '01') as '语文',
    (select sc2.s_score from score sc2 where sc4.s_id = sc2.s_id and sc2.c_id = '02') as '数学',
    (select sc3.s_score from score sc3 where sc4.s_id = sc3.s_id and sc3.c_id = '03') as '数学',
    avg(sc4.s_score) as 'avg_score'
from student st
left join score sc4 on st.s_id = sc4.s_id
group by sc4.s_id
order by avg_score desc;

-- 18.查询各科成绩最高分、最低分和平均分：以如下形式显示：课程ID，课程name，最高分，最低分，平均分，及格率，中等率，优良率，优秀率
-- 及格为>=60，中等为：70-80，优良为：80-90，优秀为：>=90
select co.c_id, co.c_name, max(sc1.s_score) as '最高分',
     min(sc2.s_score) as '最低分',
     avg(sc3.s_score) as '平均分',
     ((select count(*) from score where s_score >= 60 and c_id = co.c_id) / (select count(*) from score where c_id = co.c_id)) as '及格率',
     ((select count(*) from score where s_score >= 70 and s_score < 80 and c_id = co.c_id) / (select count(*) from score where c_id = co.c_id)) as '中等率',
     ((select count(*) from score where s_score >= 80 and s_score < 90 and c_id = co.c_id) / (select count(*) from score where c_id = co.c_id)) as '优良率',
     ((select count(*) from score where s_score >= 90 and c_id = co.c_id) / (select count(*) from score where c_id = co.c_id)) as '优秀率'
from course co
left join score sc1 on sc1.c_id = co.c_id
left join score sc2 on sc2.c_id = co.c_id
left join score sc3 on sc3.c_id = co.c_id
group by co.c_id;

-- 19、按各科成绩进行排序，并显示排名
-- mysql没有rank函数，实现参考：https://www.cnblogs.com/caicaizi/p/9803013.html
select sc.s_id, sc.c_id, sc.s_score, @curRank := @curRank + 1 as 'rank'
from score sc, (select @curRank := 0) c
where sc.c_id = '01'
order by sc.s_score desc;

select sc.s_id, sc.c_id, sc.s_score,
    case when @preRank = sc.s_score then @curRank
         when @preRank := sc.s_score then @curRank := @curRank + 1
    end as 'rank'
from score sc, (select @curRank := 0, @preRank := null) c
where sc.c_id = '01'
order by sc.s_score desc;


select * from (
    select sc1.s_id, sc1.c_id, sc1.s_score,
        case when @preRank1 = sc1.s_score then @curRank1
             when @preRank1 := sc1.s_score then @curRank1 := @curRank1 + 1
        end as 'rank'
    from score sc1, (select @curRank1 := 0, @preRank1 := null) c
    where sc1.c_id = '01'
    order by sc1.s_score desc
) as t1 union all select * from (
    select sc.s_id, sc.c_id, sc.s_score,
        case when @preRank = sc.s_score then @curRank
             when @preRank := sc.s_score then @curRank := @curRank + 1
        end as 'rank'
    from score sc, (select @curRank := 0, @preRank := null) c
    where sc.c_id = '02'
    order by sc.s_score desc
) t2;

(
    select sc1.s_id, sc1.c_id, sc1.s_score,
        case when @preRank1 = sc1.s_score then @curRank1
             when @preRank1 := sc1.s_score then @curRank1 := @curRank1 + 1
        end as 'rank'
    from (
            select *
            from score
            where c_id = '01'
            order by s_score desc
        ) sc1, (select @curRank1 := 0, @preRank1 := null) c
) union all(
    select sc.s_id, sc.c_id, sc.s_score,
        case when @preRank = sc.s_score then @curRank
             when @preRank := sc.s_score then @curRank := @curRank + 1
        end as 'rank'
    from (
            select *
            from score
            where c_id = '02'
            order by s_score desc
        ) sc, (select @curRank := 0, @preRank := null) c
)

-- 20、查询学生的总成绩并进行排名
select st.s_id, st.s_name, st.sum, @rank := @rank + 1 as 'rank'
from (
    select st0.s_id, st0.s_name,
        case when sum(sc0.s_score) is null then 0 else sum(sc0.s_score) end as 'sum'
    from  student st0
    left  join score sc0 on sc0.s_id = st0.s_id
    group by st0.s_id
) st, (select @rank := 0) r;

-- 21、查询不同老师所教不同课程平均分从高到低显示
select te.t_id, te.t_name, co.c_name, round(avg(sc.s_score), 2) as 'avg_score'
from teacher te
left join course co on co.t_id = te.t_id
left join score sc on sc.c_id = co.c_id
group by co.c_id
order by avg(sc.s_score) desc ;

-- 22、查询所有课程的成绩第2名到第3名的学生信息及该课程成绩
select st.s_id, st.s_name, sc.c_id, sc.s_score
from  student st
left join score sc on sc.s_id = st.s_id
where sc.c_id = '01'
order by sc.s_score desc
limit 1,2;

select * from (
    select st.s_id, st.s_name, sc.c_id, sc.s_score
    from  student st
    left join score sc on sc.s_id = st.s_id
    where sc.c_id = '01'
    order by sc.s_score desc
    limit 1,2
) t1 union select * from (
    select st.s_id, st.s_name, sc.c_id, sc.s_score
    from  student st
    left join score sc on sc.s_id = st.s_id
    where sc.c_id = '02'
    order by sc.s_score desc
    limit 1,2
) t2 union select * from (
    select st.s_id, st.s_name, sc.c_id, sc.s_score
    from  student st
    left join score sc on sc.s_id = st.s_id
    where sc.c_id = '03'
    order by sc.s_score desc
    limit 1,2
) t3;

-- 23、统计各科成绩各分数段人数：课程编号,课程名称,[100-85],[85-70],[70-60],[0-60]及所占百分比
select co.c_id, co.c_name,
    (select count(*) from score where c_id = co.c_id and s_score >= 85 and s_score <= 100)/(select count(*) from score  where c_id = co.c_id) as '[100-85]',
    (select count(*) from score where c_id = co.c_id and s_score >= 70 and s_score <= 85)/(select count(*) from score  where c_id = co.c_id) as '[85-70]',
    (select count(*) from score where c_id = co.c_id and s_score >= 60 and s_score <= 70)/(select count(*) from score  where c_id = co.c_id) as '[70-60]',
    (select count(*) from score where c_id = co.c_id and s_score >= 0 and s_score <= 60)/(select count(*) from score  where c_id = co.c_id) as '[60-0]'
from course co;

-- 24、查询学生平均成绩及其名次
select st.s_id, st.s_name, st.avg_score, @rank := @rank + 1 as 'rank'
from (
    select st.s_id, st.s_name,
        case when avg(sc.s_score) is null then 0 else round(avg(sc.s_score), 2) end as 'avg_score'
    from student st
    left join score sc on sc.s_id = st.s_id
    group by sc.s_id
    order by avg_score desc
) st, (select @rank := 0) r;

-- 25、查询各科成绩前三名的记录
select st.s_id, st.s_name, sc.c_id, sc.s_score
from student st
left join score sc on sc.s_id = st.s_id and sc.c_id = '01'
order by sc.s_score desc
limit 0,3

select st.*, @rank := @rank + 1
from (
    select st.s_id, st.s_name, sc.c_id, sc.s_score
    from student st
    left join score sc on sc.s_id = st.s_id and sc.c_id = '01'
    order by sc.s_score desc
    limit 0,3
) st, (select @rank := 0) r
union
select st.*, @rank1 := @rank1 + 1
from (
    select st.s_id, st.s_name, sc.c_id, sc.s_score
    from student st
    left join score sc on sc.s_id = st.s_id and sc.c_id = '02'
    order by sc.s_score desc
    limit 0,3
) st, (select @rank1 := 0) r;

-- 26、查询每门课程被选修的学生数
select sc.c_id, count(sc.s_id)
from score sc
group by sc.c_id;

-- 27、查询出只有两门课程的全部学生的学号和姓名
select st.s_id, st.s_name
from student st
left join score sc on sc.s_id = st.s_id
group by sc.s_id
having count(sc.c_id) = 2;

-- 28、查询男生、女生人数
select st.s_sex, count(st.s_id) as 'count'
from student st
group by st.s_sex;

-- 29、查询名字中含有"风"字的学生信息
select *
from student st
where st.s_name like '%风%';

-- 30、查询同名同性学生名单，并统计同名人数
select *, count(st.s_id)
from student st
group by st.s_name, st.s_sex;

-- 31、查询1990年出生的学生名单
select *
from student
where s_birth like '1990%';

-- 32、查询每门课程的平均成绩，结果按平均成绩降序排列，平均成绩相同时，按课程编号升序排列
select co.c_id, co.c_name, avg(sc.s_score) as 'avg_score'
from course co
left join score sc on sc.c_id = co.c_id
group by co.c_id
order by avg_score desc, co.c_id asc;

-- 33、查询平均成绩大于等于85的所有学生的学号、姓名和平均成绩
select st.s_id, st.s_name, avg(sc.s_score) as 'avg_score'
from student st
left join score sc on sc.s_id = st.s_id
group by sc.s_id
having avg_score >= 85;

-- 34、查询课程名称为"数学"，且分数低于60的学生姓名和分数
select st.s_name, sc.s_score, co.c_name
from student st
left join score sc on sc.s_id = st.s_id
join course co on co.c_id = sc.c_id and co.c_name = '数学'
where sc.s_score < 60;

select st.s_name, tmp.s_score, tmp.c_name
from student st, (
    select sc.s_id, sc.s_score, co.c_name
    from score sc
   join course co on co.c_id = sc.c_id and co.c_name = '数学'
    where sc.s_score < 60
) tmp
where st.s_id = tmp.s_id;

-- 35、查询所有学生的课程及分数情况
select st.s_id, st.s_name,
        sum(case when co.c_name = '语文' then sc.s_score else 0 end ) as '语文',
        sum(case when co.c_name = '数学' then sc.s_score else 0 end ) as '数学',
        sum(case when co.c_name = '英语' then sc.s_score else 0 end ) as '英语',
        (case when sum(sc.s_score) is null then 0 else sum(sc.s_score) end ) as '总分'
from student st
left join score sc on sc.s_id = st.s_id
left join course co on co.c_id = sc.c_id
group by sc.s_id
order by sum(sc.s_score) desc ;

-- 36、查询任何一门课程成绩在70分以上的姓名、课程名称和分数
select st.s_name, co.c_name, sc.s_score
from student st
join score sc on sc.s_id = st.s_id
join course co on co.c_id = sc.c_id
where sc.s_score > 70;

-- 37、查询不及格的课程
select st.s_name, co.c_name, sc.s_score
from student st
join score sc on sc.s_id = st.s_id
join course co on co.c_id = sc.c_id
where sc.s_score < 60;

-- 38、查询课程编号为01且课程成绩在80分以上的学生的学号和姓名
select st.*
from student st
join score sc on sc.s_id = st.s_id
where sc.c_id = '01' and sc.s_score >= 80;

-- 39、求每门课程的学生人数
select co.c_id, co.c_name, count(sc.s_id) as 'count'
from course co
join score sc on sc.c_id = co.c_id
group by sc.c_id;

-- 40、查询选修"张三"老师所授课程的学生中，成绩最高的学生信息及其成绩
select st.*
from student st
join score sc on sc.s_id = st.s_id
join course co on co.c_id = sc.c_id
join teacher te on te.t_id = co.t_id and te.t_name = '张三'
order by sc.s_score
limit 1;

-- 41、查询不同课程成绩相同的学生的学生编号、课程编号、学生成绩
select distinct sc.s_id, sc.c_id, sc.s_score
from score sc, score sc2
where sc.s_score = sc2.s_score and sc.s_id != sc2.s_id;

-- 42、查询每门功成绩最好的前两名
select co.c_id, co.c_name, sc.s_score
from course co
join score sc on sc.c_id = co.c_id
where (
        select count(1)
        from score sc2
        where sc.c_id = sc2.c_id and sc2.s_score >= sc.s_score
) <= 2
order by sc.c_id , sc.s_score desc ;

-- 43、统计每门课程的学生选修人数（超过5人的课程才统计）。要求输出课程号和选修人数，查询结果按人数降序排列
--     若人数相同，按课程号升序排列
select co.c_id, co.c_name, count(sc.s_id) as 'num'
from course co
join score sc on sc.c_id = co.c_id
group by sc.c_id
having count(sc.s_id) >= 5
order by num desc , co.c_id asc ;

-- 44、检索至少选修两门课程的学生学号
select st.s_id, count(sc.c_id) as 'num'
from student st
join score sc on sc.s_id = st.s_id
group by sc.s_id
having count(sc.c_id) > 2;

-- 45、查询选修了全部课程的学生信息
select st.*
from student st
join score sc on sc.s_id = st.s_id
group by st.s_id
having count(sc.c_id) = (select count(*) from course);

-- 46、查询各学生的年龄
select st.*, timestampdiff(year, st.s_birth, now()) as '年龄'
from student st;

-- 47、查询本周过生日的学生
  -- 此处可能有问题,week函数取的为当前年的第几周,2017-12-12是第50周而2018-12-12是第49周,可以取月份,day,星期几(%w),
  -- 再判断本周是否会持续到下一个月进行判断,太麻烦,不会写
select st.*
from student st
where week(now()) = week(date_format(st.s_birth, '%y%m%d'));

-- 48、查询下周过生日的学生
select st.*
from student st
where week(now()) + 1 = week(date_format(st.s_birth, '%y%m%d'));

-- 49、查询本月过生日的学生
select st.*
from student st
where month(now()) = month(date_format(st.s_birth, '%y%m%d'));

-- 50、查询下月过生日的学生
 -- 注意:当 当前月为12时,用month(now())+1为13而不是1,可用timestampadd()函数或mod取模
 select st.*
from student st
where month(timestampadd(month, 1, now())) = month(date_format(st.s_birth, '%y%m%d'));
