package hw2.seller;

import hw2.item.Money;
import hw2.item.Ticket;
import hw2.movie.screen.Reservation;
import hw2.user.User;

public class AutomaticMarchine implements Seller {
    private TicketOffice ticketOffice;

    public AutomaticMarchine(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    @Override
    public void sellTo(Reservation reservation) {
        for (int index = 0; index < ticketOffice.getSatisfiedTicketCount(reservation); index++) {
            Ticket ticket = ticketOffice.getTicket(reservation);
            ticket.setPrice(Money.ZERO);
            if (index < reservation.getUsers().size() - 1) {
                ticketOffice.plusMoney(reservation.getUsers().get(index).buy(ticket));
            }
        }

        for (User user : reservation.getUsers()) {
            user.buy(ticketOffice.getTicket(reservation));
        }
    }
}
