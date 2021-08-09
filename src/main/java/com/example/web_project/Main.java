package com.example.web_project;

import com.example.web_project.controller.ControllerSwitch;

import static com.example.web_project.dao.Impl.ConnectionPool.createNewDBconnection;
import static com.example.web_project.view.View.menu;

public class Main {

    public static void main(String[] args) {

        createNewDBconnection();
        ControllerSwitch controllerSwitch = new ControllerSwitch();

        while (true) {
            menu();
            controllerSwitch.switch_menu();
        }

//            List<String> elements = new ArrayList<String>();
//            Collections.addAll(elements, "a1", "a2", "b2", "b1", "c2", "c3", "d2", "d1");
//
//            elements.stream()
//                    .map(String::toUpperCase)
//                    .filter(str -> str.startsWith("C"))
//                    .sorted(Comparator.naturalOrder())
//                    .forEach(System.out::println);

//            Guest guest1 = new Guest("Nikita", 1, "1243", "mail.ru");
//            Guest guest2 = new Guest("Vadim", 2, "6846", "tut.by");
//            Guest guest3 = new Guest("Rolich", 3, "6491", "yahoo.ru");
//            Guest guest4 = new Guest("Mark", 4, "3416", "google.com");
//            Guest guest5 = new Guest("Tanya", 5, "5487", "bsuir.ua");
//            Guest guest6 = new Guest("Ilya", 6, "2212", "bing.ru");
//            Guest guest7 = new Guest("Maxim", 7, "9485", "shikimori.ru");
//            Guest guest8 = new Guest("ZeroTWO", 8, "2345", "cybermail.ru");
//            Guest guest9 = new Guest("Himiko", 9, "9483", "top1mail.ru");
//            Guest guest10 = new Guest("Tanjziro", 10, "1642", "rigixmail.ru");
//
//            Room room1 = new Room(1, "Standart", 0);
//            Room room2 = new Room(2, "Studio", 1);
//            Room room3 = new Room(3, "Suite", 1);
//            Room room4 = new Room(4, "Superior", 1);
//            Room room5 = new Room(5, "Single", 1);
//            Room room6 = new Room(6, "President", 0);
//            Room room7 = new Room(7, "Kervansaray", 0);
//            Room room8 = new Room(8, "Mountain", 0);
//            Room room9 = new Room(9, "Family ", 1);
//            Room room10 = new Room(10, "room1", 1);
//
//
//            Booking booking1 = new Booking(1, room1, guest1);
//            Booking booking2 = new Booking(123, room8, guest2);
//            Booking booking3 = new Booking(9, room5, guest3);
//            Booking booking4 = new Booking(23, room1, guest4);
//            Booking booking5 = new Booking(87, room4, guest5);
//            Booking booking6 = new Booking(11, room5, guest6);
//            Booking booking7 = new Booking(432, room3, guest7);
//            Booking booking8 = new Booking(52, room4, guest8);
//            Booking booking9 = new Booking(88, room2, guest9);
//            Booking booking10 = new Booking(89, room5, guest10);
//
//            ArrayList<Booking> bookings = new ArrayList<Booking>();
//            bookings.add(0, booking1);
//            bookings.add(1, booking2);
//            bookings.add(2, booking3);
//            bookings.add(3, booking4);
//            bookings.add(4, booking5);
//            bookings.add(5, booking6);
//            bookings.add(6, booking7);
//            bookings.add(7, booking8);
//            bookings.add(8, booking9);
//            bookings.add(9, booking10);

//        BookingDaoImpl bookingDao = new BookingDaoImpl();
//        bookingDao.getBooking(bookings);


        // Не работает
//        bookings.stream()
//                .sorted(new ComparatorBookings()) // Тут ошибка (хотя в примере норм)
//                .forEach(p->System.out.printf("%s (%s) - %d \n",
//                        ((Booking) p).getBooking_id(), ((Booking) p).getRoom(), ((Booking) p).getGuest()));
//
//
//        // Не работает
//        List list = bookings.stream()
//                .sorted(Comparator.comparing(Booking::getBooking_id))
//                .collect(Collectors.toList());
//
//
//        //Надо делать методы toString в Booking, Guest и Room
//        bookings.stream()
//                .sorted(Comparator.comparing(Booking::getBooking_id))
//                .forEach(System.out::println);
//
//
//        //Ничего по итогу не сортирует
//        List list1 = bookingDao.getBooking(bookings).stream()
//                .sorted(Comparator.comparing(Booking::getBooking_id))
//                .collect(Collectors.toList());


//        View view = new View();
//        GuestDaoImpl bookingMian = new GuestDaoImpl();
//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//            view.entranceAcc();
//            entry = scanner.nextInt();
//            switch (entry) {
//                case 1:
//                    bookingMian.createGuest();
//                    break;
//                case 2:
//                    bookingMian.searchAccount();
//                    break;
//                case 3:
//                    bookingMian.getGuest();
//                    break;
//            }
//        }
//
//    }

    }
}