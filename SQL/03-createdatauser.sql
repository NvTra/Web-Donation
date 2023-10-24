INSERT INTO role(role_name)
VALUES("Admin"),
      ("User");


INSERT INTO user(full_name, address, email, phone_number, user_name, password, status,created, role_id)
VALUES("Quản trị","Ha Noi","admin@gmail.com","09034204431","admin","admin",1,now(),1),
      ("Nguyễn Trà","Ha Noi","nguyentra@gmail.com","09034221531","tranv","123456",1,now(),2),
      ("Ngân Thúy","Nghe An","nganthuy@gmail.com","0903422233","nganthuy","123456",1,now(),2);
      
      insert into donation(code,name,start_date,end_date,organization_name,phone_number,description,money,created,status)
values("OG0001","Giúp đỡ trẻ em nghèo", "2023-01-30","2023-05-30","Hội từ thiện","024512325","Giúp đỡ trẻ em nghèo",0,now(),"0"),
		("LL2023","Từ thiện lũ lụt", "2023-08-01","2023-12-30","Hội hỗ trợ mùa lũ","021235565","Từ thiện lũ lụt",0,now(),"0"),
        ("TH2146","Vì trẻ em", "2023-08-01","2023-12-30","Trung tâm Tình nguyện","021235565","Vì trẻ em",0,now(),"1"),
        ("HD5113","Trái tim nhân đạo", "2023-08-01","2023-12-30","Funix Group","021235565","Trái tim nhân đạo",0,now(),"1");
