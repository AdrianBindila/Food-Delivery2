create table Assignment2.hibernate_sequence
(
    next_val bigint null
)
    engine = InnoDB;

create table Assignment2.restaurants
(
    restaurant_id  bigint       not null
        primary key,
    address        varchar(255) not null,
    delivery_zones varchar(255) not null,
    name           varchar(255) not null,
    constraint UK_hs57n29k4u6jfc5t978bq7wg9
        unique (name)
)
    engine = InnoDB;

create table Assignment2.foods
(
    food_id       bigint       not null
        primary key,
    category      varchar(255) not null,
    description   varchar(255) null,
    name          varchar(255) not null,
    price         int          not null,
    restaurant_id bigint       not null,
    constraint FKri2j6b6x4h4y1gn9ydwx02txp
        foreign key (restaurant_id) references Assignment2.restaurants (restaurant_id)
)
    engine = InnoDB;

create table Assignment2.users
(
    id       bigint       not null
        primary key,
    password varchar(255) not null,
    username varchar(255) not null,
    constraint UK_r43af9ap4edm43mmtq01oddj6
        unique (username)
)
    engine = InnoDB;

create table Assignment2.admins
(
    admin_id      bigint not null
        primary key,
    restaurant_id bigint null,
    constraint FK78t703fcj0xhfk5wt6lmpjkmr
        foreign key (admin_id) references Assignment2.users (id),
    constraint FKeug6wmie1gjiqiq6giqirjgei
        foreign key (restaurant_id) references Assignment2.restaurants (restaurant_id)
)
    engine = InnoDB;

create table Assignment2.customers
(
    address      varchar(255) not null,
    email        varchar(255) not null,
    first_name   varchar(255) not null,
    last_name    varchar(255) not null,
    phone_number varchar(255) not null,
    customer_id  bigint       not null
        primary key,
    constraint UK_rfbvkrffamfql7cjmen8v976v
        unique (email),
    constraint FKcl0jfte39nemdhxc8cjkb26ds
        foreign key (customer_id) references Assignment2.users (id)
)
    engine = InnoDB;

create table Assignment2.orders
(
    order_id         bigint       not null
        primary key,
    date             date         not null,
    delivery_address varchar(255) not null,
    status           varchar(255) null,
    total_price      int          not null,
    customer_id      bigint       not null,
    restaurant_id    bigint       not null,
    constraint FK2m9qulf12xm537bku3jnrrbup
        foreign key (restaurant_id) references Assignment2.restaurants (restaurant_id),
    constraint FKpxtb8awmi0dk6smoh2vp1litg
        foreign key (customer_id) references Assignment2.customers (customer_id)
)
    engine = InnoDB;

create table Assignment2.order_food
(
    food_id  bigint not null,
    order_id bigint not null,
    constraint FK2vwp9hg6rm6ic5mo85ar5gyyl
        foreign key (food_id) references Assignment2.orders (order_id),
    constraint FK5t3u8gwem7orfedo0uwm2w019
        foreign key (order_id) references Assignment2.foods (food_id)
)
    engine = InnoDB;


