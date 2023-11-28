use test_data_case;

insert into address(city,district,ward,house_number) values("hcm","quan pn","1","21k");
insert into address(city,district,ward,house_number) values("hcm","quan 8","3","25");
insert into address(city,district,ward,house_number) values("hcm","quan 9","6","120");
insert into address(city,district,ward,house_number) values("hcm","quan 1","10","90");
insert into address(city,district,ward,house_number) values("hcm","quan 10","4","72a");
insert into address(city,district,ward,house_number) values("hcm","quan 11","2","5a");

insert into landlord(activated,address,avatar,email,fullname,`password`,phone_number,username) values(true,"21k","abc1","abc1@gmail.com","kiet bui","123","09128326754","kiet");
insert into landlord(activated,address,avatar,email,fullname,`password`,phone_number,username) values(true,"22k","abc2","abc2@gmail.com","dat bui","123","09128326222","dat");
insert into landlord(activated,address,avatar,email,fullname,`password`,phone_number,username) values(true,"23k","abc3","abc3@gmail.com","phuc bui","123","09128326333","phuc");
insert into landlord(activated,address,avatar,email,fullname,`password`,phone_number,username) values(true,"24k","abc4","abc4@gmail.com","nhan bui","123","09128326444","nhan");
insert into landlord(activated,address,avatar,email,fullname,`password`,phone_number,username) values(true,"25k","abc5","abc5@gmail.com","thang bui","123","09128326555","thang");
insert into landlord(activated,address,avatar,email,fullname,`password`,phone_number,username) values(true,"26k","abc6","abc6@gmail.com","thinh bui","123","09128326666","thinh");

insert into buildings(building_name,address_id,landlord_id) values("kiet building",1,1);
insert into buildings(building_name,address_id,landlord_id) values("phuc building",2,6);
insert into buildings(building_name,address_id,landlord_id) values("thinh building",3,5);
insert into buildings(building_name,address_id,landlord_id) values("dat building",4,4);
insert into buildings(building_name,address_id,landlord_id) values("nhan building",5,3);
insert into buildings(building_name,address_id,landlord_id) values("thang building",6,2);

insert into apartment(area,max_tenants,monthly_rent,apartment_name,number_of_bedroom,number_of_room,room_number,building_id) values(200,2,1500000,"dat",3,2,6,1);
insert into apartment(area,max_tenants,monthly_rent,apartment_name,number_of_bedroom,number_of_room,room_number,building_id) values(100,3,1100000,"thang",2,2,2,6);
insert into apartment(area,max_tenants,monthly_rent,apartment_name,number_of_bedroom,number_of_room,room_number,building_id) values(150,1,1300000,"thinh",1,3,1,5);
insert into apartment(area,max_tenants,monthly_rent,apartment_name,number_of_bedroom,number_of_room,room_number,building_id) values(140,2,1800000,"nhan",1,1,3,4);
insert into apartment(area,max_tenants,monthly_rent,apartment_name,number_of_bedroom,number_of_room,room_number,building_id) values(75,4,2100000,"phuc",3,4,2,2);
insert into apartment(area,max_tenants,monthly_rent,apartment_name,number_of_bedroom,number_of_room,room_number,building_id) values(90,3,2500000,"kiet",3,4,3,3);

insert into users(avatar,email,fullname,`password`,phone_number,username) values("abc","dat@gmail.com","dat nguyen","123",09783247611,"dat");
insert into users(avatar,email,fullname,`password`,phone_number,username) values("abc","phuc@gmail.com","phuc truong","123",09783247612,"phuc");
insert into users(avatar,email,fullname,`password`,phone_number,username) values("abc","kiet@gmail.com","kiet bui","123",09783247613,"kiet");
insert into users(avatar,email,fullname,`password`,phone_number,username) values("abc","thinh@gmail.com","thinh phan","123",09783247614,"thinh");
insert into users(avatar,email,fullname,`password`,phone_number,username) values("abc","thang@gmail.com","thang le","123",09783247615,"thang");
insert into users(avatar,email,fullname,`password`,phone_number,username) values("abc","nhan@gmail.com","nhan tran","123",09783247616,"nhan");

insert into roles(description,name) values ("","ROLE_ADMIN");
insert into roles(description,name) values ("","ROLE_USER");
insert into roles(description,name) values ("","ROLE_LANDLORD");
