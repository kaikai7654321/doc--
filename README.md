# doc--
一个在线文档浏览系统

软件工程设计文档：

一：目标：实现一个在线文档系统：
   1. 学生可以上传下载浏览文档（本校内）（过滤器）
   2. 学生有账号
   3. 文档信息包括：name,author,type,abstract,attached file（这个也许可以
       在上传的时候实现。）, uploader
           这里是自己加的：上传时间，下载次数，平均得分
   4. 管理员可以根据目录建立维护（查询）
   5. 学生可以根据目录或者关键字查询文档
   6. 学生可以评论推荐（评论和打分就可以了）
   7. 自己在添加不少于一项的创新功能

   已经实现的： 1(未加过滤器),2学生账号（可以打分）,3文档信息（相关文档没有实现），4，管理
                可以管理doc（增删查）5.学生查看文档下载，上传。6.评论和打分（评论未分页）
		7.在线预览所有形式文档（doc,txt,docx,html）
二：开发：
   1.BS（浏览器加服务器）
   2.tomcat8.0+myeclipse2015+mysql5.7

三：界面设计：
   1.登陆界面：index.jsp, 实现学生和管理员的分流。
   2.管理员界面：显示文档目录（使用题头有选项，添加，查询，显示全部，目录表之后有一项
     删除，点进去每个文档的详细页有删除按钮）
   3.文档详细页面。展示文档，分为标题，摘要，正文，评分，评论（每个评论后面都有评分，
     上面那个事平均的），
   4.学生界面：使用左边侧边管理目录，中间正文，文档目录没有删除按钮了，变成下载按钮。详细页
   也有下载按钮。管理目录有显示全部（要分页的），上面有查询，上传，个人信息，评论，
   5.显示全部界面：分页，下载，查询，显示详情
   6.上传：选择文件，关联文件，摘要，题目，作者，
   7.个人信息：账号，密码，已下载，已上传（后面两个暂时不写）
四：数据库设计
   1.文档，doc
     1.1.id
         name
	 author
	 type
	 abs
	 
	 attachedFile
	 uploader
	 uploadTime
	 downloadTime(次数)
	 score
         url(存储地址)
	 htmlUrl(doc转成html后html的存储地址)
   2.用户，student
     userAccount
     password
     无法判断他下载了那些
   3.管理员，admin
   id
   password
   4.下载表
     id
    userAccount(外键）
    docID（外键）
  
1.开发大致用了9天。其中：
  第一天数据库出现问题，多种版本的mysql混乱，用mysql workbench看到的不是自己原来那个版本的
       mysql,用了一天解决。删掉别的版本。
  乱码问题用了一天多一点。评论用了半天。上传和下载各用半天。分页也是半天。注册和管理员界面
  用了一天。对细节进行改进用了一天半。其他用了剩下的时间。
2.关于乱码问题，会独立写个总结。对于常遇到的问题，会独立写另一个总结。
3.关于MVC的理解：
  3.1.为了保证JSP页面只有java.util.*一个类，感觉在控制器上加了更多的代码。因为不能再jsp页面
    出现自己写的哪些类。尤其javaBean。这导致自己觉得这有意义吗？
  3.2.有些地方没有经过很好的包装，控制器没有进行很好的按功能划分，更多时候是按照进度。业务逻辑
    也没有进行很好的封装。导致重复代码较多。而且自己最后有点困惑，感觉DAO结构没有用的很好。
    业务逻辑里面大量出现static方法。应该就是出现太多static不符合java以类为对象开发的思想。
  3.3.在开发的时候，虽然MVC已经带来便利，但感觉自己没有完全掌握，所有还是有点乱。繁杂。这是
    开发这类程序必须解决的问题。不然程序越大，调试和开发难度成大于线性的增长。
  3.4.最终自己实现了JSP页面只引入一个类，java.util.*类。所有请求经过控制器(近乎所有)
4.过滤器没有实现。很遗憾。应该试试的。

5.有些地方也是不尽如人意：
  5.1.管理员无法删除用户，因为删除的话会牵涉到doc和他发表的评论，在后台看就是外键。这里的
    删除应该是封号，而不是把所有的都删除，但是自己没有继续想个好方法实现。
  5.2.相关文档没有实现。感觉知网上是因为有固定格式，所以可以解析文档。但是这个项目的文档没有
    固定格式。另外，也许可以用那种两个框，这边选的在另一个框里出现那种方法实现。但工作量
    应该不小。
  5.3.用户也无法修改自己的密码。
  5.4.评论无法分页。
  5.5.下载不成功下载量也会加一。
  5.6.上传文档之后，如果直接在线预览，再使用预览页面的返回，就会出问题。问题出在返回上，但是
    也没有去解决。
  5.7.上传文档的时候不会判断是不是文档名已经存在。因为文档名不能一样。我也想过文档名可以
    重复。但是后来觉得不行，因为文档是放在同一个文件夹里面，这样会覆盖的。除非自己存起来的
    时候在名字后面把日期加上。下载的时候在去掉。
  5.8.界面不好看。很多地方布局不合理。
  5.9.同意的error.page没有加上。

6.补充：
   6.1.设计理念：
       6.1.1.横向上用户和管理员分开。从统一入口（登陆页面）进入不同的界面。（在代码上也是
             二者的代码分开）
       6.1.2.纵向上采用MVC分层。View层，Control层，Model层和数据库（持久层）,每一层只会
             与相邻的层之间有调用关系。这样就可以实现很好的封装，开发起来也会方便很多。
    6.2.方案选择：
        6.2.1.webroot下面的index.jsp是登陆页面，也是程序的入口。
	6.2.2.webroot的jsp和js文件夹下面都分成admin和user两个文件夹，相应的文件夹里面 是
	  admin和user对应的文件。
	6.2.3.webroot下面的其他文件夹为测试使用。包括html,txt,image,test,test2
	6.2.4.src目录下面共有六个package包括了control(com.lib.control),javabean(com.lib.bean),
	  service(com.lib.service),db工具库(com.lib.db)和公共工具库(com.lib.util),已经开
	  发测试用的测试包(com.lib.test).
	      A.control: 控制器所在处，共七个控制器，使用Servlet写成。功能上接受来自JSP
	        (View)的请求，并通过调研Model层的函数和类，返回结果给JSP页面。
	      B.javabean:java类所在处，共四个类。与数据库里面的表一一对应
	      C.service: 业务逻辑层。与四个类相对应，每个类对应两个业务逻辑层函数XXXService
	        和XXXServiceProxy。通过调用javabean和db工具类链接数据库来完成控制器需要完成
		的任务。
	      D.db工具库: 建立与数据的链接，生成不涉及具体对象的数据库调用函数。供业务逻辑层
	        使用。
              E.公共工具库: 一些公共函数，比如doc文档转成html的函数。
        6.3.也许这样写方案选择不好，可以参考软件工程课程设计文档里面的设计来写。
    6.3.特点，就是：
      6.3.1.JSP页面只引入一个包(java.util.*),不会出现javabean的使用。
      6.3.2.所有请求经过控制器，不会从JSP直接到JSP。
      这两点保证了彻底的分层。降低代码耦合性，提升代码的可重用性。开发起来也比较方便。
	  


