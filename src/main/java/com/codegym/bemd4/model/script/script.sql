use test_data_case;

insert into address(city,district,house_number) values("hcm","quan pn","21k");
insert into address(city,district,house_number) values("hcm","quan 8","25");
insert into address(city,district,house_number) values("hcm","quan 9","120");
insert into address(city,district,house_number) values("hcm","quan 1","90");
insert into address(city,district,house_number) values("hcm","quan 10","72a");
insert into address(city,district,house_number) values("hcm","quan 111","5a");

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

insert into apartment(activited,area,location,max_tenants,monthly_rent,`name`,number_of_bed_rooms,number_of_room,room_number,building_id) values(true,200,"hcm",3,2500000,"dat",5,4,201,1);
insert into apartment(activited,area,location,max_tenants,monthly_rent,`name`,number_of_bed_rooms,number_of_room,room_number,building_id) values(true,150,"hcm",4,1500000,"thinh",2,4,202,6);
insert into apartment(activited,area,location,max_tenants,monthly_rent,`name`,number_of_bed_rooms,number_of_room,room_number,building_id) values(true,124,"hcm",7,1200000,"thang",2,4,203,4);
insert into apartment(activited,area,location,max_tenants,monthly_rent,`name`,number_of_bed_rooms,number_of_room,room_number,building_id) values(true,80,"hcm",1,2100000,"nhan",5,3,204,5);
insert into apartment(activited,area,location,max_tenants,monthly_rent,`name`,number_of_bed_rooms,number_of_room,room_number,building_id) values(true,90,"hcm",2,3400000,"kiet",5,7,205,2);
insert into apartment(activited,area,location,max_tenants,monthly_rent,`name`,number_of_bed_rooms,number_of_room,room_number,building_id) values(true,250,"hcm",9,5500000,"phuc",5,3,206,3);